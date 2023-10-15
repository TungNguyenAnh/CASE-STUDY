package controller;

import com.example.casestudy.ConnectJDBC;
import com.example.casestudy.Student;
import com.example.casestudy.StudentService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    private final StudentService studentService = new ConnectJDBC() {
    };

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy Parameters (Dữ liệu request gửi đi) có name là "action".
        String action = request.getParameter("action");

        // Nếu dữ liệu request gửi đi không có "action" thì sẽ trả về null.
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
            default:
                break;
        }
    }

    // Phương thức xóa customer dựa theo id.
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Student customer = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        } else {
            this.studentService.delete(id);
            try {
                response.sendRedirect("customers");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // Phương thức sửa customer.
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        Student student = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (student == null) {
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        } else {
            student.setName(name);
            student.setAge(student.getAge());
            student.setAddress(address);
            this.studentService.update(id, student);
            request.setAttribute("customer", student);
            request.setAttribute("message", "Customer information was updated");
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Phương thức thêm customer.
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String address = request.getParameter("address");
        String id = request.getParameter("id");

        Student customer = new Student(id, name, age, address);
        this.studentService.save(customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        request.setAttribute("message", "New customer was created");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {

            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    showDeleteForm(request, response);
                    break;
                case "view":
                    viewCustomer(request, response);
                    break;
                default:
                    listCustomers(request, response);
                    break;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new ServletException();
        }

    }


    // Phương thức trả về trang view.jsp hiển thị thông tin của customer.
    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Student customer = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức trả về trang delete.jsp để hiển thị customer để xóa.
    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Student customer = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Phương thức trả về trang edit.jsp để hiển thị customer để sửa.
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        Student customer = this.studentService.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("customer/error-404.jsp");
        } else {
            request.setAttribute("customer", customer);
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Phương thức trả về trang create.jsp để tạo customer.
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // Phương thức trả về list.jsp để hiển thị toàn bộ customer.
    private void listCustomers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        List<Student> customers = this.studentService.findAll();
        request.setAttribute("customers", customers);
        request.getRequestDispatcher("customer/list.jsp").forward(request, response);
    }
}
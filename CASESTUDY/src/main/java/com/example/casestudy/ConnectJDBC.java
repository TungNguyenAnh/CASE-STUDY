package com.example.casestudy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectJDBC implements StudentService {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/studentlist";
    private static final String DB_Name = "root";
    private static final String DB_Password = "123123";

    public Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DB_URL, DB_Name, DB_Password);
        return connection;
    }

    @Override
    public List<Student> findAll() throws SQLException, ClassNotFoundException {
        List<Student> students = new ArrayList<>();
        Connection connection = connection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            int age = Integer.parseInt(resultSet.getString("age"));
            String address = resultSet.getString("address");
        }
        return students;
    }

    @Override
    public void save(Student student) {
        String sql = "INSERT INTO student (name, age, address) VALUES (?,?,?)";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_Name, DB_Password)) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, student.getName());
                preparedStatement.setInt(2, student.getAge());
                preparedStatement.setString(3, student.getAddress());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public void update(String id, Student student) {

    }

    @Override
    public void delete(String id) {

    }
}
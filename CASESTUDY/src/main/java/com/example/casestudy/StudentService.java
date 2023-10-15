package com.example.casestudy;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<Student> findAll() throws SQLException, ClassNotFoundException;

    void save(Student student);

    Student findById(String id);

    void update(String id, Student student);

    void delete(String id);
}

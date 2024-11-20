package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 12906
 */
public class StudentDAO {
    // 查询所有学员
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM student";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setPhone(rs.getString("phone"));
                student.setRegistrationDate(rs.getString("registration_date"));
                student.setStatus(rs.getString("status"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // 添加学员
    public void addStudent(Student student) {
        String sql = "INSERT INTO student (name, phone, registration_date, status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getPhone());
            pstmt.setString(3, student.getRegistrationDate());
            pstmt.setString(4, student.getStatus());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.StudentDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;


/**
 *
 * @author 12906
 */
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 查询所有学员
        List<Student> students = studentDAO.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/studentList.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 添加新学员
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String registrationDate = request.getParameter("registrationDate");
        String status = "报名中";

        Student student = new Student();
        student.setName(name);
        student.setPhone(phone);
        student.setRegistrationDate(registrationDate);
        student.setStatus(status);

        studentDAO.addStudent(student);
        response.sendRedirect("students");
    }
}

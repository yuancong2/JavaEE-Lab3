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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Student;


/**
 *
 * @author 12906
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {
    private StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求和响应的编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        List<Student> students = studentDAO.getAllStudents(); // 查询数据库
        request.setAttribute("students", students);          // 设置到 request 中
        request.getRequestDispatcher("/studentList.jsp").forward(request, response); // 转发到 JSP
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置请求和响应的编码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
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
        response.sendRedirect("StudentServlet");
    }
}

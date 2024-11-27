/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.VehicleDAO;
<<<<<<< Updated upstream
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;
=======
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vehicle;
>>>>>>> Stashed changes

/**
 *
 * @author SP
 */
<<<<<<< Updated upstream
=======


import dao.VehicleDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vehicle;

>>>>>>> Stashed changes
@WebServlet(name = "VehicleServlet", urlPatterns = {"/VehicleServlet"})
public class VehicleServlet extends HttpServlet {
    private VehicleDAO vehicleDAO = new VehicleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< Updated upstream
        String action = request.getParameter("action");

        if (action == null) {
            // 默认显示所有车辆
            List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
            request.setAttribute("vehicles", vehicles);
            request.getRequestDispatcher("/vehicleList.jsp").forward(request, response);
        } else if (action.equals("delete")) {
            // 删除车辆
            int id = Integer.parseInt(request.getParameter("id"));
            vehicleDAO.deleteVehicle(id);
            response.sendRedirect("vehicles");
        }
=======
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 查询所有车辆并设置到请求属性中
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
        request.setAttribute("vehicles", vehicles);

        // 转发到车辆列表页面
        request.getRequestDispatcher("/vehicleList.jsp").forward(request, response);
>>>>>>> Stashed changes
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< Updated upstream
        String action = request.getParameter("action");

        if (action.equals("add")) {
            // 添加车辆
            Vehicle vehicle = new Vehicle();
            vehicle.setLicensePlate(request.getParameter("licensePlate"));
            vehicle.setModel(request.getParameter("model"));
            vehicle.setStatus(request.getParameter("status"));
            vehicle.setRemark(request.getParameter("remark"));
            vehicleDAO.addVehicle(vehicle);
        } else if (action.equals("update")) {
            // 更新车辆信息
            Vehicle vehicle = new Vehicle();
            vehicle.setId(Integer.parseInt(request.getParameter("id")));
            vehicle.setLicensePlate(request.getParameter("licensePlate"));
            vehicle.setModel(request.getParameter("model"));
            vehicle.setStatus(request.getParameter("status"));
            vehicle.setRemark(request.getParameter("remark"));
            vehicleDAO.updateVehicle(vehicle);
        }
        response.sendRedirect("vehicles");
    }
}
=======
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("action");

        if ("updateStatus".equals(action)) {
            // 更新车辆状态
            int id = Integer.parseInt(request.getParameter("id"));
            String status = request.getParameter("status");
            vehicleDAO.updateVehicleStatus(id, status);
            response.sendRedirect("VehicleServlet");
        }
    }
}
>>>>>>> Stashed changes

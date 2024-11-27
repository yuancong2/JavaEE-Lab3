/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.VehicleDAO;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author SP
 */
@WebServlet(name = "VehicleServlet", urlPatterns = {"/VehicleServlet"})
public class VehicleServlet extends HttpServlet {
    private VehicleDAO vehicleDAO = new VehicleDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
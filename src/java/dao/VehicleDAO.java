/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import model.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author SP
 */
public class VehicleDAO {

    // 查询所有车辆
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicle";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setLicensePlate(rs.getString("license_plate"));
                vehicle.setModel(rs.getString("model"));
                vehicle.setStatus(rs.getString("status"));
                vehicle.setRemark(rs.getString("remark"));
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // 添加车辆
    public void addVehicle(Vehicle vehicle) {
    String sql = "INSERT INTO vehicle (license_plate, model, status, remark) VALUES (?, ?, ?, ?)";
    try (Connection conn = DBUtil.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, vehicle.getLicensePlate());
        pstmt.setString(2, vehicle.getModel());
        pstmt.setString(3, vehicle.getStatus() == null ? "可用" : vehicle.getStatus()); // 默认值
        pstmt.setString(4, vehicle.getRemark());
        pstmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    // 更新车辆信息
    public void updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE vehicle SET license_plate = ?, model = ?, status = ?, remark = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, vehicle.getLicensePlate());
            pstmt.setString(2, vehicle.getModel());
            pstmt.setString(3, vehicle.getStatus());
            pstmt.setString(4, vehicle.getRemark());
            pstmt.setInt(5, vehicle.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 删除车辆
    public void deleteVehicle(int vehicleId) {
        String sql = "DELETE FROM vehicle WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, vehicleId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

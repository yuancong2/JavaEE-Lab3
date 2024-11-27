/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
<<<<<<< Updated upstream
import model.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
=======

>>>>>>> Stashed changes
/**
 *
 * @author SP
 */
<<<<<<< Updated upstream
public class VehicleDAO {

    // 查询所有车辆
=======


import model.Vehicle;
import model.RepairRecord;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {

    // 获取所有车辆信息1
>>>>>>> Stashed changes
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicle";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
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
=======
    // 更新车辆状态
    public void updateVehicleStatus(int id, String status) {
        String sql = "UPDATE vehicle SET status = ? WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, status);
            pstmt.setInt(2, id);
>>>>>>> Stashed changes
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

<<<<<<< Updated upstream
    // 删除车辆
    public void deleteVehicle(int vehicleId) {
        String sql = "DELETE FROM vehicle WHERE id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, vehicleId);
            pstmt.executeUpdate();
=======
    // 获取某辆车的维修记录
    public List<RepairRecord> getRepairHistory(int vehicleId) {
        List<RepairRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM car_fixhistroy WHERE vehicle_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vehicleId);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    RepairRecord record = new RepairRecord();
                    record.setId(rs.getInt("id"));
                    record.setCost(rs.getDouble("cost"));
                    record.setProblem(rs.getString("problem"));
                    record.setFixTime(rs.getTimestamp("fix_time").toLocalDateTime());
                    record.setVehicleId(rs.getInt("vehicle_id"));
                    records.add(record);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    // 添加维修记录
    public void addRepairRecord(RepairRecord record) {
        String sql = "INSERT INTO car_fixhistroy (cost, problem, fix_time, vehicle_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, record.getCost());
            pstmt.setString(2, record.getProblem());
            pstmt.setTimestamp(3, Timestamp.valueOf(record.getFixTime()));
            pstmt.setInt(4, record.getVehicleId());
            pstmt.executeUpdate();
            System.out.println("114514191981");
>>>>>>> Stashed changes
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
<<<<<<< Updated upstream
}
=======
}
>>>>>>> Stashed changes

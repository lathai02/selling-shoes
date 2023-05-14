/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Brand;
import Model.CountTimeAccess;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lathai
 */
public class ViewDao extends DBContext {

    Connection cnn; // dùng để kết nối DB
    Statement stm; // thực thi câu lệnh SQL
    PreparedStatement pstm;
    ResultSet rs; // Lưu trữ và xử lý dữ liệu

    public void connect() {
        try {
            cnn = super.connection;
            if (cnn != null) {
                System.out.println("Connect success!");
            }
        } catch (Exception E) {
            System.out.println("Connect fail: " + E.getMessage());
        }
    }
    
    public String getViewByShoesId(String shoesId) {
        try {
            String strSelect = "select * from countTimeAccess where shoesId = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, shoesId);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String count = rs.getString(2);
                return count;
            }
        } catch (Exception e) {
            System.out.println("getViewByShoesId: " + e.getMessage());
        }
        return "-1";
    }
    
    public boolean addView(CountTimeAccess c) {
        try {
            String strAddView = "INSERT INTO countTimeAccess(shoesId, count) "
                    + "VALUES (?, ?) ";

            connect();
            pstm = cnn.prepareStatement(strAddView);
            // theo kieu du lieu trong data base
            pstm.setString(1, c.getShoesId());
            pstm.setString(2, c.getCount());
           
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addView: " + e.getMessage());
        }
        return false;
    }
    
    public boolean updateCountTime(CountTimeAccess c) {
        try {
            String strUpdateCountTime = "UPDATE countTimeAccess SET count = ? "
                    + "WHERE shoesId = ? ";

            connect();
            pstm = cnn.prepareStatement(strUpdateCountTime);
            // theo kieu du lieu trong data base
            pstm.setString(1, c.getCount());
            pstm.setString(2, c.getShoesId());
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateCountTime: " + e.getMessage());
        }
        return false;
    }
}

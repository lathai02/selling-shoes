/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lathai
 */
public class LoginDao extends DBContext {
    // tạo các thành phần xử ksy data base

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

    public boolean loginAdmin(User u) {
        try {
            String strLoginAdmin = "SELECT * FROM [User] "
                    + "WHERE userAccount = ? AND userPassword = ? AND isAdmin = ?";

            connect();
            pstm = cnn.prepareStatement(strLoginAdmin);
            // theo kieu du lieu trong data base
            pstm.setString(1, u.getAccount());
            pstm.setString(2, u.getPassword());
            pstm.setString(3, "1" + "");

            rs = pstm.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("loginAdmin: " + e.getMessage());
        }
        return false;
    }

    public boolean loginCustomer(User u) {
        try {
            String strLoginCustomer = "SELECT * FROM [User] "
                    + "WHERE userAccount = ? AND userPassword = ? ";

            connect();
            pstm = cnn.prepareStatement(strLoginCustomer);
            // theo kieu du lieu trong data base
            pstm.setString(1, u.getAccount());
            pstm.setString(2, u.getPassword());

            rs = pstm.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("loginCustomer: " + e.getMessage());
        }
        return false;
    }

    public User getuserInfoByAccount(String account) {
        try {
            String strLoginCustomer = "SELECT * FROM [User] "
                    + "WHERE userAccount = ? ";

            connect();
            pstm = cnn.prepareStatement(strLoginCustomer);
            // theo kieu du lieu trong data base
            pstm.setString(1, account);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String id = String.valueOf(rs.getInt(1));
                String userName = rs.getString(2);
                String userGender = rs.getString(3);
                String userDob = rs.getString(4);
                String userEmail = rs.getString(5);
                String userphoneNumber = rs.getString(6);
                String userAddress = rs.getString(7);
                String userAccount = rs.getString(8);
                String userPassword = rs.getString(9);
                String isAdmin = rs.getString(10);
                User u = new User(id, userDob, userGender, userName, userEmail, userphoneNumber, userAddress, userPassword, account, isAdmin);
                return u;
            }
        } catch (Exception e) {
            System.out.println("getnameByAccount: " + e.getMessage());
        }
        return null;
    }
}

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
public class SignUpDao extends DBContext {

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

    public boolean signUpAdmin(User u) {
        try {
            String strSignUpAdmin = "INSERT INTO [User](userName, userGender, userDob, userEmail, userPhoneNumber, userAddress, userAccount, userPassword, isAdmin) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            connect();
            pstm = cnn.prepareStatement(strSignUpAdmin);
            // theo kieu du lieu trong data base
            pstm.setString(1, u.getName());
            pstm.setBoolean(2, u.getGender().equals("female") ? false : true);
            pstm.setString(3, u.getDob());
            pstm.setString(4, u.getEmail());
            pstm.setString(5, u.getPhoneNumber());
            pstm.setString(6, u.getAddress());
            pstm.setString(7, u.getAccount());
            pstm.setString(8, u.getPassword());
            pstm.setString(9, u.getIsAdmin());
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("signUpAdmin: " + e.getMessage());
        }
        return false;
    }

    public boolean checkExistAccount(User u) {
        try {
            String strLoginCustomer = "SELECT * FROM [User] "
                    + "WHERE userAccount = ? OR userEmail = ? OR userPhoneNumber = ? ";

            connect();
            pstm = cnn.prepareStatement(strLoginCustomer);
            // theo kieu du lieu trong data base
            pstm.setString(1, u.getAccount());
            pstm.setString(2, u.getEmail());
            pstm.setString(3, u.getPhoneNumber());

            rs = pstm.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("checkExistAccount: " + e.getMessage());
        }
        return false;
    }

    public boolean signUpCustomer(User u) {
        try {
            String strSignUpAdmin = "INSERT INTO [User](userName, userGender, userDob, userEmail, userPhoneNumber, userAddress, userAccount, userPassword, isAdmin) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            connect();
            pstm = cnn.prepareStatement(strSignUpAdmin);
            // theo kieu du lieu trong data base
            pstm.setString(1, u.getName());
            pstm.setBoolean(2, u.getGender().equals("female") ? false : true);
            pstm.setString(3, u.getDob());
            pstm.setString(4, u.getEmail());
            pstm.setString(5, u.getPhoneNumber());
            pstm.setString(6, u.getAddress());
            pstm.setString(7, u.getAccount());
            pstm.setString(8, u.getPassword());
            pstm.setString(9, u.getIsAdmin());
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("signUpCustomer: " + e.getMessage());
        }
        return false;
    }
}

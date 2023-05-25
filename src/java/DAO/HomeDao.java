/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Brand;
import Model.Shop;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lathai
 */
public class HomeDao extends DBContext {

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

    public Shop getShopInfo() {
        try {
            String strSelect = "select * from Shop";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String name = rs.getString(1);
                String phone = rs.getString(2);
                String email = rs.getString(3);
                String address = rs.getString(4);
                String image = rs.getString(5);
                String decription = rs.getString(6);
                Shop sh = new Shop(image, decription, name, phone, email, address);
                return sh;
            }
        } catch (Exception e) {
            System.out.println("getShopInfo: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Brand> getAllBrand() {
        ArrayList<Brand> listBrand = new ArrayList<>();
        try {
            String strSelect = "select * from Brand";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String detail = rs.getString(2);
                String name = rs.getString(3);
                String img = rs.getString(4);
                Brand b = new Brand(id, img, name, detail);
                listBrand.add(b);
            }
        } catch (Exception e) {
            System.out.println("getAllBrand: " + e.getMessage());
        }
        return listBrand;
    }
}

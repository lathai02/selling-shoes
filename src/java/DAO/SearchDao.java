/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Shoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lathai
 */
public class SearchDao extends DBContext {

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

    public ArrayList<Shoes> searchShoesByKeyWord(String content) {
        ArrayList<Shoes> listShoes = new ArrayList<>();
        try {
            String strSelect = "select * from Shoes where shoesCode like ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + content + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String shoesId = rs.getString(1);
                String shoesCode = rs.getString(2);
                String shoesOrigin = rs.getString(3);
                String shoesDetail = rs.getString(4);
                String shoesName = rs.getString(5);
                String shoesColor = rs.getString(6);
                String shoesPrice = rs.getString(7);
                String shoesDecription = rs.getString(8);
                String shoesImage = rs.getString(9);
                String shoesSize = rs.getString(10);
                String shoesStockQuantity = rs.getString(11);
                String shoesGender = rs.getString(12);
                String shoesDiscount = rs.getString(13);
                String brandId = rs.getString(14);
                String userId = rs.getString(15);
                Shoes sh = new Shoes(shoesId, shoesCode, shoesOrigin, shoesDetail, shoesName, shoesColor, brandId, shoesPrice, shoesDecription, shoesImage, shoesSize, shoesStockQuantity, shoesGender, shoesDiscount, userId);
                listShoes.add(sh);
            }
        } catch (Exception e) {
            System.out.println("searchShoesByKeyWord: " + e.getMessage());
        }
        return listShoes;
    }

    public ArrayList<String> getListShoesCodeWithoutSizeAndByContent(String content) {
        ArrayList<String> listShoesCodeWithoutSizeAndByContent = new ArrayList<>();
        try {
            String strSelect = "SELECT DISTINCT LEFT(shoesCode, LEN(shoesCode) - CHARINDEX('_', REVERSE(shoesCode))) AS code_without_size FROM Shoes WHERE shoesCode LIKE ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%" + content + "%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                listShoesCodeWithoutSizeAndByContent.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("getListShoesCodeWithoutSizeAndByContent: " + e.getMessage());
        }
        return listShoesCodeWithoutSizeAndByContent;
    }

    public ArrayList<Shoes> getListShoesNoDuplicate(String content) {
        ArrayList<String> listShoesCodeWithoutSizeAndByContent = new ArrayList<>();
        ArrayList<Shoes> listShoes = new ArrayList<>();
        ArrayList<Shoes> retListShoes = new ArrayList<>();

        listShoesCodeWithoutSizeAndByContent = getListShoesCodeWithoutSizeAndByContent(content);
        listShoes = searchShoesByKeyWord(content);

        for (int i = 0; i < listShoesCodeWithoutSizeAndByContent.size(); i++) {
            boolean checkAddOneTime = false;
            for (int j = 0; j < listShoes.size(); j++) {
                if (listShoes.get(j).getCode().contains(listShoesCodeWithoutSizeAndByContent.get(i)) && !checkAddOneTime) {
                    retListShoes.add(listShoes.get(j));
                    checkAddOneTime = true;
                }
            }
        }
        System.out.println(retListShoes.size());
        return retListShoes;
    }

    public ArrayList<Shoes> getListByPage(int begin, int end, ArrayList<Shoes> listShoes) {

        ArrayList<Shoes> retList = new ArrayList<>();
        for (int i = begin; i < end; i++) {
            retList.add(listShoes.get(i));
        }
        return retList;
    }
}

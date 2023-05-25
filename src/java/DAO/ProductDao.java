/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Brand;
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
public class ProductDao extends DBContext {

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

    public ArrayList<Shoes> getListByPage(int begin, int end, ArrayList<Shoes> listShoes) {

        ArrayList<Shoes> retList = new ArrayList<>();
        for (int i = begin; i < end; i++) {
            retList.add(listShoes.get(i));
        }
        return retList;
    }

    public String getIdByBrandName(String name) {
        try {
            String strBrand = "SELECT * FROM Brand WHERE brandName = ?";

            connect();
            pstm = cnn.prepareStatement(strBrand);
            pstm.setString(1, name);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String brandId = rs.getString(1);
                return brandId;
            }
        } catch (Exception e) {
            System.out.println("getIdByBrandName: " + e.getMessage());
        }
        return "";
    }
//-------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<Shoes> getListShoesSameShoesCodeWithoutSize(String shoesCodeWithoutSize) {
        ArrayList<Shoes> listShoes = new ArrayList<>();
        try {
            String strSelect = "select * from Shoes where shoesCode like ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, shoesCodeWithoutSize + "%");
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
            System.out.println("getListShoesSameShoesCodeWithoutSize: " + e.getMessage());
        }
        System.out.println(listShoes.size());
        return listShoes;
    }
//    ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<Shoes> getListShoesBySize(String size) {
        ArrayList<Shoes> listShoesBysize = new ArrayList<>();
        try {
            String strSelect = "select * from Shoes where shoesSize = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, size);
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
                listShoesBysize.add(sh);
            }
        } catch (Exception e) {
            System.out.println("getListShoesBySize: " + e.getMessage());
        }
        return listShoesBysize;
    }
//    ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<String> getListShoesCodeWithoutSize() {
        ArrayList<String> listShoesCodeWithoutSize = new ArrayList<>();
        try {
            String strSelect = "SELECT DISTINCT LEFT(shoesCode, LEN(shoesCode) - CHARINDEX('_', REVERSE(shoesCode))) AS code_without_size FROM Shoes";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                listShoesCodeWithoutSize.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("getListShoesCodeWithoutSize: " + e.getMessage());
        }
        return listShoesCodeWithoutSize;
    }

    public ArrayList<Shoes> getListShoes() {
        ArrayList<Shoes> listShoes = new ArrayList<>();
        try {
            String strSelect = "select * from Shoes";

            connect();
            pstm = cnn.prepareStatement(strSelect);
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
            System.out.println("getListShoes: " + e.getMessage());
        }
        return listShoes;
    }

    public ArrayList<Shoes> getListShoesNoDuplicate() {
        ArrayList<String> listShoesCodeWithoutSize = new ArrayList<>();
        ArrayList<Shoes> listShoes = new ArrayList<>();
        ArrayList<Shoes> retListShoes = new ArrayList<>();

        listShoesCodeWithoutSize = getListShoesCodeWithoutSize();
        listShoes = getListShoes();

        for (int i = 0; i < listShoesCodeWithoutSize.size(); i++) {
            boolean checkAddOneTime = false;
            for (int j = 0; j < listShoes.size(); j++) {
                if (listShoes.get(j).getCode().contains(listShoesCodeWithoutSize.get(i)) && !checkAddOneTime) {
                    retListShoes.add(listShoes.get(j));
                    checkAddOneTime = true;
                }
            }
        }
        System.out.println(retListShoes.size());
        return retListShoes;
    }

//    ------------------------------------------------------------------------------------------------------
    public ArrayList<Shoes> getListShoesByBrand(String id) {
        ArrayList<Shoes> listShoes = new ArrayList<>();
        try {
            String strSelect = "select * from Shoes where brandId = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(id));
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
            System.out.println("getListShoesByBrand: " + e.getMessage());
        }
        return listShoes;
    }

    public ArrayList<String> getListShoesCodeWithoutSizeAndByBrandId(String id) {
        ArrayList<String> listShoesCodeWithoutSizeAndByBrandId = new ArrayList<>();
        try {
            String strSelect = "SELECT DISTINCT LEFT(shoesCode, LEN(shoesCode) - CHARINDEX('_', REVERSE(shoesCode))) AS code_without_size FROM Shoes WHERE brandId = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(id));
            rs = pstm.executeQuery();
            while (rs.next()) {
                listShoesCodeWithoutSizeAndByBrandId.add(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("getListShoesCodeWithoutSizeAndByBrandId: " + e.getMessage());
        }
        return listShoesCodeWithoutSizeAndByBrandId;
    }

    public ArrayList<Shoes> getListShoesNoDuplicate(String id) {
        ArrayList<String> listShoesCodeWithoutSizeAndByBrandId = new ArrayList<>();
        ArrayList<Shoes> listShoes = new ArrayList<>();
        ArrayList<Shoes> retListShoes = new ArrayList<>();

        listShoesCodeWithoutSizeAndByBrandId = getListShoesCodeWithoutSizeAndByBrandId(id);
        listShoes = getListShoesByBrand(id);

        for (int i = 0; i < listShoesCodeWithoutSizeAndByBrandId.size(); i++) {
            boolean checkAddOneTime = false;
            for (int j = 0; j < listShoes.size(); j++) {
                if (listShoes.get(j).getCode().contains(listShoesCodeWithoutSizeAndByBrandId.get(i)) && !checkAddOneTime) {
                    retListShoes.add(listShoes.get(j));
                    checkAddOneTime = true;
                }
            }
        }
        System.out.println(retListShoes.size());
        return retListShoes;
    }

//   --------------------------------------------------------------------------------
    public ArrayList<Shoes> getListShoesByPrice(String valueTo, String valueEnd) {
        ArrayList<Shoes> listShoes = new ArrayList<>();
        try {
            String strSelect = "select * from Shoes where shoesPrice <= ? and shoesPrice >= ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, valueEnd);
            pstm.setString(2, valueTo);
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
            System.out.println("getListShoesByPrice: " + e.getMessage());
        }
        return listShoes;
    }

}

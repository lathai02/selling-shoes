/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package DAO;

import Model.Brand;
import Model.ImportHistory;
import Model.Shoes;
import Model.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lathai
 */
public class AdminDao extends DBContext {

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

    public ArrayList<User> getListUser() {
        ArrayList<User> listUser = new ArrayList<>();
        try {
            String strSelect = "select * from [User] where isAdmin = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "0");
            rs = pstm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String gender = rs.getString(3);
                String dob = rs.getString(4);
                String email = rs.getString(5);
                String phoneNumber = rs.getString(6);
                String address = rs.getString(7);
                String account = rs.getString(8);
                String password = rs.getString(9);
                String isAdmin = rs.getString(10);
                User u = new User(id, dob, gender, name, email, phoneNumber, address, password, account, isAdmin);
                listUser.add(u);
            }
        } catch (Exception e) {
            System.out.println("getListUser: " + e.getMessage());
        }
        return listUser;
    }

    public boolean deleteUserById(String id) {
        try {
            String strDeleteUser = "DELETE FROM [User] WHERE userId = ?";

            connect();
            pstm = cnn.prepareStatement(strDeleteUser);
            pstm.setString(1, id);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteUserById: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteShoesByShoesCode(String shoesCode) {
        try {
            String strDeleteUser = "DELETE FROM Shoes WHERE shoesCode = ?";

            connect();
            pstm = cnn.prepareStatement(strDeleteUser);
            pstm.setString(1, shoesCode);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteShoesByShoesCode: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteBrandById(String brandId) {
        try {
            String strDeleteBrand = "DELETE FROM Brand WHERE brandId = ?";

            connect();
            pstm = cnn.prepareStatement(strDeleteBrand);
            pstm.setString(1, brandId);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteBrandById: " + e.getMessage());
        }
        return false;
    }

    public Brand getBrandBybrandId(String brandId) {
        try {
            String strBrand = "SELECT * FROM Brand WHERE brandId = ?";

            connect();
            pstm = cnn.prepareStatement(strBrand);
            pstm.setString(1, brandId);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String id = rs.getString(1);
                String detail = rs.getString(2);
                String name = rs.getString(3);
                String image = rs.getString(4);
                Brand b = new Brand(id, image, name, detail);
                return b;
            }

        } catch (Exception e) {
            System.out.println("getBrandBybrandId: " + e.getMessage());
        }
        return null;
    }

    public String checkSameBrandName(String brandName) {
        try {
            String strBrand = "SELECT * FROM Brand WHERE brandName = ?";

            connect();
            pstm = cnn.prepareStatement(strBrand);
            pstm.setString(1, brandName);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("checkSameBrandName: " + e.getMessage());
        }
        return "";
    }

    public boolean checkSameBrandNameForAdd(String brandName) {
        try {
            String strBrand = "SELECT * FROM Brand WHERE brandName = ?";

            connect();
            pstm = cnn.prepareStatement(strBrand);
            pstm.setString(1, brandName);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkSameBrandName: " + e.getMessage());
        }
        return false;
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

    public Shoes getShoesByShoesCode(String shoesCodeSearch) {
        try {
            String strSelect = "select * from Shoes where shoesCode = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, shoesCodeSearch);
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
                return sh;
            }
        } catch (Exception e) {
            System.out.println("getListShoes: " + e.getMessage());
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

    public boolean updateShoes(Shoes sh) {
        try {
            String strUpdateShoes = "UPDATE Shoes SET shoesCode = ?, "
                    + "shoesOrigin = ?, "
                    + "shoesDetail = ?, "
                    + "shoesName = ?, "
                    + "shoesColor = ?, "
                    + "shoesPrice =  ?, "
                    + "shoesDecription = ?, "
                    + "shoesImage = ?, "
                    + "shoesSize = ?, "
                    + "shoesStockQuantity = ?, "
                    + "shoesGender = ?, "
                    + "shoesDiscount = ?, "
                    + "brandId = ?, "
                    + "userId = ? "
                    + "WHERE shoesId = ? ";

            connect();
            pstm = cnn.prepareStatement(strUpdateShoes);
            // theo kieu du lieu trong data base
            pstm.setString(1, sh.getCode());
            pstm.setString(2, sh.getOrigin());
            pstm.setString(3, sh.getDetail());
            pstm.setString(4, sh.getName());
            pstm.setString(5, sh.getColor());
            pstm.setString(6, sh.getPrice());
            pstm.setString(7, sh.getDecription());
            pstm.setString(8, sh.getImg());
            pstm.setString(9, sh.getSize());
            pstm.setString(10, sh.getStockQuantity());
            pstm.setString(11, sh.getGender());
            pstm.setString(12, sh.getDiscount());
            pstm.setString(13, sh.getBrandId());
            pstm.setString(14, sh.getUserId());
            pstm.setString(15, sh.getId());
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateShoes: " + e.getMessage());
        }
        return false;
    }

    public boolean addShoes(Shoes shoes) {
        try {
            String strAddShoes = "INSERT INTO Shoes(shoesCode, shoesOrigin, shoesDetail, shoesName, shoesColor, shoesPrice, shoesDecription, shoesImage, shoesSize, shoesStockQuantity, shoesGender, shoesDiscount, brandId, userId) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";

            connect();
            pstm = cnn.prepareStatement(strAddShoes);
            // theo kieu du lieu trong data base
            pstm.setString(1, shoes.getCode());
            pstm.setString(2, shoes.getOrigin());
            pstm.setString(3, shoes.getDetail());
            pstm.setString(4, shoes.getName());
            pstm.setString(5, shoes.getColor());
            pstm.setString(6, shoes.getPrice());
            pstm.setString(7, shoes.getDecription());
            pstm.setString(8, shoes.getImg());
            pstm.setString(9, shoes.getSize());
            pstm.setString(10, "0");
            pstm.setString(11, shoes.getGender());
            pstm.setString(12, shoes.getDiscount());
            pstm.setString(13, shoes.getBrandId());
            pstm.setString(14, "1");
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addShoes: " + e.getMessage());
        }
        return false;
    }

    public String checkSameProductCode(String shoesCode) {
        try {
            String strSelect = "select * from Shoes where shoesCode = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, shoesCode);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println("checkSameProductCode: " + e.getMessage());
        }
        return "";
    }

    public boolean checkSameProductCodeForAdd(String shoesCode) {
        try {
            String strSelect = "select * from Shoes where shoesCode = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, shoesCode);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkSameProductCode: " + e.getMessage());
        }
        return false;
    }

    public String getBrandNameById(String brandId) {
        try {
            String strSelect = "select brandName from Brand where brandId = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, brandId);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String brandName = rs.getString(1);
                return brandName;
            }
        } catch (Exception e) {
            System.out.println("getBrandNameById: " + e.getMessage());
        }
        return "";
    }

    public boolean updateBrand(Brand b) {
        try {
            String strUpdateShoes = "UPDATE Brand SET brandDetail = ?, "
                    + "brandName = ?, "
                    + "image = ? "
                    + "WHERE brandId = ? ";

            connect();
            pstm = cnn.prepareStatement(strUpdateShoes);
            // theo kieu du lieu trong data base
            pstm.setString(1, b.getDetail());
            pstm.setString(2, b.getName());
            pstm.setString(3, b.getImg());
            pstm.setString(4, b.getId());
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateBrand: " + e.getMessage());
        }
        return false;
    }

    public boolean addBrand(Brand b) {
        try {
            String strAddBrand = "INSERT INTO Brand(brandDetail, brandName, image) "
                    + "VALUES (?, ?, ?) ";

            connect();
            pstm = cnn.prepareStatement(strAddBrand);
            // theo kieu du lieu trong data base
            pstm.setString(1, b.getDetail());
            pstm.setString(2, b.getName());
            pstm.setString(3, b.getImg());
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addBrand: " + e.getMessage());
        }
        return false;
    }

    public boolean addImportHistory(ImportHistory ih) {
        try {
            String strAddBrand = "INSERT INTO ImportHistory(shoesId, dateAdd, timeAdd, quantity) "
                    + "VALUES (?, ?, ?, ?) ";

            connect();
            pstm = cnn.prepareStatement(strAddBrand);
            // theo kieu du lieu trong data base
            pstm.setString(1, ih.getShoesId());
            pstm.setString(2, ih.getDateAdd());
            pstm.setString(3, ih.getTimeAdd());
            pstm.setString(4, ih.getQuantity());
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("addImportHistory: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<ImportHistory> getImportHistory() {
        ArrayList<ImportHistory> listImportHistory = new ArrayList<>();
        try {
            String strSelect = "select * from ImportHistory";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String importHistoryId = rs.getString(1);
                String shoesId = rs.getString(2);
                String dateAdd = rs.getString(3);
                String timeAdd = rs.getString(4);
                String quantity = rs.getString(5);
                ImportHistory ih = new ImportHistory(shoesId, quantity, dateAdd, importHistoryId, timeAdd);
                listImportHistory.add(ih);
            }
        } catch (Exception e) {
            System.out.println("getBrandNameById: " + e.getMessage());
        }
        return listImportHistory;
    }

    public String getShoesQuantityByShoesId(String shoesId) {
        try {
            String strSelect = "select shoesStockQuantity from Shoes where shoesId = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, shoesId);
            rs = pstm.executeQuery();
            if (rs.next()) {
                String shoesStockQuantity = rs.getString(1);
                return shoesStockQuantity;
            }
        } catch (Exception e) {
            System.out.println("getShoesQuantityByShoesId: " + e.getMessage());
        }
        return "";
    }

    public boolean updateShoesQuantity(String shoesQuantity, String shoesId) {
        try {
            String strUpdateShoesQuantity = "UPDATE Shoes SET shoesStockQuantity = ? "
                    + "WHERE shoesId = ? ";

            connect();
            pstm = cnn.prepareStatement(strUpdateShoesQuantity);
            // theo kieu du lieu trong data base
            pstm.setString(1, shoesQuantity);
            pstm.setString(2, shoesId);
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("updateShoesQuantity: " + e.getMessage());
        }
        return false;
    }

    public Shoes getShoesById(String shoesIdSearch) {
        try {
            String strSelect = "select * from Shoes where shoesId = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, shoesIdSearch);
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
                return sh;
            }
        } catch (Exception e) {
            System.out.println("getShoesById: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<ImportHistory> getImportHistoryByShoesId(String shoesIdSearch) {
        ArrayList<ImportHistory> listImportHistory = new ArrayList<>();
        try {
            String strSelect = "select * from ImportHistory where shoesId = ?";

            connect();
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, shoesIdSearch);
            rs = pstm.executeQuery();
            while (rs.next()) {
                String importHistoryId = rs.getString(1);
                String shoesId = rs.getString(2);
                String dateAdd = rs.getString(3);
                String timeAdd = rs.getString(4);
                String quantity = rs.getString(5);
                ImportHistory ih = new ImportHistory(shoesId, quantity, dateAdd, importHistoryId, timeAdd);
                listImportHistory.add(ih);
            }
        } catch (Exception e) {
            System.out.println("getBrandNameById: " + e.getMessage());
        }
        return listImportHistory;
    }

    public boolean deleteCountTimeAccessByShoesId(String shoesId) {
        try {
            String strDeleteCountTimeAccess = "DELETE FROM countTimeAccess WHERE ShoesId = ?";

           connect();
            pstm = cnn.prepareStatement(strDeleteCountTimeAccess);
            pstm.setString(1, shoesId);
            
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteCountTimeAccessByShoesId: " + e.getMessage());
        }
        return false;
    }
    
    public boolean deleteImportHistory(String shoesId) {
        try {
            String strDeleteImportHistory = "DELETE FROM ImportHistory WHERE shoesId = ?";

           connect();
            pstm = cnn.prepareStatement(strDeleteImportHistory);
            pstm.setString(1, shoesId);
            
            pstm.execute();
            return true;
        } catch (Exception e) {
            System.out.println("deleteImportHistory: " + e.getMessage());
        }
        return false;
    }
}

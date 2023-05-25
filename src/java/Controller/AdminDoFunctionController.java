/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AdminDao;
import Model.Brand;
import Model.Shoes;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import jakarta.websocket.Session;
import java.awt.Color;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 *
 * @author lathai
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class AdminDoFunctionController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String func = req.getParameter("func");
        AdminDao ad = new AdminDao();
//        String hexCode = req.getParameter("color");
//     
//        Color color = Color.decode(hexCode);
//        
//        System.out.println(color);
        if (func.equals("updateProduct")) {
            String oldImg = req.getParameter("oldImg");

            String fileName = "";
            Part filePart = req.getPart("newImg");
            fileName = filePart.getSubmittedFileName();

            if (!fileName.isEmpty()) {
                String path = "D:\\SPRING2023\\PRJ301\\sellShoesWeb\\web\\imageProject\\" + fileName;
                InputStream inputStream = filePart.getInputStream();
                Files.copy(inputStream, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            } else {
                fileName = oldImg;
            }
            String shoesOrigin = req.getParameter("shoesOrigin");
            String shoesId = req.getParameter("shoesId");
            String shoesName = req.getParameter("shoesName");
            String shoesColor = req.getParameter("shoesColor");
            String brandName = req.getParameter("brandName");
            String shoesPrice = req.getParameter("shoesPrice");
            String shoesDecription = req.getParameter("shoesDecription");
            String shoesImg = fileName;
            String shoesSize = req.getParameter("shoesSize");
            String stockQuantity = req.getParameter("stockQuantity");
            String shoesGender = req.getParameter("shoesGender");
            String shoesDiscount = req.getParameter("shoesDiscount");
            String shoesCodeOld = req.getParameter("shoesCode");
            String shoesDetail = req.getParameter("shoesDetail");
            String userId = req.getParameter("userId");
            Shoes sh = new Shoes(shoesName, shoesColor, brandName, shoesSize, shoesGender);
            String shoesCodeNew = sh.getShoesCode();
            String checkSameCode = ad.checkSameProductCode(shoesCodeNew);
            Shoes shoes = new Shoes(shoesId, shoesCodeNew, shoesOrigin, shoesDetail, shoesName, shoesColor, brandName, shoesPrice, shoesDecription, shoesImg, shoesSize, stockQuantity, shoesGender, shoesDiscount, userId);
            if (checkSameCode.equals(shoesId) || checkSameCode.equals("")) {
                boolean check = ad.updateShoes(shoes);
                if (check) {
                    req.setAttribute("notification", "Update success!");
                    ArrayList<Brand> listBrand = new ArrayList<>();
                    listBrand = ad.getAllBrand();
                    Shoes shoesAfterUpdate = new Shoes();
                    shoesAfterUpdate = ad.getShoesByShoesCode(shoesCodeNew);
                    req.setAttribute("sh", shoesAfterUpdate);
                    req.setAttribute("listBrand", listBrand);
                    req.getRequestDispatcher("DetailShoes.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("notification", "Same shoes!");
                req.setAttribute("sh", shoes);
                ArrayList<Brand> listBrand = new ArrayList<>();
                listBrand = ad.getAllBrand();
                req.setAttribute("listBrand", listBrand);
                req.getRequestDispatcher("DetailShoes.jsp").forward(req, resp);
            }

        } else if (func.equals("addProduct")) {
            String oldImg = req.getParameter("oldImg");

            String fileName = "";
            Part filePart = req.getPart("newImg");
            fileName = filePart.getSubmittedFileName();

            if (!fileName.isEmpty()) {
                String path = "D:\\SPRING2023\\PRJ301\\sellShoesWeb\\web\\imageProject\\" + fileName;
                InputStream inputStream = filePart.getInputStream();
                Files.copy(inputStream, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            } else {
                fileName = oldImg;
            }
            String shoesOrigin = req.getParameter("shoesOrigin");
            String shoesName = req.getParameter("shoesName");
            String shoesColor = req.getParameter("shoesColor");
            String brandName = req.getParameter("brandName");
            String shoesPrice = req.getParameter("shoesPrice");
            String shoesDecription = req.getParameter("shoesDecription");
            String shoesImg = fileName;
            String shoesSize = req.getParameter("shoesSize");
            String stockQuantity = "0";
            String shoesGender = req.getParameter("shoesGender");
            String shoesDiscount = req.getParameter("shoesDiscount");
            String shoesDetail = req.getParameter("shoesDetail");
            String userId = "1";
            Shoes sh = new Shoes(shoesName, shoesColor, brandName, shoesSize, shoesGender);
            String shoesCode = sh.getShoesCode();
            boolean checkSameCode = ad.checkSameProductCodeForAdd(shoesCode);
            Shoes shoes = new Shoes(shoesCode, shoesOrigin, shoesDetail, shoesName, shoesColor, brandName, shoesPrice, shoesDecription, shoesImg, shoesSize, stockQuantity, shoesGender, shoesDiscount, userId);
            if (!checkSameCode) {
                boolean check = ad.addShoes(shoes);
                if (check) {
                    ArrayList<Shoes> listShoes = new ArrayList<>();
                    listShoes = ad.getListShoes();
                    req.setAttribute("listShoes", listShoes);
                    req.setAttribute("mod", "2");
                    req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("notification", "Same shoes!");
                req.setAttribute("sh", shoes);
                ArrayList<Brand> listBrand = new ArrayList<>();
                listBrand = ad.getAllBrand();
                req.setAttribute("listBrand", listBrand);
                req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
            }
        } else if (func.equals("updateBrand")) {
            String oldImg = req.getParameter("oldImg");

            String fileName = "";
            Part filePart = req.getPart("newImg");
            fileName = filePart.getSubmittedFileName();

            if (!fileName.isEmpty()) {
                String path = "D:\\SPRING2023\\PRJ301\\sellShoesWeb\\web\\imageProject\\" + fileName;
                InputStream inputStream = filePart.getInputStream();
                Files.copy(inputStream, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            } else {
                fileName = oldImg;
            }
            String brandName = req.getParameter("brandName");
            String shoesDetail = req.getParameter("shoesDetail");
            String brandId = req.getParameter("brandId");
            String brandImage = fileName;
            Brand b = new Brand(brandId, brandImage, brandName, shoesDetail);
            if (!b.checkSameBrandName().equals(brandId)) {
                req.setAttribute("notification", "Same brand name!");
                req.setAttribute("b", b);
                req.getRequestDispatcher("BrandDetail.jsp").forward(req, resp);
            } else {
                boolean checkUpdate = ad.updateBrand(b);
                if (checkUpdate) {
                    req.setAttribute("notification", "update success");
                    req.setAttribute("b", b);
                    req.getRequestDispatcher("BrandDetail.jsp").forward(req, resp);
                }
            }
        } else if (func.equals("addBrand")) {
            String oldImg = req.getParameter("oldImg");

            String fileName = "";
            Part filePart = req.getPart("newImg");
            fileName = filePart.getSubmittedFileName();

            if (!fileName.isEmpty()) {
                String path = "D:\\SPRING2023\\PRJ301\\sellShoesWeb\\web\\imageProject\\" + fileName;
                InputStream inputStream = filePart.getInputStream();
                Files.copy(inputStream, Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
            } else {
                fileName = oldImg;
            }
            String brandName = req.getParameter("brandName");
            String shoesDetail = req.getParameter("shoesDetail");
            String brandId = req.getParameter("brandId");
            String brandImage = fileName;
            Brand b = new Brand(brandId, brandImage, brandName, shoesDetail);
            if (b.checkSameBrandNameForAdd()) {
                req.setAttribute("notification", "Same brand name!");
                req.setAttribute("b", b);
                req.getRequestDispatcher("AddBrand.jsp").forward(req, resp);
            } else {
                boolean checkAddBrand = ad.addBrand(b);
                if (checkAddBrand) {
                    req.setAttribute("notification", "Add success");
                    req.setAttribute("b", b);
                    req.getRequestDispatcher("BrandDetail.jsp").forward(req, resp);
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String func = req.getParameter("func");
        AdminDao ad = new AdminDao();

        switch (func) {
            case "deleteUser":
                String id = req.getParameter("id");
                boolean checkDeleteUser = ad.deleteUserById(id);
                if (checkDeleteUser) {
                    req.getRequestDispatcher("adminfunction?mod=1").forward(req, resp);
                }
                break;
            case "deleteProduct":
                String shoesCode = req.getParameter("shoesCode");
                String shoesIdDelete = req.getParameter("shoesId");
                ad.deleteCountTimeAccessByShoesId(shoesIdDelete);
                ad.deleteImportHistory(shoesIdDelete);
                boolean checkDeleteCode = ad.deleteShoesByShoesCode(shoesCode);
                if (checkDeleteCode) {
                    req.getRequestDispatcher("adminfunction?mod=2").forward(req, resp);
                }
                break;
            case "deleteBrand":
                String brandId = req.getParameter("id");
                boolean checkDeleteBrand = ad.deleteBrandById(brandId);
                if (checkDeleteBrand) {
                    req.getRequestDispatcher("adminfunction?mod=5").forward(req, resp);
                }
                break;
            case "addQuantity":
                String shoesId = req.getParameter("shoesId");
                HttpSession session = req.getSession();
                session.setAttribute("shoesId", shoesId);
                req.getRequestDispatcher("addquantity").forward(req, resp);
                break;
            default:
                throw new AssertionError();
        }
    }
}

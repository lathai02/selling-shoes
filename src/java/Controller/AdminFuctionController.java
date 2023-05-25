/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AdminDao;
import Model.Brand;
import Model.ImportHistory;
import Model.Shoes;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author lathai
 */
public class AdminFuctionController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int mod = Integer.parseInt(req.getParameter("mod"));
        AdminDao ad = new AdminDao();
        switch (mod) {
            case 1:
                ArrayList<User> listUser = new ArrayList<>();
                listUser = ad.getListUser();
                req.setAttribute("listUser", listUser);
                req.setAttribute("mod", "1");
                req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
                break;
            case 2:
                ArrayList<Shoes> listShoes = new ArrayList<>();
                listShoes = ad.getListShoes();
                req.setAttribute("listShoes", listShoes);
                req.setAttribute("mod", "2");
                req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
                break;
            case 3:
                String shoesCode = req.getParameter("shoesCode");
                ArrayList<Brand> listBrand = new ArrayList<>();
                listBrand = ad.getAllBrand();
                Shoes sh = new Shoes();
                sh = ad.getShoesByShoesCode(shoesCode);
                System.out.println(listBrand.size());
                req.setAttribute("sh", sh);
                req.setAttribute("listBrand", listBrand);
                req.getRequestDispatcher("DetailShoes.jsp").forward(req, resp);
                break;
            case 4:
                ArrayList<Brand> listBrandCase4 = new ArrayList<>();
                listBrandCase4 = ad.getAllBrand();
                req.setAttribute("listBrand", listBrandCase4);
                req.getRequestDispatcher("AddProduct.jsp").forward(req, resp);
                break;
            case 5:
                ArrayList<Brand> listBrandforUpdateBrand = new ArrayList<>();
                listBrandforUpdateBrand = ad.getAllBrand();
                req.setAttribute("mod", "6");
                req.setAttribute("listBrandforUpdateBrand", listBrandforUpdateBrand);
                req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
                break;
            case 6:
                String brandId = req.getParameter("id");
                Brand b = new Brand();
                b = ad.getBrandBybrandId(brandId);
                req.setAttribute("b", b);
                req.getRequestDispatcher("BrandDetail.jsp").forward(req, resp);
                break;
            case 7:
                req.getRequestDispatcher("AddBrand.jsp").forward(req, resp);
                break;
            case 8:
                ArrayList<Shoes> listShoesCase8 = new ArrayList<>();
                listShoesCase8 = ad.getListShoes();
                req.setAttribute("listShoes", listShoesCase8);
                req.setAttribute("mod", "8");
                req.getRequestDispatcher("AdminHome.jsp").forward(req, resp);
                break;
            case 9:
                Shoes shCase9 = new Shoes();
                ArrayList<ImportHistory> listImportHistory = new ArrayList<>();
                String shoesId = req.getParameter("shoesId");
                shCase9 = ad.getShoesById(shoesId);
                listImportHistory = ad.getImportHistoryByShoesId(shoesId);
                req.setAttribute("listImportHistory", listImportHistory);
                req.setAttribute("sh", shCase9);
                req.getRequestDispatcher("ImportHistory.jsp").forward(req, resp);
                break;
        }
    }
}

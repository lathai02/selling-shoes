/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.HomeDao;
import Model.Brand;
import Model.Shop;
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
public class HomeController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HomeDao hd = new HomeDao();
        Shop sh = new Shop();
        sh = hd.getShopInfo();
        ArrayList<Brand> listBrand = new ArrayList<>();
        listBrand = hd.getAllBrand();
        req.setAttribute("shop", sh);
        req.setAttribute("listBrand", listBrand);
        req.getRequestDispatcher("Home.jsp").forward(req, resp);
    }
}

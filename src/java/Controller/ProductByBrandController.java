/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.HomeDao;
import DAO.ProductDao;
import Model.Brand;
import Model.Shoes;
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
public class ProductByBrandController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brandName = req.getParameter("name");
        Brand b = new Brand();
        String idBrand = b.getIdByBrandName(brandName);
        System.out.println(idBrand);
        ProductDao pd = new ProductDao();
        ArrayList<Shoes> listShoesByBrand = new ArrayList<>();
        listShoesByBrand = pd.getListShoesNoDuplicate(idBrand);
        
        int page;
        int numberPerPage = 12;

        String pageChooes = req.getParameter("page");
        if (pageChooes == null) {
            page = 1;
        } else {
            page = Integer.parseInt(pageChooes);
        }

        int begin, end;
        begin = (page - 1) * numberPerPage;
       
        end = Math.min(listShoesByBrand.size(), page * numberPerPage);

        ArrayList<Shoes> listShoesPerPage = new ArrayList<>();
        listShoesPerPage = pd.getListByPage(begin, end, listShoesByBrand);

        int numberOfPage = ((listShoesByBrand.size() % numberPerPage == 0) ? (listShoesByBrand.size() / numberPerPage) : (listShoesByBrand.size() / numberPerPage + 1));
        req.setAttribute("listShoesPerPage", listShoesPerPage);
        req.setAttribute("page", page);
        req.setAttribute("numberOfPage", numberOfPage);

        HomeDao hd = new HomeDao();
        Shop sh = new Shop();
        sh = hd.getShopInfo();
        req.setAttribute("shop", sh);
        req.setAttribute("brandName", brandName);
//        req.setAttribute("listShoesByBrand", listShoesByBrand);
        req.getRequestDispatcher("Shop.jsp").forward(req, resp);
    }
}

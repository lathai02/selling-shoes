/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.ProductDao;
import DAO.ViewDao;
import Model.CountTimeAccess;
import Model.Shoes;
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
public class ProductDetailController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String shoesCodeWithoutSize = req.getParameter("shoesCode");
        String shoesId = req.getParameter("shoesId");

        ArrayList<Shoes> listShoes = new ArrayList<>();
        ProductDao pd = new ProductDao();
        listShoes = pd.getListShoesSameShoesCodeWithoutSize(shoesCodeWithoutSize);
        ViewDao vd = new ViewDao();
        String count = vd.getViewByShoesId(shoesId);

        if (count.equals("-1")) {
            CountTimeAccess c = new CountTimeAccess(shoesId, "1");
            vd.addView(c);
            req.setAttribute("timeAccess", "1");
            req.setAttribute("listShoes", listShoes);
            req.getRequestDispatcher("ProductDetail.jsp").forward(req, resp);
            return;
        } else {
            CountTimeAccess c = new CountTimeAccess(shoesId, String.valueOf(Integer.parseInt(count) + 1));
            vd.updateCountTime(c);
        }
        req.setAttribute("timeAccess", String.valueOf(Integer.parseInt(count) + 1));
        req.setAttribute("listShoes", listShoes);
        req.getRequestDispatcher("ProductDetail.jsp").forward(req, resp);
    }

}

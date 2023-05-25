/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.HomeDao;
import Model.Shop;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author lathai
 */
public class UserInfoController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mod = req.getParameter("mod");
        if (mod.equals("1")) {
            String standard = req.getParameter("standard");
            HomeDao hd = new HomeDao();
            Shop sh = new Shop();
            sh = hd.getShopInfo();
            req.setAttribute("shop", sh);
            req.setAttribute("choose1", standard);
//            HttpSession session = req.getSession();
//            User u = new User();
//            u = (User) session.getAttribute("accountUser");
//            Date d = Date.valueOf(u.getDob());
            req.getRequestDispatcher("User.jsp").forward(req, resp);
            return;
        } else if (mod.equals("2")) {
            req.setAttribute("choose1", " active");
            HomeDao hd = new HomeDao();
            Shop sh = new Shop();
            sh = hd.getShopInfo();
            req.setAttribute("shop", sh);
            req.getRequestDispatcher("User.jsp").forward(req, resp);
            return;
        } else if (mod.equals("3")) {
            req.setAttribute("choose2", " active");
            HomeDao hd = new HomeDao();
            Shop sh = new Shop();
            sh = hd.getShopInfo();
            req.setAttribute("shop", sh);
            req.getRequestDispatcher("User.jsp").forward(req, resp);
            return;
        }

    }
}

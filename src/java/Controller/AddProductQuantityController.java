/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.AdminDao;
import Model.ImportHistory;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;

/**
 *
 * @author lathai
 */
public class AddProductQuantityController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String shoesId = (String) session.getAttribute("shoesId");
        String numberOfShoes = req.getParameter("numberOfShoes");
        String dateImport = req.getParameter("dateImport");
        String timeImport = req.getParameter("timeImport");
        ImportHistory ih = new ImportHistory(shoesId, numberOfShoes, dateImport, timeImport);
        AdminDao ad = new AdminDao();
        if (ad.addImportHistory(ih)) {
            String shoesQuantityOld = ad.getShoesQuantityByShoesId(shoesId);
            String shoesQuantityNew = String.valueOf(Integer.parseInt(numberOfShoes) + Integer.parseInt(shoesQuantityOld));
            ad.updateShoesQuantity(shoesQuantityNew, shoesId);
            req.setAttribute("notification", "Add successful!");
        } else {
            req.setAttribute("notification", "Add fail!");
        }
        req.getRequestDispatcher("AddProductQuantity.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("AddProductQuantity.jsp").forward(req, resp);
    }
}

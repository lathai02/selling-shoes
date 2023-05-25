/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.HomeDao;
import DAO.UserDao;
import Model.Shop;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lathai
 */
public class UpdateInfoController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkWhoUpdate = req.getParameter("checkWhoUpdate");
        if (checkWhoUpdate.equals("User")) {
            boolean flag = false;
            String name = req.getParameter("full_name");
            if (checkEmpty(name)) {
                flag = true;
                req.setAttribute("nameError", "name is blank");
            }
            String email = req.getParameter("email");
            if (checkEmpty(email)) {
                flag = true;
                req.setAttribute("emailError", "email is blank");
            }
            String dob = req.getParameter("dob");
            if (checkEmpty(dob)) {
                flag = true;
                req.setAttribute("dobError", "dob is blank");
            }
            String gender = req.getParameter("gender");
            if (gender.equals("female")) {
                gender = "0" + "";
            } else if (gender.equals("male")) {
                gender = "1" + "";
            }
            if (checkEmpty(gender)) {
                flag = true;
                req.setAttribute("genderError", "gender is blank");
            }
            String phone = req.getParameter("phone");
            if (checkEmpty(phone)) {
                flag = true;
                req.setAttribute("phoneError", "phone is blank");
            }
            String address = req.getParameter("address");
            if (checkEmpty(address)) {
                flag = true;
                req.setAttribute("addressError", "address is blank");
            }
            String password = "";
            String account = "";
            String id = "";
            String isAdmin = "";
            HttpSession session = req.getSession();
            if (session.getAttribute("accountUser") != null) {
                User u = (User) session.getAttribute("accountUser");
                password = u.getPassword();
                account = u.getAccount();
                id = u.getId();
                isAdmin = u.getIsAdmin();
            }

            Date d = convertDateSameFormat(dob);
            if (flag) {
                req.getRequestDispatcher("User.jsp?mod=1").forward(req, resp);
                return;
            } else if (d.after(Calendar.getInstance().getTime())) {
                req.setAttribute("notification", "Date of birth is future!");
                req.getRequestDispatcher("User.jsp?mod=1").forward(req, resp);
                return;
            } else {
                User u = new User(id, dob, gender, name, email, phone, address, password, account, isAdmin);
                UserDao ud = new UserDao();
                boolean check = ud.updateInfo(u);
                if (check) {
                    session.setAttribute("accountUser", u);
                    req.setAttribute("notification", "Update success!");
                    req.setAttribute("choose1", "active");
                    req.getRequestDispatcher("User.jsp?mod=1").forward(req, resp);
                    HomeDao hd = new HomeDao();
                    Shop sh = new Shop();
                    sh = hd.getShopInfo();
                    req.setAttribute("shop", sh);
                    return;
                }
            }
        }
    }

    private boolean checkEmpty(String s) {
        return s.isEmpty();
    }

    private Date convertDateSameFormat(String stringDate) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date dateRet = formatter.parse(stringDate);
            return dateRet;
        } catch (Exception e) {
            System.out.println("convertDateSameFormat: " + e.getMessage());
        }
        return null;
    }

}

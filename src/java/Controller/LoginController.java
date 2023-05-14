/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.LoginDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author lathai
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkWhoLogin = req.getParameter("checkWhoLogin");
        if (checkWhoLogin.equals("adminLogin")) {
            boolean flag = false;
            String account = req.getParameter("account");
            if (checkEmpty(account)) {
                req.setAttribute("accountError", "account is blank");
                flag = true;
            }
            String password = req.getParameter("password");
            if (checkEmpty(password)) {
                req.setAttribute("passwordError", "password is blank");
                flag = true;
            }
            if (flag) {
                req.getRequestDispatcher("LoginAdmin.jsp").forward(req, resp);
                return;
            } else {
                LoginDao ld = new LoginDao();
                User u = new User(password, account);
                boolean check = ld.loginAdmin(u);
                if (check) {
                    User uSession = new User();
                    uSession = ld.getuserInfoByAccount(account);
                    HttpSession session = req.getSession();
                    session.setAttribute("accountUser", uSession);
                    resp.sendRedirect("AdminHome.jsp");
                    return;
                } else {
                    req.setAttribute("error", "Info does not exist!");
                    req.getRequestDispatcher("LoginAdmin.jsp").forward(req, resp);
                    return;
                }
            }
        } else if (checkWhoLogin.equals("userLogin")) {
            boolean flag = false;
            String account = req.getParameter("account");
            if (checkEmpty(account)) {
                req.setAttribute("accountError", "account is blank");
                flag = true;
            }
            String password = req.getParameter("password");
            if (checkEmpty(password)) {
                req.setAttribute("passwordError", "password is blank");
                flag = true;
            }
            if (flag) {
                req.getRequestDispatcher("Login.jsp").forward(req, resp);
                return;
            } else {
                LoginDao ld = new LoginDao();
                User u = new User(password, account);
                boolean check = ld.loginCustomer(u);
                if (check) {
                    User uSesion = new User();
                    uSesion = ld.getuserInfoByAccount(account);
                    HttpSession session = req.getSession();
                    session.setAttribute("accountUser", uSesion);
                    resp.sendRedirect("home");
                    return;
                } else {
                    req.setAttribute("error", "Info does not exist!");
                    req.getRequestDispatcher("Login.jsp").forward(req, resp);
                    return;
                }
            }
        }
    }

    private boolean checkEmpty(String s) {
        return s.isEmpty();
    }

}

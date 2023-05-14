/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import DAO.SignUpDao;
import Model.Brand;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author lathai
 */
public class SignUpController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String checkWhoSignUp = req.getParameter("checkWhoSignUp");
        if (checkWhoSignUp.equals("signUpAdmin")) {
            boolean flag = false;
            String account = req.getParameter("account");
            if (checkEmpty(account)) {
                flag = true;
                req.setAttribute("accountError", "account is blank");
            }
            String password = req.getParameter("password");
            if (checkEmpty(password)) {
                flag = true;
                req.setAttribute("passwordError", "password is blank");
            }
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
            String re_password = req.getParameter("re_password");
            if (checkEmpty(re_password)) {
                flag = true;
                req.setAttribute("re_passwordError", "re_password is blank");
            }
            String isAdmin = "1";

            Date d = convertDateSameFormat(dob);
            SignUpDao sud = new SignUpDao();
            User u = new User(dob, gender, name, email, phone, address, password, account, isAdmin);

            if (flag) {
                req.getRequestDispatcher("SignUpAdmin.jsp").forward(req, resp);
                return;
            } else if (!password.equals(re_password)) {
                req.setAttribute("errorSamePassAndRepass", "Password and repassword not same!");
                req.getRequestDispatcher("SignUpAdmin.jsp").forward(req, resp);
                return;
            } else if (d.after(Calendar.getInstance().getTime())) {
                req.setAttribute("errordobAfter", "Date of birth is future!");
                req.getRequestDispatcher("SignUpAdmin.jsp").forward(req, resp);
                return;
            } else if (sud.checkExistAccount(u)) {
                req.setAttribute("sameAccount", "Account or phone number or email have already!");
                req.getRequestDispatcher("SignUpAdmin.jsp").forward(req, resp);
                return;
            } else {
                boolean check = sud.signUpAdmin(u);
                if (check) {
                    req.setAttribute("account", account);
                    req.setAttribute("password", password);
                    req.getRequestDispatcher("LoginAdmin.jsp").forward(req, resp);
                    return;
                } else {
                    req.setAttribute("error", "Wrong info!");
                    req.getRequestDispatcher("SignUpAdmin.jsp").forward(req, resp);
                    return;
                }
            }
        } else if (checkWhoSignUp.equals("signUpUser")) {
            boolean flag = false;
            String account = req.getParameter("account");
            if (checkEmpty(account)) {
                flag = true;
                req.setAttribute("accountError", "account is blank");
            }
            String password = req.getParameter("password");
            if (checkEmpty(password)) {
                flag = true;
                req.setAttribute("passwordError", "password is blank");
            }
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
            String re_password = req.getParameter("re_password");
            if (checkEmpty(re_password)) {
                flag = true;
                req.setAttribute("re_passwordError", "re_password is blank");
            }
            String isAdmin = "0";

            Date d = convertDateSameFormat(dob);
            SignUpDao sud = new SignUpDao();
            User u = new User(dob, gender, name, email, phone, address, password, account, isAdmin);

            if (flag) {
                req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
                return;
            } else if (!password.equals(re_password)) {
                req.setAttribute("errorSamePassAndRepass", "Password and repassword not same!");
                req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
                return;
            } else if (d.after(Calendar.getInstance().getTime())) {
                req.setAttribute("errordobAfter", "Date of birth is future!");
                req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
                return;
            } else if (sud.checkExistAccount(u)) {
                req.setAttribute("sameAccount", "Account or phone number or email have already!");
                req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
                return;
            } else {
                boolean check = sud.signUpCustomer(u);
                if (check) {
                    req.setAttribute("account", account);
                    req.setAttribute("password", password);
                    req.getRequestDispatcher("Login.jsp").forward(req, resp);
                    return;
                } else {
                    req.setAttribute("error", "Wrong info!");
                    req.getRequestDispatcher("SignUp.jsp").forward(req, resp);
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

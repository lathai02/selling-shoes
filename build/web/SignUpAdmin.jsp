<%-- 
    Document   : SignUp
    Created on : Mar 3, 2023, 5:19:37 AM
    Author     : lathai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign up admin</title>
        <link rel="stylesheet" href="Css/NewCss.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
    <body>
        <form action="signup" method="post">
            <div class="header">
                <div class="logo">
                    <a href="Home.jsp">
                        <img src="imageProject\326280066_9115130398527573_4587678303343826377_n.jpg" alt="Logo"/>
                    </a>
                </div>
            </div>
            <br>
            <br>
            <br>
            <div id="sign-up_form">
                <div style="text-align: center;">
                    <b style="font-size: 40px;">SIGN UP ADMIN</b>
                </div>
                <br>
                <div>
                    <div style="font-size: 30px;">Full name:</div>
                    <div style="font-size: 30px; height: 30px;" > 
                        <input type="text" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" placeholder="enter full name" value="" name="full_name">
                        <div style="color: red; font-size: 15px;">${nameError}</div>
                    </div> 
                </div>
                <br>
                <br>

                <div style="font-size: 30px;" >
                    Email: 
                    <br>
                    <input type="email" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your email" value="" name="email">
                    <div style="color: red; font-size: 15px;">${emailError}</div>
                </div> 
                <br>
                <div style="font-size: 30px;" >
                    Date of birth: 
                    <br>
                    <input type="date" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your date of birth" value="" name="dob">
                    <div style="color: red; font-size: 15px;">${dobError}</div>
                </div>
                <br>
                <div style="font-size: 30px;" >
                    Gender:
                    <div style="text-align: center">
                        <div class="custom-select" style="width:100%;">
                            <select style="border: 3px solid black; border-radius: 5px; width: 101%; height: 29px;" name = "gender">
                                <option value="">choose gender</option>
                                <option value="male">male</option>
                                <option value="female">female</option>
                            </select>
                        </div>                
                    </div>
                    <div style="color: red; font-size: 15px;">${genderError}</div>
                </div>
                <br>
                <div style="font-size: 30px;" >
                    Phone number: 
                    <br>
                    <input type="text" style=" box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your phone number" value="" name="phone" >
                    <div style="color: red; font-size: 15px;">${phoneError}</div>
                </div>
                <br>
                <div style="font-size: 30px;" >
                    Address: 
                    <br>
                    <input type="text" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your address" value="" name="address">
                    <div style="color: red; font-size: 15px;">${addressError}</div>
                </div>
                <br>
                <div style="font-size: 30px;" >
                    Account: 
                    <br>
                    <input type="text" style=" box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your account" value="" name="account">
                    <div style="color: red; font-size: 15px;">${accountError}</div>
                </div> 
                <br>
                <div style="font-size: 30px;" >
                    Password: 
                    <br>
                    <div style="display: flex; justify-content: space-between; height: 30px;">
                        <input type="password" id="pass" style="box-sizing: border-box; height: 100%; border: 3px solid black; border-radius: 5px; width: 89%;" placeholder="enter password" value="" name="password">

                        <div style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; height: 100%; width: 17%; display: flex; justify-content: center; align-items: center;" onclick="showHidePassword()">
                            <i class="fa fa-eye" aria-hidden="true"  ></i>
                        </div>
                    </div>
                    <div style="color: red; font-size: 15px;">${passwordError}</div>
                </div>
                <br>
                <div style="font-size: 30px;" >
                    Re-enter Password: 
                    <br>
                    <div style="display: flex; justify-content: space-between; height: 30px;">
                        <input type="password" id="re-pass" style="box-sizing: border-box; height: 100%; border: 3px solid black; border-radius: 5px; width: 89%;" placeholder="re-enter password" value="" name="re_password">

                        <div style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; height: 100%; width: 17%; display: flex; justify-content: center; align-items: center;" onclick="showHidePassword()">
                            <i class="fa fa-eye" aria-hidden="true"  ></i>
                        </div>
                    </div>
                    <div style="color: red; font-size: 15px;">${re_passwordError}</div>
                </div>
                <br>
                <br>
                <br>
                <div style="text-align: center">
                    <input type="submit" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 25px;" value="sign up">
                    <div style="color: red; font-size: 25px;">${error}</div>
                    <div style="color: red; font-size: 25px;">${errorSamePassAndRepass}</div>
                    <div style="color: red; font-size: 25px;">${errordobAfter}</div>
                    <div style="color: red; font-size: 25px;">${sameAccount}</div>
                </div>
            </div>
            <br>
            <br>
            <br>
            <input type="hidden" value="signUpAdmin" name ="checkWhoSignUp">
            <%@include file="Footer.jsp"%> 
        </form>
        <script type="text/javascript">
            function showHidePassword() {
                const check = document.getElementById('pass').type;
                const check1 = document.getElementById('re-pass').type;

                if (check == 'password' || check1 == 'password') {
                    document.getElementById('pass').type = "text";
                    document.getElementById('re-pass').type = "text";
                } else {
                    document.getElementById('pass').type = "password";
                    document.getElementById('re-pass').type = "password";
                }
            }
        </script>
    </body>
</html>

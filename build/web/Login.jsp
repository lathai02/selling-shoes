<%-- 
    Document   : Login
    Created on : Mar 3, 2023, 4:16:43 AM
    Author     : lathai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
        <link rel="stylesheet" href="Css/NewCss.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    </head>
    <body>
        <form action="login" method="post">
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
            <div id="login_form">
                <div style="text-align: center;">
                    <b style="font-size: 40px;">LOGIN</b>
                </div>
                <br>
                <div style="font-size: 30px;" >
                    Account: 
                    <input type="text" style="border: 3px solid black; border-radius: 5px; width: 100%; height: 30px; box-sizing: border-box;" placeholder="enter account" value="${account}" name="account">
                </div>  
                <div style="color: red; font-size: 15px;">${accountError}</div>
                <br>
                <div style="font-size: 30px;" >
                    Password: 
                    <br>
                    <div style="display: flex; justify-content: space-between; height: 30px;">
                        <input type="password" id="pass" style="box-sizing: border-box; height: 100%; border: 3px solid black; border-radius: 5px; width: 89%;" placeholder="enter password" value="${password}" name="password">

                        <div style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; height: 100%; width: 17%; display: flex; justify-content: center; align-items: center;" onclick="showHidePassword()">
                            <i class="fa fa-eye" aria-hidden="true"  ></i>
                        </div>
                    </div>
                    <div style="color: red; font-size: 15px;">${passwordError}</div>
                </div>
                <a href="#" style="float: right">forgot password?</a>
                <br>
                <br>
                <div style="text-align: center">
                    <input type="submit" required="" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 25px;" value="login">
                </div>
                <div style="text-align: center">
                    <a href="SignUp.jsp" >don't have account?</a>
                    <div style="color: red; font-size: 25px;">${error}</div>
                </div>
            </div>
            <br>
            <br>
            <br>
            <input type="hidden" value="userLogin" name="checkWhoLogin">
            <%@include file="Footer.jsp"%> 
        </form>

        <script type="text/javascript">
            function showHidePassword() {
                const check = document.getElementById('pass').type;
                if (check == 'password') {
                    document.getElementById('pass').type = "text";
                } else {
                    document.getElementById('pass').type = "password";
                }
            }
        </script>
    </body>
</html>

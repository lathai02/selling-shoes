<%-- 
    Document   : User
    Created on : Mar 4, 2023, 1:55:47 AM
    Author     : lathai
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.User" %>
<%@page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>    
        <link rel="stylesheet" href="Css/NewCss.css"/>
        <style>
            .active, .btn:hover{
                background-color: #856224 !important;
                border-radius: 0px;
            }
        </style>
    </head>
    <body>
        <!--header-->
        <c:if test="${sessionScope.accountUser.isAdmin.equals('0')}">
            <%@include file="Header.jsp"%> 
        </c:if>
        <c:if test="${sessionScope.accountUser == null}">
            <%@include file="Header.jsp"%> 
        </c:if>
        <c:if test="${sessionScope.accountUser.isAdmin.equals('1')}">
            <%@include file="HeaderAdmin.jsp"%> 
        </c:if>
        <!--end header-->
        <!--product bar-->
        <c:if test="${sessionScope.accountUser.isAdmin.equals('0')}">
            <%@include file="Product_Bar.jsp"%> 
        </c:if>
        <c:if test="${sessionScope.accountUser == null}">
            <%@include file="Product_Bar.jsp"%> 
        </c:if>
        <!--end product bar-->
        <!--content-->
        <form action="updateinfo" method="post">
            <div class="container-fluid" style="padding: 0px;">
                <div class="row">
                    <div id="user_account" style="padding: 50px;" class="col-md-3">
                        <h3>
                            <c:if test="${sessionScope.accountUser != null}">
                                Xin chào, ${sessionScope.accountUser.name}!
                            </c:if>
                        </h3>
                        <div id="left_side_bar" style="width: 300px; height:100px; ">
                            <div id="myDIV" style="width: 100%; height: 100%; border-radius: 0px">

                                <c:if test="${sessionScope.accountUser.isAdmin.equals('0')}">
                                    <a href="userInfo?mod=2">
                                        <button type="button" id = "userInfo" class="btn ${choose1}" name="user_info" style="border: none;width: 100%; color: white; font-size: 20px;" onclick="show()">thông tin tài khoản</button>
                                    </a>
                                    <a href="userInfo?mod=3">
                                        <button type="button" id = "userOrder" class="btn ${choose2}" name="order" style="border: none;width: 100%; color: white; font-size: 20px;" onclick="show()">đơn hàng của bạn</button>
                                    </a>
                                </c:if>
                                <c:if test="${sessionScope.accountUser.isAdmin.equals('1')}">
                                    <a href="userInfo?mod=2" style="width: 100%; height: 100%;">
                                        <button type="button" id = "userInfo" class="btn ${choose1}" name="user_info" style="height: 100%; border: none;width: 100%; color: white; font-size: 20px;" onclick="show()">thông tin tài khoản</button>
                                    </a>
                                </c:if>
                                <c:if test="${sessionScope.accountUser == null}">
                                    <a href="userInfo?mod=2">
                                        <button type="button" id = "userInfo" class="btn ${choose1}" name="user_info" style="border: none;width: 100%; color: white; font-size: 20px;" onclick="show()">thông tin tài khoản</button>
                                    </a>
                                    <a href="userInfo?mod=3">
                                        <button type="button" id = "userOrder" class="btn ${choose2}" name="order" style="border: none;width: 100%; color: white; font-size: 20px;" onclick="show()">đơn hàng của bạn</button>
                                    </a>
                                </c:if>
                            </div>
                        </div>
                        <br>
                        <a href="logout">
                            <div style="width: 100%; text-align: center">
                                <input type="button" style=" border: 3px solid black; border-radius: 5px; width: 100px; height: 50px; background-color: #cc0000; color: white;font-size: 25px;" value="log out">
                            </div>
                        </a>
                    </div>
                    <div class="col-md-9" id="userInfo">
                        <c:if test="${sessionScope.accountUser == null}">
                            <div style="font-size: 40px; margin-top: 40px;">Đăng nhập tài khoản để xem thông tin</div>
                        </c:if>
                        <% String mod = request.getParameter("mod");%>
                        <c:if test="${sessionScope.accountUser != null}">
                            <%if(mod.equals("2") || mod.equals("1")){%>
                            <div id="info">
                                <div style="border: 3px solid black; width: 80%; height: auto; margin-left: auto; margin-right: auto; margin-top: 85px; padding: 40px">
                                    <div>
                                        <div style="font-size: 25px;">Full name:</div>
                                        <div style="font-size: 25px; height: 30px;" > 
                                            <input type="text" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" placeholder="enter full name" value="${sessionScope.accountUser.name}" name="full_name">
                                            <div style="color: red; font-size: 15px;">${nameError}</div>
                                        </div> 
                                    </div>
                                    <br>
                                    <div style="font-size: 25px;" >
                                        Email: 
                                        <br>
                                        <input type="email" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your email" value="${sessionScope.accountUser.email}" name="email">
                                        <div style="color: red; font-size: 15px;">${emailError}</div>
                                    </div> 
                                    <br>
                                    <div style="font-size: 25px;" >
                                        Date of birth: 
                                        <br>
                                        ${sessionScope.accountUser.dob}
                                        <input type="date" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your date of birth" value="${sessionScope.accountUser.dob}" name="dob">
                                        <div style="color: red; font-size: 15px;">${dobError}</div>
                                    </div>
                                    <br>
                                    <div style="font-size: 25px;" >
                                        Gender:
                                        <%
                                            User u = new User();
                                            u = (User) session.getAttribute("accountUser");
                                            String ops = u.getGender();
                                            String options [] = {"","1","0"};
                                            String selected [] = new String[options.length];;
                                            for(int i = 0 ; i < options.length ; i++){
                                                if(options[i].equals(ops)){
                                                    selected[i] = "selected";
                                                }
                                            }
                                        %>
                                        <div style="text-align: center">
                                            <div class="custom-select" style="width:100%;">
                                                <%
                                                int i = 0;
                                                %>
                                                <select style="border: 3px solid black; border-radius: 5px; width: 100%; height: 30px;" name = "gender">
                                                    <option value="" <%=selected[i]%>>choose gender</option>
                                                    <option value="male" <%=selected[++i]%>>male</option>
                                                    <option value="female" <%=selected[++i]%>>female</option>
                                                </select>
                                            </div>                
                                        </div>
                                        <div style="color: red; font-size: 15px;">${genderError}</div>
                                    </div>
                                    <br>
                                    <div style="font-size: 25px;" >
                                        Phone number: 
                                        <br>
                                        <input type="text" style=" box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your phone number" value="${sessionScope.accountUser.phoneNumber}" name="phone" >
                                        <div style="color: red; font-size: 15px;">${phoneError}</div>
                                    </div>
                                    <br>
                                    <div style="font-size: 25px;" >
                                        Address: 
                                        <br>
                                        <input type="text" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your address" value="${sessionScope.accountUser.address}" name="address">
                                        <div style="color: red; font-size: 15px;">${addressError}</div>
                                    </div>
                                    <br>
                                    <input type="hidden" name="checkWhoUpdate" value="User">
                                    <div style="text-align: center">
                                        <input type="submit" required="" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 25px;" value="update">
                                        <div style="color: red; font-size: 25px;">${notification}</div>
                                    </div>
                                </div>
                            </div>
                            <%} %>
                        </c:if>
                        <c:if test="${sessionScope.accountUser != null}">
                            <%if(mod.equals("3")){%>
                            <h2 id="order">Coming soon!</h2>
                            <%}%>
                        </c:if>
                    </div>
                </div>
                <br>
                <br>
            </div>
        </form>
        <!--end content-->
        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
        <!--        <script>
                    // Add active class to the current button (highlight it)
                    var header = document.getElementById("myDIV");
                    var btns = header.getElementsByClassName("btn");
                    for (var i = 0; i < btns.length; i++) {
                        btns[i].addEventListener("click", function () {
                            var current = document.getElementsByClassName("active");
                            current[0].className = current[0].className.replace(" active", "");
                            this.className += " active";
                        });
                    }
                </script>-->
    </body>
</html>

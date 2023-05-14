<%-- 
    Document   : headerAdmin
    Created on : Mar 14, 2023, 3:58:54 PM
    Author     : lathai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Admin</title>

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>    
        <link rel="stylesheet" href="Css/NewCss.css"/>
    </head>
    <body>

        <div class="header">
            <div class="logo">
                <a href="home">
                    <img src="imageProject\326280066_9115130398527573_4587678303343826377_n.jpg" alt="Logo"/>
                </a>
            </div>
            <div class="search_bar">
                <form action="" class="search" method="post">
                    <input type="text" class="searchTerm" placeholder="Bạn muốn tìm gì?">
                    <button type="submit" class="searchButton changeColorButton">
                        <span>Tìm kiếm</span>
                    </button>
                </form>
            </div>
            <div class="right_header">
                <div id="login_logo">
                    <%String link = "";%>
                    <%String detail = "";%>
                    <c:if test="${sessionScope.accountUser == null}">
                        <%link = "LoginAdmin.jsp";%>
                        <%detail = "login/sign up admin";%>
                    </c:if>
                    <c:if test="${sessionScope.accountUser != null}">
                        <%link = "SignUpAdmin.jsp";%>
                        <%detail = "sign up admin";%>
                    </c:if>
                    <a href="<%=link%>" class="changeColor center">
                        <i class="fa fa-sign-in icon" aria-hidden="true"></i> 
                        <br>
                        <span class="block"><%=detail%></span>
                    </a>
                </div>
                <c:if test="${sessionScope.accountUser.isAdmin.equals('1')}">   
                    <div>
                        <div id="homeAdminLogo">
                            <a href="AdminHome.jsp" class="changeColor center">
                                <i class="fa fa-chevron-left icon" aria-hidden="true"></i>
                                <br>
                                <span class="block">Back to admin</span>
                            </a>
                        </div>
                    </div>
                </c:if>


                <div id="account">
                    <a href="userInfo?standard=active&mod=1" class="changeColor center">
                        <i class="fa fa-user icon" aria-hidden="true"></i>
                        <br>
                        <span class="block">
                            <c:if test="${sessionScope.accountUser == null}">
                                user
                            </c:if>
                            <c:if test="${sessionScope.accountUser != null}">
                                ${sessionScope.accountUser.name}<br>(admin)
                            </c:if>
                        </span>
                    </a>
                </div>
            </div>
        </div>
        <!--end header-->
    </body>
</html>

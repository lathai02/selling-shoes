<%-- 
    Document   : Product_Bar
    Created on : Mar 3, 2023, 4:10:49 AM
    Author     : lathai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product bar</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>    
        <link rel="stylesheet" href="Css/NewCss.css"/>

        <style>
            .active{
                background-color: red;
            }
        </style>
    </head>
    <body>
        <!--product bar-->
        <div id="product_bar">
            <div class="changeColorHover">
                <a href="shop" class="changeColor center">
                    <span class="white brands block">Shop</span>
                </a>
            </div>
            <div class="changeColorHover">
                <a href="brand?name=Adidas" class="changeColor center">
                    <span class="white brands block">Adidas</span>
                </a>
            </div>
            <div class="changeColorHover">
                <a href="brand?name=Nike" class="changeColor center">
                    <span class="white brands block">Nike</span>
                </a>
            </div>
            <div class="changeColorHover">
                <a href="brand?name=Puma" class="changeColor center">
                    <span class="white brands block">Puma</span>
                </a>
            </div>
            <div class="changeColorHover">
                <a href="brand?name=Mlb" class="changeColor center">
                    <span class="white brands block">MLB</span>
                </a>
            </div>
            <div class="changeColorHover">
                <a href="brand?name=Vans" class="changeColor center">
                    <span class="white brands block">Vans</span>
                </a>
            </div>
        </div>
        <!--end product bar-->
    </body>
</html>

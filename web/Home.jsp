<%-- 
    Document   : Home
    Created on : Mar 2, 2023, 10:16:59 PM
    Author     : lathai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>    
        <link rel="stylesheet" href="Css/NewCss.css"/>

    </head>
    <body>
        <!--header-->
        <%@include file="Header.jsp"%> 
        <!--end header-->
        <!--product bar-->
        <%@include file="Product_Bar.jsp"%> 
        <!--end product bar-->
        <!--image-->
        <div id="background">
            <a href="brand?name=Adidas">
                <div class="imageContainer">
                    <div class="hover_image">
                        <img src="imageProject\1920x1080-px-Adidas-Minimalistic-shoe-pink-shoes-red-shoes-RX1R-1369955-wallhere.com.jpg" alt="image1" class="imageBody" style="width: 100%"/>
                    </div>
                    <div class="overlay">
                        <div class="text">EPIC ENERGY. LIGHTEST EVER.</div>
                    </div>
                </div> 
            </a>
            <a href="brand?name=Nike">
                <div class="imageContainer">
                    <div class="hover_image">
                        <img src="imageProject\pexels-ashutosh-sonwani-2016145.jpg" alt="image1" class="imageBody"/>
                    </div>
                    <div class="overlay">
                        <div class="text">RUN FOREVER WITH FOREVERRUN</div>
                    </div>
                </div> 
            </a>
            <a href="brand?name=Puma">
                <div class="imageContainer">
                    <div class="hover_image">
                        <img src="imageProject\pexels-messala-ciulla-1018482.jpg" alt="image1" class="imageBody"/>
                    </div>
                    <div class="overlay">
                        <div class="text">CLASSIC SINCE FOREVER</div>
                    </div>
                </div> 
            </a>
            <a href="brand?name=Vans">
                <div class="imageContainer">
                    <div class="hover_image">
                        <img src="imageProject\376016-4k-wallpaper.jpg" alt="image1" class="imageBody"/>
                    </div>
                    <div class="overlay">
                        <div class="text">JUST DO IT</div>
                    </div>
                </div> 
            </a>
            <a href="Home.jsp">
                <div class="imageContainer">
                    <div class="hover_image">
                        <img src="imageProject/${shop.image}" alt="image1" class="imageBody"/>
                    </div>
                    <div class="overlay">
                        <div class="text">TOI BAN GIAY</div>
                    </div>
                </div> 
            </a>
        </div>
        <!--end image-->
        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
    </body>
</html>

<%-- 
    Document   : productDetail
    Created on : Mar 4, 2023, 2:33:31 AM
    Author     : lathai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product detail</title>
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
        <!--content-->
        <div id="detail_product" style="display: flex">
            <div id="image" style="height: 900px; width: 900px;">
                <img src="imageProject/${listShoes.get(0).getImg()}" alt="image" style="width: 900px; height: 900px"/>
            </div>
            <div style="font-size: 30px; margin-left: 20px; margin-right: 20px; margin-top: 20px;">
                <div>${listShoes.get(0).getName()}</div>
                <div style="color: red; margin-top: 20px;">${listShoes.get(0).getShoesPriceAfterDiscount()} </div>


                <c:if test="${listShoes.get(0).checkDiscount() eq '1'}"> 
                    <span style="color: gray; margin-top: 20px; font-size: 20px;"><del style="font-size: 20px;">${listShoes.get(0).getPrice()}</del></span><br>
                        ${listShoes.get(0).discount}
                    </c:if>
                <br>
                <i class="fa fa-eye" aria-hidden="true"></i>    ${timeAccess}

                <br>
                <div style="font-size: 20px; margin-top: 20px; color: gray;">Mô tả</div>
                <div style="font-size: 20px; color: gray;">${listShoes.get(0).getDetail()}</div>
                <hr>
                <div style="display: flex;">
                    <span style="font-size: 20px; margin-right: 10px;">size giày</span>
                    <c:forEach items="${listShoes}" var="sh">
                        <input type="button" value="${sh.getSize()}" style="font-size: 15px; margin-right: 10px; width: 50px;height: 30px; border: 2px solid black; color: white; background-color: #856224"/>
                    </c:forEach>
                </div>
                <div style="margin-top: 20px;">
                    <span style="font-size: 20px; margin-right: 10px;">số lượng</span>
                    <input type="number" value="" style="width:60px;height: 40px; border: 2px solid black; color: white; background-color: #856224"/>
                </div>


                <div style="margin-top: 20px;">
                    <input type="submit" value="thêm vào giỏ hàng" style="width:200px; height: 40px; border: 2px solid black; color: white; background-color: #856224; font-size: 20px; text-align: center"/>
                </div>


                <hr>
                <div style="font-size: 25px;">${listShoes.get(0).getDecription()}</div>
                <br>
                <div style="font-size: 15px;">Trải nghiệm chạy bộ mượt mà với đôi giày chạy bộ Ultra 4DFWD. Giày kết hợp thân giày Ultraboost iconic với đế giữa adidas 4DFWD in 3D phiên bản cải tiến có khả năng nén về phía trước, giảm lực hãm và chuyển hoá năng lượng tác động thành chuyển động tiến về phía trước. Kết quả là chuyển động mượt mà và trải nghiệm lướt bay độc đáo. Thân Giày Sneaker Adidas Nam PRIMEKNIT ôm chân với các vùng nâng đỡ tập trung, cùng đế ngoài Continental™ Rubber cho độ bám vượt trội trong mọi điều kiện thời tiết. Thân giày làm từ loại sợi hiệu năng cao có chứa tối thiểu 50% chất liệu Parley Ocean Plastic — rác thải nhựa tái chế thu gom từ các vùng đảo xa, bãi biển, khu dân cư ven biển và đường bờ biển, nhằm ngăn chặn ô nhiễm đại dương. 50% thành phần còn lại của sợi dệt là polyester tái chế.</div>
            </div>
        </div>
        <!--end_content-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
    </body>
</html>

<%-- 
    Document   : ShopBySize
    Created on : Mar 20, 2023, 4:45:50 PM
    Author     : lathai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--header-->
        <%@include file="Header.jsp"%> 
        <!--end header-->
        <!--product bar-->
        <%@include file="Product_Bar.jsp"%> 
        <!--end product bar-->
        <img src="imageProject\coverweb04_1.jpg" alt="salePicture" class="col-md-12" style="padding: 0px;"/>
        <br>
        <br>
        <br>
        <br>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <div style="border: 3px solid black">
                        <div class="container-fluid text-center">
                            <form action="size">
                                <div style="font-size: 35px; margin-bottom: 20px; text-align: center" class="col-md-12">Size</div>
                                <input type="submit" name="value" value="36" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="37" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="38" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="39" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="40" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="41" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="42" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="43" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="44" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2" />
                                <input type="submit" name="value" value="45" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                                <input type="submit" name="value" value="46" style="margin-bottom: 10px; font-size: 15px; height: 30px; border: 2px solid black; color: white; background-color: #856224" class="col-md-2"/>
                            </form>
                        </div>
                    </div>
                    <br>
                    <div style="border: 3px solid black">
                        <form action="price">
                            <div class="container-fluid" style="margin-bottom: 10px;">
                                <div style="font-size: 35px; margin-bottom: 20px; text-align: center" class="col-md-12">Price</div>
                                From:
                                <input type="number" name="valueTo" value="${valueTo}"><br>
                                To:
                                <input type="number" name="valueEnd" value="${valueEnd}">
                                <input type="submit" value="submit">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-9">
                    <div class="row">
                        <c:forEach items="${listShoesPerPage}" var="sh">
                            <div id="product_shop" class="col-md-3">
                                <a href="detail?shoesCode=${sh.getShoesCodeWithoutSize()}&shoesId=${sh.id}">
                                    <img src="imageProject/${sh.getImg()}" style="width:100%; height: 300px">
                                    <div style="text-align: center; width:100% " >
                                        <div>${sh.name}</div>
                                        <div>${sh.getShoesPriceAfterDiscount()}</div>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                    <br>
                    <br>
                    <div class="column" style="display: flex; justify-content: center;" >
                        <div class="panination">
                            <c:forEach begin="${1}" end="${numberOfPage}" var="i">
                                <a 
                                    href="size?page=${i}&size=${size}"
                                    class="<c:if test="${page eq i}">active</c:if>" id="buttonPage">${i}</a>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <br>
    <script>
        function submitSize() {
            document.getElementById("sizeBnt").submit();
        }
    </script>
    <!--footer-->
    <%@include file="Footer.jsp"%> 
    <!--end footer-->
</body>
</html>

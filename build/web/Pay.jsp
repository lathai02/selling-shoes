<%-- 
    Document   : Pay
    Created on : Mar 3, 2023, 5:11:35 PM
    Author     : lathai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/NewCss.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <title>Pay</title>
    </head>
    <body>
        <!--header-->
        <%@include file="Header.jsp"%> 
        <!--end header-->
        <!--product bar-->
        <%@include file="Product_Bar.jsp"%> 
        <!--end product bar-->
        <!--content-->
        <form action="">
            <div id="content_pay" style="border: 3px solid black; width: 800px; height: auto; padding: 30px; margin-top: 30px; margin-bottom: 30px; margin-left: auto; margin-right: auto; ">
                <div style="text-align: center; font-size: 30px;">Gio hàng <br>(n sản phẩm)</div>
                <hr style="margin-bottom: 10px;">

                <div id="product" style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 10px; color: black; width: fit-content; height: 85px;">
                    <img src="imageProject\ULTRABOOST-20-SHOES-10.jpg" alt="img" style="width: fit-content; height: 100%; border: 2px solid black;"/>
                    <div style="margin-left: 10px; border: 2px solid black; padding: 5px; height: 100%; width: fit-content">
                        <div >Giày Sneaker Adidas Nam Ultraboost Cold.Rdy DNA "Olive" G54966 - Hàng Chính Hãng</div>
                        <span id="size" style="color: grey;">size: 19</span>
                        <span id="price" style="float: right; color: grey;">price: 2.500.000</span>
                    </div>
                    <div style="margin-left: 10px; height: 100%;">
                        <input type="number" placeholder="số lượng" value="" style="width: 85px; fit-content;height: 100%; border: 2px solid black; color: black; background-color: white; font-size: 17px; font-size: 25px;"/>
                    </div>
                    <div style="margin-left: 10px; height: 100%;" >
                        <input class="changeColorButton" type="button" value="delete" style="width: 85px;height: 100%; border: 2px solid black; color: black; font-size: 17px;"/>
                    </div>
                </div>

                <div id="product" style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 10px; color: black; width: fit-content; height: 85px;">
                    <img src="imageProject\ULTRABOOST-20-SHOES-10.jpg" alt="img" style="width: fit-content; height: 100%; border: 2px solid black;"/>
                    <div style="margin-left: 10px; border: 2px solid black; padding: 5px; height: 100%; width: fit-content">
                        <div >Giày Sneaker Adidas Nam Ultraboost Cold.Rdy DNA "Olive" G54966 - Hàng Chính Hãng</div>
                        <span id="size" style="color: grey;">size: 19</span>
                        <span id="price" style="float: right; color: grey;">price: 2.500.000</span>
                    </div>
                    <div style="margin-left: 10px; height: 100%;">
                        <input type="number" placeholder="số lượng" value="" style="width: 85px; font-size: 25px; fit-content;height: 100%; border: 2px solid black; color: black; background-color: white;"/>
                    </div>
                    <div style="margin-left: 10px; height: 100%;" >
                        <input class="changeColorButton" type="button" value="delete" style="width: 85px;height: 100%; border: 2px solid black; color: black; font-size: 17px;"/>
                    </div>
                </div>
                <div id="product" style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 10px; color: black; width: fit-content; height: 85px;">
                    <img src="imageProject\ULTRABOOST-20-SHOES-10.jpg" alt="img" style="width: fit-content; height: 100%; border: 2px solid black;"/>
                    <div style="margin-left: 10px; border: 2px solid black; padding: 5px; height: 100%; width: fit-content">
                        <div >Giày Sneaker Adidas Nam Ultraboost Cold.Rdy DNA "Olive" G54966 - Hàng Chính Hãng</div>
                        <span id="size" style="color: grey;">size: 19</span>
                        <span id="price" style="float: right; color: grey;">price: 2.500.000</span>
                    </div>
                    <div style="margin-left: 10px; height: 100%;">
                        <input type="number" placeholder="số lượng" value="" style="width: 85px; fit-content;height: 100%; border: 2px solid black; color: black; background-color: white; font-size: 25px;"/>
                    </div>
                    <div style="margin-left: 10px; height: 100%;" >
                        <input class="changeColorButton" type="button" value="delete" style="width: 85px;height: 100%; border: 2px solid black; color: black; font-size: 17px;"/>
                    </div>
                </div>

                <hr>
                <form action="" >
                    <div id="saleCode" style="height: 35px;">
                        <div style="font-size: 20px; height: 100%" > 
                            <div style="display: flex; justify-content: center; height: 100%">
                                <input type="text" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 60%; height: 100%;" placeholder="enter sale code" value="" name="sale_code">
                                <input type="submit" value="submit" name="sale_code" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; height: 100%; width: 17%; display: flex; justify-content: center; align-items: center;">
                            </div>
                        </div>            
                    </div>
                </form>
                <hr>
                <div>
                    Tạm tính: 
                    <span style="float: right">2.500.000</span>
                </div>
                <div>
                    Phí vận chuyển: 
                    <span style="float: right">30.000</span>
                </div>
                <hr>
                <div>
                    Tổng Cộng:
                    <span style="float: right">2.530.000</span>
                </div>
                <br>
                <br>
                <div style="display: flex; justify-content: space-around">
                    <a href=""><input type="button" value="Tiếp tục mua sắm" style="border: 3px solid black; border-radius: 5px;width: 200px; height: 50px; background-color: black; color: white;font-size: 18px; "> </a>
                    <input type="submit" value="Thanh toán" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 18px; padding: 0px;"> 
                </div>
            </div>
        </form>
        <!--end content-->

        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
    </body>
</html>

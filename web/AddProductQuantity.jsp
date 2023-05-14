<%-- 
    Document   : AddProductQuantity
    Created on : Mar 20, 2023, 12:38:31 AM
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
        <%@include file="HeaderAdmin.jsp"%> 
        <!--end header-->
        <div style="text-align: center;">
            <b style="font-size: 40px;">ADD PRODUCT QUANTITY</b>
        </div>
        <form action="addquantity" method="post">
            <div style="border: 3px solid black; width: 80%; height: auto; margin-left: auto; margin-right: auto; margin-top: 85px; padding: 40px">
                <div>
                    <div style="font-size: 25px;">Số lượng:</div>
                    <div style="font-size: 25px; height: 30px;" > 
                        <input type="number" required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" placeholder="enter shoes quantity" value="" name="numberOfShoes">
                        <div style="color: red; font-size: 15px;">${numberOfShoesError}</div>
                    </div> 
                </div>
                <div>
                    <div style="font-size: 25px;">Ngày nhập:</div>
                    <div style="font-size: 25px; height: 30px;" > 
                        <input type="date" required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" placeholder="enter date import" value="" name="dateImport">
                        <input type="time" required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" placeholder="enter time import" value="" name="timeImport">
                        <div style="color: red; font-size: 15px;">${dateImportError}</div>
                    </div> 
                </div>
                <br>                    
                <br>
                <div style="text-align: center">
                    <input type="submit" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 25px;" value="Add">
                    <div style="color: red; font-size: 25px;">${notification}</div>
                </div>
            </div> 
        </form>
        <br>
        <br>
        <br>
        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->

        <script>
            var today = new Date();
            var date = today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
            var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
            var dateTime = date + ' ' + time;
            document.getElementById("datetime").innerHTML = dateTime;
        </script>
    </body>
</html>

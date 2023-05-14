<%-- 
    Document   : ImportHistory
    Created on : Mar 20, 2023, 9:51:10 AM
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
        <div style="border: 3px solid black; width: 80%; height: auto; margin-left: auto; margin-right: auto; margin-top: 85px; padding: 40px">
            <div id="image" style="height: 300px; width: 300px; margin-left: auto; margin-right: auto">
                <img src="imageProject/${sh.img}" alt="image" style="width: 300px; height: 300px"/>
            </div>
            <div>
                <div style="font-size: 25px;">shoes Code:</div>
                <div style="font-size: 25px; height: 30px;" > 
                    <input type="text" readonly="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" placeholder="" value="${sh.code}" name="shoesCode">
                </div> 
            </div>
            <br>
            <br>
            <c:forEach items="${listImportHistory}" var="lh">
                <div>
                    <div style="font-size: 25px;">Số lượng:</div>
                    <div style="font-size: 25px; height: 30px;" > 
                        <input type="number" required="" readonly="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" placeholder="enter shoes quantity" value="${lh.quantity}" name="numberOfShoes">
                    </div> 
                </div>
                <div>
                    <div style="font-size: 25px;">Ngày nhập:</div>
                    <div style="font-size: 25px; height: 30px;" > 
                        <input type="date" required="" readonly="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" value="${lh.dateAdd}" name="dateImport">
                        <input type="time" required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" value="${lh.getTime()}" name="timeImport">
                    </div> 
                </div>
                <br>
                <br>
                <br>
                <br>
            </c:forEach>
        </div> 
        <br>
        <br>
        <br>
        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
    </body>
</html>

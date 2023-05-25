<%-- 
    Document   : brandDetail
    Created on : Mar 17, 2023, 8:59:10 PM
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
            <b style="font-size: 40px;">UPDATE BRAND</b>
        </div>
        <form action="dofunction" method="post" enctype="multipart/form-data" style="display: flex; align-items: center">
            <div style="border: 3px solid black; width: 80%; height: auto; margin-left: auto; margin-right: auto; margin-top: 85px; padding: 40px">

                <div style="font-size: 25px;" >
                    Brand name:
                    <br>
                    <input type="text" required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter brand name" value="${b.name}" name="brandName">
                    <div style="color: red; font-size: 15px;">${brandNameError}</div>
                </div> 
                <br>
                <br>
                <div style="font-size: 25px;" >
                    Brand detail:
                    <br>
                    <textarea required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 200px;" placeholder="enter brand detail" name="shoesDetail">${b.detail}</textarea>
                    <div style="color: red; font-size: 15px;">${brandDetailError}</div>
                </div> 
                <br><br>
                <div style="font-size: 25px;" >
                    Brand image:
                    <br>
                    <div style="display: flex; justify-content: space-between">
                        <img src="imageProject/${b.img}" alt="shoes image" style="width: 150px; height: 150px;"/>
                        <input type="file" name="newImg" />
                        <input type="hidden" name="oldImg" value="${b.img}" >
                    </div>
                </div>
                <input type="hidden" name="func" value="updateBrand">
                <input type="hidden" name="brandId" value="${b.id}">
                <br>
                <div style="text-align: center">
                    <input type="submit" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 25px;" value="update">
                    <div style="color: red; font-size: 25px;">${notification}</div>
                </div>
            </div>
        </form>
        <br><br>
        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
    </body>
</html>

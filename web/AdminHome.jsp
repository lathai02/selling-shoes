<%-- 
    Document   : Admin
    Created on : Mar 9, 2023, 2:23:34 PM
    Author     : lathai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>

        <style>
            .active, .btn:hover{
                background-color: #856224 !important;
                border-radius: 0px;
            }

            .dropbtn {
                background-color: black;
                color: white;
                padding: 16px;
                font-size: 20px;
                border: none;
                cursor: pointer;
            }

            .dropdown {
                position: relative;
                display: inline-block;
            }

            .dropdown-content {
                display: none;
                position: absolute;
                background-color: black;
                box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
                z-index: 1;
                box-sizing: content-box;
            }

            .dropdown-content a {
                padding-left: 20px;
                padding-top: 15px;
                color: white;
                height: 100%;
                box-sizing: border-box;
                border: 3px solid black;
                text-decoration: none;
                display: block;
                background-color: black;
                margin-top: 0px;
            }

            .dropdown-content a:hover {
                background-color: #856224;
                color: white;
            }

            .dropdown:hover .dropdown-content {
                display: block;
            }

            .dropdown:hover .dropbtn {
                background-color: #856224;
            }

            td{
                border:3px solid black !important;
            }


            .delete:hover{
                background-color: #856224 !important;
            }
        </style>
    </head>
    <body>
        <%String mod = "";
            if(request.getAttribute("mod") != null){
                mod = (String)request.getAttribute("mod");
            }           
        %>
        <!--header-->
        <%@include file="HeaderAdmin.jsp"%> 
        <!--end header-->
        <div id="user_account" style="padding: 20px;">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-3">
                        <h2 >
                            <c:if test="${sessionScope.accountUser != null}">
                                Xin chào, ${sessionScope.accountUser.name}!
                            </c:if>
                        </h2>
                        <div id="left_side_bar" style="background-color: black; width: 300px; height:auto; border: none" >
                            <div id="myDIV" style="width: 100%; border-radius:0px; height: auto; margin: 0px;">
                                <div class="dropdown" style="width: 100%; height: 100%">
                                    <div style="display: flex; flex-direction: column">
                                        <button class="dropbtn" style="width: 100%; border: 3px solid black">Quản lý khách hàng</button>
                                        <div class="dropdown-content" style="width: 100%; margin-left: 301px; height: 100%; margin-top: 0px;">
                                            <a href="adminfunction?mod=1">xóa khách hàng</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="dropdown" style="width: 100%; height: 100%">
                                    <div style="display: flex; flex-direction: column">
                                        <button class="dropbtn" style="width: 100%; border: 3px solid black">Quản lý sản phẩm</button>

                                        <div class="dropdown-content" style="width: 100%; margin-left: 301px; height: 100%; margin-top: 0px;">
                                            <a href="adminfunction?mod=4">Thêm sản phẩm</a>
                                            <a href="adminfunction?mod=2">xóa, sửa sản phẩm</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="dropdown" style="width: 100%; height: 100%">
                                    <div style="display: flex; flex-direction: column">
                                        <button class="dropbtn" style="width: 100%; border: 3px solid black">Quản lý brands</button>

                                        <div class="dropdown-content" style="width: 100%; margin-left: 301px; height: 100%; margin-top: 0px;">
                                            <a href="adminfunction?mod=7">Thêm brand</a>
                                            <a href="adminfunction?mod=5">xóa, sửa brand</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="dropdown" style="width: 100%; height: 100%">
                                    <div style="display: flex; flex-direction: column">
                                        <button class="dropbtn" style="width: 100%; border: 3px solid black">Quản lý kho</button>
                                        <div class="dropdown-content" style="width: 100%; margin-left: 301px; height: 100%; margin-top: 0px;">
                                            <a href="adminfunction?mod=8">thêm số lượng sản phẩm</a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-9">
                        <%if(mod.equals("2")){%>
                        <table border="3" style="height: 100%; width: 100%">
                            <tr>
                                <td>Code</td>
                                <td>Name</td>
                                <td>Size</td>
                                <td>BrandName</td>
                                <td>Color</td>
                                <td>Gender</td>
                                <td>Image</td>
                            </tr>
                            <c:forEach items="${listShoes}" var="sh">
                                <tr>
                                    <td><a href="adminfunction?mod=3&shoesCode=${sh.getCode()}">${sh.getCode()}</a></td>
                                    <td>${sh.getName()}</td>
                                    <td>${sh.getSize()}</td>
                                    <td>${sh.getBrandNameById(sh.getBrandId())}</td>
                                    <td>${sh.getColor()}</td>
                                    <td>${sh.getGender()}</td>
                                    <td style="width: 150px;"><img src="imageProject/${sh.getImg()}" alt="shoes" style="width: 150px; height: 150px;"/></td>
                                    <td style="padding: 0px;"><a href="dofunction?func=deleteProduct&shoesCode=${sh.getCode()}&shoesId=${sh.getId()}"><input type="button" value="delete" style="width: 100%; height: 100%; color: white;background-color: black" class="delete"></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <%}%>
                        <%if(mod.equals("1")){%>
                        <table border="3" style="height: 100%; width: 100%">
                            <tr>
                                <td>ID</td>
                                <td>Name</td>
                                <td>Gender</td>
                                <td>DOB</td>
                                <td>Email</td>
                                <td>Phone number</td>
                                <td>Address</td>
                                <td>Account</td>
                            </tr>
                            <c:forEach items="${listUser}" var="u">
                                <tr>
                                    <td>${u.getId()}</td>
                                    <td>${u.getName()}</td>
                                    <td>${u.getGender()}</td>
                                    <td>${u.getDob()}</td>
                                    <td>${u.getEmail()}</td>
                                    <td>${u.getPhoneNumber()}</td>
                                    <td>${u.getAddress()}</td>
                                    <td>${u.getAccount()}</td>
                                    <td style="padding: 0px;"><a href="dofunction?func=deleteUser&id=${u.getId()}"><input type="button" value="delete" style="width: 100%; height: 100%; color: white;background-color: black" class="delete"></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <%}%>
                        <%if(mod.equals("6")){%>
                        <table border="3" style="height: 100%; width: 100%">
                            <tr>
                                <td>ID</td>
                                <td>Name</td>
                                <td>Detail</td>
                                <td>Image</td>
                            </tr>
                            <c:forEach items="${listBrandforUpdateBrand}" var="b">
                                <tr>
                                    <td><a href="adminfunction?mod=6&id=${b.getId()}">${b.getId()}</a></td>
                                    <td>${b.getName()}</td>
                                    <td>${b.getDetail()}</td>
                                    <td><img src="imageProject/${b.getImg()}" alt="shoes" style="width: 150px; height: 150px;"/></td>
                                    <td style="padding: 0px;"><a href="dofunction?func=deleteBrand&id=${b.getId()}"><input type="button" value="delete" style="width: 100%; height: 100%; color: white;background-color: black" class="delete"></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <%}%>
                        <%if(mod.equals("8")){%>
                        <table border="3" style="height: 100%; width: 100%">
                            <tr>
                                <td>Code</td>
                                <td>Image</td>

                            </tr>
                            <c:forEach items="${listShoes}" var="sh">
                                <tr>
                                    <td><a href="adminfunction?mod=9&shoesId=${sh.getId()}">${sh.getCode()}</a></td>
                                    <td style="width: 150px;"><img src="imageProject/${sh.getImg()}" alt="shoes" style="width: 150px; height: 150px;"/></td>
                                    <td style="padding: 0px;"><a href="dofunction?func=addQuantity&shoesId=${sh.getId()}"><input type="button" value="Add quantity" style="width: 100%; height: 100%; color: white;background-color: black"></a></td>
                                </tr>
                            </c:forEach>
                        </table>
                        <%}%>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <br>
        <br>
        <br>
        <br>
        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
    </body>
</html>

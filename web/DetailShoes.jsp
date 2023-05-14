<%-- 
    Document   : DetailShoes
    Created on : Mar 16, 2023, 3:34:31 PM
    Author     : lathai
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Shoes" %>
<%@page import="Model.Brand" %>
<%@page import="java.util.ArrayList" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/NewCss.css"/>
        <title>JSP Page</title>
    </head>
    <body>

        <%
            Shoes sh = new Shoes();
            if( request.getAttribute("sh")  !=  null){
                sh = (Shoes)request.getAttribute("sh");
            }
        %>
        <%
                        String opsColor = sh.getColor() + "";
                        String optionsColor [] = {"","Red","Orange","Yellow", "Green", "Blue", "Purple", "White", "Galaxy Blue", "Black", "Pink", "Grey"};
                        String selectedColor [] = new String[optionsColor.length];;
                        for(int i = 0 ; i < optionsColor.length ; i++){
                            if(optionsColor[i].equals(opsColor)){
                                selectedColor[i] = "selected";
                            }
                        }
        %>
        <%
                        String opsSize = (String) sh.getSize();
                        String optionsSize [] = {"","35.0","36.0","37.0", "38.0", "39.0", "40.0", "41.0", "42.0", "43.0", "44.0", "45.0", "46.0"};
                        String selectedSize [] = new String[optionsSize.length];;
                        for(int i = 0 ; i < optionsSize.length ; i++){
                            if(optionsSize[i].equals(opsSize)){
                                selectedSize[i] = "selected";
                            }
                        }
        %>
        <%
                        String opsGender = (String) sh.getGender();
                       
                        String optionsGender [] = {"","1","0"};
                        String selectedGender [] = new String[optionsGender.length];
                        for(int i = 0 ; i < optionsGender.length ; i++){
                            if(optionsGender[i].equals(opsGender)){
                                selectedGender[i] = "selected";
                            }
                        }
        %>
        <!--header-->
        <%@include file="HeaderAdmin.jsp"%> 
        <!--end header-->
        <div style="text-align: center;">
            <b style="font-size: 40px;">UPDATE PRODUCT</b>
        </div>
        <br>
        <form action="dofunction" method="post" enctype="multipart/form-data" style="display: flex; align-items: center">
            <div style="border: 3px solid black; width: 80%; height: auto; margin-left: auto; margin-right: auto; margin-top: 85px; padding: 40px">
                <div>
                    <div style="font-size: 25px;">Shoes origin:</div>
                    <div style="font-size: 25px; height: 30px;" > 
                        <input type="text" required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 100%;" placeholder="enter shoes origin" value="${sh.origin}" name="shoesOrigin">
                        <div style="color: red; font-size: 15px;">${shoesOriginError}</div>
                    </div> 
                </div>
                <br>
                <div style="font-size: 25px;" >
                    Shoes detail:
                    <br>
                    <input type="text" required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter shoes detail" value="${sh.detail}" name="shoesDetail">
                    <div style="color: red; font-size: 15px;">${shoesDetailError}</div>
                </div> 
                <br>
                <div style="font-size: 25px;" >
                    Shoes name:
                    <br>
                    <input type="text" required="" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter your shoes name" value="${sh.name}" name="shoesName">
                    <div style="color: red; font-size: 15px;">${shoesNameError}</div>
                </div>
                <br>
                <div style="font-size: 25px;" >
                    Shoes color:
                    <div style="text-align: center">
                        <div class="custom-select" style="width:100%;" required="">
                            <%
                            int iColor = 0;
                            %>
                            <select style="border: 3px solid black; border-radius: 5px; width: 100%; height: 30px;" name = "shoesColor">
                                <option value="" <%=selectedColor[iColor]%>>choose color</option>
                                <option value="Red" <%=selectedColor[++iColor]%>>Red</option>
                                <option value="Orange" <%=selectedColor[++iColor]%>>Orange</option>
                                <option value="Yellow" <%=selectedColor[++iColor]%>>Yellow</option>
                                <option value="Green" <%=selectedColor[++iColor]%>>Green</option>
                                <option value="Blue" <%=selectedColor[++iColor]%>>Blue</option>
                                <option value="Purple" <%=selectedColor[++iColor]%>>Purple</option>
                                <option value="White" <%=selectedColor[++iColor]%>>White</option>
                                <option value="Galaxy Blue" <%=selectedColor[++iColor]%>>Galaxy Blue</option>
                                <option value="Black" <%=selectedColor[++iColor]%>>Black</option>
                                <option value="Pink" <%=selectedColor[++iColor]%>>Pink</option>
                                <option value="Grey" <%=selectedColor[++iColor]%>>Grey</option>
                            </select>
                        </div>                
                    </div>
                    <div style="color: red; font-size: 15px;">${genderError}</div>
                </div>
                <div style="font-size: 25px;" >
                    Shoes Price:
                    <br>
                    <input required="" type="number" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter shoes price" value="${sh.price}" name="shoesPrice">
                    <div style="color: red; font-size: 15px;">${shoesPriceError}</div>
                </div>
                <div style="font-size: 25px;" >
                    Shoes image:
                    <br>
                    <div style="display: flex; justify-content: space-between">
                        <img src="imageProject/${sh.img}" alt="shoes image" style="width: 150px; height: 150px;"/>
                        <input type="file" name="newImg" />
                        <input type="hidden" name="oldImg" value="${sh.getImg()}" >
                    </div>
                </div>
                <br>
                <div style="font-size: 25px;" >
                    Shoes size: 
                    <div style="text-align: center">
                        <div class="custom-select" style="width:100%;">
                            <%
                            int iSize = 0;
                            %>
                            <select style="border: 3px solid black; border-radius: 5px; width: 100%; height: 30px;" name = "shoesSize" required="">
                                <option value="" <%=selectedSize[iSize]%>>choose size</option>
                                <option value="35" <%=selectedSize[++iSize]%>>35</option>
                                <option value="36" <%=selectedSize[++iSize]%>>36</option>
                                <option value="37" <%=selectedSize[++iSize]%>>37</option>
                                <option value="38" <%=selectedSize[++iSize]%>>38</option>
                                <option value="39" <%=selectedSize[++iSize]%>>39</option>
                                <option value="40" <%=selectedSize[++iSize]%>>40</option>
                                <option value="41" <%=selectedSize[++iSize]%>>41</option>
                                <option value="42" <%=selectedSize[++iSize]%>>42</option>
                                <option value="43" <%=selectedSize[++iSize]%>>43</option>
                                <option value="44" <%=selectedSize[++iSize]%>>44</option>
                                <option value="45" <%=selectedSize[++iSize]%>>45</option>
                                <option value="46" <%=selectedSize[++iSize]%>>46</option>
                            </select>
                        </div>                
                    </div>
                    <div style="color: red; font-size: 15px;">${genderError}</div>
                </div>
                <br>
                <div style="font-size: 25px;" >
                    shoes gender:
                    <div style="text-align: center">
                        <div class="custom-select" style="width:100%;">
                            <%
                            int iGender = 0;
                            %>
                            <select style="border: 3px solid black; border-radius: 5px; width: 100%; height: 30px;" name = "shoesGender" required="">
                                <option value="" <%=selectedGender[iGender]%>>choose gender</option>
                                <option value="1" <%=selectedGender[++iGender]%>>male</option>
                                <option value="0" <%=selectedGender[++iGender]%>>female</option>
                            </select>
                        </div>                
                    </div>
                    <div style="color: red; font-size: 15px;">${shoesGenderError}</div>
                </div>
                <br>
                <div style="font-size: 25px;" >
                    shoes discount:
                    <br>
                    <input required="" type="text" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter shoes discount" value="${sh.getDiscount()}" name="shoesDiscount">
                    <div style="color: red; font-size: 15px;">${shoesDiscountError}</div>
                </div>
                <br>
                <div style="font-size: 25px;" >
                    shoes decription:
                    <br>
                    <input required="" type="text" style="box-sizing: border-box; border: 3px solid black; border-radius: 5px; width: 100%; height: 29px;" placeholder="enter shoes decription" value="${sh.getDecription()}" name="shoesDecription">
                    <div style="color: red; font-size: 15px;">${shoesDecriptionError}</div>
                </div>
                <br>
                <div style="font-size: 25px;" >
                    brand Name:
                    <div style="text-align: center">
                        <div class="custom-select" style="width:100%;">
                            <select style="border: 3px solid black; border-radius: 5px; width: 100%; height: 30px;" name = "brandName" required="">
                                <option value="" >choose brand</option>
                                <c:forEach items="${listBrand}" var="b">
                                    <option value="${b.getId()}" <c:if test="${b.getId().equals(sh.getBrandId())}">selected</c:if>>${b.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>                
                    </div>
                    <div style="color: red; font-size: 15px;">${genderError}</div>
                </div>
                <input type="hidden" name="func" value="updateProduct">
                <div style="text-align: center">
                    <input type="submit" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 25px;" value="update">
                    <div style="color: red; font-size: 25px;">${notification}</div>
                </div>
            </div>
            <input type="hidden" name="shoesCode" value="${sh.getCode()}">
            <input type="hidden" name="userId" value="${sh.getUserId()}">
            <input type="hidden" name="stockQuantity" value="${sh.getStockQuantity()}">
            <input type="hidden" name="shoesId" value="${sh.getId()}">

        </form>
        <br>
        <br>
        <br>
        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
    </body>
</html>

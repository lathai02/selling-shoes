<%-- 
    Document   : addProduct
    Created on : Mar 17, 2023, 3:20:47 AM
    Author     : lathai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="Css/NewCss.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <!--header-->
        
        <%@include file="HeaderAdmin.jsp"%> 
        <!--end header--> 
        <div style="text-align: center;">
            <b style="font-size: 40px;">ADD PRODUCT</b>
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
                            <select style="border: 3px solid black; border-radius: 5px; width: 100%; height: 30px;" name = "shoesColor">
                                <option value="">choose color</option>
                                <option value="Red" <c:if test="${sh.color.equals('Red')}"> selected</c:if>>Red</option>
                                <option value="Orange" <c:if test="${sh.color.equals('Orange')}"> selected</c:if>>Orange</option>
                                <option value="Yellow" <c:if test="${sh.color.equals('Yellow')}"> selected</c:if>>Yellow</option>
                                <option value="Green" <c:if test="${sh.color.equals('Green')}"> selected</c:if>>Green</option>
                                <option value="Blue" <c:if test="${sh.color.equals('Blue')}"> selected</c:if>>Blue</option>
                                <option value="Purple" <c:if test="${sh.color.equals('Purple')}"> selected</c:if>>Purple</option>
                                <option value="White" <c:if test="${sh.color.equals('White')}"> selected</c:if>>White</option>
                                <option value="Galaxy Blue" <c:if test="${sh.color.equals('Galaxy Blue')}"> selected</c:if>>Galaxy Blue</option>
                                <option value="Black" <c:if test="${sh.color.equals('Black')}"> selected</c:if>>Black</option>
                                <option value="Pink" <c:if test="${sh.color.equals('Pink')}"> selected</c:if>>Pink</option>
                                <option value="Grey" <c:if test="${sh.color.equals('Grey')}"> selected</c:if>>Grey</option>

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
                        <img src="imageProject/${sh.img}" style="width: 150px; height: 150px;"/>
                        <input type="file" name="newImg" />
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
                                <option value="">choose size</option>
                                <option value="35" <c:if test="${sh.size.equals('35')}"> selected</c:if>>>35</option>
                                <option value="36" <c:if test="${sh.size.equals('36')}"> selected</c:if>>36</option>
                                <option value="37" <c:if test="${sh.size.equals('37')}"> selected</c:if>>37</option>
                                <option value="38" <c:if test="${sh.size.equals('38')}"> selected</c:if>>38</option>
                                <option value="39" <c:if test="${sh.size.equals('39')}"> selected</c:if>>39</option>
                                <option value="40" <c:if test="${sh.size.equals('40')}"> selected</c:if>>40</option>
                                <option value="41" <c:if test="${sh.size.equals('41')}"> selected</c:if>>41</option>
                                <option value="42" <c:if test="${sh.size.equals('42')}"> selected</c:if>>42</option>
                                <option value="43" <c:if test="${sh.size.equals('43')}"> selected</c:if>>43</option>
                                <option value="44" <c:if test="${sh.size.equals('44')}"> selected</c:if>>44</option>
                                <option value="45" <c:if test="${sh.size.equals('45')}"> selected</c:if>>45</option>
                                <option value="46" <c:if test="${sh.size.equals('46')}"> selected</c:if>>46</option>
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

                            <select style="border: 3px solid black; border-radius: 5px; width: 100%; height: 30px;" name = "shoesGender" required="">
                                <option value="" >choose gender</option>
                                <option value="1" <c:if test="${sh.gender.equals('1')}"> selected</c:if>>male</option>
                                <option value="0" <c:if test="${sh.gender.equals('0')}"> selected</c:if>>female</option>
                                </select>
                            </div>                
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
                                        <option value="${b.getId()}" <c:if test="${sh.brandId.equals(b.getId())}"> selected</c:if>>${b.getName()}</option>
                                    </c:forEach>
                                </select>
                            </div>                
                        </div>
                        <div style="color: red; font-size: 15px;">${genderError}</div>
                    </div>
                    <input type="color" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 25px;"name="color">

                    <input type="hidden" name="func" value="addProduct">
                    <div style="text-align: center">
                        <input type="submit" style="border: 3px solid black; border-radius: 5px;width: 100px; height: 50px; background-color: black; color: white;font-size: 25px;" value="Add">
                        <div style="color: red; font-size: 25px;">${notification}</div>
                    </div>
                </div>
            </div>

        </form>
        <br>
        <br>
        <br>
        <!--footer-->
        <%@include file="Footer.jsp"%> 
        <!--end footer-->
    </body>
</html>

<%-- 
    Document   : Footer
    Created on : Mar 3, 2023, 4:13:43 AM
    Author     : lathai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Footer</title>  
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="Css/NewCss.css"/>
    </head>
    <body>
        <!--footer-->
        <div id="footer">
            <div id="logo-Footer">
                <a href=""><img src="imageProject\22.png" alt="logo footer"/></a>
            </div>

            <div class="flex_footer" style="height: 65px;">
                <div id="address" style="display: flex; justify-content: center; align-items: center; height: 100%; flex-direction: column">
                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                    <div>${shop.address}</div>
                </div>
                <div id="phone_number" style="display: flex; justify-content: center; align-items: center; flex-direction: column">
                    <i class="fa fa-phone-square" aria-hidden="true"></i>
                    <div >${shop.phoneNumber}</div>
                </div>
                <div id="email" style="display: flex; justify-content: center; align-items: center; flex-direction: column">
                    <i class="fa fa-envelope" aria-hidden="true"></i>
                    <div >${shop.email}</div>
                </div>
            </div>

            <div class="flex_footer">
                <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m12!1m3!1d29793.6391338335!2d105.53980095!3d21.02448625!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!5e0!3m2!1sen!2s!4v1677790616963!5m2!1sen!2s" width="500" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                <iframe src="https://www.facebook.com/plugins/page.php?href=https%3A%2F%2Fwww.facebook.com%2FToiBanGiayBrand&tabs=timeline&width=500&height=300&small_header=true&adapt_container_width=true&hide_cover=false&show_facepile=false&appId" width="500" height="300" style="border:none;overflow:hidden" scrolling="no" frameborder="0" allowfullscreen="true" allow="autoplay; clipboard-write; encrypted-media; picture-in-picture; web-share"></iframe>
            </div>
            <div id="author" style="text-align: center; font-size: 20px; color: whitesmoke; padding: 15px;" >
                Author
                <br>
                thailahe161592
                <br>
                <br>
                contact with me
                <br>
                <div style="display: flex; justify-content: space-around">
                    <div>
                        <a href="https://www.facebook.com/lathai1611" style="color: whitesmoke"><i class="fa fa-facebook" aria-hidden="true" style="color: whitesmoke"></i><br>lathai1611</a>
                    </div>
                    <div>
                        <a href="https://mail.google.com/mail/u/2/#inbox?compose=GTvVlcSMSqVrJTHPSdmFClHQbBCgrMRWtszprGplFfTfDcCBKDjlRhfLQqkRMHmZHLHbZLVmJRjWW" style="color: whitesmoke">
                            <i class="fa fa-envelope-o" aria-hidden="true"></i><br>
                            leanthai02@gmail.com
                        </a>
                    </div>
                    <div>
                        <i class="fa fa-mobile" aria-hidden="true"></i><br>
                        0966132094
                    </div>
                </div>
            </div>
        </div>
        <!--end footer-->
    </body>
</html>

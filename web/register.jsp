<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Fashi Template">
        <meta name="keywords" content="Fashi, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Registration</title>
        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/themify-icons.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>

    <body>

        <%@include file="header.jsp" %>
        <!-- Register Section Begin -->
        <div class="register-login-section spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 offset-lg-3">
                        <div class="register-form">
                            <h2>Registration</h2>
                            <form action="MainController" method="post"> 
                                <div class="group-input">
                                    <label for="userID">User ID*</label>
                                    <input type="text" id="userID" name="txtUserID" value=""/>
                                    ${requestScope.USERID_EMPTY}

                                </div>
                                <div class="group-input">
                                    <label for="username">User name*</label>
                                    <input type="text" id="username" name="txtUserName" value=""/>
                                    ${requestScope.USERNAME_EMPTY}

                                </div>
                                <div class="group-input">
                                    <label for="pass">Password *</label>
                                    <input type="password" id="pass" name="txtPassword"/>
                                    ${requestScope.PASSWORD_EMPTY}
                                </div>
                                <div class="group-input">
                                    <label for="con-pass">Confirm Password *</label>
                                    <input type="password" id="con-pass" name="txtRePassword" value=""/>
                                    ${requestScope.PASSWORD_NOT_SAME}
                                </div>
                                <button type="submit" class="site-btn register-btn" name="btnAction" value="Register">REGISTER</button>
                            </form>
                            <div class="text-center justify-content-center"">
                                <h3>${requestScope.REGISTRATION_ERROR}</h3>
                            </div>
                            <div class="text-center justify-content-center"">
                                <h3>${requestScope.DUPLICATE_ID}</h3>
                            </div>
                           
                            <div class="switch-login">
                                <c:url var="login_Page" value="MainController">
                                    <c:param name="btnAction" value="Login Page"></c:param>
                                </c:url>
                                <a href="${login_Page}" class="or-login">Or Login</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <%@include file="footer.jsp" %>

    </body>

</html>
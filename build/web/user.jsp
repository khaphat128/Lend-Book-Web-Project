<%-- 
    Document   : user
    Created on : Jun 22, 2020, 10:40:53 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Welcome: ${sessionScope.USER.getUserName}</h1>
    </body>
</html>

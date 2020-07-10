<%-- 
    Document   : insertBook
    Created on : Jul 7, 2020, 1:06:00 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert A Type Of Book Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    </head>
    <body>
        <div class="container text-center">
            <h3 class="text-danger">Create Book</h3>
        </div>
        <form action="MainController" method="post" class="container" style="width: 50%">
            <div class="form-group">
                Image link:<input type="file" name="txtImage" value="" class="form-control"/><br>
                
            </div>
            <div class="form-group">
                Title:<input type="text" name="txtTitle" value=""class="form-control"/><br>
                
            </div>
            <div class="form-group">
                Price:<input type="number" step="0.5" name="txtPrice" min="1" max="100" value="" class="form-control"/><br>
                <h4 class="text-danger">${requestScope.PRICE_ERROR}</h4>
            </div>
            <div class="form-group">
                Description:<input type="text" name="txtDescription" value="" class="form-control"/><br>

            </div>
            <div class="form-group">
                Available Amount:<input type="number" name="txtTotalAmount" min="1" max="100" value="" class="form-control"/><br>

            </div>
            <div class="form-group">
                <button type="submit" name="btnAction" value="Insert_Book_Controller" class="form-control btn btn-success">Insert</button>
            </div>
        </form>
    </body>
</html>

<%-- 
    Document   : UpdateBook
    Created on : Jul 8, 2020, 1:29:21 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Book Page</title>
    </head>
    <body>

        <form action="MainController" method="post" class="container" style="width: 50%">

            <input type="text" name="bookID" value="${param.bookID}" readonly=""/><br>

            <div class="form-group">
                Image link:<input type="file" name="txtImage" value="" class="form-control"/><br>
                ${requestScope.ERROR}<br>
            </div>
            <div class="form-group">
                Title:<input type="text" name="txtTitle" value="${param.title}"class="form-control"/><br>
                ${requestScope.ERROR}<br>
            </div>
           
            <div class="form-group">
                Price:<input type="number" step="0.5" name="txtPrice" min="1" max="100" value="${param.price}" class="form-control"/><br>
                ${requestScope.ERROR}<br>
            </div>
            <div class="form-group">
                Description:<input type="text" name="txtDescription" value="${param.description}" class="form-control"/><br>
                ${requestScope.ERROR}<br>
            </div>
            <div class="form-group">
                Total Amount:<input type="number" name="txtTotalAmount" min="1" max="100" value="${param.totalAmount}" class="form-control"/><br>
                ${requestScope.ERROR}<br>
            </div>

            <div class="form-group">
                Available Amount:<input type="number" name="txtAvailableAmount" min="1" max="100" value="" class="form-control"/><br>
                ${requestScope.ERROR}<br>
            </div>
            <div class="form-group">
                <button type="submit" name="btnAction" value="Update Book" class="form-control btn btn-success">Update</button>
            </div>

        </form>


    </body>
</html>

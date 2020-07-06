<%-- 
    Document   : show-book
    Created on : Jul 4, 2020, 10:46:21 PM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Book Page</title>
    </head>
    <body>
        <h1>Welcome: ${sessionScope.USER.userName}</h1>
        <table border="1">
            <thead>
                <tr>                    
                    <th>No</th>
                    <th>Book ID</th>
                    <th>Image</th>
                    <th>Title</th>
                    <th>Price</th>
                    <th>totalAmount</th>
                    <th>availableAmount</th>
                    <th>Status</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="dto" items="${requestScope.LIST_BOOK}" varStatus="counter">
                    <tr>
                        <td>${counter.count}</td>
                        <td>${dto.bookID}</td>
                        <td>
                            <img src="${dto.image}" alt="alternatetext">
                        </td>
                        <td>${dto.title}</td>
                        <td>${dto.price}</td>
                        <td>${dto.totalAmount}</td>
                        <td>${dto.availableAmount}</td>
                        <td>${dto.status}</td>

                <img src="${dto.image}" alt="alternatetext">

                </tr>
                </tbody>
            </c:forEach>

        </table>

    </body>
</html>

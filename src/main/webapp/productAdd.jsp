<%-- 
    Document   : productAdd
    Created on : Oct 22, 2024, 7:17:32 PM
    Author     : ccull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
    </head>
    <body>
<form action="ProductServlet" method="post">
    <input type="hidden" name="action" value="${action}"> <%--sets action attribute --%>
    <label>Code:</label>
    <input type="text" name="code" value="${product.code}"><br>
    <label>Description:</label>
    <input type="text" name="description" value="${product.description}"><br>
    <label>Price:</label>
    <input type="text" name="price" value="${product.price}"><br>
    <input type="submit" value="Save">
</form>
    </body>
</html>

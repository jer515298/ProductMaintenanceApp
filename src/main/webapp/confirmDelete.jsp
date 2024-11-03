<%-- 
    Document   : confirmDelete
    Created on : Oct 22, 2024, 7:18:19 PM
    Author     : ccull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="music.business.Product"%> <!-- import your Product class -->

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Product</title>
    </head>
    <body>
        <h3>Are you sure you want to delete this product?</h3>
        
        <p><strong>Code:</strong> ${product.code}</P>
        <p><strong>Description:</strong> ${product.description}</P>
        <p><strong>Price: $</strong>${product.price}</P>

        <form action="ProductServlet" method="post">
            <input type="hidden" name="action" value="confirmDelete">
            <input type="hidden" name="code" value="${product.code}">
            <input type="submit" value="Confirm Delete">
        </form>
        <form action="ProductServlet" method="get"> <!--Cancel deletion, return with action=list -->
            <input type="hidden" name="action" value="list">
            <input type="submit" value="Cancel">
        </form>
    </body>
</html>

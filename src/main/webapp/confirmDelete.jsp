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
        <title>Delete Product - Product Maintenance Application</title>
    </head>
    <body>
        <header>
            <h1>Product Maintenance Application</h1>
            <h3>Are you sure you want to delete this product?</h3>
        </header>
        
        <div id="formContainer">

            <div>
                    <p><strong>Code:</strong> ${product.code}</p>
                    <p><strong>Description:</strong> ${product.description}</p>
                    <p><strong>Price: $</strong>${product.price}</p>
            </div>

            <form action="ProductServlet" method="post">
                <input type="hidden" name="action" value="confirmDelete">
                <input type="hidden" name="code" value="${product.code}">
                <div class="flex">
                    <input type="submit" value="Confirm Delete" style="font-weight: bold;">
                </div>
            </form>
            <form action="ProductServlet" method="get"> <!--Cancel deletion, return with action=list -->
                <input type="hidden" name="action" value="list">
                <div class="flex">
                    <input type="submit" value="Cancel" style="font-weight: bold;">
                </div>
            </form>
        </div>
    </body>
</html>

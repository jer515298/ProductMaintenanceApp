<%-- 
    Document   : products
    Created on : Oct 22, 2024, 7:15:30 PM
    Author     : ccull
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="music.business.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product List</title>
        <link rel="stylesheet" href="styles/main.css">
    </head>
    
        <div>
            <h1>Product Maintenance Application</h1>
        </div>
        <nav>
            <a href="index.html">Home</a>
            <a href="about.xhtml">About</a>
            <a href="contact.html">Contact</a>
            <a href="ProductServlet?action=list">Manage Products</a>
        </nav>
        
        <h2>Product List</h2>
        
        <table border="1">
            <tr>
                <th>Code</th>
                <th>Description</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.code}</td>
                    <td>${product.description}</td>
                    <td>${product.priceCurrencyFormat}</td>
                    <td><a href="ProductServlet?action=edit&code=${product.code}">Edit</a></td>
                    <td><a href="ProductServlet?action=delete&code=${product.code}">Delete</a></td>
                </tr>
            </c:forEach>
            
        </table>
        
        <a href="ProductServlet?action=saveProduct" style="text-align: center">Add Product</a>

            
    
</html>

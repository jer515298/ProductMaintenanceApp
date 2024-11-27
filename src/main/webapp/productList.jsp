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
        <link rel="stylesheet" href="styles/productList.css">
        <script>
            document.addEventListener('DOMContentLoaded', function() {
                var addButton = document.querySelector('a[href="ProductServlet?action=saveProduct"]');
                if (addButton) {
                    addButton.addEventListener('mouseover', function() {
                        addButton.style.backgroundColor = '#0056b3'; // Darker shade of blue
                        addButton.style.transform = 'translateY(-2px)';
                    });
                    addButton.addEventListener('mouseout', function() {
                        addButton.style.backgroundColor = '#007bff';
                        addButton.style.transform = 'translateY(0)';
                    });
                }
            });
        </script>
    </head>
    <body>
        <div class="banner">
            <h1>Product Maintenance Application</h1>
        </div>
        <nav>
            <a href="index.html">Home</a>
            <a href="about.xhtml">About</a>
            <a href="contact.html">Contact</a>
            <a href="ProductServlet?action=list">Manage Products</a>
        </nav>
        <div id="containerMain">
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
            <div style="text-align: center; margin-top: 20px;">
                <a href="ProductServlet?action=saveProduct" style="
                    display: inline-block;
                    padding: 10px 20px;
                    background-color: #007bff; /* Bootstrap primary blue color */
                    color: #fff;
                    text-align: center;
                    text-decoration: none;
                    font-size: 16px;
                    font-weight: bold;
                    border-radius: 5px;
                    transition: background-color 0.3s ease, transform 0.3s ease;
                ">Add Product</a>
            </div>
        </div>
        <footer>
            <p>This website is for educational purposes under the Des Moines Area Community College.</p>
            <p>All images are under fair use or are in public domain.</p>
            <img src="images/Note.png" alt="music note">
        </footer>
    </body>
</html>

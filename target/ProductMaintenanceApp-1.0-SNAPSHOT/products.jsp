<link rel="stylesheet" href="styles/main.css">

<div>
    <h1>Product Maintenance Application</h1>
</div>
<nav>
    <a href="index.html">Home</a>
    <a href="ProductServlet?action=list">Manage Products</a>
</nav>

<h2>Product List</h2>

<table border="1">
    <tr>
        <th>Code</th>
        <th>Description</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.code}</td>
            <td>${product.description}</td>
            <td>${product.priceCurrencyFormat}</td>
            <td>
                <a href="ProductServlet?action=edit&code=${product.code}">Edit</a>
                <a href="ProductServlet?action=delete&code=${product.code}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
            
<a href="ProductServlet?action=add" style="text-align: center">Add Product</a>

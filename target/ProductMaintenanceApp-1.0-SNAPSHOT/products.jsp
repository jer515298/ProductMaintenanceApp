<h2>Product List</h2>
<a href="ProductServlet?action=add">Add Product</a>
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

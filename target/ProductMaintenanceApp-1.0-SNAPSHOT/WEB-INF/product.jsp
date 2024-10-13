<form action="ProductServlet" method="post">
    <input type="hidden" name="action" value="${action}">
    <label>Code:</label>
    <input type="text" name="code" value="${product.code}"><br>
    <label>Description:</label>
    <input type="text" name="description" value="${product.description}"><br>
    <label>Price:</label>
    <input type="text" name="price" value="${product.price}"><br>
    <input type="submit" value="Save">
</form>

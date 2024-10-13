<h3>Are you sure you want to delete the product?</h3>
<form action="ProductServlet" method="post">
    <input type="hidden" name="action" value="confirmDelete">
    <input type="hidden" name="code" value="${product.code}">
    <input type="submit" value="Yes">
    <a href="ProductServlet?action=list">No</a>
</form>

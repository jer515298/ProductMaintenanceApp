<%-- 
    Document   : productAdd
    Created on : Oct 22, 2024, 7:17:32 PM
    Author     : ccull
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="custom" uri="/WEB-INF/customTags.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Product</title>
         <script type="text/javascript">
        function validateForm() {
            // Clear any previous error message
            document.getElementById("error-message").innerText = "";
            document.getElementById("nullCode").innerText = "";
            document.getElementById("nullDescription").innerText = "";
            document.getElementById("nullPrice").innerText = "";

            // Get form field values
            var code = document.forms["productForm"]["code"].value;
            var description = document.forms["productForm"]["description"].value;
            var price = document.forms["productForm"]["price"].value;
            
            // Checks for emtpy fields
            var fieldsFilled = true;
            
            if (code === "") {
                document.getElementById("nullCode").innerText = "*";
                fieldsFilled = false;
            }
            if (description === "") {
                document.getElementById("nullDescription").innerText = "*";
                fieldsFilled = false;
            }
            if (price === "") {
                document.getElementById("nullPrice").innerText = "*";
                fieldsFilled = false;
            }
            
            if (!fieldsFilled) {
            document.getElementById("error-message").innerText = "Please fill in all fields!";
                
            }
            return fieldsFilled;  // Allow form submission if no fields are empty = True
            
            
        }
    </script>
    </head>
    <body>
    <!-- Error message paragraph (initially hidden) -->
    <p id="error-message" style="color:red;"></p>   

        
<form name="productForm" action="ProductServlet" method="post" onsubmit="return validateForm()">
    <input type="hidden" name="action" value="${action}"> <%--sets action attribute --%>

    <label>Code:</label>
    <input type="text" name="code" value="${product.code}">
    <custom:requiredField value="${product.code}"/>
    <p id="nullCode" style="color:red; display: inline;"></p>
    <br>
    
    <label>Description:</label>
    <input type="text" name="description" value="${product.description}">
    <custom:requiredField value="${product.description}"/>
    <p id="nullDescription" style="color:red; display: inline;"></p>
    <br>
    
    <label>Price:</label>
    <input type="text" name="price" value="${product.price}">
    <custom:requiredField value="${product.price}"/>
    <p id="nullPrice" style="color:red; display: inline;"></p>
    <br>
        
    <input type="submit" value="Save">
</form>
    </body>
</html>

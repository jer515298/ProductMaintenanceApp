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
        <title>Add Product - Product Maintenance Application</title>
        <style>
            .labelText {
                 margin: auto;
                display: table;
            }

            .labelText div{
                display: table-row;
            }

            .labelText div label, .labelText div input {
                display: table-cell;
            }
        </style>
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
        <header>
            <h1>Add Product</h1>

            <!-- Error message paragraph (initially hidden) -->
            <p id="error-message" style="color:red;"></p>       
        </header>

        <div id="formContainer">
            <form name="productForm" action="ProductServlet" method="post" onsubmit="return validateForm()">
                <input type="hidden" name="action" value="${action}"> <!--<%--sets action attribute --%>-->
            
                <div class="labelText">
                    <div>
                        <label>Code:</label>
                        <input type="text" name="code" value="${product.code}">
                        <custom:requiredField value="${product.code}"/>
                        <p id="nullCode" style="color:red; display: inline;"></p>
                    </div>
                    <div>
                        <label>Description:</label>
                        <input type="text" name="description" value="${product.description}">
                        <custom:requiredField value="${product.description}"/>
                        <p id="nullDescription" style="color:red; display: inline;"></p>
                    </div>
                    <div>
                        <label>Price:</label>
                        <input type="text" name="price" value="${product.price}">
                        <custom:requiredField value="${product.price}"/>
                        <p id="nullPrice" style="color:red; display: inline;"></p>
                    </div>
                </div>
                    
                <div class="flex">
                    <input type="submit" value="Save" style="font-weight:bold;">
                    <input type="button" value="Cancel" style="font-weight:bold;">
                </div>
            </form>
        </div>
    </body>
</html>

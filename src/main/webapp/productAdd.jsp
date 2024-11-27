<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="custom" uri="/WEB-INF/customTags.tld" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Product</title>
        <style>
            /* General body styling */
            body {
                font-family: Arial, sans-serif;
                background-color: #f0f0f0; /* Light grey background for better contrast */
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            /* Container for the form */
            .form-container {
                background-color: #fff;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                width: 100%;
                max-width: 400px;
            }
            /* Heading styling */
            h1 {
                text-align: center;
                color: #333;
            }
            /* Form group styling */
            .form-group {
                margin-bottom: 15px;
            }
            /* Label styling */
            label {
                display: block;
                margin-bottom: 5px;
                font-weight: bold;
            }
            /* Input field styling */
            input[type="text"] {
                width: 100%;
                padding: 10px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            /* Submit button styling */
            .btn-save {
                width: 100%;
                padding: 12px;
                background: linear-gradient(135deg, #4a90e2, #007bff);
                border: none;
                border-radius: 5px;
                color: #fff;
                font-size: 18px;
                font-weight: bold;
                cursor: pointer;
                box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                transition: background 0.3s ease, transform 0.3s ease;
            }
            /* Submit button hover effect */
            .btn-save:hover {
                background: linear-gradient(135deg, #007bff, #4a90e2);
                transform: translateY(-2px);
            }
            /* Error message styling */
            .error-message {
                color: red;
                font-size: 0.9em;
                display: none;
            }
        </style>
        <script type="text/javascript">
            function validateForm() {
                // Clear previous error messages
                document.querySelectorAll('.error-message').forEach(function(el) {
                    el.style.display = 'none';
                });

                let isValid = true;

                // Validate Code
                const code = document.getElementById('code').value.trim();
                if (code === '') {
                    document.getElementById('nullCode').style.display = 'block';
                    isValid = false;
                }

                // Validate Description
                const description = document.getElementById('description').value.trim();
                if (description === '') {
                    document.getElementById('nullDescription').style.display = 'block';
                    isValid = false;
                }

                // Validate Price
                const price = document.getElementById('price').value.trim();
                if (price === '') {
                    document.getElementById('nullPrice').style.display = 'block';
                    isValid = false;
                } else if (isNaN(price) || Number(price) <= 0) {
                    document.getElementById('nullPrice').textContent = 'Please enter a valid price.';
                    document.getElementById('nullPrice').style.display = 'block';
                    isValid = false;
                }

                return isValid;
            }
        </script>
    </head>
    <body>
        <div class="form-container">
            <h1>Add Product</h1>
            <form name="productForm" action="ProductServlet" method="post" onsubmit="return validateForm()">
                <input type="hidden" name="action" value="${action}">

                <div class="form-group">
                    <label for="code">Code:</label>
                    <input type="text" id="code" name="code" value="${product.code}">
                    <p id="nullCode" class="error-message">* Code is required.</p>
                </div>

                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" id="description" name="description" value="${product.description}">
                    <p id="nullDescription" class="error-message">* Description is required.</p>
                </div>

                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="text" id="price" name="price" value="${product.price}">
                    <p id="nullPrice" class="error-message">* Price is required.</p>
                </div>

                <input type="submit" value="Save" class="btn-save">
            </form>
        </div>
    </body>
</html>

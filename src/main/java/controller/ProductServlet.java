package controller;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import music.business.Product;
import music.data.ProductDB;

/**
 * Servlet to manage product-related operations.
 */
public class ProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "list"; // default action
        }
        
        if (action.equals("list")) {
            List<Product> products = ProductDB.getProducts(); // Retrieve products from the database

            if (products == null || products.isEmpty()) {
                request.setAttribute("message", "No products found to display.");
            } else {
                request.setAttribute("products", products);  // Add the products to the request
            }

            // Forward the request to productList.jsp
            getServletContext().getRequestDispatcher("/productList.jsp")
                    .forward(request, response);
        } else if (action.equals("saveProduct")) {
            request.setAttribute("action", "saveProduct");
            getServletContext().getRequestDispatcher("/productAdd.jsp")
                    .forward(request, response);
        } else if (action.equals("edit")) {
            String code = request.getParameter("code");
            Product product = ProductDB.selectProduct(code); // Retrieve product from the database
            request.setAttribute("product", product);
            request.setAttribute("action", "edit");
            getServletContext().getRequestDispatcher("/productAdd.jsp")
                    .forward(request, response);
        } else if (action.equals("delete")) {
            String code = request.getParameter("code");
            Product product = ProductDB.selectProduct(code); // Retrieve product from the database
            request.setAttribute("product", product);
            getServletContext().getRequestDispatcher("/confirmDelete.jsp")
                    .forward(request, response);            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action.equals("saveProduct")) {
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));

            Product product = new Product(code, description, price);
            ProductDB.addProduct(product); // Insert product into the database
            response.sendRedirect("ProductServlet?action=list");            
        } else if (action.equals("edit")) {
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            double price = Double.parseDouble(request.getParameter("price"));

            Product product = new Product(code, description, price);
            ProductDB.updateProduct(product); // Update product in the database
            response.sendRedirect("ProductServlet?action=list");
        } else if (action.equals("confirmDelete")) {
            String code = request.getParameter("code");
            ProductDB.deleteProduct(code); // Delete product from the database
            response.sendRedirect("ProductServlet?action=list");
        }
    }
}

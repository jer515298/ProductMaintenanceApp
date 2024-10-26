/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import music.business.Product;
import music.data.ProductIO;

/**
 *
 * @author ccull
 */
public class ProductServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // get action attribute
        String action = request.getParameter("action");
        // Initialize the file path for ProductIO
        String filePath = getServletContext().getRealPath("/WEB-INF/products.txt");
        ProductIO.init(filePath);  // Initialize ProductIO with the file path

        // Retrieve the list of products
        List<Product> products = ProductIO.selectProducts();
        
        if (action == null) {
            action = "list"; // default action
        }
        
        if (action.equals("list")) {
            // Check if products are available
            if (products == null || products.isEmpty()) {
                request.setAttribute("message", "No products found to display.");
            } else {
                request.setAttribute("products", products);  // Add the products to the request
            }

            // Forward the request to productList.jsp
            getServletContext().getRequestDispatcher("/productList.jsp")
                    .forward(request, response);
        } else if (action.equals("add")) {
            // add product functionality, forward to productAdd,jsp
            getServletContext().getRequestDispatcher("/productAdd.jsp")
            .forward(request, response);
        } else if (action.equals("edit")) {
            // edit product functionlity, forwards to productAdd.jsp
            // also needs to use product code attribute to send product fields in request attribute
            
            // Forward the request to productAdd.jsp
            getServletContext().getRequestDispatcher("/productAdd.jsp")
                    .forward(request, response);
        } else if (action.equals("delete")) {
            // delete product, forwards to confirmDelete.jsp
            getServletContext().getRequestDispatcher("/confirmDelete.jsp")
                    .forward(request, response);
            
            
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);  // Handle POST requests by calling doGet()
    }
}

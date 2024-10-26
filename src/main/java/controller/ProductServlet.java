/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        } else if (action.equals("saveProduct")) {
            // add product functionality, action=saveProduct forward to productAdd,jsp
            
            
            request.setAttribute("action", "saveProduct");
            
            // forward to productAdd.jsp with action=saveProduct
            getServletContext().getRequestDispatcher("/productAdd.jsp")
            .forward(request, response);
        } else if (action.equals("edit")) {
            // edit product functionlity, forwards to productAdd.jsp
            // also needs to use product code attribute to send product fields in request attribute
            
            String code = request.getParameter("code");
            
            // use productIO method to retrieve product
            Product product = ProductIO.selectProduct(code);
            
            // set product as request attribute for edit/add page
            request.setAttribute("product", product);
            request.setAttribute("action", "edit");

            
            // Forward the request to productAdd.jsp
            getServletContext().getRequestDispatcher("/productAdd.jsp")
                    .forward(request, response);
        } else if (action.equals("delete")) {
            // delete product, forwards to confirmDelete.jsp
            // attribute product with associated product code
            String code = request.getParameter("code");
            
            Product product = ProductIO.selectProduct(code);
            
            request.setAttribute("product", product); // send attribute to confirmDelete.jsp
            
            getServletContext().getRequestDispatcher("/confirmDelete.jsp")
                    .forward(request, response);            
        }
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // get action attribute
        String action = request.getParameter("action");
        // Initialize the file path for ProductIO
        String filePath = getServletContext().getRealPath("/WEB-INF/products.txt");
        ProductIO.init(filePath);  // Initialize ProductIO with the file path
        
        if (action.equals("saveProduct")) {
            // save product for add product functionality
            // will return to productList.jsp with action="list"
            
            // get fields from productAdd.jsp
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String priceString = request.getParameter("price");
            
            double price = Double.parseDouble(priceString);
            
            // create product Object
            Product product = new Product(code, description, price);
             
            // insert product to products.txt file
            ProductIO.insertProduct(product); // method also saves new product list
             
            // Redirect back to ProductServlet with action=list
            response.sendRedirect("ProductServlet?action=list");            
        } else if (action.equals("edit")) {
            // edit product functionality
            // will return to productList.jsp with action="list"
            
            // get fields from productAdd.jsp
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String priceString = request.getParameter("price");
            
            double price = Double.parseDouble(priceString);
            
            // create product Object
            Product product = new Product(code, description, price);
            
            //use productIO updateProduct, uses product.code to update, also saves list
            ProductIO.updateProduct(product);
            
            // Redirect back to ProductServlet with action=list
            response.sendRedirect("ProductServlet?action=list");
        } else if (action.equals("confirmDelete")) {
            // delete product using attribute code
            // redirect back to productServlet with action=list
            String code = request.getParameter("code");
            
            // get product object
            Product product = ProductIO.selectProduct(code);
            
            // delete product, method also saves new list
            ProductIO.deleteProduct(product);
            
            response.sendRedirect("ProductServlet?action=list");
        }
        
        
    }
}

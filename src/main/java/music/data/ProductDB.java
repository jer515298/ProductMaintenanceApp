package music.data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import music.business.Product;

public class ProductDB {

    // SQL Queries
    private static final String GET_PRODUCTS_QUERY = "SELECT * FROM Products";
    private static final String ADD_PRODUCT_QUERY = "INSERT INTO Products (code, description, price) VALUES (?, ?, ?)";
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE Products SET description = ?, price = ? WHERE code = ?";
    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM Products WHERE code = ?";
    private static final String SELECT_PRODUCT_QUERY = "SELECT * FROM Products WHERE code = ?";

    // Method to get a list of all products
    public static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(GET_PRODUCTS_QUERY);
             ResultSet rs = statement.executeQuery()) {

            while (rs.next()) {
                Product product = new Product();
                product.setCode(rs.getString("code"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Method to add a new product
    public static void addProduct(Product product) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(ADD_PRODUCT_QUERY)) {

            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an existing product
    public static void updateProduct(Product product) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(UPDATE_PRODUCT_QUERY)) {

            ps.setString(1, product.getDescription());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getCode());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete a product by code
    public static void deleteProduct(String code) {
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCT_QUERY)) {

            ps.setString(1, code);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve a single product by code
    public static Product selectProduct(String code) {
        Product product = null;
        try (Connection connection = ConnectionPool.getInstance().getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT_QUERY)) {

            ps.setString(1, code);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    product = new Product();
                    product.setCode(rs.getString("code"));
                    product.setDescription(rs.getString("description"));
                    product.setPrice(rs.getDouble("price"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    // Optional: Method to test the connection
    public static void testConnection() {
        try (Connection connection = ConnectionPool.getInstance().getConnection()) {
            if (connection != null) {
                System.out.println("Connection successful!");
            } else {
                System.out.println("Failed to establish a connection.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

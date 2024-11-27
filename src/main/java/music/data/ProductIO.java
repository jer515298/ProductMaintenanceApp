package music.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import music.business.Product;

public class ProductIO {
    private static List<Product> products = new ArrayList<>();
    private static String filePath = "products.txt"; // Default path, can be modified

    // Initialize the file path if needed
    public static void init(String path) {
        filePath = path;
    }

    // Retrieve all products from the text file
    public static List<Product> selectProducts() {
        products.clear();
        File file = new File(filePath);
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = in.readLine()) != null) {
                String[] tokens = line.split("\\|");
                if (tokens.length == 3) {
                    String code = tokens[0];
                    String description = tokens[1];
                    double price = Double.parseDouble(tokens[2]);
                    Product product = new Product(code, description, price);
                    products.add(product);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }

    // Insert a new product into the text file
    public static void insertProduct(Product product) {
        products = selectProducts();
        products.add(product);
        saveProducts();
    }

    // Update an existing product in the text file
    public static void updateProduct(Product product) {
        products = selectProducts();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getCode().equalsIgnoreCase(product.getCode())) {
                products.set(i, product);
                break;
            }
        }
        saveProducts();
    }

    // Delete a product from the text file
    public static void deleteProduct(String code) {
        products = selectProducts();
        products.removeIf(p -> p.getCode().equalsIgnoreCase(code));
        saveProducts();
    }

    // Save all products back to the text file
    private static void saveProducts() {
        try (PrintWriter out = new PrintWriter(new FileWriter(filePath))) {
            for (Product p : products) {
                out.println(p.getCode() + "|" + p.getDescription() + "|" + p.getPrice());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

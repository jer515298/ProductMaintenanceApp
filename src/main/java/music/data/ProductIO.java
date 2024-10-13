package music.data;

import java.io.*;
import java.util.*;
import music.business.Product;

public class ProductIO {

    private static String filePath;

    public static void init(String filePath) {
        ProductIO.filePath = filePath;
    }

    public static List<Product> selectProducts() {
        List<Product> products = new ArrayList<>();
        File file = new File(filePath);

        try {
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                if (t.countTokens() >= 3) {
                    String code = t.nextToken();
                    String description = t.nextToken();
                    String priceString = t.nextToken();
                    double price = Double.parseDouble(priceString);

                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(price);

                    products.add(p);
                }
                line = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        return products;
    }

    // Add the selectProduct method here
    public static Product selectProduct(String productCode) {
        List<Product> products = selectProducts();  // Retrieve the list of products
        for (Product p : products) {
            if (p.getCode().equalsIgnoreCase(productCode)) {
                return p;  // Return the product if the code matches
            }
        }
        return null;  // If no product matches, return null
    }

    // Other methods like insertProduct, updateProduct, etc.
}

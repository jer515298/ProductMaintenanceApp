package music.business;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the Product class.
 */
public class ProductTest {
    
    public ProductTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getId and setId methods, of class Product.
     */
    @Test
    public void testGetSetId() {
        System.out.println("getSetId");
        Product instance = new Product();
        Long expectedId = 1L;
        instance.setId(expectedId);
        assertEquals(expectedId, instance.getId(), "Product ID should match the set value.");
    }

    /**
     * Test of getCode and setCode methods, of class Product.
     */
    @Test
    public void testGetSetCode() {
        System.out.println("getSetCode");
        Product instance = new Product();
        String expectedCode = "CD01";
        instance.setCode(expectedCode);
        assertEquals(expectedCode, instance.getCode(), "Product code should match the set value.");
    }

    /**
     * Test of getDescription and setDescription methods, of class Product.
     */
    @Test
    public void testGetSetDescription() {
        System.out.println("getSetDescription");
        Product instance = new Product();
        String expectedDescription = "Artist - Album";
        instance.setDescription(expectedDescription);
        assertEquals(expectedDescription, instance.getDescription(), "Product description should match the set value.");
    }

    

    /**
     * Test of getPrice and setPrice methods, of class Product.
     */
    @Test
    public void testGetSetPrice() {
        System.out.println("getSetPrice");
        Product instance = new Product();
        double expectedPrice = 19.99;
        instance.setPrice(expectedPrice);
        assertEquals(expectedPrice, instance.getPrice(), 0.001, "Product price should match the set value.");
    }

    /**
     * Test of getPriceCurrencyFormat method, of class Product.
     */
    @Test
    public void testGetPriceCurrencyFormat() {
        System.out.println("getPriceCurrencyFormat");
        Product instance = new Product();
        instance.setPrice(19.99);
        String expectedFormat = "$19.99"; // Adjust based on your locale
        assertEquals(expectedFormat, instance.getPriceCurrencyFormat(), "Price should be formatted as currency.");
    }

    /**
     * Test of getImageURL method, of class Product.
     */
    @Test
    public void testGetImageURL() {
        System.out.println("getImageURL");
        Product instance = new Product();
        instance.setCode("CD01");
        String expectedURL = "/musicStore/images/CD01_cover.jpg";
        assertEquals(expectedURL, instance.getImageURL(), "Image URL should be formatted based on product code.");
    }

    /**
     * Test of getProductType method, of class Product.
     */
    @Test
    public void testGetProductType() {
        System.out.println("getProductType");
        Product instance = new Product();
        String expectedType = "Audio CD";
        assertEquals(expectedType, instance.getProductType(), "Product type should be 'Audio CD' by default.");
    }
}

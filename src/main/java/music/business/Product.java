package music.business;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import java.text.NumberFormat;
import java.io.Serializable;

@Entity
@Table(name = "Products") // specify table name if it's different in the database
public class Product implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-generates primary key value
    @Column(name = "id") // specify column name if different in the database
    private Long productId; 
    
    @Column(name = "code") // specify column name if different in the database
    private String code;
    
    @Column(name = "description") // specify column name if different in the database
    private String description;
    
    @Column(name = "price") // specify column name if different in the database
    private double price;
    
    public Product() {}
    
    public Product(String code, String description, double price) {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public Long getId() {
        return productId;
    }
    
    public void setId(Long productId) {
        this.productId = productId;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getArtistName() {
        return description.contains(" - ") ? description.substring(0, description.indexOf(" - ")) : description;
    }
    
    public String getAlbumName() {
        return description.contains(" - ") ? description.substring(description.indexOf(" - ") + 3) : "";
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    public String getImageURL() {
        return "/musicStore/images/" + code + "_cover.jpg";
    }
    
    public String getProductType() {
        return "Audio CD";
    }
}

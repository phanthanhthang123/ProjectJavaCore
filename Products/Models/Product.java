
package QuanLyBanHang.Products.Models;

/**
 * Product
 */
public class Product {
    private Integer id;
    private String name;
    private Float price;
    private int quantity;
    private String description;

    public Product(){

    }
    public Product( String name,Float price, int quantity, String description) {
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }
    public Product(Integer id, String name,Float price, int quantity, String description) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }

    //setter and getter
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return String.format("%-20d %-20s %-20.2f %-20d %-20s",this.getId(),this.getName(),this.getPrice(),this.getQuantity(),this.getDescription());
    }

    
}
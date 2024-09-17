package QuanLyBanHang.Oders.Models;

/**
 * OderDetail
 */
public class OrderDetail {
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Float price;
    private Integer quantity;

    //setter and getter
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getOrderId() {
        return orderId;
    }
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPriceTotal(){
        return this.getQuantity()*this.getPrice();
    }
}
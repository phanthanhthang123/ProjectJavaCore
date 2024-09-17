package QuanLyBanHang.Oders.Models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Integer id;
    private String customerName;
    private String phone;
    private String email;

    private List<OrderDetail> oderDetails = new ArrayList<>();
    
    public Order() {
    }
    public Order(Integer id, String customerName, String phone, String email) {
        this.id = id;
        this.customerName = customerName;
        this.phone = phone;
        this.email = email;
    }
    //setter and getter
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public List<OrderDetail> getOderDetails() {
        return oderDetails;
    }
    public void setOderDetails(List<OrderDetail> oderDetails) {
        this.oderDetails = oderDetails;
    }

    
}

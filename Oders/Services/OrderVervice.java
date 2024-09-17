package QuanLyBanHang.Oders.Services;

import java.util.InputMismatchException;
import java.util.Scanner;

import QuanLyBanHang.Main;
import QuanLyBanHang.Oders.Models.Order;
import QuanLyBanHang.Oders.Models.OrderDetail;
import QuanLyBanHang.Products.Models.Product;
import QuanLyBanHang.Products.Services.ProductService;

public class OrderVervice {
    public void order() {
        Scanner inputs = new Scanner(System.in);
        try {
            System.out.println("-------------Mua San Pham------------");
            System.out.print("Ma dat hang:");
            Integer id = inputs.nextInt();

            inputs.nextLine();
            System.out.print("Nhap ten khach hang: ");
            String custormerName = inputs.nextLine();

            System.out.print("Nhap so dien thoai: ");
            String phone = inputs.nextLine();

            System.out.print("Nhap email: ");
            String email = inputs.nextLine();

            Order order = new Order(id, custormerName, phone, email);
            System.out.println("-------------Danh sach san pham------------");
            System.out.printf("%-20s %-20s %-20s %-20s %-20s\n", "ID", "Ten San Pham", "Gia Ban", "So Luong",
                    "Mo Ta San Pham");

            int productFunction = 1;
            do {
                ProductService productService = new ProductService();
                productService.showProducts();
                System.out.print("Moi Nhap Ma San Pham: ");
                Integer productId = inputs.nextInt();

                // kiem tra ma san pham
                Product product = null;
                for (Product p : Main.PRODUCTS) {
                    if (p.getId().equals(productId)) {
                        product = p;
                        break;
                    }
                }

                if (product == null) {
                    System.out.println("Ma san pham khong ton tai, vui long kiem tra lai");
                    break;
                } else {
                    System.out.print("So luong: ");
                    Integer quantity = inputs.nextInt();
                    while (product.getQuantity() < quantity ) {
                        System.out.print("So luong san pham khong du, vui long nhap lai: ");
                        quantity = inputs.nextInt();
                    }
                    OrderDetail orderDetail = new OrderDetail();
                    orderDetail.setId(1);
                    orderDetail.setOrderId(order.getId());
                    orderDetail.setPrice(product.getPrice());
                    orderDetail.setProductId(productId);
                    orderDetail.setQuantity(quantity);

                    order.getOderDetails().add(orderDetail);

                    System.out.print("Quy khach muon mua hang tiep khong (1/0)?:");
                    int check = inputs.nextInt();
                    if(check==1){
                        productFunction = 0;
                    }
                    else{
                        Main.ORDERS.add(order);
                        productFunction = 1;
                    }
                }

            } while (productFunction == 0);

        } catch (InputMismatchException ie) {
            System.out.println("Nhap sai , vui long nhap lai");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void showOrder(){
        System.out.println("-------------Danh sach don hang------------");
        
        ProductService productService = new ProductService();
        for(Order order : Main.ORDERS){
            System.out.printf("%-20s %-20s %-20s %-30s\n","ID","Ten Khach Hang","So Dien Thoai","Email");
            System.out.printf("%-20s %-20s %-20s %-30s\n",order.getId(),order.getCustomerName(),order.getPhone(),order.getEmail());

            System.out.printf("%-20s %-20s %-20s %-20s\n","STT","Ten San Pham","Gia","So Luong");
            int i = 1;
            float priceTotal = 0;
            for(OrderDetail od : order.getOderDetails()){
                Product p = productService.getById(od.getProductId());
                priceTotal += od.getPriceTotal();
                System.out.printf("%-20d %-20s %-20.2f %-30d \n",i++,p.getName(),od.getPrice(),od.getQuantity());
            }
            System.out.printf("Tong so tien ban phai tra la: %.2f\n",priceTotal);
        }
    }
}

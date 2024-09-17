package QuanLyBanHang;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import QuanLyBanHang.Oders.Services.OrderVervice;
import QuanLyBanHang.Products.Models.Product;
import QuanLyBanHang.Products.Services.ProductService;
import QuanLyBanHang.Oders.Models.Order;

public class Main {
    public static List<Product> PRODUCTS = new ArrayList<Product>();
    public static List<Order> ORDERS = new ArrayList<>();

    public static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("----------Danh sach chuc nang------------");
        System.out.println("1.Them moi san pham");
        System.out.println("2.Hien thi san pham");
        System.out.println("3.Sua san pham");
        System.out.println("4.Xoa san pham");
        System.out.println("5.Mua Hang");
        System.out.println("6.Hien thi danh sach don hang");
        System.out.println("7.Thoat");
        System.out.print("Ban chon: ");
        int input = scan.nextInt();
        return input;
    }

    public static void main(String[] args) {
        for(int i=1;i<=4;i++){
            Product p = new Product((Integer)i,"SP"+i,(float)1000000,10-i,"Description");
            Main.PRODUCTS.add(p);

        }
        Scanner scan = new Scanner(System.in);
        int input = 0;
        do {
            try {
                input = menu();

                //Product Service -- Cac Dich Vu San Pham
                ProductService productService = new ProductService();
                OrderVervice orderVervice = new OrderVervice();
                switch (input) {
                    case 1:
                        productService.insertProduct();
                        break;
                    case 2:
                        productService.showProducts();
                        break;
                    case 3:
                        productService.updateProduct();
                        break;
                    case 4:
                        productService.removeProduct();
                        break;
                    case 5:
                        orderVervice.order();
                        break;
                    case 6:
                    orderVervice.showOrder();
                        break;
                    case 7:
                        System.out.print("Ban co chac chan muon thoat chuong trinh(1/0)?: ");
                        int temp = scan.nextInt();
                        if (temp == 0)
                            input = 0;
                        else {
                            System.out.println("Cam on ban da su dung phan mem");
                            input = 7;
                        }
                        break;
                    default:
                    break;
                }
            } catch (InputMismatchException ie) {
                System.out.println("Nhap khong hop le,vui long nhap lai");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (input != 7);
    }
}

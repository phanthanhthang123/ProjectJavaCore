package QuanLyBanHang.Products.Services;

import java.util.InputMismatchException;
import java.util.Scanner;

import QuanLyBanHang.Main;
import QuanLyBanHang.Products.Models.Product;

public class ProductService {

    public void insertProduct(){
        Scanner inputs = new Scanner(System.in);
        System.out.println("Nhap thong tin san pham: ");
        
        try{
            System.out.print("Ma: ");
            int id = inputs.nextInt();

            System.out.print("Ten San Pham: ");
            inputs.nextLine();//xoa enter
            String name = inputs.nextLine();

            System.out.print("Gia cua san pham: ");
            Float price = inputs.nextFloat();

            System.out.print("So luong cua san pham: ");
            int quantity = inputs.nextInt();

            System.out.print("Mo ta san pham: ");
            inputs.nextLine();//xoa enter
            String description = inputs.nextLine();
            //insert vao db
            Product p = new Product(id,name,price,quantity,description);
            Main.PRODUCTS.add(p);

        }catch(InputMismatchException ei){
            System.out.println("Ban da nhap sai gia tri,vui long nhap lai");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void showProducts(){
        System.out.println("-------------Danh sach san pham------------");
        System.out.printf("%-20s %-20s %-20s %-20s %-20s\n","ID","Ten San Pham","Gia Ban","So Luong","Mo Ta San Pham");
        for(Product p : Main.PRODUCTS){
            System.out.println(p.toString());
        }
    }

    public void updateProduct(){
        Scanner inputs = new Scanner(System.in);
        try{
            System.out.print("Nhap ID san pham: ");
            Integer id = inputs.nextInt();
            Product product = null;
            for(Product p : Main.PRODUCTS){
                if(p.getId().equals(id)){
                    product = p;
                    break;
                } 
            }

            if(product == null){
                System.out.println("Ma san pham khong ton tai. Xin vui long nhap lai!");
            }else{
                System.out.println("---------------Thong tin san Pham------------");
                System.out.printf("%-20s %-20s %-20s %-20s %-20s\n","ID","Ten San Pham","Gia Ban","So Luong","Mo Ta San Pham");
                System.out.println(product.toString());

                for(int i=0;i< Main.PRODUCTS.size();i++){
                    if(id.equals(Main.PRODUCTS.get(i).getId())){
                        System.out.print("Ten San Pham: ");
                        inputs.nextLine();
                        String name = inputs.nextLine();

                        System.out.print("Gia San Pham: ");
                        Float price = inputs.nextFloat();
                        
                        System.out.print("So Luong: ");
                        Integer quantity = inputs.nextInt();

                        System.out.print("Mo Ta San Pham: ");
                        inputs.nextLine();
                        String description = inputs.nextLine();

                        Main.PRODUCTS.get(i).setName(name);
                        Main.PRODUCTS.get(i).setPrice(price);
                        Main.PRODUCTS.get(i).setQuantity(quantity);
                        Main.PRODUCTS.get(i).setDescription(description);
                    }
                }
            }

        }catch(InputMismatchException ei){
            System.out.println("Ban da nhap sai gia tri,xin vui long nhap lai");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void removeProduct(){
        Scanner inputs = new Scanner(System.in);
        try{
            System.out.print("Nhap ID ban muon xoa: ");
            Integer id = inputs.nextInt();
            Product product = null;
            for(Product p : Main.PRODUCTS){
                if(id.equals(p.getId())){
                    product = p;
                }
            }
            if(product == null){
                System.out.printf("San Pham co Id %d khong ton tai, vui long nhap lai\n",id);
            }else{
                try{
                    System.out.println("--------Thong tin san pham bi xoa---------");
                    System.out.printf("%-20s %-20s %-20s %-20s %-20s\n","ID","Ten San Pham","Gia Ban","So Luong","Mo Ta San Pham");
                    System.out.println(product.toString());
                    System.out.print("Ban co chac chan muon xoa khong(1/0)?: ");
                    int check = inputs.nextInt();
                    if(check == 0){   
                        return;
                    }else{
                        Main.PRODUCTS.remove(product);
                    }
                }catch(InputMismatchException ie){
                    System.out.println("Ban nhap sai gia tri,vui long nhap lai");
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }catch(InputMismatchException ie){
            System.out.println("Ban nhap sai gia tri, vui long nhap lai");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    //Lay product theo id product
    public Product getById(Integer id){
        Product product = new Product();
        for (Product p : Main.PRODUCTS){
            if(p.getId().equals(id)){
                product = p;
                break;
            }
        }
        return product;
    }
}

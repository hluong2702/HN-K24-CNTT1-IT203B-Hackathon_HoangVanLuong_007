package rw.entity;

import rw.business.WarehouseBusiness;

import java.util.Scanner;

public class Product {
    private String productId;
    private String productName;
    private double price;
    private int quantity;
    private String category;

    public Product(String productId, String productName, double price, int quantity, String category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập ID sản phẩm: ");
        while (true) {
            this.productId = scanner.next();
            if (this.productId.isEmpty()) {
                System.out.print("ID không được để trống. Vui lòng nhập lại: ");
            }
            System.out.print("Nhập tên sản phẩm: ");
            this.productName = scanner.next();
            System.out.print("Nhập giá sản phẩm: ");
            while (true) {
                try {
                    this.price = Double.parseDouble(scanner.next());
                    if (this.price < 0) {
                        throw new NumberFormatException("Giá không được âm.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Giá không hợp lệ. Vui lòng nhập lại: ");
                }
            }
            System.out.print("Nhập số lượng sản phẩm: ");
            while (true) {
                try {
                    this.quantity = Integer.parseInt(scanner.next());
                    if (this.quantity < 0) {
                        throw new NumberFormatException("Số lượng không được âm.");
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.print("Số lượng không hợp lệ. Vui lòng nhập lại: ");
                }
            }
            System.out.print("Nhập loại sản phẩm: ");
            this.category = scanner.next();
        }

    }
}

package rw.business;

import rw.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class WarehouseBusiness {
    private List<Product> products = new ArrayList<>();
    private static WarehouseBusiness instance;

    private WarehouseBusiness() {
    }

    public static WarehouseBusiness getInstance() {
        if (instance == null) {
            instance = new WarehouseBusiness();
        }
        return instance;
    }

    // hien thi danh sach san pham
    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("Khong co san pham nao trong kho");
        } else {
            System.out.println("Danh sach san pham trong kho:");
            products.forEach(p -> System.out.println("ID: " + p.getProductId() + ", Name: " + p.getProductName() + ", Price: " + p.getPrice() + ", Quantity: " + p.getQuantity() + ", Category: " + p.getCategory()));
        }
    }

    // them moi san pham
    public void addProduct(Product product) {
        boolean exists = products.stream().anyMatch(p -> p.getProductId().equals(product.getProductId()));
        if (exists) {
            System.out.println("San pham da ton tai, khong the them");
        } else {
            products.add(product);
            System.out.println("Them san pham thanh cong");
        }
    }

    
    // Cap nhat
    public void updateProduct(String productId, Product newProduct) {
        boolean found = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId().equals(productId)) {
                products.set(i, newProduct);
                System.out.println("Cap nhat san pham thanh cong");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay san pham de cap nhat");
        }
    }


    // Xoa theo ma san pham
    public void deleteProduct(String productId) {
        boolean removed = products.removeIf(p -> p.getProductId().equals(productId));
        if (removed) {
            System.out.println("Xoa san pham thanh cong");
        } else {
            System.out.println("Khong tim thay san pham de xoa");
        }
    }

    // Tim kiem san pham theo ten
    public void searchProductsByName(String keyword) {
        int count = 0;
        for (Product p : products) {
            if (p.getProductName().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("ID: " + p.getProductId() + ", Name: " + p.getProductName() + ", Price: " + p.getPrice() + ", Quantity: " + p.getQuantity() + ", Category: " + p.getCategory());
                count++;
            }
        }
        System.out.println("Tong so luong san pham tim thay: " + count);
    }

    // Sap xep san pham theo gia tang dan
    public void sortProductsByPrice() {
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
        System.out.println("Da sap xep san pham theo gia tang dan");
    }

    // Loc danh sach san pham co so luong ton kho duoi 5
    public void filterLowStockProducts() {
        List<Product> lowStockProducts = products.stream().filter(p -> p.getQuantity() < 5).toList();
        if (lowStockProducts.isEmpty()) {
            System.out.println("Khong co san pham nao co so luong ton kho duoi 5");
        } else {
            System.out.println("Danh sach san pham co so luong ton kho duoi 5:");
            lowStockProducts.forEach(p -> System.out.println("ID: " + p.getProductId() + ", Name: " + p.getProductName() + ", Price: " + p.getPrice() + ", Quantity: " + p.getQuantity() + ", Category: " + p.getCategory()));
        }
    }




}

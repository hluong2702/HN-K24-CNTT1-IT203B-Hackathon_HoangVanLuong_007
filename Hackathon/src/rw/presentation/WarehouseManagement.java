package rw.presentation;

import rw.business.WarehouseBusiness;
import rw.entity.Product;

import java.util.Scanner;

public class WarehouseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- QUẢN LÝ KHO HÀNG ---");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật sản phẩm");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Cảnh báo sản phẩm sắp hết hàng(quantity < 5)");
            System.out.println("7. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    WarehouseBusiness.getInstance().displayProducts();
                    break;
                case 2:
                    Product newProduct = new Product("", "", 0, 0, "");
                    newProduct.inputData(sc);
                    WarehouseBusiness.getInstance().addProduct(newProduct);
                    break;
                case 3:
                    System.out.print("Nhập ID sản phẩm cần cập nhật: ");
                    String updateId = sc.next();
                    System.out.print("Nhập tên sản phẩm mới: ");
                    String updateName = sc.next();
                    System.out.print("Nhập giá sản phẩm mới: ");
                    double updatePrice = sc.nextDouble();
                    System.out.print("Nhập số lượng sản phẩm mới: ");
                    int updateQuantity = sc.nextInt();
                    System.out.print("Nhập loại sản phẩm mới: ");
                    String updateCategory = sc.next();
                    WarehouseBusiness.getInstance().updateProduct(updateId, new Product(updateId, updateName, updatePrice, updateQuantity, updateCategory));
                    break;
                case 4:
                    System.out.print("Nhập ID sản phẩm cần xóa: ");
                    String deleteId = sc.next();
                    WarehouseBusiness.getInstance().deleteProduct(deleteId);
                    break;
                case 5:
                    System.out.print("Nhập tên sản phẩm cần tìm kiếm: ");
                    String searchName = sc.next();
                    WarehouseBusiness.getInstance().searchProductsByName(searchName);
                    break;
                case 6:
                    WarehouseBusiness.getInstance().filterLowStockProducts();
                    break;
                case 7:
                    WarehouseBusiness.getInstance().sortProductsByPrice();
                    System.out.println("Sản phẩm đã được sắp xếp theo giá tăng dần.");
                    break;
                case 8:
                    System.out.println("Thank you.See you again!");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }

        }

    }
}

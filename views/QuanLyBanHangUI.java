package views;

import java.util.Scanner;

import controllers.QuanLyBaoHanh;
import controllers.QuanLyGiamGia;
import controllers.QuanLyHoaDon;
import controllers.QuanLyKhachHang;
import controllers.QuanLyThanhToan;

public class QuanLyBanHangUI {
  private static QuanLyBanHangUI instance;
  private static final Scanner input = new Scanner(System.in);

  public static QuanLyBanHangUI getInstance() {
    if (instance == null) {
      instance = new QuanLyBanHangUI();
    }
    return instance;
  }

  public static void listFunctionsView() {
    System.out.println("--------- Danh sách chức năng --------");
    System.out.println("1.Quản lý khách hàng");
    System.out.println("2.Quản lý hóa đơn");
    System.out.println("3.Quản lý bảo hành");
    System.out.println("4.Quản lý giảm giá");
    System.out.println("5.Quản lý thanh toán");
    System.out.println("0.Đăng xuất.");
    System.out.println("--------------------------------------");
  }

  public static void quanLyKhachHangUI() {
    String subCheck = null;
    do {
      System.out.println("Danh Sách chức năng:");
      System.out.println("1.Xem danh sách khách hàng");
      System.out.println("2.Thêm khách hàng");
      System.out.println("3.Sửa khách hàng");
      System.out.println("4.Xóa khách hàng");
      System.out.println("5.Tìm kiếm");
      System.out.println("0.Thoát");
      System.out.println("Mời nhập: ");
      subCheck = input.nextLine();
      switch (subCheck) {
        case "1" -> QuanLyKhachHang.getInstance().Read();
        case "2" -> QuanLyKhachHang.getInstance().Create();
        case "3" -> QuanLyKhachHang.getInstance().Update();
        case "4" -> QuanLyKhachHang.getInstance().Delete();
        case "5" -> QuanLyKhachHang.getInstance().searchByCategory();
        case "0" -> {
          System.out.println("\nThoát quản lý khách hàng\n");
          return;
        }
        default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
      }
    } while (subCheck != "0");
  }

  public static void quanLyHoaDon() {
    String subCheck = null;
    do {
      System.out.println("Danh Sách chức năng:");
      System.out.println("1.Xem danh sách hóa đơn");
      System.out.println("2.Thêm hóa đơn");
      System.out.println("3.Sửa hóa đơn");
      System.out.println("4.Xóa hóa đơn");
      System.out.println("5.Tìm kiếm");
      System.out.println("0.Thoát");
      System.out.println("Mời nhập: ");
      subCheck = input.nextLine();
      switch (subCheck) {
        case "1" -> {
          QuanLyHoaDon.getInstance().Read();
          break;
        }
        case "2" -> {
          QuanLyHoaDon.getInstance().Create();
          break;
        }
        case "3" -> {
          QuanLyHoaDon.getInstance().Update();
          break;
        }
        case "4" -> {
          QuanLyHoaDon.getInstance().Delete();
          break;
        }
        case "5" -> {
          QuanLyHoaDon.getInstance().searchByCategory();
          break;
        }
        case "0" -> {
          System.out.println("\nThoát quản lý khách hàng\n");
          return;
        }
        default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
      }
    } while (subCheck != "0");
  }

  public static void quanlyBaoHanh() {
    String subCheck = null;
    do {
      System.out.println("Danh Sách chức năng:");
      System.out.println("1.Xem danh sách bảo hành");
      System.out.println("2.Thêm bảo hành");
      System.out.println("3.Sửa bảo hành");
      System.out.println("4.Xóa bảo hành");
      System.out.println("5.Tìm kiếm");
      System.out.println("0.Thoát");
      System.out.println("Mời nhập: ");
      subCheck = input.nextLine();
      switch (subCheck) {
        case "1" -> {
          QuanLyBaoHanh.getInstance().Read();
        }
        case "2" -> {
          QuanLyBaoHanh.getInstance().Create();
        }
        case "3" -> {
          QuanLyBaoHanh.getInstance().Update();
        }
        case "4" -> {
          QuanLyBaoHanh.getInstance().Delete();
        }
        case "5" -> {
          QuanLyBaoHanh.getInstance().searchByCategory();
        }
        case "0" -> {
          System.out.println("\nThoát quản lý bảo hành\n");
          return;
        }
        default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
      }
    } while (subCheck != "0");
  }

  public static void quanlyGiamGia() {
    String subCheck;
    do {
      System.out.println("Danh Sách chức năng:");
      System.out.println("1.Xem danh sách sản phẩm được giảm giá");
      System.out.println("2.Thêm sản phẩm bạn muốn giảm giá");
      System.out.println("3.Sửa sản phẩm được giảm giá");
      System.out.println("4.Xóa sản phẩm");
      System.out.println("5.Tìm kiếm");
      System.out.println("0.Thoát");
      System.out.println("Mời nhập: ");
      subCheck = input.nextLine();
      switch (subCheck) {
        case "1" -> {
          QuanLyGiamGia.getInstance().Read();
        }
        case "2" -> {
          QuanLyGiamGia.getInstance().Create();
        }
        case "3" -> {
          QuanLyGiamGia.getInstance().Update();
        }
        case "4" -> {
          QuanLyGiamGia.getInstance().Delete();
        }
        case "5" -> {
          QuanLyGiamGia.getInstance().searchByCategory();
        }
        case "0" -> {
          System.out.println("\nThoát quản lý giảm giá\n");
          return;
        }
        default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
      }
    } while (subCheck != "0");
  }

  public static void quanlyThanhToan() {
    String subCheck = null;
    do {
      System.out.println("Danh Sách chức năng:");
      System.out.println("1.Xem sản phẩm và danh sách khách hàng thanh toán");
      System.out.println("2.Thêm ");
      System.out.println("3.Sửa ");
      System.out.println("4.Xóa ");
      System.out.println("5.Tìm kiếm");
      System.out.println("0.Thoát");
      System.out.println("Mời nhập: ");
      subCheck = input.nextLine();
      switch (subCheck) {
        case "1" -> {
          QuanLyThanhToan.getInstance().Read();
        }
        case "2" -> {
          QuanLyThanhToan.getInstance().Create();
        }
        case "3" -> {
          QuanLyThanhToan.getInstance().Update();
        }
        case "4" -> {
          QuanLyThanhToan.getInstance().Delete();
        }
        case "5" -> {
          QuanLyThanhToan.getInstance().searchByCategory();
        }
        case "0" -> {
          System.out.println("\nThoát quản lý thanh toán\n");
          return;
        }
        default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
      }
    } while (subCheck != "0");
  }

  private QuanLyBanHangUI() {
    String function;
    do {
      listFunctionsView();
      System.out.print("Chọn chức năng: ");
      function = input.nextLine();
      switch (function) {
        case "1" -> {
          quanLyKhachHangUI();
        }
        case "2" -> {
          quanLyHoaDon();

        }
        case "3" -> {
          quanlyBaoHanh();
        }
        case "4" -> {
          quanlyGiamGia();
        }
        case "5" -> {
          quanlyThanhToan();
        }
        case "0" -> {
          System.out.println("\nĐăng xuất thành công");
          return;
        }
        default -> {
          System.out.println("\nNhập sai chức năng, vui lòng nhập lại!\n");
        }
      }
    } while (function != "0");
  }
}

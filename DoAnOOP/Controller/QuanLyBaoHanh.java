package Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entity.Warranty;

public class QuanLyBaoHanh implements ControllerInterface {
  Scanner sc = new Scanner(System.in);
  Warranty[] warranty;

  public QuanLyBaoHanh() {
    super();
    getListWarranties();
  }

  // Lấy danh sách bảo hành từ file
  public Warranty[] getListWarranties() {
    String[] result = new String[0];
    try {
      result = Stream.read("Database/BaoHanh.txt");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    warranty = new Warranty[result.length];
    for (int i = 0; i < result.length; i++) {
      String[] row = result[i].split(";");
      warranty[i] = new Warranty(row[0], LocalDate.parse(row[1]), row[2], row[3], row[4], row[5], row[6]);
    }
    return warranty;
  }

  @Override
  public void Read() {
    System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH BẢO HÀNH----+");
    String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-13s | %-25s | %-12s |",
        "ID sản phẩm",
        "Ngày bảo hành",
        "Số lượng",
        "Phương thức bảo hành",
        "ID khách hàng",
        "Tên khách hàng",
        "SĐT");
    System.out.format(
        "+-------------+---------------------------+----------+----------------------+---------------+---------------------------+--------------+%n");
    System.out.println(header);
    System.out.format(
        "+-------------+---------------------------+----------+----------------------+---------------+---------------------------+--------------+%n");
    getListWarranties();

    for (Warranty w : warranty) {
      String read = String.format("| %-11s | %-25s | %-8s | %-20s | %-13s | %-25s | %-12s |",
          w.getProduct_ID(),
          w.getProduct_Date(),
          w.getYears_Of_Warranty(),
          w.getWarranty_Method(),
          w.getCustomer_ID(),
          w.getCustomer_Name(),
          w.getSDT());
      System.out.println(read);
    }
    System.out.format(
        "+-------------+---------------------------+----------+----------------------+---------------+---------------------------+--------------+%n");
    waitConsole();
  }

  @Override
  public void Create() {
    System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN BẢO HÀNH----+");

    Warranty warrantyModel = new Warranty();
    System.out.println("Nhập ID Sản phẩm (sp_): ");
    warrantyModel.setProduct_ID(sc.nextLine());
    int check = 0;
    for (Warranty w : warranty) {
      if (warrantyModel.getProduct_ID().equals(w.getProduct_ID())) {
        check = 1;
        break;
      }
    }
    if (check == 1) {
      System.out.println("\t\t\t\t\t\t\t\t +----MÃ SẢN PHẨM BỊ TRÙNG----+");
      return;
    }

    System.out.println("Nhập Ngày sản xuất: ");
    warrantyModel.setProduct_Date(LocalDate.parse(sc.nextLine()));

    System.out.println("Nhập Năm bảo hành: ");
    warrantyModel.setYears_Of_Warranty(sc.nextLine());

    System.out.println(" Phương thức bảo hành: ");
    warrantyModel.setWarranty_Method(sc.nextLine());
    // TODO: Phương thức gì?

    System.out.println("Nhập ID Khách hàng: ");
    warrantyModel.setCustomer_ID(sc.nextLine());
    // TODO: check ràng buộc khách hàng, có thông tin khách hàng auto nhập vào tên +

    System.out.println("Nhập tên Khách hàng: ");
    warrantyModel.setCustomer_Name(sc.nextLine());

    System.out.println("Nhập SĐT Khách hàng: ");
    warrantyModel.setSDT(sc.nextLine());

    updateList(0, warranty);
    getListWarranties();
  }

  @Override
  public void Update() {
    try {
      System.out.println("\t\t\t\t\t\t\t\t +----CẬP NHẬT THÔNG TIN BẢO HÀNH----+");
      System.out.println("Nhập ID của sản phẩm cần sửa: ");
      String ID_Product = sc.nextLine();
      Warranty id = null;

      for (Warranty w : warranty) {
        if (w.getProduct_ID().equals(ID_Product)) {
          id = w;
          break;
        }
      }
      if (id == null) {
        System.out.println("\t\t\t\t\t\t\t\t +-----MÃ SẢN PHẨM KHÔNG TỒN TẠI-----+");
        return;
      }

      System.out.println("1. Sửa 1 phần của dòng");
      System.out.println("2. Sửa toàn bộ dòng");
      System.out.print("Nhập số 1 hoặc 2: ");
      int choose = sc.nextInt();
      while (true) {
        if (choose < 1 || choose > 2) {
          System.out.print("Nhập lại: ");
          choose = sc.nextInt();
        } else {
          break;
        }
      }

      System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN BẢO HÀNH TRƯỚC KHI CHỈNH SỬA----+");
      String header = String.format("| %-11s | %-25s | %-8s | %-20s | %-13s | %-25s | %-12s |",
          "ID sản phẩm",
          "Ngày bảo hành",
          "Số lượng",
          "Phương thức bảo hành",
          "ID khách hàng",
          "Tên khách hàng",
          "SĐT");
      System.out.format(
          "+-------------+---------------------------+----------+----------------------+---------------+---------------------------+--------------+%n");
      System.out.println(header);
      System.out.format(
          "+-------------+---------------------------+----------+----------------------+---------------+---------------------------+--------------+%n");
      String row = String.format("| %-11s | %-25s | %-8s | %-20s | %-13s | %-25s | %-12s |",
          id.getProduct_ID(),
          id.getProduct_Date(),
          id.getYears_Of_Warranty(),
          id.getWarranty_Method(),
          id.getCustomer_ID(),
          id.getCustomer_Name(),
          id.getSDT());
      System.out.println(row);
      System.out.format(
          "+-------------+---------------------------+----------+----------------------+---------------+---------------------------+--------------+%n");

      if (choose == 1) {
        System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN SỬA-------------+");
        System.out.println("\t\t\t\t\t\t\t\t |0. Thoát                                 |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1. ID sản phẩm                           |");
        System.out.println("\t\t\t\t\t\t\t\t |2. Ngày sản xuất                         |");
        System.out.println("\t\t\t\t\t\t\t\t |3. Năm bảo hành                          |");
        System.out.println("\t\t\t\t\t\t\t\t |4. Phương thức bảo hành                  |");
        System.out.println("\t\t\t\t\t\t\t\t |5. ID Khách hàng                         |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
        int index = sc.nextInt();
        while (true) {
          if (index < 0 || index > 5) {
            System.out.print("Nhập lại: ");
            index = sc.nextInt();
          } else {
            break;
          }
        }

        String[] data = new String[warranty.length];

        for (int i = 0; i < warranty.length; i++) {
          if (warranty[i].getProduct_ID().equals(ID_Product)) {
            System.out.println("Nhập thông tin bảo hành:");

            switch (index) {
              case 0:
                return;
              case 1:
                System.out.println("Nhập ID sản phẩm: ");
                sc.nextLine();
                id.setProduct_ID(sc.nextLine());
                int check = 0;
                for (Warranty w : warranty) {
                  if (id.getProduct_ID().equals(w.getProduct_ID())) {
                    check = 1;
                    break;
                  }
                }
                if (check == 1) {
                  System.out.println("\t\t\t\t\t\t\t\t +----MÃ SẢN PHẨM BỊ TRÙNG----+");
                  return;
                }
                warranty[i].setProduct_ID(id.getProduct_ID());
                break;
              case 2:
                System.out.println("Nhập Ngày sản xuất: ");
                sc.nextLine();
                id.setProduct_Date(LocalDate.parse(sc.nextLine()));
                warranty[i].setProduct_Date(id.getProduct_Date());
                break;
              case 3:
                System.out.println("Nhập Năm bảo hành: ");
                sc.nextLine();
                id.setYears_Of_Warranty(sc.nextLine());
                warranty[i].setYears_Of_Warranty(id.getYears_Of_Warranty());
                break;
              case 4:
                System.out.println("Nhập Phương thức bảo hành: ");
                sc.nextLine();
                id.setWarranty_Method(sc.nextLine());
                warranty[i].setWarranty_Method(id.getWarranty_Method());
                break;
              case 5:
                System.out.println("Nhập ID Khách hàng: ");
                sc.nextLine();
                id.setCustomer_ID(sc.nextLine());
                warranty[i].setCustomer_ID(id.getCustomer_ID());
                break;
            }
          }
          data[i] = warranty[i].getProduct_ID() + ";" +
              warranty[i].getProduct_Date() + ";" +
              warranty[i].getYears_Of_Warranty() + ";" +
              warranty[i].getWarranty_Method() + ";" +
              warranty[i].getCustomer_ID() + ";" +
              warranty[i].getCustomer_Name() + ";" +
              warranty[i].getSDT();
        }
        try {
          Stream.addAll("Database/BaoHanh.txt", data);
          System.out.println("\t\t\t\t\t\t\t\t+----SỬA THÔNG TIN BẢO HÀNH THÀNH CÔNG----+");
          waitConsole();
        } catch (IOException e) {
          e.printStackTrace();
        }
      } else {
        String[] data = new String[warranty.length];

        for (int i = 0; i < warranty.length; i++) {
          if (warranty[i].getProduct_ID().equals(ID_Product)) {
            System.out.println("Nhập thông tin bảo hành:");

            System.out.println("Nhập Ngày sản xuất: ");
            sc.nextLine();
            id.setProduct_Date(LocalDate.parse(sc.nextLine()));

            System.out.println("Nhập Năm bảo hành: ");
            id.setYears_Of_Warranty(sc.nextLine());

            System.out.println("Nhập Phương thức bảo hành: ");
            id.setWarranty_Method(sc.nextLine());

            System.out.println("Nhập ID Khách hàng: ");
            id.setCustomer_ID(sc.nextLine());

            System.out.println("Nhập tên Khách hàng: ");
            id.setCustomer_Name(sc.nextLine());

            System.out.println("Nhập Số điện thoại: ");
            id.setSDT(sc.nextLine());

            warranty[i].setProduct_Date(id.getProduct_Date());
            warranty[i].setYears_Of_Warranty(id.getYears_Of_Warranty());
            warranty[i].setWarranty_Method(id.getWarranty_Method());
            warranty[i].setCustomer_ID(id.getCustomer_ID());
            warranty[i].setCustomer_Name(id.getCustomer_Name());
            warranty[i].setSDT(id.getSDT());
          }
          data[i] = warranty[i].getProduct_ID() + ";" +
              warranty[i].getProduct_Date() + ";" +
              warranty[i].getYears_Of_Warranty() + ";" +
              warranty[i].getWarranty_Method() + ";" +
              warranty[i].getCustomer_ID() + ";" +
              warranty[i].getCustomer_Name() + ";" +
              warranty[i].getSDT();
        }
        try {
          Stream.addAll("Database/BaoHanh.txt", data);
          System.out.println("\t\t\t\t\t\t\t\t+----SỬA THÔNG TIN BẢO HÀNH THÀNH CÔNG----+");
          waitConsole();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    } catch (InputMismatchException ei) {
      System.out.println("\t\t\t\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void Delete() {
    try {
      // Nhập và kiểm tra ID sản phẩm có tồn tại không
      // Nếu có thì xóa luôn và thông báo thành công
      // Còn không thì thông báo ID không tồn tại
      System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN BẢO HÀNH----+");
      System.out.print("Nhập ID sản phẩm cần xóa: ");
      String ID_Product = sc.nextLine();

      Warranty product = null;
      for (Warranty w : warranty) {
        if (w.getProduct_ID().equals(ID_Product)) {
          product = w;
          break;
        }
      }

      if (product == null) {
        System.out.println("\t\t\t\t\t\t\t\t +-----MÃ BẢO HÀNH KHÔNG TỒN TẠI-----+");
        return;
      }

      for (int i = 0; i < warranty.length; i++) {
        if (ID_Product.equals(warranty[i].getProduct_ID())) {
          warranty = deleteWarranty(warranty, i);
          break;
        }
      }

      // Add lại nguyên danh sách đã xóa dòng dữ liệu
      updateList(1, warranty);

    } catch (InputMismatchException ei) {
      System.out.println("\t\t\t\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  // Xóa phần tử khỏi mảng
  public Warranty[] deleteWarranty(Warranty[] warranty, int index) {
    Warranty[] newCs = new Warranty[warranty.length - 1];
    for (int i = 0, j = 0; i < warranty.length; i++) {
      if (i != index) {
        newCs[j++] = warranty[i];
      }
    }
    return newCs;
  }

  // Thêm phần tử vào mảng
  public Warranty[] addWarranty(Warranty[] warranty, Warranty sanpham) {
    warranty = Arrays.copyOf(warranty, warranty.length + 1);
    warranty[warranty.length - 1] = sanpham;
    return warranty;
  }

  @Override
  public void Search_byCategory() {
    String find;
    System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN TÌM-------------+");
    System.out.println("\t\t\t\t\t\t\t\t |0. Thoát                                 |");
    System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
    System.out.println("\t\t\t\t\t\t\t\t |1. ID sản phẩm                           |");
    System.out.println("\t\t\t\t\t\t\t\t |2. Ngày sản xuất                         |");
    System.out.println("\t\t\t\t\t\t\t\t |3. Năm bảo hành                          |");
    System.out.println("\t\t\t\t\t\t\t\t |4. Phương thức bảo hành                  |");
    System.out.println("\t\t\t\t\t\t\t\t |5. ID Khách hàng                         |");
    System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
    System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    int index = sc.nextInt();

    while (true) {
      if (index < 0 || index > 5) {
        System.out.print("Nhập lại: ");
        index = sc.nextInt();
      } else {
        break;
      }
    }

    System.out.print("Nhập nội dung cần tìm: ");
    sc.nextLine();
    find = sc.nextLine();

    System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH BẢO HÀNH----+");
    String header = String.format("| %-11s | %-25s | %-8s | %-20s | %-13s | %-25s | %-12s |",
        "ID sản phẩm",
        "Ngày bảo hành",
        "Số lượng",
        "Phương thức bảo hành",
        "ID khách hàng",
        "Tên khách hàng",
        "SĐT");
    System.out.format(
        "+-------------+---------------------------+----------+----------------------+---------------+---------------------------+--------------+%n");
    System.out.println(header);

    for (int i = 0; i < warranty.length; i++) {
      switch (index) {
        case 0:
          return;
        case 1:
          if (warranty[i].getProduct_ID().equalsIgnoreCase(find))
            OutputData(i);
          break;
        case 2:
          if (warranty[i].getProduct_Date().equals(LocalDate.parse(find)))
            OutputData(i);
          break;
        case 3:
          if (warranty[i].getYears_Of_Warranty().equalsIgnoreCase(find))
            OutputData(i);
          break;
        case 4:
          if (warranty[i].getWarranty_Method().equalsIgnoreCase(find))
            OutputData(i);
          break;
        case 5:
          if (warranty[i].getCustomer_ID().equalsIgnoreCase(find))
            OutputData(i);
          break;
      }
    }
    System.out.format(
        "+-------------+---------------------------+----------+----------------------+---------------+---------------------------+--------------+%n");
  }

  public void OutputData(int i) {
    String row = String.format("| %-11s | %-25s | %-8s | %-20s | %-13s | %-25s | %-12s |",
        warranty[i].getProduct_ID(),
        warranty[i].getProduct_Date(),
        warranty[i].getYears_Of_Warranty(),
        warranty[i].getWarranty_Method(),
        warranty[i].getCustomer_ID(),
        warranty[i].getCustomer_Name(),
        warranty[i].getSDT());
    System.out.println(row);
  }

  public String[] stringToInputInFile(Warranty[] warranty) {
    String[] data = new String[warranty.length];

    for (int i = 0; i < warranty.length; i++) {
      data[i] = warranty[i].getProduct_ID() + ";" +
          warranty[i].getProduct_Date() + ";" +
          warranty[i].getYears_Of_Warranty() + ";" +
          warranty[i].getWarranty_Method() + ";" +
          warranty[i].getCustomer_ID() + ";" +
          warranty[i].getCustomer_Name() + ";" +
          warranty[i].getSDT();
    }

    return data;
  }

  public void updateList(int select, Warranty[] warranty) {
    switch (select) {
      case 0:
        try {
          String[] data = stringToInputInFile(warranty);
          Stream.addAll("Database/BaoHanh.txt", data);
          System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN BẢO HÀNH THÀNH CÔNG----+");
          waitConsole();
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;

      case 1:
        try {
          String[] data = stringToInputInFile(warranty);
          Stream.addAll("Database/BaoHanh.txt", data);
          System.out.println("\t\t\t\t\t\t\t\t +----SỬA THÔNG TIN BẢO HÀNH THÀNH CÔNG----+");
          waitConsole();
        } catch (IOException e) {
          e.printStackTrace();
        }
        break;
    }
  }

  public int getListLength(Warranty[] warranty) {
    return warranty.length;
  }

  public void waitConsole() {
    System.out.println("\t\t\t\t\t\t\t\t - Ấn Enter để tiếp tục");
    sc.nextLine();
  }
}
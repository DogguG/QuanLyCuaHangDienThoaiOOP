package models;

import java.util.Scanner;

public abstract class ConNguoi {
    Scanner sc = new Scanner(System.in);
    private String name, gender, address, email, sdt;
    private int age;

    public ConNguoi() {

    }

    public ConNguoi(String name, String gender, String address, String email, String sdt, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.sdt = sdt;
        this.age = age;
    }

    public ConNguoi(String name, int age, String address, String email, String sdt, String gender) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.sdt = sdt;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return this.sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ConNguoi name(String name) {
        setName(name);
        return this;
    }

    public ConNguoi gender(String gender) {
        setGender(gender);
        return this;
    }

    public ConNguoi address(String address) {
        setAddress(address);
        return this;
    }

    public ConNguoi email(String email) {
        setEmail(email);
        return this;
    }

    public ConNguoi sdt(String sdt) {
        setSdt(sdt);
        return this;
    }

    public ConNguoi age(int age) {
        setAge(age);
        return this;
    }

    public abstract void AddThongTin(); 
    //{
    //     try {
    //         do {
    //             System.out.print("Nhập họ tên: ");
    //             setName(sc.nextLine());
    //         } while (!Validation.isValidName(name));
    //         do {
    //             Validation.readValidAge();
    //             setAge(sc.nextInt());
    //         } while (!Validation.isValidAge(age));
    //         sc.nextLine();
    //         do {
    //             System.out.print("Nhập giới tính: ");
    //             setGender(sc.nextLine());
    //         } while (!Validation.isValidGender(gender));
    //         do {
    //             System.out.print("Nhập địa chỉ: ");
    //             setAddress(sc.nextLine());
    //         } while (!Validation.isValidAddress(address));
    //         do {
    //             System.out.print("Nhập Email: ");
    //             setEmail(sc.nextLine());
    //         } while (!Validation.isValidEmail(email));
    //         do {
    //             System.out.print("Nhập số điện thoại: ");
    //             sdt = sc.nextLine();
    //         } while (!Validation.isValidPhoneNumber(sdt));
    //     } catch (Exception e) {
    //         System.out.println(e.getMessage());
    //     }
    // }
}

package model;

public class Student {
    private int id;
    private String name;
    private String mail;
    private String dob;
    private String address;
    private String phone;
    private String class_name;
    private int id_course;

    public Student() {
    }

    public Student(String name, String email, String dob, String address, String phone) {
        this.name = name;
        this.mail = email;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
    }

    public Student(String name, String mail, String dob, String address, String phone, int id_course) {
        this.name = name;
        this.mail = mail;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.id_course = id_course;
    }

    public Student(String name, String email, String dob, String address, String phone, String class_name) {
        this.name = name;
        this.mail = email;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.class_name = class_name;
    }

    public Student(int id, String name, String email, String dob, String address, String phone, String class_name) {
        this.id = id;
        this.name = name;
        this.mail = email;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.class_name = class_name;
    }

    public Student(int id, String name, String mail, String dob, String address, String phone, int id_course) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.id_course = id_course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }
}


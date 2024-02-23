package service;
import config.ConnectionJDBC;
import model.Course;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {
    public static final String INSERT_INTO_STUDENTS = "insert into students(name, mail, dob, address,phone) values (?,?,?,?,?);";
    Connection c = ConnectionJDBC.getConnection();
    public List<Student> fillAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement("select s.id, s.name,s.mail,s.dateOfBirth, s.address,s.phone,c.name as class from students s join class c on s.id_class = c.id;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String mail = rs.getString("mail");
                String dob = rs.getString("dateOfBirth");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String c_name = rs.getString("class");
                Student student = new Student(id,name,mail,dob,address,phone,c_name);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    public List<Course> courseList() {
        List<Course> courseList = new ArrayList<>();
        try {
            PreparedStatement statement = c.prepareStatement("select * from class;");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Course course = new Course(id,name);
                courseList.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return courseList;
    }

    public void addStudent(Student student) {
        try {
            PreparedStatement statement = c.prepareStatement("insert into students (name, mail, dateOfBirth, address, phone, id_class) values (?,?,?,?,?,?);");
            statement.setString(1,student.getName());
            statement.setString(2,student.getMail());
            statement.setString(3,student.getDob());
            statement.setString(4,student.getAddress());
            statement.setString(5,student.getPhone());
            statement.setInt(6,student.getId_course());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteStudent(int id) throws SQLException {
        PreparedStatement statement = c.prepareStatement("delete from students where id = ?");
        statement.setInt(1,id);
        statement.executeUpdate();
    }
    public List<Student> findByName(String n) throws SQLException {
        List<Student> students = new ArrayList<>();
        PreparedStatement statement = c.prepareStatement("select * from v_students where name like ?;");
        statement.setString(1,n);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String mail = rs.getString("mail");
            String dob = rs.getString("dateOfBirth");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            String c_name = rs.getString("class");
            Student student = new Student(id,name,mail,dob,address,phone,c_name);
            students.add(student);
        }
        return students;
    }
    public Student selectStudent(int id_student) throws SQLException {
        Student student = null;
        PreparedStatement statement = c.prepareStatement("select * from students where id=?;");
        statement.setInt(1,id_student);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String mail = rs.getString("mail");
            String dob = rs.getString("dateOfBirth");
            String address = rs.getString("address");
            String phone = rs.getString("phone");
            int id_class = rs.getInt("id_class");
            student = new Student(id,name,mail,dob,address,phone,id_class);
        }
        return student;
    }
    public void editStudent(Student student) throws SQLException {
        PreparedStatement statement = c.prepareStatement("update students set name=?,mail=?,dateOfBirth=?,address=?,phone=?,id_class=? where id=?;");
        statement.setString(1,student.getName());
        statement.setString(2,student.getMail());
        statement.setString(3,student.getDob());
        statement.setString(4,student.getAddress());
        statement.setString(5,student.getPhone());
        statement.setInt(6,student.getId_course());
        statement.setInt(7,student.getId());
        statement.executeUpdate();
    }


}

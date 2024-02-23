package controller;

import model.Course;
import model.Student;
import service.StudentService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(urlPatterns = "/student")

public class StudentServlet extends HttpServlet {
    StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(req,resp);
                    break;
                case "edit":
                    editStudent(req,resp);
                    break;
                case "delete":
                    deleteStudent(req,resp);
                    break;
                case "search":
                    searchByName(req,resp);
                    break;
                default:
                    showData(req, resp);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void editStudent(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student editStudent = studentService.selectStudent(id);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/edit.jsp");
        req.setAttribute("student",editStudent);
        List<Course> list = studentService.courseList();
        req.setAttribute("course",list);
        dispatcher.forward(req,resp);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        String name = "%" + req.getParameter("c")+"%";
        req.setAttribute("find",studentService.findByName(name));
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/search.jsp");
        dispatcher.forward(req,resp);
    }

    private void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        studentService.deleteStudent(id);
        List<Student> students = studentService.fillAll();
        req.setAttribute("list",students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/list.jsp");
        dispatcher.forward(req,resp);
    }

    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> list = studentService.courseList();
        req.setAttribute("course",list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/create.jsp");
        dispatcher.forward(req,resp);
    }

    private void showData(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> students = studentService.fillAll();
        req.setAttribute("list",students);
        RequestDispatcher dispatcher = req.getRequestDispatcher("student/list.jsp");
        try {
            dispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action="";
        }
        switch (action) {
            case "create":
                createNewStudent(req, resp);
                showData(req, resp);
                break;
            case "edit":
                updateStudent(req, resp);
                break;
        }
    }

    private void updateStudent(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int course = Integer.parseInt(req.getParameter("course"));
        Student student = new Student(name,mail,dob,address,phone,course);



    }

    private void createNewStudent(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String mail = req.getParameter("mail");
        String dob = req.getParameter("dob");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int course = Integer.parseInt(req.getParameter("course"));
        Student student = new Student(name,mail,dob,address,phone,course);
        studentService.addStudent(student);
    }
}

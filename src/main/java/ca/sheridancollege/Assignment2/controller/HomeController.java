package ca.sheridancollege.Assignment2.controller;

import ca.sheridancollege.Assignment2.beans.Student;
import ca.sheridancollege.Assignment2.database.DatabaseAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeController {

    private final DatabaseAccess database;

    public HomeController(DatabaseAccess database) {
        this.database = database;
    }

    @GetMapping("/listStudents")
    public String list(Model model){
        List<Student> student = database.getStudent();
        model.addAttribute("studentList", student);
        return "listStudents";
    }

    @GetMapping("/studentDetails/{id}")
    public String studentDetails(Model model, @PathVariable int id){
        Student student = database.getStudentById(id);
        model.addAttribute("student", student);
        return "studentDetails";
    }

    @GetMapping("/lists")
    public String listedInformation(){
        return "listStudents";
    }
}

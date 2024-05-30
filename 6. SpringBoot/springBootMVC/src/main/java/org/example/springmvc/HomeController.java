package org.example.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("success")
    public String addStudent(@ModelAttribute(name = "student") Student student){
        return "addstudent";
    }

    @GetMapping("getStudents")
    public String getStudent(Model model){
        List<Student> students = new ArrayList<>();
        Student s1=new Student();
        s1.setAge(18);
        s1.setName("John");
        s1.setId(1);
        students.add(s1);
        Student s2=new Student();
        s2.setAge(19);
        s2.setName("Jane");
        s2.setId(2);
        students.add(s2);
        model.addAttribute("students", students);
        return "getstudents";
    }
}

package com.example.studentapp.controller;

import com.example.studentapp.entity.Student;
import com.example.studentapp.service.StudentService;
import com.example.studentapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private CourseService courseService;

    // READ - display students
    @GetMapping("/students")
    public String viewStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // CREATE - show form
    @GetMapping("/addStudent")
    public String showAddForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("courses", courseService.getAllCourses());
        return "addStudent";
    }

    // CREATE - save student
    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student, Model model) {
        try {
            studentService.saveStudent(student);
            return "redirect:/students";
        } catch (Exception e) {
            model.addAttribute("error", "Error creating student: " + e.getMessage());
            model.addAttribute("student", student);
            model.addAttribute("courses", courseService.getAllCourses());
            return "addStudent";
        }
    }

    // UPDATE - show form
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        model.addAttribute("courses", courseService.getAllCourses());
        return "editStudent";
    }

    // UPDATE - save changes
    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute Student student, Model model) {
        try {
            studentService.saveStudent(student);
            return "redirect:/students";
        } catch (Exception e) {
            model.addAttribute("error", "Error updating student: " + e.getMessage());
            model.addAttribute("student", student);
            model.addAttribute("courses", courseService.getAllCourses());
            return "editStudent";
        }
    }
}

package com.mariam.springboot.studentsystem.controller;


import com.mariam.springboot.studentsystem.entity.*;
import com.mariam.springboot.studentsystem.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/newTeacher")
    public Teacher addTeacher(@RequestBody Teacher theTeacher) {
        theTeacher.setId(0);
        teacherService.save(theTeacher);
        return theTeacher;
    }


    @PutMapping("/newTeacher")
    public Teacher updateTeacher(@RequestBody Teacher theTeacher) {
        teacherService.save(theTeacher);
        return theTeacher;
    }

    @DeleteMapping("/{teacherId}")
    public String deleteTeacher(@PathVariable int teacherId) {
        teacherService.deleteById(teacherId);
        return "Deleted Teacher id - " + teacherId;
    }

    @GetMapping("/list")
    public List<Teacher> listTeachers(Model theModel) {
        List<Teacher> theTeacher = teacherService.findAll();
        return theTeacher;
    }

    @GetMapping("/{teacherId}")
    public Teacher getTeacher(@PathVariable int teacherId) {
        Teacher theTeacher = teacherService.findById(teacherId);
        return theTeacher;
    }

    @GetMapping("/getByMail/{teacherMail}")
    public Teacher getTeacherByMail(@PathVariable String teacherMail) {
        Teacher theTeacher = teacherService.findByMail(teacherMail);
        return theTeacher;
    }

    @GetMapping("/getByletter")
    public List<Teacher> getTeacherByLetterInName() {
        List<Teacher> theTeacher = teacherService.findByLetterInName();
        return theTeacher;
    }
}

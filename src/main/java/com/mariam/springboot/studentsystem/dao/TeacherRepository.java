package com.mariam.springboot.studentsystem.dao;


import com.mariam.springboot.studentsystem.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Teacher findByEmail(String email);

    List<Teacher> findByFirstNameContainingOrLastNameContaining(String letter1, String letter2);

}

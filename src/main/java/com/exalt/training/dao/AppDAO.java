package com.exalt.training.dao;

import com.exalt.training.entity.Course;
import com.exalt.training.entity.Instructor;
import com.exalt.training.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    void save(Course course);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    InstructorDetail findInstructorDetailById(Integer id);
}

package com.exalt.training.dao;

import com.exalt.training.entity.Instructor;
import com.exalt.training.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    InstructorDetail findInstructorDetailById(Integer id);
}

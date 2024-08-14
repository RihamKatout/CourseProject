package com.exalt.training.dao;

import com.exalt.training.entity.Instructor;

public interface AppDAO {
    void save(Instructor instructor);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
}

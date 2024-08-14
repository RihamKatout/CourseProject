package com.exalt.training.dao;

import com.exalt.training.entity.Course;
import com.exalt.training.entity.Instructor;
import com.exalt.training.entity.InstructorDetail;
import com.exalt.training.entity.Student;

public interface AppDAO {
    void save(Instructor instructor);
    void save(Course course);
    Instructor findInstructorById(Integer id);
    void deleteInstructorById(Integer id);
    InstructorDetail findInstructorDetailById(Integer id);
    Course findCourseAndStudentsByCourseId(Integer id);
    Student findStudentAndCoursesByStudentId(Integer id);
    void update(Student student);
}

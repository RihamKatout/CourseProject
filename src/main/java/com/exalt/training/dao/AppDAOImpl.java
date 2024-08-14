package com.exalt.training.dao;

import com.exalt.training.entity.Course;
import com.exalt.training.entity.Instructor;
import com.exalt.training.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class AppDAOImpl implements AppDAO{

    private final EntityManager entityManager;


    @Override
    @Transactional
    public void save(Instructor instructor) {
        // this will also save the details object; cascadeType = ALL
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Instructor findInstructorById(Integer id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Integer id) {
        entityManager.remove(findInstructorById(id));
    }

    @Override
    public InstructorDetail findInstructorDetailById(Integer id) {
        return entityManager.find(InstructorDetail.class, id);
    }
}

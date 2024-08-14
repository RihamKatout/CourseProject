package com.exalt.training.dao;

import com.exalt.training.entity.Instructor;
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
    public Instructor findInstructorById(Integer id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(Integer id) {
        entityManager.remove(findInstructorById(id));
    }
}

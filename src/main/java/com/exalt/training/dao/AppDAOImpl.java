package com.exalt.training.dao;

import com.exalt.training.entity.Course;
import com.exalt.training.entity.Instructor;
import com.exalt.training.entity.InstructorDetail;
import com.exalt.training.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public Course findCourseAndStudentsByCourseId(Integer id) {
        // JOIN FETCH query
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                + "JOIN FETCH c.students "
                + "where c.id = :data", Course.class
        );
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(Integer id) {
        // JOIN FETCH query
        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id = :data", Student.class
        );
        query.setParameter("data", id);
        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }
}

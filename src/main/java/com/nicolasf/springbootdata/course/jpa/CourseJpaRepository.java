package com.nicolasf.springbootdata.course.jpa;

import com.nicolasf.springbootdata.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course);
    }
    public Course findById(Long id) {
       return entityManager.find(Course.class, id);
    }
    public void delete(Long id) {
        Course course = findById(id);
        entityManager.remove(course);
    }
}

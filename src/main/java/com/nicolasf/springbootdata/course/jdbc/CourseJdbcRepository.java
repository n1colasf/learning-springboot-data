package com.nicolasf.springbootdata.course.jdbc;

import com.nicolasf.springbootdata.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository // indicates that an annotated class is a repository, which is an abstraction of data access and storage
public class CourseJdbcRepository {
   private final JdbcTemplate springJdbcTemplate;

   //Constructor injection
    public CourseJdbcRepository(JdbcTemplate springJdbcTemplate) {
        this.springJdbcTemplate = springJdbcTemplate;
    }
   private static final String INSERT_QUERY =
           """
           INSERT INTO COURSE (ID, NAME, AUTHOR) VALUES (?, ?, ?)
           """;
    private static final String DELETE_QUERY =
            """
            DELETE FROM COURSE WHERE ID = ?
            """;
    private static final String SELECT_QUERY =
            """
            SELECT * FROM COURSE WHERE ID = ?
            """;

   public void insert(Course course) {
      springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
   }
    public void delete(Long id) {
        springJdbcTemplate.update(DELETE_QUERY,id);
    }
    public Course findById(Long id) {
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }
}

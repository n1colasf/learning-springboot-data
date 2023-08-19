package com.nicolasf.springbootdata.course;

import com.nicolasf.springbootdata.course.Course;
import com.nicolasf.springbootdata.course.jdbc.CourseJdbcRepository;
import com.nicolasf.springbootdata.course.jpa.CourseJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    //@Autowired
    //private CourseJdbcRepository repository;
    //@Autowired
    //private CourseJpaRepository repository;
    private final CourseSpringDataJpaRepository repository;
    public CourseCommandLineRunner(CourseSpringDataJpaRepository repository) {
        this.repository = repository;
    }
    @Override
    public void run(String... args) throws Exception {
    /*
       repository.insert(new Course(1L, "Spring Framework", "Udemy"));
        repository.insert(new Course(2L, "Spring Framework 2", "Udemy"));
        repository.insert(new Course(3L, "Spring Framework 3", "Udemy"));

        repository.delete(3L);

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(2L));
    */
        repository.save(new Course(1L, "Spring Framework", "Udemy S.A."));
        repository.save(new Course(2L, "Spring Framework 2", "Udemy"));
        repository.save(new Course(3L, "Spring Framework 3", "Udemy"));

        System.out.println(repository.findById(3L));
        repository.deleteById(3L);

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(2L));

        repository.findAll().forEach(System.out::println);
        System.out.println(repository.count());
        repository.findByAuthor("Udemy S.A.").forEach(System.out::println);
        repository.findByName("Spring Framework 2").forEach(System.out::println);
    }
}

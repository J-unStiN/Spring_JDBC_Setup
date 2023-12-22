package com.example.jpahibernatebuildup1.course.jdbc;

import com.example.jpahibernatebuildup1.course.Course;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {
    // CommandLineRunner 스프링이 시작하자마자 실행할 수 있도록 해주는 인터페이스 (run구현)

    private final CourseJdbcRepository courseJdbcRepowsitory;

    public CourseJdbcCommandLineRunner(CourseJdbcRepository courseJdbcRepository) {
        this.courseJdbcRepowsitory = courseJdbcRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        courseJdbcRepowsitory.insert(new Course(1, "Spring", "jun"));
        courseJdbcRepowsitory.insert(new Course(2, "ASP", "jun"));
        courseJdbcRepowsitory.insert(new Course(3, "Node", "jun"));

        courseJdbcRepowsitory.deleteById(1);

        System.out.println(courseJdbcRepowsitory.findById(2));
        System.out.println(courseJdbcRepowsitory.findById(3));
    }
}

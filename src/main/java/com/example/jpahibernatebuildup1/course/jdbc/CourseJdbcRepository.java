package com.example.jpahibernatebuildup1.course.jdbc;

import com.example.jpahibernatebuildup1.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    // 필드주입
    @Autowired
    private JdbcTemplate spsringJdbcTemplate;


    // 문자열 블록을 통해 쿼리 텍스트를 유지하면서 쿼리생성
    private static String INSERT_QUERY =
            """
            insert into course(ID, NAME, AUTHOR) 
                        values (?, ?, ?);
            """;

    private static String DELETE_QUERY =
            """
            delete from course where id = ?
            """;

    private static String SELECT_QUERY =
            """
            select * from course 
                    where id = ?
            """;

    ///
    public void insert(Course course) {
        spsringJdbcTemplate.update(INSERT_QUERY,
                            course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(long id) {
        spsringJdbcTemplate.update(DELETE_QUERY, id);
    }

    /* 객체를 돌려받기 위해서 queryForObject()메서드 사용
    *   그리고 new BeanPropertyRowMapper<>(Course.class)를 통해 리턴할 객체타입에 맞게끔 바꿔줌 */
    public Course findById(long id) {
        return spsringJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class), id);
    }





}

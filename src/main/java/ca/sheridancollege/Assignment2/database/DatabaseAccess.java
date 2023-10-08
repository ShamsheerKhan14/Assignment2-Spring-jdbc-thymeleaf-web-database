package ca.sheridancollege.Assignment2.database;

import ca.sheridancollege.Assignment2.beans.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DatabaseAccess {

    private NamedParameterJdbcTemplate jdbc;

    public DatabaseAccess(NamedParameterJdbcTemplate jdbc){
        this.jdbc = jdbc;
    }

    public List<Student> getStudent(){

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM student ";


        BeanPropertyRowMapper<Student> studentsMapper= new BeanPropertyRowMapper<Student>(Student.class);
        List<Student> student = jdbc.query(query, studentsMapper);
        return student;
    }

    public Student getStudentById (int id){
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String query = "SELECT * FROM student WHERE id = :id";
        namedParameters.addValue("id", id);
        BeanPropertyRowMapper<Student> studentsMapper = new BeanPropertyRowMapper<>(Student.class);
        Student student = jdbc.queryForObject(query, namedParameters, studentsMapper);
        return student;
    }
}

package com.springboot.mybatis.mapper;

import com.springboot.mybatis.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseMapper {
    @Results({
            @Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "courseClass",column = "course_class"),
            @Result(property = "cover",column = "cover"),
            @Result(property = "courseCode",column = "course_code"),
            @Result(property = "finished",column = "finished"),
    })
    @Select("SELECT * FROM Course ")
    List<Course> selectAll();

    @Results({
            @Result(property = "courseId",column = "course_id"),
            @Result(property = "courseName",column = "course_name"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "courseClass",column = "course_class"),
            @Result(property = "cover",column = "cover"),
            @Result(property = "courseCode",column = "course_code"),
            @Result(property = "finished",column = "finished"),
    })
    @Select("SELECT * FROM Course WHERE course_id = #{courseId} ")
    Course getOne(Long courseId);

    @Delete("DELETE FROM Course WHERE course_id = #{courseId} ")
    void delete(Long courseId);

    @Insert("INSERT INTO Course(course_name,user_id,course_class,cover,course_code,finished) VALUES(#{courseName},#{userId},#{courseClass},#{cover},#{courseCode},#{finished}) ")
    void insert(Course course);

    @Update("UPDATE Course SET cover=#{cover},finished=#{finished} WHERE course_id =#{courseId}")
    void update(Course course);
}

package com.bhavya.rsql.conversion;

import com.bhavya.rsql.dto.Course;
import com.bhavya.rsql.entity.CourseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseConverter {

  public Course convert(CourseEntity  courseEntity){
    Course course = new Course();
    BeanUtils.copyProperties(courseEntity, course);
    return course;
  }

  public List<Course> convert(List<CourseEntity>  courseEntity){
    List<Course> courses = new ArrayList<>();
    for(CourseEntity courseEntity1: courseEntity){
      Course course = new Course();
      BeanUtils.copyProperties(courseEntity1, course);
      courses.add(course);
    }
    return courses;
  }
}

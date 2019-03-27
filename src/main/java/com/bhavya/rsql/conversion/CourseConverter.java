package com.bhavya.rsql.conversion;

import com.bhavya.rsql.dto.Course;
import com.bhavya.rsql.entity.CourseEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter {

  public Course convert(CourseEntity  courseEntity){
    Course course = new Course();
    BeanUtils.copyProperties(courseEntity, course);
    return course;
  }
}

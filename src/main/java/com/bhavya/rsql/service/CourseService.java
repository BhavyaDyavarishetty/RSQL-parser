package com.bhavya.rsql.service;

import com.bhavya.rsql.conversion.CourseConverter;
import com.bhavya.rsql.dto.Course;
import com.bhavya.rsql.entity.CourseEntity;
import com.bhavya.rsql.exception.ObjectNotFoundException;
import com.bhavya.rsql.repository.CourseRepository;
import cz.jirutka.rsql.parser.RSQLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service public class CourseService extends SpecService{

  @Autowired private RSQLParser parser;

  @Autowired CourseRepository courseRepository;

  @Autowired CourseConverter courseConverter;

  public Course getCourse(String filter) throws ObjectNotFoundException {
    Specification<CourseEntity> spec = getSpec(filter);
    CourseEntity courseEntity = courseRepository.findOne(spec)
        .orElseThrow(() -> new ObjectNotFoundException("Course not found"));

    return courseConverter.convert(courseEntity);
  }

  public List<Course> getCourses(String filter) {
    Specification<CourseEntity> spec = getSpec(filter);
    List<CourseEntity> courseEntity = courseRepository.findAll(spec);

    return courseConverter.convert(courseEntity);
  }

}

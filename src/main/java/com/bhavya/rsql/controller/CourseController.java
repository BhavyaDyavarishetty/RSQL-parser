package com.bhavya.rsql.controller;

import com.bhavya.rsql.dto.Course;
import com.bhavya.rsql.exception.ObjectNotFoundException;
import com.bhavya.rsql.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

  private final CourseService courseService;

  @Autowired public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  @RequestMapping("/")
  public String healthCheck() {
    return "OK";
  }

  @GetMapping(value = "/course")
  public Course getCourse(@RequestParam(value = "filter") String filter) throws ObjectNotFoundException {
    return courseService.getCourse(filter);
  }

  @GetMapping(value = "/courses")
  public List<Course> getCourses(@RequestParam(value = "filter") String filter) throws ObjectNotFoundException {
    return courseService.getCourses(filter);
  }
}

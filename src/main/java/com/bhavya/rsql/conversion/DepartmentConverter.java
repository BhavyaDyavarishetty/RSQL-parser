package com.bhavya.rsql.conversion;

import com.bhavya.rsql.dto.Course;
import com.bhavya.rsql.dto.Department;
import com.bhavya.rsql.entity.CourseEntity;
import com.bhavya.rsql.entity.DepartmentEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentConverter {

  public Department convert(DepartmentEntity departmentEntity){
    Department department = new Department();
    BeanUtils.copyProperties(departmentEntity, department);
    if(departmentEntity.getCourseEntity()!= null && departmentEntity.getCourseEntity().size()>0){
      List<Course> list = new ArrayList<>();
      for(CourseEntity courseEntity: departmentEntity.getCourseEntity()){
        Course course = new Course();
        BeanUtils.copyProperties(courseEntity, course);
        list.add(course);
      }
      department.setCourses(list);
    }
    return department;
  }
}

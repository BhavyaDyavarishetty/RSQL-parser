package com.bhavya.rsql.conversion;

import com.bhavya.rsql.dto.Department;
import com.bhavya.rsql.entity.DepartmentEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class DepartmentConverter {

  public Department convert(DepartmentEntity departmentEntity){
    Department department = new Department();
    BeanUtils.copyProperties(departmentEntity, department);
    return department;
  }
}

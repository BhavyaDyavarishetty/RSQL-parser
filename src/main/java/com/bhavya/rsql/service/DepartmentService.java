package com.bhavya.rsql.service;

import com.bhavya.rsql.conversion.DepartmentConverter;
import com.bhavya.rsql.dto.Department;
import com.bhavya.rsql.entity.DepartmentEntity;
import com.bhavya.rsql.exception.ObjectNotFoundException;
import com.bhavya.rsql.repository.DepartmentRepository;
import cz.jirutka.rsql.parser.RSQLParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service public class DepartmentService extends SpecService{

  @Autowired private RSQLParser parser;

  @Autowired DepartmentRepository departmentRepository;

  @Autowired DepartmentConverter departmentConverter;

  public Department getDepartment(String filter) throws ObjectNotFoundException {
    Specification<DepartmentEntity> spec = getSpec(filter);
    DepartmentEntity departmentEntity = departmentRepository.findOne(spec)
        .orElseThrow(() -> new ObjectNotFoundException("Department not found"));

    return departmentConverter.convert(departmentEntity);
  }
}

package com.bhavya.rsql.controller;

import com.bhavya.rsql.dto.Department;
import com.bhavya.rsql.exception.ObjectNotFoundException;
import com.bhavya.rsql.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController public class DepartmentController {

  private final DepartmentService departmentService;

  @Autowired public DepartmentController(DepartmentService departmentService) {
    this.departmentService = departmentService;
  }

  @GetMapping(value = "/department")
  public Department getCourse(@RequestParam(value = "filter") String filter) throws ObjectNotFoundException {
    return departmentService.getDepartment(filter);
  }
}

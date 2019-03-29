package com.bhavya.rsql.dto;

import lombok.Data;

import java.util.List;

@Data
public class Department {

  private Integer id;
  private String departmentName;
  private String location;
  private List<Course> courses;
}

package com.bhavya.rsql.dto;

import lombok.Data;

@Data
public class Course {

  private Integer id;
  private String courseName;
  private Integer duration;
  private Department department;
}

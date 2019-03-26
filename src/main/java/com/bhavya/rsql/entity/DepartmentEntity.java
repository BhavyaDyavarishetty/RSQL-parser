package com.bhavya.rsql.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "department")
public class DepartmentEntity {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "department_name")
  private String departmentName;

  @Basic
  private String location;

  @OneToMany
  private List<CourseEntity> courseEntity;
}


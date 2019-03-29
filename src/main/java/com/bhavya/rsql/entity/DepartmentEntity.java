package com.bhavya.rsql.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "department")
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

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "departmentEntity")
  private List<CourseEntity> courseEntity;
}


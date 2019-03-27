package com.bhavya.rsql.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "course")
@Table(name = "course")
public class CourseEntity {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "course_name")
  private String courseName;

  @Basic
  private Integer duration;

  @ManyToOne
  private DepartmentEntity departmentEntity;

  @ManyToMany
  private List<StudentEntity> students;
}

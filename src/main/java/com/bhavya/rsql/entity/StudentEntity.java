package com.bhavya.rsql.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "student")
public class StudentEntity {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  private Integer id;

  @Basic
  private String name;

  @Basic
  private String email;

  @ManyToMany
  private List<CourseEntity> courses;
}

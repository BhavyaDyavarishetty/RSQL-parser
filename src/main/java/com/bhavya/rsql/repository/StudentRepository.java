package com.bhavya.rsql.repository;

import com.bhavya.rsql.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<StudentEntity, Integer> {
}

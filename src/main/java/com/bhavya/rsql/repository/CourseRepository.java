package com.bhavya.rsql.repository;

import com.bhavya.rsql.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CourseRepository extends JpaRepository<CourseEntity, Integer>, JpaSpecificationExecutor<CourseEntity> {
}

package com.example.selflearning.demo.hibernate.cache.firstlevel.repository;

import com.example.selflearning.demo.hibernate.cache.firstlevel.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface StudentRepository extends CrudRepository<Student, Serializable> {

}

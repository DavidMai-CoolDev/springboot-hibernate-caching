package com.example.selflearning.demo.hibernate.cache.firstlevel.service;

import com.example.selflearning.demo.hibernate.cache.firstlevel.entity.Student;
import com.example.selflearning.demo.hibernate.cache.firstlevel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//@Service
@Component
public interface StudentService {
    public Student saveStudent(Student student);

    public Student getStudent(int id) throws InterruptedException;
    public List<Student> getAll();
}


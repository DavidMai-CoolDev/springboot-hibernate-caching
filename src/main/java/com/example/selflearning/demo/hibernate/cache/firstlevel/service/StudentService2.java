package com.example.selflearning.demo.hibernate.cache.firstlevel.service;

import com.example.selflearning.demo.hibernate.cache.firstlevel.entity.Student;
import com.example.selflearning.demo.hibernate.cache.firstlevel.repository.StudentRepository;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.Optional;

public class StudentService2 {
//    @Autowired
//    private StudentRepository studentRepository;
//    @Transactional
//    @Cacheable(value = "student-cache", key = "'studentcache'+#id")
//    public Student getStudent(int id) throws InterruptedException {
//
//        Optional<Student> studentResponse = studentRepository.findById(id);
//        Student student = studentResponse.get();
////        int size = CacheManager.ALL_CACHE_MANAGERS.get(0)
////                .getCache("com.example.selflearning.demo.hibernate.cache.firstlevel.entity.Student").getSize();
////        System.out.println("the size of the cache is: " +size);
//        return student;

}

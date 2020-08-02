package com.example.selflearning.demo.hibernate.cache.firstlevel.impl;

import com.example.selflearning.demo.hibernate.cache.firstlevel.entity.Student;
import com.example.selflearning.demo.hibernate.cache.firstlevel.repository.StudentRepository;
import com.example.selflearning.demo.hibernate.cache.firstlevel.service.StudentService;
import com.example.selflearning.demo.hibernate.cache.firstlevel.util.HibernateJavaConfig;
import net.sf.ehcache.CacheManager;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public Student saveStudent(Student student) {
        Student response = studentRepository.save(student);
        return response;
    }

    @Transactional
    @Cacheable(value = "student-cache", key = "'studentcache'+#id")
    public Student getStudent(int id) throws InterruptedException {
//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        session.beginTransaction();
//
//        Student student = session.load(Student.class,id);
//        System.out.println(student);
//        session.getTransaction().commit();
//        session.close();
//        System.out.println();
        System.out.println("Getting from database");
        Optional<Student> studentResponse = studentRepository.findById(id);
        Student student = studentResponse.get();
           List<Student> students =  entityManager.createNativeQuery("select * from  student").getResultList();
        return student;
    }

    @Transactional
    @Cacheable(value = "getallstudent-cache")
    public List<Student> getAll() {
        System.out.println("Getting from database");
        List<Student> students =  entityManager.createNativeQuery("select * from  student").getResultList();
        return students;
    }

}

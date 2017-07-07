package com.qibao.service.impl;

import com.qibao.model.StudentMapper;
import com.qibao.model.dao.Student;
import com.qibao.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by giozola on 2017/7/6.
 */
@Service
public class StudentService implements IStudentService{

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student getByName() {
        Student student = new Student();
        student.setName("zhangsan");
        student.setAge(45);
        student = studentMapper.selectOne(student);
        System.out.println("班级为："+student.getClasses());
        return student;
    }
}

package com.qibao.service;

import com.qibao.model.dao.Student;
import org.springframework.stereotype.Service;

/**
 * Created by giozola on 2017/7/6.
 */
public interface IStudentService {
    Student getByName();
}

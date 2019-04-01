package com.hmily.noteblog.service.api;


import java.util.List;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;
import com.hmily.noteblog.entity.Student;

/**
 * Created by zyzhmily on 2018/8/21.
 */
public interface StudentService extends IService<Student> {

    List<Student> findAllStudent();
    List<Student> findSomeColumn();

    void deleteById(Integer id);

    void updateByPrimarKeySelective(Student student);

    void saveStudent(Student student);

    Page<Student> findAllStudentPage(Page<Student> page);

    List<Student> findStuByGender(Integer gender);

}

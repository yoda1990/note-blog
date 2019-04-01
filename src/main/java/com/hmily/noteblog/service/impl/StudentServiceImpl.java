package com.hmily.noteblog.service.impl;


import java.util.List;

import com.hmily.noteblog.entity.Student;
import com.hmily.noteblog.service.api.StudentService;
import com.hmily.noteblog.service.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

/**
 * Created by zyzhmily on 2018/8/21.
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper,Student> implements StudentService {

    @Override
    public List<Student> findAllStudent() {
        // TODO Auto-generated method stub
        return baseMapper.findAllStudent();
    }

    @Override
    public List<Student> findSomeColumn() {
        // TODO Auto-generated method stub
        return baseMapper.findSomeColumn();
    }

    @Override
    public void deleteById(Integer id) {
        baseMapper.deleteById(id);

    }

    @Override
    public void updateByPrimarKeySelective(Student student) {
        baseMapper.updateById(student);

    }

    @Override
    public void saveStudent(Student student) {
        baseMapper.saveStudent(student);

    }

    @Override
    public Page<Student> findAllStudentPage(Page<Student> page) {
        // TODO Auto-generated method stub
        page.setRecords(baseMapper.findAllStudentPage(page));
        return page;
    }

    @Override
    public List<Student> findStuByGender(Integer gender) {
        // TODO Auto-generated method stub
        return baseMapper.findStuByGender(gender);
    }


}

package com.sias.Service.Impl;


import com.sias.Service.StudentService;
import com.sias.dao.StudentMapper;
import com.sias.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> selectAll() {

        List<Student> list=studentMapper.selectAll();
        return list;
    }

    @Override
    public void deleteByID(int id) {
        studentMapper.deleteById(id);
    }

    @Override
    public Student selectById(int id) {
        Student ss=studentMapper.selectByID(id);

        return ss;
    }

    @Override
    public void updateById( Student student) {
        studentMapper.updateByID(student);
    }

    @Override
    public boolean insertI(Student student) {
        String name = student.getName();

        if (studentMapper.selectBYY(name)==1){
            return false;
        }else {
            studentMapper.insertI(student);
            return true;
        }
    }
}

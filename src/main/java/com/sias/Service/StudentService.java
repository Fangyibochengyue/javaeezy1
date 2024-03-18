package com.sias.Service;

import com.sias.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    List<Student> selectAll();

    void deleteByID(int id);

    Student selectById(int id);

    void updateById(Student student);

    boolean insertI(Student student);
}

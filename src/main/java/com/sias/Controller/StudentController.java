package com.sias.Controller;
import com.sias.Service.StudentService;
import com.sias.common.R;
import com.sias.pojo.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Slf4j
public class StudentController {
    @Autowired
    private StudentService studentService;
    /**
     * 展示数据
     * @return
     */
    @GetMapping("/students")
     public R<List<Student>> selectAll(){
        List<Student> list=studentService.selectAll();
        return R.success(list);
    }
    /**
     * 删除员工信息
     * @param id
     * @return
     */
    @DeleteMapping("/students/{id}")
    public R<String> deleteByID(@PathVariable int id){
        studentService.deleteByID(id);
        return R.success("删除成功");
    }

    /**
     * 回显信息
     * @param id
     * @return
     */
    @GetMapping("/students/{id}")
    public R<Student> selectByID(@PathVariable int id){
        Student s=studentService.selectById(id);
        return R.success(s);
    }

    /**
     * 根据id修改对象
     * @param id
     * @param student
     * @return
     */
    @PutMapping("/students/{id}")
    public R<String> updateById(@PathVariable int id,@RequestBody Student student){
        student.setStuNO(id);
        log.info("{}",student);
        studentService.updateById(student);
        return R.success("修改成功");
    }

    /**
     * 添加用户信息
     * @param student
     * @return
     */
    @PostMapping("/students")
    private R<String> insertI(@RequestBody Student student){
        boolean b = studentService.insertI(student);
        if (b){
            return R.success("添加成功");
        }else {
            return R.error("用户已经存在");
        }
    }
}

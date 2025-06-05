package com.mozisun.springboottlias.server.impl;


import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mozisun.springboottlias.header.enums.CommonExceptionEnum;
import com.mozisun.springboottlias.header.exception.ExceptionCase;
import com.mozisun.springboottlias.mapper.StudentMapper;
import com.mozisun.springboottlias.model.Dto.StudentDto;
import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.vo.StudentVo;
import com.mozisun.springboottlias.server.StudentServer;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/17 18:11
 * @description
 */
@Service
public class StudentServerImpl implements StudentServer {

  @Resource
  private StudentMapper studentMapper;

  @Override
  public PageResult<StudentVo> page(StudentQuery query) {
    PageHelper.startPage(query.getPage(), query.getPageSize());
    List<StudentVo> studentList = studentMapper.selectStudentList(query);
    PageInfo<StudentVo> pageInfo = new PageInfo<>(studentList);
    PageResult<StudentVo> result = new PageResult<>();
    result.setRows(pageInfo.getList());
    result.setTotal(pageInfo.getTotal());
    return result;
  }

  @Override
  public Student getById(Integer id) {
    return studentMapper.selectStudentById(id);
  }

  @Override
  public void putStudent(StudentDto student) {

    Student putStu = new Student();
    BeanUtil.copyProperties(student, putStu);
    putStu.setUpdateTime(LocalDateTime.now());
    studentMapper.updateStudent(putStu);

  }

  @Override
  public void putViolation(Integer id, Short score) {
    Student student = studentMapper.selectStudentById(id);
    if (student == null) {
      throw new RuntimeException("学生不存在");
    }
    Student build = Student.builder()
                           .id(id)
                           .violationCount((short) (student.getViolationCount() + 1))
                           .violationScore((short) (student.getViolationScore() + score))
                           .updateTime(LocalDateTime.now())
                           .build();
    studentMapper.updateStudent(build);
  }

  @Override
  public void addStudent(StudentDto addStu) {
    checkAddStudent(addStu);

    Student stu = new Student();
    BeanUtil.copyProperties(addStu, stu);
    stu.setCreateTime(LocalDateTime.now());
    stu.setUpdateTime(LocalDateTime.now());
    studentMapper.insertStudent(stu);
  }

  @Override
  public void delById(Integer[] ids) {
    studentMapper.deleteStudentByIdBatch(ids);
  }


  public void checkAddStudent(StudentDto student) {
    if (student == null || student.getNo() == null || student.getNo().isBlank() ||
        student.getPhone() == null || student.getPhone().isBlank() || student.getIdCard() == null ||
        student.getIdCard().isBlank()) {
      ExceptionCase.cast(CommonExceptionEnum.STUDENT_PARAM_INVALID);
    }
    Student byNo = studentMapper.selectStudentByNo(student.getNo());
    if (byNo != null) {
      ExceptionCase.cast(CommonExceptionEnum.STUDENT_NO_EXISTS);
    }
    Student byPhone = studentMapper.selectStudentByPhone(student.getPhone());
    if (byPhone != null) {
      ExceptionCase.cast(CommonExceptionEnum.STUDENT_PHONE_EXISTS);
    }

    Student byIdCard = studentMapper.selectStudentByIdCard(student.getIdCard());
    if (byIdCard != null) {
      ExceptionCase.cast(CommonExceptionEnum.STUDENT_ID_CARD_EXISTS);
    }


  }
}
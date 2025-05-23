package com.mozisun.springboottlias.server;

import com.mozisun.springboottlias.model.Dto.StudentDto;
import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.vo.StudentVo;

/**
 * @author MoZi
 * @createTime 2025/5/17 18:11
 */
public interface StudentServer {

  PageResult<StudentVo> page(StudentQuery query);

  Student getById(Integer id);

  void putStudent(StudentDto student);

  void putViolation(Integer id, Short score);

  void addStudent(StudentDto student);

  void delById(Integer[] ids);
}

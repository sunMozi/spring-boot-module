package com.mozisun.springboottlias.server.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mozisun.springboottlias.mapper.StudentMapper;
import com.mozisun.springboottlias.model.Dto.StudentQuery;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.model.vo.StudentVo;
import com.mozisun.springboottlias.server.StudentServer;
import jakarta.annotation.Resource;
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
}
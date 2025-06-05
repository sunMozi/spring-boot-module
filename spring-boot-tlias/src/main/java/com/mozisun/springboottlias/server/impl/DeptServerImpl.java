package com.mozisun.springboottlias.server.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mozisun.springboottlias.header.enums.CommonExceptionEnum;
import com.mozisun.springboottlias.header.exception.ExceptionCase;
import com.mozisun.springboottlias.mapper.DeptMapper;
import com.mozisun.springboottlias.mapper.EmpMapper;
import com.mozisun.springboottlias.model.Dto.PageQuery;
import com.mozisun.springboottlias.model.entiry.Dept;
import com.mozisun.springboottlias.model.entiry.Emp;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.server.DeptServer;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/11 11:22
 * @description
 */
@Service
@Slf4j
public class DeptServerImpl implements DeptServer {

  @Resource
  private DeptMapper deptMapper;

  @Resource
  private EmpMapper empMapper;


  @Override
  public Dept getDeptById(Integer id) {
    if (id == null || id < 1) {
      throw new RuntimeException("参数校验");
    }
    log.info("查询部门id为{}的部门信息", id);
    return deptMapper.selectDeptById(id);
  }

  @Override
  public void putDept(Dept dept) {
    if (dept == null || dept.getName().isEmpty() || dept.getId() < 0) {
      throw new RuntimeException("参数错误");
    }
    Dept byName = deptMapper.selectDeptByName(dept.getName());
    if (byName != null && !byName.getId().equals(dept.getId())) {
      ExceptionCase.cast(CommonExceptionEnum.DEM_ALREADY_EXISTS);
    }
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.updateDept(dept);
    log.info("更新部门id为{}的部门信息", dept.getId());
  }

  @Override
  public List<Dept> deptList() {
    return deptMapper.selectDeptList();
  }


  @Override
  public PageResult<Dept> deptAll(PageQuery query) {
    PageHelper.startPage(query.getPage(), query.getPageSize());
    List<Dept> depts = deptMapper.selectDeptList();
    Page<Dept> page = (Page<Dept>) depts;
    log.info("查询所有部门信息 : {}", depts);
    return new PageResult<>(page.getTotal(), page.getResult());
  }

  @Override
  public void addDept(Dept dept) {
    Dept newDept = deptMapper.selectDeptByName(dept.getName());
    if (newDept != null) {
      ExceptionCase.cast(CommonExceptionEnum.DEM_ALREADY_EXISTS);
    }
    dept.setCreateTime(LocalDateTime.now());
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.insertDept(dept);
    log.info("添加部门信息 : {}", dept);
  }

  @Override
  public void delById(Integer id) {
    List<Emp> empList = empMapper.selectEmpByDeptId(id);
    if (!empList.isEmpty()) {
      ExceptionCase.cast(CommonExceptionEnum.DEPT_HAS_EMP);
    }
    deptMapper.deleteById(id);
  }
}
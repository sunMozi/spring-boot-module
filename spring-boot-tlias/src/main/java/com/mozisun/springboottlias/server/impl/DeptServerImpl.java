package com.mozisun.springboottlias.server.impl;


import com.mozisun.springboottlias.mapper.DeptMapper;
import com.mozisun.springboottlias.model.entiry.Dept;
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
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.updateDept(dept);
    log.info("更新部门id为{}的部门信息", dept.getId());
  }


  @Override
  public List<Dept> deptAll() {
    List<Dept> depts = deptMapper.selectDeptList();
    log.info("查询所有部门信息 : {}", depts);
    return depts;
  }

  @Override
  public void addDept(Dept dept) {
    dept.setCreateTime(LocalDateTime.now());
    dept.setUpdateTime(LocalDateTime.now());
    deptMapper.insertDept(dept);
    log.info("添加部门信息 : {}", dept);
  }

  @Override
  public void delById(Integer id) {
    deptMapper.deleteById(id);
  }
}
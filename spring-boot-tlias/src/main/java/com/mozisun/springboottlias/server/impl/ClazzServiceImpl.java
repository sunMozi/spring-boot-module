package com.mozisun.springboottlias.server.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mozisun.springboottlias.mapper.ClazzMapper;
import com.mozisun.springboottlias.mapper.StudentMapper;
import com.mozisun.springboottlias.model.Dos.ClazzListDo;
import com.mozisun.springboottlias.model.Dto.ClazzPageQuery;
import com.mozisun.springboottlias.model.entiry.Clazz;
import com.mozisun.springboottlias.model.entiry.Student;
import com.mozisun.springboottlias.model.result.PageResult;
import com.mozisun.springboottlias.server.ClazzService;
import jakarta.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

/**
 * @author moZiA
 * @date 2025/5/11 19:49
 * @description
 */
@Service
public class ClazzServiceImpl implements ClazzService {

  @Resource
  private ClazzMapper clazzMapper;

  @Resource
  private StudentMapper studentMapper;


  @Override
  public PageResult<ClazzListDo> getClazzList(ClazzPageQuery clazzPageQuery) {
    PageHelper.startPage(clazzPageQuery.getPage(), clazzPageQuery.getPageSize());
    Page<ClazzListDo> clazzList = clazzMapper.selectClazzList(clazzPageQuery);
    List<ClazzListDo> listDoList = clazzList.getResult();
    LocalDate now = LocalDate.now();
    for (ClazzListDo clazzListDo : listDoList) {
      LocalDate begin = clazzListDo.getBeginDate();
      LocalDate end = clazzListDo.getEndDate();

      if (end.isBefore(now)) {
        clazzListDo.setStatus("已结课");
      } else if (begin.isAfter(now)) {
        clazzListDo.setStatus("未开始");
      } else {
        clazzListDo.setStatus("在读");
      }

    }
    PageResult<ClazzListDo> pageResult = new PageResult<>();
    pageResult.setTotal(clazzList.getTotal());
    pageResult.setRows(clazzList.getResult());
    return pageResult;
  }

  @Override
  public void addClazz(Clazz clazz) {
    clazz.setCreateTime(LocalDateTime.now());
    clazz.setUpdateTime(LocalDateTime.now());

    clazzMapper.insertClazz(clazz);
  }

  @Override
  public void delById(Integer id) {
    if (id == null || id <= 0) {
      throw new RuntimeException("数据错误");
    }
    List<Student> clazz = studentMapper.selectStudentByClazzId();

    if (clazz != null) {
      throw new RuntimeException("班级有学生,不可 删除");
    }

    clazzMapper.deleteById(id);
  }

  @Override
  public Clazz getById(Integer id) {
    return clazzMapper.selectClazzById(id);
  }

  @Override
  public void putClazz(Clazz clazz) {
    Clazz clazzById = clazzMapper.selectClazzById(clazz.getId());
    if (clazzById == null) {
      throw new RuntimeException("id 不存在");
    }
    Clazz byClazzName = clazzMapper.selectClazzListByClazzName(clazz.getName());

    if (byClazzName != null) {
      if (!Objects.equals(byClazzName.getId(), clazz.getId())) {
        throw new RuntimeException("班级已存在");
      }
    }

    clazz.setUpdateTime(LocalDateTime.now());
    clazzMapper.updateClazz(clazz);
  }

  @Override
  public List<ClazzListDo> list() {
    Page<ClazzListDo> clazzList = clazzMapper.selectClazzList(null);
    return clazzList.getResult();
  }
}
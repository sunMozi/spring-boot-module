package com.mozisun.springboottlias.server.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mozisun.springboottlias.header.enums.CommonExceptionEnum;
import com.mozisun.springboottlias.header.exception.ExceptionCase;
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
import java.util.Optional;
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
    return new PageResult<>(clazzList.getTotal(), clazzList.getResult());
  }

  @Override
  public void addClazz(Clazz clazz) {
    // 校验：班级名称唯一
    validateClazzNameUnique(clazz.getName(), null);

    clazz.setCreateTime(LocalDateTime.now());
    clazz.setUpdateTime(LocalDateTime.now());

    clazzMapper.insertClazz(clazz);
  }

  @Override
  public void delById(Integer id) {
    // 参数校验
    if (id == null || id <= 0) {
      ExceptionCase.cast(CommonExceptionEnum.CLASS_ID_INVALID);
    }

    // 查询该班级下是否存在学生
    List<Student> studentList = studentMapper.selectStudentByClazzId(id);
    if (!studentList.isEmpty()) {
      ExceptionCase.cast(CommonExceptionEnum.CLASS_HAS_STUDENTS);
    }

    // 执行删除，检查是否成功
    int deleted = clazzMapper.deleteById(id);
    if (deleted == 0) {
      ExceptionCase.cast(CommonExceptionEnum.USER_NOT_EXIST);
    }
  }


  @Override
  public Clazz getById(Integer id) {
    return clazzMapper.selectClazzById(id);
  }

  @Override
  public void putClazz(Clazz clazz) {
    // 校验：班级是否存在
    Clazz clazzById = clazzMapper.selectClazzById(clazz.getId());
    if (clazzById == null) {
      ExceptionCase.cast(CommonExceptionEnum.CLAZZ_NOT_EXIST);
    }

    // 校验：班级名称唯一（排除自己）
    validateClazzNameUnique(clazz.getName(), clazz.getId());

    clazz.setUpdateTime(LocalDateTime.now());

    int updated = clazzMapper.updateClazz(clazz);
    if (updated == 0) {
      ExceptionCase.cast(CommonExceptionEnum.CLAZZ_NOT_EXIST);
    }
  }


  @Override
  public List<ClazzListDo> list() {
    Page<ClazzListDo> clazzList = clazzMapper.selectClazzList(null);
    return clazzList.getResult();
  }


  private void validateClazzNameUnique(String name, Integer selfId) {
    Optional.ofNullable(clazzMapper.selectClazzListByClazzName(name))
            .filter(existing -> !Objects.equals(existing.getId(), selfId))
            .ifPresent(existing -> ExceptionCase.cast(CommonExceptionEnum.CLAZZ_NAME_ALREADY_EXISTS));
  }

}
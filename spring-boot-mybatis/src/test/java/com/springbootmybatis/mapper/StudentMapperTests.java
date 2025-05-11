package com.springbootmybatis.mapper;

import com.springbootmybatis.pojo.Student;
import jakarta.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("mybatis 学生 dao 测试")
public class StudentMapperTests {

  @Resource
  private StudentMapper studentMapper;

  @Test
  @DisplayName("查询所有学生")
  public void testSelectAll() {
    List<Student> students = studentMapper.selectAll();
    students.forEach(System.out::println);
  }

  @Test
  @DisplayName("添加新学生")
  public void testInsertStudent() {
    Student student = Student.builder()
                             .id(null)
                             .name("张三")
                             .no("202232313")
                             .gender(1)
                             .phone("18888888888")
                             .idCard("32233")
                             .degree(6)
                             .graduationDate(LocalDate.now())
                             .createTime(LocalDateTime.now())
                             .updateTime(LocalDateTime.now())
                             .build();

    Integer i = studentMapper.insertStudent(student);
    System.out.println(i);
  }

  @Test
  @DisplayName("更新学生信息")
  public void testSelectStudentById() {
    Student student = Student.builder()
                             .id(11)
                             .no("00111110")
                             .phone("10077777777")
                             .idCard("22222222222")
                             .build();
    Integer i = studentMapper.updateStudent(student);
    System.out.println(i);

  }


  @Test
  @DisplayName("根据id查询Student")
  public void selectStudentById() {
    Student student = studentMapper.selectStudentById(1);
    Assertions.assertNotNull(student);
    System.out.println(student);
  }

  @Test
  public void deleteStudentById() {
    Integer row = studentMapper.deleteStudentById(1);
    Assertions.assertNotNull(row);
    System.out.println(row);
  }

}
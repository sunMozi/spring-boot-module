package com.spring_boot.springboothello;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.spring_boot.springboothello.pojo.Student;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moZiA
 * @date 2025/5/4 16:19
 * @description
 */
@SpringBootTest
public class JacksonTests {

  private Student student;
  private JsonMapper jsonMapper;

  @BeforeEach
  public void info() {
    System.out.println("aaa");
    student = new Student();
    student.setAddress("杭州");
    student.setName("Tom");
    student.setAge(23);
    List<String> list = new ArrayList();
    list.add("吃饭");
    list.add("睡觉");
    list.add("打豆豆");
    student.setHoppyList(list);
    jsonMapper = new JsonMapper();
    System.out.println(student);
  }

  @Test
  public void testObj2json() throws JsonProcessingException {
    String jsonStr = jsonMapper.writeValueAsString(student);
    System.out.println(jsonStr);
  }

}
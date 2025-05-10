package com.webdemo.server;


import com.webdemo.pojo.Student;
import java.util.List;

/**
 * @author moZiA
 * @date 2025/5/6 10:20
 * @description
 */

public interface StudentServer {

  List<Student> getStudentList();

}
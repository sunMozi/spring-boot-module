package com.webdemo;


import org.junit.jupiter.api.Test;

/**
 * @author moZiA
 * @date 2025/5/10 18:22
 * @description
 */
public class Tests {

  @Test
  public void test() {
    String s6 = new String("1") + new String("1");
    String s6intern = s6.intern();
    String s7 = "11";
    System.out.println(s6intern == s6);
    System.out.println(s6intern == s7);


  }

}
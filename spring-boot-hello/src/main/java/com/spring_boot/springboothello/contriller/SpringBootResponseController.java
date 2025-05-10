package com.spring_boot.springboothello.contriller;


import com.spring_boot.springboothello.pojo.User;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author moZiA
 * @date 2025/5/4 11:05
 * @description
 */
@Controller
public class SpringBootResponseController {


  private static final Logger logger = LoggerFactory.getLogger(SpringBootResponseController.class);

  @RequestMapping("response1")
  public String response1() {
    return "/html/success.html";
  }

  @RequestMapping("response2")
  public String response2() {
    return "redirect:https://www.baidu.com";
  }


  @RequestMapping("json")
  @ResponseBody
  public User json() {
    return new User(18, "Tom", 19);
  }


  @RequestMapping("json2")
  @ResponseBody
  public List<User> json2() {
    User tom = new User(18, "Tom", 19);
    User joke = new User(18, "Joke", 19);
    List<User> userList = new ArrayList<>();
    userList.add(tom);
    userList.add(joke);
    return userList;
  }


}

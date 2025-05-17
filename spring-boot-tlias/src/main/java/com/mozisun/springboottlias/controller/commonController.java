package com.mozisun.springboottlias.controller;


import com.mozisun.springboottlias.config.AppConfig;
import com.mozisun.springboottlias.model.result.Result;
import com.mozisun.springboottlias.utils.ThumbnailUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author moZiA
 * @date 2025/5/16 15:49
 * @description
 */
@Controller
public class commonController {

  @Resource
  private AppConfig appConfig;


  @PostMapping("/upload")
  @ResponseBody
  public Result<?> uploadImage(String username ,Integer age ,@RequestParam("file") MultipartFile file) {

    return Result.success();
  }

//  @PostMapping("/upload")
//  @ResponseBody
//  public Result<String> uploadImage(@RequestParam("file") MultipartFile file) throws Exception {
//
//    Path uploadDir = Paths.get(appConfig.getImage_dir()).normalize().toAbsolutePath();
//    Path targetPath = Path.of(uploadDir + "/" + file.getOriginalFilename());
//
//    //  保存文件
//    Files.createDirectories(uploadDir); // 确保目录存在
//    file.transferTo(targetPath);
//    String ImagePath = "http://127.0.0.1:8080" + "/thumb/" + file.getOriginalFilename();
//    return Result.success(ImagePath);
//
//  }


  public void getThumbnail(@PathVariable String imageName, HttpServletResponse response) {
    Path imagePath = Paths.get(appConfig.getImage_dir() + imageName);

    System.out.println(imagePath);

    byte[] processed = null;
    try {
      processed = ThumbnailUtil.generateThumbnail(Files.readAllBytes(imagePath),
                                                  2048,
                                                  2048,
                                                  true,
                                                  0.99);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    response.setContentType("image/jpeg");
    response.setHeader("Cache-Control", "public, max-age=604800");
    try {
      response.getOutputStream().write(processed);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }


}
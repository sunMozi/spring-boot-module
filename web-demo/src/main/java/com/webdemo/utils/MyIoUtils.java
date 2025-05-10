package com.webdemo.utils;


import cn.hutool.core.io.IoUtil;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author moZiA
 * @date 2025/5/5 17:13
 * @description
 */
@Component
@Log4j2
public class MyIoUtils {

  public List<String> getFileData(String filePath) {

    List<String> list = new ArrayList<>();
    try (
        InputStream in = this.getClass().getClassLoader().getResourceAsStream(filePath)
    ) {
      IoUtil.readLines(in, StandardCharsets.UTF_8, list);
    } catch (Exception e) {
      log.error("文件加载失败 数据访问层, 获取文件出现异常, 异常数据如下:{}", e.getMessage());
    }

    return list;
  }




}
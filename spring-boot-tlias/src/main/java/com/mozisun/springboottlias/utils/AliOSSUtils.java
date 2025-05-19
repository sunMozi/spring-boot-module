package com.mozisun.springboottlias.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.mozisun.springboottlias.properties.AliOSSProperties;
import jakarta.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * 阿里云 OSS 工具类
 */
@Component
public class AliOSSUtils {

  @Resource
  private AliOSSProperties aliOSSProperties;

  /**
   * 上传文件（使用配置默认参数）
   */
  public String upload(MultipartFile file) throws IOException {
    String originalFilename = file.getOriginalFilename();
    if (originalFilename == null) {
      throw new IllegalArgumentException("文件名不能为空");
    }

    // 生成唯一文件名
    String fileName = generateUniqueFileName(originalFilename);
    // 使用默认配置的存储桶
    return upload(aliOSSProperties.getBucketName(), fileName, file);
  }

  public String upload(String bucketName, String fileName, MultipartFile file) throws IOException {
    String endpoint = aliOSSProperties.getEndpoint();
    String accessKeyId = aliOSSProperties.getAccessKeyId();
    String accessKeySecret = aliOSSProperties.getAccessKeySecret();

    try (InputStream inputStream = file.getInputStream()) {
      OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
      ossClient.putObject(bucketName, fileName, inputStream);

      String url = buildObjectUrl(endpoint, bucketName, fileName);
      ossClient.shutdown();

      return url;
    }
  }


  private String generateUniqueFileName(String originalFilename) {
    String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
    return UUID.randomUUID() + fileExtension;
  }


  private String buildObjectUrl(String endpoint, String bucketName, String objectName) {
    String[] endpointParts = endpoint.split("//");
    String protocol = endpointParts[0];
    String domain = endpointParts[1];
    return String.format("%s//%s.%s/%s", protocol, bucketName, domain, objectName);
  }
}
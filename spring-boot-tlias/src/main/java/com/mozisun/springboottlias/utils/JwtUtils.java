package com.mozisun.springboottlias.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import javax.crypto.SecretKey;

public class JwtUtils {


  public static String createJWT(String base64SecretKey,
                                 long ttlMillis,
                                 Map<String, Object> claims) {
    try {
      // 1. 解码 Base64 密钥并校验长度
      byte[] keyBytes = java.util.Base64.getDecoder().decode(base64SecretKey);
      validateSecretKey(keyBytes);

      // 2. 生成 HMAC-SHA256 密钥
      SecretKey key = Keys.hmacShaKeyFor(keyBytes);

      // 3. 计算过期时间
      Instant now = Instant.now();
      Instant expiration = now.plusMillis(ttlMillis);

      // 4. 构建 JWT（自动处理类型转换）
      return Jwts.builder()
                 .setClaims(claims)  // 自动推断 String/Number/Boolean/Date 等类型
                 .setIssuedAt(Date.from(now))
                 .setExpiration(Date.from(expiration))
                 .signWith(key)
                 .compact();
    } catch (Exception e) {
      throw new JwtException("JWT 生成失败: " + e.getMessage(), e);
    }
  }


  public static Map<String, Object> parseJWT(String base64SecretKey, String token) {
    try {
      // 1. 解码 Base64 密钥
      byte[] keyBytes = java.util.Base64.getDecoder().decode(base64SecretKey);
      SecretKey key = Keys.hmacShaKeyFor(keyBytes);

      // 2. 解析并验证 JWT
      Claims claims = Jwts.parserBuilder()
                          .setSigningKey(key)
                          .build()
                          .parseClaimsJws(token)
                          .getBody();

      // 3. 返回不可修改的 Map（自动类型转换）
      return claims;
    } catch (Exception e) {
      throw new JwtException("JWT 解析失败: " + e.getMessage(), e);
    }
  }

  private static void validateSecretKey(byte[] keyBytes) {
    if (keyBytes.length < 32) {
      throw new IllegalArgumentException("密钥长度不足 256 位（需至少 32 字节）");
    }
  }

}
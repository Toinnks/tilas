package com.example.tilas;

import com.example.tilas.mapper.DeptMapper;
import com.example.tilas.mapper.EmpMapper;
;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.*;


@Slf4j
@SpringBootTest
class TilasApplicationTests {
    @Autowired
    DeptMapper deptMapper;

    @Autowired
    EmpMapper empMapper;

    @Test
    public void testGenJwt() {
        // 1. 准备 claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "itheima");

        // 2. 创建安全的 HMAC-SHA 密钥（必须至少 256 位 = 32 字节）
        String secret = "aXRjYXN0aXRjYXN0aXRjYXN0aXRjYXN0"; // 32 字符 = 32 字节（UTF-8）
        SecretKey key = Keys.hmacShaKeyFor(secret.getBytes());

        // 3. 构建 JWT
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000)) // 12 小时
                .signWith(key) // 使用 SecretKey 签名
                .compact();

        System.out.println(jwt);
    }


}

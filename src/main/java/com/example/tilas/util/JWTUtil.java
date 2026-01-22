package com.example.tilas.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JWTUtil {
    private static final String SECRET = "aXRjYXN0aXRjYNNAdfjlakjfljJJAN0aXRjYXN0";
    private static final Long EXPIRED = 1000*60*60*12L;
    public static String genJwt(Map<String , Object> claims) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

        // 3. 构建 JWT
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRED)) // 12 小时
                .signWith(key) // 使用 SecretKey 签名
                .compact();
        return jwt;
    }
    public static Claims parseJwt(String jwt) {
        SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

        // 解析 JWT
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)          // 设置签名密钥
                .build()
                .parseClaimsJws(jwt)         // 验证签名并解析
                .getBody();
        // 获取 payload
        return claims;
    }

}

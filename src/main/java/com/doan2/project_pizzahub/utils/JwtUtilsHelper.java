package com.doan2.project_pizzahub.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;

//B16

@Component
public class JwtUtilsHelper {

    @Value("${jwt.privateKey}")
    private String privateKey;

    public String generateToken(String data) {

        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(privateKey));
        String jws = Jwts.builder().setSubject(data).signWith(key).compact();

        return jws;
    }

    public boolean verifyToke(String token) {
        try {
            SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(privateKey));
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }

    }
}

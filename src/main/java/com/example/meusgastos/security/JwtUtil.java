package com.example.meusgastos.security;

import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.example.meusgastos.domain.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {
    @Value("${auth.jwt.secret}")
    private String jwtSecret;

    @Value("${auth.jwt-expiration-milliseg}")
    private Long jwtExpirationMilliseg;

    // Metodo para gerar o token
    public String gerarToken(Authentication authentication) {
        // Ele pega a data atual e soma com o tempo de expiração
        Date dataExpiracao = new Date(new Date().getTime() + jwtExpirationMilliseg);
        // Pega o usuário autenticado
        Usuario usuario = (Usuario) authentication.getPrincipal();

        try {
            // Cria a chave secreta para assinar o token
            Key secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes("UTF-8"));

            // Gera o token JWT
            return Jwts.builder()
                    .setSubject(usuario.getUsername())
                    .setIssuedAt(new Date())
                    .setExpiration(dataExpiracao)
                    .signWith(secretKey)
                    .compact();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

    // Metodo para pegar as permissões do token
    private Claims getClaims(String token) {
        try {
            Key secretKey = Keys.hmacShaKeyFor(jwtSecret.getBytes("UTF-8"));
            Claims claims = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Metodo para pegar o email do usuário no token
    public String getUserName(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    // Metodo para validar o token
    public boolean isValidToken(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            String email = claims.getSubject();
            Date dataExpiracao = claims.getExpiration();
            Date agora = new Date(System.currentTimeMillis());
            if (email != null && agora.before(dataExpiracao)) {
                return true;
            }
        }
        return false;
    }
}

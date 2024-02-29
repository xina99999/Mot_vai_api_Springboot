//package com.sample.restful.Provider;
//
//import com.sample.restful.entities.User;
//import com.sample.restful.models.responses.UserDTO;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.swing.*;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.function.Function;
//
//public class JwtTokenProvider {
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private Long expiration;
//
//    public  String genarateToken(User user)
//    {
//        Map<String,Object> claims = new HashMap<>();
//        return createToken(claims,user.getUserName());
//    }
//
//    private String createToken(Map<String, Object> claims, String subject)
//    {
//        Date now = new Date();
//        Date expirationDate = new Date(now.getTime()+expiration);
//
//        return Jwts.builder()
//                .setClaims(claims).setSubject(subject).setIssuedAt(now)
//                .setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512,secret)
//                .compact();
//    }
//
//    public Boolean validateToken ( String token , User user)
//    {
//        final  String username = extractUsername(token);
//        return (username.equals(user.getUserName()) && !isTokenExpired(token));
//    }
//
//    public  String extractUsername(String token)
//    {
//        return extractClaim(token,Claims::getSubject);
//    }
//
//    public Date extractExpiration(String token)
//    {
//        return extractClaim(token,Claims::getExpiration);
//    }
//
//    private <T> T extractClaim(String token, Function<Claims,T> claimsResolver)
//    {
//        final  Claims claims = extractAllClaims(token);
//        return claimsResolver.apply(claims);
//    }
//
//    private Claims extractAllClaims(String token)
//    {
//        return  Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
//
//    }
//
//    private Boolean isTokenExpired(String token)
//    {
//        final  Date expiration = extractExpiration(token);
//        return expiration.before(new Date());
//    }
//}

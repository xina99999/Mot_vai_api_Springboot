//package com.sample.restful.controllers;
//
//import com.sample.restful.Provider.JwtTokenProvider;
//import com.sample.restful.entities.User;
//import com.sample.restful.models.responses.User_loginDTO;
//import com.sample.restful.repositories.JwtAuthenticationResponse;
//import com.sample.restful.services.UserService;
//
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/v1/auth")
//public class AuthController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenProvider jwtTokenProvider;
//
//    public ResponseEntity<?> Login (@RequestBody User_loginDTO userLoginDTO)
//    {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(User_loginDTO.from(User::getUserName,User_loginDTO.from(User::getPassword)));
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt = jwtTokenProvider.genarateToken(authentication);
//        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
//    }
//
//}

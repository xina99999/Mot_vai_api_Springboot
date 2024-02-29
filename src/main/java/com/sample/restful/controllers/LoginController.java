package com.sample.restful.controllers;

import com.sample.restful.entities.User;
import com.sample.restful.models.requests.LoginUseRequest;
import com.sample.restful.models.responses.User_loginDTO;
import com.sample.restful.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("")
    public ResponseEntity<User_loginDTO> login(@RequestBody LoginUseRequest request)
    {
        User user = userService.findByUserName(request.getUserName());
        if(request.getUserName().equals(user.getUserName()) && request.getPassword().equals(user.getPassword()))
        {
            return  new ResponseEntity<>(User_loginDTO.from(user), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}

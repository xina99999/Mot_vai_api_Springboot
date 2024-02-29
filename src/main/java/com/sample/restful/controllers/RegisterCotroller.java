package com.sample.restful.controllers;

import com.sample.restful.entities.User;
import com.sample.restful.models.requests.SaveUserRequest;
import com.sample.restful.models.responses.UserDTO;
import com.sample.restful.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/Register")
public class RegisterCotroller {
    @Autowired
    private UserService userService;

    @PostMapping("")
    ResponseEntity<UserDTO> register(@RequestBody SaveUserRequest request)
    {

        User user1 = userService.findByUserName(request.getUserName());
        if(user1==null && request.getPassword().length()>=6)
        {
            User user = userService.save(request);
            boolean isEqual = user.getUserName().equals(request.getUserName());
            if (user == null)
            {
                return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
            } else if(user.getPassword().length()>=6 )
            { if(isEqual == true)
            {
                return new ResponseEntity<>(UserDTO.from(user),HttpStatus.OK);
            } else
            {
                return  new ResponseEntity<>(UserDTO.from(user),HttpStatus.BAD_REQUEST);
            }
            }else {
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            }
        }
        else {
            return  new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
        }
    }


}

package com.sample.restful.controllers;

import com.sample.restful.entities.User;
import com.sample.restful.models.requests.LoginUseRequest;
import com.sample.restful.models.requests.SaveUserRequest;
import com.sample.restful.models.responses.UserDTO;
import com.sample.restful.models.responses.User_loginDTO;

import com.sample.restful.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/v1/User")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/register")
     ResponseEntity<UserDTO> register(@RequestBody SaveUserRequest request)
    {

        User user = userService.save(request);
        boolean isEqual = user.getUserName().equals(request.getUserName());
        if (user == null)
        {
            return  new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        } else if(user.getPassword().length()>=6 )
        { if(isEqual == false)
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

    @PostMapping("/delete")
    ResponseEntity<UserDTO> delete(@RequestParam("id") Long id) {
        User user = userService.findById(id);
        if (user == null) {
            userService.delete(user);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/list")
    ResponseEntity<List<UserDTO>> list()
    {
        List<UserDTO> user = userService.findAll().stream().map(UserDTO::from).toList();
        return  new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/detail/{id}")
    ResponseEntity<UserDTO> detail(@RequestParam("id") Long id)
    {
      User user = userService.findById(id);
      if (user != null)
      {
          return new ResponseEntity<>(UserDTO.from(user),HttpStatus.OK);
      }
      return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{userName}")
    public ResponseEntity<User_loginDTO> getbyUser( @PathVariable String userName   )
    {
        User user = userService.findByUserName(userName);
        return new ResponseEntity<>(User_loginDTO.from(user),HttpStatus.OK);
    }

    @PostMapping("/login")
    public  ResponseEntity<User_loginDTO> logins(@RequestBody LoginUseRequest request)
    {


        User user = userService.findByUserName(request.getUserName());

        if(user != null)
        {
         if (user.getPassword().equals(request.getPassword() )&& user.getUserName().equals(request.getUserName()))
         {
             return new ResponseEntity<>(User_loginDTO.from(user), HttpStatus.OK);
         } else {

             return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
         }
        } else {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

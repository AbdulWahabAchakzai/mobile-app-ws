package com.appdeveloperblog.app.ws.mobileappws.ui.controller;

import com.appdeveloperblog.app.ws.mobileappws.service.UserService;
import com.appdeveloperblog.app.ws.mobileappws.shared.dto.UserDto;
import com.appdeveloperblog.app.ws.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.appdeveloperblog.app.ws.mobileappws.ui.model.response.UserRest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public String getUser(){
        return "Get User called";
    }

    @PostMapping
    public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails){
        UserRest returnValue = new UserRest();

        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userDetails, userDto);

        UserDto createdUser = userService.createUser (userDto);
        BeanUtils.copyProperties(createdUser, returnValue);

        return returnValue;

    }

    @PutMapping
    public String updateUser(){
        return "Update User called";
    }

    @DeleteMapping
    public String deleteUser(){
        return "Delete User called";
    }

}

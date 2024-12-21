package hu.unideb.inf.webproject_backend.controller;

import hu.unideb.inf.webproject_backend.service.UserService;
import hu.unideb.inf.webproject_backend.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService service;

    @GetMapping("/allUser")
    public List<UserDto> getAllUser(){
        return service.findAll();
    }
}

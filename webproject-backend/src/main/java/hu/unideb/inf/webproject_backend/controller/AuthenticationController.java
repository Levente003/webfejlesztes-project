package hu.unideb.inf.webproject_backend.controller;

import hu.unideb.inf.webproject_backend.service.AuthenticationService;
import hu.unideb.inf.webproject_backend.service.dto.LoginUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/**", method = RequestMethod.OPTIONS)
    public ResponseEntity<Void> handleOptions() {
        return ResponseEntity.ok().build();
    }

    @PostMapping("/signIn")
    public String signIn(@RequestBody LoginUserDto user){
        return authenticationService.signIn(user);
    }
}

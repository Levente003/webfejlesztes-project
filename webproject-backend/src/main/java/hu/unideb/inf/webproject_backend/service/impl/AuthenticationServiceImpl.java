package hu.unideb.inf.webproject_backend.service.impl;

import hu.unideb.inf.webproject_backend.data.entities.UserEntity;
import hu.unideb.inf.webproject_backend.data.repositories.UserRepository;
import hu.unideb.inf.webproject_backend.service.AuthenticationService;
import hu.unideb.inf.webproject_backend.service.JwtService;
import hu.unideb.inf.webproject_backend.service.dto.LoginUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtService jwtService;

    @Override
    public String signIn(LoginUserDto loginUserDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginUserDto.getUsername(),
                        loginUserDto.getPassword())
        );
        UserEntity user = userRepo.findByUsername(loginUserDto.getUsername());
        return jwtService.generateToken(user);
    }
}

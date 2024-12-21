package hu.unideb.inf.webproject_backend.service.impl;

import hu.unideb.inf.webproject_backend.data.entities.UserEntity;
import hu.unideb.inf.webproject_backend.data.repositories.UserRepository;
import hu.unideb.inf.webproject_backend.service.AuthenticationService;
import hu.unideb.inf.webproject_backend.service.JwtService;
import hu.unideb.inf.webproject_backend.service.dto.LoginUserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private JwtService jwtService;

    @Override
    public String signIn(LoginUserDto loginUserDto) {
        Optional<UserEntity> user = userRepo.findByUsername(loginUserDto.getUsername());
        return jwtService.generateToken(user.get());
    }
}

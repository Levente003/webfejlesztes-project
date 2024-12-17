package hu.unideb.inf.webproject_backend.service;

import hu.unideb.inf.webproject_backend.service.dto.LoginUserDto;

public interface AuthenticationService {

    String signIn(LoginUserDto loginUserDto);
}

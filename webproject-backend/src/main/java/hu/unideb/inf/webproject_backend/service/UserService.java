package hu.unideb.inf.webproject_backend.service;

import hu.unideb.inf.webproject_backend.service.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
}

package hu.unideb.inf.webproject_backend.service.impl;

import hu.unideb.inf.webproject_backend.data.entities.UserEntity;
import hu.unideb.inf.webproject_backend.data.repositories.UserRepository;
import hu.unideb.inf.webproject_backend.service.UserService;
import hu.unideb.inf.webproject_backend.service.dto.UserDto;
import hu.unideb.inf.webproject_backend.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Autowired
    UserMapper mapper;

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> list = userRepo.findAll();
        return mapper.userEntityListToUserDtoList(list);
    }
}

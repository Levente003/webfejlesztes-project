package hu.unideb.inf.webproject_backend.config;

import hu.unideb.inf.webproject_backend.data.entities.RoleEnum;
import hu.unideb.inf.webproject_backend.data.entities.UserEntity;
import hu.unideb.inf.webproject_backend.data.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final UserRepository repository;

    public DataInitializer(UserRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        repository.save(new UserEntity("admin", "admin", RoleEnum.ADMIN));
        repository.save(new UserEntity("user", "user", RoleEnum.USER));
    }
}

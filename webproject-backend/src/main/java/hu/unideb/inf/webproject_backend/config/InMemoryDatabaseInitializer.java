package hu.unideb.inf.webproject_backend.config;

import hu.unideb.inf.webproject_backend.data.entities.RoleEnum;
import hu.unideb.inf.webproject_backend.data.entities.UserEntity;
import hu.unideb.inf.webproject_backend.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class InMemoryDatabaseInitializer {
    private UserRepository userRepo;

    public void init() {
        UserEntity adminUser = new UserEntity("admin", "admin", RoleEnum.ADMIN);
        userRepo.save(adminUser);
        UserEntity normalUser = new UserEntity("user", "user", RoleEnum.USER);
        userRepo.save(normalUser);
    }
}

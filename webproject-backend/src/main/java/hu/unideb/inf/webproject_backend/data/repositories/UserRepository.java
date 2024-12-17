package hu.unideb.inf.webproject_backend.data.repositories;

import hu.unideb.inf.webproject_backend.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}

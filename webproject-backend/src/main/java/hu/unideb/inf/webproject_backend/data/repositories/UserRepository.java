package hu.unideb.inf.webproject_backend.data.repositories;

import hu.unideb.inf.webproject_backend.data.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByUsername(String username);
}

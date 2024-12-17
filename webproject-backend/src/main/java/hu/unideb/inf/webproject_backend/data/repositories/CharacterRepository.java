package hu.unideb.inf.webproject_backend.data.repositories;

import hu.unideb.inf.webproject_backend.data.entities.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {
    CharacterEntity findById(long id);

    //FILTER
    List<CharacterEntity> findBySeries(String series);

    List<CharacterEntity> findByAgeBetween(int min, int max);

    List<CharacterEntity> findByGender(String gender);

    //SORTING
    List<CharacterEntity> findAllByOrderByNameAsc();

    List<CharacterEntity> findAllByOrderBySeriesAsc();

    //SIMPLE GET ALL
    List<CharacterEntity> findAll();
}

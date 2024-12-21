package hu.unideb.inf.webproject_backend.service;

import hu.unideb.inf.webproject_backend.service.dto.CharacterDto;

import java.util.List;

public interface CharacterService {

    CharacterDto addCharacter(CharacterDto dto);
    List<CharacterDto> findAll();
    void delete(Long id);
    CharacterDto update(CharacterDto dto);
}

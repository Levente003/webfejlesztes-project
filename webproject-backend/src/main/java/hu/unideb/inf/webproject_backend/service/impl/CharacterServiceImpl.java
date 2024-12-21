package hu.unideb.inf.webproject_backend.service.impl;

import hu.unideb.inf.webproject_backend.data.entities.CharacterEntity;
import hu.unideb.inf.webproject_backend.data.repositories.CharacterRepository;
import hu.unideb.inf.webproject_backend.service.CharacterService;
import hu.unideb.inf.webproject_backend.service.dto.CharacterDto;
import hu.unideb.inf.webproject_backend.service.mapper.CharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterRepository repo;

    @Autowired
    CharacterMapper mapper;

    @Override
    public CharacterDto addCharacter(CharacterDto dto) {
        return mapper.characterEntityToCharacterDto(repo.save(mapper.characterDtoToCharacterEntity(dto)));
    }

    @Override
    public List<CharacterDto> findAll() {
        return repo.findAll().stream().map(mapper::characterEntityToCharacterDto).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public CharacterDto update(CharacterDto dto) {
        CharacterEntity entity = repo.findById(dto.getId());
        entity.setName(dto.getName());
        entity.setSeries(dto.getSeries());
        entity.setSpecies(dto.getSpecies());
        entity.setGender(dto.getGender());
        entity.setAge(dto.getAge());
        entity.setHeight(dto.getHeight());
        entity.setWeight(dto.getWeight());
        return mapper.characterEntityToCharacterDto(repo.save(entity));
    }
}

package hu.unideb.inf.webproject_backend.service.mapper;

import hu.unideb.inf.webproject_backend.data.entities.CharacterEntity;
import hu.unideb.inf.webproject_backend.service.dto.CharacterDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CharacterMapper {

    CharacterDto characterEntityToCharacterDto(CharacterEntity characterEntity);
    CharacterEntity characterDtoToCharacterEntity(CharacterDto characterDto);

    List<CharacterDto> characterEntityListToCharacterDtoList(List<CharacterEntity> characterEntities);
    List<CharacterEntity> characterDtoListToCharacterEntityList(List<CharacterDto> characterDtos);

}

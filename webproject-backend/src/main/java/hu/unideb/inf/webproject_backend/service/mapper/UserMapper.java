package hu.unideb.inf.webproject_backend.service.mapper;

import hu.unideb.inf.webproject_backend.data.entities.RoleEnum;
import hu.unideb.inf.webproject_backend.data.entities.UserEntity;
import hu.unideb.inf.webproject_backend.service.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "role", source = "role", qualifiedByName = "roleEnumToString")
    UserDto userEntityToUserDto(UserEntity userEntity);

    @Mapping(target = "role", source = "role", qualifiedByName = "stringToRoleEnum")
    UserEntity userDtoToUserEntity(UserDto userDto);

    @Named("roleEnumToString")
    default String roleEnumToString(RoleEnum role) {
        return role == null ? null : role.name();
    }

    @Named("stringToRoleEnum")
    default RoleEnum stringToRoleEnum(String role) {
        return role == null ? null : RoleEnum.valueOf(role);
    }

    List<UserDto> userEntityListToUserDtoList(List<UserEntity> userEntities);
    List<UserEntity> userDtoListToUserEntityList(List<UserDto> userDtos);

}

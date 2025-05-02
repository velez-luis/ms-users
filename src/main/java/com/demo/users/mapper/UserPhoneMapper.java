package com.demo.users.mapper;

import com.demo.users.dto.request.UserPhoneRequestDTO;
import com.demo.users.model.UserPhone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
 * UserPhoneMapper.java
 * <p>
 * Interfaz que define el mapeo entre los objetos DTO y las entidades de teléfono de usuario.
 * Utiliza MapStruct para implementar las conversiones automáticas entre
 * {@link UserPhoneRequestDTO} y {@link UserPhone}.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Mapper(componentModel = "spring")
public interface UserPhoneMapper {

    static final String ATRIBUTE_CITY_CODE = "citycode";
    static final String ATRIBUTE_COUNTRY_CODE = "countrycode";

    UserPhoneMapper INSTANCE = Mappers.getMapper(UserPhoneMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = ATRIBUTE_CITY_CODE, source = ATRIBUTE_CITY_CODE)
    @Mapping(target = ATRIBUTE_COUNTRY_CODE, source = ATRIBUTE_COUNTRY_CODE)
    UserPhone toEntity(UserPhoneRequestDTO phoneDTO);

    @Mapping(target = ATRIBUTE_CITY_CODE, source = ATRIBUTE_CITY_CODE)
    @Mapping(target = ATRIBUTE_COUNTRY_CODE, source = ATRIBUTE_COUNTRY_CODE)
    UserPhoneRequestDTO toDto(UserPhone phone);

    List<UserPhone> toEntityList(List<UserPhoneRequestDTO> phoneDTOs);
    List<UserPhoneRequestDTO> toDtoList(List<UserPhone> phones);

}

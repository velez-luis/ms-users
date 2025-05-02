package com.demo.users.mapper;


import com.demo.users.dto.request.UserRequestDTO;
import com.demo.users.dto.response.UserResponseDTO;
import com.demo.users.model.UserBase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
/**
 * UserBaseMapper.java
 * <p>
 * Interfaz que define el mapeo entre los objetos DTO y las entidades de Usuario.
 * Utiliza MapStruct para implementar las conversiones automáticas entre
 * {@link UserRequestDTO} y {@link UserBase}.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Mapper(componentModel = "spring", uses = UserPhoneMapper.class)
public interface UserBaseMapper {

    static final String ATRIBUTE_PASSWORD = "password";
    static final String ATRIBUTE_PHONE = "phones";

    UserBaseMapper INSTANCE = Mappers.getMapper(UserBaseMapper.class);

    /**
     * Instancia singleton del mapper.
     * <p>
     * Proporciona una instancia compartida del mapper que puede ser utilizada
     * cuando no se requiere la inyección de dependencias de Spring.
     * </p>
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = ATRIBUTE_PASSWORD, source = ATRIBUTE_PASSWORD)
    @Mapping(target = "lastLogin", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "token", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "isActive", constant = "true")
    @Mapping(target = "created", ignore = true)
    @Mapping(target = "modified", ignore = true)
    @Mapping(target = ATRIBUTE_PHONE, ignore = true) /*Manejado en el servicio*/
    UserBase toEntity(UserRequestDTO userRequestDTO);

    @Mapping(target = ATRIBUTE_PASSWORD, ignore = true)
    @Mapping(target = ATRIBUTE_PHONE, ignore = true)
    UserRequestDTO toRequestDto(UserBase user);

    /**
     * Convierte una entidad UserBase a UserResponseDTO.
     * <p>
     * Este método mapea los campos relevantes de la entidad UserBase a un objeto
     * de respuesta UserResponseDTO, incluyendo id, fechas, token y estado.
     * </p>
     *
     * @param user La entidad UserBase a convertir
     * @return UserResponseDTO con la información del usuario
     */
    UserResponseDTO toResponseDto(UserBase user);

    List<UserBase> toEntityList(List<UserRequestDTO> userRequestDTOS);
    List<UserRequestDTO> toDtoList(List<UserBase> users);

}

package com.demo.users.service.impl;

import com.demo.users.dto.request.UserRequestDTO;
import com.demo.users.dto.response.UserResponseDTO;
import com.demo.users.exception.EmailAlreadyExistException;
import com.demo.users.exception.ModelNotFoundException;
import com.demo.users.mapper.UserBaseMapper;
import com.demo.users.mapper.UserPhoneMapper;
import com.demo.users.model.UserBase;
import com.demo.users.model.UserPhone;
import com.demo.users.repo.GenericRepo;
import com.demo.users.repo.UserBaseRepo;
import com.demo.users.service.UserBaseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
/**
 * UserBaseServiceImpl.java
 * <p>
 * Implementación de {@link UserBaseService} que extiende de {@link ServiceImpl}.
 * Proporciona la implementación concreta para gestionar usuarios, incluyendo
 * operaciones transaccionales y validaciones específicas.
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class UserBaseServiceImpl extends ServiceImpl<UserBase, UUID> implements UserBaseService {

    private final UserBaseRepo userRepository;
    private final UserBaseMapper userMapper;
    private final UserPhoneMapper userPhoneMapper;
    @Override
    protected GenericRepo<UserBase, UUID> getRepo() {return this.userRepository;}

    @Transactional
    public UserResponseDTO saveTransactional(UserRequestDTO userRequestDTO) throws Exception {

        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            log.error("Email ya existe: {}", userRequestDTO.getEmail());
            throw new EmailAlreadyExistException("Email already exists");
        }
        UserBase user = userMapper.toEntity(userRequestDTO);
        user.setPhones(new ArrayList<>());
        userRequestDTO.getPhones().forEach(phoneDto -> {
            UserPhone phone = userPhoneMapper.toEntity(phoneDto);
            phone.setUser(user);
            user.getPhones().add(phone);
        });
        /* user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));*/
        user.setPassword(userRequestDTO.getPassword());
        userRepository.save(user);
        return userMapper.toResponseDto(user);

    }

    @Override
    public UserResponseDTO findByEmail(String email) {
        UserBase userBase = userRepository.findByEmail(email)
                .orElseThrow(() -> new ModelNotFoundException("No se encontró usuario con el correo: " + email));
        return userMapper.toResponseDto(userBase);
    }
}

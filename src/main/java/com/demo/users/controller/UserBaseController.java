package com.demo.users.controller;

import com.demo.users.controller.common.ApiControllerRoutes;
import com.demo.users.dto.common.CustomResponse;
import com.demo.users.dto.request.UserRequestDTO;
import com.demo.users.dto.response.UserResponseDTO;
import com.demo.users.exception.CustomErrorResponse;
import com.demo.users.service.impl.UserBaseServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@Tag(name = "Usuarios", description = "API para la gestión de usuarios")
@RestController
@RequestMapping(ApiControllerRoutes.USER_DATA_API)
@RequiredArgsConstructor
public class UserBaseController {

    private final UserBaseServiceImpl userService;

    @Operation(summary = "Obtener usuario por correo electrónico",
            description = "Devuelve un usuario basado en su correo electrónico",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Usuario encontrado",
                            content = @Content(schema = @Schema(implementation = UserResponseDTO.class))),
                    @ApiResponse(responseCode = "404", description = "Usuario no encontrado",
                            content = @Content(schema = @Schema(implementation = CustomResponse.class)))
            })
    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponseDTO> getUserByEmail(@PathVariable(name = "email", required = true) String email) {
        return ResponseEntity.ok(userService.findByEmail(email));
    }

    @Operation(summary = "Crear un nuevo usuario",
            description = "Crea un nuevo usuario con la información proporcionada",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente",
                            content = @Content(schema = @Schema(implementation = UserResponseDTO.class))),
                    @ApiResponse(responseCode = "400", description = "Solicitud inválida",
                            content = @Content(schema = @Schema(implementation = CustomErrorResponse.class))),
                    @ApiResponse(responseCode = "409", description = "El correo ya existe",
                            content = @Content(schema = @Schema(implementation = CustomResponse.class)))
            })
    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDTO userDTO) throws Exception {
        UserResponseDTO createdUser = userService.saveTransactional(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

}

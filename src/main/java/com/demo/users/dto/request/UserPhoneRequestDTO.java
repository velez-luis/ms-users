package com.demo.users.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
/**
 * UserPhoneRequestDTO.java
 * <p>
 * DTO (Data Transfer Object) para la información de teléfonos de usuarios.
 * Contiene validaciones para los campos:
 * <ul>
 *     <li>number: Número telefónico (solo dígitos)</li>
 *     <li>citycode: Código de ciudad</li>
 *     <li>countrycode: Código de país</li>
 * </ul>
 * </p>
 *
 * @author Luis Velez
 * @version 1.0
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPhoneRequestDTO {

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "\\d{7,15}$",
            message = "Phone number must contain only digits and be between 7 and 15 characters")
    private String number;

    @NotBlank(message = "City code cannot be blank")
    @Size(min = 1, max = 5, message = "City code must be between {min} and {max} characters")
    private String citycode;

    @NotBlank(message = "Country code cannot be blank")
    @Size(min = 1, max = 5, message = "Country code must be between {min} and {max} characters")
    private String countrycode;
}

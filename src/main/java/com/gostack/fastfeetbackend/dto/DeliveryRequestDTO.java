package com.gostack.fastfeetbackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
public class DeliveryRequestDTO {

    @NotNull
    private Long userId;

    @NotBlank
    private String productName;

    @NotBlank
    private String address;

    @NotBlank
    private String postalCode;

    @NotBlank
    private String neighborhood;

    @NotBlank
    private String city;

    @NotBlank
    private String state;

    @NotNull
    private String signature;

}

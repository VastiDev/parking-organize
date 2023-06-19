package br.com.novaface.parkingorganizing.owner.application.api;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class OwnerRequest {
    private String fullName;
    private String cpf;

    private String email;

    private String cellphoneNumber;

    private LocalDate birthData;

    private String roomNumber;

    private Boolean acceptTerms;
}

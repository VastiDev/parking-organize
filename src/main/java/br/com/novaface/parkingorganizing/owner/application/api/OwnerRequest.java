package br.com.novaface.parkingorganizing.owner.application.api;

import lombok.Data;

import java.time.LocalDate;
@Data
public class OwnerRequest {
    private String fullName;
    private String cpf;
    private String email;
    private String cellphoneNumber;
    private LocalDate birthData;
    private String roomNumber;
    private Boolean acceptTerms;

}

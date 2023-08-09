package br.com.novaface.parkingorganizing.owner.application.api;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class OwnerRequest {
    private String fullName;
    private String cpf;
    private String email;
    private String cellphoneNumber;
    private LocalDate birthData;
    private String roomNumber;
    private Boolean acceptTerms;

}

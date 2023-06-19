package br.com.novaface.parkingorganizing.owner.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Owner {
    @Id
    private UUID idOwner;
    @NotBlank
    private String fullName;
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String cellphoneNumber;
    @NotNull
    private LocalDate birthData;
    @NotBlank
    private String roomNumber;
    @NotNull
    private Boolean acceptTerms;

    private LocalDateTime timeRegistration;
    private LocalDateTime timeLastChange;

    public Owner(String fullName, String cpf, String email, String cellphoneNumber,
                 LocalDate birthData, String roomNumber, Boolean acceptTerms) {
        this.idOwner = UUID.randomUUID();
        this.fullName = fullName;
        this.cpf = cpf;
        this.email = email;
        this.cellphoneNumber = cellphoneNumber;
        this.birthData = birthData;
        this.roomNumber = roomNumber;
        this.acceptTerms = acceptTerms;
        this.timeRegistration = LocalDateTime.now();

    }
}

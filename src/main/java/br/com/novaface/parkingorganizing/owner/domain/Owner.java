package br.com.novaface.parkingorganizing.owner.domain;

import br.com.novaface.parkingorganizing.owner.application.api.OwnerRequest;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idOwner", updatable = false, unique = true, nullable = false)
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
    @NotBlank
    private String parkingLot;
    @NotNull
    private Boolean acceptTerms;

    private LocalDateTime timeRegistration;
    private LocalDateTime timeLastChange;

    public Owner(OwnerRequest ownerRequest) {
        this.fullName = ownerRequest.getFullName();
        this.cpf = ownerRequest.getCpf();
        this.email = ownerRequest.getEmail();
        this.cellphoneNumber = ownerRequest.getCellphoneNumber();
        this.birthData = ownerRequest.getBirthData();
        this.roomNumber =ownerRequest.getRoomNumber();
        this.parkingLot = ownerRequest.getParkingLot();
        this.acceptTerms = ownerRequest.getAcceptTerms();
        this.timeRegistration = LocalDateTime.now();

    }
}

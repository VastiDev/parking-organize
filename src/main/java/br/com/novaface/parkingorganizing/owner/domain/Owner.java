package br.com.novaface.parkingorganizing.owner.domain;

import br.com.novaface.parkingorganizing.OwnerChangeRequest;
import br.com.novaface.parkingorganizing.lot.domain.Lot;
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


@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idOwner", updatable = false, unique = true, nullable = false)
    private UUID idOwner;
    @NotBlank
    @Column(unique = true)
    @CPF
    private String cpf;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String fullName;
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

    @OneToOne(mappedBy = "owner", cascade = CascadeType.ALL)
    private Lot lot;

    public Owner(OwnerRequest ownerRequest) {
        this.fullName = ownerRequest.getFullName();
        this.cpf = ownerRequest.getCpf();
        this.email = ownerRequest.getEmail();
        this.cellphoneNumber = ownerRequest.getCellphoneNumber();
        this.birthData = ownerRequest.getBirthData();
        this.roomNumber =ownerRequest.getRoomNumber();
        this.acceptTerms = ownerRequest.getAcceptTerms();
        this.timeRegistration = LocalDateTime.now();

    }

    public void patch(OwnerChangeRequest ownerChangeRequest) {
        this.fullName = ownerChangeRequest.getFullName();
        this.cellphoneNumber = ownerChangeRequest.getCellphoneNumber();
        this.roomNumber =ownerChangeRequest.getRoomNumber();
        this.timeLastChange = LocalDateTime.now();
    }

}

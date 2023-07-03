package br.com.novaface.parkingorganizing.owner.application.api;

import br.com.novaface.parkingorganizing.owner.domain.Owner;
import lombok.Value;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Value
public class OwnerDetailResponse {
    private UUID idOwner;
    private String fullName;
    private String email;
    private String cellphoneNumber;
    private LocalDate birthData;
    private String roomNumber;
    private Boolean acceptTerms;
    private LocalDateTime timeRegistration;

    public OwnerDetailResponse(Owner owner) {
        this.idOwner = owner.getIdOwner();
        this.fullName = owner.getFullName();
        this.email = owner.getEmail();
        this.cellphoneNumber = owner.getCellphoneNumber();
        this.birthData = owner.getBirthData();
        this.roomNumber = owner.getRoomNumber();
        this.acceptTerms = owner.getAcceptTerms();
        this.timeRegistration = owner.getTimeRegistration();
    }
}

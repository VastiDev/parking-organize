package br.com.novaface.parkingorganizing.owner.application.api;

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
    private String parkingLot;
    private Boolean acceptTerms;
    private LocalDateTime timeRegistration;
}

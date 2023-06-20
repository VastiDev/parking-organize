package br.com.novaface.parkingorganizing.owner.application.api;


import lombok.Value;

import java.util.UUID;
@Value
public class OwnerListResponse {
    private UUID idOwner;
    private String fullName;
    private String email;
    private String cellphoneNumber;
    private String roomNumber;
}

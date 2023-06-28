package br.com.novaface.parkingorganizing;

import lombok.Value;

import java.time.LocalDate;

@Value
public class OwnerChangeRequest {
    private String fullName;
    private String cellphoneNumber;
    private String roomNumber;
    private String parkingLot;


}

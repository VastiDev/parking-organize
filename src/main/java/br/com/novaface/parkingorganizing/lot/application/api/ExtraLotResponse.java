package br.com.novaface.parkingorganizing.lot.application.api;

import lombok.Value;

import java.util.UUID;
@Value
public class ExtraLotResponse {
    private Integer numberLot;
    private UUID idOwnerHome;
    private String extraLot;
}

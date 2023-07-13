package br.com.novaface.parkingorganizing.lot.application.api;

import lombok.Value;

import java.util.UUID;
@Value
public class LotDetailResponse {
    private Integer numberLot;
    private UUID idOwnerHome;
}

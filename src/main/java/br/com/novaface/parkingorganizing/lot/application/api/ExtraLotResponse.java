package br.com.novaface.parkingorganizing.lot.application.api;

import lombok.Value;

import java.util.UUID;
@Value
public class ExtraLotResponse {
    private String extraLot;
    private Integer numberLot;
    private String fullName;
}

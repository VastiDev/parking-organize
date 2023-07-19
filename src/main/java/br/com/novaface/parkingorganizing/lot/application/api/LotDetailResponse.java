package br.com.novaface.parkingorganizing.lot.application.api;

import br.com.novaface.parkingorganizing.lot.domain.Lot;
import lombok.Data;
import lombok.Value;

import java.util.UUID;
@Value
public class LotDetailResponse {
    private Integer numberLot;
    private UUID idOwnerHome;
    private String fullName;

    public LotDetailResponse(Lot lot) {
        this.numberLot = lot.getNumberLot();
        this.idOwnerHome = lot.getIdOwnerHome();
        this.fullName = lot.getFullName();
    }
}

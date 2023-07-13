package br.com.novaface.parkingorganizing.lot.application.api;

import br.com.novaface.parkingorganizing.lot.domain.Lot;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Value
public class LotListResponse {
    private Integer numberLot;
    private UUID idOwnerHome;


    public static List<LotListResponse> convert(List<Lot> lots) {
        return lots.stream()
                .map(LotListResponse::new)
                .collect(Collectors.toList());
    }

    public LotListResponse(Lot lots) {
        this.numberLot = lots.getNumberLot();
        this.idOwnerHome = lots.getIdOwnerHome();

    }
}

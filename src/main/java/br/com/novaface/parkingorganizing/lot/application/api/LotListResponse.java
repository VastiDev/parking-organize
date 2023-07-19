package br.com.novaface.parkingorganizing.lot.application.api;

import br.com.novaface.parkingorganizing.lot.domain.Lot;
import br.com.novaface.parkingorganizing.owner.application.service.OwnerService;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
@Value
public class LotListResponse {
    private Integer numberLot;
    private UUID idOwnerHome;
    private String extraLot;
    private String fullName;


    public static List<LotListResponse> convert(List<Lot> lots, OwnerService ownerService) {
        return lots.stream()
                .map(p -> new LotListResponse(p, ownerService))
                .collect(Collectors.toList());
    }

    public LotListResponse(Lot lots, OwnerService ownerService) {
        this.numberLot = lots.getNumberLot();
        this.idOwnerHome = lots.getIdOwnerHome();
        this.extraLot = lots.getExtraLot();
        this.fullName = ownerService.getOwnerPerId(idOwnerHome).getFullName();
    }
}

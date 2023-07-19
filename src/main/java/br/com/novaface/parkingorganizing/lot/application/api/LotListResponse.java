package br.com.novaface.parkingorganizing.lot.application.api;

import br.com.novaface.parkingorganizing.lot.domain.Lot;
import br.com.novaface.parkingorganizing.owner.application.repository.OwnerRepository;

import lombok.Data;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class LotListResponse {
    private Integer numberLot;
    private UUID idOwnerHome;


    public LotListResponse(Lot lot) {

        this.numberLot = lot.getNumberLot();
        this.idOwnerHome = lot.getIdOwnerHome();

    }

    public static List<LotListResponse> convert(List<Lot> lots) {
        return lots.stream().
                map(LotListResponse::new)
                .collect(Collectors.toList());
    }

}

package br.com.novaface.parkingorganizing.lot.application.api;

import br.com.novaface.parkingorganizing.lot.domain.Lot;
import br.com.novaface.parkingorganizing.owner.application.repository.OwnerRepository;
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

    public LotListResponse(Lot lot, OwnerRepository ownerRepository) {
        this.fullName = ownerRepository.getOwnerPerId(lot.getIdOwnerHome()).getFullName();
        this.numberLot = lot.getNumberLot();
        this.idOwnerHome = lot.getIdOwnerHome();
        this.extraLot = lot.getExtraLot();

    }


    public static List<LotListResponse> convert(List<Lot> lots, OwnerRepository ownerRepository) {
        return lots.stream().map(lot -> new LotListResponse(lot, ownerRepository))
                .collect(Collectors.toList());
    }

}

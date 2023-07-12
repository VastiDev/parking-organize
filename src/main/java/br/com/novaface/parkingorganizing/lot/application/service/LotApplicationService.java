package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.application.api.LotRequest;
import br.com.novaface.parkingorganizing.lot.application.api.LotResponse;
import br.com.novaface.parkingorganizing.lot.domain.Lot;
import br.com.novaface.parkingorganizing.owner.application.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;
@Service
@Log4j2
@RequiredArgsConstructor
public class LotApplicationService implements LotService {
    private final OwnerService ownerService;
    private final LotRepository lotRepository;
    @Override
    public LotResponse createLot(UUID idOwner, @Valid LotRequest lotRequest) {
        log.info("[start] LotApplicationService - createLot");
        ownerService.getOwnerPerId(idOwner);
        Lot lot = lotRepository.saveLot(new Lot(idOwner, lotRequest));
        log.info("[finish] LotApplicationService - createLot");
        return new LotResponse(lot.getIdLot());
    }
}

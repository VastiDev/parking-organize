package br.com.novaface.parkingorganizing.lot.application.api;

import br.com.novaface.parkingorganizing.lot.application.service.LotService;
import br.com.novaface.parkingorganizing.lot.domain.Lot;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.UUID;
@RestController
@Log4j2
@RequiredArgsConstructor
public class LotController implements LotAPI {
    private final LotService lotService;
    @Override
    public LotResponse postLot(UUID idOwner, @Valid LotRequest lotRequest) {
        log.info("[start] LotController - postLot");
        log.info("[idOwner] {}",idOwner);
        LotResponse lot = lotService.createLot(idOwner, lotRequest);
        log.info("[finish] LotController - postLot ");
        return lot;
    }
}
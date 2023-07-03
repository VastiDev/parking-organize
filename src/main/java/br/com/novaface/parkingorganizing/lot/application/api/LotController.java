package br.com.novaface.parkingorganizing.lot.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RestController
@Log4j2
public class LotController implements LotAPI {
    @Override
    public LotResponse postLot(UUID idOwner, LotRequest lotRequest) {
        log.info("[start] LotController - postLo ");
        log.info("[idOwner] {}",idOwner);
        log.info("[finish] LotController - postLo ");
        return null;
    }
}

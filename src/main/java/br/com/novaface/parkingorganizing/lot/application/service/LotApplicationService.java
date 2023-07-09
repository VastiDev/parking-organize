package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.application.api.LotRequest;
import br.com.novaface.parkingorganizing.lot.application.api.LotResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.UUID;
@Service
@Log4j2
public class LotApplicationService implements LotService {
    @Override
    public LotResponse createLot(UUID idOwner, @Valid LotRequest lotRequest) {
        log.info("[start] LotApplicationService - createLot");
        log.info("[finish] LotApplicationService - createLot");
        return null;
    }
}

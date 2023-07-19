package br.com.novaface.parkingorganizing.lot.application.api;

import br.com.novaface.parkingorganizing.lot.application.service.LotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
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

    @Override
    public List<LotListResponse> getAllLots() {
        log.info("[start] LotController -  getAllLots");
        List<LotListResponse> lots = lotService.getAllLots();
        log.info("[finish] LotController -  getAllLots");
        return lots;
    }
    @Override
    public LotDetailResponse getLotPerId(UUID idLot) {
        log.info("[start] LotController - getLotPerId ");
        LotDetailResponse lotDetailed = lotService.getLotPerId(idLot);
        log.info("[finish] LotController - getLotPerId ");
        return lotDetailed;
    }

    @Override
    public void deleteLotPerId(UUID idLot) {
        log.info("[start] LotController - deleteLotPerId");
        lotService.deleteLotPerId(idLot);
        log.info("[finish] LotController - deleteLotPerId");


    }

    @Override
    public void changeLot(UUID idLot, LotChangeRequest lotChangeRequest) {
        log.info("[start] LotController - changeLot");
        lotService.changeLot(idLot, lotChangeRequest);
        log.info("[finish] LotController - changeLot");

    }

    @Override
    public ResponseEntity<String> addLot(UUID idOwner, UUID idLot, ExtraLotRequest extraLotRequest) {
        log.info("[start] LotController - addLot");
        lotService.addLot(idOwner, idLot, extraLotRequest);
        log.info("[finish] LotController - addLot");
        return ResponseEntity.status(HttpStatus.CREATED).body("Succesfully registered extra Lot");

    }
}

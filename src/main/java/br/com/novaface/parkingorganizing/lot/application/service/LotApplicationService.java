package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.application.api.*;
import br.com.novaface.parkingorganizing.lot.domain.Lot;
import br.com.novaface.parkingorganizing.owner.application.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
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

    @Override
    public List<LotListResponse> getAllLots() {
        log.info("[start] LotApplicationService - getAllLots");
        List<Lot> lots = lotRepository.getAllLots();
        log.info("[finish] LotApplicationService - getAllLots");
        return LotListResponse.convert(lots,ownerService);
    }

    @Override
    public LotDetailResponse getLotPerId(UUID idLot) {
        log.info("[start] LotApplicationService - getLotPerId");
        Lot lot = lotRepository.getLotPerId(idLot);
        log.info("[finish] LotApplicationService - getLotPerId");
        return new LotDetailResponse(lot);

    }

    @Override
    public void deleteLotPerId(UUID idLot) {
        log.info("[start] LotApplicationService - deleteLotPerId");
        Lot lot = lotRepository.getLotPerId(idLot);
        lotRepository.deleteLotPerId(lot);
        log.info("[finish] LotApplicationService - deleteLotPerId");

    }

    @Override
    public void changeLot(UUID idLot, @Valid LotChangeRequest lotChangeRequest) {
        log.info("[start] LotApplicationService - changeLot");
        Lot lot = lotRepository.getLotPerId(idLot);
        lot.change(lotChangeRequest);
        lotRepository.saveLot(lot);
        log.info("[finish] LotApplicationService - changeLot");

    }

    @Override
    public void addLot(UUID idOwner, UUID idLot, ExtraLotRequest extraLotRequest) {
        log.info("[start] LotApplicationService - addLot");
        ownerService.getOwnerPerId(idOwner);
        Lot lot = lotRepository.addLot(new Lot(idOwner, extraLotRequest));
        log.info("[finish] LotApplicationService - addLot");


    }


}
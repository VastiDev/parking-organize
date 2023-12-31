package br.com.novaface.parkingorganizing.lot.infra;

import br.com.novaface.parkingorganizing.handler.APIException;
import br.com.novaface.parkingorganizing.lot.application.service.LotRepository;
import br.com.novaface.parkingorganizing.lot.domain.Lot;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class LotInfraRepository implements LotRepository {
    private final LotInfraJPARepository lotInfraJPARepository;

    @Override
    public Lot saveLot(Lot lot) {
        log.info("[start] LotInfraRepository - saveLot");
        try {
            lotInfraJPARepository.save(lot);
        } catch (DataIntegrityViolationException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Occupied lot", e);
        }
        log.info("[finish] LotInfraRepository - saveLot");
        return lot;
    }

    @Override
    public List<Lot> getAllLots() {
        log.info("[start] LotInfraRepository - getAllLots");
        List<Lot> allLots = lotInfraJPARepository.findAll();
        log.info("[finish] LotInfraRepository - getAllLots");
        return allLots;
    }

    @Override
    public Lot getLotPerId(UUID idLot) {
        log.info("[start] LotInfraRepository - getLotPerId");
        Lot lot = lotInfraJPARepository.findById(idLot)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,
                        "Client not found"));
        log.info("[finish] LotInfraRepository - getLotPerId");
        return lot;
    }

    @Override
    public void deleteLotPerId(Lot lot) {
        log.info("[start] LotInfraRepository - deleteLotPerId");
        lotInfraJPARepository.delete(lot);
        log.info("[finish] LotInfraRepository - deleteLotPerId");

    }

    @Override
    public void addLot(Lot lot) {
        log.info("[start] LotInfraRepository - addLot");
        lotInfraJPARepository.save(lot);
        log.info("[finish] LotInfraRepository - addLot");

    }
}
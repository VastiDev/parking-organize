package br.com.novaface.parkingorganizing.lot.infra;

import br.com.novaface.parkingorganizing.lot.application.service.LotRepository;
import br.com.novaface.parkingorganizing.lot.domain.Lot;
import br.com.novaface.parkingorganizing.owner.application.infra.OwnerInfraRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class LotInfraRepository implements LotRepository {
    private final LotInfraJPARepository lotInfraJPARepository;

    @Override
    public Lot saveLot(Lot lot) {
        log.info("[start] LotInfraRepository - saveLot");
        lotInfraJPARepository.save(lot);
        log.info("[finish] LotInfraRepository - saveLot");
        return lot;
    }
}

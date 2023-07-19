package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.domain.Lot;

import java.util.List;
import java.util.UUID;

public interface LotRepository {

    Lot saveLot(Lot lot);

    List<Lot> getAllLots();

    Lot getLotPerId(UUID idLot);

    void deleteLotPerId(Lot lot);

    void addLot(Lot lot);
}

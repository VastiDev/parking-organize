package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.domain.Lot;

import java.util.List;

public interface LotRepository {

    Lot saveLot(Lot lot);

    List<Lot> getAllLots();
}

package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.domain.Lot;

public interface LotRepository {
    Lot saveLot(Lot lot);
}

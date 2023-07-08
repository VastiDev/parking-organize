package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.application.api.LotRequest;
import br.com.novaface.parkingorganizing.lot.application.api.LotResponse;
import br.com.novaface.parkingorganizing.lot.domain.Lot;

import javax.validation.Valid;
import java.util.UUID;

public interface LotService {

    LotResponse createLot(UUID idOwner, LotRequest lotRequest);
}

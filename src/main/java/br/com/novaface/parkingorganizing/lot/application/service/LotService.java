package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.application.api.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface LotService {

    LotResponse createLot(UUID idOwner, LotRequest lotRequest);

    List<LotListResponse> getAllLots();

    LotDetailResponse getLotPerId(UUID idLot);

    void deleteLotPerId(UUID idLot);

    void changeLot(UUID idLot, @Valid LotChangeRequest lotChangeRequest);

    ExtraLotResponse addLot(UUID idOwner, UUID idLot, ExtraLotRequest extraLotRequest);
}

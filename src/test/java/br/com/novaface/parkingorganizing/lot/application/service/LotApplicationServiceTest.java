package br.com.novaface.parkingorganizing.lot.application.service;


import br.com.novaface.parkingorganizing.lot.application.api.LotRequest;
import br.com.novaface.parkingorganizing.lot.application.api.LotResponse;
import br.com.novaface.parkingorganizing.lot.domain.Lot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class LotApplicationServiceTest {

    @InjectMocks
    private LotApplicationService classeTeste;

    @Mock
    private LotRepository lotRepository;

    @BeforeEach
    public void setup() {
        openMocks(this);
    }


    @Test
    @DisplayName("Testando se Salva")
    public void verificarSeSalvaTest() {
        //GIVEN
        LotRequest lotRequest = new LotRequest();
        lotRequest.setNumberLot(23);

        Lot lotSalvo = new Lot(lotRequest);
        UUID idLot = UUID.randomUUID();
        lotSalvo.setIdLot(idLot);

        UUID idOwner = UUID.randomUUID();


        //WHEN
        when(lotRepository.saveLot(any(Lot.class))).thenReturn(lotSalvo);
        LotResponse response = classeTeste.createLot(idOwner, lotRequest);

        //THEN
        verify(lotRepository, times(1)).saveLot(any(Lot.class));
        assertEquals(idLot, response.getIdLot());
    }
}
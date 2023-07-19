package br.com.novaface.parkingorganizing.lot.application.service;

import br.com.novaface.parkingorganizing.lot.application.api.LotRequest;
import br.com.novaface.parkingorganizing.lot.domain.Lot;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.UUID;

import static net.bytebuddy.matcher.ElementMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
class LotApplicationServiceTest {

    @InjectMocks
    private LotApplicationService classTest;

    @Mock
    private LotRepository lotRepository;

    @Mock
    private UUID idOwner;

    @Test
    public void verifyIfRellySaveTest() {
        //GIVEN
        LotRequest lotRequest = new LotRequest();
        lotRequest.setNumberLot(22);
        //WHEN
        when(lotRepository.saveLot(new Lot())).thenReturn((Lot) any());
        classTest.createLot(idOwner,lotRequest);
        //THEN
        Mockito.verify(lotRepository, Mockito.times(1)).saveLot((Lot) any());
    }
}
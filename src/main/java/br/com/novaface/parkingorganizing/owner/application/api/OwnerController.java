package br.com.novaface.parkingorganizing.owner.application.api;

import br.com.novaface.parkingorganizing.owner.application.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Log4j2
@RequiredArgsConstructor
public class OwnerController implements OwnerAPI {
    private final OwnerService ownerService;
    @Override
    public OwnerResponse postOwner(OwnerRequest ownerRequest) {
        log.info("[start] OwnerController - postOwner");
        OwnerResponse ownerCreated = ownerService.creatOwner(ownerRequest);
        log.info("[finish] OwnerController - postOwner");
        return ownerCreated;
    }

    @Override
    public List<OwnerListResponse> getAllOwner() {
        log.info("[start] OwnerController - getAllOwner");
        log.info("[finish] OwnerController - getAllOwner");
        return null;
    }
}

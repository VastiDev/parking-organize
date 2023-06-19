package br.com.novaface.parkingorganizing.owner.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class OwnerController implements OwnerAPI {
    @Override
    public OwnerResponse postOwner(OwnerRequest ownerRequest) {
        log.info("[start] OwnerController - postOwner");
        log.info("[finish] OwnerController - postOwner");
        return null;
    }
}

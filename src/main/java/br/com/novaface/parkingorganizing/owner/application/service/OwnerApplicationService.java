package br.com.novaface.parkingorganizing.owner.application.service;

import br.com.novaface.parkingorganizing.owner.application.api.OwnerRequest;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerResponse;
import br.com.novaface.parkingorganizing.owner.domain.Owner;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class OwnerApplicationService implements OwnerService {
    @Override
    public OwnerResponse creatOwner(OwnerRequest ownerRequest) {
        log.info("[start] OwnerApplicationService - creatOwner");
        Owner owner = ownerRepository.save(new Owner(ownerRequest));
        log.info("[finish] OwnerApplicationService - creatOwner");
        return null;
    }
}

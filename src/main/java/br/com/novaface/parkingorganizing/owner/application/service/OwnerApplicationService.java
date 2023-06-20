package br.com.novaface.parkingorganizing.owner.application.service;

import br.com.novaface.parkingorganizing.owner.application.api.OwnerListResponse;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerRequest;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerResponse;
import br.com.novaface.parkingorganizing.owner.application.repository.OwnerRepository;
import br.com.novaface.parkingorganizing.owner.domain.Owner;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
@RequiredArgsConstructor
public class OwnerApplicationService implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Override
    public OwnerResponse creatOwner(OwnerRequest ownerRequest) {
        log.info("[start] OwnerApplicationService - creatOwner");
        Owner owner = ownerRepository.save(new Owner(ownerRequest));
        log.info("[finish] OwnerApplicationService - creatOwner");
        return OwnerResponse.builder().idOwner(owner.getIdOwner()).build();
    }

    @Override
    public List<OwnerListResponse> getAllOwners() {
        log.info("[start] OwnerApplicationService - getAllOwners");
        log.info("[finish] OwnerApplicationService - getAllOwners");
        return null;
    }
}

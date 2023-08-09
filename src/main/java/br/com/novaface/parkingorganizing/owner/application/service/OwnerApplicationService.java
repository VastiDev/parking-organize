package br.com.novaface.parkingorganizing.owner.application.service;

import br.com.novaface.parkingorganizing.OwnerChangeRequest;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerDetailResponse;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerListResponse;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerRequest;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerResponse;
import br.com.novaface.parkingorganizing.owner.application.repository.OwnerRepository;
import br.com.novaface.parkingorganizing.owner.domain.Owner;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class OwnerApplicationService implements OwnerService {
    private final OwnerRepository ownerRepository;

    @Override
    public OwnerResponse creatOwner(@Valid OwnerRequest ownerRequest) {
        log.info("[start] OwnerApplicationService - creatOwner");
        Owner owner = ownerRepository.save(new Owner(ownerRequest));
        log.info("[finish] OwnerApplicationService - creatOwner");
        return OwnerResponse.builder().idOwner(owner.getIdOwner()).build();
    }

    @Override
    public List<OwnerListResponse> getAllOwners() {
        log.info("[start] OwnerApplicationService - getAllOwners");
        List<Owner> owners = ownerRepository.getAllOwners();
        log.info("[finish] OwnerApplicationService - getAllOwners");
        return OwnerListResponse.convert(owners);
    }

    @Override
    public OwnerDetailResponse getOwnerPerId(UUID idOwner) {
        log.info("[start] OwnerApplicationService - getOwnerPerId");
        Owner owner = ownerRepository.getOwnerPerId(idOwner);
        log.info("[finish] OwnerApplicationService - getOwnerPerId");
        return new OwnerDetailResponse(owner);
    }

    @Override
    public void deleteOwnerPerId(UUID idOwner) {
        log.info("[start] OwnerApplicationService - deleteOwnerPerId");
        Owner owner = ownerRepository.getOwnerPerId(idOwner);
        ownerRepository.deleteOwner(owner);
        log.info("[finish] OwnerApplicationService - deleteOwnerPerId");

    }

    @Override
    public void patchChangeOwner(UUID idOwner, OwnerChangeRequest ownerChangeRequest) {
        log.info("[start] OwnerApplicationService - patchChangeOwner");
        Owner owner = ownerRepository.getOwnerPerId(idOwner);
        owner.patch(ownerChangeRequest);
        ownerRepository.save(owner);
        log.info("[finish] OwnerApplicationService - patchChangeOwner");

    }
}

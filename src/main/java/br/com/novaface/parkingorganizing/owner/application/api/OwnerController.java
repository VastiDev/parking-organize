package br.com.novaface.parkingorganizing.owner.application.api;

import br.com.novaface.parkingorganizing.OwnerChangeRequest;
import br.com.novaface.parkingorganizing.owner.application.service.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;


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
        List<OwnerListResponse> owners = ownerService.getAllOwners();
        log.info("[finish] OwnerController - getAllOwner");
        return owners;
    }

    @Override
    public OwnerDetailResponse getOwnerPerId(UUID idOwner) {
        log.info("[start] OwnerController - getOwnerPerId");
        log.info("[idOwner] {}", idOwner);
        OwnerDetailResponse ownerDetailed = ownerService.getOwnerPerId(idOwner);
        log.info("[finish] OwnerController - getOwnerPerId");
        return ownerDetailed;
    }

    @Override
    public void deleteOwnerPerId(UUID idOwner) {
        log.info("[start] OwnerController - deleteOwnerPerId");
        log.info("[idOwner] {}", idOwner);
        ownerService.deleteOwnerPerId(idOwner);
        log.info("[finish] OwnerController - deleteOwnerPerId");
    }

    @Override
    public void patchChangeOwner(UUID idOwner, OwnerChangeRequest ownerChangeRequest) {
        log.info("[start] OwnerController - patchChangeOwner");
        log.info("[idOwner] {}", idOwner);
        ownerService.patchChangeOwner(idOwner, ownerChangeRequest);
        log.info("[finish] OwnerController - patchChangeOwner");

    }

}

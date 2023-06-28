package br.com.novaface.parkingorganizing.owner.application.service;

import br.com.novaface.parkingorganizing.owner.application.api.OwnerDetailResponse;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerListResponse;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerRequest;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerResponse;

import java.util.List;
import java.util.UUID;

public interface OwnerService {
    OwnerResponse creatOwner(OwnerRequest ownerRequest);
    List<OwnerListResponse> getAllOwners();
    OwnerDetailResponse getOwnerPerId(UUID idOwner);
    void deleteOwnerPerId(UUID idOwner);
}

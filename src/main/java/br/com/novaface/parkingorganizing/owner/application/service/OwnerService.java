package br.com.novaface.parkingorganizing.owner.application.service;

import br.com.novaface.parkingorganizing.owner.application.api.OwnerListResponse;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerRequest;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerResponse;

import java.util.List;

public interface OwnerService {
    OwnerResponse creatOwner(OwnerRequest ownerRequest);
    List<OwnerListResponse> getAllOwners();
}

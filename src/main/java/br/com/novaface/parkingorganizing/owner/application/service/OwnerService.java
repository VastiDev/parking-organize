package br.com.novaface.parkingorganizing.owner.application.service;

import br.com.novaface.parkingorganizing.owner.application.api.OwnerRequest;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerResponse;

public interface OwnerService {
    OwnerResponse creatOwner(OwnerRequest ownerRequest);
}

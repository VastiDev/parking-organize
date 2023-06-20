package br.com.novaface.parkingorganizing.owner.application.repository;

import br.com.novaface.parkingorganizing.owner.domain.Owner;

public interface OwnerRepository {
    Owner save(Owner owner);
}

package br.com.novaface.parkingorganizing.owner.application.repository;

import br.com.novaface.parkingorganizing.owner.domain.Owner;

import java.util.List;

public interface OwnerRepository {
    Owner save(Owner owner);
    List<Owner> getAllOwners();
}

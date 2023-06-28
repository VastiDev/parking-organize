package br.com.novaface.parkingorganizing.owner.application.repository;

import br.com.novaface.parkingorganizing.owner.domain.Owner;

import java.util.List;
import java.util.UUID;

public interface OwnerRepository {
    Owner save(Owner owner);
    List<Owner> getAllOwners();
    Owner getOwnerPerId(UUID idOwner);
    void deleteOwner(Owner owner);
}

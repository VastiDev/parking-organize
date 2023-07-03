package br.com.novaface.parkingorganizing.owner.application.infra;

import br.com.novaface.parkingorganizing.handler.APIException;
import br.com.novaface.parkingorganizing.owner.application.repository.OwnerRepository;
import br.com.novaface.parkingorganizing.owner.domain.Owner;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class OwnerInfraRepository implements OwnerRepository {
    private final OwnerSpringDataJPARepository ownerSpringDataJPARepository;

    @Override
    public Owner save(Owner owner) {
        log.info("[start] OwnerInfraRepository - save");
        ownerSpringDataJPARepository.save(owner);
        log.info("[finish] OwnerInfraRepository - save");
        return owner;
    }

    @Override
    public List<Owner> getAllOwners() {
        log.info("[start] OwnerInfraRepository - getAllOwners");
        List<Owner> allOwners = ownerSpringDataJPARepository.findAll();
        log.info("[finish] OwnerInfraRepository - getAllOwners");
        return allOwners;
    }

    @Override
    public Owner getOwnerPerId(UUID idOwner) {
        log.info("[start] OwnerInfraRepository - getOwnerPerId");
        Owner owner = ownerSpringDataJPARepository.findById(idOwner)
                        .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Cliente não enconttrado!"));
        log.info("[finish] OwnerInfraRepository - getOwnerPerId");
        return owner;
    }

    @Override
    public void deleteOwner(Owner owner) {
        log.info("[start] OwnerInfraRepository - deleteOwner");
        ownerSpringDataJPARepository.delete(owner);
        log.info("[finish] OwnerInfraRepository - deleteOwner");


    }
}

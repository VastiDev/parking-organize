package br.com.novaface.parkingorganizing.owner.application.infra;

import br.com.novaface.parkingorganizing.owner.application.repository.OwnerRepository;
import br.com.novaface.parkingorganizing.owner.domain.Owner;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}

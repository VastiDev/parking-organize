package br.com.novaface.parkingorganizing.owner.application.infra;

import br.com.novaface.parkingorganizing.owner.domain.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OwnerSpringDataJPARepository extends JpaRepository<Owner, UUID> {
}

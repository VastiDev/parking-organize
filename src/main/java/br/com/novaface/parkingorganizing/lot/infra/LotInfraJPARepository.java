package br.com.novaface.parkingorganizing.lot.infra;

import br.com.novaface.parkingorganizing.lot.domain.Lot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LotInfraJPARepository extends JpaRepository<Lot, UUID> {

}

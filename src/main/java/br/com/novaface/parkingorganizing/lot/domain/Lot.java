package br.com.novaface.parkingorganizing.lot.domain;

import br.com.novaface.parkingorganizing.lot.application.api.LotRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idLot", updatable = false, unique = true, nullable = false )
    private UUID idLot;

    @NotNull
    private UUID idOwnerHome;
    @Min(1)
    @Max(30)
    @Column(unique = true)
    private Integer numberLot;

    private LocalDateTime timeRegistration;
    private LocalDateTime timeLastChange;

    public Lot(UUID idOwner, @Valid LotRequest lotRequest) {
        this.idOwnerHome = idOwner;
        this.numberLot = lotRequest.getNumberLot();
        this.timeRegistration = LocalDateTime.now();
    }


}

package br.com.novaface.parkingorganizing.lot.domain;

import br.com.novaface.parkingorganizing.lot.application.api.LotRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
    @NotBlank
    @Min(1)
    @Max(30)
    private Integer numberLot;



    private LocalDateTime timeRegistration;
    private LocalDateTime timeLastChange;

    public Lot(UUID idLot, UUID idOwner, @Valid LotRequest lotRequest) {
        this.idLot = idLot;
        this.idOwnerHome = idOwner;
        this.numberLot = lotRequest.getNumberLot();
        this.timeRegistration = LocalDateTime.now();

    }


}

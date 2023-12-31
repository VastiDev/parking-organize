package br.com.novaface.parkingorganizing.lot.domain;

import br.com.novaface.parkingorganizing.lot.application.api.ExtraLotRequest;
import br.com.novaface.parkingorganizing.lot.application.api.LotChangeRequest;
import br.com.novaface.parkingorganizing.lot.application.api.LotRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
@Setter
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idLot", updatable = false, unique = true, nullable = false )
    private UUID idLot;


    private UUID idOwnerHome;

    @Min(1)
    @Max(30)
    @Column(unique = true)
    private Integer numberLot;

    private String extraLot;

    private LocalDateTime timeRegistration;
    private LocalDateTime timeLastChange;

    public Lot(UUID idOwner, @Valid LotRequest lotRequest) {
        this.idOwnerHome = idOwner;
        this.numberLot = lotRequest.getNumberLot();
        this.timeRegistration = LocalDateTime.now();
    }

    public Lot(UUID idOwner, LotChangeRequest lotChangeRequest) {
        this.numberLot = lotChangeRequest.getNumberLot();
        this.timeLastChange = LocalDateTime.now();

    }

    public Lot(UUID idOwner, ExtraLotRequest extraLotRequest) {
        this.idLot = getIdLot();
        this.extraLot = extraLotRequest.getExtraLot();
        this.timeRegistration = LocalDateTime.now();



    }

    public Lot(LotRequest lotRequest) {
    }

    public void change(LotChangeRequest lotChangeRequest) {
        this.numberLot = lotChangeRequest.getNumberLot();
        this.timeLastChange = LocalDateTime.now();
    }
}

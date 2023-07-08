package br.com.novaface.parkingorganizing.lot.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Entity
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idLot;
    @NotBlank
    private Integer numberLot;


    private LocalDateTime timeRegistration;
    private LocalDateTime timeLastChange;
}

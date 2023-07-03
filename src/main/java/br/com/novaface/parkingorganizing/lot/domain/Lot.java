package br.com.novaface.parkingorganizing.lot.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idLot", updatable = false, unique = true, nullable = false)
    private UUID idLot;
    @NotBlank
    private String numberLot;


    private LocalDateTime timeRegistration;
    private LocalDateTime timeLastChange;
}

package br.com.novaface.parkingorganizing.lot.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @Setter
    @Min(1)
    @Max(30)
    @Column(unique = true)
    private Integer numberLot;



    private LocalDateTime timeRegistration;
    private LocalDateTime timeLastChange;
}

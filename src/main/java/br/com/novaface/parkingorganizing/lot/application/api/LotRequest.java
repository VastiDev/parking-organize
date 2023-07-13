package br.com.novaface.parkingorganizing.lot.application.api;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class LotRequest {
    @Min(1)
    @Max(30)
    @Column(unique = true)
    private Integer numberLot;

}

package br.com.novaface.parkingorganizing.lot.application.api;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Max;

@Data
public class LotRequest {

    private Integer numberLot;

}

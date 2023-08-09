package br.com.novaface.parkingorganizing.owner.application.api;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.util.UUID;

@Data
@Builder
@Value
public class OwnerResponse {
    private UUID idOwner;
}

package br.com.novaface.parkingorganizing.owner.application.api;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
@Value
@Builder
public class OwnerResponse {
    private UUID idOwner;
}

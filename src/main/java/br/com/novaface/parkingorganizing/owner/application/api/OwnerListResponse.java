package br.com.novaface.parkingorganizing.owner.application.api;


import br.com.novaface.parkingorganizing.owner.domain.Owner;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class OwnerListResponse {
    private UUID idOwner;
    private String fullName;
    private String email;
    private String cellphoneNumber;
    private String roomNumber;

    public static List<OwnerListResponse> convert(List<Owner> owners) {
        return owners.stream()
                .map(OwnerListResponse::new)
                .collect(Collectors.toList());
    }

    public OwnerListResponse(Owner owner) {
        this.idOwner = owner.getIdOwner();
        this.fullName = owner.getFullName();
        this.email = owner.getEmail();
        this.cellphoneNumber = owner.getCellphoneNumber();
        this.roomNumber = owner.getRoomNumber();
    }
}

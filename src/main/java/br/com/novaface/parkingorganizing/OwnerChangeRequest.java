package br.com.novaface.parkingorganizing;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Getter
@NoArgsConstructor(access = AccessLevel.PUBLIC, force = true)
public class OwnerChangeRequest {
    private String fullName;
    private String cellphoneNumber;
    private String roomNumber;
    private String parkingLot;


}

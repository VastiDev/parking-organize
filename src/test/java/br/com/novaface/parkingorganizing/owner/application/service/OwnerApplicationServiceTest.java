package br.com.novaface.parkingorganizing.owner.application.service.test;

import br.com.novaface.parkingorganizing.owner.application.api.OwnerListResponse;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerRequest;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerResponse;
import br.com.novaface.parkingorganizing.owner.application.repository.OwnerRepository;
import br.com.novaface.parkingorganizing.owner.application.service.OwnerApplicationService;
import br.com.novaface.parkingorganizing.owner.domain.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class OwnerApplicationServiceTest {


    @InjectMocks
    private OwnerApplicationService target;

    @Mock
    private OwnerRepository ownerRepository;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOwner() {
        // Given
        OwnerRequest ownerRequest = new OwnerRequest();
        Owner owner = new Owner();
        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

        // When
        OwnerResponse response = target.creatOwner(ownerRequest);

        // Then
        assertNotNull(response);
        assertEquals(owner.getIdOwner(), response.getIdOwner());
        verify(ownerRepository, times(1)).save(any(Owner.class));
    }

    @Test
    public void testGetAllOwners() {
        // Given
        OwnerRequest ownerRequest = new OwnerRequest();
        OwnerRequest ownerRequest1 = new OwnerRequest();
        List<Owner> mockOwners = Arrays.asList(new Owner(ownerRequest),new Owner(ownerRequest1));
        when(ownerRepository.getAllOwners()).thenReturn(mockOwners);

        // When
        List<OwnerListResponse> response = target.getAllOwners();

        // Then
        assertNotNull(response);
        assertEquals(mockOwners.size(), response.size());

        verify(ownerRepository, times(1)).getAllOwners();
    }

    @Test
    public void testDeleteOwnerPerId() {
        // Given
        UUID ownerId = UUID.randomUUID();
        Owner mockOwner = new Owner(/* initialize owner */);
        when(ownerRepository.getOwnerPerId(ownerId)).thenReturn(mockOwner);

        // When
        target.deleteOwnerPerId(ownerId);

        // Then
        verify(ownerRepository, times(1)).getOwnerPerId(ownerId);
        verify(ownerRepository, times(1)).deleteOwner(mockOwner);
    }
}

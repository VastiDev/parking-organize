package br.com.novaface.parkingorganizing.owner.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/owner")
public interface OwnerAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OwnerResponse postOwner (@Valid @RequestBody OwnerRequest ownerRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<OwnerListResponse> getAllOwner();

    @GetMapping(value = "/{idOwner}")
    @ResponseStatus(code = HttpStatus.OK)
    OwnerDetailResponse getOwnerPerId(@PathVariable UUID idOwner);

    @DeleteMapping(value = "/{idOwner}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteOwnerPerId(@PathVariable UUID idOwner);

}

package br.com.novaface.parkingorganizing.owner.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/owner")
public interface OwnerAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OwnerResponse postOwner (@RequestBody OwnerRequest ownerRequest);

}

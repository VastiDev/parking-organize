package br.com.novaface.parkingorganizing.owner.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/owner")
public interface OwnerAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    OwnerResponse postOwner (@Valid @RequestBody OwnerRequest ownerRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<OwnerListResponse> getAllOwner();

}

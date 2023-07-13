package br.com.novaface.parkingorganizing.lot.application.api;

import br.com.novaface.parkingorganizing.lot.domain.Lot;

import br.com.novaface.parkingorganizing.owner.application.api.OwnerDetailResponse;
import br.com.novaface.parkingorganizing.owner.application.api.OwnerListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/v2/owner/lot")
public interface LotAPI {

    @PostMapping("/{idOwner}")
    @ResponseStatus(code = HttpStatus.CREATED)
    LotResponse postLot(@PathVariable UUID idOwner,
                        @Valid @RequestBody LotRequest lotRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<LotListResponse> getAllLots();

    @GetMapping(value = "/{idLot}")
    @ResponseStatus(code = HttpStatus.OK)
    LotDetailResponse getLotPerId(@PathVariable UUID idLot);

}


package br.com.novaface.parkingorganizing.lot.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

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


    LotDetailResponse getLotPerId(UUID idLot);

    @DeleteMapping(value = "/{idLot}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteLotPerId(@PathVariable UUID idLot);


}


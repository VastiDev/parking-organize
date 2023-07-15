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

    @GetMapping(value = "/{idLot}")
    @ResponseStatus(code = HttpStatus.OK)
    LotDetailResponse getLotPerId(@PathVariable UUID idLot);

    @DeleteMapping(value = "/{idLot}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteLotPerId(@PathVariable UUID idLot);

    @PatchMapping("/{idLot}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void changeLot(@PathVariable UUID idLot,
                        @Valid @RequestBody LotChangeRequest lotChangeRequest);

    @PostMapping("/{idOwner}/add-lot")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void addLot(@PathVariable UUID idOwner,
                @Valid @RequestBody ExtraLotRequest extraLotRequest);


}


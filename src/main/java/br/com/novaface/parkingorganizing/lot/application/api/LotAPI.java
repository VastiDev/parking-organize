package br.com.novaface.parkingorganizing.lot.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/v1/owner/{idOwner}/lot")
public interface LotAPI {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    LotResponse postLot (@PathVariable UUID idOwner,
                         @Valid @RequestBody LotRequest lotRequest);
}

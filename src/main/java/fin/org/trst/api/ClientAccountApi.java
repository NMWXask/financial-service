package fin.org.trst.api;

import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/account")
public interface ClientAccountApi {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ClientAccountResponse>> getClientAccounts();

    @PostMapping("/open")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ClientAccountResponse> createAccount(@RequestBody ClientAccountRequest clientAccountRequest);
}

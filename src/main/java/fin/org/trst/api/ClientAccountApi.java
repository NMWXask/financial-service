package fin.org.trst.api;

import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface ClientAccountApi {

    @GetMapping("/api/account")
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ClientAccountResponse>> getClientAccounts();

    @PostMapping("/api/account/open")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<ClientAccountResponse> createAccount(@RequestBody ClientAccountRequest clientAccountRequest);

    @PatchMapping("api/account/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ResponseEntity<ClientAccountResponse> updateAccount(@RequestBody ClientAccountRequest clientAccountRequest);

    @DeleteMapping("api/account/delete/")
    ResponseEntity<Void> deleteAccount(@RequestBody ClientAccountRequest clientAccountRequest);
}

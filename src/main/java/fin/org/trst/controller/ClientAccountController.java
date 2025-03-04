package fin.org.trst.controller;

import fin.org.trst.api.ClientAccountApi;
import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import fin.org.trst.service.ClientAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientAccountController implements ClientAccountApi {

    private final ClientAccountService clientAccountService;

    @Override
    public ResponseEntity<List<ClientAccountResponse>> getClientAccounts() {
        List<ClientAccountResponse> clientAccountResponses = clientAccountService.getClientAccounts();
        return ResponseEntity.ok(clientAccountResponses);
    }

    @Override
    public ResponseEntity<ClientAccountResponse> createAccount(ClientAccountRequest clientAccountRequest) {
        ClientAccountResponse savedAccount = clientAccountService.saveClientAccount(clientAccountRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAccount);
    }
}

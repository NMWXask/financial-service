package fin.org.trst.api;

import fin.org.trst.db.dto.ClientAccountResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping("api/account")
public interface ClientAccountApi {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ResponseEntity<List<ClientAccountResponse>> getClientAccounts();
}

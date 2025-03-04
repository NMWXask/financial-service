package fin.org.trst.service;

import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import fin.org.trst.db.enums.AccountType;

import java.util.List;
import java.util.Optional;

public interface ClientAccountService {

    List<ClientAccountResponse> getClientAccounts();

    Optional<ClientAccountResponse> getClientAccountById(Long id);

    ClientAccountResponse saveClientAccount(ClientAccountRequest clientAccount);

    ClientAccountResponse updateClientAccount(ClientAccountRequest clientAccount);

    void deleteClientAccount(ClientAccountRequest clientAccount);

    List<ClientAccountResponse> getPremiumClientAccounts(AccountType accountType);

    List<ClientAccountResponse> getBaseClientAccounts(AccountType accountType);
}

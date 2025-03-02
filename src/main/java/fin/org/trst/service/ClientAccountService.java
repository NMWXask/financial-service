package fin.org.trst.service;

import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import fin.org.trst.db.enums.AccountType;

import java.util.List;

public interface ClientAccountService {

    List<ClientAccountResponse> getClientAccounts();

    ClientAccountResponse getClientAccountById(Long id);

    ClientAccountResponse saveClientAccount(ClientAccountRequest clientAccount);

    ClientAccountResponse updateClientAccount(ClientAccountRequest clientAccount);

    void deleteClientAccount(ClientAccountRequest clientAccount);

    List<ClientAccountResponse> getPremiumClientAccounts(AccountType accountType);

    List<ClientAccountResponse> getBaseClientAccounts(AccountType accountType);
}

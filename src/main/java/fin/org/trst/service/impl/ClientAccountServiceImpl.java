package fin.org.trst.service.impl;

import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import fin.org.trst.db.enums.AccountType;
import fin.org.trst.db.model.ClientAccount;
import fin.org.trst.db.repository.ClientAccountRepository;
import fin.org.trst.service.ClientAccountService;
import fin.org.trst.service.mapper.ClientAccountMapper;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientAccountServiceImpl implements ClientAccountService {

    private final ClientAccountRepository clientAccountRepository;
    private final ClientAccountMapper clientAccountMapper;
    private final Counter clientAccountCounter;

    public ClientAccountServiceImpl(ClientAccountRepository clientAccountRepository,
                                    ClientAccountMapper clientAccountMapper,
                                    MeterRegistry meterRegistry) {
        this.clientAccountRepository = clientAccountRepository;
        this.clientAccountMapper = clientAccountMapper;
        this.clientAccountCounter = Counter.builder("client_account_requests_total")
                .description("Total number of client account requests")
                .register(meterRegistry);
    }

    @Override
    public List<ClientAccountResponse> getClientAccounts() {
        clientAccountCounter.increment();
        return clientAccountRepository.findAll().stream()
                .map(clientAccountMapper::toClientAccountResponse)
                .toList();
    }

    @Override
    public Optional<ClientAccountResponse> getClientAccountById(Long id) {
        clientAccountCounter.increment();
        return clientAccountRepository.findById(id).map(clientAccountMapper::toClientAccountResponse);
    }

    @Override
    public ClientAccountResponse saveClientAccount(ClientAccountRequest clientAccount) {
        ClientAccount entity = clientAccountMapper.toClientAccount(clientAccount);
        clientAccountRepository.saveAndFlush(entity);
        clientAccountCounter.increment();
        return clientAccountMapper.toClientAccountResponse(entity);
    }

    @Override
    public ClientAccountResponse updateClientAccount(ClientAccountRequest clientAccount) {
        return null;
    }

    @Override
    public void deleteClientAccount(ClientAccountRequest clientAccount) {

    }

    @Override
    public List<ClientAccountResponse> getPremiumClientAccounts(AccountType accountType) {
        return List.of();
    }

    @Override
    public List<ClientAccountResponse> getBaseClientAccounts(AccountType accountType) {
        return List.of();
    }
}

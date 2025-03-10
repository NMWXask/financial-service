package fin.org.trst.service.impl;

import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import fin.org.trst.db.enums.AccountType;
import fin.org.trst.db.model.ClientAccount;
import fin.org.trst.db.repository.ClientAccountRepository;
import fin.org.trst.exception.ClientAccountNotFoundException;
import fin.org.trst.monitoring.MonitoringService;
import fin.org.trst.service.ClientAccountService;
import fin.org.trst.service.mapper.ClientAccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ClientAccountServiceImpl implements ClientAccountService {

    private final ClientAccountRepository clientAccountRepository;
    private final ClientAccountMapper clientAccountMapper;
    private final MonitoringService monitoringService;

    private static final  String METRIC_NAME = "client_account_requests_total";

    @Override
    public List<ClientAccountResponse> getClientAccounts() {
        monitoringService.increment(METRIC_NAME);
        return clientAccountRepository.findAll().stream()
                .map(clientAccountMapper::toClientAccountResponse)
                .toList();
    }

    @Override
    public Optional<ClientAccountResponse> getClientAccountById(Long id) {
        monitoringService.increment(METRIC_NAME);
        return clientAccountRepository.findById(id)
                .map(clientAccountMapper::toClientAccountResponse)
                .or(() -> {
                    monitoringService.failure(METRIC_NAME);
                    throw new ClientAccountNotFoundException("Client account with id " + id + " not found.");
                });
    }

    @Override
    public ClientAccountResponse saveClientAccount(ClientAccountRequest clientAccount) {
        monitoringService.increment(METRIC_NAME);
        ClientAccount entity = clientAccountMapper.toClientAccount(clientAccount);
        try {
            clientAccountRepository.saveAndFlush(entity);
            monitoringService.success(METRIC_NAME);
            return clientAccountMapper.toClientAccountResponse(entity);
        } catch (Exception e) {
            monitoringService.failure(METRIC_NAME);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public ClientAccountResponse updateClientAccount(ClientAccountRequest clientAccount) {
        monitoringService.increment(METRIC_NAME);
        ClientAccount entity = clientAccountRepository.findByEmail(clientAccount.getEmail());
        if (entity != null) {
            entity = clientAccountMapper.toClientAccount(clientAccount);
            clientAccountRepository.saveAndFlush(entity);
            monitoringService.success(METRIC_NAME);
            return clientAccountMapper.toClientAccountResponse(entity);
        } else {
            monitoringService.failure(METRIC_NAME);
            throw new ClientAccountNotFoundException("Client with email :" + clientAccount.getEmail() + "not found.");
        }
    }

    @Override
    public void deleteClientAccount(ClientAccountRequest clientAccount) {
        monitoringService.increment(METRIC_NAME);
        ClientAccount entity = clientAccountRepository.findByEmail(clientAccount.getEmail());
        if (entity == null) {
            monitoringService.failure(METRIC_NAME);
            log.error("Not found entity with email :{}", clientAccount.getEmail());
            throw new ClientAccountNotFoundException("Client with email :" + clientAccount.getEmail() + "not found.");
        }
        monitoringService.success(METRIC_NAME);
        clientAccountRepository.delete(entity);
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

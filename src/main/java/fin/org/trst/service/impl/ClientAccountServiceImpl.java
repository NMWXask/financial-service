package fin.org.trst.service.impl;

import fin.org.trst.annotation.Monitor;
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
    @Monitor(metricName = METRIC_NAME)
    public List<ClientAccountResponse> getClientAccounts() {
        return clientAccountRepository.findAll().stream()
                .map(clientAccountMapper::toClientAccountResponse)
                .toList();
    }

    @Override
    @Monitor(metricName = METRIC_NAME)
    public Optional<ClientAccountResponse> getClientAccountById(Long id) {
        return clientAccountRepository.findById(id)
                .map(clientAccountMapper::toClientAccountResponse)
                .or(() -> {
                    throw new ClientAccountNotFoundException("Client account with id " + id + " not found.");
                });
    }

    @Override
    @Monitor(metricName = METRIC_NAME)
    public ClientAccountResponse saveClientAccount(ClientAccountRequest clientAccount) {
        ClientAccount entity = clientAccountMapper.toClientAccount(clientAccount);
        try {
            clientAccountRepository.saveAndFlush(entity);
            return clientAccountMapper.toClientAccountResponse(entity);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    @Monitor(metricName = METRIC_NAME)
    public ClientAccountResponse updateClientAccount(ClientAccountRequest clientAccount) {
        ClientAccount entity = clientAccountRepository.findByEmail(clientAccount.getEmail());
        if (entity != null) {
            entity = clientAccountMapper.toClientAccount(clientAccount);
            clientAccountRepository.saveAndFlush(entity);
            return clientAccountMapper.toClientAccountResponse(entity);
        } else {
            throw new ClientAccountNotFoundException("Client with email :" + clientAccount.getEmail() + "not found.");
        }
    }

    @Override
    @Monitor(metricName = METRIC_NAME)
    public void deleteClientAccount(ClientAccountRequest clientAccount) {
        ClientAccount entity = clientAccountRepository.findByEmail(clientAccount.getEmail());
        if (entity == null) {
            log.error("Not found entity with email :{}", clientAccount.getEmail());
            throw new ClientAccountNotFoundException("Client with email :" + clientAccount.getEmail() + "not found.");
        }
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

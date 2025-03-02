package fin.org.trst.service.mapper;

import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import fin.org.trst.db.model.ClientAccount;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface ClientAccountMapper {

    ClientAccount toClientAccount(ClientAccountRequest clientAccountRequest);

    ClientAccountResponse toClientAccountResponse(ClientAccount clientAccount);
}

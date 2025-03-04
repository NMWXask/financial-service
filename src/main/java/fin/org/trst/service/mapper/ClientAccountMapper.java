package fin.org.trst.service.mapper;

import fin.org.trst.db.dto.ClientAccountRequest;
import fin.org.trst.db.dto.ClientAccountResponse;
import fin.org.trst.db.model.ClientAccount;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring",
        builder = @Builder(disableBuilder = true))
public interface ClientAccountMapper {
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    ClientAccount toClientAccount(ClientAccountRequest clientAccountRequest);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "accountBalance", source = "accountBalance")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "createdAt", expression = "java(fin.org.trst.util.DateTimeUtil.currentDateTime())")
    @Mapping(target = "updatedAt", expression = "java(fin.org.trst.util.DateTimeUtil.updatedAt())")
    @Mapping(target = "accountRating", source = "accountRating")
    @Mapping(target = "accountType", source = "accountType")
    ClientAccountResponse toClientAccountResponse(ClientAccount clientAccount);

    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "phoneNumber", source = "phoneNumber")
    @Mapping(target = "dateOfBirth", source = "dateOfBirth")
    @Mapping(target = "accountBalance", source = "accountBalance")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "createdAt", expression = "java(fin.org.trst.util.DateTimeUtil.currentDateTime())")
    @Mapping(target = "updatedAt", expression = "java(fin.org.trst.util.DateTimeUtil.updatedAt())")
    @Mapping(target = "accountRating", source = "accountRating")
    @Mapping(target = "accountType", source = "accountType")
    ClientAccountResponse toClientAccountResponse(ClientAccountRequest clientAccountRequest);

}

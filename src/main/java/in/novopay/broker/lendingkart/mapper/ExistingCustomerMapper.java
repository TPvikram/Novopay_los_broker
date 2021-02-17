package in.novopay.broker.lendingkart.mapper;

import in.novopay.broker.common.request.CreateLoanApplRequest;
import in.novopay.broker.common.request.PersonalDetails;
import in.novopay.broker.lendingkart.request.ExistingCustomer;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExistingCustomerMapper {

        ExistingCustomerMapper MAPPER = Mappers.getMapper(ExistingCustomerMapper.class);

       // ExistingCustomer fromCreateLoanApp(CreateLoanApplRequest createLoanApplRequest);
        ExistingCustomer fromCreateLoanApp(PersonalDetails personalDetails);




}

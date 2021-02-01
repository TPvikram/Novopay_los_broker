package in.novopay.broker.lendingkart.mapper;

import in.novopay.broker.common.request.AdditionalDetails;
import in.novopay.broker.common.request.BusinessDetails;
import in.novopay.broker.common.request.CreateLoanApplRequest;
import in.novopay.broker.common.request.PersonalDetails;
import in.novopay.broker.lendingkart.request.BusinessAddress;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.request.PersonalAddress;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springframework.data.mongodb.util.BsonUtils;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateLoanApplicationMapper {

    CreateLoanApplicationMapper MAPPER = Mappers.getMapper(CreateLoanApplicationMapper.class);

    LendingKartRequest fromCreateLoanAppRequest(CreateLoanApplRequest createLoanApplRequest);
    LendingKartRequest fromCreateLoanAppRequest(PersonalDetails personalDetails, BusinessDetails businessDetails, AdditionalDetails additionalDetails);

    PersonalAddress fromPersonalAddress(PersonalDetails personalDetails);

    BusinessAddress fromBusinessAddress(BusinessDetails businessDetails);
   /* @InheritInverseConfiguration
    in.novopay.broker.common.request.CreateLoanApplRequest toCreateLoanAppRequest(
            LendingKartRequest lendingKartRequest);

    LendingKartRequest toLendingKartRequest(PersonalDetails personalDetails, BusinessDetails businessDetails, AdditionalDetails additionalDetails);

    PersonalAddress toPersonalAddress(PersonalDetails personalDetails);

    BusinessAddress toBusinessAddress(BusinessDetails businessDetails);
*/

}
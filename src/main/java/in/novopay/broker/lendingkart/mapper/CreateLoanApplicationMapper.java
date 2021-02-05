package in.novopay.broker.lendingkart.mapper;

import in.novopay.broker.common.request.*;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.request.PersonalAddress;
import org.mapstruct.Mapper;
import org.mapstruct.MappingInheritanceStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateLoanApplicationMapper {

    CreateLoanApplicationMapper MAPPER = Mappers.getMapper(CreateLoanApplicationMapper.class);


    LendingKartRequest fromCreateLoanAppRequest(CreateLoanApplRequest createLoanApplRequest);

    LendingKartRequest fromCreateLoanAppRequest(PersonalDetails personalDetails,
                                                BusinessDetails businessDetails,
                                                AdditionalDetails additionalDetails,
                                                Consent consent);

    PersonalAddress toPersonalAddress(PersonalDetails personalDetails);
    in.novopay.broker.lendingkart.request.BusinessAddress toBusinessAddress(BusinessDetails businessDetails);

       /* @InheritInverseConfiguration
    in.novopay.broker.common.request.CreateLoanApplRequest toCreateLoanAppRequest(
            LendingKartRequest lendingKartRequest);

    LendingKartRequest toLendingKartRequest(PersonalDetails personalDetails, BusinessDetails businessDetails, AdditionalDetails additionalDetails);

    PersonalAddress toPersonalAddress(PersonalDetails personalDetails);

    Address toBusinessAddress(BusinessDetails businessDetails);
*/

}
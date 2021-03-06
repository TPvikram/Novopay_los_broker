package in.novopay.broker.common.request;

import in.novopay.broker.common.model.ActionForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateLoanApplRequest {

    PersonalDetails personalDetails;
    Consent consent;
    BusinessDetails businessDetails;
    AdditionalDetails additionalDetails;

}

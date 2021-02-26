package in.novopay.broker.lendingkart.response;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateLoanApplResponse{

        String leadId;
        String applicationId;
        String message;
        List<String> errorMessageList;
        String uniqueId;
        String loanDeliveryMethod;

}
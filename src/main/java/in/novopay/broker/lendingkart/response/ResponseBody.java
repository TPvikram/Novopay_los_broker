package in.novopay.broker.lendingkart.response;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.kafka.common.protocol.types.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
public class ResponseBody {

        String leadId;
        String applicationId;
        String message;
        List<String> errorMessageList;
        String uniqueId;
        String loanDeliveryMethod;

}

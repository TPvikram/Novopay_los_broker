package in.novopay.broker.lendingkart.response;


import lombok.*;
import org.apache.kafka.common.protocol.types.Field;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ResponseBody {

        String leadId;
        String applicationId;
        String message;
        String uniqueId;
        List<String> errorMessageList;

}

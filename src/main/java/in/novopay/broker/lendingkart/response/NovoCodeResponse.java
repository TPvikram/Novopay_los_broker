package in.novopay.broker.lendingkart.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder (toBuilder = true)
public class NovoCodeResponse {

    String status;
    String responseCode;
    ResponseBody responseBody;

}

package in.novopay.broker.common.response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder (toBuilder = true)
public class NovoCodeResponse {

    String status;
    String message;
    String desc;

    // The unique Id of the document in the database
    String formDocId;
}

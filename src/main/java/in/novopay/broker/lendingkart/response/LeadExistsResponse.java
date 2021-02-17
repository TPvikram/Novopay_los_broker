package in.novopay.broker.lendingkart.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LeadExistsResponse {

    String applicationId;
    boolean leadExists;
}

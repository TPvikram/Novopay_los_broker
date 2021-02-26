package in.novopay.broker.lendingkart.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LeadExistsResponse {

    String applicationId;
    boolean leadExists;
}

package in.novopay.broker.lendingkart.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LendingKartResponse {

    String status;
    String responseCode;
}
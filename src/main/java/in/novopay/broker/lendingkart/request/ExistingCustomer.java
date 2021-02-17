package in.novopay.broker.lendingkart.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExistingCustomer {

    String mobile;
    String email;

}

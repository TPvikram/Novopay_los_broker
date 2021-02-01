package in.novopay.broker.lendingkart.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Address {

    String ownership;
    String address;
    String city;
    String state;
    String pincode;

}

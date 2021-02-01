package in.novopay.broker.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessDetails {

    String  businessAge;
    String age;
    String registeredAs;
    String ownership;
    String city;
    String state;
    String companyGstNumber;
}

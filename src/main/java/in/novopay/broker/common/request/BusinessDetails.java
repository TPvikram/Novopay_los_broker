package in.novopay.broker.common.request;

import in.novopay.broker.lendingkart.request.BusinessAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
public class BusinessDetails {

    String businessAge;
    String age;
    String registeredAs;
  String ownership;
    String city;
    String state;
    String companyGstNumber;
    String businessRunBy;

}

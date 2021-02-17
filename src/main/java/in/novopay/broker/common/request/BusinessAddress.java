package in.novopay.broker.common.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessAddress  {

    String ownership;
    String address;
    String city;
    String state;
    String pincode;
}

package in.novopay.broker.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDetails {
    String firstName;
    String lastName;
    String email;
    String mobile;
    String companyName;
    long businessRevenue;
    String personalDob;
    String gender;
    String pincode;
}

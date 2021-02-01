package in.novopay.broker.lendingkart.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LendingKartRequest {

    String firstName; //
    String lastName; //
    String email; //
    String mobile; //
    long businessRevenue; //
    int businessAge; ///
    String registeredAs; ///
    String personalDob; //
    String personalPAN; ////
    String gender; //
    boolean cibilConsentForLK;
    boolean mobileNoVerified;
    PersonalAddress personalAddress;
    String businessRunBy;
    long loanAmount; ////
    String typeOfLoan;
    String companyName; //
    BusinessAddress businessAddress;
    String loanNeedTime;
    String uniqueId;
}

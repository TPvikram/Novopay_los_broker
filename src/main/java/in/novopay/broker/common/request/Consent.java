package in.novopay.broker.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Consent {
    boolean cibilConsentForLK;
    boolean mobileNoVerified;
}

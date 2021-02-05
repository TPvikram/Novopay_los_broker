package in.novopay.broker.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.kafka.common.protocol.types.Field;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalDetails {
    String personalPAN;
    String personalAadhaar;
    String passkey;
    String registrationProof;
    String loanAmount;
    String pancardUploadPersonal;
   String pancardUploadCompany;
    String bankStatements;
   String registrationProofDocument;
}

package in.novopay.broker.consumer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.binding.NovoBrokerListenerBinding;
import in.novopay.broker.common.constants.CommonConstants;
import in.novopay.broker.common.model.ActionForm;
import in.novopay.broker.common.request.AdditionalDetails;
import in.novopay.broker.common.request.BusinessDetails;
import in.novopay.broker.common.request.CreateLoanApplRequest;
import in.novopay.broker.common.request.PersonalDetails;
import in.novopay.broker.lendingkart.handler.LoanApplicationHandler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

import java.util.HashMap;
import java.util.Map;


@EnableBinding(NovoBrokerListenerBinding.class)
public class NovoBrokerConsumer {

    LoanApplicationHandler loanApplicationHandler;

    @StreamListener(target = NovoBrokerListenerBinding.CHANNEL)
    public void getActionForm(ActionForm actionForm) {
      //System.out.println(actionForm.toString());

        String formAction = actionForm.getFormAction();
        HashMap<String, Object> formValues = actionForm.getValues();

        if (formAction.equals("CreateLoanApplication")) {
            CreateLoanApplRequest createLoanApplRequest = CreateLoanApplRequest.builder().build();

            ObjectMapper mapper = new ObjectMapper();

           PersonalDetails personalDetails = mapper.convertValue(formValues.get("personal_details"),
                    new TypeReference<PersonalDetails>() {});
            createLoanApplRequest.setPersonalDetails(personalDetails);

            BusinessDetails businessDetails = mapper.convertValue(formValues.get("business_details"),
                    new TypeReference<BusinessDetails>() {});
            createLoanApplRequest.setBusinessDetails(businessDetails);

            AdditionalDetails additionalDetails = mapper.convertValue(formValues.get("additional_details"),
                    new TypeReference<AdditionalDetails>() {});
            createLoanApplRequest.setAdditionalDetails(additionalDetails);

           /* createLoanApplRequest.setCibilConsentForLK(
                    Boolean.valueOf(formValues.get("cibilconsentForLK").toString()));
            createLoanApplRequest.setMobileNoVerified(
                    Boolean.valueOf(formValues.get("mobileNoVerified").toString()));*/
            loanApplicationHandler.createApplication(createLoanApplRequest);
        }



    }

}
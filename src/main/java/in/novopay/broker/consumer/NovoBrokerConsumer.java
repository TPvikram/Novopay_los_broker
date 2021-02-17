package in.novopay.broker.consumer;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.binding.NovoBrokerListenerBinding;
import in.novopay.broker.common.constants.CommonConstants;
import in.novopay.broker.common.model.ActionForm;
import in.novopay.broker.common.request.*;
import in.novopay.broker.lendingkart.handler.LoanApplicationHandler;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.response.LeadExistsResponse;
import in.novopay.broker.lendingkart.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@EnableBinding(NovoBrokerListenerBinding.class)
public class NovoBrokerConsumer {

    @Autowired
    LoanApplicationHandler loanApplicationHandler;
    private JsonGenerator jsonGenerator = null;
    private ObjectMapper objectMapping = null;

    @StreamListener(target = NovoBrokerListenerBinding.CHANNEL)
    public void getActionForm(ActionForm actionForm) throws IOException {
        String formAction = actionForm.getFormAction();
        HashMap<String, Object> formValues = actionForm.getValues();

        if (formAction.equals("CreateLoanApplication")) {
            CreateLoanApplRequest createLoanApplRequest = CreateLoanApplRequest.builder().build();

            ObjectMapper mapper = new ObjectMapper();

            PersonalDetails personalDetails = mapper.convertValue(formValues.get("personal_details"),
                    new TypeReference<PersonalDetails>() {
                    });
            createLoanApplRequest.setPersonalDetails(personalDetails);

            BusinessDetails businessDetails = mapper.convertValue(formValues.get("business_details"),
                    new TypeReference<BusinessDetails>() {
                    });
            createLoanApplRequest.setBusinessDetails(businessDetails);

            AdditionalDetails additionalDetails = mapper.convertValue(formValues.get("additional_details"),
                    new TypeReference<AdditionalDetails>() {
                    });
            createLoanApplRequest.setAdditionalDetails(additionalDetails);


            Consent consent = mapper.convertValue(formValues.get("consent"),
                    new TypeReference<Consent>() {
                    });
            createLoanApplRequest.setConsent(consent);


            //Checking if Lead already exists
            LeadExistsResponse leadExistsResponse =  loanApplicationHandler.LeadExistStatus(createLoanApplRequest);
            if (leadExistsResponse.isLeadExists()) {
                System.out.println("Lead already exist ApplicationID: "+ leadExistsResponse.getApplicationId());
            }
            else{
                ResponseBody responseBody = loanApplicationHandler.createApplication(createLoanApplRequest);

                System.out.println(responseBody);

                if (responseBody.getApplicationId() != null) {

                    //TODO Upload file Api to be called
                }

            }
        }


    }

}

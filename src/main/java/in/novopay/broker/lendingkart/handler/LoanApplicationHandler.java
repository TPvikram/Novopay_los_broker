package in.novopay.broker.lendingkart.handler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.common.model.ActionForm;
import in.novopay.broker.common.request.*;
import in.novopay.broker.lendingkart.http.CreateApplicationClient;
import in.novopay.broker.lendingkart.http.LeadDedupe;
import in.novopay.broker.lendingkart.mapper.CreateLoanApplicationMapper;
import in.novopay.broker.lendingkart.mapper.ExistingCustomerMapper;
import in.novopay.broker.lendingkart.request.ExistingCustomer;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.response.CreateLoanApplResponse;
import in.novopay.broker.lendingkart.response.LeadExistsResponse;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class LoanApplicationHandler {

    CreateApplicationClient createApplicationClient;
    LeadDedupe leadDedupe;

    private static final Logger LOGGER = Logger.getLogger(LoanApplicationHandler.class.getName());

    public void createLoanApplication(ActionForm actionForm) {

        CreateLoanApplResponse createLoanApplResponse = null;
        HashMap<String, Object> formValues = actionForm.getValues();
        CreateLoanApplRequest createLoanApplRequest = CreateLoanApplRequest.builder().build();

        ObjectMapper mapper = new ObjectMapper();
        PersonalDetails personalDetails = mapper.convertValue(formValues.get("personal_details"),
                new TypeReference<PersonalDetails>(){});
        BusinessDetails businessDetails = mapper.convertValue(formValues.get("business_details"),
                new TypeReference<BusinessDetails>() {});
        AdditionalDetails additionalDetails = mapper.convertValue(formValues.get("additional_details"),
                new TypeReference<AdditionalDetails>() {});
        Consent consent = mapper.convertValue(formValues.get("consent"),
                new TypeReference<Consent>() {});

        createLoanApplRequest.setPersonalDetails(personalDetails);
        createLoanApplRequest.setAdditionalDetails(additionalDetails);
        createLoanApplRequest.setBusinessDetails(businessDetails);
        createLoanApplRequest.setConsent(consent);

        // Before create application check whether lead exists already
        LeadExistsResponse leadExistsResponse = leadExistStatus(createLoanApplRequest);

        if (!leadExistsResponse.isLeadExists()) {
            LendingKartRequest lendingKartRequest = null;
            lendingKartRequest = CreateLoanApplicationMapper.MAPPER.fromCreateLoanAppRequest(createLoanApplRequest.getPersonalDetails(),
                    createLoanApplRequest.getBusinessDetails(),
                    createLoanApplRequest.getAdditionalDetails(), createLoanApplRequest.getConsent());
            lendingKartRequest.setBusinessAddress(CreateLoanApplicationMapper.MAPPER.toBusinessAddress(createLoanApplRequest.getBusinessDetails()));
            lendingKartRequest.setPersonalAddress(CreateLoanApplicationMapper.MAPPER.toPersonalAddress(createLoanApplRequest.getPersonalDetails()));

            createLoanApplResponse = createApplicationClient.createLoanApplication(lendingKartRequest);
            LOGGER.log(Level.INFO, createLoanApplResponse.toString());
        }
        else {
            LOGGER.log(Level.INFO, "Lead already exists - " + leadExistsResponse.getApplicationId());
        }

    }

    //Checking Lead Exists
    public LeadExistsResponse leadExistStatus(CreateLoanApplRequest createLoanApplRequest){
        ExistingCustomer existingCustomer = null;
        existingCustomer = ExistingCustomerMapper.MAPPER.fromCreateLoanApp(createLoanApplRequest.getPersonalDetails());
        return leadDedupe.customerExisting(existingCustomer);
    }

}

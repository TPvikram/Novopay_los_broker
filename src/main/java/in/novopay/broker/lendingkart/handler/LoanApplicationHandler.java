package in.novopay.broker.lendingkart.handler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.common.request.CreateLoanApplRequest;
import in.novopay.broker.common.request.PersonalDetails;
import in.novopay.broker.lendingkart.http.CreateApplicationClient;
import in.novopay.broker.lendingkart.mapper.CreateLoanApplicationMapper;
import in.novopay.broker.lendingkart.request.BusinessAddress;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.request.PersonalAddress;
import in.novopay.broker.lendingkart.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Component
public class LoanApplicationHandler {

    @Autowired
    CreateApplicationClient createApplicationClient;

    private static final Logger LOGGER = Logger.getLogger(LoanApplicationHandler.class.getName());

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public ResponseBody createApplication(CreateLoanApplRequest createLoanApplRequest) {
        LendingKartRequest lendingKartRequest = null;



        if (createLoanApplRequest !=null) {
            LOGGER.info("Mapping Loan Application Request to LendingKart Request");
           System.out.println(createLoanApplRequest.toString());
            lendingKartRequest=CreateLoanApplicationMapper.MAPPER.fromCreateLoanAppRequest(createLoanApplRequest.getPersonalDetails(),
                    createLoanApplRequest.getBusinessDetails(),
                    createLoanApplRequest.getAdditionalDetails(), createLoanApplRequest.getConsent());
            lendingKartRequest.setBusinessAddress(CreateLoanApplicationMapper.MAPPER.toBusinessAddress(createLoanApplRequest.getBusinessDetails()));
            lendingKartRequest.setPersonalAddress(CreateLoanApplicationMapper.MAPPER.toPersonalAddress(createLoanApplRequest.getPersonalDetails()));

        }
        ResponseBody responseBody = createApplicationClient.createLkApp(lendingKartRequest);



        // Call the createApplication API in LendingKart

// createApplicationClient.invokeRestCall(lkLoanApplRequest);
        return responseBody;
    }

}

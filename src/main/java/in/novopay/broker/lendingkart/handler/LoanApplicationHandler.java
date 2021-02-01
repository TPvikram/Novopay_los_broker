package in.novopay.broker.lendingkart.handler;
import in.novopay.broker.common.request.CreateLoanApplRequest;
import in.novopay.broker.lendingkart.http.CreateApplicationClient;
import in.novopay.broker.lendingkart.mapper.CreateLoanApplicationMapper;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LoanApplicationHandler {

    @Autowired
    CreateApplicationClient createApplicationClient;

    private static final Logger LOGGER = Logger.getLogger(LoanApplicationHandler.class.getName());

    public LendingKartRequest createApplication(CreateLoanApplRequest createLoanApplRequest) {
        LendingKartRequest lendingKartRequest = null;

        if (createLoanApplRequest !=null) {
            LOGGER.info("Mapping Loan Application Request to LendingKart Request");
            System.out.println(createLoanApplRequest.toString());
         //   lendingKartRequest = CreateLoanApplicationMapper.MAPPER.fromCreateLoanAppRequest(createLoanApplRequest);
            lendingKartRequest=CreateLoanApplicationMapper.MAPPER.fromCreateLoanAppRequest(createLoanApplRequest.getPersonalDetails(),
                    createLoanApplRequest.getBusinessDetails(),
                    createLoanApplRequest.getAdditionalDetails());
            System.out.println(lendingKartRequest.toString());
        }

        // Call the createApplication API in LendingKart

//        createApplicationClient.invokeRestCall(lkLoanApplRequest);
        return lendingKartRequest;
    }

}

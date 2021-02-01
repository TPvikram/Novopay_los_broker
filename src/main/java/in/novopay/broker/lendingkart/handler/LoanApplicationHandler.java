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

    public LendingKartRequest createApplication(CreateLoanApplRequest loanApplRequest) {
        LendingKartRequest lkLoanApplRequest = null;

        if (loanApplRequest !=null) {
            LOGGER.info("Convert the REST Model to MongoDB Document");
            lkLoanApplRequest = CreateLoanApplicationMapper.MAPPER.fromCreateLoanAppRequest(loanApplRequest);
        }

        // Call the createApplication API in LendingKart
        System.out.println(lkLoanApplRequest.toString());
        createApplicationClient.invokeRestCall(lkLoanApplRequest);
        return lkLoanApplRequest;
    }

}

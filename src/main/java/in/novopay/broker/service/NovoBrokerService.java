package in.novopay.broker.service;

import in.novopay.broker.common.request.CreateLoanApplRequest;
import in.novopay.broker.lendingkart.handler.LoanApplicationHandler;
import in.novopay.broker.lendingkart.http.CreateApplicationClient;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;



@Service
public class NovoBrokerService {

    @Autowired
    CreateApplicationClient createApplicationClient;

    @Autowired
    LoanApplicationHandler loanApplicationHandler;


    private static final Logger LOGGER = Logger.getLogger(NovoBrokerService.class.getName());

    public String createLoanApplication(CreateLoanApplRequest createLoanApplRequest) {
       LendingKartRequest lendingKartRequest = loanApplicationHandler.createApplication(createLoanApplRequest);
     //  createApplicationClient.invokeRestCall(lkApplicationRequest);


        // Call the Handler method and pass the LendingKartRequest
        // After receiving the response, call the LowCode Microservice Rest Endpoint

        return null;
    }
}
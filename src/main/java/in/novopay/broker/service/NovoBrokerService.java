package in.novopay.broker.service;


import in.novopay.broker.common.model.ActionForm;
import in.novopay.broker.lendingkart.handler.LoanApplicationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;


@Service
public class NovoBrokerService {

    @Autowired
    LoanApplicationHandler loanApplicationHandler;

    private static final Logger LOGGER = Logger.getLogger(NovoBrokerService.class.getName());

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    public void processLendingKartRequest(ActionForm actionForm) {

        String formAction = actionForm.getFormAction();
        if (formAction.equals("CreateLoanApplication")) {
            loanApplicationHandler.createLoanApplication(actionForm);
        }
        else if (formAction.equals("isLeadExistsStatus")) {
            //TODO:
        }
    }

    public void processCapitalFloatRequest(ActionForm actionForm) {
        //TODO:
    }




}
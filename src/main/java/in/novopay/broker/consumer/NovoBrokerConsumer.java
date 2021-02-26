package in.novopay.broker.consumer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.binding.NovoBrokerListenerBinding;
import in.novopay.broker.common.model.ActionForm;
import in.novopay.broker.common.request.*;
import in.novopay.broker.lendingkart.response.LeadExistsResponse;
import in.novopay.broker.lendingkart.response.CreateLoanApplResponse;
import in.novopay.broker.service.NovoBrokerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;

@Service
@EnableBinding(NovoBrokerListenerBinding.class)
public class NovoBrokerConsumer {

    @Value("loan-provider")
    String loanProvider;

    @Autowired
    NovoBrokerService novoBrokerService;

    ActionForm actionForm = ActionForm.builder().build();

    @StreamListener(target = NovoBrokerListenerBinding.CHANNEL)
    public void consumeActionForm(ActionForm actionForm) throws IOException {

        if (loanProvider.equals("lendingkart")) {
            novoBrokerService.processLendingKartRequest(actionForm);
        }
        else if (loanProvider.equals("capitalfloat")) {
            novoBrokerService.processCapitalFloatRequest(actionForm);
        }
    }
}




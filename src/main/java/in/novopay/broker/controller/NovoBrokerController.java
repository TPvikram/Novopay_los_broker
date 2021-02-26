package in.novopay.broker.controller;

import in.novopay.broker.lendingkart.response.CreateLoanApplResponse;
import in.novopay.broker.response.NovoCodeResponse;
import java.util.logging.Logger;

import org.springframework.web.bind.annotation.*;

@RestController
public class NovoBrokerController {



CreateLoanApplResponse createLoanApplResponse;

    private static final Logger LOGGER = Logger.getLogger(NovoBrokerController.class.getName());

    @GetMapping("/response")
    public CreateLoanApplResponse getResponse(){
        return createLoanApplResponse;

    }

    @GetMapping("/testget")
    public NovoCodeResponse testGet() {
        return NovoCodeResponse.builder().build();
    }
}
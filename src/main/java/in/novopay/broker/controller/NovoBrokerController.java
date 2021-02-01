package in.novopay.broker.controller;

import in.novopay.broker.service.NovoBrokerService;
import in.novopay.broker.response.NovoCodeResponse;

import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/novo-broker")
public class NovoBrokerController {

    private static final Logger LOGGER = Logger.getLogger(NovoBrokerController.class.getName());

    @GetMapping("/testget")
    public NovoCodeResponse testGet() {
        return NovoCodeResponse.builder().build();
    }
}
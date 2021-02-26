package in.novopay.broker.lendingkart.http;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.response.CreateLoanApplResponse;
import in.novopay.broker.lendingkart.response.LendingKartResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static in.novopay.broker.common.constants.CommonConstants.BASE_URL;
import static in.novopay.broker.common.constants.CommonConstants.CREATE_APP_API_KEY;


@Component
public class LendingKartClient {

    @Autowired
    private RestTemplate restTemplate;
    private ResponseEntity<CreateLoanApplResponse> responseEntity;


    private CreateLoanApplResponse createLoanApplResponse;



    public CreateLoanApplResponse createLkApp(@RequestBody LendingKartRequest lendingKartRequest) {

        LendingKartResponse lendingKartResponse = LendingKartResponse.builder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-Api-Key", CREATE_APP_API_KEY);

        HttpEntity<LendingKartRequest> entity = new HttpEntity<LendingKartRequest>(lendingKartRequest, headers);

        responseEntity = restTemplate.exchange(BASE_URL+"/create-application",
                HttpMethod.POST,
                entity, CreateLoanApplResponse.class);
        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException(String.format("Unable to create Application, received status", responseEntity.getStatusCode()));

        }

        ObjectMapper responseMapper = new ObjectMapper();
        createLoanApplResponse = responseMapper.convertValue(responseEntity.getBody(),
                new TypeReference<CreateLoanApplResponse>() {
                });

        return createLoanApplResponse;
    }
}

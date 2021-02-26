package in.novopay.broker.lendingkart.http;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.lendingkart.request.ExistingCustomer;
import in.novopay.broker.lendingkart.response.LeadExistsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static in.novopay.broker.common.constants.CommonConstants.BASE_URL;
import static in.novopay.broker.common.constants.CommonConstants.CREATE_APP_API_KEY;

@Component
public class LeadDedupe {

    @Autowired
    private RestTemplate restTemplate;
    private LeadExistsResponse leadExistsResponse;

    public LeadExistsResponse customerExisting(ExistingCustomer existingCustomer){

        LeadExistsResponse leadExists = LeadExistsResponse.builder().build();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("X-Api-Key", CREATE_APP_API_KEY);

        HttpEntity<ExistingCustomer> entity = new HttpEntity<ExistingCustomer>(existingCustomer, headers);
        ResponseEntity<LeadExistsResponse> responseEntity = restTemplate.exchange(BASE_URL + "/lead-exists-status",
                HttpMethod.POST,
                entity, LeadExistsResponse.class);

        if (responseEntity.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException(String.format("Unable to check Application status, received status", responseEntity.getStatusCode()));
        }
        ObjectMapper responseMapper = new ObjectMapper();
        leadExists = responseMapper.convertValue(responseEntity.getBody(),
                new TypeReference<LeadExistsResponse>() {
                });


        return leadExists;
    }
}

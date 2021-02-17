package in.novopay.broker.lendingkart.http;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.response.NovoCodeResponse;
import in.novopay.broker.lendingkart.response.ResponseBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static in.novopay.broker.common.constants.CommonConstants.BASE_URL;
import static in.novopay.broker.common.constants.CommonConstants.CREATE_APP_API_KEY;


@Component
public class CreateApplicationClient {

    @Autowired
    private RestTemplate restTemplate;
    private ResponseEntity<ResponseBody> responseEntity;
    private  ResponseBody responseBody;



    public ResponseBody createLkApp(@RequestBody LendingKartRequest lendingKartRequest) {

        NovoCodeResponse novoCodeResponse = NovoCodeResponse.builder().build();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.set("X-Api-Key", CREATE_APP_API_KEY);

            HttpEntity<LendingKartRequest> entity = new HttpEntity<LendingKartRequest>(lendingKartRequest, headers);

            responseEntity = restTemplate.exchange(BASE_URL+"/create-application",
                    HttpMethod.POST,
                    entity, ResponseBody.class);
            if (responseEntity.getStatusCode() != HttpStatus.OK) {
                throw new IllegalStateException(String.format("Unable to create Application, received status", responseEntity.getStatusCode()));
                //getHttpConnection().connect();
            }

            ObjectMapper responseMapper = new ObjectMapper();
            responseBody = responseMapper.convertValue(responseEntity.getBody(),
                    new TypeReference<ResponseBody>() {
                    });

      return responseBody;
    }
}

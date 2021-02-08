package in.novopay.broker.lendingkart.http;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.response.NovoCodeResponse;
import in.novopay.broker.lendingkart.response.ResponseBody;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;


@Component
public class CreateApplicationClient {

    @Autowired
    private RestTemplate restTemplate;
    private ResponseEntity<ResponseBody> responseEntity;
    private  ResponseBody responseBody;

    ClientHttpRequestFactory requestFactory = new
            HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());

    public ResponseBody createLkApp(@RequestBody LendingKartRequest lendingKartRequest) {

        NovoCodeResponse novoCodeResponse = NovoCodeResponse.builder().build();

        if (lendingKartRequest != null) {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            HttpEntity<LendingKartRequest> entity = new HttpEntity<LendingKartRequest>(lendingKartRequest, headers);
            responseEntity = restTemplate.exchange("http://localhost:8081/lendingKart/createApplication",
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
        }
      return responseBody;
    }
}

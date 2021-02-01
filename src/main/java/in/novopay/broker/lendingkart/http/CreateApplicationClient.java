package in.novopay.broker.lendingkart.http;
import in.novopay.broker.lendingkart.request.LendingKartRequest;
import in.novopay.broker.lendingkart.response.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import static in.novopay.broker.lendingkart.constants.NovoBrokerConstants.BASEURL;

@Component
public class CreateApplicationClient {

    private RestTemplate restTemplate;
/*
    public ResponseEntity<ResponseBody> invokeRestCall(@RequestBody LendingKartRequest lendingKartRequest) {
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<LendingKartRequest> entity = new HttpEntity<LendingKartRequest>(lendingKartRequest,headers);

        ResponseEntity<ResponseBody> responseBody = restTemplate.exchange(BASEURL+"/v2/partner/leads/create-application",
                HttpMethod.POST,
                entity,ResponseBody.class);

        //getHttpConnection().connect();
        return responseBody;
    }*/
}

package in.novopay.broker.lendingkart.http;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import static in.novopay.broker.lendingkart.constants.NovoBrokerConstants.BASEURL;


public class FileUploadClient {

    RestTemplate restTemplate;

    public void invokeRestCallFileUpload(@RequestParam("applicationId") String applicationId,
                               @RequestParam("documentType") String documentType) {

        //restTemplate.exchange(BASEURL+"/documents/{applicationId}/{documentType}");

    }

}

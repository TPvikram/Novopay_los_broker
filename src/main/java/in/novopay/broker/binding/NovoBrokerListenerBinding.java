package in.novopay.broker.binding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface NovoBrokerListenerBinding {
    String CHANNEL = "novoCodeActionForm";

    @Input(CHANNEL)
    SubscribableChannel novoCodeActionForm();

}

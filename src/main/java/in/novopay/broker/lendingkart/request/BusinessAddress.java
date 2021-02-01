package in.novopay.broker.lendingkart.request;


import lombok.*;
import lombok.experimental.SuperBuilder;
import org.apache.kafka.common.protocol.types.Field;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@SuperBuilder(toBuilder = true)
public class BusinessAddress extends Address {

}

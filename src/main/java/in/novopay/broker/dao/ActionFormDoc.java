package in.novopay.broker.dao;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "actionform")
public class ActionFormDoc {

    @Transient
    public static final String SEQUENCE_NAME = "actionform_seq";

    @Id
    long id;

    String formId;
    String formTitle;
    String formAction;
    String metaFormId;

    HashMap<String, Object> values;
}
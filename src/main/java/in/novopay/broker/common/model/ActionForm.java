package in.novopay.broker.common.model;


import lombok.*;

import java.util.HashMap;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ActionForm {

    // Form Id
    String formId;

    // Form Name
    String formTitle;

    // Form Action - e.g createLoanRequest or updateLoanRequest
    String formAction;

    // Associated Meta Data Form Id
    String metaFormId;

    // Form Field Values in the form request
    // The HashMap contains FieldId as key and FieldValue as value
    HashMap<String, Object> values;

}

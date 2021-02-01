package in.novopay.broker.common.handler;

import in.novopay.broker.common.request.CommonRequest;
import in.novopay.broker.common.request.CreateLoanApplRequest;

public abstract class AbstractHandler {

    public abstract void handleRequest(CommonRequest commonRequest);
}

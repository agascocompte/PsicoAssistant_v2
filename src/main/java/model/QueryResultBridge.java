package model;

import java.util.List;

public class QueryResultBridge<T, U> {
    private String queryText;
    private String action;
    private T parameters;
    private boolean allRequiredParamsPresent;
    private String fulfillmentText;
    private List<FulfillmentMessages> fulfillmentMessages;
    private List<OutputContext<U>> outputContexts;
    private Intent intent;
    private double intentDetectionConfidence;
    private Object diagnosticInfo;
    private String languageCode;

    public QueryResultBridge() {
        super();
    }

    public String getQueryText() {
        return queryText;
    }

    public String getAction() {
        return action;
    }

    public T getParameters() {
        return parameters;
    }

    public boolean isAllRequiredParamsPresent() {
        return allRequiredParamsPresent;
    }

    public String getFulfillmentText() {
        return fulfillmentText;
    }

    public List<FulfillmentMessages> getFulfillmentMessages() {
        return fulfillmentMessages;
    }

    public List<OutputContext<U>> getOutputContexts() {
        return outputContexts;
    }

    public Intent getIntent() {
        return intent;
    }

    public double getIntentDetectionConfidence() {
        return intentDetectionConfidence;
    }

    public Object getDiagnosticInfo() {
        return diagnosticInfo;
    }

    public String getLanguageCode() {
        return languageCode;
    }
}

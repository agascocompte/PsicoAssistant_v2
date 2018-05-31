package model_response;

import com.google.cloud.dialogflow.v2.Context;
import com.google.cloud.dialogflow.v2.EventInput;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.WebhookResponse;
import com.google.protobuf.Struct;

import java.util.List;

public class ResponseBridge {
    private String fulfillmentText;
    private List<Intent.Message> fulfillmentMessages;
    private String source;
    private Struct payload;
    private List<Context> outputContext;
    private EventInput followupEventInput;

    public ResponseBridge(WebhookResponse webhookResponse) {
        fulfillmentText = webhookResponse.getFulfillmentText();
        fulfillmentMessages = webhookResponse.getFulfillmentMessagesList();
        source = webhookResponse.getSource();
        payload = webhookResponse.getPayload();
        outputContext = webhookResponse.getOutputContextsList();
        followupEventInput = webhookResponse.getFollowupEventInput();
    }
}

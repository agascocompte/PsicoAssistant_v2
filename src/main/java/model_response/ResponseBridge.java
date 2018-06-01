package model_response;

import com.google.cloud.dialogflow.v2.EventInput;
import com.google.cloud.dialogflow.v2.Intent;
import com.google.cloud.dialogflow.v2.WebhookResponse;
import com.google.protobuf.Message;
import com.google.protobuf.Struct;

import java.util.ArrayList;
import java.util.List;

public class ResponseBridge {
    private String fulfillmentText;
    private List<Intent.Message> fulfillmentMessages;
    private String source;
    private Struct payload;
    private List<Context> outputContexts;
    private EventInput followupEventInput;

    public ResponseBridge(WebhookResponse webhookResponse) {
        fulfillmentText = webhookResponse.getFulfillmentText();
        fulfillmentMessages = webhookResponse.getFulfillmentMessagesList();
        source = webhookResponse.getSource();
        payload = webhookResponse.getPayload();
        outputContexts = null;
        followupEventInput = webhookResponse.getFollowupEventInput();
    }

    public ResponseBridge() {
        fulfillmentText = "";
        fulfillmentMessages = new ArrayList<>();
        source = "";
        payload = null;
        outputContexts = new ArrayList<>();
        followupEventInput = null;
    }

    public void setFulfillmentText(String text) {
        fulfillmentText = text;
    }

    public void addFulfillmentMessage(Intent.Message message) {
        fulfillmentMessages.add(message);
    }

    public void addAllFulfillmentMessages(List<Intent.Message> messages) {
        for (Intent.Message m : messages) {
            fulfillmentMessages.add(m);
        }
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setPayload(Struct payload) {
        this.payload = payload;
    }

    public void addOutputContext(Context context) {
        outputContexts.add(context);
    }

    public void addAllOutputContexts(List<Context> outputContexts) {
        for (Context context : outputContexts) {
            this.outputContexts.add(context);
        }
    }

    public void setFollowupEventInput(EventInput eventInput) {
        followupEventInput = eventInput;
    }
}

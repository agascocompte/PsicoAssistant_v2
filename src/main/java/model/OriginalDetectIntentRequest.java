package model;

public class OriginalDetectIntentRequest {
    private String source;
    private String version;
    private Payload payload;

    public OriginalDetectIntentRequest() {
        super();
    }

    public String getSource() {
        return source;
    }

    public String getVersion() {
        return version;
    }

    public Payload getPayload() {
        return payload;
    }
}

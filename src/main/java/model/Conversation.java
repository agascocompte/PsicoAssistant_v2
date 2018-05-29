package model;

public class Conversation {
    private String conversationId;
    private String type;
    private String conversationToken;

    public Conversation() {
        super();
    }

    public String getConversationId() {
        return conversationId;
    }

    public String getType() {
        return type;
    }

    public String getConversationToken() {
        return conversationToken;
    }
}

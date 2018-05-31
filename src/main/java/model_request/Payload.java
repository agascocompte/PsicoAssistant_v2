package model_request;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Payload {
    private boolean isInSandbox;
    private Surface surface;
    private List<Inputs> inputs;
    private User user;
    private Conversation conversation;
    private List<AvailableSurface> availableSurfaces;

    public Payload() {
        super();
    }

    public boolean isInSandbox() {
        return isInSandbox;
    }

    public Surface getSurface() {
        return surface;
    }

    public List<Inputs> getInputs() {
        return inputs;
    }

    public User getUser() {
        return user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public List<AvailableSurface> getAvailableSurfaces() {
        return availableSurfaces;
    }
}

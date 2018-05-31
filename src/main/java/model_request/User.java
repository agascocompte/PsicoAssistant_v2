package model_request;

public class User {
    private String lastSeen;
    private String locale;
    private String userId;

    public User() {
        super();
    }

    public String getLocale() {
        return locale;
    }

    public String getUserId() {
        return userId;
    }

    public String getLastSeen() {

        return lastSeen;
    }
}

package model_request;

public class OutputContext<U> {
    private String name;
    private long lifespanCount;
    private U parameters;

    public OutputContext() {
        super();
    }

    public String getName() {
        return name;
    }

    public long getLifespanCount() {
        return lifespanCount;
    }

    public U getParameters() {
        return parameters;
    }
}

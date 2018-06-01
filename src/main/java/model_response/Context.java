package model_response;

import java.util.Map;

public class Context {
    private String name;
    private int lifespanCount;
    private Map<String, Integer> parameters;

    public Context() {
        name = "";
        lifespanCount = 0;
        parameters = null;
    }

    public Context(String name, int lifespan, Map<String, Integer> parameters) {
        this.name = name;
        this.lifespanCount = lifespan;
        this.parameters = parameters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLifespan(int lifespan) {
        this.lifespanCount = lifespan;
    }

    public int getLifespan() {
        return lifespanCount;
    }

    public void setParameters(Map<String, Integer> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(String key, Integer value) {
        parameters.put(key, value);
    }
}

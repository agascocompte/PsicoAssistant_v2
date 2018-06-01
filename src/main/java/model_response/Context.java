package model_response;

import java.util.Map;

public class Context {
    private String name;
    private int lifespan;
    private Map<String, Integer> parameters;

    public Context() {
        name = "";
        lifespan = 0;
        parameters = null;
    }

    public Context(String name, int lifespan, Map<String, Integer> parameters) {
        this.name = name;
        this.lifespan = lifespan;
        this.parameters = parameters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }

    public int getLifespan() {
        return lifespan;
    }

    public void setParameters(Map<String, Integer> parameters) {
        this.parameters = parameters;
    }

    public void addParameter(String key, Integer value) {
        parameters.put(key, value);
    }
}

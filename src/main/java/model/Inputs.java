package model;

import java.util.List;

public class Inputs {
    private List<RawInputs> rawInputs;
    private List<Argument> arguments;
    private String intent;

    public Inputs() {
        super();
    }

    public List<RawInputs> getRawInputs() {
        return rawInputs;
    }

    public List<Argument> getArguments() {
        return arguments;
    }

    public String getIntent() {
        return intent;
    }
}

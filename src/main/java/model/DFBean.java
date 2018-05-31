package model;

public class DFBean {
    String speech;
    String dispText;
    String source;

    public DFBean(){
        super();
    }

    public DFBean(String speech, String dispText, String source) {
        super();
        this.speech = speech;
        this.dispText = dispText;
        this.source = source;
    }

    public String getSpeech() {
        return speech;
    }
    public void setSpeech(String speech) {
        this.speech = speech;
    }
    public String getDispText() {
        return dispText;
    }
    public void setDispText(String dispText) {
        this.dispText = dispText;
    }
    public String getSource() {
        return source;
    }
    public void setSource(String source) {
        this.source = source;
    }
}

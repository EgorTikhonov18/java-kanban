package Tasks;

public enum Status {
    NEW("new"), IN_PROGRESS("inProgress"), DONE("done");
    private String translation;


    Status() {
    }


    Status(String translation) {
        this.translation = translation;
    }

    private String getTranslation() {
        return translation;
    } // был public


    public String toString() {
        return translation;
    }
}
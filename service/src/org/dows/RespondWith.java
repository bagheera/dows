package org.dows;

public class RespondWith {
    private static RespondWith instance = new RespondWith();
    private LookupResponse response;

    public static RespondWith getInstance() {
        return instance;
    }

    public void setResponse(LookupResponse response) {
        this.response = response;
    }

    public LookupResponse getResponse() {
        return response;
    }
}

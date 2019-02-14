package com.jobfinder.progressoft.jobfinder.model.type;

public enum WebServiceType {

    GET_MESSAGES("getMessages");

    private String webserviceName;

    WebServiceType(String webserviceName) {
        this.webserviceName = webserviceName;
    }

    public String getWebserviceName() {
        return webserviceName;
    }

    public void setWebserviceName(String webserviceName) {
        this.webserviceName = webserviceName;
    }
}
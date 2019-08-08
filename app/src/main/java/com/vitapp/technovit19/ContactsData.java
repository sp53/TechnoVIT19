package com.vitapp.technovit19;

public class ContactsData {
    private String url;
    private String name;
    private String number;

    public ContactsData(String url, String name, String number) {
        this.url = url;
        this.name = name;
        this.number = number;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

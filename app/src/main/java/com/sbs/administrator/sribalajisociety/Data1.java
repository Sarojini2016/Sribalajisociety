package com.sbs.administrator.sribalajisociety;

public class Data1 {

    private String header;
    private String subHeader;
    private String mobile;
    private String fax;
    private String email;

    public Data1(String header, String subHeader, String mobile, String fax, String email) {
        super();
        this.header = header;
        this.subHeader = subHeader;
        this.mobile = mobile;
        this.fax = fax;
        this.email = email;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getSubHeader() {
        return subHeader;
    }

    public void setSubHeader(String subHeader) {
        this.subHeader = subHeader;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}


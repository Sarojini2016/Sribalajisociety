package com.sbs.administrator.sribalajisociety;

public class SearchResults {
    private String designationname = "";
    private String telephone = "";
    private String faxno = "";
    private String emailid = "";

    public void setdesignationname(String name) {
        this.designationname = name;
    }

    public String getdesignationname() {
        return designationname;
    }

    public String gettelephone() {
        return telephone;
    }

    public void settelephone(String Telephone) {
        this.telephone = Telephone;
    }

    public String getfaxno() {
        return faxno;
    }

    public void setfaxno(String faxno) {
        this.faxno = faxno;
    }

    public String getemaild() {
        return emailid;
    }

    public void setemailid(String eid) {
        this.emailid = eid;

    }
}

package rms.demo.domain;

public class Affiche {
    private String aid;
    private String amessage;
    private String adate;

    public Affiche() {
    }

    public Affiche(String aid, String amessage, String adate) {
        this.aid = aid;
        this.amessage = amessage;
        this.adate = adate;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAmessage() {
        return amessage;
    }

    public void setAmessage(String amessage) {
        this.amessage = amessage;
    }

    public String getAdate() {
        return adate;
    }

    public void setAdate(String adate) {
        this.adate = adate;
    }
}

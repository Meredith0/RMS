package rms.demo.domain;

public class Checkstate {
    private String id;
    private String eid;
    private int cyear;
    private int cmonth;
    private int atwork;
    private int late;
    private int early;

    public Checkstate() {
    }

    public Checkstate(String id,String eid, int cyear, int cmonth, int atwork, int late, int early) {
        this.id = id;
        this.eid = eid;
        this.cyear = cyear;
        this.cmonth = cmonth;
        this.atwork = atwork;
        this.late = late;
        this.early = early;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public int getCyear() {
        return cyear;
    }

    public void setCyear(int cyear) {
        this.cyear = cyear;
    }

    public int getCmonth() {
        return cmonth;
    }

    public void setCmonth(int cmonth) {
        this.cmonth = cmonth;
    }

    public int getAtwork() {
        return atwork;
    }

    public void setAtwork(int atwork) {
        this.atwork = atwork;
    }

    public int getLate() {
        return late;
    }

    public void setLate(int late) {
        this.late = late;
    }

    public int getEarly() {
        return early;
    }

    public void setEarly(int early) {
        this.early = early;
    }

    @Override
    public String toString () {
        return "Checkstate{" + "id='" + id + '\'' + ", eid='" + eid + '\'' + ", cyear=" + cyear + ", cmonth=" + cmonth
                   + ", atwork=" + atwork + ", late=" + late + ", early=" + early + '}';
    }

}

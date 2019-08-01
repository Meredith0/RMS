package rms.demo.domain;

public class Checkwork {
    private String cid;

    private String eid;

    private String itime;

    private String otime;

    private Integer holiday;

    public Checkwork() {
    }

    public Checkwork(String cid, String eid, String itime, String otime, Integer holiday) {
        this.cid = cid;
        this.eid = eid;
        this.itime = itime;
        this.otime = otime;
        this.holiday = holiday;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid == null ? null : eid.trim();
    }

    public String getItime() {
        return itime;
    }

    public void setItime(String itime) {
        this.itime = itime;
    }

    public String getOtime() {
        return otime;
    }

    public void setOtime(String otime) {
        this.otime = otime;
    }

    public Integer getHoliday() {
        return holiday;
    }

    public void setHoliday(Integer holiday) {
        this.holiday = holiday;
    }
}
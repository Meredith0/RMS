package rms.demo.domain;
/**
 * @author : Meredith
 * @date : 2019-07-30 11:00
 * @description :
 */
public class Department {

    private int did;
    private String dname;
    private String dmanager;

    public Department() {
    }

    public Department(int did, String dname, String dmanager) {
        this.did = did;
        this.dname = dname;
        this.dmanager = dmanager;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDmanager() {
        return dmanager;
    }

    public void setDmanager(String dmanager) {
        this.dmanager = dmanager;
    }

    @Override
    public String toString() {
        return "Department{" +
                   "did=" + did +
                   ", dname='" + dname + '\'' +
                   ", dmanager='" + dmanager + '\'' +
                   '}';
    }
}

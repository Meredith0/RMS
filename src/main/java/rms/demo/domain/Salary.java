package rms.demo.domain;

/**
 * Description: SSM01
 *
 * @author CM
 * Created by Administrator on 2019/7/26 9:23
 */
public class Salary {
    private String  sid;

    private String eid;

    private String base;

    private String date;

    private String bonus;
    /**
    希望查询员工工资时也查询员工信息
    */
    private Employee employee;

    public Salary(){
    }

    public Salary(String sid,String eid,String base,String date,String bonus,Employee employee){
        this.sid = sid;
        this.eid = eid;
        this.base = base;
        this.date = date;
        this.bonus = bonus;
        this.employee = employee;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getEid() {
        return eid;
    }

    public void setEid(String eid) {
        this.eid = eid;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "sid='" + sid + '\'' +
                ", eid='" + eid + '\'' +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", bonus='" + bonus + '\'' +
                ", employee=" + employee +
                '}';
    }
}

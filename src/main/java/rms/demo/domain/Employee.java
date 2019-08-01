package rms.demo.domain;

import java.sql.Date;

/**
 * @author : Meredith
 * @date : 2019-07-31 17:03
 * @description :
 */
public class Employee {

    private String sex;

    private Date workdate; //入职日期
    private Integer did;
    private Integer pid;
    private String identity;
    private Integer phone;
    private String address;
    private Date birthday;
    private Integer eid;
    private String ename;

    public Employee () {
    }

    public Employee (String ename) {
        this.ename = ename;
    }


    public Integer getEid () {
        return eid;
    }

    public void setEid (Integer eid) {
        this.eid = eid;
    }

    public String getEname () {
        return ename;
    }

    public void setEname (String ename) {
        this.ename = ename;
    }

    public String getSex () {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }

    public Integer getDid () {
        return did;
    }

    public void setDid (Integer did) {
        this.did = did;
    }

    public Integer getPid () {
        return pid;
    }

    public void setPid (Integer pid) {
        this.pid = pid;
    }



    public Integer getPhone () {
        return phone;
    }

    public void setPhone (Integer phone) {
        this.phone = phone;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }

    public Date getBirthday () {
        return birthday;
    }

    public void setBirthday (Date birthday) {
        this.birthday = birthday;
    }

    public String getIdentity () {
        return identity;
    }

    public void setIdentity (String identity) {
        this.identity = identity;
    }

    public Date getWorkdate () {
        return workdate;
    }

    public void setWorkdate (Date workdate) {
        this.workdate = workdate;
    }

    @Override
    public String toString () {
        return "Employee{" + "sex='" + sex + '\'' + ", workdate=" + workdate + ", did=" + did + ", pid=" + pid
                   + ", identity='" + identity + '\'' + ", phone=" + phone + ", address='" + address + '\''
                   + ", birthday=" + birthday + ", eid=" + eid + ", ename='" + ename + '\'' + '}';
    }

}

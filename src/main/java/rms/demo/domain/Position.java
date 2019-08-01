package rms.demo.domain;
/**
 * @author : Meredith
 * @date : 2019-07-29 08:49
 * @description : 职位
 */
public class Position {
    private Integer pid;

    private String pname;
    private Double basemoney;

    private Integer count;

    @Override
    public String toString()
    {
        return "Position{" +
                   "pid=" + pid +
                   ", pname='" + pname + '\'' +
                   ", basemoney=" + basemoney +
                   ", count=" + count +
                   '}';
    }

    public Position () {
    }

    public Position(Integer pid, String pname, Double basemoney, Integer count)
    {
        this.pid = pid;
        this.pname = pname;
        this.basemoney = basemoney;
        this.count = count;
    }

    public Position (String pname, Double basemoney, Integer count) {
        this.pname = pname;
        this.basemoney = basemoney;
        this.count = count;
    }

    public Integer getPid()
    {
        return pid;
    }

    public void setPid(Integer pid)
    {
        this.pid = pid;
    }

    public String getPname()
    {
        return pname;
    }

    public void setPname(String pname)
    {
        this.pname = pname == null ? null : pname.trim();
    }

    public Double getBasemoney()
    {
        return basemoney;
    }

    public void setBasemoney(Double basemoney)
    {
        this.basemoney = basemoney;
    }

    public Integer getCount()
    {
        return count;
    }

    public void setCount(Integer count)
    {
        this.count = count;
    }

}

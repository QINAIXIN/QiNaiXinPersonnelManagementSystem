package org.javaboy.vhr.model.vo;


public class EmployeeecRespVo {
    private Integer id;

    private Integer eid;

    private String ecdate;

    private String ecreason;

    private Integer ecpoint;

    private String ectype;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEcdate() {
        return ecdate;
    }

    public void setEcdate(String ecdate) {
        this.ecdate = ecdate;
    }

    public String getEcreason() {
        return ecreason;
    }

    public void setEcreason(String ecreason) {
        this.ecreason = ecreason == null ? null : ecreason.trim();
    }

    public Integer getEcpoint() {
        return ecpoint;
    }

    public void setEcpoint(Integer ecpoint) {
        this.ecpoint = ecpoint;
    }

    public String getEctype() {
        return ectype;
    }

    public void setEctype(String ectype) {
        this.ectype = ectype;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}
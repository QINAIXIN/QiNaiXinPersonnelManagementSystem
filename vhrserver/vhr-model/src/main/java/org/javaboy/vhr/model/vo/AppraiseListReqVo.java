package org.javaboy.vhr.model.vo;

import org.javaboy.vhr.model.vo.PageReqVo;

public class AppraiseListReqVo extends PageReqVo {


    private String appresult;

    private String appcontent;

    public String getAppresult() {
        return appresult;
    }

    public void setAppresult(String appresult) {
        this.appresult = appresult;
    }

    public String getAppcontent() {
        return appcontent;
    }

    public void setAppcontent(String appcontent) {
        this.appcontent = appcontent;
    }
}

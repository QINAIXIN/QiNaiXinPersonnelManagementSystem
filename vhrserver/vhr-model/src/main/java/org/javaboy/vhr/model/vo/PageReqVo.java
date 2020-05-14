package org.javaboy.vhr.model.vo;

public class PageReqVo {

    private Integer page;
    private Integer size;

    public Integer getPage() {
        return page==null?1:page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size==null?10:size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}

package com.kermi.market.marketevent.entity;

import java.util.List;

public class PageResult<T> {

    private int totalPageNum;

    public int getTotalPageNum() {
        return totalPageNum;
    }

    public void setTotalPageNum(int totalPageNum) {
        this.totalPageNum = totalPageNum;
    }

    private List<T> datas;

    private long total;

    public PageResult() {
    }

    public PageResult(List<T> datas, long total, int totalPageNum) {
        this.datas = datas;
        this.total = total;
        this.totalPageNum=totalPageNum;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}

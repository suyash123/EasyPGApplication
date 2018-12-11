package com.easy.pg.model;

import android.arch.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class PGSearchInfos {

    private String status;
    private List<PGSearchInfo> pgSearchInfoList = new ArrayList<>();
    private MutableLiveData<List<PGSearchInfo>> pgListMutableLiveData = new MutableLiveData<>();

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setPgSearchInfoList(List<PGSearchInfo> pgSearchInfoList) {
        this.pgSearchInfoList = pgSearchInfoList;
    }

    public MutableLiveData<List<PGSearchInfo>> getPgListMutableLiveData() {
        return pgListMutableLiveData;
    }
}

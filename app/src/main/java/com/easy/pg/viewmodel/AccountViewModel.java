package com.easy.pg.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.easy.pg.model.AccountInfo;
import com.easy.pg.view.callbacks.IAccInfoCallbacks;

public class AccountViewModel extends ViewModel {

    private MutableLiveData<AccountInfo> accInfoLiveData = new MutableLiveData<>();
    private IAccInfoCallbacks accInfoCallbacks;

    public AccountViewModel() {
    }

    public void setAccInfoCallbacks(IAccInfoCallbacks accInfoCallbacks) {
        this.accInfoCallbacks = accInfoCallbacks;
    }

    public MutableLiveData<AccountInfo> getAccInfoLiveData() {
        return accInfoLiveData;
    }
}

package com.easy.pg.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.view.View;

import com.easy.pg.core.sharedpref.SharedPrefConst;
import com.easy.pg.core.sharedpref.SharedPrefUtils;
import com.easy.pg.core.utils.ValidatorUtil;
import com.easy.pg.model.LoginInfo;
import com.easy.pg.view.callbacks.ILoginCallbacks;

public class LoginViewModel extends ViewModel {

    public LoginInfo loginInfo = new LoginInfo();
    private ILoginCallbacks iLoginCallbacks;

    public LoginViewModel() {
    }

    public void setLoginCallbacks(ILoginCallbacks iLoginCallbacks) {
        this.iLoginCallbacks = iLoginCallbacks;
    }

    public void onLogin() {
        //ToDo
        if(loginInfo != null &&
                ValidatorUtil.isValidPhoneNumber(loginInfo.getMobile()) &&
                ValidatorUtil.isValidPassword(loginInfo.getPwd())){
            if(loginInfo.getMobile().equals("9999417641") && loginInfo.getPwd().equals("pwd123456")){
                SharedPrefUtils.getInstance(SharedPrefUtils.ACCOUNT_SETTINGS).saveDataSafe(SharedPrefConst.SP_ACC_CREATED, true);
                SharedPrefUtils.getInstance(SharedPrefUtils.ACCOUNT_SETTINGS).saveDataSafe(SharedPrefConst.SP_ACC_MOBILE, loginInfo.getMobile());
                SharedPrefUtils.getInstance(SharedPrefUtils.ACCOUNT_SETTINGS).saveDataSafe(SharedPrefConst.SP_ACC_PWD, loginInfo.getPwd());
                iLoginCallbacks.onLogin(true, "Success.");
            }
        } else if(iLoginCallbacks != null){
            iLoginCallbacks.onLogin(false, "Work in progress!! Try again later :)");
        }
    }

    public void onNewRegisterClick() {
        if(iLoginCallbacks != null) {
            iLoginCallbacks.onNewRegistrationClick();
        }
    }
}

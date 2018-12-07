package com.easy.pg.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.view.View;

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
        if(iLoginCallbacks != null){
            iLoginCallbacks.onLogin(false, "Work in progress!! Try again later :)");
        }
    }

    public void onNewRegisterClick() {
        if(iLoginCallbacks != null) {
            iLoginCallbacks.onNewRegistrationClick();
        }
    }
}

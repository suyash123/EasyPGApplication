package com.easy.pg.viewmodel;

import android.arch.lifecycle.ViewModel;

import com.easy.pg.model.RegisterInfo;
import com.easy.pg.view.callbacks.IRegistrationCallback;

public class RegisterViewModel extends ViewModel{

    public RegisterInfo registerInfo = new RegisterInfo();
    private IRegistrationCallback iRegistrationCallback;

    public RegisterViewModel() {
    }

    public void setRegistrationCallback(IRegistrationCallback iRegistrationCallback) {
        this.iRegistrationCallback = iRegistrationCallback;
    }

    public void onRegister() {
        //ToDo
        if(iRegistrationCallback != null){
            iRegistrationCallback.onRegistration(false, "Work in progress!! Try again later :)");
        }
    }

    public void onLoginBackClick() {
        if(iRegistrationCallback != null) {
            iRegistrationCallback.onBackLoginClick();
        }
    }
}

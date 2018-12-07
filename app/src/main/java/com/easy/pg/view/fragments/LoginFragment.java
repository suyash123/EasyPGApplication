package com.easy.pg.view.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.easy.pg.app.BR;
import com.easy.pg.app.databinding.LoginInfoBinding;
import com.easy.pg.app.R;
import com.easy.pg.view.callbacks.ILoginCallbacks;
import com.easy.pg.viewmodel.LoginViewModel;

public class LoginFragment extends Fragment implements ILoginCallbacks{

    public static final String TAG = LoginFragment.class.getSimpleName();
    private LoginViewModel loginViewModel;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        loginViewModel = ViewModelProviders.of(getActivity()).get(LoginViewModel.class);
        loginViewModel.setLoginCallbacks(this);
        LoginInfoBinding viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.login, container, false);
        viewDataBinding.setLoginVar(loginViewModel);
        return viewDataBinding.getRoot();
    }

    @Override
    public void onLogin(boolean isSuccess, String message) {
        showSnackBarMessage(message);
    }

    @Override
    public void onNewRegistrationClick() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        RegisterFragment fragment = new RegisterFragment();
        ft.replace(R.id.fragmentFrame, fragment, RegisterFragment.TAG);
        ft.commit();
    }

    private void showSnackBarMessage(String message) {

        if (getView() != null) {

            Snackbar.make(getView(),message,Snackbar.LENGTH_SHORT).show();
        }
    }
}

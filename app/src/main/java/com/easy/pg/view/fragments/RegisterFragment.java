package com.easy.pg.view.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easy.pg.app.BR;
import com.easy.pg.app.R;
import com.easy.pg.app.databinding.RegisterInfoBinding;
import com.easy.pg.view.HomeActivity;
import com.easy.pg.view.callbacks.IRegistrationCallback;
import com.easy.pg.viewmodel.RegisterViewModel;

public class RegisterFragment extends Fragment implements IRegistrationCallback {

    public static final String TAG = LoginFragment.class.getSimpleName();
    private RegisterViewModel registerViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        registerViewModel = ViewModelProviders.of(getActivity()).get(RegisterViewModel.class);
        registerViewModel.setRegistrationCallback(this);
        RegisterInfoBinding viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.register, container, false);
        viewDataBinding.setRegVar(registerViewModel);
        return viewDataBinding.getRoot();
    }

    @Override
    public void onRegistration(boolean isSuccess, String message) {
        showSnackBarMessage(message);
        if (isSuccess) {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

    @Override
    public void onBackLoginClick() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        LoginFragment fragment = new LoginFragment();
        ft.replace(R.id.fragmentFrame, fragment, LoginFragment.TAG);
        ft.commit();
    }

    private void showSnackBarMessage(String message) {

        if (getView() != null) {

            Snackbar.make(getView(),message,Snackbar.LENGTH_SHORT).show();
        }
    }
}

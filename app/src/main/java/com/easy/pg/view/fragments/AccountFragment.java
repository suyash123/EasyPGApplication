package com.easy.pg.view.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.easy.pg.app.R;
import com.easy.pg.app.databinding.AccountInfoBinding;
import com.easy.pg.view.callbacks.IAccInfoCallbacks;
import com.easy.pg.viewmodel.AccountViewModel;

public class AccountFragment extends Fragment implements IAccInfoCallbacks{

    public static final String TAG = AccountFragment.class.getSimpleName();
    private AccountViewModel accountViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        accountViewModel = ViewModelProviders.of(getActivity()).get(AccountViewModel.class);
        accountViewModel.setAccInfoCallbacks(this);
        AccountInfoBinding viewDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_account, container, false);
        viewDataBinding.setAccViewModel(accountViewModel);
        return viewDataBinding.getRoot();
    }
}

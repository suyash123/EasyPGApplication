package com.easy.pg.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.easy.pg.app.R;
import com.easy.pg.core.sharedpref.SharedPrefConst;
import com.easy.pg.core.sharedpref.SharedPrefUtils;
import com.easy.pg.view.fragments.LoginFragment;

public class EasyPGActivity extends AppCompatActivity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean isAccountCreated = SharedPrefUtils.getInstance(SharedPrefUtils.ACCOUNT_SETTINGS).getDataSafe(SharedPrefConst.SP_ACC_CREATED, false);
        if(isAccountCreated) {
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_login);

        if (savedInstanceState == null) {

            loadFragment();
        }
    }

    private void loadFragment() {
        if (loginFragment == null) {

            loginFragment = new LoginFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, loginFragment, LoginFragment.TAG).commit();
    }
}

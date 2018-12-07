package com.easy.pg.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.easy.pg.app.R;
import com.easy.pg.view.fragments.LoginFragment;

public class EasyPGActivity extends AppCompatActivity {

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

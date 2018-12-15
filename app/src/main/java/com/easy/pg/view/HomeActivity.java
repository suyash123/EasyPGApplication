package com.easy.pg.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.easy.pg.app.R;
import com.easy.pg.view.fragments.AccountFragment;
import com.easy.pg.view.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                loadHomeFragment();
                                break;
                            case R.id.action_account:
                                loadAccountFragment();
                                break;
                        }
                        return true;
                    }
                });
        if (savedInstanceState == null) {

            loadHomeFragment();
        }
    }

    private void loadHomeFragment() {
        if (homeFragment == null) {

            homeFragment = new HomeFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, homeFragment, HomeFragment.TAG).commit();
    }

    private void loadAccountFragment() {
        if (accountFragment == null) {

            accountFragment = new AccountFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, accountFragment, AccountFragment.TAG).commit();
    }
}

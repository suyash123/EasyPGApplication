package com.easy.pg.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.easy.pg.app.R;
import com.easy.pg.model.FilterData;
import com.easy.pg.modules.dialog.filter.CustomFilterFragment;
import com.easy.pg.view.fragments.AccountFragment;
import com.easy.pg.view.fragments.FilterFragment;
import com.easy.pg.view.fragments.HomeFragment;

import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements CustomFilterFragment.Callbacks, CustomFilterFragment.AnimationListener{

    private HomeFragment homeFragment;
    private AccountFragment accountFragment;
    private FilterData filterData;
    private HashMap<String, List<String>> applied_filters;

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

        applied_filters = new HashMap<>();
        filterData = FilterData.getSampleFilterData();
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

    public FilterData getFilterData() {
        return filterData;
    }

    public HashMap<String, List<String>> getApplied_filters() {
        return applied_filters;
    }

    @Override
    public void onResult(Object result) {
        Log.d("HomeActivity", "On Result");
    }

    @Override
    public void onOpenAnimationStart() {
        Log.d("HomeActivity", "onOpenAnimationStart");
    }

    @Override
    public void onOpenAnimationEnd() {
        Log.d("HomeActivity", "onOpenAnimationEnd");
    }

    @Override
    public void onCloseAnimationStart() {
        Log.d("HomeActivity", "onCloseAnimationStart");
    }

    @Override
    public void onCloseAnimationEnd() {
        Log.d("HomeActivity", "onCloseAnimationEnd");
    }
}

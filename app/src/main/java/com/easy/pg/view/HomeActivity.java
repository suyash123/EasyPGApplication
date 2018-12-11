package com.easy.pg.view;

import android.app.SearchManager;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.easy.pg.app.R;
import com.easy.pg.model.PGSearchInfo;
import com.easy.pg.view.adapters.HomeAdapter;
import com.easy.pg.viewmodel.HomeViewModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private MenuItem mSearchItem;
    private MenuItem mFilterItem;
    private Toolbar mToolbar;
    private HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        final RecyclerView recyclerView = findViewById(R.id.pg_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeAdapter = new HomeAdapter(R.layout.card_home, homeViewModel);

        homeViewModel.getMutableLiveData().observe(this, new Observer<ArrayList<PGSearchInfo>>() {
            @Override
            public void onChanged(@Nullable ArrayList<PGSearchInfo> pgSearchInfos) {
                homeAdapter.setPgSearchInfos(pgSearchInfos);
                recyclerView.setAdapter(homeAdapter);
            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_home:
                                break;
                            case R.id.action_account:
                                break;
                        }
                        return true;
                    }
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_filter_menu, menu);

        mSearchItem = menu.findItem(R.id.m_search);

        MenuItemCompat.setOnActionExpandListener(mSearchItem, new MenuItemCompat.OnActionExpandListener() {
            @Override
            public boolean onMenuItemActionCollapse(MenuItem item) {
                if (mSearchItem.isActionViewExpanded()) {
                    //ToDo
                }
                return true;
            }

            @Override
            public boolean onMenuItemActionExpand(MenuItem item) {
                //ToDo
                return true;
            }
        });

        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(mSearchItem);
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //ToDo
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                //ToDo
                return false;
            }
        });

        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ToDo
            }
        });

        mFilterItem = menu.findItem(R.id.m_filter);
        mFilterItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                //ToDo
                return false;
            }
        });
        return true;
    }
}

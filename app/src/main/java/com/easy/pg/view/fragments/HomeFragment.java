package com.easy.pg.view.fragments;

import android.app.SearchManager;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.easy.pg.app.R;
import com.easy.pg.model.FilterData;
import com.easy.pg.model.PGSearchInfo;
import com.easy.pg.view.adapters.HomeAdapter;
import com.easy.pg.viewmodel.HomeViewModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment{

    public static final String TAG = HomeFragment.class.getSimpleName();
    private MenuItem mSearchItem;
//    private MenuItem mFilterItem;
    private Toolbar mToolbar;
    private HomeViewModel homeViewModel;
    private HomeAdapter homeAdapter;
    private FilterFragment filterFragment;
    private FloatingActionButton fab;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mToolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(mToolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        final RecyclerView recyclerView = root.findViewById(R.id.pg_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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
        fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFilterFragment();
            }
        });
        return root;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_filter_menu, menu);

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
        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));

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

//        mFilterItem = menu.findItem(R.id.m_filter);
//        mFilterItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//            @Override
//            public boolean onMenuItemClick(MenuItem menuItem) {
//                //ToDo
//                return false;
//            }
//        });
    }

    private void loadFilterFragment() {
        if (filterFragment == null) {
            filterFragment = new FilterFragment();
            filterFragment.setParentFab(fab);
        }
        filterFragment.show(((AppCompatActivity)getActivity()).getSupportFragmentManager(), FilterFragment.TAG);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentFrame, filterFragment, FilterFragment.TAG).commit();
    }
}

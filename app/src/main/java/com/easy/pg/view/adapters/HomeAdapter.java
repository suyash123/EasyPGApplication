package com.easy.pg.view.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.easy.pg.app.BR;
import com.easy.pg.app.databinding.PGSearchInfoBinding;
import com.easy.pg.model.PGSearchInfo;
import com.easy.pg.viewmodel.HomeViewModel;

import java.util.ArrayList;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder>{

    private ArrayList<PGSearchInfo> pgSearchInfos;
    private HomeViewModel homeViewModel;
    private int layoutId;
    private LayoutInflater layoutInflater;

    public HomeAdapter(@LayoutRes int layoutId, HomeViewModel homeViewModel) {
        this.homeViewModel = homeViewModel;
        this.layoutId = layoutId;
    }

    public void setPgSearchInfos(ArrayList<PGSearchInfo> pgSearchInfos) {
        this.pgSearchInfos = pgSearchInfos;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if(layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        PGSearchInfoBinding pgSearchInfoBinding = DataBindingUtil.inflate(layoutInflater, layoutId, viewGroup, false);

        return new HomeViewHolder(pgSearchInfoBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        PGSearchInfo pgSearchInfo = pgSearchInfos.get(position);
        holder.bind(homeViewModel, position, pgSearchInfo);
    }

    @Override
    public int getItemCount() {
        return pgSearchInfos == null ? 0 : pgSearchInfos.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder{

        private PGSearchInfoBinding pgSearchInfoBinding;

        public HomeViewHolder(@NonNull PGSearchInfoBinding pgSearchInfoBinding) {
            super(pgSearchInfoBinding.getRoot());
            this.pgSearchInfoBinding = pgSearchInfoBinding;
        }

        private void bind(HomeViewModel viewModel, int position, PGSearchInfo pgSearchInfo) {
            pgSearchInfoBinding.setPgInfo(pgSearchInfo);
            pgSearchInfoBinding.setPosition(position);
            pgSearchInfoBinding.setViewModel(viewModel);
            pgSearchInfoBinding.executePendingBindings();
        }
    }
}

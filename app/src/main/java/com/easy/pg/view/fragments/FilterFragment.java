package com.easy.pg.view.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.easy.pg.app.R;
import com.easy.pg.core.utils.AppConstants;
import com.easy.pg.modules.dialog.filter.CustomFilterFragment;
import com.easy.pg.view.HomeActivity;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilterFragment extends CustomFilterFragment{

    public static final String TAG = AccountFragment.class.getSimpleName();
    private HashMap<String, List<String>> applied_filters = new HashMap<>();
    private List<TextView> textviews = new ArrayList<>();

    private TabLayout tabs_types;

    private ImageButton imgbtn_refresh, imgbtn_apply;
    private SectionsPagerAdapter mAdapter;
    private DisplayMetrics metrics;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        applied_filters = ((HomeActivity) getActivity()).getApplied_filters();
        metrics = this.getResources().getDisplayMetrics();

        for (Map.Entry<String, List<String>> entry : applied_filters.entrySet()) {
            Log.d("k9res", "from activity: " + entry.getKey());
            for (String s : entry.getValue()) {
                Log.d("k9res", "from activity val: " + s);

            }
        }
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        View contentView = View.inflate(getContext(), R.layout.filter_view, null);

        RelativeLayout rl_content = (RelativeLayout) contentView.findViewById(R.id.rl_content);
        LinearLayout ll_buttons = (LinearLayout) contentView.findViewById(R.id.ll_buttons);
        imgbtn_refresh = (ImageButton) contentView.findViewById(R.id.imgbtn_refresh);
        imgbtn_apply = (ImageButton) contentView.findViewById(R.id.imgbtn_apply);
        ViewPager vp_types = (ViewPager) contentView.findViewById(R.id.vp_types);
        tabs_types = (TabLayout) contentView.findViewById(R.id.tabs_types);

        imgbtn_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFilter(applied_filters);
            }
        });
        imgbtn_refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (TextView tv : textviews) {
                    tv.setTag(AppConstants.UNSELECTED_TAG);
                    tv.setBackgroundResource(R.drawable.tab_unselect);
                    tv.setTextColor(ContextCompat.getColor(getContext(), R.color.filters_tabs));
                }
                applied_filters.clear();
            }
        });

        mAdapter = new SectionsPagerAdapter();
        vp_types.setOffscreenPageLimit(4);
        vp_types.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        tabs_types.setupWithViewPager(vp_types);


        //params to set
        setAnimationDuration(600); //optional; default 500ms
        setPeekHeight(300); // optional; default 400dp
        setCallbacks((Callbacks) getActivity()); //optional; to get back result
        setAnimationListener((AnimationListener) getActivity()); //optional; to get animation callbacks
        setViewgroupStatic(ll_buttons); // optional; layout to stick at bottom on slide
        setViewPager(vp_types); //optional; if you use viewpager that has scrollview
        setViewMain(rl_content); //necessary; main bottomsheet view
        setMainContentView(contentView); // necessary; call at end before super
        super.setupDialog(dialog, style); //call super at last
    }

    public class SectionsPagerAdapter extends PagerAdapter {

        @Override
        public Object instantiateItem(ViewGroup collection, int position) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.sorter_layout, collection, false);
            FlexboxLayout fbl = (FlexboxLayout) layout.findViewById(R.id.fbl);
//            LinearLayout ll_scroll = (LinearLayout) layout.findViewById(R.id.ll_scroll);
//            FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (int) (metrics.heightPixels-(104*metrics.density)));
//            ll_scroll.setLayoutParams(lp);
            switch (position) {
                case 0:
                    inflateLayoutWithFilters(AppConstants.PG, fbl);
                    break;
                case 1:
                    inflateLayoutWithFilters(AppConstants.COLLEGE, fbl);
                    break;
                case 2:
                    inflateLayoutWithFilters(AppConstants.AREA, fbl);
                    break;
                case 3:
                    inflateLayoutWithFilters(AppConstants.RATING, fbl);
                    break;
                case 4:
                    inflateLayoutWithFilters(AppConstants.PRICE, fbl);
                    break;
                case 5:
                    inflateLayoutWithFilters(AppConstants.DISTANCE, fbl);
                    break;
            }
            collection.addView(layout);
            return layout;

        }

        @Override
        public void destroyItem(ViewGroup collection, int position, Object view) {
            collection.removeView((View) view);
        }

        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.pg);
                case 1:
                    return getResources().getString(R.string.college);
                case 2:
                    return getResources().getString(R.string.area);
                case 3:
                    return getResources().getString(R.string.rating);
                case 4:
                    return getResources().getString(R.string.price);
                case 5:
                    return getResources().getString(R.string.distance);
            }
            return "";
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

    }

    private void inflateLayoutWithFilters(final String filter_category, FlexboxLayout fbl) {
        List<String> keys = new ArrayList<>();
        switch (filter_category) {
            case AppConstants.PG:
                keys = ((HomeActivity) getActivity()).getFilterData().getUniquePGKeys();
                break;
            case AppConstants.AREA:
                keys = ((HomeActivity) getActivity()).getFilterData().getUniqueAreaKeys();
                break;
            case AppConstants.COLLEGE:
                keys = ((HomeActivity) getActivity()).getFilterData().getUniqueCollegeKeys();
                break;
            case AppConstants.DISTANCE:
                keys = ((HomeActivity) getActivity()).getFilterData().getUniqueDistanceKeys();
                break;
            case AppConstants.PRICE:
                keys = ((HomeActivity) getActivity()).getFilterData().getUniquePriceKeys();
                break;
            case AppConstants.RATING:
                keys = ((HomeActivity) getActivity()).getFilterData().getUniqueRatingKeys();
                break;
        }

        for (int i = 0; i < keys.size(); i++) {
            View subchild = getActivity().getLayoutInflater().inflate(R.layout.single_chip, null);
            final TextView tv = ((TextView) subchild.findViewById(R.id.txt_title));
            tv.setText(keys.get(i));
            final int finalI = i;
            final List<String> finalKeys = keys;
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (tv.getTag() != null && tv.getTag().equals(AppConstants.SELECTED_TAG)) {
                        tv.setTag(AppConstants.UNSELECTED_TAG);
                        tv.setBackgroundResource(R.drawable.tab_unselect);
                        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.filters_tabs));
                        removeFromSelectedMap(filter_category, finalKeys.get(finalI));
                    } else {
                        tv.setTag(AppConstants.SELECTED_TAG);
                        tv.setBackgroundResource(R.drawable.tab_select);
                        tv.setTextColor(ContextCompat.getColor(getContext(), R.color.filters_header));
                        addToSelectedMap(filter_category, finalKeys.get(finalI));
                    }
                }
            });
            try {
                Log.d("k9res", "key: " + filter_category + " |val:" + keys.get(finalI));
                Log.d("k9res", "applied_filters != null: " + (applied_filters != null));
                Log.d("k9res", "applied_filters.get(key) != null: " + (applied_filters.get(filter_category) != null));
                Log.d("k9res", "applied_filters.get(key).contains(keys.get(finalI)): " + (applied_filters.get(filter_category).contains(keys.get(finalI))));
            } catch (Exception e) {

            }
            if (applied_filters != null && applied_filters.get(filter_category) != null && applied_filters.get(filter_category).contains(keys.get(finalI))) {
                tv.setTag(AppConstants.SELECTED_TAG);
                tv.setBackgroundResource(R.drawable.tab_select);
                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.filters_header));
            } else {
                tv.setBackgroundResource(R.drawable.tab_unselect);
                tv.setTextColor(ContextCompat.getColor(getContext(), R.color.filters_tabs));
            }
            textviews.add(tv);

            fbl.addView(subchild);
        }


    }

    private void addToSelectedMap(String key, String value) {
        if (applied_filters.get(key) != null && !applied_filters.get(key).contains(value)) {
            applied_filters.get(key).add(value);
        } else {
            List<String> temp = new ArrayList<>();
            temp.add(value);
            applied_filters.put(key, temp);
        }
    }

    private void removeFromSelectedMap(String key, String value) {
        if (applied_filters.get(key).size() == 1) {
            applied_filters.remove(key);
        } else {
            applied_filters.get(key).remove(value);
        }
    }
}

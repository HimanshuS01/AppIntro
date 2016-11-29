package com.github.paolorotolo.appintroexample.ui.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.paolorotolo.appintroexample.R;
import com.github.paolorotolo.appintroexample.ui.permsTabs.PermsPagerAdapter;
import com.github.paolorotolo.appintroexample.util.TabLayout;

/**
 * Created by andrew on 11/17/16.
 */

public class PermissionTabsFragment extends Fragment {

    ViewPager pager;
    PermsPagerAdapter adapter;
    TabLayout tabs;
    CharSequence Titles[] = {getResources().getString(R.string.tg2_tab_1),
            getResources().getString(R.string.tg2_tab_2)};
    int Numboftabs = 2;

    public PermissionTabsFragment() {
        //required empty constructor
    }

    @SuppressWarnings({"ConstantConditions", "deprecation"})
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        adapter = new PermsPagerAdapter(getActivity().getFragmentManager(), Titles, Numboftabs);

        pager = (ViewPager) getView().findViewById(R.id.pager);
        pager.setAdapter(adapter);

        tabs = (TabLayout) getView().findViewById(R.id.tabs);
        tabs.setBackgroundColor(getResources().getColor(R.color.blue));
        tabs.setDistributeEvenly(true);
        tabs.setCustomTabColorizer(new TabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.blue);
            }
        });
        tabs.setViewPager(pager);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_permission_tabs, container, false);
    }
}

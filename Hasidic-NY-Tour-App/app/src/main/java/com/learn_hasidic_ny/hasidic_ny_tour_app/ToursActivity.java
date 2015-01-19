package com.learn_hasidic_ny.hasidic_ny_tour_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.FragmentTabHost;

import com.learn_hasidic_ny.tours_fragments.GuidedToursFragment;
import com.learn_hasidic_ny.tours_fragments.SelfGuideToursFragment;

/**
 * Created by wengu on 1/11/15.
 */
public class ToursActivity extends Fragment {

    private FragmentTabHost mTabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mTabHost = new FragmentTabHost(getActivity());
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.toursLayout);

        mTabHost.addTab(mTabHost.newTabSpec("guided").setIndicator("Guided"),
                GuidedToursFragment.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("self").setIndicator("Self Guided"),
                SelfGuideToursFragment.class, null);

        return mTabHost;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }
}

package com.learn_hasidic_ny.hasidic_ny_tour_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.support.v4.app.FragmentTabHost;

import com.learn_hasidic_ny.tours_fragments.GuidedToursFragment;
import com.learn_hasidic_ny.tours_fragments.SelfGuideToursFragment;

/**
 * Created by wengu on 1/11/15.
 */
public class ToursActivity extends Fragment {

    private FragmentTabHost tabHost;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tours_layout, container, false);


        return rootView;
    }
}

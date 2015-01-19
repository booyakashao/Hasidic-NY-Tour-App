package com.learn_hasidic_ny.tours_fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.learn_hasidic_ny.hasidic_ny_tour_app.R;

/**
 * Created by wengu on 1/19/15.
 */
public class SelfGuideToursFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.tour_self_guided_layout, container, false);


        return viewRoot;
    }
}

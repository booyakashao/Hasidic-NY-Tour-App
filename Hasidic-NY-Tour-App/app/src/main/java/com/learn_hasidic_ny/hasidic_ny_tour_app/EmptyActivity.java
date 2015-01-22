package com.learn_hasidic_ny.hasidic_ny_tour_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wen Gu on 1/21/2015.
 */
public class EmptyActivity extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View viewRoot = inflater.inflate(R.layout.empty_activity_layout, container, false);

        return viewRoot;
    }
}

package com.learn_hasidic_ny.hasidic_ny_tour_app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by wengu on 1/11/15.
 */
public class POIActivity extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (LinearLayout) inflater.inflate(R.layout.poi_layout, container, false);
    }
}

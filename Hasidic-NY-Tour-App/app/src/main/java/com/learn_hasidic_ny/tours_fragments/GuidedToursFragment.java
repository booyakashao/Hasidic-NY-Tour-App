package com.learn_hasidic_ny.tours_fragments;

import android.support.v4.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.learn_hasidic_ny.db_objects.TourGuide;
import com.learn_hasidic_ny.hasidic_ny_tour_app.EmptyActivity;
import com.learn_hasidic_ny.hasidic_ny_tour_app.POIActivity;
import com.learn_hasidic_ny.hasidic_ny_tour_app.R;

/**
 * Created by wengu on 1/19/15.
 */
public class GuidedToursFragment extends Fragment {

    Fragment fr;
    FragmentManager fm;
    FragmentTransaction fragmentTransaction;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View viewRoot = inflater.inflate(R.layout.tour_guided_layout, container, false);
        viewRoot.setId(View.generateViewId());

        LinearLayout mainLayout = (LinearLayout) viewRoot.findViewById(R.id.mainLinearLayout);

        SQLiteDatabase toursDB = viewRoot.getContext().openOrCreateDatabase("toursDB.db", viewRoot.getContext().MODE_PRIVATE, null);
        Cursor query = toursDB.rawQuery("SELECT * FROM tourGuides", null);

        if(query.moveToFirst()) {
            do {
                // Cycle through all records
                TourGuide currentTourGuide = new TourGuide();
                currentTourGuide.setTour_guide_ID(query.getInt(0));
                currentTourGuide.setFirst_name(query.getString(1));
                currentTourGuide.setLast_name(query.getString(2));
                currentTourGuide.setEmail(query.getString(3));
                currentTourGuide.setDescription(query.getString(4));

                RelativeLayout currentRelativeLayout = new RelativeLayout(viewRoot.getContext());
                currentRelativeLayout.setId(View.generateViewId());
                RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                currentRelativeLayout.setLayoutParams(relativeLayoutParams);
                currentRelativeLayout.setMinimumHeight(50);
                currentRelativeLayout.setClickable(true);

                ImageView currentPicture = new ImageView(viewRoot.getContext());
                currentPicture.setId(View.generateViewId());
                RelativeLayout.LayoutParams pictureViewParams = new RelativeLayout.LayoutParams( convertToDP(viewRoot, 100), convertToDP(viewRoot, 100));
                pictureViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                pictureViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                currentPicture.setScaleType(ImageView.ScaleType.FIT_XY);
                currentPicture.setImageResource(R.drawable.man_silhouette);

                currentRelativeLayout.addView(currentPicture, pictureViewParams);

                final TextView nameTextView = new TextView(viewRoot.getContext());
                nameTextView.setText(currentTourGuide.getFirst_name() + " " + currentTourGuide.getLast_name());
                nameTextView.setId(View.generateViewId());
                RelativeLayout.LayoutParams nameTextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                nameTextViewParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                nameTextViewParams.addRule(RelativeLayout.LEFT_OF, currentPicture.getId());
                nameTextView.setTextAppearance(viewRoot.getContext(), android.R.style.TextAppearance_Medium);

                currentRelativeLayout.addView(nameTextView, nameTextViewParams);

                TextView descriptionTextView = new TextView(viewRoot.getContext());
                descriptionTextView.setId(View.generateViewId());
                descriptionTextView.setText(currentTourGuide.getDescription());
                RelativeLayout.LayoutParams descriptionTextViewParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                descriptionTextViewParams.addRule(RelativeLayout.BELOW, nameTextView.getId());
                descriptionTextViewParams.addRule(RelativeLayout.ALIGN_RIGHT, nameTextView.getId());
                descriptionTextViewParams.addRule(RelativeLayout.ALIGN_LEFT, nameTextView.getId());
                descriptionTextViewParams.addRule(RelativeLayout.ALIGN_BOTTOM, currentPicture.getId());
                descriptionTextView.setTextAppearance(viewRoot.getContext(), android.R.style.TextAppearance_Small);

                currentRelativeLayout.addView(descriptionTextView, descriptionTextViewParams);

                currentRelativeLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast tourGuideToast = Toast.makeText(v.getContext(), "You have clicked on Tour Guide " + nameTextView.getText(), Toast.LENGTH_SHORT);
                        tourGuideToast.show();

                        /*
                        View newView = (View) viewRoot.getParent();

                        newView.inflate(newView.getContext(), R.layout.empty_activity_layout, (ViewGroup) newView.getParent());
                        */

                        fr = new EmptyActivity();
                        fm = getFragmentManager();
                        fragmentTransaction = fm.beginTransaction();
                        fragmentTransaction.replace(viewRoot.getId(), fr);
                        fragmentTransaction.commit();
                    }
                });

                mainLayout.addView(currentRelativeLayout);

            } while (query.moveToNext());
        } else {
            Toast.makeText(viewRoot.getContext(), "Error retrieving data", Toast.LENGTH_LONG).show();
        }

        toursDB.close();

        return viewRoot;
    }

    private int convertToDP(View currentView, int pixels) {
        float scale = currentView.getContext().getResources().getDisplayMetrics().density;

        return (int) (pixels * scale + 0.5f);
    }
}

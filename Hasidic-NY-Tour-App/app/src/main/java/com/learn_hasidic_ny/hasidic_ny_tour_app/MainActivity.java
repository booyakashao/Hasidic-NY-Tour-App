package com.learn_hasidic_ny.hasidic_ny_tour_app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;


public class MainActivity extends FragmentActivity {

    private FragmentTabHost tabbedNavigationControl;

    private final String toursTabTitle = "Tours";
    private final String poiTabTitle = "POI";
    private final String musicTabTitle = "Music";
    private final String moreTabTitle = "More...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Importing FragmentTabHost from layout
        tabbedNavigationControl = (FragmentTabHost) findViewById(R.id.tabbedNavigationControl);

        tabbedNavigationControl.setup(this, this.getSupportFragmentManager(), android.R.id.tabcontent);

        //==============Linear and lazy addition of tab spec=================
        TabHost.TabSpec localTabSpec = tabbedNavigationControl.newTabSpec("Tours_Tab");
        localTabSpec.setIndicator(toursTabTitle, null);
        Intent toursIntent = new Intent(this, ToursActivity.class);
        tabbedNavigationControl.addTab(localTabSpec, ToursActivity.class, null);

        localTabSpec = tabbedNavigationControl.newTabSpec("POI_Tab");
        localTabSpec.setIndicator(poiTabTitle, null);
        Intent poiIntent = new Intent(this, POIActivity.class);
        tabbedNavigationControl.addTab(localTabSpec, POIActivity.class, null);

        localTabSpec = tabbedNavigationControl.newTabSpec("Music_Tab");
        localTabSpec.setIndicator(musicTabTitle, null);
        Intent musicIntent = new Intent(this, MusicActivity.class);
        tabbedNavigationControl.addTab(localTabSpec, MusicActivity.class, null);

        localTabSpec = tabbedNavigationControl.newTabSpec("More_Tab");
        localTabSpec.setIndicator(moreTabTitle, null);
        Intent moreIntent = new Intent(this, MoreActivity.class);
        tabbedNavigationControl.addTab(localTabSpec, MoreActivity.class, null);
        //===================================================================


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

package com.learn_hasidic_ny.hasidic_ny_tour_app;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;


public class MainActivity extends Activity {

    TabHost tabbedNavigationControl;

    private final String toursTabTitle = "Tours";
    private final String poiTabTitle = "POI";
    private final String musicTabTitle = "Music";
    private final String moreTabTitle = "More...";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Importing TabHost from layout
        tabbedNavigationControl = (TabHost) findViewById(R.id.tabbedNavigationControl);

        tabbedNavigationControl.setup();

        //==============Linear and lazy addition of tab spec=================
        TabHost.TabSpec localTabSpec = tabbedNavigationControl.newTabSpec("Tours");
        localTabSpec.setContent(R.id.toursTab);
        localTabSpec.setIndicator(toursTabTitle);
        tabbedNavigationControl.addTab(localTabSpec);

        localTabSpec = tabbedNavigationControl.newTabSpec(poiTabTitle);
        localTabSpec.setContent(R.id.poiTab);
        localTabSpec.setIndicator(poiTabTitle);
        tabbedNavigationControl.addTab(localTabSpec);

        localTabSpec = tabbedNavigationControl.newTabSpec(musicTabTitle);
        localTabSpec.setContent(R.id.musicTab);
        localTabSpec.setIndicator(musicTabTitle);
        tabbedNavigationControl.addTab(localTabSpec);

        localTabSpec = tabbedNavigationControl.newTabSpec(moreTabTitle);
        localTabSpec.setContent(R.id.moreTab);
        localTabSpec.setIndicator(moreTabTitle);
        tabbedNavigationControl.addTab(localTabSpec);
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

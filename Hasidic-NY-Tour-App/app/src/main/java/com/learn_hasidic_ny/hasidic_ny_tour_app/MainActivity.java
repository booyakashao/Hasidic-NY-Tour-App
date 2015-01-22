package com.learn_hasidic_ny.hasidic_ny_tour_app;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.Toast;

import static android.widget.Toast.makeText;

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
        tabbedNavigationControl.addTab(localTabSpec, ToursActivity.class, null);

        localTabSpec = tabbedNavigationControl.newTabSpec("POI_Tab");
        localTabSpec.setIndicator(poiTabTitle, null);
        tabbedNavigationControl.addTab(localTabSpec, POIActivity.class, null);

        localTabSpec = tabbedNavigationControl.newTabSpec("Music_Tab");
        localTabSpec.setIndicator(musicTabTitle, null);
        tabbedNavigationControl.addTab(localTabSpec, MusicActivity.class, null);

        localTabSpec = tabbedNavigationControl.newTabSpec("More_Tab");
        localTabSpec.setIndicator(moreTabTitle, null);
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
            Toast toast = makeText(this, "You have selected an action setting", Toast.LENGTH_LONG);
            toast.show();
            return true;
        }

        if (id == R.id.fillDB) {
            Toast toast = makeText(this, "Populated DB", Toast.LENGTH_LONG);
            toast.show();

            SQLiteDatabase toursDB = getBaseContext().openOrCreateDatabase("toursDB.db", MODE_PRIVATE, null);

            toursDB.execSQL("CREATE TABLE tourGuides (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "first_name TEXT, " +
                    "last_name TEXT," +
                    "email TEXT," +
                    "description BLOB);");
            toursDB.execSQL("INSERT INTO tourGuides (first_name, last_name, email, description) values(" +
                    "'Frieda'," +
                    "'Vizel'," +
                    "'Frieda.Vizel@HasidicWilliamsburgTour.com'," +
                    "'This is where the description for Frieda would go.');");
            toursDB.execSQL("INSERT INTO tourGuides (first_name, last_name, email, description) values(" +
                    "'Jacob'," +
                    "'Gluck'," +
                    "'Jacob@HasidicWilliamsburgTour.com'," +
                    "'This is where the description for jacob would go.');");
            toursDB.execSQL("INSERT INTO tourGuides (first_name, last_name, email, description) values(" +
                    "'Faigy'," +
                    "'Mayer'," +
                    "'faigy.mayer@mayer.com'," +
                    "'This is where the description would go." +
                    "Filler Text. Filler Text. Filler Text. Filler Text." +
                    "Filler Text. Filler Text. Filler Text. Filler Text.');");
            toursDB.close();
            return true;
        }
        if (id == R.id.clearDB) {
            SQLiteDatabase toursDB = getBaseContext().openOrCreateDatabase("toursDB.db", MODE_PRIVATE, null);
            toursDB.execSQL("DROP TABLE tourGuides;");
            toursDB.close();
        }

        return super.onOptionsItemSelected(item);
    }
}

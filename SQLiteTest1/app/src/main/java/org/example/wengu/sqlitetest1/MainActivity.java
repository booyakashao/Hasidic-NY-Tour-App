package org.example.wengu.sqlitetest1;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SQLiteDatabase sqliteDatabase = getBaseContext().openOrCreateDatabase("sqlite-test-1.db", MODE_PRIVATE, null);
        sqliteDatabase.execSQL("DROP TABLE contacts;");
        sqliteDatabase.execSQL("CREATE TABLE contacts(name TEXT, phone INTEGER, email TEXT);");
        sqliteDatabase.execSQL("INSERT INTO contacts VALUES('Wen', 123456,'wen@ownits.com');");
        sqliteDatabase.execSQL("INSERT INTO contacts VALUES('Fred', 12345,'fred@nurk.com');");

        Cursor query = sqliteDatabase.rawQuery("SELECT * FROM contacts", null);
        if(query.moveToFirst()) {
            do {
                // Cycle through all records
                String name = query.getString(0);
                int phone = query.getInt(1);
                String email = query.getString(2);
                Toast.makeText(getBaseContext(), "Name = " + name + " phone = " + phone + " email = " + email, Toast.LENGTH_LONG).show();
            } while (query.moveToNext());
        } else {
            Toast.makeText(getBaseContext(), "Error retrieving data", Toast.LENGTH_LONG).show();
        }
        sqliteDatabase.close();
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

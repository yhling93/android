package com.yhling.adam.actionbar_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * Created by adam on 9/25/16.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("111");
        toolbar.setSubtitle("SubTitleBar");
        toolbar.setNavigationIcon(R.drawable.ic_actionbar_back);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        //ab.setDisplayShowHomeEnabled(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "[onDestroy]");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_actionbar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast.makeText(this, "You just clicked home!\n" +
                    "The view id is : " + String.valueOf(item.getItemId()) + "\n" +
                    "The view title is : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "You just clicked : " + item.getTitle(), Toast.LENGTH_SHORT).show();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {

    }
}

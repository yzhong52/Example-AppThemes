package com.example.example_appthemes;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Update theme of application
        SharedPreferences manager = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = manager.getString("ThemePreference", "red");
        if (theme.equals("red")) {
            this.setTheme(R.style.AppTheme2);
        } else {
            this.setTheme(R.style.AppTheme);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void onThemeSelected(View view) {
        SharedPreferences manager = PreferenceManager.getDefaultSharedPreferences(this);
        switch (view.getId()) {
            case R.id.pink_theme_btn:
                manager.edit().putString("ThemePreference", "red").apply();

                break;
            case R.id.blue_theme_btn:
                manager.edit().putString("ThemePreference", "blue").apply();

                break;
            default:
                break;
        }

        super.recreate();
    }
}

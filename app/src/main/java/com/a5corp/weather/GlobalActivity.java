package com.a5corp.weather;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class GlobalActivity extends Activity {

    static CityPreference cp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_global);
        Log.i("Loaded" , "Global");
    }

    @Override
    protected void onResume() {
        cp = new CityPreference(this);
        super.onResume();

        if (!cp.prefs.getBoolean("first" , true)) {
            Intent intent = new Intent(GlobalActivity.this, WeatherActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            Log.i("Loaded" , "Weather");
            startActivity(intent);
        }
        else {
            cp.prefs.edit().putBoolean("first" , false);
            Intent intent = new Intent(GlobalActivity.this, FirstLaunch.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            Log.i("Loaded" , "First");
            startActivity(intent);
        }
    }
}

package ua.pack.bonvitess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class AppSettingsActivity extends AppCompatActivity {
    private static String APP_PREFS = "switch_prefs";
    private static String SWITCH_STATUS = "switch_status";

    boolean switch_status;
    public static SharedPreferences appSharedPreferences;
    public static SharedPreferences.Editor editor;
    public Switch toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);
        toggle = findViewById(R.id.switch1);
        appSharedPreferences = getSharedPreferences(APP_PREFS,MODE_PRIVATE);
        editor = getSharedPreferences(APP_PREFS,MODE_PRIVATE).edit();
        switch_status = appSharedPreferences.getBoolean(SWITCH_STATUS,false);
        toggle.setChecked(switch_status);

        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (toggle.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor.putBoolean(SWITCH_STATUS,true);
                    editor.apply();
                    toggle.setChecked(true);
                }
                else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor.putBoolean(SWITCH_STATUS,false);
                    editor.apply();
                    toggle.setChecked(false);
                }
            }
        });

    }
    public void mOnViewClick(View view) {
        Intent viewClick = new Intent(this, aboutUs.class);
        startActivity(viewClick);

    }
    public boolean sendBoolean() {
        return toggle.isChecked();
    }

}
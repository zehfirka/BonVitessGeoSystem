package ua.pack.bonvitess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class AppSettingsActivity extends AppCompatActivity {

    //оголошення змінних
    private static final String APP_PREFS = "switch_prefs";
    private static final String SWITCH_STATUS = "switch_status";

    boolean switch_status;
    public static SharedPreferences appSharedPreferences;
    public static SharedPreferences.Editor editor;
    public Switch toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);
        //ініціалізація змінних
        toggle = findViewById(R.id.switch1);
        appSharedPreferences = getSharedPreferences(APP_PREFS,MODE_PRIVATE);
        editor = getSharedPreferences(APP_PREFS,MODE_PRIVATE).edit();
        switch_status = appSharedPreferences.getBoolean(SWITCH_STATUS,false);
        toggle.setChecked(switch_status);

        //перевірка стану перемикача кольорової теми

        toggle.setOnCheckedChangeListener((compoundButton, b) -> {
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
        });

    }

    //обробка натискання на картку з інформацією про розробників
    public void mOnInformationViewClick(View view) {
        Intent informationViewClick = new Intent(this, aboutUsActivity.class);
        startActivity(informationViewClick);
    }

}
package ua.pack.bonvitess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AppSettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_settings);
        RadioGroup settingsRadio = findViewById(R.id.settingsRadioGroup);
        RadioButton settingsRadioOne = findViewById(R.id.settingsRadio);
        RadioButton settingsRadioTwo = findViewById(R.id.settingsRadio2);
        RadioButton settingsRadioThree = findViewById(R.id.settingsRadio3);

        settingsRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (settingsRadioOne.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                else if (settingsRadioTwo.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                else if (settingsRadioThree.isChecked()) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                }
            }
        });
    }
}
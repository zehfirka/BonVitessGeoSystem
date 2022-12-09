package ua.pack.bonvitess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private AdView mAdView;
    public boolean SwitchState;
    AppSettingsActivity appSettingsActivity = new AppSettingsActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText startEdit = findViewById(R.id.editTextStart);
        EditText finishEdit = findViewById(R.id.editTextFinish);




        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void mOnButtonClick(View view) {
        String key = "AIzaSyD1q8wcNP-qK4XtN2PydpoTuqIxRskE3tM";
        Intent intClick = new Intent(this, DisplayResultActivity.class);
        startActivity(intClick);

    }

    public void OnSettingsButtonClick(View view) {
        Intent intSettings = new Intent(this, AppSettingsActivity.class);
        startActivity(intSettings);

    }
}


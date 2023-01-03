package ua.pack.bonvitess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void OnSettingsActivityClick(View view) {
        Intent intSettings = new Intent(this, AppSettingsActivity.class);
        startActivity(intSettings);
    }

    //обробка натискання на картку інформації про наявні маршрути
    public void OnRouteActivityClick(View view) {
        Intent intRoute = new Intent(this,RoutesActivity.class);
        startActivity(intRoute);
    }

    public void OnMainActivityClick(View view) {
        Intent intMain = new Intent(this, MainActivity.class);
        startActivity(intMain);
    }
}
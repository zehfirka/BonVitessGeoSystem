package ua.pack.bonvitess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.api.Status;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    //оголошення змінних
    public EditText etStartPoint,etFinishPoint;
    public String startPoint, endPoint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ініціалізація обʼєктів EditText - текстові поля
        setContentView(R.layout.activity_main);
        etStartPoint = findViewById(R.id.editTextStart);
        etFinishPoint = findViewById(R.id.editTextFinish);

        //Інціалізація АРІ
        Places.initialize(getApplicationContext(),"AIzaSyD1q8wcNP-qK4XtN2PydpoTuqIxRskE3tM");
        MobileAds.initialize(this, initializationStatus -> {
        });
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Автозаповнення від Google
        etStartPoint.setOnClickListener(view -> {
            List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS,
                    Place.Field.LAT_LNG,Place.Field.NAME);
            Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY
                    ,fieldList).build(MainActivity.this);
            startActivityForResult(intent,100);
        });

        etFinishPoint.setOnClickListener(view -> {
            List<Place.Field> endFieldList = Arrays.asList(Place.Field.ADDRESS,
                    Place.Field.LAT_LNG,Place.Field.NAME);
            Intent endpointIntent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY
                    ,endFieldList).build(MainActivity.this);
            startActivityForResult(endpointIntent,100);
        });
    }

    //обробка запиту Autocomplete Places API

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Place place = Autocomplete.getPlaceFromIntent(data);
            if (etStartPoint.isFocused()) {
                etStartPoint.setText(place.getAddress());
                startPoint = place.getLatLng().toString();
            }
            else if (etFinishPoint.isFocused()) {
                etFinishPoint.setText(place.getAddress());
                endPoint = place.getLatLng().toString();
            }
            //обробка помилки зі сторони серверної частини
        } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
            Status status = Autocomplete.getStatusFromIntent(data);
            Toast.makeText(getApplicationContext(),status.getStatusMessage(),Toast.LENGTH_SHORT).show();
        }
    }

    //Обробка натискання на кнопку пошуку

    public void mOnButtonClick(View view) {
        startPoint = etStartPoint.getText().toString();
        endPoint = etFinishPoint.getText().toString();

        //перевірка на пусті вхідні значення
        if (startPoint.isEmpty()) {
            Toast.makeText(MainActivity.this,"Введіть початкову точку",Toast.LENGTH_SHORT).show();
        } else if (endPoint.isEmpty()) {
            Toast.makeText(MainActivity.this,"Введіть кінцеву точку",Toast.LENGTH_SHORT).show();
        } else {
            //відкриваємо нове вікно Activity
            Intent intClick = new Intent(this,MapsActivity.class);
            intClick.putExtra("startA", startPoint);
            intClick.putExtra("startB",endPoint);
            startActivity(intClick);
        }

    }

    //Обробка натискання на кнопку налаштувань

    public void OnSettingsButtonClick(View view) {
        Intent intSettings = new Intent(this, AppSettingsActivity.class);
        startActivity(intSettings);

    }
}


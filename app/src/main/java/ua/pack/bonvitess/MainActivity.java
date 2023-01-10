package ua.pack.bonvitess;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.AutocompleteActivity;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class MainActivity extends AppCompatActivity {
    //оголошення змінних
    public EditText etStartPoint, etFinishPoint;
    public String startPoint, endPoint, currentLocation;
    public LatLng startLatLng, endLatLng;
    public double lat, lng;
    FusedLocationProviderClient client;
    ImageButton locationButtonStart, locationButtonFinish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Ініціалізація обʼєктів EditText - текстові поля
        setContentView(R.layout.activity_main);
        etStartPoint = findViewById(R.id.editTextStart);
        etFinishPoint = findViewById(R.id.editTextFinish);
        locationButtonStart = findViewById(R.id.locationButtonStart);
        locationButtonFinish = findViewById(R.id.locationButtonFinish);


        //Інціалізація АРІ
        Places.initialize(getApplicationContext(), "AIzaSyD1q8wcNP-qK4XtN2PydpoTuqIxRskE3tM");
        MobileAds.initialize(this, initializationStatus -> {
        });
        client = LocationServices.getFusedLocationProviderClient(this);
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //ініціалізація сервісів геолокації

        //перевірка наявності дозволу
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
        } else {
            askPermission(); //отримання дозволю
        }

        //контролюємо натискання кнопок геолокації
        locationButtonStart.setOnClickListener(v -> {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                getLocation();
                etStartPoint.setText(currentLocation);
                startLatLng = new LatLng(lat,lng);

            }

        });

        locationButtonFinish.setOnClickListener(v -> {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                getLocation();
                etFinishPoint.setText(currentLocation);
                endLatLng = new LatLng(lat,lng);
            }
        });

        //Автозаповнення від Google
        etStartPoint.setOnClickListener(view -> {
            List<Place.Field> fieldList = Arrays.asList(Place.Field.ADDRESS,
                    Place.Field.LAT_LNG, Place.Field.NAME);
            Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY
                    , fieldList).build(MainActivity.this);
            startActivityForResult(intent, 100);
        });

        etFinishPoint.setOnClickListener(view -> {
            List<Place.Field> endFieldList = Arrays.asList(Place.Field.ADDRESS,
                    Place.Field.LAT_LNG, Place.Field.NAME);
            Intent endpointIntent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.OVERLAY
                    , endFieldList).build(MainActivity.this);
            startActivityForResult(endpointIntent, 100);
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
                startLatLng = place.getLatLng();

            } else if (etFinishPoint.isFocused()) {
                etFinishPoint.setText(place.getAddress());
                endPoint = place.getLatLng().toString();
                endLatLng = place.getLatLng();
            }
            //обробка помилки зі сторони серверної частини
        } else if (resultCode == AutocompleteActivity.RESULT_ERROR) {
            Status status = Autocomplete.getStatusFromIntent(data);
            Toast.makeText(getApplicationContext(), status.getStatusMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    //Обробка натискання на кнопку пошуку

    public void mOnButtonClick(View view) {
        startPoint = etStartPoint.getText().toString();
        endPoint = etFinishPoint.getText().toString();

        //перевірка на пусті вхідні значення
        if (startPoint.isEmpty()) {
            Toast.makeText(MainActivity.this, "Введіть початкову точку", Toast.LENGTH_SHORT).show();
        } else if (endPoint.isEmpty()) {
            Toast.makeText(MainActivity.this, "Введіть кінцеву точку", Toast.LENGTH_SHORT).show();
        } else if (startPoint.equals(endPoint)) {
            Toast.makeText(MainActivity.this, "Так не можна, точки маршруту мають бути різними", Toast.LENGTH_SHORT).show();
        } else {
            //відкриваємо нове вікно Activity
            Intent intClick = new Intent(this, MapsActivity.class);
            Bundle latlngs = new Bundle();
            latlngs.putParcelable("start_position",startLatLng);
            latlngs.putParcelable("end_position",endLatLng);
            intClick.putExtra("bundle", latlngs);
            intClick.putExtra("startA", startPoint);
            intClick.putExtra("startB", endPoint);
            startActivity(intClick);
        }

    }

    //Обробка натискання на кнопку налаштувань

    public void onMenuButtonClick(View view) {
        Intent intMenu = new Intent(this, MenuActivity.class);
        startActivity(intMenu);
    }

    //отримуємо геолокацію
    public void getLocation() {
        //перевірка наявності дозволу
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            //обробка даних при успішному запиті
            client.getLastLocation().addOnSuccessListener(location -> {
                //перевірка на пусте значення
                if (location != null) {
                    lat = location.getLatitude();
                    lng = location.getLongitude();


                    //зворотнє геокодування відповіді від АРІ
                    Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                    try {
                        List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),location.getLongitude(),1);
                        currentLocation = addresses.get(0).getAddressLine(0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            //запитуємо дозвіл якщо його немає
        } else askPermission();


    }
    public void askPermission() {
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},1);
    }

    //обробка відповіді користувача на запит про отримання дозволу
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLocation();
            } else {
                Toast.makeText(MainActivity.this,"Потрібен дозвіл на отримання геолокації",Toast.LENGTH_SHORT).show();
            }
        }
    }
}


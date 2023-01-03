package ua.pack.bonvitess;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ua.pack.bonvitess.databinding.ActivityMapsBinding;
import ua.pack.bonvitess.parceUtility.DirectionResponse;
import ua.pack.bonvitess.parceUtility.MapService;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    //оголошення змінних
    private GoogleMap mMap;
    public String startPoint,endPoint;
    public TextView floatingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Коректна робота Google Map
        ua.pack.bonvitess.databinding.ActivityMapsBinding binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        floatingText = findViewById(R.id.floatingTextView);

        //отримання даних з MainActivity
        Intent intent = getIntent();
        startPoint = intent.getStringExtra("startA");
        endPoint = intent.getStringExtra("startB");
        floatingText.setText(startPoint + " - " + endPoint);

        // Ініціалізуємо SupportFragment та повідомляємо про готовність роботи
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;

        //створюємо обʼєкт Retrofit для відправки запиту
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://maps.googleapis.com/maps/api/directions/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MapService service = retrofit.create(MapService.class);

        //Відправка запиту
        Call<DirectionResponse> directionResponseCall = service.getDirection(startPoint, endPoint, "transit", getString(R.string.google_maps_api_key));
        directionResponseCall.enqueue(new Callback<DirectionResponse>() {
            @Override
            //метод обробки якщо відправка запиту успішна
            public void onResponse(Call<DirectionResponse> call, Response<DirectionResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    //зберігаємо інформацію
                    DirectionResponse directionResponse = response.body();

                    // Малюємо маршрут на карті за допомогою PolylineOptions
                    List<LatLng> route = PolyUtil.decode(directionResponse.getRoutes().get(0).getOverviewPolyline().getPoints());
                    mMap.addPolyline(new PolylineOptions().addAll(route).color(Color.RED));

                    //позиціонуємо камеру
                    LatLngBounds polylineBounds = getRouteBounds(route);
                    mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(polylineBounds,15));

                } else {
                    // якщо відправка запиту успішна, але відповідь незадовільна
                    Toast.makeText(MapsActivity.this, "Помилка при отриманні маршруту", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            //метод обробки якщо відправка запиту неуспішна
            public void onFailure(Call<DirectionResponse> call, Throwable t) {
                Toast.makeText(MapsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //отримуємо координати точок полілінії для позиціонування камери
    private LatLngBounds getRouteBounds(List<LatLng> route) {
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        for (LatLng latLng : route) {
            builder.include(latLng);
        }
        return builder.build();
    }

}

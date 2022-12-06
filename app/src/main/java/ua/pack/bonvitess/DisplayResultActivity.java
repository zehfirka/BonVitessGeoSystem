package ua.pack.bonvitess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class DisplayResultActivity extends AppCompatActivity {
    private List<RecycleHolder> holders;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        recyclerView = (RecyclerView) findViewById(R.id.resultView);
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(llm);

        InitialiseData();
        InitializeAdapter();


    }
    public void onReturnClick(View view) {
        Intent returnClick = new Intent(this, MainActivity.class);
        startActivity(returnClick);
    }

    private void InitialiseData() {
        holders = new ArrayList<>();
        holders.add(new RecycleHolder("Вулиця Жилянська", "14:30", "Пройдіть 200 метрів до зупинки 'НСК Олімпійський'"));
        holders.add(new RecycleHolder("Автобус №69", "14:45", "Проїдьте 3 зупинки"));
        holders.add(new RecycleHolder("Київ Пасажирський", "15:05", "Пройдіть 150 метрів до станції метро 'Вокзальна'"));
        holders.add(new RecycleHolder("метро Політехнічний Інститут", "15.13", "Проїдьте одну станцію"));
        holders.add(new RecycleHolder("Тестова точка 1","15:15","Поверніть праворуч"));
        holders.add(new RecycleHolder("Тестова точка 2","15:20","Сядьте на автобус"));
        holders.add(new RecycleHolder("Тестова точка 3","15:25","Йдіть прямо"));
        holders.add(new RecycleHolder("Тестова точка 4","15:35","Розверніться"));
        holders.add(new RecycleHolder("Тестова точка 5","15:50","Поверніть ліворуч"));
        holders.add(new RecycleHolder("Тестова точка 6","16:10","проїдьте 5 зупинок"));
        holders.add(new RecycleHolder("Тестова точка 7","16:25","Йдіть 300 метрів"));
        holders.add(new RecycleHolder("Тестова точка 8","16:50","Поверніть ліворуч"));
    }
    private void InitializeAdapter(){
        ResultAdapter resultAdapter = new ResultAdapter(holders);
        recyclerView.setAdapter(resultAdapter);
    }
}
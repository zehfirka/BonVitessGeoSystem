package ua.pack.bonvitess;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayResultActivity extends AppCompatActivity {
    private List<Root> rootList = new ArrayList<>(); //підвʼязано до окремого класу
    private RecyclerView recyclerView;
    ResultAdapter resultAdapter; //адаптер до ресуклера

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        recyclerView = (RecyclerView) findViewById(R.id.resultView);
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(llm);
        resultAdapter = new ResultAdapter(rootList);
        recyclerView.setAdapter(resultAdapter); //підключення адаптера

        fetchHolders(); //ця штука відправляє запит апі



    }
    public void onReturnClick(View view) {
        Intent returnClick = new Intent(this, MainActivity.class);
        startActivity(returnClick);
    }

    private void fetchHolders(){ //тут воно посилається на клас RetrofitClient і бере в callback ліст
        RetrofitClient.getRetrofitClient().getRoutes().enqueue(new Callback<List<Root>>() {
            @Override
            public void onResponse(Call<List<Root>> call, Response<List<Root>> response) {
                if (response.isSuccessful() && response.body() != null) { //тут перевірка на успішність запиту
                    rootList.addAll(response.body());
                    resultAdapter.notifyDataSetChanged(); //адаптер отримує інфу що щось змінилось
                }
            }

            @Override
            public void onFailure(Call<List<Root>> call, Throwable t) {
                Toast.makeText(DisplayResultActivity.this, "Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}
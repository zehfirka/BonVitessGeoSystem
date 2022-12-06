package ua.pack.bonvitess;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DisplayResultActivity extends AppCompatActivity {
    private List<routes> routesList = new ArrayList<>();
    private RecyclerView recyclerView;
    ResultAdapter resultAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_result);
        recyclerView = (RecyclerView) findViewById(R.id.resultView);
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(llm);
        resultAdapter = new ResultAdapter(routesList);
        recyclerView.setAdapter(resultAdapter);

        fetchHolders();



    }
    public void onReturnClick(View view) {
        Intent returnClick = new Intent(this, MainActivity.class);
        startActivity(returnClick);
    }

    private void fetchHolders(){
        RetrofitClient.getRetrofitClient().getRoutes().enqueue(new Callback<List<routes>>() {
            @Override
            public void onResponse(Call<List<routes>> call, Response<List<routes>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    routesList.addAll(response.body());
                    resultAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<routes>> call, Throwable t) {
                Toast.makeText(DisplayResultActivity.this, "Error: "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}
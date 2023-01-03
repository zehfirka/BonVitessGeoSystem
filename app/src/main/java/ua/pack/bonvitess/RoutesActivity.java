package ua.pack.bonvitess;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ua.pack.bonvitess.adapterUtility.BusListAdapter;
import ua.pack.bonvitess.adapterUtility.Buses;

public class RoutesActivity extends AppCompatActivity {

    //оголошення змінних
    final ArrayList<Buses> busesList = new ArrayList<>();
    public RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        //метод ініціалізації даних для RecyclerView
        setData();

        //Ініціалізація RecyclerView, Adapter та LayoutManager
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(getBaseContext());
        recyclerView.setLayoutManager(llm);
        BusListAdapter busListAdapter = new BusListAdapter(this, busesList);
        recyclerView.setAdapter(busListAdapter);

    }

    private void setData() {
        busesList.add(new Buses("Автобус 1","ЗАЛІЗНИЧНИЙ ВОКЗАЛ - РАЙЛІКАРНЯ", "12 грн.","10.26 км","раз на 40 хв"));
        busesList.add(new Buses("Автобус 1А","ВУЛ. ВИГОВСЬКОГО - РАЙЛІКАРНЯ", "12 грн.","12.41 км"," кожні 15 хв"));
        busesList.add(new Buses("Автобус 1Б","ЕНЕРГОНАГЛЯД - РАЙЛІКАРНЯ", "12 грн.","11.74 км","кожні 10 хв"));
        busesList.add(new Buses("Автобус 4","ВУЛ. КОМАРОВА - ВУЛ. ВОЛКОВА", "12 грн.","6.96 км","кожні 25 хв"));
        busesList.add(new Buses("Автобус 5","М/Н НОВА УМАНЬ - ЗАВОД \"ЗБВ\"", "12 грн.","11.56 км","кожні 40 хв"));
        busesList.add(new Buses("Автобус 7","АЕРОПОРТ - ЗАРЕМБОВА ГРЕБЛЯ - РИНОК", "12 грн.","5.69 км","кожні 20 хв"));
        busesList.add(new Buses("Автобус 8","ЦЕНТРАЛЬНИЙ РИНОК - ГРС", "12 грн.","7.87 км","кожні 17 хв"));
        busesList.add(new Buses("Автобус 9","РАЙЛІКАРНЯ - ЗАВОД \"ЗБВ\"", "12 грн.","11.85 км","кожні 10 хв"));
        busesList.add(new Buses("Автобус 14","РАЙЛІКАРНЯ - ПАТ \"УМАНСЬКЕ АТП-7155\"", "12 грн.","10.88 км","кожні 5 хв"));
        busesList.add(new Buses("Автобус 15","АЛІЗНИЧНИЙ ВОКЗАЛ - ДАЧІ", "12 грн.","6.96 км","раз на 40 хв"));
        busesList.add(new Buses("Автобус 17","ШКОЛА №6 - ШКОЛА №5", "12 грн.","8.69 км","кожні 20 хв"));
        busesList.add(new Buses("Автобус 18","С. РОДИНИКІВКА - М/Н НОВА УМАНЬ'", "12 грн.","11.22 км","кожні 25 хв"));
        busesList.add(new Buses("Автобус 21","ВУЛ. ВОЛКОВА - ДП \"ГАЗОВИК\"", "12 грн.","5.63 км","раз на 40 хв"));
        busesList.add(new Buses("Автобус 24","ЦЕНТРАЛЬНИЙ РИНОК - С. ПОЛЯНЕЦЬКЕ", "12 грн.","10.07 км","від 40 до 80 хв"));
    }
}
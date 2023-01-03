package ua.pack.bonvitess.adapterUtility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ua.pack.bonvitess.R;

//адаптер для роботи RecyclerView

public class BusListAdapter extends RecyclerView.Adapter<BusListAdapter.ViewHolder> {

    //оголошення змінної
    private final List<Buses> busesList;

    //конструктор
    public BusListAdapter(Context context, List<Buses> busesList) {
        this.busesList = busesList;
    }

    //ініціалізуємо TextView для роботи кожного елементу списку
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView busNumber, busRoute,busFee,busDistance,busInterval;
        ViewHolder(View view) {
            super(view);
            busNumber = view.findViewById(R.id.busnumber_text);
            busRoute = view.findViewById(R.id.route_text);
            busFee = view.findViewById(R.id.fee_text);
            busDistance = view.findViewById(R.id.distance_text);
            busInterval = view.findViewById(R.id.interval_text);

        }
    }

    //налаштовуємо LayoutInflater
    @NonNull
    @Override
    public BusListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.result_holder,parent,false);
        return new ViewHolder(view);
    }

    //Додаємо текстові значення з обʼєктів класу до відповідних TextView елементу списку
    @Override
    public void onBindViewHolder(@NonNull BusListAdapter.ViewHolder holder, int position) {
        Buses buses = busesList.get(position);
        holder.busNumber.setText(buses.getNumber());
        holder.busRoute.setText(buses.getDestinationRoute());
        holder.busFee.setText("Ціна квитка: " + buses.getFee());
        holder.busDistance.setText("Довжина маршруту: " + buses.getDistance());
        holder.busInterval.setText("Інтервал руху: " + buses.getInterval());


    }

    //Отримуємо розмір списку
    @Override
    public int getItemCount() {
        return busesList.size();
    }
}

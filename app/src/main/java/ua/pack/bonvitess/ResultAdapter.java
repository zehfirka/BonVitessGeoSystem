package ua.pack.bonvitess;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.HintViewHolder> {
    List<Root> rootList; //знову ліст
    public Step step;
    public Leg leg;

    public ResultAdapter(List<Root> rootList) {
        this.rootList = rootList; //по логіці це конструктор
    }

    public static class HintViewHolder extends RecyclerView.ViewHolder {
        TextView timeText;
        TextView hintText;
        HintViewHolder(View itemView) { //тут ми шукаємо текстові лейбли куди вставляється отриманий текст
            super(itemView);
            timeText = (TextView) itemView.findViewById(R.id.timeText);
            hintText = (TextView) itemView.findViewById(R.id.hintText);

        }
    }

    @Override
    public HintViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.result_holder, viewGroup, false);
        HintViewHolder hintViewHolder = new HintViewHolder(v); //тут ініціалізація холдера - одного елементу списку
        return hintViewHolder;
    }

    @Override
    public void onBindViewHolder( HintViewHolder holder, int i) { //ось оця штука вставляє отримані дані в текстВью
        holder.timeText.setText(leg.getDuration().toString());
        holder.hintText.setText(step.getHTMLInstructions());
    }

    @Override
    public int getItemCount() {
        return rootList.size(); //практичної користі немає
    }


}


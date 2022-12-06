package ua.pack.bonvitess;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.HintViewHolder> {
    public static class HintViewHolder extends RecyclerView.ViewHolder {
        TextView routeText;
        TextView timeText;
        TextView hintText;
        HintViewHolder(View itemView) {
            super(itemView);
            routeText = (TextView) itemView.findViewById(R.id.stepText);
            timeText = (TextView) itemView.findViewById(R.id.timeText);
            hintText = (TextView) itemView.findViewById(R.id.hintText);

        }
    }
    List<RecycleHolder> holders;
    ResultAdapter(List<RecycleHolder> holders){
        this.holders = holders;
    }
    @Override
    public HintViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.result_holder, viewGroup, false);
        HintViewHolder hintViewHolder = new HintViewHolder(v);
        return hintViewHolder;
    }

    @Override
    public void onBindViewHolder( HintViewHolder holder, int i) {
        holder.routeText.setText(holders.get(i).route);
        holder.timeText.setText(holders.get(i).time);
        holder.hintText.setText(holders.get(i).hints);
    }

    @Override
    public int getItemCount() {
        return holders.size();
    }


}


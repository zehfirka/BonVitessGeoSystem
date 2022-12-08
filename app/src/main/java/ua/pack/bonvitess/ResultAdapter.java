package ua.pack.bonvitess;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.HintViewHolder> {
    List<routes> routesList;

    public ResultAdapter(List<routes> routesList) {
        this.routesList = routesList;
    }

    public static class HintViewHolder extends RecyclerView.ViewHolder {
        TextView timeText;
        TextView hintText;
        HintViewHolder(View itemView) {
            super(itemView);
            timeText = (TextView) itemView.findViewById(R.id.timeText);
            hintText = (TextView) itemView.findViewById(R.id.hintText);

        }
    }

    @Override
    public HintViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.result_holder, viewGroup, false);
        HintViewHolder hintViewHolder = new HintViewHolder(v);
        return hintViewHolder;
    }

    @Override
    public void onBindViewHolder( HintViewHolder holder, int i) {
        holder.timeText.setText(routesList.get(i).getTitle());
        holder.hintText.setText(routesList.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return routesList.size();
    }


}


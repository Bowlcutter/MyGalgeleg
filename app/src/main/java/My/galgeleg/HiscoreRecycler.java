package My.galgeleg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HiscoreRecycler extends RecyclerView.Adapter<HiscoreRecycler.MyViewHolder> {

    ArrayList<String> data1;
    ArrayList<String> data2;

    public HiscoreRecycler(ArrayList s1, ArrayList s2){
        data1 = s1;
        data2 = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.hiscore_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(data1.get(position));
        holder.myText2.setText(data2.get(position));
    }

    @Override
    public int getItemCount() {
        return data2.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.spiller);
            myText2 = itemView.findViewById(R.id.score);
        }
    }
}

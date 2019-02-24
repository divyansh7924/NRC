package info.androidhive.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class CentersAdapter extends RecyclerView.Adapter<CentersAdapter.MyViewHolder> {

    private List<Center> centersList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, dist, add;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            add = (TextView) view.findViewById(R.id.add);
            dist = (TextView) view.findViewById(R.id.dist);
        }
    }


    public CentersAdapter(List<Center> centersList) {
        this.centersList = centersList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.center_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Center center = centersList.get(position);
        holder.title.setText(center.getTitle());
        holder.add.setText(center.getGenre());
        holder.dist.setText(center.getYear());
    }

    @Override
    public int getItemCount() {
        return centersList.size();
    }
}

package com.example.myapplicationnew.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplicationnew.R;

import java.util.List;


public class CustomRecyclerAdapter extends RecyclerView.Adapter<CustomRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<ListofItems> listofItems;

    public CustomRecyclerAdapter(Context context, List listofItems) {
        this.context = context;
        this.listofItems = listofItems;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setTag(listofItems.get(position));

        ListofItems pu = listofItems.get(position);

        holder.id.setText(pu.getId()+" ");
        holder.listId.setText(pu.getListId()+ " ");
        holder.name.setText(pu.getName());


    }

    @Override
    public int getItemCount() {
        return listofItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView id;
        public TextView listId;
        public TextView name;

        public ViewHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            listId = (TextView) itemView.findViewById(R.id.listId);
            name = (TextView) itemView.findViewById(R.id.name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ListofItems cpu = (ListofItems) view.getTag();

                    Toast.makeText(view.getContext(), cpu.getId()+" "+cpu.getListId()+" is "+ cpu.getName(), Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

}
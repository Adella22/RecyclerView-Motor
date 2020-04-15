package com.tugas2.tgs6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class grid_Adapter_motor extends RecyclerView.Adapter<grid_Adapter_motor.GridViewHolder> {
    private ArrayList<motor> listmotor;

    public grid_Adapter_motor(ArrayList<motor> list) {
        this.listmotor = list;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_motor, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(listmotor.get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount() {
        return listmotor.size();
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;

        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }

        private OnItemClickCallback onItemClickCallback;

        public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }


        @Override
        public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickCallback.onItemClicked(list_Adapter_motor.get(holder.getAdapterPosition()));
                }
            });
        }

        public interface OnItemClickCallback {
            void onItemClicked(motor data);
        }

        private void showRecyclerGrid() {
            rvmotor.setLayoutManager(new GridLayoutManager(this, 2));
            grid_Adapter_motor grid_adapter_motor = new grid_Adapter_motor(listmotor);
            rvmotor.setAdapter(grid_adapter_motor);

            grid_adapter_motor.setOnItemClickCallback(new grid_Adapter_motor().OnItemClickCallback()
            {
                @Override
                public void onItemClicked (motor data){
                showRecyclerGrid(data);
            }
            })
        }
    }
}
package com.tugas2.tgs6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class list_Adapter_motor extends RecyclerView.Adapter<list_Adapter_motor.ListViewHolder> {
    private ArrayList<motor> listmotor;

    public list_Adapter_motor(ArrayList<motor> list) {
        this.listmotor = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_motor, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        motor motor = listmotor.get(position);
        Glide.with(holder.itemView.getContext())
                .load(motor.getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvName.setText(motor.getName());
        holder.tvDetail.setText(motor.getDetail());
    }

    @Override
    public int getItemCount() {
        return listmotor.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDetail;

        ListViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
        private OnItemClickCallback onItemClickCallback;
        public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }


        @Override
        public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {

            holder.itemView.setOnClickListener(new View().OnClickListener() {
                @Override
                public void onClick(View ) {
                    onItemClickCallback.onItemClicked(list_Adapter_motor.get(holder.getAdapterPosition()));
                }
            });
        }

        public interface OnItemClickCallback {
            void onItemClicked(motor data);
        }
        private void showRecyclerList() {
            rvmotor.setLayoutManager(new LinearLayoutManager(this));
            list_Adapter_motor listHeroAdapter = new list_Adapter_motor(list);
            rvmotor.setAdapter(listHeroAdapter);

            listHeroAdapter.setOnItemClickCallback(new list_Adapter_motor().OnItemClickCallback() {
                @Override
                public void onItemClicked(motor data) {
                    showSelectedmotor(data);
                }
            });
        }


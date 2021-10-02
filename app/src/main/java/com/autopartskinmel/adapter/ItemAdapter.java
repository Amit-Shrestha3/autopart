package com.autopartskinmel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.autopartskinmel.R;
import com.autopartskinmel.model.Item;
import com.squareup.picasso.Picasso;
import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    Context context;
    private final List<Item> itemList;
    private final OnItemClickListener onItemClickListener;


    public ItemAdapter(Context context, List<Item> itemList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.itemList = itemList;
        this.onItemClickListener = onItemClickListener;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item getPosition = itemList.get(position);

        holder.itemName.setText(getPosition.getItemName());
        holder.itemPrice.setText(getPosition.getItemPrice());
        holder.itemCondition.setText(getPosition.getItemCondition());

        Picasso.get().load(getPosition.getItemImage()).into(holder.itemImage);

    }

    @Override
    public int getItemCount() {
        return itemList==null ? 0 : itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        private final TextView itemName;
        private final TextView itemPrice;
        private final TextView itemCondition;
        private final ImageView itemImage;


        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            itemName = itemView.findViewById(R.id.item_name);
            itemImage = itemView.findViewById(R.id.item_image);
            itemPrice = itemView.findViewById(R.id.item_price);
            itemCondition = itemView.findViewById(R.id.item_condition);

            itemView.setOnClickListener(view -> onItemClickListener.onItemClick(getAdapterPosition()));
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
}

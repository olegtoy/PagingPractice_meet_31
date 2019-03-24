package com.practice.olegtojgildin.paging;

import android.arch.paging.PagedListAdapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class ItemAdapter extends PagedListAdapter<Hit, ItemAdapter.ItemViewHolder> {

    private Context mContext;

    protected ItemAdapter(Context mCtx) {
        super(DIFF_CALLBACK);
        this.mContext = mCtx;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_image, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        Hit item = getItem(position);
        if (item != null) {
            Picasso.get()
                    .load(item.getLargeImageURL())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(holder.imageView);

        } else {
            Toast.makeText(mContext, "Item is null", Toast.LENGTH_LONG).show();
        }
    }


    public static DiffUtil.ItemCallback<Hit> DIFF_CALLBACK =  new DiffUtil.ItemCallback<Hit>() {
        @Override
        public boolean areItemsTheSame(@NonNull Hit oldItem, @NonNull Hit newItem) {
            return oldItem.getWebformatURL().equals(newItem.getWebformatURL());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Hit oldItem, @NonNull Hit newItem) {
            return oldItem.getWebformatURL().equals(newItem.getWebformatURL());
        }
    };


    class ItemViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

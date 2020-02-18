package com.vnext.demomvp.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.vnext.demomvp.R;
import com.vnext.demomvp.model.entity.Category;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<Category> arrayListCategory;

    public CategoryAdapter(Context context, ArrayList<Category> arrayListCategory) {
        this.context = context;
        this.arrayListCategory = arrayListCategory;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.custom_category_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(arrayListCategory.get(position).getImageCategory()).into(holder.img_custom_catelogy_item);
        holder.txt_custom_catelogy_item.setText(arrayListCategory.get(position).getNameCategory());
    }

    @Override
    public int getItemCount() {
        return arrayListCategory.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_custom_catelogy_item)
        TextView txt_custom_catelogy_item;
        @BindView(R.id.img_custom_catelogy_item)
        ImageView img_custom_catelogy_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

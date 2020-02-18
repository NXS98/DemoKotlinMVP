package com.vnext.demomvp.view.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vnext.demomvp.R;
import com.vnext.demomvp.model.entity.Category;
import com.vnext.demomvp.model.interfaces.CategoryContract;
import com.vnext.demomvp.presenter.CategoryPresenter;
import com.vnext.demomvp.view.adapter.CategoryAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StoreActivity extends AppCompatActivity implements CategoryContract.View {
    CategoryPresenter categoryPresenter;
    @BindView(R.id.recyclerview_category)
    RecyclerView recyclerviewCategory;
    GridLayoutManager layoutManager;
    CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        ButterKnife.bind(this);
        categoryPresenter = new CategoryPresenter(this);
        categoryPresenter.loadDataCategory();
    }

    @Override
    public void loadDataCategory(ArrayList<Category> arrCategories) {
        layoutManager = new GridLayoutManager(this,2);
        recyclerviewCategory.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,arrCategories);
        recyclerviewCategory.hasFixedSize();
        recyclerviewCategory.setAdapter(categoryAdapter);
    }
}

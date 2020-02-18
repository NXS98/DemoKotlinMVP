package com.vnext.demomvp.model.interfaces;

import com.vnext.demomvp.model.entity.Category;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface CategoryContract {
    interface View{
        void loadDataCategory(ArrayList<Category> arrCategories);
    }
    interface Presenter{
        void loadDataCategory();
    }
}

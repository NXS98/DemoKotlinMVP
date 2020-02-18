package com.vnext.demomvp.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("ID_Category")
    @Expose
    private String iDCategory;
    @SerializedName("Name_Category")
    @Expose
    private String nameCategory;
    @SerializedName("Image_Category")
    @Expose
    private String imageCategory;
    @SerializedName("Status")
    @Expose
    private String status;

    public String getIDCategory() {
        return iDCategory;
    }

    public void setIDCategory(String iDCategory) {
        this.iDCategory = iDCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(String imageCategory) {
        this.imageCategory = imageCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
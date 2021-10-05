package com.example.procurementapp.models;

public class SupplierModel {

    //declare variables
    String sup_id;
    String sup_name;
    String sup_location;
    String sup_mob;
    String img_url;

    //Create getters and setters
    public String getSup_id() {
        return sup_id;
    }

    public void setSup_id(String sup_id) {
        this.sup_id = sup_id;
    }

    public String getSup_name() {
        return sup_name;
    }

    public void setSup_name(String sup_name) {
        this.sup_name = sup_name;
    }

    public String getSup_location() {
        return sup_location;
    }

    public void setSup_location(String sup_location) {
        this.sup_location = sup_location;
    }

    public String getSup_mob() {
        return sup_mob;
    }

    public void setSup_mob(String sup_mob) {
        this.sup_mob = sup_mob;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    //Create constructor
    public SupplierModel(String sup_id, String sup_name, String sup_location, String sup_mob, String img_url) {
        this.sup_id = sup_id;
        this.sup_name = sup_name;
        this.sup_location = sup_location;
        this.sup_mob = sup_mob;
        this.img_url = img_url;
    }

    public SupplierModel() {
    }
}

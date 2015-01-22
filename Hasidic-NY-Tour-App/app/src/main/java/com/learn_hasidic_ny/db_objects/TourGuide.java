package com.learn_hasidic_ny.db_objects;

/**
 * Created by wengu on 1/19/15.
 */
public class TourGuide {

    //Label Tables
    public static final String TABLE = "TourGuides";

    public static final String KEY_ID = "id";
    public static final String KEY_first_name = "first_name";
    public static final String KEY_last_name = "last_name";
    public static final String KEY_email = "email";
    public static final String KEY_description = "description";

    // member variables
    private int tour_guide_ID;
    private String first_name;
    private String last_name;
    private String email;
    private String description;

    public int getTour_guide_ID() {
        return tour_guide_ID;
    }

    public void setTour_guide_ID(int tour_guide_ID) {
        this.tour_guide_ID = tour_guide_ID;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

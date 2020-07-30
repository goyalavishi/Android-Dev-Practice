package com.example.avishigoyal.dynamiclist;

import android.graphics.Bitmap;

/**
 * Created by Avishi Goyal on 20-12-2015.
 */
public class ListData {


    String title, discription, time;
    Bitmap image;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

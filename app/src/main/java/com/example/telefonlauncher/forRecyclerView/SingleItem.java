package com.example.telefonlauncher.forRecyclerView;

import android.widget.CheckBox;

public class SingleItem {


    private String mainText;
    private int backgroundColor;

    public SingleItem(String mainText, int backgroundColor) {

        this.mainText = mainText;
        this.backgroundColor = backgroundColor;

    }


    public String getMainText() {return mainText;}
    public int getBackgroundColor() {return backgroundColor;}


}

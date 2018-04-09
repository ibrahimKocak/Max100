package com.example.ibrah.max100;

import android.widget.Button;

/**
 * Created by ibrah on 9.12.2017.
 */

public class MyButton {

    private Button button;
    private int status;         //0=unclickable, 1=clickable, 2=clicked

    //Constructors
    MyButton(Button viewById) {
        setButton(viewById);}

    public MyButton(Button viewById,int status) {
        setButton(viewById);
        setStatus(status);}

    public MyButton() {}

    public Button getButton() {
        return button;
    }



    private void setButton(Button button) {
        this.button = button;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

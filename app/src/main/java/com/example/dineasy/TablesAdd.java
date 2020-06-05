package com.example.dineasy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TablesAdd {
    private int mImageResource;
    private String mText1;
    private String mText2;
    private int mImageResource2;


    public TablesAdd(int imageResource, String text1, String text2,int ImageResource2){
        mImageResource = imageResource;
        mImageResource2 = ImageResource2;
        mText1 = text1;
        mText2 = text2;
    }
    public int getImageResource2(){
        return mImageResource2;
    }
    public int getImageResource(){
        return mImageResource;
    }
    public String getText1(){
        return mText1;
    }
    public String getText2(){
        return mText2;
    }
}
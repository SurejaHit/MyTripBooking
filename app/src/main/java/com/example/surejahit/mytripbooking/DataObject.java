package com.example.surejahit.mytripbooking;

public class DataObject {
    private String mText1;
    private String mText2;
    private int img;

    DataObject (String text1, String text2, int thumb){
        mText1 = text1;
        mText2 = text2;
        img = thumb;
    }

    public String getmText1() {
        return mText1;
    }

    public void setmText1(String mText1)
    { this.mText1 = mText1; }

    public String getmText2() {
        return mText2;
    }

    public void setmText2(String mText2)
    { this.mText2 = mText2; }

    public int getimg(){ return img; }

    public void setimg(int img)
    {this.img = img;}

}


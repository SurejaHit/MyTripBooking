package com.example.surejahit.mytripbooking;

import android.content.Context;
import android.content.SharedPreferences;

public class Userlog {

    Context ctx;
    SharedPreferences shp;
    private String name;

    public void removeuser()
    {
        shp.edit().clear().commit();
    }
    public String getName() {
       name = shp.getString("username","");
        return name;
    }

    public void setName(String name) {
        this.name = name;
        shp.edit().putString("username",name).commit();
    }


    public Userlog(Context context)
    {
        this.ctx = context;
        shp = context.getSharedPreferences("hiddenlogfile",Context.MODE_PRIVATE);
    }

}

package com.my_course_coen_390.Tutorial04.Controllers;

import android.content.Context;


import com.android.volley.Request;

import java.util.ArrayList;

/**
 * Created by Mohammed Shehab on 13-Oct-17.
 */

public class VolleyCommand <T>{

    ArrayList<Request<T>> requestsList = new ArrayList<>();
    Context context;
    public VolleyCommand(Context c) {
        this.context = c;
    }

    public void add(Request<T> request)
    {
        if(request != null)
            requestsList.add(request);
    }

    public void remove(Request<T> request)
    {
        if(request != null)
            requestsList.remove(request);
    }

    public void execute()
    {
        for(Request request : requestsList) {
            ShehabSingleton.getInstance(context).addToRequestQueue(request);
        }
    }
}
package com.my_course_coen_390.Tutorial04.Controllers;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    //jdsfvhdksjbgfh
    private SharedPreferences sharedPreferences;
    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference",
                Context.MODE_PRIVATE );
    }
    public void saveProfileName(String name)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("profileName",name );
        editor.commit();
    }
    public String getProfileName()
    {
        return sharedPreferences.getString("profileName", null);
    }

}

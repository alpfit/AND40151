package com.apillay.dailyfortune;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by apillay on 3/9/2016.
 */
public class MyPreferences {
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "DailyFortune";
    private static final String IS_FIRSTTIME = "IsFirstTime";
    private static final String USER_NAME = "name";

    public MyPreferences(Context context) {
        _context = context;
        prefs = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = prefs.edit();
    }

    public boolean isFirstTime() {
        return prefs.getBoolean(IS_FIRSTTIME, true);
    }

    public void setOld(boolean b) {
        if (b) {
            editor.putBoolean(IS_FIRSTTIME, false);
            editor.commit();
        }
    }

    public String getUserName() {
        return prefs.getString(USER_NAME, "");
    }

    public void setUserName(String name) {
        editor.putString(USER_NAME, name);
        editor.commit();
    }


}

package com.kg.vista.ooba.ui.activity;

import android.content.Context;
import android.content.SharedPreferences;

public class UsersManagement {

    private static String PREF_NAME = "prefs";

    public UsersManagement(){ }

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    public static String getUserData(Context context) {
        return getPrefs(context).getString("USER_ID", "0");
    }

    public static void setUserData(Context context, String input) {
        SharedPreferences.Editor editor = getPrefs(context).edit();
        editor.putString("USER_ID", input);
        editor.commit();
    }
}

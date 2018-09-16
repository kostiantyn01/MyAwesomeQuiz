package com.demien.myawesomequiz.PreferenceManager;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceManager {

    private static final String SHARED_PREFS = "sharedPrefs";


    // properties
    private static final String SOME_STRING_VALUE = "SOME_STRING_VALUE";
    private static final int SOME_INT_VALUE = 0;
    // other properties...


    private SharedPreferenceManager() {}

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
    }

    public static String getSomeStringValue(Context context) {
        return getSharedPreferences(context).getString(SOME_STRING_VALUE , null);
    }

    public static void setSomeStringValue(Context context, String newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(SOME_STRING_VALUE , newValue);
        editor.apply();
    }

    public static void setSomeIntValue(Context context, int newValue) {
        final SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(SOME_STRING_VALUE , newValue);
        editor.apply();
    }

    public static int getSomeIntValue(Context context) {
        return getSharedPreferences(context).getInt(SOME_STRING_VALUE , 0);
    }

}

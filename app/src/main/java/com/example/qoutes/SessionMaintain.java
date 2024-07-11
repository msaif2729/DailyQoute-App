package com.example.qoutes;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionMaintain {

    private Context context;
    private final String PREF_MEMORY = "daily-qoutes";
    private final int PREF_MODE = 0;
    private SharedPreferences.Editor editor;
    private final String KEY_LOGIN = "key_login";
    private final String KEY_NAME = "key_name";
    private final String KEY_GENDER = "key_gender";
    private final String KEY_THEME = "key_theme";
    private final String KEY_CAT = "key_cat";

    private SharedPreferences sharedPreferences;

    public SessionMaintain(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_MEMORY,PREF_MODE);
        editor = sharedPreferences.edit();
    }

    public boolean checksession()
    {
        if(sharedPreferences.contains(KEY_LOGIN))
        {
            return true;
        }
        else
            return false;
    }


    public void namesession(String name)
    {
        editor.putString(KEY_NAME,name);
        editor.commit();
        editor.apply();
    }

    public void gendersession(String gender)
    {
        editor.putString(KEY_GENDER,gender);
        editor.putBoolean(KEY_LOGIN,true);
        editor.commit();
        editor.apply();
    }

    public void themesession(String theme)
    {
        editor.putString(KEY_THEME,theme);
        editor.commit();
        editor.apply();
    }

    public String getTheme(String key)
    {
        return sharedPreferences.getString(key,null);
    }

    public String[] getsession(String keyname,String keygender)
    {
        return new String[]{sharedPreferences.getString(keyname,null),sharedPreferences.getString(keygender,null)};
    }

    public void category(String cat)
    {
        editor.putString(KEY_CAT,cat);
        editor.commit();
        editor.apply();
    }
    public String getcategory(String keycat)
    {
       return sharedPreferences.getString(keycat,null);
    }






}

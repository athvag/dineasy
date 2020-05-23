package com.example.dineasy;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManagement {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String SESname = "USER";
    String SHARED_PREF_NAME="session";
    String SESSION_KEY = "session_user";
    String SESSION_USERNAME = "session_username";
    public SessionManagement(Context context){
        sharedPreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void saveSession(user user){
        //save session of user whenever user is logged in
    int id = user.getId();
    String uname = user.getName();
    editor.putString(SESname,uname).commit();
    editor.putInt(SESSION_KEY,id).commit();
        String username = user.getName();
        editor.putString(SESSION_USERNAME,username).commit();
    }
    public int getSession(){
        //return user id whose session is saved
    return sharedPreferences.getInt(SESSION_KEY,-1);
    }

    public String getSESname(){
        return sharedPreferences.getString(SESname,"");
    }
    public void setSESname(String name){
        editor.putString(SESname,name).commit();
    }
    public void removeSession(){
        editor.putInt(SESSION_KEY, -1).commit();
    }
}

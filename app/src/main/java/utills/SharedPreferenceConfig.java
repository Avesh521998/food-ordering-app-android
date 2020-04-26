package utills;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SharedPreferenceConfig {
    private SharedPreferenceConfig sharedPreference;
    private Context context;
    public void SharedPreferenceConfig()
    {
    }
    public static boolean saveEmail(String email,Context context)
    {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_EMAIL,email);
        prefsEditor.apply();
        return true;
    }
    public static String getEmail(Context context){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(Constants.KEY_EMAIL,null);
    }

}

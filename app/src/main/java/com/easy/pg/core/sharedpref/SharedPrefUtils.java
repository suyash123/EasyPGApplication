package com.easy.pg.core.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.StringDef;

import com.easy.pg.app.EasyPGApplication;
import com.easy.pg.core.utils.Utils;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class SharedPrefUtils {

    public final static String ACCOUNT_SETTINGS = "account_settings";
    public final static String DEFAULT_SETTINGS_PREF = "com.easy.pg_preferences";

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ACCOUNT_SETTINGS, DEFAULT_SETTINGS_PREF})
    public @interface SharedPrefFile {
    }

    private static final String DEFAULT_PREF_NAME = ACCOUNT_SETTINGS;
    private static volatile SharedPreferences defaultSharedPreferences;
    private ISharedPrefUtil sharedPrefManager;
    private static final Map<String, SharedPrefUtils> prefsMap = new ConcurrentHashMap<>();

    public enum SharedPreferenceFile {
        DEFAULT(0), LIBRARY_IN_USE(1), BACKUP_FILE_IN_USE(2);
        final int value;

        SharedPreferenceFile(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static void resetMap() {
        prefsMap.clear();
    }

    private static SharedPrefUtils initializeSharedPref(Context context, String argSharedPrefName) {
        SharedPrefUtils sharedPrefUtils = null;
        if (context != null) {
            sharedPrefUtils = new SharedPrefUtils();
            sharedPrefUtils.sharedPrefManager = new CustomSharedPref(getFilename(argSharedPrefName), context);
            prefsMap.put(argSharedPrefName, sharedPrefUtils);
            sharedPrefUtils.defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return sharedPrefUtils;
    }

    public static SharedPrefUtils defaultAndroidPref(Context context) {
        return getInstance(context.getPackageName() + "_preferences");
    }

    public static SharedPrefUtils getInstance() {
        return getInstance(DEFAULT_PREF_NAME);
    }

    public static SharedPrefUtils getInstance(String argSharedPrefName) {
        if (prefsMap.containsKey(argSharedPrefName)) {
            SharedPrefUtils util = prefsMap.get(argSharedPrefName);
            if (util != null && util.sharedPrefManager != null) {
                return util;
            }
        }
        if (EasyPGApplication.getInstance() == null) {
            return null;
        }
        return initializeSharedPref(EasyPGApplication.getInstance(), argSharedPrefName);
    }

    private SharedPrefUtils() {
        // NO OP
    }

    private static String getFilename(String argSharedPrefName) {
        return getDefaultSharedPref().getString(argSharedPrefName, argSharedPrefName);
    }

    public  void saveDataSafe(@SharedPrefConst.Key String key, String value) {
        sharedPrefManager.saveData(key, value);
    }

    @Deprecated
    public  void saveData(String key, String value) {
        sharedPrefManager.saveData(key, value);
    }

    public  void saveDataSafe(@SharedPrefConst.Key String key, boolean value) {
        sharedPrefManager.saveData(key, value);
    }

    @Deprecated
    public  void saveData(String key, boolean value) {
        sharedPrefManager.saveData(key, value);
    }

    public  void saveDataSafe(@SharedPrefConst.Key String key, long value) {
        sharedPrefManager.saveData(key, value);
    }

    @Deprecated
    public  void saveData(String key, long value) {
        sharedPrefManager.saveData(key, value);
    }

    public  void saveDataSafe(@SharedPrefConst.Key String key, float value) {
        sharedPrefManager.saveData(key, value);
    }

    @Deprecated
    public  void saveData(String key, float value) {
        sharedPrefManager.saveData(key, value);
    }

    public  void saveDataSafe(@SharedPrefConst.Key String key, int value) {
        sharedPrefManager.saveData(key, value);
    }

    @Deprecated
    public  void saveData(String key, int value) {
        sharedPrefManager.saveData(key, value);
    }

    public  void saveDataMap(Map<String, Integer> keyValueMap) {
        if (keyValueMap != null && keyValueMap.size() > 0) {
            Set<String> keys = keyValueMap.keySet();
            for (String key : keys) {
                sharedPrefManager.saveData(key, keyValueMap.get(key));
            }
        }
    }

    public  void saveDataSetSafe(@SharedPrefConst.Key String key, Set<String> value) {
        sharedPrefManager.saveDataSet(key, value);
    }

    public  void removeDataSafe(@SharedPrefConst.Key String key) {
        sharedPrefManager.removeData(key);
    }

    @Deprecated
    public  void removeData(String key) {
        sharedPrefManager.removeData(key);
    }

    public  void removeData(Set<String> keys) {
        if (!Utils.isEmpty(keys)) {
            for (String key : keys) {
                sharedPrefManager.removeData(key);
            }
        }
    }

    public  Boolean getDataSafe(@SharedPrefConst.Key String key, boolean defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    @Deprecated
    public  Boolean getData(String key, boolean defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    public  String getDataSafe(@SharedPrefConst.Key String key, String defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    @Deprecated
    public  String getData(String key, String defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    public  Set<String> getDataSetSafe(@SharedPrefConst.Key String key, Set<String> defaultValues) {
        Set<String> stringSet = sharedPrefManager.getDataSet(key, defaultValues);
        if (Utils.isEmpty(stringSet)) {
            return new HashSet<>();
        }
        return new HashSet<>(stringSet);
    }

    public  float getDataSafe(@SharedPrefConst.Key String key, float defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    @Deprecated
    public  float getData(String key, float defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    public  int getDataSafe(@SharedPrefConst.Key String key, int defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    @Deprecated
    public  int getData(String key, int defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    public  long getDataSafe(@SharedPrefConst.Key String key, long defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    @Deprecated
    public  long getData(String key, long defaultValue) {
        return sharedPrefManager.getData(key, defaultValue);
    }

    public  Map<String, ?> getAllData() {
        return sharedPrefManager.getAllData();
    }

    public  void deleteAllData() {
        sharedPrefManager.deleteAllData();
    }

    public static SharedPreferences getDefaultSharedPref() {
        if (defaultSharedPreferences == null)
            defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(EasyPGApplication.getInstance());
        return defaultSharedPreferences;
    }

    public boolean getSharedPreferenceAsBooleanSafe(@SharedPrefConst.Key String key, boolean defaultValue) {
        return getDefaultSharedPref().getBoolean(key, defaultValue);
    }

    public  boolean containsSafe(@SharedPrefConst.Key String key) {
        return sharedPrefManager.contains(key);
    }

    public interface EditPreference {
        public void edit(ISharedPrefUtil util);
    }

    public synchronized void apply(EditPreference editPreference) {
        editPreference.edit(sharedPrefManager);
    }
}

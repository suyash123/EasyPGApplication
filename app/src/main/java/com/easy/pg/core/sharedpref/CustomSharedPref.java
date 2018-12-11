package com.easy.pg.core.sharedpref;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;
import java.util.Set;

public class CustomSharedPref implements ISharedPrefUtil {
    private SharedPreferences hikeSharedPreferences;
    private SharedPreferences.Editor editor;

    public CustomSharedPref(String argSharedPrefName, Context context) {
        hikeSharedPreferences = context.getSharedPreferences(argSharedPrefName, Activity.MODE_PRIVATE | Context.MODE_MULTI_PROCESS);
        editor = hikeSharedPreferences.edit();
    }

    @Override
    public synchronized void saveData(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    @Override
    public synchronized String getData(String key, String defaultValue) {
        return hikeSharedPreferences.getString(key, defaultValue);
    }

    @Override
    public synchronized void saveData(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    @Override
    public synchronized Boolean getData(String key, boolean defaultValue) {
        return hikeSharedPreferences.getBoolean(key, defaultValue);
    }

    @Override
    public synchronized void saveData(String key, long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    @Override
    public synchronized long getData(String key, long defaultValue) {
        return hikeSharedPreferences.getLong(key, defaultValue);
    }

    @Override
    public synchronized void saveData(String key, float value) {
        editor.putFloat(key, value);
        editor.apply();
    }

    @Override
    public synchronized float getData(String key, float defaultValue) {
        return hikeSharedPreferences.getFloat(key, defaultValue);
    }

    @Override
    public synchronized void saveData(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    @Override
    public synchronized int getData(String key, int defaultValue) {
        return hikeSharedPreferences.getInt(key, defaultValue);
    }

    @Override
    public synchronized void saveDataSet(String key, Set<String> value) {
        editor.putStringSet(key, value);
        editor.apply();
    }

    @Override
    public synchronized Set<String> getDataSet(String key, Set<String> defaultValues) {
        return hikeSharedPreferences.getStringSet(key, defaultValues);
    }

    @Override
    public synchronized void removeData(String key) {
        editor.remove(key);
        editor.apply();
    }

    @Override
    public synchronized void deleteAllData() {
        editor.clear();
        editor.apply();
    }

    @Override
    public synchronized boolean contains(String key) {
        return hikeSharedPreferences.contains(key);
    }

    @Override
    public synchronized Map<String, ?> getAllData() {
        return hikeSharedPreferences.getAll();
    }
}
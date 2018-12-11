package com.easy.pg.core.sharedpref;

import java.util.Map;
import java.util.Set;

public interface ISharedPrefUtil {

    void saveData(@SharedPrefConst.Key String key, String value);

    String getData(@SharedPrefConst.Key String key, String defaultValue);

    void saveData(@SharedPrefConst.Key String key, boolean value);

    Boolean getData(@SharedPrefConst.Key String key, boolean defaultValue);

    void saveData(@SharedPrefConst.Key String key, long value);

    long getData(@SharedPrefConst.Key String key, long defaultValue);

    void saveData(@SharedPrefConst.Key String key, float value);

    float getData(@SharedPrefConst.Key String key, float defaultValue);

    void saveData(@SharedPrefConst.Key String key, int value);

    int getData(@SharedPrefConst.Key String key, int defaultValue);

    void saveDataSet(@SharedPrefConst.Key String key, Set<String> value);

    Set<String> getDataSet(@SharedPrefConst.Key String key, Set<String> defaultValues);

    void removeData(@SharedPrefConst.Key String key);

    void deleteAllData();

    boolean contains(@SharedPrefConst.Key String key);

    Map<String, ?> getAllData();
}

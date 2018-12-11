package com.easy.pg.core.sharedpref;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class SharedPrefConst {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({
            SP_ACC_CREATED,
            SP_ACC_MOBILE,
            SP_ACC_PWD
            })

    public @interface Key {
    }

    public static final String SP_ACC_CREATED = "a:created";
    public static final String SP_ACC_MOBILE = "a:mobile";
    public static final String SP_ACC_PWD = "a:pwd";

}


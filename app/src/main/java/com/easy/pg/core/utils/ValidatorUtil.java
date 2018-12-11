package com.easy.pg.core.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

public class ValidatorUtil {

    public static boolean isEmailValid(@NonNull CharSequence text) {
        String regex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        return (!TextUtils.isEmpty(text) && text.toString().matches(regex));
    }

    public static boolean isValidPassword(@NonNull CharSequence text) {
        return !TextUtils.isEmpty(text) && text.length() >= 6 && text.length() <= 15;
    }

    public static boolean isValidPhoneNumber(@NonNull CharSequence text) {
        if(TextUtils.isEmpty(text)) {
            return false;
        }
        String regex = "[^\\d]";
        String PhoneDigits = text.toString().replaceAll(regex, "");
        return PhoneDigits.length() == 10;
    }
}

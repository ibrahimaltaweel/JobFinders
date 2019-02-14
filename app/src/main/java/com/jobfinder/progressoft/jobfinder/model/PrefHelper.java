package com.jobfinder.progressoft.jobfinder.model;

import android.content.Context;
import android.content.SharedPreferences;

import com.jobfinder.progressoft.jobfinder.model.vo.C;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class PrefHelper {
    private static SharedPreferences prefs = null;

    private static SharedPreferences getPrefs(Context context) {
        if (prefs == null) {
            prefs = context.getApplicationContext().getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        }

        return prefs;
    }


}
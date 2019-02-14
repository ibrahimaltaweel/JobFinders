package com.jobfinder.progressoft.jobfinder.controller.util;

import android.content.Context;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CacheUtil {
    public static String getCachedData(Context context, String... fileNameParts) {
        File cacheDir = context.getApplicationContext().getCacheDir();
        File file = new File(cacheDir.getPath() + "/" + StringUtils.join(fileNameParts, "_"));

        if (!file.exists()) {
            return null;
        }

        String line;
        final String NEW_LINE = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder();

        try {
            FileReader fReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fReader);

            while ((line = bReader.readLine()) != null) {
                stringBuilder.append(line + NEW_LINE);
            }

            if (stringBuilder.toString().endsWith(NEW_LINE)) {
                stringBuilder.setLength(stringBuilder.length() - 1);
            }

            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void cacheDataAsync(final Context context, final String data, final String... fileNameParts) {
        if (data == null || data.isEmpty()) {
            return;
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                File cacheDir = context.getApplicationContext().getCacheDir();
                File file = new File(cacheDir.getPath() + "/" + StringUtils.join(fileNameParts, "_"));

                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(data);
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void deleteCachedDataAsync(final Context context, final String... fileNameParts) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File cacheDir = context.getApplicationContext().getCacheDir();
                File file = new File(cacheDir.getPath() + "/" + StringUtils.join(fileNameParts, "_"));
                if (file.exists()) {
                    file.delete();
                }
            }
        }).start();
    }

    public static boolean makeDirs(String... dirs) {
        boolean success = true;

        for (String path : dirs) {
            File folder = new File(path);

            if (!folder.exists()) {
                success = folder.mkdir();
            }

            if (!success) {
                return false;
            }
        }

        return true;
    }
}
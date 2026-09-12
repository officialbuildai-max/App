package com.cloud.tmc.integration.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import dalvik.system.DexFile;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class ClassUtils {
    public static Map<String, String> scan(Context context, String str) {
        return scan(context, str, ".*\\$.*", "");
    }

    public static Map<String, String> scan(Context context, String str, @NonNull String str2) {
        return scan(context, str, str2, "");
    }

    public static Map<String, String> scan(Context context, String str, @NonNull String str2, @NonNull String str3) {
        HashMap hashMap = new HashMap();
        try {
            Enumeration<String> entries = new DexFile(context.getPackageCodePath()).entries();
            while (entries.hasMoreElements()) {
                String nextElement = entries.nextElement();
                if (nextElement.contains(str) && !nextElement.matches(str2)) {
                    if ("".equals(str3)) {
                        hashMap.put(nextElement.substring(nextElement.lastIndexOf(".") + 1, nextElement.length()), nextElement);
                    } else {
                        hashMap.put(nextElement.substring(nextElement.lastIndexOf(".") + 1, nextElement.length() - str3.length()), nextElement);
                    }
                }
            }
        } catch (IOException e11) {
            e11.printStackTrace();
        }
        return hashMap;
    }
}

package com.cloud.hisavana.sdk.common.util;

import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public class p0 {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(35);
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        int lastIndexOf2 = str.lastIndexOf(63);
        if (lastIndexOf2 > 0) {
            str = str.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = str.lastIndexOf(47);
        if (lastIndexOf3 >= 0) {
            str = str.substring(lastIndexOf3 + 1);
        }
        return (str.isEmpty() || !Pattern.matches("[a-zA-Z_0-9\\.\\-\\(\\)\\%]+", str)) ? "" : str;
    }

    private static Map b(String str) {
        HashMap hashMap = new HashMap();
        String d11 = d(str);
        if (d11 == null) {
            return hashMap;
        }
        for (String str2 : d11.split("[&]")) {
            String[] split = str2.split("[=]");
            if (split.length > 1) {
                hashMap.put(split[0], split[1]);
            } else if (!"".equals(split[0])) {
                hashMap.put(split[0], "");
            }
        }
        return hashMap;
    }

    public static String c(String str, String str2) {
        Map b11;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (b11 = b(str2)) == null || b11.isEmpty()) {
            return "";
        }
        String str3 = (String) b11.get(str);
        return TextUtils.isEmpty(str3) ? "" : str3;
    }

    private static String d(String str) {
        String[] split;
        String str2;
        String trim = str.trim();
        if (trim == null || trim.length() <= 1 || (split = trim.split("[?]")) == null || split.length <= 1 || (str2 = split[1]) == null) {
            return null;
        }
        return str2;
    }

    public static boolean e(String str, String str2) {
        return str2.startsWith(str);
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            new URL(str);
            return true;
        } catch (MalformedURLException unused) {
            return false;
        }
    }
}

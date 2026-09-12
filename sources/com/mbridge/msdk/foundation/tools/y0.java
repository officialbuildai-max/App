package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;

/* loaded from: classes5.dex */
public class y0 {
    public static boolean a(String str) {
        return str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str);
    }

    public static boolean b(String str) {
        return (str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str)) ? false : true;
    }
}

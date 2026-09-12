package com.cloud.hisavana.sdk.common.util;

import android.text.TextUtils;
import com.cloud.hisavana.sdk.e4;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class l0 {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            String[] split = str.split(":");
            if (split.length != 3) {
                return 0;
            }
            return (Integer.parseInt(split[0]) * 3600) + (Integer.parseInt(split[1]) * 60) + Integer.parseInt(split[2]);
        } catch (Exception unused) {
            e4.b().e("TimeUtil", "getDuration wrong,param is " + str);
            return 0;
        }
    }

    public static long b(long j11) {
        return j11 - ((TimeZone.getDefault().getRawOffset() + j11) % 3600000);
    }

    public static long c(long j11) {
        return j11 - ((TimeZone.getDefault().getRawOffset() + j11) % 86400000);
    }
}

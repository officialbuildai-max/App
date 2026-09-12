package com.bytedance.sdk.openadsdk.utils;

import android.content.Context;

/* loaded from: classes3.dex */
public class zR {
    public static String Sj(Context context) {
        int Sj = com.bytedance.sdk.component.utils.wE.Sj(context, 0L);
        return Sj != 2 ? Sj != 3 ? Sj != 4 ? Sj != 5 ? Sj != 6 ? "mobile" : "5g" : "4g" : "wifi" : "3g" : "2g";
    }
}

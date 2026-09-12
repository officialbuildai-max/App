package com.mbridge.msdk.util;

import com.cloud.tmc.component_api_ps.MiniAppIpcCommonUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.out.MBConfiguration;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f38814a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile Boolean f38815b;

    public static boolean a() {
        if (f38814a == null) {
            try {
                boolean z10 = Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 2;
                f38814a = Boolean.valueOf(z10);
                return z10;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b(MiniAppIpcCommonUtils.TAG, "isChina", e11);
                }
            }
        }
        return f38814a != null && f38814a.booleanValue();
    }

    public static boolean b() {
        if (f38815b == null) {
            try {
                boolean z10 = Integer.parseInt(String.valueOf(MBConfiguration.SDK_VERSION.charAt(10))) == 1;
                f38815b = Boolean.valueOf(z10);
                return z10;
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    o0.b(MiniAppIpcCommonUtils.TAG, "isOversea", e11);
                }
            }
        }
        return f38815b != null && f38815b.booleanValue();
    }
}

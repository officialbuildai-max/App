package com.transsion.push.utils;

import com.cloud.tmc.kernel.utils.NetworkUtil;

/* loaded from: classes6.dex */
public final class n {
    public static String a() {
        int c11 = com.transsion.core.utils.d.c();
        return c11 != -101 ? (c11 == -1 || c11 == 0) ? "" : c11 != 1 ? c11 != 2 ? c11 != 3 ? "" : NetworkUtil.NETWORK_TYPE_4G : NetworkUtil.NETWORK_TYPE_3G : NetworkUtil.NETWORK_TYPE_2G : "wifi";
    }

    public static String b() {
        String a11 = a();
        return "wifi".equals(a11) ? "wifi" : "".equals(a11) ? "no_network" : "mobile";
    }

    public static boolean c() {
        return "wifi".equals(a());
    }
}

package com.mbridge.msdk.advanced.common;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, Boolean> f34112a = new HashMap();

    public static void a(String str, boolean z10) {
        f34112a.put(str, Boolean.valueOf(z10));
    }

    public static boolean a(String str) {
        if (f34112a.containsKey(str)) {
            return f34112a.get(str).booleanValue();
        }
        return false;
    }

    public static void b(String str) {
        f34112a.remove(str);
    }
}

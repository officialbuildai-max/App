package com.transsion.rewardscenter.utils;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class q {
    public static final void a(String module, Map map) {
        Intrinsics.h(module, "module");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", module);
        if (map != null) {
            hashMap.putAll(map);
        }
        hj.i.f64628a.p("rewards_center", hashMap);
    }

    public static final void b(String module, Map map) {
        Intrinsics.h(module, "module");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", module);
        if (map != null) {
            hashMap.putAll(map);
        }
        hj.i.f64628a.D("rewards_center", hashMap);
    }

    public static /* synthetic */ void c(String str, Map map, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            map = null;
        }
        b(str, map);
    }
}

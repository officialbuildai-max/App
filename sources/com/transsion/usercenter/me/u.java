package com.transsion.usercenter.me;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f57138a = new u();

    /* renamed from: b, reason: collision with root package name */
    private static String f57139b;

    private u() {
    }

    public final void a(String moduleName) {
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        String str = f57139b;
        if (str == null) {
            str = "";
        }
        hashMap.put("user_id", str);
        hashMap.put("user_status", "me");
        hashMap.put("module_name", moduleName);
        hj.i.f64628a.D("profiledetail", hashMap);
    }

    public final void b(String moduleName) {
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        String str = f57139b;
        if (str == null) {
            str = "";
        }
        hashMap.put("user_id", str);
        hashMap.put("user_status", "me");
        hashMap.put("module_name", moduleName);
        hj.i.f64628a.p("profiledetail", hashMap);
    }

    public final void c(String moduleName, int i11) {
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        String str = f57139b;
        if (str == null) {
            str = "";
        }
        hashMap.put("user_id", str);
        hashMap.put("user_status", "me");
        hashMap.put("module_name", moduleName);
        hashMap.put(RequestParameters.POSITION, String.valueOf(i11));
        hj.i.f64628a.p("profiledetail", hashMap);
    }

    public final void d(String str) {
        f57139b = str;
    }
}

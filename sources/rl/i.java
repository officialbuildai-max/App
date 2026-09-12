package rl;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private final HashSet f74681a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f74682b = new HashSet();

    public final void a(String pageName, String moduleName, String str, String str2, Integer num, boolean z10, String str3, String str4, String str5) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        hashMap.put("subject_id", str);
        hashMap.put("ops", str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(num);
        hashMap.put(RequestParameters.POSITION, sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(z10);
        hashMap.put("has_resource", sb3.toString());
        hashMap.put("category", String.valueOf(str3));
        hashMap.put("rec_type", String.valueOf(str4));
        hashMap.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f43316a.i(pageName, hashMap);
    }

    public final void b(String pageName, String str, String str2, Integer num, String str3, String str4, String str5) {
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("staff_id", String.valueOf(str));
        hashMap.put("ops", String.valueOf(str2));
        hashMap.put(RequestParameters.POSITION, String.valueOf(num));
        if (str != null) {
            boolean contains = this.f74682b.contains(str);
            this.f74682b.add(str);
            if (contains) {
                return;
            }
        }
        hashMap.put("category", String.valueOf(str3));
        hashMap.put("rec_type", String.valueOf(str4));
        hashMap.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f43316a.a(pageName, hashMap);
    }

    public final void c(String pageName, String str, String str2, Integer num, String str3, String str4, String str5) {
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("staff_id", String.valueOf(str));
        hashMap.put("ops", String.valueOf(str2));
        hashMap.put(RequestParameters.POSITION, String.valueOf(num));
        hashMap.put("category", String.valueOf(str3));
        hashMap.put("rec_type", String.valueOf(str4));
        hashMap.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f43316a.f(pageName, hashMap);
    }

    public final void d(String pageName, String str, String str2, Integer num, boolean z10, String str3, String str4, String str5) {
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", String.valueOf(str));
        hashMap.put("ops", String.valueOf(str2));
        hashMap.put(RequestParameters.POSITION, String.valueOf(num));
        if (str != null) {
            boolean contains = this.f74681a.contains(str);
            this.f74681a.add(str);
            if (contains) {
                return;
            }
        }
        hashMap.put("has_resource", String.valueOf(z10));
        hashMap.put("category", String.valueOf(str3));
        hashMap.put("rec_type", String.valueOf(str4));
        hashMap.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f43316a.a(pageName, hashMap);
    }

    public final void e(String pageName, String str, String str2, Integer num, boolean z10, String str3, String str4, String str5) {
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("subject_id", String.valueOf(str));
        hashMap.put("ops", String.valueOf(str2));
        hashMap.put(RequestParameters.POSITION, String.valueOf(num));
        hashMap.put("has_resource", String.valueOf(z10));
        hashMap.put("category", String.valueOf(str3));
        hashMap.put("rec_type", String.valueOf(str4));
        hashMap.put("label", String.valueOf(str5));
        com.transsion.baselib.helper.a.f43316a.f(pageName, hashMap);
    }
}

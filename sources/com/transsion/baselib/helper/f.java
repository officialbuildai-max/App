package com.transsion.baselib.helper;

import android.text.TextUtils;
import com.therouter.TheRouter;
import com.transsion.base.report.athena.ClickType;
import com.transsion.memberapi.IPremiumApi;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f43323a = new f();

    private f() {
    }

    public static /* synthetic */ void b(f fVar, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 32) != 0) {
            str6 = null;
        }
        fVar.a(str, str2, str3, str4, str5, str6);
    }

    public static /* synthetic */ void e(f fVar, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str5 = null;
        }
        fVar.d(str, str2, str3, str4, str5);
    }

    public static /* synthetic */ void g(f fVar, String str, String str2, String str3, String str4, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str4 = null;
        }
        fVar.f(str, str2, str3, str4, i11);
    }

    public static /* synthetic */ void i(f fVar, String str, String str2, String str3, String str4, int i11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str4 = null;
        }
        fVar.h(str, str2, str3, str4, i11);
    }

    public final void a(String pageName, String str, String orderId, String traceId, String skuId, String str2) {
        String str3;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(orderId, "orderId");
        Intrinsics.h(traceId, "traceId");
        Intrinsics.h(skuId, "skuId");
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            Intrinsics.e(str);
            hashMap.put("scene_id", str);
        }
        hashMap.put("order_id", orderId);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("module_name", str2);
        hashMap.put("trace_id", traceId);
        hashMap.put("sku_id", skuId);
        hashMap.put("opt_type", "order_submit");
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi == null || (str3 = iPremiumApi.m()) == null) {
            str3 = "non-vip";
        }
        hashMap.put("membership_status", str3);
        hj.i.f64628a.F(pageName, "vip_buy_click", hashMap);
    }

    public final void c(String pageName, String dialogName) {
        String str;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(dialogName, "dialogName");
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", dialogName);
        hashMap.put("module_name", "confirm");
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi == null || (str = iPremiumApi.m()) == null) {
            str = "non-vip";
        }
        hashMap.put("membership_status", str);
        hj.i.f64628a.q(pageName, hashMap, ClickType.FEATURE);
    }

    public final void d(String pageName, String sceneId, String traceId, String moduleName, String str) {
        String str2;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(traceId, "traceId");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("scene_id", sceneId);
        hashMap.put("trace_id", traceId);
        hashMap.put("module_name", moduleName);
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi == null || (str2 = iPremiumApi.m()) == null) {
            str2 = "non-vip";
        }
        hashMap.put("membership_status", str2);
        if (str != null && str.length() != 0) {
            hashMap.put("subject_id", str);
        }
        hj.i.f64628a.F(pageName, "vip_sku_show", hashMap);
    }

    public final void f(String pageName, String sceneId, String traceId, String str, int i11) {
        String str2;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(traceId, "traceId");
        HashMap hashMap = new HashMap();
        hashMap.put("scene_id", sceneId);
        hashMap.put("trace_id", traceId);
        if (str != null && str.length() != 0) {
            hashMap.put("subject_id", str);
        }
        hashMap.put("remind_type", String.valueOf(i11));
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi == null || (str2 = iPremiumApi.m()) == null) {
            str2 = "non-vip";
        }
        hashMap.put("membership_status", str2);
        hj.i.f64628a.F(pageName, "vip_entry_click", hashMap);
    }

    public final void h(String pageName, String sceneId, String traceId, String str, int i11) {
        String str2;
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(sceneId, "sceneId");
        Intrinsics.h(traceId, "traceId");
        HashMap hashMap = new HashMap();
        hashMap.put("scene_id", sceneId);
        hashMap.put("trace_id", traceId);
        if (str != null && str.length() != 0) {
            hashMap.put("subject_id", str);
        }
        hashMap.put("remind_type", String.valueOf(i11));
        IPremiumApi iPremiumApi = (IPremiumApi) TheRouter.d(IPremiumApi.class, new Object[0]);
        if (iPremiumApi == null || (str2 = iPremiumApi.m()) == null) {
            str2 = "non-vip";
        }
        hashMap.put("membership_status", str2);
        hj.i.f64628a.F(pageName, "vip_entry_show", hashMap);
    }
}

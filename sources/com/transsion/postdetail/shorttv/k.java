package com.transsion.postdetail.shorttv;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f49278a = new k();

    private k() {
    }

    public static /* synthetic */ void b(k kVar, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str5 = "minitv_play";
        }
        kVar.a(str, str2, str3, str4, str5);
    }

    public static /* synthetic */ void d(k kVar, String str, String str2, String str3, boolean z10, String str4, String str5, int i11, Object obj) {
        if ((i11 & 16) != 0) {
            str4 = "minitv_play";
        }
        String str6 = str4;
        if ((i11 & 32) != 0) {
            str5 = null;
        }
        kVar.c(str, str2, str3, z10, str6, str5);
    }

    public final void a(String str, String str2, String optType, String position, String pageName) {
        Intrinsics.h(optType, "optType");
        Intrinsics.h(position, "position");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "watch_ad");
        if (str == null) {
            str = "";
        }
        hashMap.put("subject_id", str);
        if (str2 == null) {
            str2 = "";
        }
        hashMap.put("ops", str2);
        hashMap.put("opt_type", optType);
        hashMap.put(RequestParameters.POSITION, position);
        hj.i.f64628a.p(pageName, hashMap);
    }

    public final void c(String str, String str2, String optType, boolean z10, String pageName, String str3) {
        Intrinsics.h(optType, "optType");
        Intrinsics.h(pageName, "pageName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", "favorite");
        if (str != null && str.length() != 0) {
            hashMap.put("subject_id", str);
        }
        if (str2 != null && str2.length() != 0) {
            hashMap.put("ops", str2);
        }
        hashMap.put("opt_type", optType);
        hashMap.put("favorite", String.valueOf(!z10));
        if (str3 != null && str3.length() != 0) {
            hashMap.put(WebConstants.PAGE_FROM, str3);
        }
        hj.i.f64628a.p(pageName, hashMap);
    }
}

package com.transsion.baselib.helper;

import com.transsion.web.api.WebConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f43316a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f43317b = new ConcurrentHashMap();

    private a() {
    }

    public final void a(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        hj.i.f64628a.D(pageName, map);
    }

    public final void b(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        hj.i.f64628a.p(pageName, map);
    }

    public final void c(String pageName, String dialogName) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(dialogName, "dialogName");
        HashMap hashMap = new HashMap();
        hashMap.put("dialog_name", dialogName);
        hj.i.f64628a.r(pageName, hashMap);
    }

    public final void d(Map map) {
        Intrinsics.h(map, "map");
        hj.i.f64628a.t("download_app", map);
    }

    public final void e(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        hj.i.f64628a.D(pageName, map);
    }

    public final void f(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        hj.i.f64628a.p(pageName, map);
    }

    public final void g(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        hj.i.f64628a.p(pageName, map);
    }

    public final void h(String pageName, String moduleName, String str, String str2, String str3, String str4) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(moduleName, "moduleName");
        HashMap hashMap = new HashMap();
        hashMap.put("module_name", moduleName);
        if (str != null) {
            hashMap.put("group_id", str);
        }
        if (str2 != null) {
            hashMap.put("subject_id", str2);
        }
        if (str3 != null) {
            hashMap.put("post_id", str3);
        }
        if (str4 != null) {
            hashMap.put("ops", str4);
        }
        hj.i.f64628a.p(pageName, hashMap);
    }

    public final void i(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        hj.i.f64628a.p(pageName, map);
    }

    public final void k(String pageName, String pageFrom, String duration) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(pageFrom, "pageFrom");
        Intrinsics.h(duration, "duration");
        HashMap hashMap = new HashMap();
        hashMap.put(WebConstants.PAGE_FROM, pageFrom);
        hashMap.put("duration", duration);
        hj.i.f64628a.s(pageName, "pt", hashMap);
    }

    public final void l(String pageName, Map map) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(map, "map");
        hj.i.f64628a.p(pageName, map);
    }

    public final void m(String pageName, List pageTabNameList, boolean z10) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(pageTabNameList, "pageTabNameList");
        if (z10) {
            f43317b.clear();
        }
        Iterator it = pageTabNameList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            ConcurrentHashMap concurrentHashMap = f43317b;
            if (!concurrentHashMap.containsKey(str)) {
                concurrentHashMap.put(str, Boolean.TRUE);
                HashMap hashMap = new HashMap();
                hashMap.put("page_tab_name", str);
                hj.i.f64628a.D(pageName, hashMap);
            }
        }
    }

    public final void n(String pageName, String pageTabName) {
        Intrinsics.h(pageName, "pageName");
        Intrinsics.h(pageTabName, "pageTabName");
        HashMap hashMap = new HashMap();
        hashMap.put("page_tab_name", pageTabName);
        hj.i.f64628a.p(pageName, hashMap);
    }
}

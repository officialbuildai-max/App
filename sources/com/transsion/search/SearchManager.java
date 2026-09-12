package com.transsion.search;

import android.text.TextUtils;
import com.blankj.utilcode.util.o;
import com.google.gson.reflect.TypeToken;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes4.dex */
public final class SearchManager {

    /* renamed from: f, reason: collision with root package name */
    public static final a f51995f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static final Lazy f51996g = LazyKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0() { // from class: com.transsion.search.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            SearchManager e11;
            e11 = SearchManager.e();
            return e11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private int f52000d;

    /* renamed from: b, reason: collision with root package name */
    private final String f51998b = "kv_search_group";

    /* renamed from: c, reason: collision with root package name */
    private final String f51999c = "kv_search_work";

    /* renamed from: e, reason: collision with root package name */
    private List f52001e = new ArrayList();

    /* renamed from: a, reason: collision with root package name */
    private MMKV f51997a = MMKV.I("kv_search_list");

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SearchManager a() {
            return (SearchManager) SearchManager.f51996g.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchManager e() {
        return new SearchManager();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(SearchManager searchManager) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(searchManager.f52001e);
        a.C0856a.f(lg.a.f68962a, "VS_SM", "add" + arrayList, false, 4, null);
        int i11 = searchManager.f52000d;
        if (i11 != 1) {
            if (i11 == 2) {
                MMKV mmkv = searchManager.f51997a;
                if (mmkv != null) {
                    mmkv.putString(searchManager.f51998b, o.j(arrayList));
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
        }
        MMKV mmkv2 = searchManager.f51997a;
        if (mmkv2 != null) {
            mmkv2.putString(searchManager.f51999c, o.j(arrayList));
        }
    }

    private final void i(Runnable runnable) {
        h.f52235b.a().d(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(SearchManager searchManager) {
        searchManager.f52001e.clear();
        int i11 = searchManager.f52000d;
        if (i11 != 1) {
            if (i11 == 2) {
                MMKV mmkv = searchManager.f51997a;
                if (mmkv != null) {
                    mmkv.putString(searchManager.f51998b, "");
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
        }
        MMKV mmkv2 = searchManager.f51997a;
        if (mmkv2 != null) {
            mmkv2.putString(searchManager.f51999c, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(SearchManager searchManager, com.transsion.search.a aVar) {
        aVar.a(searchManager.l());
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        if (r0 != 3) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "keyword"
            kotlin.jvm.internal.Intrinsics.h(r5, r0)
            java.util.List r0 = r4.f52001e
            boolean r0 = r0.contains(r5)
            if (r0 == 0) goto L18
            java.util.List r0 = r4.f52001e
            r0.remove(r5)
            java.util.List r0 = r4.f52001e
            r0.add(r5)
            goto L47
        L18:
            int r0 = r4.f52000d
            r1 = 1
            r2 = 0
            r3 = 30
            if (r0 == r1) goto L35
            r1 = 2
            if (r0 == r1) goto L27
            r1 = 3
            if (r0 == r1) goto L35
            goto L42
        L27:
            java.util.List r0 = r4.f52001e
            int r0 = r0.size()
            if (r0 < r3) goto L42
            java.util.List r0 = r4.f52001e
            r0.remove(r2)
            goto L42
        L35:
            java.util.List r0 = r4.f52001e
            int r0 = r0.size()
            if (r0 < r3) goto L42
            java.util.List r0 = r4.f52001e
            r0.remove(r2)
        L42:
            java.util.List r0 = r4.f52001e
            r0.add(r5)
        L47:
            java.util.List r5 = r4.f52001e
            boolean r5 = r5.isEmpty()
            if (r5 == 0) goto L50
            return
        L50:
            com.transsion.search.b r5 = new com.transsion.search.b
            r5.<init>()
            r4.i(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.search.SearchManager.g(java.lang.String):void");
    }

    public final void j() {
        i(new Runnable() { // from class: com.transsion.search.e
            @Override // java.lang.Runnable
            public final void run() {
                SearchManager.k(SearchManager.this);
            }
        });
    }

    public final List l() {
        List arrayList;
        String str = null;
        if (this.f52000d == 2) {
            MMKV mmkv = this.f51997a;
            if (mmkv != null) {
                str = mmkv.getString(this.f51998b, "");
            }
        } else {
            MMKV mmkv2 = this.f51997a;
            if (mmkv2 != null) {
                str = mmkv2.getString(this.f51999c, "");
            }
        }
        a.C0856a.f(lg.a.f68962a, "VS_SM", "findSearch" + str, false, 4, null);
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "{}")) {
            arrayList = new ArrayList();
        } else {
            Object e11 = o.e(str, new TypeToken<List<String>>() { // from class: com.transsion.search.SearchManager$findSearch$list$type$1
            }.getType());
            Intrinsics.e(e11);
            arrayList = (List) e11;
        }
        arrayList.isEmpty();
        this.f52001e = arrayList;
        return arrayList;
    }

    public final void m(int i11, final com.transsion.search.a callback) {
        Intrinsics.h(callback, "callback");
        this.f52000d = i11;
        i(new Runnable() { // from class: com.transsion.search.c
            @Override // java.lang.Runnable
            public final void run() {
                SearchManager.n(SearchManager.this, callback);
            }
        });
    }
}

package com.transsion.shorttv.ad.playeroverlayad;

import androidx.view.LifecycleCoroutineScope;
import com.transsion.shorttv.ad.AdLoadState;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.t1;

/* loaded from: classes6.dex */
public final class ShortTvPlayerOverlayAdManager {

    /* renamed from: b, reason: collision with root package name */
    private static WeakReference f52771b;

    /* renamed from: d, reason: collision with root package name */
    private static t1 f52773d;

    /* renamed from: e, reason: collision with root package name */
    private static int f52774e;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f52776g;

    /* renamed from: a, reason: collision with root package name */
    public static final ShortTvPlayerOverlayAdManager f52770a = new ShortTvPlayerOverlayAdManager();

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap f52772c = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private static int f52775f = 3;

    private ShortTvPlayerOverlayAdManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        j();
    }

    private final boolean g() {
        if (f52774e < 0 || f52775f < 0) {
            return false;
        }
        int size = f52772c.size() + 1;
        if (f52776g) {
            int i11 = f52775f;
            return i11 == 0 || (size - f52774e) % (i11 + 1) == 0;
        }
        int i12 = f52774e;
        if (i12 == 0) {
            f52776g = true;
            return f52775f == 0;
        }
        if (i12 != size) {
            return false;
        }
        f52776g = true;
        return true;
    }

    private final void h() {
        WeakReference weakReference;
        LifecycleCoroutineScope lifecycleCoroutineScope;
        t1 d11;
        t1 t1Var = f52773d;
        if ((t1Var != null && t1Var.isActive()) || (weakReference = f52771b) == null || (lifecycleCoroutineScope = (LifecycleCoroutineScope) weakReference.get()) == null) {
            return;
        }
        d11 = k.d(lifecycleCoroutineScope, null, null, new ShortTvPlayerOverlayAdManager$startAutoDestroyTimer$1(null), 3, null);
        f52773d = d11;
    }

    private final void i() {
        t1 t1Var = f52773d;
        if (t1Var != null) {
            t1.a.b(t1Var, null, 1, null);
        }
        f52773d = null;
    }

    private final void j() {
        e b11;
        Collection values = f52772c.values();
        Intrinsics.g(values, "<get-values>(...)");
        for (a aVar : CollectionsKt.R0(values)) {
            if (aVar.c() == AdLoadState.SUCCEED && !aVar.e() && (b11 = aVar.b()) != null) {
                Long valueOf = Long.valueOf(b11.h());
                if (valueOf.longValue() <= 0) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    if (System.currentTimeMillis() - valueOf.longValue() >= 10000) {
                        aVar.a();
                    }
                }
            }
        }
    }

    public final void b() {
        ur.a.g(ur.a.f77012a, "overlay", "overlay ad manager clear", null, 4, null);
        Collection values = f52772c.values();
        Intrinsics.g(values, "<get-values>(...)");
        for (a aVar : CollectionsKt.R0(values)) {
            e b11 = aVar.b();
            if (b11 != null) {
                b11.f();
            }
            aVar.f(null);
        }
        f52772c.clear();
        WeakReference weakReference = f52771b;
        if (weakReference != null) {
            weakReference.clear();
        }
        f52771b = null;
        i();
        f52776g = false;
    }

    public final a c(String key) {
        LifecycleCoroutineScope lifecycleCoroutineScope;
        Intrinsics.h(key, "key");
        WeakReference weakReference = f52771b;
        if (weakReference == null || (lifecycleCoroutineScope = (LifecycleCoroutineScope) weakReference.get()) == null) {
            return null;
        }
        ur.a.g(ur.a.f77012a, "overlay", "getAdData, key=" + key + ", currentVideoCount=" + f52772c.size(), null, 4, null);
        a aVar = (a) f52772c.get(key);
        if (aVar == null) {
            aVar = new a();
            aVar.h(false);
            if (f52770a.g()) {
                aVar.f(new e("ShortTvPlayerOverlayScene", lifecycleCoroutineScope));
                aVar.h(true);
            }
            f52772c.put(key, aVar);
        }
        return aVar;
    }

    public final void d(LifecycleCoroutineScope scope) {
        Intrinsics.h(scope, "scope");
        f52771b = new WeakReference(scope);
        h();
        com.transsion.ad.scene.a aVar = com.transsion.ad.scene.a.f42255a;
        f52774e = aVar.o("ShortTvPlayerOverlayScene", 0);
        f52775f = aVar.q("ShortTvPlayerOverlayScene", 3);
    }

    public final void e(String key) {
        e b11;
        Intrinsics.h(key, "key");
        a aVar = (a) f52772c.get(key);
        if (aVar != null && (b11 = aVar.b()) != null) {
            b11.j();
        }
        a aVar2 = (a) f52772c.get(key);
        if (aVar2 != null) {
            aVar2.i(false);
        }
    }
}

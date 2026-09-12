package qm;

import android.os.Bundle;
import android.os.SystemClock;
import androidx.collection.s;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f73767a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f73768b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private static final ConcurrentHashMap f73769c = new ConcurrentHashMap();

    private e() {
    }

    public final List a(int i11) {
        return (List) f73768b.remove(Integer.valueOf(i11));
    }

    public final int b(List preloadList) {
        ConcurrentHashMap concurrentHashMap;
        Intrinsics.h(preloadList, "preloadList");
        int hashCode = preloadList.hashCode();
        while (true) {
            concurrentHashMap = f73768b;
            if (!concurrentHashMap.containsKey(Integer.valueOf(hashCode))) {
                break;
            }
            hashCode = (hashCode << 1) | s.a(SystemClock.elapsedRealtimeNanos());
        }
        concurrentHashMap.put(Integer.valueOf(hashCode), preloadList);
        Iterator it = preloadList.iterator();
        while (it.hasNext()) {
            b.g((b) it.next(), null, 1, null);
        }
        return hashCode;
    }

    public final int c(b... preload) {
        Intrinsics.h(preload, "preload");
        return b(ArraysKt.K0(preload));
    }

    public final void d(String str, Bundle bundle) {
        List a11;
        c cVar = (c) f73769c.get(str);
        if (cVar == null || (a11 = cVar.a(str, bundle)) == null) {
            return;
        }
        int b11 = f73767a.b(a11);
        if (bundle != null) {
            bundle.putInt("yy_preload_id", b11);
        }
    }

    public final void e(c interceptor) {
        Intrinsics.h(interceptor, "interceptor");
        a.C0856a.f(lg.a.f68962a, "IPreload", "regInterceptor", false, 4, null);
        f73769c.put(interceptor.getPath(), interceptor);
    }
}

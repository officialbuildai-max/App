package com.therouter.history;

import com.therouter.TheRouterThreadPool;
import com.therouter.inject.RecyclerLruCache;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class HistoryRecorder {

    /* renamed from: a, reason: collision with root package name */
    private static long f40786a = 0;

    /* renamed from: b, reason: collision with root package name */
    private static int f40787b = 30;

    /* renamed from: c, reason: collision with root package name */
    private static final RecyclerLruCache f40788c;

    /* renamed from: d, reason: collision with root package name */
    private static final WeakHashMap f40789d;

    static {
        RecyclerLruCache recyclerLruCache = new RecyclerLruCache(f40787b);
        recyclerLruCache.a(new Function3<String, d, d, Unit>() { // from class: com.therouter.history.HistoryRecorder$mCacher$1$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((String) obj, (d) obj2, (d) obj3);
                return Unit.f67184a;
            }

            public final void invoke(String str, d dVar, d dVar2) {
                WeakHashMap weakHashMap;
                weakHashMap = HistoryRecorder.f40789d;
                weakHashMap.put(str, dVar);
            }
        });
        f40788c = recyclerLruCache;
        f40789d = new WeakHashMap();
    }

    public static final boolean c(final d event) {
        Intrinsics.h(event, "event");
        return TheRouterThreadPool.g(new Runnable() { // from class: com.therouter.history.e
            @Override // java.lang.Runnable
            public final void run() {
                HistoryRecorder.d(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(d event) {
        Intrinsics.h(event, "$event");
        RecyclerLruCache recyclerLruCache = f40788c;
        long j11 = f40786a;
        f40786a = 1 + j11;
        recyclerLruCache.put(String.valueOf(j11), event);
    }
}

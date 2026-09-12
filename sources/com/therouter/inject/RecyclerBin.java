package com.therouter.inject;

import java.util.Arrays;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class RecyclerBin {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap f40799a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final RecyclerLruCache f40800b;

    /* renamed from: c, reason: collision with root package name */
    private final WeakHashMap f40801c;

    public RecyclerBin() {
        RecyclerLruCache recyclerLruCache = new RecyclerLruCache(10);
        recyclerLruCache.a(new Function3<a, Object, Object, Unit>() { // from class: com.therouter.inject.RecyclerBin$mCacher$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                invoke((a) obj, obj2, obj3);
                return Unit.f67184a;
            }

            public final void invoke(a aVar, Object obj, Object obj2) {
                WeakHashMap weakHashMap;
                WeakHashMap weakHashMap2;
                weakHashMap = RecyclerBin.this.f40801c;
                RecyclerBin recyclerBin = RecyclerBin.this;
                synchronized (weakHashMap) {
                    weakHashMap2 = recyclerBin.f40801c;
                    weakHashMap2.put(aVar, obj);
                    Unit unit = Unit.f67184a;
                }
            }
        });
        this.f40800b = recyclerLruCache;
        this.f40801c = new WeakHashMap();
    }

    public final Object b(Class clazz, Object... params) {
        Object remove;
        Intrinsics.h(clazz, "clazz");
        Intrinsics.h(params, "params");
        a aVar = new a(clazz, Arrays.copyOf(params, params.length));
        Object obj = this.f40799a.get(aVar);
        if (obj != null) {
            return obj;
        }
        Object obj2 = this.f40800b.get(aVar);
        if (obj2 != null) {
            return obj2;
        }
        synchronized (this.f40801c) {
            remove = this.f40801c.remove(aVar);
            Unit unit = Unit.f67184a;
        }
        if (remove != null) {
            this.f40800b.put(aVar, remove);
        }
        return remove;
    }

    public final void c(Class clazz, Object obj, Object... params) {
        Intrinsics.h(clazz, "clazz");
        Intrinsics.h(params, "params");
        a aVar = new a(clazz, Arrays.copyOf(params, params.length));
        if (clazz.isAnnotationPresent(Singleton.class)) {
            if (obj != null) {
                this.f40799a.put(aVar, obj);
            }
        } else {
            if (clazz.isAnnotationPresent(NewInstance.class)) {
                return;
            }
            this.f40800b.put(aVar, obj);
        }
    }
}

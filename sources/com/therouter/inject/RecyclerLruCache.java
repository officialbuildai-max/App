package com.therouter.inject;

import android.util.LruCache;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class RecyclerLruCache extends LruCache {

    /* renamed from: a, reason: collision with root package name */
    private Function3 f40802a;

    public RecyclerLruCache(int i11) {
        super(i11);
        this.f40802a = new Function3<Object, Object, Object, Unit>() { // from class: com.therouter.inject.RecyclerLruCache$mListener$1
            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                m853invoke(obj, obj2, obj3);
                return Unit.f67184a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m853invoke(Object obj, Object obj2, Object obj3) {
            }
        };
    }

    public final void a(Function3 block) {
        Intrinsics.h(block, "block");
        this.f40802a = block;
    }

    @Override // android.util.LruCache
    protected void entryRemoved(boolean z10, Object obj, Object obj2, Object obj3) {
        super.entryRemoved(z10, obj, obj2, obj3);
        this.f40802a.invoke(obj, obj2, obj3);
    }
}

package com.transsion.ad.strategy;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final f f42286a = new f();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f42287b = LazyKt.b(new Function0() { // from class: com.transsion.ad.strategy.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV d11;
            d11 = f.d();
            return d11;
        }
    });

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("one_room_advertising");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return c();
    }

    public final MMKV c() {
        return (MMKV) f42287b.getValue();
    }
}

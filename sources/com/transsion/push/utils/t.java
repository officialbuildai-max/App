package com.transsion.push.utils;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f50998a = new t();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f50999b = LazyKt.b(new Function0() { // from class: com.transsion.push.utils.s
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = t.c();
            return c11;
        }
    });

    private t() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("notification");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return (MMKV) f50999b.getValue();
    }
}

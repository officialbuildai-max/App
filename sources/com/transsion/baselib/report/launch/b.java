package com.transsion.baselib.report.launch;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f43424a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f43425b = LazyKt.b(new Function0() { // from class: com.transsion.baselib.report.launch.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = b.c();
            return c11;
        }
    });

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV I = MMKV.I("kv_app");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final MMKV b() {
        return (MMKV) f43425b.getValue();
    }
}

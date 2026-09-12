package com.transsion.member;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    public static final c0 f46483a = new c0();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f46484b = LazyKt.b(new Function0() { // from class: com.transsion.member.b0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = c0.c();
            return c11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static final int f46485c = 8;

    private c0() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        return MMKV.I("member_kv");
    }

    public final MMKV b() {
        return (MMKV) f46484b.getValue();
    }
}

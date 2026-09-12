package com.transsion.rewardscenter.utils;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f51349a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f51350b = LazyKt.b(new Function0() { // from class: com.transsion.rewardscenter.utils.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV f11;
            f11 = b.f();
            return f11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    public static final int f51351c = 8;

    private b() {
    }

    private final MMKV b() {
        return (MMKV) f51350b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV f() {
        return MMKV.I("RewardsCenterCache");
    }

    public final String c() {
        String k11 = b().k("phone_cc");
        return k11 == null ? "" : k11;
    }

    public final String d() {
        String k11 = b().k("phone_iso");
        return k11 == null ? "" : k11;
    }

    public final String e() {
        String k11 = b().k("phone_number");
        return k11 == null ? "" : k11;
    }

    public final void g(String cc2, String iso, String number) {
        Intrinsics.h(cc2, "cc");
        Intrinsics.h(iso, "iso");
        Intrinsics.h(number, "number");
        b().putString("phone_cc", cc2);
        b().putString("phone_iso", iso);
        b().putString("phone_number", number);
    }
}

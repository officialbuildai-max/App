package com.transsnet.downloader.util;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public static final f0 f60058a = new f0();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f60059b = LazyKt.b(new Function0() { // from class: com.transsnet.downloader.util.e0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV d11;
            d11 = f0.d();
            return d11;
        }
    });

    private f0() {
    }

    private final MMKV b() {
        return (MMKV) f60059b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("transfer_tips");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final boolean c() {
        return b().getBoolean("key_transfer_tips_dialog_show", false);
    }

    public final void e(boolean z10) {
        b().putBoolean("key_transfer_tips_dialog_show", z10);
    }
}

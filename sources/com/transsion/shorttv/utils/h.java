package com.transsion.shorttv.utils;

import androidx.view.b0;
import com.cloud.tmc.kernel.constants.TmcConstants;
import com.tencent.mmkv.MMKV;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public static final h f53707a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f53708b = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.utils.f
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV g11;
            g11 = h.g();
            return g11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f53709c = LazyKt.b(new Function0() { // from class: com.transsion.shorttv.utils.g
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV h11;
            h11 = h.h();
            return h11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final int f53710d = 20;

    /* renamed from: e, reason: collision with root package name */
    private static final int f53711e = 3;

    /* renamed from: f, reason: collision with root package name */
    private static CopyOnWriteArrayList f53712f = new CopyOnWriteArrayList();

    /* renamed from: g, reason: collision with root package name */
    private static final b0 f53713g = new b0();

    private h() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV g() {
        MMKV I = MMKV.I("short_tv");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV h() {
        MMKV I = MMKV.I("kv_app");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final boolean c() {
        return System.currentTimeMillis() - d().getLong("k_download_guide_bubble_last_show_time", 0L) >= TmcConstants.MINIAPP_TIME_DIFF;
    }

    public final MMKV d() {
        return (MMKV) f53708b.getValue();
    }

    public final MMKV e() {
        return (MMKV) f53709c.getValue();
    }

    public final void f() {
        d().putLong("k_download_guide_bubble_last_show_time", System.currentTimeMillis());
    }
}

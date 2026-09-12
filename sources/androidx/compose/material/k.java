package androidx.compose.material;

import androidx.compose.ui.graphics.u1;
import androidx.compose.ui.graphics.w1;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public static final k f3493a = new k();

    /* renamed from: b, reason: collision with root package name */
    public static final int f3494b = 0;

    private k() {
    }

    public final j a(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, androidx.compose.runtime.i iVar, int i11, int i12, int i13) {
        long j21;
        long j22;
        long h11 = (i13 & 1) != 0 ? e.f3484a.a(iVar, 6).h() : j11;
        if ((i13 & 2) != 0) {
            e eVar = e.f3484a;
            j21 = w1.h(u1.k(eVar.a(iVar, 6).g(), c.f3473a.b(iVar, 6), 0.0f, 0.0f, 0.0f, 14, null), eVar.a(iVar, 6).l());
        } else {
            j21 = j12;
        }
        long h12 = (i13 & 4) != 0 ? e.f3484a.a(iVar, 6).h() : j13;
        long k11 = (i13 & 8) != 0 ? u1.k(h12, 0.24f, 0.0f, 0.0f, 0.0f, 14, null) : j14;
        long k12 = (i13 & 16) != 0 ? u1.k(e.f3484a.a(iVar, 6).g(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long k13 = (i13 & 32) != 0 ? u1.k(k12, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long k14 = (i13 & 64) != 0 ? u1.k(ColorsKt.b(h12, iVar, (i11 >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long k15 = (i13 & 128) != 0 ? u1.k(h12, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j18;
        long k16 = (i13 & 256) != 0 ? u1.k(k14, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long k17 = (i13 & 512) != 0 ? u1.k(k13, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j20;
        if (androidx.compose.runtime.k.H()) {
            j22 = k14;
            androidx.compose.runtime.k.Q(436017687, i11, i12, "androidx.compose.material.SliderDefaults.colors (Slider.kt:500)");
        } else {
            j22 = k14;
        }
        d dVar = new d(h11, j21, h12, k11, k12, k13, j22, k15, k16, k17, null);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        return dVar;
    }
}

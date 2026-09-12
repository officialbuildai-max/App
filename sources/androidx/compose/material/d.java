package androidx.compose.material;

import androidx.compose.runtime.a3;
import androidx.compose.runtime.r2;
import androidx.compose.ui.graphics.u1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d implements j {

    /* renamed from: a, reason: collision with root package name */
    private final long f3474a;

    /* renamed from: b, reason: collision with root package name */
    private final long f3475b;

    /* renamed from: c, reason: collision with root package name */
    private final long f3476c;

    /* renamed from: d, reason: collision with root package name */
    private final long f3477d;

    /* renamed from: e, reason: collision with root package name */
    private final long f3478e;

    /* renamed from: f, reason: collision with root package name */
    private final long f3479f;

    /* renamed from: g, reason: collision with root package name */
    private final long f3480g;

    /* renamed from: h, reason: collision with root package name */
    private final long f3481h;

    /* renamed from: i, reason: collision with root package name */
    private final long f3482i;

    /* renamed from: j, reason: collision with root package name */
    private final long f3483j;

    private d(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20) {
        this.f3474a = j11;
        this.f3475b = j12;
        this.f3476c = j13;
        this.f3477d = j14;
        this.f3478e = j15;
        this.f3479f = j16;
        this.f3480g = j17;
        this.f3481h = j18;
        this.f3482i = j19;
        this.f3483j = j20;
    }

    public /* synthetic */ d(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, j13, j14, j15, j16, j17, j18, j19, j20);
    }

    @Override // androidx.compose.material.j
    public a3 a(boolean z10, boolean z11, androidx.compose.runtime.i iVar, int i11) {
        iVar.P(-1491563694);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-1491563694, i11, -1, "androidx.compose.material.DefaultSliderColors.tickColor (Slider.kt:1111)");
        }
        a3 i12 = r2.i(u1.g(z10 ? z11 ? this.f3480g : this.f3481h : z11 ? this.f3482i : this.f3483j), iVar, 0);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        iVar.K();
        return i12;
    }

    @Override // androidx.compose.material.j
    public a3 b(boolean z10, boolean z11, androidx.compose.runtime.i iVar, int i11) {
        iVar.P(1575395620);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(1575395620, i11, -1, "androidx.compose.material.DefaultSliderColors.trackColor (Slider.kt:1100)");
        }
        a3 i12 = r2.i(u1.g(z10 ? z11 ? this.f3476c : this.f3477d : z11 ? this.f3478e : this.f3479f), iVar, 0);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        iVar.K();
        return i12;
    }

    @Override // androidx.compose.material.j
    public a3 c(boolean z10, androidx.compose.runtime.i iVar, int i11) {
        iVar.P(-1733795637);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.Q(-1733795637, i11, -1, "androidx.compose.material.DefaultSliderColors.thumbColor (Slider.kt:1095)");
        }
        a3 i12 = r2.i(u1.g(z10 ? this.f3474a : this.f3475b), iVar, 0);
        if (androidx.compose.runtime.k.H()) {
            androidx.compose.runtime.k.P();
        }
        iVar.K();
        return i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        return u1.m(this.f3474a, dVar.f3474a) && u1.m(this.f3475b, dVar.f3475b) && u1.m(this.f3476c, dVar.f3476c) && u1.m(this.f3477d, dVar.f3477d) && u1.m(this.f3478e, dVar.f3478e) && u1.m(this.f3479f, dVar.f3479f) && u1.m(this.f3480g, dVar.f3480g) && u1.m(this.f3481h, dVar.f3481h) && u1.m(this.f3482i, dVar.f3482i) && u1.m(this.f3483j, dVar.f3483j);
    }

    public int hashCode() {
        return (((((((((((((((((u1.s(this.f3474a) * 31) + u1.s(this.f3475b)) * 31) + u1.s(this.f3476c)) * 31) + u1.s(this.f3477d)) * 31) + u1.s(this.f3478e)) * 31) + u1.s(this.f3479f)) * 31) + u1.s(this.f3480g)) * 31) + u1.s(this.f3481h)) * 31) + u1.s(this.f3482i)) * 31) + u1.s(this.f3483j);
    }
}

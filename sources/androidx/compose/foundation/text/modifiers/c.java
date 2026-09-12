package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.l;
import androidx.compose.ui.text.q;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: h, reason: collision with root package name */
    public static final a f3350h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    public static final int f3351i = 8;

    /* renamed from: j, reason: collision with root package name */
    private static c f3352j;

    /* renamed from: a, reason: collision with root package name */
    private final LayoutDirection f3353a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f3354b;

    /* renamed from: c, reason: collision with root package name */
    private final o0.e f3355c;

    /* renamed from: d, reason: collision with root package name */
    private final h.b f3356d;

    /* renamed from: e, reason: collision with root package name */
    private final d0 f3357e;

    /* renamed from: f, reason: collision with root package name */
    private float f3358f;

    /* renamed from: g, reason: collision with root package name */
    private float f3359g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a(c cVar, LayoutDirection layoutDirection, d0 d0Var, o0.e eVar, h.b bVar) {
            if (cVar != null && layoutDirection == cVar.g() && Intrinsics.c(d0Var, cVar.f()) && eVar.getDensity() == cVar.d().getDensity() && bVar == cVar.e()) {
                return cVar;
            }
            c cVar2 = c.f3352j;
            if (cVar2 != null && layoutDirection == cVar2.g() && Intrinsics.c(d0Var, cVar2.f()) && eVar.getDensity() == cVar2.d().getDensity() && bVar == cVar2.e()) {
                return cVar2;
            }
            c cVar3 = new c(layoutDirection, e0.c(d0Var, layoutDirection), o0.g.a(eVar.getDensity(), eVar.C0()), bVar, null);
            c.f3352j = cVar3;
            return cVar3;
        }
    }

    private c(LayoutDirection layoutDirection, d0 d0Var, o0.e eVar, h.b bVar) {
        this.f3353a = layoutDirection;
        this.f3354b = d0Var;
        this.f3355c = eVar;
        this.f3356d = bVar;
        this.f3357e = e0.c(d0Var, layoutDirection);
        this.f3358f = Float.NaN;
        this.f3359g = Float.NaN;
    }

    public /* synthetic */ c(LayoutDirection layoutDirection, d0 d0Var, o0.e eVar, h.b bVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(layoutDirection, d0Var, eVar, bVar);
    }

    public final long c(long j11, int i11) {
        String str;
        l a11;
        String str2;
        l a12;
        float f11 = this.f3359g;
        float f12 = this.f3358f;
        if (Float.isNaN(f11) || Float.isNaN(f12)) {
            str = d.f3360a;
            a11 = q.a(str, this.f3357e, o0.c.b(0, 0, 0, 0, 15, null), this.f3355c, this.f3356d, (r22 & 32) != 0 ? CollectionsKt.l() : null, (r22 & 64) != 0 ? CollectionsKt.l() : null, (r22 & 128) != 0 ? Integer.MAX_VALUE : 1, (r22 & 256) != 0 ? false : false);
            f11 = a11.getHeight();
            str2 = d.f3361b;
            a12 = q.a(str2, this.f3357e, o0.c.b(0, 0, 0, 0, 15, null), this.f3355c, this.f3356d, (r22 & 32) != 0 ? CollectionsKt.l() : null, (r22 & 64) != 0 ? CollectionsKt.l() : null, (r22 & 128) != 0 ? Integer.MAX_VALUE : 2, (r22 & 256) != 0 ? false : false);
            f12 = a12.getHeight() - f11;
            this.f3359g = f11;
            this.f3358f = f12;
        }
        return o0.c.a(o0.b.n(j11), o0.b.l(j11), i11 != 1 ? RangesKt.i(RangesKt.f(Math.round(f11 + (f12 * (i11 - 1))), 0), o0.b.k(j11)) : o0.b.m(j11), o0.b.k(j11));
    }

    public final o0.e d() {
        return this.f3355c;
    }

    public final h.b e() {
        return this.f3356d;
    }

    public final d0 f() {
        return this.f3354b;
    }

    public final LayoutDirection g() {
        return this.f3353a;
    }
}

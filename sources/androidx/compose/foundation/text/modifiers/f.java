package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.modifiers.c;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.l;
import androidx.compose.ui.text.o;
import androidx.compose.ui.text.q;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.y;
import androidx.compose.ui.text.z;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.t;
import o0.u;

/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    private String f3378a;

    /* renamed from: b, reason: collision with root package name */
    private d0 f3379b;

    /* renamed from: c, reason: collision with root package name */
    private h.b f3380c;

    /* renamed from: d, reason: collision with root package name */
    private int f3381d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3382e;

    /* renamed from: f, reason: collision with root package name */
    private int f3383f;

    /* renamed from: g, reason: collision with root package name */
    private int f3384g;

    /* renamed from: h, reason: collision with root package name */
    private long f3385h;

    /* renamed from: i, reason: collision with root package name */
    private o0.e f3386i;

    /* renamed from: j, reason: collision with root package name */
    private l f3387j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f3388k;

    /* renamed from: l, reason: collision with root package name */
    private long f3389l;

    /* renamed from: m, reason: collision with root package name */
    private c f3390m;

    /* renamed from: n, reason: collision with root package name */
    private o f3391n;

    /* renamed from: o, reason: collision with root package name */
    private LayoutDirection f3392o;

    /* renamed from: p, reason: collision with root package name */
    private long f3393p;

    /* renamed from: q, reason: collision with root package name */
    private int f3394q;

    /* renamed from: r, reason: collision with root package name */
    private int f3395r;

    private f(String str, d0 d0Var, h.b bVar, int i11, boolean z10, int i12, int i13) {
        this.f3378a = str;
        this.f3379b = d0Var;
        this.f3380c = bVar;
        this.f3381d = i11;
        this.f3382e = z10;
        this.f3383f = i12;
        this.f3384g = i13;
        this.f3385h = a.f3348a.a();
        this.f3389l = u.a(0, 0);
        this.f3393p = o0.b.f70719b.c(0, 0);
        this.f3394q = -1;
        this.f3395r = -1;
    }

    public /* synthetic */ f(String str, d0 d0Var, h.b bVar, int i11, boolean z10, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, d0Var, bVar, i11, z10, i12, i13);
    }

    private final l f(long j11, LayoutDirection layoutDirection) {
        o k11 = k(layoutDirection);
        return q.c(k11, b.a(j11, this.f3382e, this.f3381d, k11.a()), b.b(this.f3382e, this.f3381d, this.f3383f), p.e(this.f3381d, p.f6517a.b()));
    }

    private final void h() {
        this.f3387j = null;
        this.f3391n = null;
        this.f3392o = null;
        this.f3394q = -1;
        this.f3395r = -1;
        this.f3393p = o0.b.f70719b.c(0, 0);
        this.f3389l = u.a(0, 0);
        this.f3388k = false;
    }

    private final boolean i(long j11, LayoutDirection layoutDirection) {
        o oVar;
        l lVar = this.f3387j;
        if (lVar == null || (oVar = this.f3391n) == null || oVar.b() || layoutDirection != this.f3392o) {
            return true;
        }
        if (o0.b.f(j11, this.f3393p)) {
            return false;
        }
        return o0.b.l(j11) != o0.b.l(this.f3393p) || ((float) o0.b.k(j11)) < lVar.getHeight() || lVar.k();
    }

    private final o k(LayoutDirection layoutDirection) {
        o oVar = this.f3391n;
        if (oVar == null || layoutDirection != this.f3392o || oVar.b()) {
            this.f3392o = layoutDirection;
            String str = this.f3378a;
            d0 c11 = e0.c(this.f3379b, layoutDirection);
            o0.e eVar = this.f3386i;
            Intrinsics.e(eVar);
            oVar = androidx.compose.ui.text.p.b(str, c11, null, null, eVar, this.f3380c, 12, null);
        }
        this.f3391n = oVar;
        return oVar;
    }

    public final o0.e a() {
        return this.f3386i;
    }

    public final boolean b() {
        return this.f3388k;
    }

    public final long c() {
        return this.f3389l;
    }

    public final Unit d() {
        o oVar = this.f3391n;
        if (oVar != null) {
            oVar.b();
        }
        return Unit.f67184a;
    }

    public final l e() {
        return this.f3387j;
    }

    public final boolean g(long j11, LayoutDirection layoutDirection) {
        boolean z10 = true;
        if (this.f3384g > 1) {
            c.a aVar = c.f3350h;
            c cVar = this.f3390m;
            d0 d0Var = this.f3379b;
            o0.e eVar = this.f3386i;
            Intrinsics.e(eVar);
            c a11 = aVar.a(cVar, layoutDirection, d0Var, eVar, this.f3380c);
            this.f3390m = a11;
            j11 = a11.c(j11, this.f3384g);
        }
        boolean z11 = false;
        if (i(j11, layoutDirection)) {
            l f11 = f(j11, layoutDirection);
            this.f3393p = j11;
            this.f3389l = o0.c.f(j11, u.a(androidx.compose.foundation.text.b.a(f11.getWidth()), androidx.compose.foundation.text.b.a(f11.getHeight())));
            if (!p.e(this.f3381d, p.f6517a.c()) && (t.g(r9) < f11.getWidth() || t.f(r9) < f11.getHeight())) {
                z11 = true;
            }
            this.f3388k = z11;
            this.f3387j = f11;
            return true;
        }
        if (!o0.b.f(j11, this.f3393p)) {
            l lVar = this.f3387j;
            Intrinsics.e(lVar);
            this.f3389l = o0.c.f(j11, u.a(androidx.compose.foundation.text.b.a(Math.min(lVar.a(), lVar.getWidth())), androidx.compose.foundation.text.b.a(lVar.getHeight())));
            if (p.e(this.f3381d, p.f6517a.c()) || (t.g(r3) >= lVar.getWidth() && t.f(r3) >= lVar.getHeight())) {
                z10 = false;
            }
            this.f3388k = z10;
            this.f3393p = j11;
        }
        return false;
    }

    public final void j(o0.e eVar) {
        o0.e eVar2 = this.f3386i;
        long d11 = eVar != null ? a.d(eVar) : a.f3348a.a();
        if (eVar2 == null) {
            this.f3386i = eVar;
            this.f3385h = d11;
        } else if (eVar == null || !a.e(this.f3385h, d11)) {
            this.f3386i = eVar;
            this.f3385h = d11;
            h();
        }
    }

    public final z l(d0 d0Var) {
        o0.e eVar;
        LayoutDirection layoutDirection = this.f3392o;
        if (layoutDirection == null || (eVar = this.f3386i) == null) {
            return null;
        }
        AnnotatedString annotatedString = new AnnotatedString(this.f3378a, null, null, 6, null);
        if (this.f3387j == null || this.f3391n == null) {
            return null;
        }
        long d11 = o0.b.d(this.f3393p, 0, 0, 0, 0, 10, null);
        return new z(new y(annotatedString, d0Var, CollectionsKt.l(), this.f3383f, this.f3382e, this.f3381d, eVar, layoutDirection, this.f3380c, d11, (DefaultConstructorMarker) null), new MultiParagraph(new MultiParagraphIntrinsics(annotatedString, d0Var, CollectionsKt.l(), eVar, this.f3380c), d11, this.f3383f, p.e(this.f3381d, p.f6517a.b()), null), this.f3389l, null);
    }

    public final void m(String str, d0 d0Var, h.b bVar, int i11, boolean z10, int i12, int i13) {
        this.f3378a = str;
        this.f3379b = d0Var;
        this.f3380c = bVar;
        this.f3381d = i11;
        this.f3382e = z10;
        this.f3383f = i12;
        this.f3384g = i13;
        h();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ParagraphLayoutCache(paragraph=");
        sb2.append(this.f3387j != null ? "<paragraph>" : "null");
        sb2.append(", lastDensity=");
        sb2.append((Object) a.h(this.f3385h));
        sb2.append(')');
        return sb2.toString();
    }
}

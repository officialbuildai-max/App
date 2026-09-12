package androidx.compose.foundation.text.modifiers;

import androidx.compose.foundation.text.modifiers.c;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.MultiParagraph;
import androidx.compose.ui.text.MultiParagraphIntrinsics;
import androidx.compose.ui.text.d0;
import androidx.compose.ui.text.e0;
import androidx.compose.ui.text.font.h;
import androidx.compose.ui.text.style.p;
import androidx.compose.ui.text.y;
import androidx.compose.ui.text.z;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.u;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private AnnotatedString f3362a;

    /* renamed from: b, reason: collision with root package name */
    private d0 f3363b;

    /* renamed from: c, reason: collision with root package name */
    private h.b f3364c;

    /* renamed from: d, reason: collision with root package name */
    private int f3365d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f3366e;

    /* renamed from: f, reason: collision with root package name */
    private int f3367f;

    /* renamed from: g, reason: collision with root package name */
    private int f3368g;

    /* renamed from: h, reason: collision with root package name */
    private List f3369h;

    /* renamed from: i, reason: collision with root package name */
    private c f3370i;

    /* renamed from: j, reason: collision with root package name */
    private long f3371j;

    /* renamed from: k, reason: collision with root package name */
    private o0.e f3372k;

    /* renamed from: l, reason: collision with root package name */
    private MultiParagraphIntrinsics f3373l;

    /* renamed from: m, reason: collision with root package name */
    private LayoutDirection f3374m;

    /* renamed from: n, reason: collision with root package name */
    private z f3375n;

    /* renamed from: o, reason: collision with root package name */
    private int f3376o;

    /* renamed from: p, reason: collision with root package name */
    private int f3377p;

    private e(AnnotatedString annotatedString, d0 d0Var, h.b bVar, int i11, boolean z10, int i12, int i13, List list) {
        this.f3362a = annotatedString;
        this.f3363b = d0Var;
        this.f3364c = bVar;
        this.f3365d = i11;
        this.f3366e = z10;
        this.f3367f = i12;
        this.f3368g = i13;
        this.f3369h = list;
        this.f3371j = a.f3348a.a();
        this.f3376o = -1;
        this.f3377p = -1;
    }

    public /* synthetic */ e(AnnotatedString annotatedString, d0 d0Var, h.b bVar, int i11, boolean z10, int i12, int i13, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, d0Var, bVar, i11, z10, i12, i13, list);
    }

    private final MultiParagraph d(long j11, LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics i11 = i(layoutDirection);
        return new MultiParagraph(i11, b.a(j11, this.f3366e, this.f3365d, i11.a()), b.b(this.f3366e, this.f3365d, this.f3367f), p.e(this.f3365d, p.f6517a.b()), null);
    }

    private final void f() {
        this.f3373l = null;
        this.f3375n = null;
        this.f3377p = -1;
        this.f3376o = -1;
    }

    private final boolean g(z zVar, long j11, LayoutDirection layoutDirection) {
        if (zVar == null || zVar.v().i().b() || layoutDirection != zVar.k().d()) {
            return true;
        }
        if (o0.b.f(j11, zVar.k().a())) {
            return false;
        }
        return o0.b.l(j11) != o0.b.l(zVar.k().a()) || ((float) o0.b.k(j11)) < zVar.v().h() || zVar.v().f();
    }

    private final MultiParagraphIntrinsics i(LayoutDirection layoutDirection) {
        MultiParagraphIntrinsics multiParagraphIntrinsics = this.f3373l;
        if (multiParagraphIntrinsics == null || layoutDirection != this.f3374m || multiParagraphIntrinsics.b()) {
            this.f3374m = layoutDirection;
            AnnotatedString annotatedString = this.f3362a;
            d0 c11 = e0.c(this.f3363b, layoutDirection);
            o0.e eVar = this.f3372k;
            Intrinsics.e(eVar);
            h.b bVar = this.f3364c;
            List list = this.f3369h;
            if (list == null) {
                list = CollectionsKt.l();
            }
            multiParagraphIntrinsics = new MultiParagraphIntrinsics(annotatedString, c11, list, eVar, bVar);
        }
        this.f3373l = multiParagraphIntrinsics;
        return multiParagraphIntrinsics;
    }

    private final z j(LayoutDirection layoutDirection, long j11, MultiParagraph multiParagraph) {
        float min = Math.min(multiParagraph.i().a(), multiParagraph.w());
        AnnotatedString annotatedString = this.f3362a;
        d0 d0Var = this.f3363b;
        List list = this.f3369h;
        if (list == null) {
            list = CollectionsKt.l();
        }
        List list2 = list;
        int i11 = this.f3367f;
        boolean z10 = this.f3366e;
        int i12 = this.f3365d;
        o0.e eVar = this.f3372k;
        Intrinsics.e(eVar);
        return new z(new y(annotatedString, d0Var, list2, i11, z10, i12, eVar, layoutDirection, this.f3364c, j11, (DefaultConstructorMarker) null), multiParagraph, o0.c.f(j11, u.a(androidx.compose.foundation.text.b.a(min), androidx.compose.foundation.text.b.a(multiParagraph.h()))), null);
    }

    public final o0.e a() {
        return this.f3372k;
    }

    public final z b() {
        return this.f3375n;
    }

    public final z c() {
        z zVar = this.f3375n;
        if (zVar != null) {
            return zVar;
        }
        throw new IllegalStateException("You must call layoutWithConstraints first");
    }

    public final boolean e(long j11, LayoutDirection layoutDirection) {
        if (this.f3368g > 1) {
            c.a aVar = c.f3350h;
            c cVar = this.f3370i;
            d0 d0Var = this.f3363b;
            o0.e eVar = this.f3372k;
            Intrinsics.e(eVar);
            c a11 = aVar.a(cVar, layoutDirection, d0Var, eVar, this.f3364c);
            this.f3370i = a11;
            j11 = a11.c(j11, this.f3368g);
        }
        if (g(this.f3375n, j11, layoutDirection)) {
            this.f3375n = j(layoutDirection, j11, d(j11, layoutDirection));
            return true;
        }
        z zVar = this.f3375n;
        Intrinsics.e(zVar);
        if (o0.b.f(j11, zVar.k().a())) {
            return false;
        }
        z zVar2 = this.f3375n;
        Intrinsics.e(zVar2);
        this.f3375n = j(layoutDirection, j11, zVar2.v());
        return true;
    }

    public final void h(o0.e eVar) {
        o0.e eVar2 = this.f3372k;
        long d11 = eVar != null ? a.d(eVar) : a.f3348a.a();
        if (eVar2 == null) {
            this.f3372k = eVar;
            this.f3371j = d11;
        } else if (eVar == null || !a.e(this.f3371j, d11)) {
            this.f3372k = eVar;
            this.f3371j = d11;
            f();
        }
    }

    public final void k(AnnotatedString annotatedString, d0 d0Var, h.b bVar, int i11, boolean z10, int i12, int i13, List list) {
        this.f3362a = annotatedString;
        this.f3363b = d0Var;
        this.f3364c = bVar;
        this.f3365d = i11;
        this.f3366e = z10;
        this.f3367f = i12;
        this.f3368g = i13;
        this.f3369h = list;
        f();
    }
}

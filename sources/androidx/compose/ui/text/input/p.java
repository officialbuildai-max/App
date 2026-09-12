package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: h, reason: collision with root package name */
    public static final a f6326h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final p f6327i = new p(false, 0, false, 0, 0, null, null, 127, null);

    /* renamed from: a, reason: collision with root package name */
    private final boolean f6328a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6329b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6330c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6331d;

    /* renamed from: e, reason: collision with root package name */
    private final int f6332e;

    /* renamed from: f, reason: collision with root package name */
    private final x f6333f;

    /* renamed from: g, reason: collision with root package name */
    private final n0.i f6334g;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p a() {
            return p.f6327i;
        }
    }

    private p(boolean z10, int i11, boolean z11, int i12, int i13, x xVar, n0.i iVar) {
        this.f6328a = z10;
        this.f6329b = i11;
        this.f6330c = z11;
        this.f6331d = i12;
        this.f6332e = i13;
        this.f6333f = xVar;
        this.f6334g = iVar;
    }

    public /* synthetic */ p(boolean z10, int i11, boolean z11, int i12, int i13, x xVar, n0.i iVar, int i14, DefaultConstructorMarker defaultConstructorMarker) {
        this((i14 & 1) != 0 ? false : z10, (i14 & 2) != 0 ? t.f6335a.b() : i11, (i14 & 4) != 0 ? true : z11, (i14 & 8) != 0 ? u.f6341a.h() : i12, (i14 & 16) != 0 ? o.f6315b.a() : i13, (i14 & 32) != 0 ? null : xVar, (i14 & 64) != 0 ? n0.i.f70184c.b() : iVar, null);
    }

    public /* synthetic */ p(boolean z10, int i11, boolean z11, int i12, int i13, x xVar, n0.i iVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(z10, i11, z11, i12, i13, xVar, iVar);
    }

    public final boolean b() {
        return this.f6330c;
    }

    public final int c() {
        return this.f6329b;
    }

    public final int d() {
        return this.f6332e;
    }

    public final int e() {
        return this.f6331d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.f6328a == pVar.f6328a && t.f(this.f6329b, pVar.f6329b) && this.f6330c == pVar.f6330c && u.k(this.f6331d, pVar.f6331d) && o.l(this.f6332e, pVar.f6332e) && Intrinsics.c(this.f6333f, pVar.f6333f) && Intrinsics.c(this.f6334g, pVar.f6334g);
    }

    public final x f() {
        return this.f6333f;
    }

    public final boolean g() {
        return this.f6328a;
    }

    public int hashCode() {
        int a11 = ((((((((androidx.compose.foundation.e.a(this.f6328a) * 31) + t.g(this.f6329b)) * 31) + androidx.compose.foundation.e.a(this.f6330c)) * 31) + u.l(this.f6331d)) * 31) + o.m(this.f6332e)) * 31;
        x xVar = this.f6333f;
        return ((a11 + (xVar != null ? xVar.hashCode() : 0)) * 31) + this.f6334g.hashCode();
    }

    public String toString() {
        return "ImeOptions(singleLine=" + this.f6328a + ", capitalization=" + ((Object) t.h(this.f6329b)) + ", autoCorrect=" + this.f6330c + ", keyboardType=" + ((Object) u.m(this.f6331d)) + ", imeAction=" + ((Object) o.n(this.f6332e)) + ", platformImeOptions=" + this.f6333f + ", hintLocales=" + this.f6334g + ')';
    }
}

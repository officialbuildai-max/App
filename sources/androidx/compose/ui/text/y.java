package androidx.compose.ui.text;

import androidx.compose.ui.text.font.h;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    private final AnnotatedString f6545a;

    /* renamed from: b, reason: collision with root package name */
    private final d0 f6546b;

    /* renamed from: c, reason: collision with root package name */
    private final List f6547c;

    /* renamed from: d, reason: collision with root package name */
    private final int f6548d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f6549e;

    /* renamed from: f, reason: collision with root package name */
    private final int f6550f;

    /* renamed from: g, reason: collision with root package name */
    private final o0.e f6551g;

    /* renamed from: h, reason: collision with root package name */
    private final LayoutDirection f6552h;

    /* renamed from: i, reason: collision with root package name */
    private final h.b f6553i;

    /* renamed from: j, reason: collision with root package name */
    private final long f6554j;

    /* renamed from: k, reason: collision with root package name */
    private androidx.compose.ui.text.font.g f6555k;

    private y(AnnotatedString annotatedString, d0 d0Var, List list, int i11, boolean z10, int i12, o0.e eVar, LayoutDirection layoutDirection, androidx.compose.ui.text.font.g gVar, h.b bVar, long j11) {
        this.f6545a = annotatedString;
        this.f6546b = d0Var;
        this.f6547c = list;
        this.f6548d = i11;
        this.f6549e = z10;
        this.f6550f = i12;
        this.f6551g = eVar;
        this.f6552h = layoutDirection;
        this.f6553i = bVar;
        this.f6554j = j11;
        this.f6555k = gVar;
    }

    private y(AnnotatedString annotatedString, d0 d0Var, List list, int i11, boolean z10, int i12, o0.e eVar, LayoutDirection layoutDirection, h.b bVar, long j11) {
        this(annotatedString, d0Var, list, i11, z10, i12, eVar, layoutDirection, (androidx.compose.ui.text.font.g) null, bVar, j11);
    }

    public /* synthetic */ y(AnnotatedString annotatedString, d0 d0Var, List list, int i11, boolean z10, int i12, o0.e eVar, LayoutDirection layoutDirection, h.b bVar, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(annotatedString, d0Var, list, i11, z10, i12, eVar, layoutDirection, bVar, j11);
    }

    public final long a() {
        return this.f6554j;
    }

    public final o0.e b() {
        return this.f6551g;
    }

    public final h.b c() {
        return this.f6553i;
    }

    public final LayoutDirection d() {
        return this.f6552h;
    }

    public final int e() {
        return this.f6548d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        return Intrinsics.c(this.f6545a, yVar.f6545a) && Intrinsics.c(this.f6546b, yVar.f6546b) && Intrinsics.c(this.f6547c, yVar.f6547c) && this.f6548d == yVar.f6548d && this.f6549e == yVar.f6549e && androidx.compose.ui.text.style.p.e(this.f6550f, yVar.f6550f) && Intrinsics.c(this.f6551g, yVar.f6551g) && this.f6552h == yVar.f6552h && Intrinsics.c(this.f6553i, yVar.f6553i) && o0.b.f(this.f6554j, yVar.f6554j);
    }

    public final int f() {
        return this.f6550f;
    }

    public final List g() {
        return this.f6547c;
    }

    public final boolean h() {
        return this.f6549e;
    }

    public int hashCode() {
        return (((((((((((((((((this.f6545a.hashCode() * 31) + this.f6546b.hashCode()) * 31) + this.f6547c.hashCode()) * 31) + this.f6548d) * 31) + androidx.compose.foundation.e.a(this.f6549e)) * 31) + androidx.compose.ui.text.style.p.f(this.f6550f)) * 31) + this.f6551g.hashCode()) * 31) + this.f6552h.hashCode()) * 31) + this.f6553i.hashCode()) * 31) + o0.b.o(this.f6554j);
    }

    public final d0 i() {
        return this.f6546b;
    }

    public final AnnotatedString j() {
        return this.f6545a;
    }

    public String toString() {
        return "TextLayoutInput(text=" + ((Object) this.f6545a) + ", style=" + this.f6546b + ", placeholders=" + this.f6547c + ", maxLines=" + this.f6548d + ", softWrap=" + this.f6549e + ", overflow=" + ((Object) androidx.compose.ui.text.style.p.g(this.f6550f)) + ", density=" + this.f6551g + ", layoutDirection=" + this.f6552h + ", fontFamilyResolver=" + this.f6553i + ", constraints=" + ((Object) o0.b.q(this.f6554j)) + ')';
    }
}

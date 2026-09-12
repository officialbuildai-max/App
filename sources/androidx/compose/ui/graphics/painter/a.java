package androidx.compose.ui.graphics.painter;

import androidx.compose.ui.graphics.e4;
import androidx.compose.ui.graphics.v1;
import androidx.compose.ui.graphics.x3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o0.p;
import o0.t;
import o0.u;
import y.m;
import z.f;
import z.g;

/* loaded from: classes.dex */
public final class a extends Painter {

    /* renamed from: g, reason: collision with root package name */
    private final e4 f4696g;

    /* renamed from: h, reason: collision with root package name */
    private final long f4697h;

    /* renamed from: i, reason: collision with root package name */
    private final long f4698i;

    /* renamed from: j, reason: collision with root package name */
    private int f4699j;

    /* renamed from: k, reason: collision with root package name */
    private final long f4700k;

    /* renamed from: l, reason: collision with root package name */
    private float f4701l;

    /* renamed from: m, reason: collision with root package name */
    private v1 f4702m;

    private a(e4 e4Var, long j11, long j12) {
        this.f4696g = e4Var;
        this.f4697h = j11;
        this.f4698i = j12;
        this.f4699j = x3.f4954a.a();
        this.f4700k = k(j11, j12);
        this.f4701l = 1.0f;
    }

    public /* synthetic */ a(e4 e4Var, long j11, long j12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(e4Var, (i11 & 2) != 0 ? p.f70738b.a() : j11, (i11 & 4) != 0 ? u.a(e4Var.getWidth(), e4Var.getHeight()) : j12, null);
    }

    public /* synthetic */ a(e4 e4Var, long j11, long j12, DefaultConstructorMarker defaultConstructorMarker) {
        this(e4Var, j11, j12);
    }

    private final long k(long j11, long j12) {
        if (p.h(j11) < 0 || p.i(j11) < 0 || t.g(j12) < 0 || t.f(j12) < 0 || t.g(j12) > this.f4696g.getWidth() || t.f(j12) > this.f4696g.getHeight()) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        return j12;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean a(float f11) {
        this.f4701l = f11;
        return true;
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    protected boolean b(v1 v1Var) {
        this.f4702m = v1Var;
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.c(this.f4696g, aVar.f4696g) && p.g(this.f4697h, aVar.f4697h) && t.e(this.f4698i, aVar.f4698i) && x3.d(this.f4699j, aVar.f4699j);
    }

    @Override // androidx.compose.ui.graphics.painter.Painter
    public long h() {
        return u.d(this.f4700k);
    }

    public int hashCode() {
        return (((((this.f4696g.hashCode() * 31) + p.j(this.f4697h)) * 31) + t.h(this.f4698i)) * 31) + x3.e(this.f4699j);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.graphics.painter.Painter
    public void j(g gVar) {
        f.e(gVar, this.f4696g, this.f4697h, this.f4698i, 0L, u.a(Math.round(m.i(gVar.i())), Math.round(m.g(gVar.i()))), this.f4701l, null, this.f4702m, 0, this.f4699j, 328, null);
    }

    public String toString() {
        return "BitmapPainter(image=" + this.f4696g + ", srcOffset=" + ((Object) p.m(this.f4697h)) + ", srcSize=" + ((Object) t.i(this.f4698i)) + ", filterQuality=" + ((Object) x3.f(this.f4699j)) + ')';
    }
}

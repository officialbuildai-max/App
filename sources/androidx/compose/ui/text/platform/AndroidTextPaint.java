package androidx.compose.ui.text.platform;

import android.graphics.Paint;
import android.text.TextPaint;
import androidx.compose.runtime.a3;
import androidx.compose.ui.graphics.c1;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.graphics.n4;
import androidx.compose.ui.graphics.t0;
import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.text.style.i;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class AndroidTextPaint extends TextPaint {

    /* renamed from: a, reason: collision with root package name */
    private m4 f6387a;

    /* renamed from: b, reason: collision with root package name */
    private androidx.compose.ui.text.style.i f6388b;

    /* renamed from: c, reason: collision with root package name */
    private int f6389c;

    /* renamed from: d, reason: collision with root package name */
    private z4 f6390d;

    /* renamed from: e, reason: collision with root package name */
    private j1 f6391e;

    /* renamed from: f, reason: collision with root package name */
    private a3 f6392f;

    /* renamed from: g, reason: collision with root package name */
    private y.m f6393g;

    /* renamed from: h, reason: collision with root package name */
    private z.h f6394h;

    public AndroidTextPaint(int i11, float f11) {
        super(i11);
        ((TextPaint) this).density = f11;
        this.f6388b = androidx.compose.ui.text.style.i.f6484b.c();
        this.f6389c = z.g.f79233o1.a();
        this.f6390d = z4.f4996d.a();
    }

    private final void a() {
        this.f6392f = null;
        this.f6391e = null;
        this.f6393g = null;
        setShader(null);
    }

    private final m4 c() {
        m4 m4Var = this.f6387a;
        if (m4Var != null) {
            return m4Var;
        }
        m4 b11 = t0.b(this);
        this.f6387a = b11;
        return b11;
    }

    public final int b() {
        return this.f6389c;
    }

    public final void d(int i11) {
        if (c1.E(i11, this.f6389c)) {
            return;
        }
        c().n(i11);
        this.f6389c = i11;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        if ((r0 == null ? false : y.m.f(r0.m(), r6)) == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e(final androidx.compose.ui.graphics.j1 r5, final long r6, float r8) {
        /*
            r4 = this;
            if (r5 != 0) goto L6
            r4.a()
            goto L6a
        L6:
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.b5
            if (r0 == 0) goto L18
            androidx.compose.ui.graphics.b5 r5 = (androidx.compose.ui.graphics.b5) r5
            long r5 = r5.b()
            long r5 = androidx.compose.ui.text.style.k.b(r5, r8)
            r4.f(r5)
            goto L6a
        L18:
            boolean r0 = r5 instanceof androidx.compose.ui.graphics.y4
            if (r0 == 0) goto L6a
            androidx.compose.ui.graphics.j1 r0 = r4.f6391e
            boolean r0 = kotlin.jvm.internal.Intrinsics.c(r0, r5)
            r1 = 0
            if (r0 == 0) goto L35
            y.m r0 = r4.f6393g
            if (r0 != 0) goto L2b
            r0 = r1
            goto L33
        L2b:
            long r2 = r0.m()
            boolean r0 = y.m.f(r2, r6)
        L33:
            if (r0 != 0) goto L54
        L35:
            r2 = 9205357640488583168(0x7fc000007fc00000, double:2.247117487993712E307)
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 == 0) goto L3f
            r1 = 1
        L3f:
            if (r1 == 0) goto L54
            r4.f6391e = r5
            y.m r0 = y.m.c(r6)
            r4.f6393g = r0
            androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1 r0 = new androidx.compose.ui.text.platform.AndroidTextPaint$setBrush$1
            r0.<init>()
            androidx.compose.runtime.a3 r5 = androidx.compose.runtime.r2.c(r0)
            r4.f6392f = r5
        L54:
            androidx.compose.ui.graphics.m4 r5 = r4.c()
            androidx.compose.runtime.a3 r6 = r4.f6392f
            if (r6 == 0) goto L63
            java.lang.Object r6 = r6.getValue()
            android.graphics.Shader r6 = (android.graphics.Shader) r6
            goto L64
        L63:
            r6 = 0
        L64:
            r5.x(r6)
            androidx.compose.ui.text.platform.f.a(r4, r8)
        L6a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.AndroidTextPaint.e(androidx.compose.ui.graphics.j1, long, float):void");
    }

    public final void f(long j11) {
        if (j11 != 16) {
            setColor(w1.j(j11));
            a();
        }
    }

    public final void g(z.h hVar) {
        if (hVar == null || Intrinsics.c(this.f6394h, hVar)) {
            return;
        }
        this.f6394h = hVar;
        if (Intrinsics.c(hVar, z.l.f79237a)) {
            setStyle(Paint.Style.FILL);
            return;
        }
        if (hVar instanceof z.m) {
            c().C(n4.f4683a.b());
            z.m mVar = (z.m) hVar;
            c().setStrokeWidth(mVar.f());
            c().A(mVar.d());
            c().r(mVar.c());
            c().m(mVar.b());
            m4 c11 = c();
            mVar.e();
            c11.q(null);
        }
    }

    public final void h(z4 z4Var) {
        if (z4Var == null || Intrinsics.c(this.f6390d, z4Var)) {
            return;
        }
        this.f6390d = z4Var;
        if (Intrinsics.c(z4Var, z4.f4996d.a())) {
            clearShadowLayer();
        } else {
            setShadowLayer(androidx.compose.ui.text.platform.extensions.f.b(this.f6390d.b()), y.g.m(this.f6390d.d()), y.g.n(this.f6390d.d()), w1.j(this.f6390d.c()));
        }
    }

    public final void i(androidx.compose.ui.text.style.i iVar) {
        if (iVar == null || Intrinsics.c(this.f6388b, iVar)) {
            return;
        }
        this.f6388b = iVar;
        i.a aVar = androidx.compose.ui.text.style.i.f6484b;
        setUnderlineText(iVar.d(aVar.d()));
        setStrikeThruText(this.f6388b.d(aVar.b()));
    }
}

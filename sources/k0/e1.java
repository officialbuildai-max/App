package k0;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Trace;
import android.text.BoringLayout;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class e1 {

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f66631a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f66632b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f66633c;

    /* renamed from: d, reason: collision with root package name */
    private final g0 f66634d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f66635e;

    /* renamed from: f, reason: collision with root package name */
    private final Layout f66636f;

    /* renamed from: g, reason: collision with root package name */
    private final int f66637g;

    /* renamed from: h, reason: collision with root package name */
    private final int f66638h;

    /* renamed from: i, reason: collision with root package name */
    private final int f66639i;

    /* renamed from: j, reason: collision with root package name */
    private final float f66640j;

    /* renamed from: k, reason: collision with root package name */
    private final float f66641k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f66642l;

    /* renamed from: m, reason: collision with root package name */
    private final Paint.FontMetricsInt f66643m;

    /* renamed from: n, reason: collision with root package name */
    private final int f66644n;

    /* renamed from: o, reason: collision with root package name */
    private final l0.h[] f66645o;

    /* renamed from: p, reason: collision with root package name */
    private final Rect f66646p;

    /* renamed from: q, reason: collision with root package name */
    private f0 f66647q;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v4, types: [int] */
    /* JADX WARN: Type inference failed for: r10v6 */
    public e1(CharSequence charSequence, float f11, TextPaint textPaint, int i11, TextUtils.TruncateAt truncateAt, int i12, float f12, float f13, boolean z10, boolean z11, int i13, int i14, int i15, int i16, int i17, int i18, int[] iArr, int[] iArr2, g0 g0Var) {
        boolean z12;
        boolean z13;
        TextDirectionHeuristic textDirectionHeuristic;
        Layout a11;
        long l11;
        l0.h[] j11;
        Paint.FontMetricsInt h11;
        this.f66631a = textPaint;
        this.f66632b = z10;
        this.f66633c = z11;
        this.f66634d = g0Var;
        this.f66646p = new Rect();
        int length = charSequence.length();
        TextDirectionHeuristic k11 = f1.k(i12);
        Layout.Alignment a12 = c1.f66621a.a(i11);
        boolean z14 = (charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(-1, length, l0.a.class) < length;
        Trace.beginSection("TextLayout:initLayout");
        try {
            BoringLayout.Metrics a13 = g0Var.a();
            double d11 = f11;
            int ceil = (int) Math.ceil(d11);
            if (a13 == null || g0Var.b() > f11 || z14) {
                z12 = true;
                this.f66642l = false;
                z13 = false;
                textDirectionHeuristic = k11;
                a11 = z0.f66675a.a(charSequence, textPaint, ceil, 0, charSequence.length(), k11, a12, i13, truncateAt, (int) Math.ceil(d11), f12, f13, i18, z10, z11, i14, i15, i16, i17, iArr, iArr2);
            } else {
                this.f66642l = true;
                z12 = true;
                a11 = e.f66630a.a(charSequence, textPaint, ceil, a13, a12, z10, z11, truncateAt, ceil);
                textDirectionHeuristic = k11;
                z13 = false;
            }
            this.f66636f = a11;
            Trace.endSection();
            int min = Math.min(a11.getLineCount(), i13);
            this.f66637g = min;
            int i19 = min - 1;
            this.f66635e = (min >= i13 && (a11.getEllipsisCount(i19) > 0 || a11.getLineEnd(i19) != charSequence.length())) ? z12 : z13;
            l11 = f1.l(this);
            j11 = f1.j(this);
            this.f66645o = j11;
            long i20 = j11 != null ? f1.i(j11) : f1.f66659b;
            this.f66638h = Math.max(g1.c(l11), g1.c(i20));
            this.f66639i = Math.max(g1.b(l11), g1.b(i20));
            h11 = f1.h(this, textPaint, textDirectionHeuristic, j11);
            this.f66644n = h11 != null ? h11.bottom - ((int) r(i19)) : z13;
            this.f66643m = h11;
            this.f66640j = l0.d.b(a11, i19, null, 2, null);
            this.f66641k = l0.d.d(a11, i19, null, 2, null);
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ e1(java.lang.CharSequence r24, float r25, android.text.TextPaint r26, int r27, android.text.TextUtils.TruncateAt r28, int r29, float r30, float r31, boolean r32, boolean r33, int r34, int r35, int r36, int r37, int r38, int r39, int[] r40, int[] r41, k0.g0 r42, int r43, kotlin.jvm.internal.DefaultConstructorMarker r44) {
        /*
            Method dump skipped, instructions count: 177
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k0.e1.<init>(java.lang.CharSequence, float, android.text.TextPaint, int, android.text.TextUtils$TruncateAt, int, float, float, boolean, boolean, int, int, int, int, int, int, int[], int[], k0.g0, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ float B(e1 e1Var, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z10 = false;
        }
        return e1Var.A(i11, z10);
    }

    private final float f(int i11) {
        if (i11 == this.f66637g - 1) {
            return this.f66640j + this.f66641k;
        }
        return 0.0f;
    }

    private final f0 i() {
        f0 f0Var = this.f66647q;
        if (f0Var != null) {
            Intrinsics.e(f0Var);
            return f0Var;
        }
        f0 f0Var2 = new f0(this.f66636f);
        this.f66647q = f0Var2;
        return f0Var2;
    }

    public static /* synthetic */ float z(e1 e1Var, int i11, boolean z10, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            z10 = false;
        }
        return e1Var.y(i11, z10);
    }

    public final float A(int i11, boolean z10) {
        return i().c(i11, false, z10) + f(p(i11));
    }

    public final CharSequence C() {
        return this.f66636f.getText();
    }

    public final boolean D() {
        if (this.f66642l) {
            e eVar = e.f66630a;
            Layout layout = this.f66636f;
            Intrinsics.f(layout, "null cannot be cast to non-null type android.text.BoringLayout");
            return eVar.b((BoringLayout) layout);
        }
        z0 z0Var = z0.f66675a;
        Layout layout2 = this.f66636f;
        Intrinsics.f(layout2, "null cannot be cast to non-null type android.text.StaticLayout");
        return z0Var.c((StaticLayout) layout2, this.f66633c);
    }

    public final boolean E(int i11) {
        return this.f66636f.isRtlCharAt(i11);
    }

    public final void F(Canvas canvas) {
        d1 d1Var;
        if (canvas.getClipBounds(this.f66646p)) {
            int i11 = this.f66638h;
            if (i11 != 0) {
                canvas.translate(0.0f, i11);
            }
            d1Var = f1.f66658a;
            d1Var.a(canvas);
            this.f66636f.draw(d1Var);
            int i12 = this.f66638h;
            if (i12 != 0) {
                canvas.translate(0.0f, (-1) * i12);
            }
        }
    }

    public final void a(int i11, int i12, float[] fArr, int i13) {
        float d11;
        float e11;
        int length = C().length();
        if (i11 < 0) {
            throw new IllegalArgumentException("startOffset must be > 0");
        }
        if (i11 >= length) {
            throw new IllegalArgumentException("startOffset must be less than text length");
        }
        if (i12 <= i11) {
            throw new IllegalArgumentException("endOffset must be greater than startOffset");
        }
        if (i12 > length) {
            throw new IllegalArgumentException("endOffset must be smaller or equal to text length");
        }
        if (fArr.length - i13 < (i12 - i11) * 4) {
            throw new IllegalArgumentException("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 4");
        }
        int p11 = p(i11);
        int p12 = p(i12 - 1);
        c0 c0Var = new c0(this);
        if (p11 > p12) {
            return;
        }
        while (true) {
            int u11 = u(p11);
            int o11 = o(p11);
            int min = Math.min(i12, o11);
            float v11 = v(p11);
            float k11 = k(p11);
            boolean z10 = x(p11) == 1;
            for (int max = Math.max(i11, u11); max < min; max++) {
                boolean E = E(max);
                if (z10 && !E) {
                    d11 = c0Var.b(max);
                    e11 = c0Var.c(max + 1);
                } else if (z10 && E) {
                    e11 = c0Var.d(max);
                    d11 = c0Var.e(max + 1);
                } else if (z10 || !E) {
                    d11 = c0Var.d(max);
                    e11 = c0Var.e(max + 1);
                } else {
                    e11 = c0Var.b(max);
                    d11 = c0Var.c(max + 1);
                }
                fArr[i13] = d11;
                fArr[i13 + 1] = v11;
                fArr[i13 + 2] = e11;
                fArr[i13 + 3] = k11;
                i13 += 4;
            }
            if (p11 == p12) {
                return;
            } else {
                p11++;
            }
        }
    }

    public final RectF b(int i11) {
        float A;
        float A2;
        float y10;
        float y11;
        int p11 = p(i11);
        float v11 = v(p11);
        float k11 = k(p11);
        boolean z10 = x(p11) == 1;
        boolean isRtlCharAt = this.f66636f.isRtlCharAt(i11);
        if (!z10 || isRtlCharAt) {
            if (z10 && isRtlCharAt) {
                y10 = A(i11, false);
                y11 = A(i11 + 1, true);
            } else if (isRtlCharAt) {
                y10 = y(i11, false);
                y11 = y(i11 + 1, true);
            } else {
                A = A(i11, false);
                A2 = A(i11 + 1, true);
            }
            float f11 = y10;
            A = y11;
            A2 = f11;
        } else {
            A = y(i11, false);
            A2 = y(i11 + 1, true);
        }
        return new RectF(A, v11, A2, k11);
    }

    public final boolean c() {
        return this.f66635e;
    }

    public final boolean d() {
        return this.f66633c;
    }

    public final int e() {
        return (this.f66635e ? this.f66636f.getLineBottom(this.f66637g - 1) : this.f66636f.getHeight()) + this.f66638h + this.f66639i + this.f66644n;
    }

    public final boolean g() {
        return this.f66632b;
    }

    public final Layout h() {
        return this.f66636f;
    }

    public final float j(int i11) {
        return this.f66638h + ((i11 != this.f66637g + (-1) || this.f66643m == null) ? this.f66636f.getLineBaseline(i11) : v(i11) - this.f66643m.ascent);
    }

    public final float k(int i11) {
        if (i11 != this.f66637g - 1 || this.f66643m == null) {
            return this.f66638h + this.f66636f.getLineBottom(i11) + (i11 == this.f66637g + (-1) ? this.f66639i : 0);
        }
        return this.f66636f.getLineBottom(i11 - 1) + this.f66643m.bottom;
    }

    public final int l() {
        return this.f66637g;
    }

    public final int m(int i11) {
        return this.f66636f.getEllipsisCount(i11);
    }

    public final int n(int i11) {
        return this.f66636f.getEllipsisStart(i11);
    }

    public final int o(int i11) {
        return this.f66636f.getEllipsisStart(i11) == 0 ? this.f66636f.getLineEnd(i11) : this.f66636f.getText().length();
    }

    public final int p(int i11) {
        return this.f66636f.getLineForOffset(i11);
    }

    public final int q(int i11) {
        return this.f66636f.getLineForVertical(i11 - this.f66638h);
    }

    public final float r(int i11) {
        return k(i11) - v(i11);
    }

    public final float s(int i11) {
        return this.f66636f.getLineLeft(i11) + (i11 == this.f66637g + (-1) ? this.f66640j : 0.0f);
    }

    public final float t(int i11) {
        return this.f66636f.getLineRight(i11) + (i11 == this.f66637g + (-1) ? this.f66641k : 0.0f);
    }

    public final int u(int i11) {
        return this.f66636f.getLineStart(i11);
    }

    public final float v(int i11) {
        return this.f66636f.getLineTop(i11) + (i11 == 0 ? 0 : this.f66638h);
    }

    public final int w(int i11) {
        if (this.f66636f.getEllipsisStart(i11) == 0) {
            return i().d(i11);
        }
        return this.f66636f.getEllipsisStart(i11) + this.f66636f.getLineStart(i11);
    }

    public final int x(int i11) {
        return this.f66636f.getParagraphDirection(i11);
    }

    public final float y(int i11, boolean z10) {
        return i().c(i11, true, z10) + f(p(i11));
    }
}

package androidx.compose.ui.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.Spanned;
import android.text.TextUtils;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.text.platform.AndroidParagraphIntrinsics;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k0.e1;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class a implements l {

    /* renamed from: a, reason: collision with root package name */
    private final AndroidParagraphIntrinsics f6146a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6147b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6148c;

    /* renamed from: d, reason: collision with root package name */
    private final long f6149d;

    /* renamed from: e, reason: collision with root package name */
    private final e1 f6150e;

    /* renamed from: f, reason: collision with root package name */
    private final CharSequence f6151f;

    /* renamed from: g, reason: collision with root package name */
    private final List f6152g;

    /* renamed from: androidx.compose.ui.text.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public /* synthetic */ class C0054a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6153a;

        static {
            int[] iArr = new int[ResolvedTextDirection.values().length];
            try {
                iArr[ResolvedTextDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ResolvedTextDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f6153a = iArr;
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:57:0x01b3. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    private a(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i11, boolean z10, long j11) {
        List list;
        y.i iVar;
        float w11;
        float j12;
        int b11;
        float v11;
        float f11;
        float j13;
        this.f6146a = androidParagraphIntrinsics;
        this.f6147b = i11;
        this.f6148c = z10;
        this.f6149d = j11;
        if (o0.b.m(j11) != 0 || o0.b.n(j11) != 0) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        if (i11 < 1) {
            throw new IllegalArgumentException("maxLines should be greater than 0");
        }
        d0 i12 = androidParagraphIntrinsics.i();
        this.f6151f = b.c(i12, z10) ? b.a(androidParagraphIntrinsics.f()) : androidParagraphIntrinsics.f();
        int d11 = b.d(i12.z());
        boolean k11 = androidx.compose.ui.text.style.h.k(i12.z(), androidx.compose.ui.text.style.h.f6475b.c());
        int f12 = b.f(i12.v().c());
        int e11 = b.e(androidx.compose.ui.text.style.e.e(i12.r()));
        int g11 = b.g(androidx.compose.ui.text.style.e.f(i12.r()));
        int h11 = b.h(androidx.compose.ui.text.style.e.g(i12.r()));
        TextUtils.TruncateAt truncateAt = z10 ? TextUtils.TruncateAt.END : null;
        e1 v12 = v(d11, k11 ? 1 : 0, truncateAt, i11, f12, e11, g11, h11);
        if (!z10 || v12.e() <= o0.b.k(j11) || i11 <= 1) {
            this.f6150e = v12;
        } else {
            int b12 = b.b(v12, o0.b.k(j11));
            if (b12 >= 0 && b12 != i11) {
                v12 = v(d11, k11 ? 1 : 0, truncateAt, RangesKt.f(b12, 1), f12, e11, g11, h11);
            }
            this.f6150e = v12;
        }
        z().e(i12.g(), y.n.a(getWidth(), getHeight()), i12.d());
        ShaderBrushSpan[] y10 = y(this.f6150e);
        if (y10 != null) {
            Iterator a11 = ArrayIteratorKt.a(y10);
            while (a11.hasNext()) {
                ((ShaderBrushSpan) a11.next()).c(y.n.a(getWidth(), getHeight()));
            }
        }
        CharSequence charSequence = this.f6151f;
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            Object[] spans = spanned.getSpans(0, charSequence.length(), l0.j.class);
            ArrayList arrayList = new ArrayList(spans.length);
            for (Object obj : spans) {
                l0.j jVar = (l0.j) obj;
                int spanStart = spanned.getSpanStart(jVar);
                int spanEnd = spanned.getSpanEnd(jVar);
                int p11 = this.f6150e.p(spanStart);
                Object[] objArr = p11 >= this.f6147b;
                Object[] objArr2 = this.f6150e.m(p11) > 0 && spanEnd > this.f6150e.n(p11);
                Object[] objArr3 = spanEnd > this.f6150e.o(p11);
                if (objArr2 == true || objArr3 == true || objArr == true) {
                    iVar = null;
                } else {
                    int i13 = C0054a.f6153a[r(spanStart).ordinal()];
                    if (i13 == 1) {
                        w11 = w(spanStart, true);
                    } else {
                        if (i13 != 2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        w11 = w(spanStart, true) - jVar.d();
                    }
                    float d12 = jVar.d() + w11;
                    e1 e1Var = this.f6150e;
                    switch (jVar.c()) {
                        case 0:
                            j12 = e1Var.j(p11);
                            b11 = jVar.b();
                            v11 = j12 - b11;
                            iVar = new y.i(w11, v11, d12, jVar.b() + v11);
                            break;
                        case 1:
                            v11 = e1Var.v(p11);
                            iVar = new y.i(w11, v11, d12, jVar.b() + v11);
                            break;
                        case 2:
                            j12 = e1Var.k(p11);
                            b11 = jVar.b();
                            v11 = j12 - b11;
                            iVar = new y.i(w11, v11, d12, jVar.b() + v11);
                            break;
                        case 3:
                            v11 = ((e1Var.v(p11) + e1Var.k(p11)) - jVar.b()) / 2;
                            iVar = new y.i(w11, v11, d12, jVar.b() + v11);
                            break;
                        case 4:
                            f11 = jVar.a().ascent;
                            j13 = e1Var.j(p11);
                            v11 = f11 + j13;
                            iVar = new y.i(w11, v11, d12, jVar.b() + v11);
                            break;
                        case 5:
                            v11 = (jVar.a().descent + e1Var.j(p11)) - jVar.b();
                            iVar = new y.i(w11, v11, d12, jVar.b() + v11);
                            break;
                        case 6:
                            Paint.FontMetricsInt a12 = jVar.a();
                            f11 = ((a12.ascent + a12.descent) - jVar.b()) / 2;
                            j13 = e1Var.j(p11);
                            v11 = f11 + j13;
                            iVar = new y.i(w11, v11, d12, jVar.b() + v11);
                            break;
                        default:
                            throw new IllegalStateException("unexpected verticalAlignment");
                    }
                }
                arrayList.add(iVar);
            }
            list = arrayList;
        } else {
            list = CollectionsKt.l();
        }
        this.f6152g = list;
    }

    public /* synthetic */ a(AndroidParagraphIntrinsics androidParagraphIntrinsics, int i11, boolean z10, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(androidParagraphIntrinsics, i11, z10, j11);
    }

    private final boolean A(Spanned spanned, Class cls) {
        return spanned.nextSpanTransition(-1, spanned.length(), cls) != spanned.length();
    }

    private final void B(m1 m1Var) {
        Canvas d11 = androidx.compose.ui.graphics.h0.d(m1Var);
        if (k()) {
            d11.save();
            d11.clipRect(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.f6150e.F(d11);
        if (k()) {
            d11.restore();
        }
    }

    private final e1 v(int i11, int i12, TextUtils.TruncateAt truncateAt, int i13, int i14, int i15, int i16, int i17) {
        return new e1(this.f6151f, getWidth(), z(), i11, truncateAt, this.f6146a.j(), 1.0f, 0.0f, androidx.compose.ui.text.platform.c.b(this.f6146a.i()), true, i13, i15, i16, i17, i14, i12, null, null, this.f6146a.h(), 196736, null);
    }

    private final ShaderBrushSpan[] y(e1 e1Var) {
        if (!(e1Var.C() instanceof Spanned)) {
            return null;
        }
        CharSequence C = e1Var.C();
        Intrinsics.f(C, "null cannot be cast to non-null type android.text.Spanned");
        if (!A((Spanned) C, ShaderBrushSpan.class)) {
            return null;
        }
        CharSequence C2 = e1Var.C();
        Intrinsics.f(C2, "null cannot be cast to non-null type android.text.Spanned");
        return (ShaderBrushSpan[]) ((Spanned) C2).getSpans(0, e1Var.C().length(), ShaderBrushSpan.class);
    }

    @Override // androidx.compose.ui.text.l
    public float a() {
        return this.f6146a.a();
    }

    @Override // androidx.compose.ui.text.l
    public ResolvedTextDirection b(int i11) {
        return this.f6150e.x(this.f6150e.p(i11)) == 1 ? ResolvedTextDirection.Ltr : ResolvedTextDirection.Rtl;
    }

    @Override // androidx.compose.ui.text.l
    public float c(int i11) {
        return this.f6150e.v(i11);
    }

    @Override // androidx.compose.ui.text.l
    public y.i d(int i11) {
        if (i11 >= 0 && i11 <= this.f6151f.length()) {
            float z10 = e1.z(this.f6150e, i11, false, 2, null);
            int p11 = this.f6150e.p(i11);
            return new y.i(z10, this.f6150e.v(p11), z10, this.f6150e.k(p11));
        }
        throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0," + this.f6151f.length() + ']').toString());
    }

    @Override // androidx.compose.ui.text.l
    public float e() {
        return x(0);
    }

    @Override // androidx.compose.ui.text.l
    public int f(int i11) {
        return this.f6150e.u(i11);
    }

    @Override // androidx.compose.ui.text.l
    public int g(int i11, boolean z10) {
        return z10 ? this.f6150e.w(i11) : this.f6150e.o(i11);
    }

    @Override // androidx.compose.ui.text.l
    public float getHeight() {
        return this.f6150e.e();
    }

    @Override // androidx.compose.ui.text.l
    public float getWidth() {
        return o0.b.l(this.f6149d);
    }

    @Override // androidx.compose.ui.text.l
    public int h() {
        return this.f6150e.l();
    }

    @Override // androidx.compose.ui.text.l
    public float i(int i11) {
        return this.f6150e.t(i11);
    }

    @Override // androidx.compose.ui.text.l
    public void j(m1 m1Var, j1 j1Var, float f11, z4 z4Var, androidx.compose.ui.text.style.i iVar, z.h hVar, int i11) {
        int b11 = z().b();
        AndroidTextPaint z10 = z();
        z10.e(j1Var, y.n.a(getWidth(), getHeight()), f11);
        z10.h(z4Var);
        z10.i(iVar);
        z10.g(hVar);
        z10.d(i11);
        B(m1Var);
        z().d(b11);
    }

    @Override // androidx.compose.ui.text.l
    public boolean k() {
        return this.f6150e.c();
    }

    @Override // androidx.compose.ui.text.l
    public int l(float f11) {
        return this.f6150e.q((int) f11);
    }

    @Override // androidx.compose.ui.text.l
    public float m(int i11) {
        return this.f6150e.s(i11);
    }

    @Override // androidx.compose.ui.text.l
    public void n(long j11, float[] fArr, int i11) {
        this.f6150e.a(b0.j(j11), b0.i(j11), fArr, i11);
    }

    @Override // androidx.compose.ui.text.l
    public float o() {
        return x(h() - 1);
    }

    @Override // androidx.compose.ui.text.l
    public int p(int i11) {
        return this.f6150e.p(i11);
    }

    @Override // androidx.compose.ui.text.l
    public void q(m1 m1Var, long j11, z4 z4Var, androidx.compose.ui.text.style.i iVar, z.h hVar, int i11) {
        int b11 = z().b();
        AndroidTextPaint z10 = z();
        z10.f(j11);
        z10.h(z4Var);
        z10.i(iVar);
        z10.g(hVar);
        z10.d(i11);
        B(m1Var);
        z().d(b11);
    }

    @Override // androidx.compose.ui.text.l
    public ResolvedTextDirection r(int i11) {
        return this.f6150e.E(i11) ? ResolvedTextDirection.Rtl : ResolvedTextDirection.Ltr;
    }

    @Override // androidx.compose.ui.text.l
    public float s(int i11) {
        return this.f6150e.k(i11);
    }

    @Override // androidx.compose.ui.text.l
    public y.i t(int i11) {
        if (i11 >= 0 && i11 < this.f6151f.length()) {
            RectF b11 = this.f6150e.b(i11);
            return new y.i(b11.left, b11.top, b11.right, b11.bottom);
        }
        throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0," + this.f6151f.length() + ')').toString());
    }

    @Override // androidx.compose.ui.text.l
    public List u() {
        return this.f6152g;
    }

    public float w(int i11, boolean z10) {
        return z10 ? e1.z(this.f6150e, i11, false, 2, null) : e1.B(this.f6150e, i11, false, 2, null);
    }

    public float x(int i11) {
        return this.f6150e.j(i11);
    }

    public final AndroidTextPaint z() {
        return this.f6146a.k();
    }
}

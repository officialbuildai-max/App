package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.internal.StaticLayoutBuilderCompat;
import xa.a;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: t0, reason: collision with root package name */
    private static final boolean f29197t0 = false;

    /* renamed from: u0, reason: collision with root package name */
    private static final Paint f29198u0 = null;
    private Typeface A;
    private Typeface B;
    private Typeface C;
    private xa.a D;
    private xa.a E;
    private CharSequence G;
    private CharSequence H;
    private boolean I;
    private boolean K;
    private Bitmap L;
    private Paint M;
    private float N;
    private float O;
    private float P;
    private float Q;
    private float R;
    private int S;
    private int[] T;
    private boolean U;
    private final TextPaint V;
    private final TextPaint W;
    private TimeInterpolator X;
    private TimeInterpolator Y;
    private float Z;

    /* renamed from: a, reason: collision with root package name */
    private final View f29199a;

    /* renamed from: a0, reason: collision with root package name */
    private float f29200a0;

    /* renamed from: b, reason: collision with root package name */
    private float f29201b;

    /* renamed from: b0, reason: collision with root package name */
    private float f29202b0;

    /* renamed from: c, reason: collision with root package name */
    private boolean f29203c;

    /* renamed from: c0, reason: collision with root package name */
    private ColorStateList f29204c0;

    /* renamed from: d, reason: collision with root package name */
    private float f29205d;

    /* renamed from: d0, reason: collision with root package name */
    private float f29206d0;

    /* renamed from: e, reason: collision with root package name */
    private float f29207e;

    /* renamed from: e0, reason: collision with root package name */
    private float f29208e0;

    /* renamed from: f, reason: collision with root package name */
    private int f29209f;

    /* renamed from: f0, reason: collision with root package name */
    private float f29210f0;

    /* renamed from: g, reason: collision with root package name */
    private final Rect f29211g;

    /* renamed from: g0, reason: collision with root package name */
    private ColorStateList f29212g0;

    /* renamed from: h, reason: collision with root package name */
    private final Rect f29213h;

    /* renamed from: h0, reason: collision with root package name */
    private float f29214h0;

    /* renamed from: i, reason: collision with root package name */
    private final RectF f29215i;

    /* renamed from: i0, reason: collision with root package name */
    private float f29216i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f29218j0;

    /* renamed from: k0, reason: collision with root package name */
    private StaticLayout f29220k0;

    /* renamed from: l0, reason: collision with root package name */
    private float f29222l0;

    /* renamed from: m0, reason: collision with root package name */
    private float f29224m0;

    /* renamed from: n, reason: collision with root package name */
    private ColorStateList f29225n;

    /* renamed from: n0, reason: collision with root package name */
    private float f29226n0;

    /* renamed from: o, reason: collision with root package name */
    private ColorStateList f29227o;

    /* renamed from: o0, reason: collision with root package name */
    private CharSequence f29228o0;

    /* renamed from: p, reason: collision with root package name */
    private int f29229p;

    /* renamed from: q, reason: collision with root package name */
    private float f29231q;

    /* renamed from: r, reason: collision with root package name */
    private float f29233r;

    /* renamed from: s, reason: collision with root package name */
    private float f29235s;

    /* renamed from: t, reason: collision with root package name */
    private float f29237t;

    /* renamed from: u, reason: collision with root package name */
    private float f29238u;

    /* renamed from: v, reason: collision with root package name */
    private float f29239v;

    /* renamed from: w, reason: collision with root package name */
    private Typeface f29240w;

    /* renamed from: x, reason: collision with root package name */
    private Typeface f29241x;

    /* renamed from: y, reason: collision with root package name */
    private Typeface f29242y;

    /* renamed from: z, reason: collision with root package name */
    private Typeface f29243z;

    /* renamed from: j, reason: collision with root package name */
    private int f29217j = 16;

    /* renamed from: k, reason: collision with root package name */
    private int f29219k = 16;

    /* renamed from: l, reason: collision with root package name */
    private float f29221l = 15.0f;

    /* renamed from: m, reason: collision with root package name */
    private float f29223m = 15.0f;
    private TextUtils.TruncateAt F = TextUtils.TruncateAt.END;
    private boolean J = true;

    /* renamed from: p0, reason: collision with root package name */
    private int f29230p0 = 1;

    /* renamed from: q0, reason: collision with root package name */
    private float f29232q0 = 0.0f;

    /* renamed from: r0, reason: collision with root package name */
    private float f29234r0 = 1.0f;

    /* renamed from: s0, reason: collision with root package name */
    private int f29236s0 = StaticLayoutBuilderCompat.f29174n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements a.InterfaceC0988a {
        a() {
        }

        @Override // xa.a.InterfaceC0988a
        public void a(Typeface typeface) {
            b.this.m0(typeface);
        }
    }

    /* renamed from: com.google.android.material.internal.b$b, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    class C0399b implements a.InterfaceC0988a {
        C0399b() {
        }

        @Override // xa.a.InterfaceC0988a
        public void a(Typeface typeface) {
            b.this.x0(typeface);
        }
    }

    public b(View view) {
        this.f29199a = view;
        TextPaint textPaint = new TextPaint(129);
        this.V = textPaint;
        this.W = new TextPaint(textPaint);
        this.f29213h = new Rect();
        this.f29211g = new Rect();
        this.f29215i = new RectF();
        this.f29207e = e();
        Z(view.getContext().getResources().getConfiguration());
    }

    private void D0(float f11) {
        h(f11);
        boolean z10 = f29197t0 && this.N != 1.0f;
        this.K = z10;
        if (z10) {
            n();
        }
        ViewCompat.postInvalidateOnAnimation(this.f29199a);
    }

    private Layout.Alignment M() {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f29217j, this.I ? 1 : 0) & 7;
        return absoluteGravity != 1 ? absoluteGravity != 5 ? this.I ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : this.I ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    private void P(TextPaint textPaint) {
        textPaint.setTextSize(this.f29223m);
        textPaint.setTypeface(this.f29240w);
        textPaint.setLetterSpacing(this.f29214h0);
    }

    private boolean P0() {
        return this.f29230p0 > 1 && (!this.I || this.f29203c) && !this.K;
    }

    private void Q(TextPaint textPaint) {
        textPaint.setTextSize(this.f29221l);
        textPaint.setTypeface(this.f29243z);
        textPaint.setLetterSpacing(this.f29216i0);
    }

    private void S(float f11) {
        if (this.f29203c) {
            this.f29215i.set(f11 < this.f29207e ? this.f29211g : this.f29213h);
            return;
        }
        this.f29215i.left = Y(this.f29211g.left, this.f29213h.left, f11, this.X);
        this.f29215i.top = Y(this.f29231q, this.f29233r, f11, this.X);
        this.f29215i.right = Y(this.f29211g.right, this.f29213h.right, f11, this.X);
        this.f29215i.bottom = Y(this.f29211g.bottom, this.f29213h.bottom, f11, this.X);
    }

    private static boolean T(float f11, float f12) {
        return Math.abs(f11 - f12) < 1.0E-5f;
    }

    private boolean U() {
        return ViewCompat.getLayoutDirection(this.f29199a) == 1;
    }

    private boolean X(CharSequence charSequence, boolean z10) {
        return (z10 ? androidx.core.text.u.f8336d : androidx.core.text.u.f8335c).a(charSequence, 0, charSequence.length());
    }

    private static float Y(float f11, float f12, float f13, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f13 = timeInterpolator.getInterpolation(f13);
        }
        return oa.a.a(f11, f12, f13);
    }

    private static int a(int i11, int i12, float f11) {
        float f12 = 1.0f - f11;
        return Color.argb(Math.round((Color.alpha(i11) * f12) + (Color.alpha(i12) * f11)), Math.round((Color.red(i11) * f12) + (Color.red(i12) * f11)), Math.round((Color.green(i11) * f12) + (Color.green(i12) * f11)), Math.round((Color.blue(i11) * f12) + (Color.blue(i12) * f11)));
    }

    private float a0(TextPaint textPaint, CharSequence charSequence) {
        return textPaint.measureText(charSequence, 0, charSequence.length());
    }

    private void b(boolean z10) {
        StaticLayout staticLayout;
        i(1.0f, z10);
        CharSequence charSequence = this.H;
        if (charSequence != null && (staticLayout = this.f29220k0) != null) {
            this.f29228o0 = TextUtils.ellipsize(charSequence, this.V, staticLayout.getWidth(), this.F);
        }
        CharSequence charSequence2 = this.f29228o0;
        float f11 = 0.0f;
        if (charSequence2 != null) {
            this.f29222l0 = a0(this.V, charSequence2);
        } else {
            this.f29222l0 = 0.0f;
        }
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f29219k, this.I ? 1 : 0);
        int i11 = absoluteGravity & 112;
        if (i11 == 48) {
            this.f29233r = this.f29213h.top;
        } else if (i11 != 80) {
            this.f29233r = this.f29213h.centerY() - ((this.V.descent() - this.V.ascent()) / 2.0f);
        } else {
            this.f29233r = this.f29213h.bottom + this.V.ascent();
        }
        int i12 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i12 == 1) {
            this.f29237t = this.f29213h.centerX() - (this.f29222l0 / 2.0f);
        } else if (i12 != 5) {
            this.f29237t = this.f29213h.left;
        } else {
            this.f29237t = this.f29213h.right - this.f29222l0;
        }
        i(0.0f, z10);
        float height = this.f29220k0 != null ? r10.getHeight() : 0.0f;
        StaticLayout staticLayout2 = this.f29220k0;
        if (staticLayout2 == null || this.f29230p0 <= 1) {
            CharSequence charSequence3 = this.H;
            if (charSequence3 != null) {
                f11 = a0(this.V, charSequence3);
            }
        } else {
            f11 = staticLayout2.getWidth();
        }
        StaticLayout staticLayout3 = this.f29220k0;
        this.f29229p = staticLayout3 != null ? staticLayout3.getLineCount() : 0;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f29217j, this.I ? 1 : 0);
        int i13 = absoluteGravity2 & 112;
        if (i13 == 48) {
            this.f29231q = this.f29211g.top;
        } else if (i13 != 80) {
            this.f29231q = this.f29211g.centerY() - (height / 2.0f);
        } else {
            this.f29231q = (this.f29211g.bottom - height) + this.V.descent();
        }
        int i14 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i14 == 1) {
            this.f29235s = this.f29211g.centerX() - (f11 / 2.0f);
        } else if (i14 != 5) {
            this.f29235s = this.f29211g.left;
        } else {
            this.f29235s = this.f29211g.right - f11;
        }
        j();
        D0(this.f29201b);
    }

    private void c() {
        g(this.f29201b);
    }

    private float d(float f11) {
        float f12 = this.f29207e;
        return f11 <= f12 ? oa.a.b(1.0f, 0.0f, this.f29205d, f12, f11) : oa.a.b(0.0f, 1.0f, f12, 1.0f, f11);
    }

    private static boolean d0(Rect rect, int i11, int i12, int i13, int i14) {
        return rect.left == i11 && rect.top == i12 && rect.right == i13 && rect.bottom == i14;
    }

    private float e() {
        float f11 = this.f29205d;
        return f11 + ((1.0f - f11) * 0.5f);
    }

    private boolean f(CharSequence charSequence) {
        boolean U = U();
        return this.J ? X(charSequence, U) : U;
    }

    private void g(float f11) {
        float f12;
        S(f11);
        if (!this.f29203c) {
            this.f29238u = Y(this.f29235s, this.f29237t, f11, this.X);
            this.f29239v = Y(this.f29231q, this.f29233r, f11, this.X);
            D0(f11);
            f12 = f11;
        } else if (f11 < this.f29207e) {
            this.f29238u = this.f29235s;
            this.f29239v = this.f29231q;
            D0(0.0f);
            f12 = 0.0f;
        } else {
            this.f29238u = this.f29237t;
            this.f29239v = this.f29233r - Math.max(0, this.f29209f);
            D0(1.0f);
            f12 = 1.0f;
        }
        TimeInterpolator timeInterpolator = oa.a.f71042b;
        i0(1.0f - Y(0.0f, 1.0f, 1.0f - f11, timeInterpolator));
        t0(Y(1.0f, 0.0f, f11, timeInterpolator));
        if (this.f29227o != this.f29225n) {
            this.V.setColor(a(y(), w(), f12));
        } else {
            this.V.setColor(w());
        }
        int i11 = Build.VERSION.SDK_INT;
        float f13 = this.f29214h0;
        float f14 = this.f29216i0;
        if (f13 != f14) {
            this.V.setLetterSpacing(Y(f14, f13, f11, timeInterpolator));
        } else {
            this.V.setLetterSpacing(f13);
        }
        this.P = Y(this.f29206d0, this.Z, f11, null);
        this.Q = Y(this.f29208e0, this.f29200a0, f11, null);
        this.R = Y(this.f29210f0, this.f29202b0, f11, null);
        int a11 = a(x(this.f29212g0), x(this.f29204c0), f11);
        this.S = a11;
        this.V.setShadowLayer(this.P, this.Q, this.R, a11);
        if (this.f29203c) {
            this.V.setAlpha((int) (d(f11) * this.V.getAlpha()));
            if (i11 >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, com.google.android.material.color.b.a(this.S, textPaint.getAlpha()));
            }
        }
        ViewCompat.postInvalidateOnAnimation(this.f29199a);
    }

    private void h(float f11) {
        i(f11, false);
    }

    private void i(float f11, boolean z10) {
        float f12;
        float f13;
        Typeface typeface;
        if (this.G == null) {
            return;
        }
        float width = this.f29213h.width();
        float width2 = this.f29211g.width();
        if (T(f11, 1.0f)) {
            f12 = this.f29223m;
            f13 = this.f29214h0;
            this.N = 1.0f;
            typeface = this.f29240w;
        } else {
            float f14 = this.f29221l;
            float f15 = this.f29216i0;
            Typeface typeface2 = this.f29243z;
            if (T(f11, 0.0f)) {
                this.N = 1.0f;
            } else {
                this.N = Y(this.f29221l, this.f29223m, f11, this.Y) / this.f29221l;
            }
            float f16 = this.f29223m / this.f29221l;
            width = (z10 || this.f29203c || width2 * f16 <= width) ? width2 : Math.min(width / f16, width2);
            f12 = f14;
            f13 = f15;
            typeface = typeface2;
        }
        if (width > 0.0f) {
            boolean z11 = this.O != f12;
            boolean z12 = this.f29218j0 != f13;
            boolean z13 = this.C != typeface;
            StaticLayout staticLayout = this.f29220k0;
            boolean z14 = z11 || z12 || (staticLayout != null && (width > ((float) staticLayout.getWidth()) ? 1 : (width == ((float) staticLayout.getWidth()) ? 0 : -1)) != 0) || z13 || this.U;
            this.O = f12;
            this.f29218j0 = f13;
            this.C = typeface;
            this.U = false;
            this.V.setLinearText(this.N != 1.0f);
            r5 = z14;
        }
        if (this.H == null || r5) {
            this.V.setTextSize(this.O);
            this.V.setTypeface(this.C);
            this.V.setLetterSpacing(this.f29218j0);
            this.I = f(this.G);
            StaticLayout k11 = k(P0() ? this.f29230p0 : 1, width, this.I);
            this.f29220k0 = k11;
            this.H = k11.getText();
        }
    }

    private void i0(float f11) {
        this.f29224m0 = f11;
        ViewCompat.postInvalidateOnAnimation(this.f29199a);
    }

    private void j() {
        Bitmap bitmap = this.L;
        if (bitmap != null) {
            bitmap.recycle();
            this.L = null;
        }
    }

    private StaticLayout k(int i11, float f11, boolean z10) {
        StaticLayout staticLayout = null;
        try {
            staticLayout = StaticLayoutBuilderCompat.b(this.G, this.V, (int) f11).d(this.F).g(z10).c(i11 == 1 ? Layout.Alignment.ALIGN_NORMAL : M()).f(false).i(i11).h(this.f29232q0, this.f29234r0).e(this.f29236s0).j(null).a();
        } catch (StaticLayoutBuilderCompat.StaticLayoutBuilderCompatException e11) {
            Log.e("CollapsingTextHelper", e11.getCause().getMessage(), e11);
        }
        return (StaticLayout) androidx.core.util.i.g(staticLayout);
    }

    private void m(Canvas canvas, float f11, float f12) {
        int alpha = this.V.getAlpha();
        canvas.translate(f11, f12);
        if (!this.f29203c) {
            this.V.setAlpha((int) (this.f29226n0 * alpha));
            if (Build.VERSION.SDK_INT >= 31) {
                TextPaint textPaint = this.V;
                textPaint.setShadowLayer(this.P, this.Q, this.R, com.google.android.material.color.b.a(this.S, textPaint.getAlpha()));
            }
            this.f29220k0.draw(canvas);
        }
        if (!this.f29203c) {
            this.V.setAlpha((int) (this.f29224m0 * alpha));
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 31) {
            TextPaint textPaint2 = this.V;
            textPaint2.setShadowLayer(this.P, this.Q, this.R, com.google.android.material.color.b.a(this.S, textPaint2.getAlpha()));
        }
        int lineBaseline = this.f29220k0.getLineBaseline(0);
        CharSequence charSequence = this.f29228o0;
        float f13 = lineBaseline;
        canvas.drawText(charSequence, 0, charSequence.length(), 0.0f, f13, this.V);
        if (i11 >= 31) {
            this.V.setShadowLayer(this.P, this.Q, this.R, this.S);
        }
        if (this.f29203c) {
            return;
        }
        String trim = this.f29228o0.toString().trim();
        if (trim.endsWith("…")) {
            trim = trim.substring(0, trim.length() - 1);
        }
        String str = trim;
        this.V.setAlpha(alpha);
        canvas.drawText(str, 0, Math.min(this.f29220k0.getLineEnd(0), str.length()), 0.0f, f13, (Paint) this.V);
    }

    private void n() {
        if (this.L != null || this.f29211g.isEmpty() || TextUtils.isEmpty(this.H)) {
            return;
        }
        g(0.0f);
        int width = this.f29220k0.getWidth();
        int height = this.f29220k0.getHeight();
        if (width <= 0 || height <= 0) {
            return;
        }
        this.L = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        this.f29220k0.draw(new Canvas(this.L));
        if (this.M == null) {
            this.M = new Paint(3);
        }
    }

    private boolean n0(Typeface typeface) {
        xa.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        if (this.f29242y == typeface) {
            return false;
        }
        this.f29242y = typeface;
        Typeface b11 = xa.h.b(this.f29199a.getContext().getResources().getConfiguration(), typeface);
        this.f29241x = b11;
        if (b11 == null) {
            b11 = this.f29242y;
        }
        this.f29240w = b11;
        return true;
    }

    private float s(int i11, int i12) {
        return (i12 == 17 || (i12 & 7) == 1) ? (i11 / 2.0f) - (this.f29222l0 / 2.0f) : ((i12 & GravityCompat.END) == 8388613 || (i12 & 5) == 5) ? this.I ? this.f29213h.left : this.f29213h.right - this.f29222l0 : this.I ? this.f29213h.right - this.f29222l0 : this.f29213h.left;
    }

    private float t(RectF rectF, int i11, int i12) {
        return (i12 == 17 || (i12 & 7) == 1) ? (i11 / 2.0f) + (this.f29222l0 / 2.0f) : ((i12 & GravityCompat.END) == 8388613 || (i12 & 5) == 5) ? this.I ? rectF.left + this.f29222l0 : this.f29213h.right : this.I ? this.f29213h.right : rectF.left + this.f29222l0;
    }

    private void t0(float f11) {
        this.f29226n0 = f11;
        ViewCompat.postInvalidateOnAnimation(this.f29199a);
    }

    private int x(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return 0;
        }
        int[] iArr = this.T;
        return iArr != null ? colorStateList.getColorForState(iArr, 0) : colorStateList.getDefaultColor();
    }

    private int y() {
        return x(this.f29225n);
    }

    private boolean y0(Typeface typeface) {
        xa.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        if (this.B == typeface) {
            return false;
        }
        this.B = typeface;
        Typeface b11 = xa.h.b(this.f29199a.getContext().getResources().getConfiguration(), typeface);
        this.A = b11;
        if (b11 == null) {
            b11 = this.B;
        }
        this.f29243z = b11;
        return true;
    }

    public float A() {
        Q(this.W);
        return (-this.W.ascent()) + this.W.descent();
    }

    public void A0(boolean z10) {
        this.f29203c = z10;
    }

    public int B() {
        return this.f29217j;
    }

    public void B0(float f11) {
        this.f29205d = f11;
        this.f29207e = e();
    }

    public float C() {
        Q(this.W);
        return -this.W.ascent();
    }

    public void C0(int i11) {
        this.f29236s0 = i11;
    }

    public float D() {
        return this.f29221l;
    }

    public Typeface E() {
        Typeface typeface = this.f29243z;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void E0(float f11) {
        this.f29232q0 = f11;
    }

    public float F() {
        return this.f29201b;
    }

    public void F0(float f11) {
        this.f29234r0 = f11;
    }

    public float G() {
        return this.f29207e;
    }

    public void G0(int i11) {
        if (i11 != this.f29230p0) {
            this.f29230p0 = i11;
            j();
            b0();
        }
    }

    public int H() {
        return this.f29236s0;
    }

    public void H0(TimeInterpolator timeInterpolator) {
        this.X = timeInterpolator;
        b0();
    }

    public int I() {
        StaticLayout staticLayout = this.f29220k0;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public void I0(boolean z10) {
        this.J = z10;
    }

    public float J() {
        return this.f29220k0.getSpacingAdd();
    }

    public final boolean J0(int[] iArr) {
        this.T = iArr;
        if (!W()) {
            return false;
        }
        b0();
        return true;
    }

    public float K() {
        return this.f29220k0.getSpacingMultiplier();
    }

    public void K0(x xVar) {
        if (xVar != null) {
            c0(true);
        }
    }

    public int L() {
        return this.f29230p0;
    }

    public void L0(CharSequence charSequence) {
        if (charSequence == null || !TextUtils.equals(this.G, charSequence)) {
            this.G = charSequence;
            this.H = null;
            j();
            b0();
        }
    }

    public void M0(TimeInterpolator timeInterpolator) {
        this.Y = timeInterpolator;
        b0();
    }

    public TimeInterpolator N() {
        return this.X;
    }

    public void N0(TextUtils.TruncateAt truncateAt) {
        this.F = truncateAt;
        b0();
    }

    public CharSequence O() {
        return this.G;
    }

    public void O0(Typeface typeface) {
        boolean n02 = n0(typeface);
        boolean y02 = y0(typeface);
        if (n02 || y02) {
            b0();
        }
    }

    public TextUtils.TruncateAt R() {
        return this.F;
    }

    public boolean V() {
        return this.J;
    }

    public final boolean W() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2 = this.f29227o;
        return (colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = this.f29225n) != null && colorStateList.isStateful());
    }

    public void Z(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            Typeface typeface = this.f29242y;
            if (typeface != null) {
                this.f29241x = xa.h.b(configuration, typeface);
            }
            Typeface typeface2 = this.B;
            if (typeface2 != null) {
                this.A = xa.h.b(configuration, typeface2);
            }
            Typeface typeface3 = this.f29241x;
            if (typeface3 == null) {
                typeface3 = this.f29242y;
            }
            this.f29240w = typeface3;
            Typeface typeface4 = this.A;
            if (typeface4 == null) {
                typeface4 = this.B;
            }
            this.f29243z = typeface4;
            c0(true);
        }
    }

    public void b0() {
        c0(false);
    }

    public void c0(boolean z10) {
        if ((this.f29199a.getHeight() <= 0 || this.f29199a.getWidth() <= 0) && !z10) {
            return;
        }
        b(z10);
        c();
    }

    public void e0(ColorStateList colorStateList) {
        if (this.f29227o == colorStateList && this.f29225n == colorStateList) {
            return;
        }
        this.f29227o = colorStateList;
        this.f29225n = colorStateList;
        b0();
    }

    public void f0(int i11, int i12, int i13, int i14) {
        if (d0(this.f29213h, i11, i12, i13, i14)) {
            return;
        }
        this.f29213h.set(i11, i12, i13, i14);
        this.U = true;
    }

    public void g0(Rect rect) {
        f0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void h0(int i11) {
        xa.d dVar = new xa.d(this.f29199a.getContext(), i11);
        if (dVar.i() != null) {
            this.f29227o = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f29223m = dVar.j();
        }
        ColorStateList colorStateList = dVar.f78281c;
        if (colorStateList != null) {
            this.f29204c0 = colorStateList;
        }
        this.f29200a0 = dVar.f78286h;
        this.f29202b0 = dVar.f78287i;
        this.Z = dVar.f78288j;
        this.f29214h0 = dVar.f78290l;
        xa.a aVar = this.E;
        if (aVar != null) {
            aVar.c();
        }
        this.E = new xa.a(new a(), dVar.e());
        dVar.h(this.f29199a.getContext(), this.E);
        b0();
    }

    public void j0(ColorStateList colorStateList) {
        if (this.f29227o != colorStateList) {
            this.f29227o = colorStateList;
            b0();
        }
    }

    public void k0(int i11) {
        if (this.f29219k != i11) {
            this.f29219k = i11;
            b0();
        }
    }

    public void l(Canvas canvas) {
        int save = canvas.save();
        if (this.H == null || this.f29215i.width() <= 0.0f || this.f29215i.height() <= 0.0f) {
            return;
        }
        this.V.setTextSize(this.O);
        float f11 = this.f29238u;
        float f12 = this.f29239v;
        boolean z10 = this.K && this.L != null;
        float f13 = this.N;
        if (f13 != 1.0f && !this.f29203c) {
            canvas.scale(f13, f13, f11, f12);
        }
        if (z10) {
            canvas.drawBitmap(this.L, f11, f12, this.M);
            canvas.restoreToCount(save);
            return;
        }
        if (!P0() || (this.f29203c && this.f29201b <= this.f29207e)) {
            canvas.translate(f11, f12);
            this.f29220k0.draw(canvas);
        } else {
            m(canvas, this.f29238u - this.f29220k0.getLineStart(0), f12);
        }
        canvas.restoreToCount(save);
    }

    public void l0(float f11) {
        if (this.f29223m != f11) {
            this.f29223m = f11;
            b0();
        }
    }

    public void m0(Typeface typeface) {
        if (n0(typeface)) {
            b0();
        }
    }

    public void o(RectF rectF, int i11, int i12) {
        this.I = f(this.G);
        rectF.left = Math.max(s(i11, i12), this.f29213h.left);
        rectF.top = this.f29213h.top;
        rectF.right = Math.min(t(rectF, i11, i12), this.f29213h.right);
        rectF.bottom = this.f29213h.top + r();
    }

    public void o0(int i11) {
        this.f29209f = i11;
    }

    public ColorStateList p() {
        return this.f29227o;
    }

    public void p0(int i11, int i12, int i13, int i14) {
        if (d0(this.f29211g, i11, i12, i13, i14)) {
            return;
        }
        this.f29211g.set(i11, i12, i13, i14);
        this.U = true;
    }

    public int q() {
        return this.f29219k;
    }

    public void q0(Rect rect) {
        p0(rect.left, rect.top, rect.right, rect.bottom);
    }

    public float r() {
        P(this.W);
        return -this.W.ascent();
    }

    public void r0(float f11) {
        if (this.f29216i0 != f11) {
            this.f29216i0 = f11;
            b0();
        }
    }

    public void s0(int i11) {
        xa.d dVar = new xa.d(this.f29199a.getContext(), i11);
        if (dVar.i() != null) {
            this.f29225n = dVar.i();
        }
        if (dVar.j() != 0.0f) {
            this.f29221l = dVar.j();
        }
        ColorStateList colorStateList = dVar.f78281c;
        if (colorStateList != null) {
            this.f29212g0 = colorStateList;
        }
        this.f29208e0 = dVar.f78286h;
        this.f29210f0 = dVar.f78287i;
        this.f29206d0 = dVar.f78288j;
        this.f29216i0 = dVar.f78290l;
        xa.a aVar = this.D;
        if (aVar != null) {
            aVar.c();
        }
        this.D = new xa.a(new C0399b(), dVar.e());
        dVar.h(this.f29199a.getContext(), this.D);
        b0();
    }

    public float u() {
        return this.f29223m;
    }

    public void u0(ColorStateList colorStateList) {
        if (this.f29225n != colorStateList) {
            this.f29225n = colorStateList;
            b0();
        }
    }

    public Typeface v() {
        Typeface typeface = this.f29240w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public void v0(int i11) {
        if (this.f29217j != i11) {
            this.f29217j = i11;
            b0();
        }
    }

    public int w() {
        return x(this.f29227o);
    }

    public void w0(float f11) {
        if (this.f29221l != f11) {
            this.f29221l = f11;
            b0();
        }
    }

    public void x0(Typeface typeface) {
        if (y0(typeface)) {
            b0();
        }
    }

    public int z() {
        return this.f29229p;
    }

    public void z0(float f11) {
        float a11 = d1.a.a(f11, 0.0f, 1.0f);
        if (a11 != this.f29201b) {
            this.f29201b = a11;
            c();
        }
    }
}

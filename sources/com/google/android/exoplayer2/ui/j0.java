package com.google.android.exoplayer2.ui;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
final class j0 {
    private int A;
    private int B;
    private int C;
    private int D;
    private StaticLayout E;
    private StaticLayout F;
    private int G;
    private int H;
    private int I;
    private Rect J;

    /* renamed from: a, reason: collision with root package name */
    private final float f27220a;

    /* renamed from: b, reason: collision with root package name */
    private final float f27221b;

    /* renamed from: c, reason: collision with root package name */
    private final float f27222c;

    /* renamed from: d, reason: collision with root package name */
    private final float f27223d;

    /* renamed from: e, reason: collision with root package name */
    private final float f27224e;

    /* renamed from: f, reason: collision with root package name */
    private final TextPaint f27225f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f27226g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f27227h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f27228i;

    /* renamed from: j, reason: collision with root package name */
    private Layout.Alignment f27229j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f27230k;

    /* renamed from: l, reason: collision with root package name */
    private float f27231l;

    /* renamed from: m, reason: collision with root package name */
    private int f27232m;

    /* renamed from: n, reason: collision with root package name */
    private int f27233n;

    /* renamed from: o, reason: collision with root package name */
    private float f27234o;

    /* renamed from: p, reason: collision with root package name */
    private int f27235p;

    /* renamed from: q, reason: collision with root package name */
    private float f27236q;

    /* renamed from: r, reason: collision with root package name */
    private float f27237r;

    /* renamed from: s, reason: collision with root package name */
    private int f27238s;

    /* renamed from: t, reason: collision with root package name */
    private int f27239t;

    /* renamed from: u, reason: collision with root package name */
    private int f27240u;

    /* renamed from: v, reason: collision with root package name */
    private int f27241v;

    /* renamed from: w, reason: collision with root package name */
    private int f27242w;

    /* renamed from: x, reason: collision with root package name */
    private float f27243x;

    /* renamed from: y, reason: collision with root package name */
    private float f27244y;

    /* renamed from: z, reason: collision with root package name */
    private float f27245z;

    public j0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f27224e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f27223d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f27220a = round;
        this.f27221b = round;
        this.f27222c = round;
        TextPaint textPaint = new TextPaint();
        this.f27225f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f27226g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f27227h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f27230k, (Rect) null, this.J, this.f27227h);
    }

    private void d(Canvas canvas, boolean z10) {
        if (z10) {
            e(canvas);
            return;
        }
        com.google.android.exoplayer2.util.a.e(this.J);
        com.google.android.exoplayer2.util.a.e(this.f27230k);
        c(canvas);
    }

    private void e(Canvas canvas) {
        StaticLayout staticLayout = this.E;
        StaticLayout staticLayout2 = this.F;
        if (staticLayout == null || staticLayout2 == null) {
            return;
        }
        int save = canvas.save();
        canvas.translate(this.G, this.H);
        if (Color.alpha(this.f27240u) > 0) {
            this.f27226g.setColor(this.f27240u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f27226g);
        }
        int i11 = this.f27242w;
        if (i11 == 1) {
            this.f27225f.setStrokeJoin(Paint.Join.ROUND);
            this.f27225f.setStrokeWidth(this.f27220a);
            this.f27225f.setColor(this.f27241v);
            this.f27225f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i11 == 2) {
            TextPaint textPaint = this.f27225f;
            float f11 = this.f27221b;
            float f12 = this.f27222c;
            textPaint.setShadowLayer(f11, f12, f12, this.f27241v);
        } else if (i11 == 3 || i11 == 4) {
            boolean z10 = i11 == 3;
            int i12 = z10 ? -1 : this.f27241v;
            int i13 = z10 ? this.f27241v : -1;
            float f13 = this.f27221b / 2.0f;
            this.f27225f.setColor(this.f27238s);
            this.f27225f.setStyle(Paint.Style.FILL);
            float f14 = -f13;
            this.f27225f.setShadowLayer(this.f27221b, f14, f14, i12);
            staticLayout2.draw(canvas);
            this.f27225f.setShadowLayer(this.f27221b, f13, f13, i13);
        }
        this.f27225f.setColor(this.f27238s);
        this.f27225f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f27225f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        canvas.restoreToCount(save);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void f() {
        /*
            r7 = this;
            android.graphics.Bitmap r0 = r7.f27230k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f27234o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f27231l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f27236q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f27237r
            r6 = -8388609(0xffffffffff7fffff, float:-3.4028235E38)
            int r6 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r6 == 0) goto L2e
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
            goto L3f
        L2e:
            float r3 = (float) r1
            int r5 = r0.getHeight()
            float r5 = (float) r5
            int r0 = r0.getWidth()
            float r0 = (float) r0
            float r5 = r5 / r0
            float r3 = r3 * r5
            int r0 = java.lang.Math.round(r3)
        L3f:
            int r3 = r7.f27235p
            r5 = 1
            r6 = 2
            if (r3 != r6) goto L48
            float r3 = (float) r1
        L46:
            float r2 = r2 - r3
            goto L4e
        L48:
            if (r3 != r5) goto L4e
            int r3 = r1 / 2
            float r3 = (float) r3
            goto L46
        L4e:
            int r2 = java.lang.Math.round(r2)
            int r3 = r7.f27233n
            if (r3 != r6) goto L59
            float r3 = (float) r0
        L57:
            float r4 = r4 - r3
            goto L5f
        L59:
            if (r3 != r5) goto L5f
            int r3 = r0 / 2
            float r3 = (float) r3
            goto L57
        L5f:
            int r3 = java.lang.Math.round(r4)
            android.graphics.Rect r4 = new android.graphics.Rect
            int r1 = r1 + r2
            int r0 = r0 + r3
            r4.<init>(r2, r3, r1, r0)
            r7.J = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.j0.f():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void g() {
        /*
            Method dump skipped, instructions count: 489
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.j0.g():void");
    }

    public void b(ba.b bVar, c cVar, float f11, float f12, float f13, Canvas canvas, int i11, int i12, int i13, int i14) {
        int i15;
        boolean z10 = bVar.f16336d == null;
        if (!z10) {
            i15 = ViewCompat.MEASURED_STATE_MASK;
        } else if (TextUtils.isEmpty(bVar.f16333a)) {
            return;
        } else {
            i15 = bVar.f16344l ? bVar.f16345m : cVar.f27167c;
        }
        if (a(this.f27228i, bVar.f16333a) && com.google.android.exoplayer2.util.p0.c(this.f27229j, bVar.f16334b) && this.f27230k == bVar.f16336d && this.f27231l == bVar.f16337e && this.f27232m == bVar.f16338f && com.google.android.exoplayer2.util.p0.c(Integer.valueOf(this.f27233n), Integer.valueOf(bVar.f16339g)) && this.f27234o == bVar.f16340h && com.google.android.exoplayer2.util.p0.c(Integer.valueOf(this.f27235p), Integer.valueOf(bVar.f16341i)) && this.f27236q == bVar.f16342j && this.f27237r == bVar.f16343k && this.f27238s == cVar.f27165a && this.f27239t == cVar.f27166b && this.f27240u == i15 && this.f27242w == cVar.f27168d && this.f27241v == cVar.f27169e && com.google.android.exoplayer2.util.p0.c(this.f27225f.getTypeface(), cVar.f27170f) && this.f27243x == f11 && this.f27244y == f12 && this.f27245z == f13 && this.A == i11 && this.B == i12 && this.C == i13 && this.D == i14) {
            d(canvas, z10);
            return;
        }
        this.f27228i = bVar.f16333a;
        this.f27229j = bVar.f16334b;
        this.f27230k = bVar.f16336d;
        this.f27231l = bVar.f16337e;
        this.f27232m = bVar.f16338f;
        this.f27233n = bVar.f16339g;
        this.f27234o = bVar.f16340h;
        this.f27235p = bVar.f16341i;
        this.f27236q = bVar.f16342j;
        this.f27237r = bVar.f16343k;
        this.f27238s = cVar.f27165a;
        this.f27239t = cVar.f27166b;
        this.f27240u = i15;
        this.f27242w = cVar.f27168d;
        this.f27241v = cVar.f27169e;
        this.f27225f.setTypeface(cVar.f27170f);
        this.f27243x = f11;
        this.f27244y = f12;
        this.f27245z = f13;
        this.A = i11;
        this.B = i12;
        this.C = i13;
        this.D = i14;
        if (z10) {
            com.google.android.exoplayer2.util.a.e(this.f27228i);
            g();
        } else {
            com.google.android.exoplayer2.util.a.e(this.f27230k);
            f();
        }
        d(canvas, z10);
    }
}

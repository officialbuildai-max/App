package androidx.media3.ui;

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
import java.util.Objects;

/* loaded from: classes2.dex */
final class u0 {
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
    private final float f13809a;

    /* renamed from: b, reason: collision with root package name */
    private final float f13810b;

    /* renamed from: c, reason: collision with root package name */
    private final float f13811c;

    /* renamed from: d, reason: collision with root package name */
    private final float f13812d;

    /* renamed from: e, reason: collision with root package name */
    private final float f13813e;

    /* renamed from: f, reason: collision with root package name */
    private final TextPaint f13814f;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f13815g;

    /* renamed from: h, reason: collision with root package name */
    private final Paint f13816h;

    /* renamed from: i, reason: collision with root package name */
    private CharSequence f13817i;

    /* renamed from: j, reason: collision with root package name */
    private Layout.Alignment f13818j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f13819k;

    /* renamed from: l, reason: collision with root package name */
    private float f13820l;

    /* renamed from: m, reason: collision with root package name */
    private int f13821m;

    /* renamed from: n, reason: collision with root package name */
    private int f13822n;

    /* renamed from: o, reason: collision with root package name */
    private float f13823o;

    /* renamed from: p, reason: collision with root package name */
    private int f13824p;

    /* renamed from: q, reason: collision with root package name */
    private float f13825q;

    /* renamed from: r, reason: collision with root package name */
    private float f13826r;

    /* renamed from: s, reason: collision with root package name */
    private int f13827s;

    /* renamed from: t, reason: collision with root package name */
    private int f13828t;

    /* renamed from: u, reason: collision with root package name */
    private int f13829u;

    /* renamed from: v, reason: collision with root package name */
    private int f13830v;

    /* renamed from: w, reason: collision with root package name */
    private int f13831w;

    /* renamed from: x, reason: collision with root package name */
    private float f13832x;

    /* renamed from: y, reason: collision with root package name */
    private float f13833y;

    /* renamed from: z, reason: collision with root package name */
    private float f13834z;

    public u0(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, new int[]{R.attr.lineSpacingExtra, R.attr.lineSpacingMultiplier}, 0, 0);
        this.f13813e = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f13812d = obtainStyledAttributes.getFloat(1, 1.0f);
        obtainStyledAttributes.recycle();
        float round = Math.round((context.getResources().getDisplayMetrics().densityDpi * 2.0f) / 160.0f);
        this.f13809a = round;
        this.f13810b = round;
        this.f13811c = round;
        TextPaint textPaint = new TextPaint();
        this.f13814f = textPaint;
        textPaint.setAntiAlias(true);
        textPaint.setSubpixelText(true);
        Paint paint = new Paint();
        this.f13815g = paint;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f13816h = paint2;
        paint2.setAntiAlias(true);
        paint2.setFilterBitmap(true);
    }

    private static boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return charSequence == charSequence2 || (charSequence != null && charSequence.equals(charSequence2));
    }

    private void c(Canvas canvas) {
        canvas.drawBitmap(this.f13819k, (Rect) null, this.J, this.f13816h);
    }

    private void d(Canvas canvas, boolean z10) {
        if (z10) {
            e(canvas);
            return;
        }
        androidx.media3.common.util.a.e(this.J);
        androidx.media3.common.util.a.e(this.f13819k);
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
        if (Color.alpha(this.f13829u) > 0) {
            this.f13815g.setColor(this.f13829u);
            canvas.drawRect(-this.I, 0.0f, staticLayout.getWidth() + this.I, staticLayout.getHeight(), this.f13815g);
        }
        int i11 = this.f13831w;
        if (i11 == 1) {
            this.f13814f.setStrokeJoin(Paint.Join.ROUND);
            this.f13814f.setStrokeWidth(this.f13809a);
            this.f13814f.setColor(this.f13830v);
            this.f13814f.setStyle(Paint.Style.FILL_AND_STROKE);
            staticLayout2.draw(canvas);
        } else if (i11 == 2) {
            TextPaint textPaint = this.f13814f;
            float f11 = this.f13810b;
            float f12 = this.f13811c;
            textPaint.setShadowLayer(f11, f12, f12, this.f13830v);
        } else if (i11 == 3 || i11 == 4) {
            boolean z10 = i11 == 3;
            int i12 = z10 ? -1 : this.f13830v;
            int i13 = z10 ? this.f13830v : -1;
            float f13 = this.f13810b / 2.0f;
            this.f13814f.setColor(this.f13827s);
            this.f13814f.setStyle(Paint.Style.FILL);
            float f14 = -f13;
            this.f13814f.setShadowLayer(this.f13810b, f14, f14, i12);
            staticLayout2.draw(canvas);
            this.f13814f.setShadowLayer(this.f13810b, f13, f13, i13);
        }
        this.f13814f.setColor(this.f13827s);
        this.f13814f.setStyle(Paint.Style.FILL);
        staticLayout.draw(canvas);
        this.f13814f.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
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
            android.graphics.Bitmap r0 = r7.f13819k
            int r1 = r7.C
            int r2 = r7.A
            int r1 = r1 - r2
            int r3 = r7.D
            int r4 = r7.B
            int r3 = r3 - r4
            float r2 = (float) r2
            float r1 = (float) r1
            float r5 = r7.f13823o
            float r5 = r5 * r1
            float r2 = r2 + r5
            float r4 = (float) r4
            float r3 = (float) r3
            float r5 = r7.f13820l
            float r5 = r5 * r3
            float r4 = r4 + r5
            float r5 = r7.f13825q
            float r1 = r1 * r5
            int r1 = java.lang.Math.round(r1)
            float r5 = r7.f13826r
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
            int r3 = r7.f13824p
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
            int r3 = r7.f13822n
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.u0.f():void");
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.u0.g():void");
    }

    public void b(u1.a aVar, b bVar, float f11, float f12, float f13, Canvas canvas, int i11, int i12, int i13, int i14) {
        int i15;
        boolean z10 = aVar.f76684d == null;
        if (!z10) {
            i15 = ViewCompat.MEASURED_STATE_MASK;
        } else if (TextUtils.isEmpty(aVar.f76681a)) {
            return;
        } else {
            i15 = aVar.f76692l ? aVar.f76693m : bVar.f13716c;
        }
        if (a(this.f13817i, aVar.f76681a) && Objects.equals(this.f13818j, aVar.f76682b) && this.f13819k == aVar.f76684d && this.f13820l == aVar.f76685e && this.f13821m == aVar.f76686f && Integer.valueOf(this.f13822n).equals(Integer.valueOf(aVar.f76687g)) && this.f13823o == aVar.f76688h && Integer.valueOf(this.f13824p).equals(Integer.valueOf(aVar.f76689i)) && this.f13825q == aVar.f76690j && this.f13826r == aVar.f76691k && this.f13827s == bVar.f13714a && this.f13828t == bVar.f13715b && this.f13829u == i15 && this.f13831w == bVar.f13717d && this.f13830v == bVar.f13718e && Objects.equals(this.f13814f.getTypeface(), bVar.f13719f) && this.f13832x == f11 && this.f13833y == f12 && this.f13834z == f13 && this.A == i11 && this.B == i12 && this.C == i13 && this.D == i14) {
            d(canvas, z10);
            return;
        }
        this.f13817i = aVar.f76681a;
        this.f13818j = aVar.f76682b;
        this.f13819k = aVar.f76684d;
        this.f13820l = aVar.f76685e;
        this.f13821m = aVar.f76686f;
        this.f13822n = aVar.f76687g;
        this.f13823o = aVar.f76688h;
        this.f13824p = aVar.f76689i;
        this.f13825q = aVar.f76690j;
        this.f13826r = aVar.f76691k;
        this.f13827s = bVar.f13714a;
        this.f13828t = bVar.f13715b;
        this.f13829u = i15;
        this.f13831w = bVar.f13717d;
        this.f13830v = bVar.f13718e;
        this.f13814f.setTypeface(bVar.f13719f);
        this.f13832x = f11;
        this.f13833y = f12;
        this.f13834z = f13;
        this.A = i11;
        this.B = i12;
        this.C = i13;
        this.D = i14;
        if (z10) {
            androidx.media3.common.util.a.e(this.f13817i);
            g();
        } else {
            androidx.media3.common.util.a.e(this.f13819k);
            f();
        }
        d(canvas, z10);
    }
}

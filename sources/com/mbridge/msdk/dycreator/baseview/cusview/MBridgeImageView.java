package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class MBridgeImageView extends ImageView {

    /* renamed from: a, reason: collision with root package name */
    private Xfermode f34665a;

    /* renamed from: b, reason: collision with root package name */
    private int f34666b;

    /* renamed from: c, reason: collision with root package name */
    private int f34667c;

    /* renamed from: d, reason: collision with root package name */
    private int f34668d;

    /* renamed from: e, reason: collision with root package name */
    private int f34669e;

    /* renamed from: f, reason: collision with root package name */
    private int f34670f;

    /* renamed from: g, reason: collision with root package name */
    private int f34671g;

    /* renamed from: h, reason: collision with root package name */
    private int f34672h;

    /* renamed from: i, reason: collision with root package name */
    private int f34673i;

    /* renamed from: j, reason: collision with root package name */
    private int f34674j;

    /* renamed from: k, reason: collision with root package name */
    private float[] f34675k;

    /* renamed from: l, reason: collision with root package name */
    private float[] f34676l;

    /* renamed from: m, reason: collision with root package name */
    private RectF f34677m;

    /* renamed from: n, reason: collision with root package name */
    private RectF f34678n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f34679o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f34680p;

    /* renamed from: q, reason: collision with root package name */
    private Path f34681q;

    /* renamed from: r, reason: collision with root package name */
    private Paint f34682r;

    public MBridgeImageView(Context context) {
        this(context, null);
    }

    public MBridgeImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBridgeImageView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34681q = new Path();
        this.f34682r = new Paint();
        this.f34675k = new float[8];
        this.f34676l = new float[8];
        this.f34678n = new RectF();
        this.f34677m = new RectF();
        this.f34665a = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }

    private void a() {
        if (this.f34675k == null || this.f34676l == null) {
            return;
        }
        int i11 = 0;
        while (true) {
            try {
                float[] fArr = this.f34675k;
                if (i11 >= fArr.length) {
                    return;
                }
                float f11 = this.f34668d;
                fArr[i11] = f11;
                this.f34676l[i11] = f11 - (this.f34673i / 2.0f);
                i11++;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
    }

    private void a(int i11, int i12) {
        Path path = this.f34681q;
        if (path != null) {
            path.reset();
        }
        Paint paint = this.f34682r;
        if (paint != null) {
            paint.setStrokeWidth(i11);
            this.f34682r.setColor(i12);
            this.f34682r.setStyle(Paint.Style.STROKE);
        }
    }

    private void a(Canvas canvas) {
        a(canvas, this.f34673i, this.f34674j, this.f34678n, this.f34675k);
    }

    private void a(Canvas canvas, int i11, int i12, RectF rectF, float[] fArr) {
        try {
            a(i11, i12);
            Path path = this.f34681q;
            if (path != null) {
                path.addRoundRect(rectF, fArr, Path.Direction.CCW);
            }
            if (canvas != null) {
                canvas.drawPath(this.f34681q, this.f34682r);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void b() {
        int i11;
        int i12;
        int i13;
        try {
            if (this.f34675k == null || this.f34676l == null) {
                return;
            }
            int i14 = 0;
            while (true) {
                i11 = 2;
                if (i14 >= 2) {
                    break;
                }
                float[] fArr = this.f34675k;
                float f11 = this.f34669e;
                fArr[i14] = f11;
                this.f34676l[i14] = f11 - (this.f34673i / 2.0f);
                i14++;
            }
            while (true) {
                i12 = 4;
                if (i11 >= 4) {
                    break;
                }
                float[] fArr2 = this.f34675k;
                float f12 = this.f34670f;
                fArr2[i11] = f12;
                this.f34676l[i11] = f12 - (this.f34673i / 2.0f);
                i11++;
            }
            while (true) {
                if (i12 >= 6) {
                    break;
                }
                float[] fArr3 = this.f34675k;
                float f13 = this.f34671g;
                fArr3[i12] = f13;
                this.f34676l[i12] = f13 - (this.f34673i / 2.0f);
                i12++;
            }
            for (i13 = 6; i13 < 8; i13++) {
                float[] fArr4 = this.f34675k;
                float f14 = this.f34672h;
                fArr4[i13] = f14;
                this.f34676l[i13] = f14 - (this.f34673i / 2.0f);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void c() {
        RectF rectF = this.f34678n;
        if (rectF != null) {
            float f11 = this.f34673i / 2.0f;
            rectF.set(f11, f11, this.f34666b - f11, this.f34667c - f11);
        }
    }

    private void d() {
        RectF rectF = this.f34677m;
        if (rectF != null) {
            rectF.set(0.0f, 0.0f, this.f34666b, this.f34667c);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        try {
            canvas.saveLayer(this.f34677m, null, 31);
            int i11 = this.f34666b;
            int i12 = this.f34673i * 2;
            float f11 = (i11 - i12) * 1.0f;
            float f12 = i11;
            float f13 = this.f34667c;
            canvas.scale(f11 / f12, ((r5 - i12) * 1.0f) / f13, f12 / 2.0f, f13 / 2.0f);
            super.onDraw(canvas);
            Paint paint = this.f34682r;
            if (paint != null) {
                paint.reset();
                this.f34682r.setAntiAlias(true);
                this.f34682r.setStyle(Paint.Style.FILL);
                this.f34682r.setXfermode(this.f34665a);
            }
            Path path = this.f34681q;
            if (path != null) {
                path.reset();
                this.f34681q.addRoundRect(this.f34677m, this.f34676l, Path.Direction.CCW);
            }
            canvas.drawPath(this.f34681q, this.f34682r);
            Paint paint2 = this.f34682r;
            if (paint2 != null) {
                paint2.setXfermode(null);
            }
            canvas.restore();
            if (this.f34679o) {
                a(canvas);
            }
        } catch (Exception e11) {
            o0.a("MBridgeImageView", e11.getMessage());
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f34666b = i11;
        this.f34667c = i12;
        if (this.f34680p) {
            b();
        } else {
            a();
        }
        c();
        d();
    }

    public void setBorder(int i11, int i12, int i13) {
        this.f34679o = true;
        this.f34673i = i12;
        this.f34674j = i13;
        this.f34668d = i11;
    }

    public void setCornerRadius(int i11) {
        this.f34668d = i11;
    }

    public void setCustomBorder(int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f34679o = true;
        this.f34680p = true;
        this.f34673i = i15;
        this.f34674j = i16;
        this.f34669e = i11;
        this.f34671g = i13;
        this.f34670f = i12;
        this.f34672h = i14;
    }
}

package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

/* loaded from: classes5.dex */
public class ProgressBar extends View {

    /* renamed from: a, reason: collision with root package name */
    Runnable f35900a;

    /* renamed from: b, reason: collision with root package name */
    private float f35901b;

    /* renamed from: c, reason: collision with root package name */
    private float f35902c;

    /* renamed from: d, reason: collision with root package name */
    private float f35903d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f35904e;

    /* renamed from: f, reason: collision with root package name */
    private float f35905f;

    /* renamed from: g, reason: collision with root package name */
    private long f35906g;

    /* renamed from: h, reason: collision with root package name */
    private Handler f35907h;

    /* renamed from: i, reason: collision with root package name */
    private Drawable f35908i;

    /* renamed from: j, reason: collision with root package name */
    private int f35909j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f35910k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f35911l;

    /* renamed from: m, reason: collision with root package name */
    private long f35912m;

    /* renamed from: n, reason: collision with root package name */
    private float f35913n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f35914o;

    /* renamed from: p, reason: collision with root package name */
    private Drawable f35915p;

    /* renamed from: q, reason: collision with root package name */
    private Rect f35916q;

    /* renamed from: r, reason: collision with root package name */
    private Drawable f35917r;

    /* renamed from: s, reason: collision with root package name */
    private float f35918s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f35919t;

    /* renamed from: u, reason: collision with root package name */
    private int f35920u;

    /* renamed from: v, reason: collision with root package name */
    private int f35921v;

    /* renamed from: w, reason: collision with root package name */
    private int f35922w;

    /* renamed from: x, reason: collision with root package name */
    private long f35923x;

    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ProgressBar.this.invalidate();
        }
    }

    public ProgressBar(Context context) {
        super(context);
        this.f35900a = new a();
        this.f35906g = 25L;
        this.f35907h = new Handler(Looper.getMainLooper());
        this.f35910k = false;
        this.f35913n = 0.95f;
        this.f35914o = false;
        this.f35916q = new Rect();
        a(context);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f35900a = new a();
        this.f35906g = 25L;
        this.f35907h = new Handler(Looper.getMainLooper());
        this.f35910k = false;
        this.f35913n = 0.95f;
        this.f35914o = false;
        this.f35916q = new Rect();
        a(context);
    }

    private void a(Context context) {
        setWillNotDraw(false);
    }

    private void a(Canvas canvas, float f11) {
        Drawable drawable;
        Drawable drawable2;
        if (this.f35919t) {
            float f12 = this.f35905f;
            float f13 = this.f35918s * 0.5f;
            int i11 = (int) ((1.0f - (f12 / f13)) * 255.0f);
            if (i11 < 0) {
                i11 = 0;
            }
            if (f12 > f13) {
                setVisible(false);
            }
            Drawable drawable3 = this.f35917r;
            if (drawable3 != null) {
                drawable3.setAlpha(i11);
            }
            Drawable drawable4 = this.f35904e;
            if (drawable4 != null) {
                drawable4.setAlpha(i11);
            }
            Drawable drawable5 = this.f35915p;
            if (drawable5 != null) {
                drawable5.setAlpha(i11);
            }
            canvas.save();
            canvas.translate(this.f35905f, 0.0f);
        }
        if (this.f35917r != null && this.f35915p != null) {
            Drawable drawable6 = this.f35917r;
            drawable6.setBounds(0, 0, (int) (this.f35916q.width() - (this.f35915p.getIntrinsicWidth() * 0.05f)), drawable6.getIntrinsicHeight());
            this.f35917r.draw(canvas);
        }
        if (this.f35919t && (drawable2 = this.f35904e) != null && this.f35915p != null) {
            int intrinsicWidth = drawable2.getIntrinsicWidth();
            Drawable drawable7 = this.f35904e;
            drawable7.setBounds(0, 0, intrinsicWidth, drawable7.getIntrinsicHeight());
            canvas.save();
            canvas.translate(-intrinsicWidth, 0.0f);
            this.f35904e.draw(canvas);
            canvas.restore();
        }
        if (this.f35915p != null) {
            canvas.save();
            canvas.translate(this.f35916q.width() - getWidth(), 0.0f);
            this.f35915p.draw(canvas);
            canvas.restore();
        }
        if (!this.f35919t && Math.abs(this.f35901b - this.f35913n) < 1.0E-5f && (drawable = this.f35908i) != null) {
            int i12 = (int) (this.f35909j + (f11 * 0.2f * this.f35918s));
            this.f35909j = i12;
            if (i12 + drawable.getIntrinsicWidth() >= this.f35916q.width()) {
                this.f35909j = -this.f35908i.getIntrinsicWidth();
            }
            canvas.save();
            canvas.translate(this.f35909j, 0.0f);
            this.f35908i.draw(canvas);
            canvas.restore();
        }
        if (this.f35919t) {
            canvas.restore();
        }
    }

    private float getVelocity() {
        if (this.f35919t) {
            return this.f35911l ? 1.0f : 0.4f;
        }
        if (this.f35923x < 2000) {
            return this.f35921v == 1 ? this.f35911l ? 1.0f : 0.4f : this.f35920u == 1 ? this.f35911l ? 0.4f : 0.2f : this.f35911l ? 0.2f : 0.05f;
        }
        return 0.05f;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (!this.f35910k) {
            this.f35910k = true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = this.f35914o ? 0L : currentTimeMillis - this.f35912m;
        this.f35903d = Math.abs(((float) j11) / 1000.0f);
        this.f35912m = currentTimeMillis;
        this.f35923x += j11;
        float velocity = getVelocity();
        this.f35902c = velocity;
        float f11 = this.f35901b + (velocity * this.f35903d);
        this.f35901b = f11;
        if (!this.f35919t) {
            float f12 = this.f35913n;
            if (f11 > f12) {
                this.f35901b = f12;
            }
        }
        this.f35916q.right = (int) (this.f35901b * this.f35918s);
        this.f35907h.removeCallbacksAndMessages(null);
        this.f35907h.postDelayed(this.f35900a, this.f35906g);
        super.draw(canvas);
        a(canvas, this.f35903d);
    }

    @Override // android.view.View
    public Bitmap getDrawingCache(boolean z10) {
        return null;
    }

    public float getProgress() {
        return this.f35901b;
    }

    public void initResource(boolean z10) {
        if (z10 || (this.f35908i == null && this.f35915p == null && this.f35917r == null && this.f35904e == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.f35908i = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f35908i.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.f35915p = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f35915p.getIntrinsicHeight());
            }
            this.f35917r = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
            this.f35904e = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", com.mbridge.msdk.foundation.controller.c.m().h()));
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
    }

    @Override // android.view.View
    protected void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f35918s = getMeasuredWidth();
    }

    public void onThemeChange() {
        if (this.f35910k) {
            initResource(true);
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z10) {
        super.onWindowFocusChanged(z10);
        Drawable drawable = this.f35908i;
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) (drawable.getIntrinsicWidth() * 1.5d), getHeight());
        }
        Drawable drawable2 = this.f35915p;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    public void setPaused(boolean z10) {
        this.f35914o = z10;
        if (z10) {
            return;
        }
        this.f35912m = System.currentTimeMillis();
    }

    public void setProgress(float f11, boolean z10) {
        if (!z10 || f11 < 1.0f) {
            return;
        }
        startEndAnimation();
    }

    public void setProgressBarListener(c cVar) {
    }

    public void setProgressState(int i11) {
        if (i11 == 5) {
            this.f35920u = 1;
            this.f35921v = 0;
            this.f35922w = 0;
            this.f35923x = 0L;
            return;
        }
        if (i11 == 6) {
            this.f35921v = 1;
            if (this.f35922w == 1) {
                startEndAnimation();
            }
            this.f35923x = 0L;
            return;
        }
        if (i11 == 7) {
            startEndAnimation();
        } else {
            if (i11 != 8) {
                return;
            }
            this.f35922w = 1;
            if (this.f35921v == 1) {
                startEndAnimation();
            }
        }
    }

    @Override // android.view.View
    public void setVisibility(int i11) {
        super.setVisibility(i11);
    }

    public void setVisible(boolean z10) {
        if (!z10) {
            setVisibility(4);
            return;
        }
        this.f35911l = true;
        this.f35912m = System.currentTimeMillis();
        this.f35903d = 0.0f;
        this.f35923x = 0L;
        this.f35919t = false;
        this.f35905f = 0.0f;
        this.f35901b = 0.0f;
        this.f35918s = getMeasuredWidth();
        this.f35914o = false;
        this.f35920u = 0;
        this.f35921v = 0;
        this.f35922w = 0;
        Drawable drawable = this.f35908i;
        if (drawable != null) {
            this.f35909j = -drawable.getIntrinsicWidth();
        } else {
            this.f35909j = 0;
        }
        Drawable drawable2 = this.f35917r;
        if (drawable2 != null) {
            drawable2.setAlpha(255);
        }
        Drawable drawable3 = this.f35904e;
        if (drawable3 != null) {
            drawable3.setAlpha(255);
        }
        Drawable drawable4 = this.f35915p;
        if (drawable4 != null) {
            drawable4.setAlpha(255);
        }
        setVisibility(0);
        invalidate();
    }

    public void startEndAnimation() {
        if (this.f35919t) {
            return;
        }
        this.f35919t = true;
        this.f35905f = 0.0f;
    }
}

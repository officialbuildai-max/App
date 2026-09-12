package com.bytedance.sdk.component.adexpress.vS;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.b;
import com.bumptech.glide.load.resource.drawable.c;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class Fmk extends ImageView {
    private float Dq;
    private AnimatedImageDrawable EjP;
    private boolean Fmk;
    private boolean HiB;
    private float Jcg;
    private Movie Sj;
    private int TEQ;
    private int TKC;
    private int Ym;

    /* renamed from: aa, reason: collision with root package name */
    private volatile boolean f20987aa;
    private long sP;
    private boolean sef;
    private float uA;
    private boolean vS;

    public Fmk(Context context) {
        super(context);
        this.HiB = Build.VERSION.SDK_INT >= 28;
        this.vS = false;
        this.Fmk = true;
        this.sef = true;
        Sj();
    }

    private void Sj(Canvas canvas) {
        Movie movie = this.Sj;
        if (movie == null) {
            return;
        }
        movie.setTime(this.TKC);
        float f11 = this.uA;
        if (f11 == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.Sj.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f11, f11);
            Movie movie2 = this.Sj;
            float f12 = this.Jcg;
            float f13 = this.uA;
            movie2.draw(canvas, f12 / f13, this.Dq / f13);
        }
        canvas.restore();
    }

    private void TKC() {
        if (this.Sj == null) {
            return;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.sP == 0) {
            this.sP = uptimeMillis;
        }
        int duration = this.Sj.duration();
        if (duration == 0) {
            duration = 1000;
        }
        if (this.sef || Math.abs(duration - this.TKC) >= 60) {
            this.TKC = (int) ((uptimeMillis - this.sP) % duration);
        } else {
            this.TKC = duration;
            this.f20987aa = true;
        }
    }

    private void sP() {
        if (this.Sj == null || this.HiB || !this.Fmk) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && b.a(drawable)) {
            AnimatedImageDrawable a11 = c.a(drawable);
            this.EjP = a11;
            if (!this.f20987aa) {
                a11.start();
            }
            if (!this.sef) {
                a11.setRepeatCount(0);
            }
        }
        sP();
    }

    void Sj() {
        if (this.HiB) {
            return;
        }
        setLayerType(1, null);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.Sj == null || this.HiB) {
            super.onDraw(canvas);
            return;
        }
        try {
            if (this.f20987aa) {
                Sj(canvas);
                return;
            }
            TKC();
            Sj(canvas);
            sP();
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        if (this.Sj != null && !this.HiB) {
            this.Jcg = (getWidth() - this.TEQ) / 2.0f;
            this.Dq = (getHeight() - this.Ym) / 2.0f;
        }
        this.Fmk = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i11, int i12) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i11, i12);
        if (this.HiB || (movie = this.Sj) == null) {
            return;
        }
        int width = movie.width();
        int height = this.Sj.height();
        float max = 1.0f / Math.max((View.MeasureSpec.getMode(i11) == 0 || width <= (size2 = View.MeasureSpec.getSize(i11))) ? 1.0f : width / size2, (View.MeasureSpec.getMode(i12) == 0 || height <= (size = View.MeasureSpec.getSize(i12))) ? 1.0f : height / size);
        this.uA = max;
        int i13 = (int) (width * max);
        this.TEQ = i13;
        int i14 = (int) (height * max);
        this.Ym = i14;
        setMeasuredDimension(i13, i14);
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    public void onScreenStateChanged(int i11) {
        super.onScreenStateChanged(i11);
        if (this.Sj != null) {
            this.Fmk = i11 == 1;
            sP();
        }
    }

    @Override // android.view.View
    @SuppressLint({"NewApi"})
    protected void onVisibilityChanged(View view, int i11) {
        super.onVisibilityChanged(view, i11);
        if (this.Sj != null) {
            this.Fmk = i11 == 0;
            sP();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i11) {
        super.onWindowVisibilityChanged(i11);
        if (this.Sj != null) {
            this.Fmk = i11 == 0;
            sP();
        }
    }

    public void setRepeatConfig(boolean z10) {
        AnimatedImageDrawable animatedImageDrawable;
        this.sef = z10;
        if (z10) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.EjP) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception unused) {
        }
    }
}

package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.motion.widget.p;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.ViewCompat;
import com.tn.lib.view.FlowLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    private v0.b A;
    private RectF A0;
    private b B;
    private View B0;
    private androidx.constraintlayout.motion.widget.b C;
    private Matrix C0;
    boolean D;
    ArrayList D0;
    int E;
    int F;
    int G;
    int H;
    boolean I;
    float J;
    float K;
    long L;
    float M;
    private boolean N;
    private ArrayList O;
    private ArrayList P;
    private ArrayList Q;
    private CopyOnWriteArrayList R;
    private int S;
    private long T;
    private float U;
    private int V;
    private float W;

    /* renamed from: a, reason: collision with root package name */
    p f7221a;

    /* renamed from: a0, reason: collision with root package name */
    boolean f7222a0;

    /* renamed from: b, reason: collision with root package name */
    Interpolator f7223b;

    /* renamed from: b0, reason: collision with root package name */
    protected boolean f7224b0;

    /* renamed from: c, reason: collision with root package name */
    Interpolator f7225c;

    /* renamed from: c0, reason: collision with root package name */
    int f7226c0;

    /* renamed from: d, reason: collision with root package name */
    float f7227d;

    /* renamed from: d0, reason: collision with root package name */
    int f7228d0;

    /* renamed from: e, reason: collision with root package name */
    private int f7229e;

    /* renamed from: e0, reason: collision with root package name */
    int f7230e0;

    /* renamed from: f, reason: collision with root package name */
    int f7231f;

    /* renamed from: f0, reason: collision with root package name */
    int f7232f0;

    /* renamed from: g, reason: collision with root package name */
    private int f7233g;

    /* renamed from: g0, reason: collision with root package name */
    int f7234g0;

    /* renamed from: h, reason: collision with root package name */
    private int f7235h;

    /* renamed from: h0, reason: collision with root package name */
    int f7236h0;

    /* renamed from: i, reason: collision with root package name */
    private int f7237i;

    /* renamed from: i0, reason: collision with root package name */
    float f7238i0;

    /* renamed from: j, reason: collision with root package name */
    private boolean f7239j;

    /* renamed from: j0, reason: collision with root package name */
    private androidx.constraintlayout.core.motion.utils.d f7240j0;

    /* renamed from: k, reason: collision with root package name */
    HashMap f7241k;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f7242k0;

    /* renamed from: l, reason: collision with root package name */
    private long f7243l;

    /* renamed from: l0, reason: collision with root package name */
    private g f7244l0;

    /* renamed from: m, reason: collision with root package name */
    private float f7245m;

    /* renamed from: m0, reason: collision with root package name */
    private Runnable f7246m0;

    /* renamed from: n, reason: collision with root package name */
    float f7247n;

    /* renamed from: n0, reason: collision with root package name */
    private int[] f7248n0;

    /* renamed from: o, reason: collision with root package name */
    float f7249o;

    /* renamed from: o0, reason: collision with root package name */
    int f7250o0;

    /* renamed from: p, reason: collision with root package name */
    private long f7251p;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f7252p0;

    /* renamed from: q, reason: collision with root package name */
    float f7253q;

    /* renamed from: q0, reason: collision with root package name */
    int f7254q0;

    /* renamed from: r, reason: collision with root package name */
    private boolean f7255r;

    /* renamed from: r0, reason: collision with root package name */
    HashMap f7256r0;

    /* renamed from: s, reason: collision with root package name */
    boolean f7257s;

    /* renamed from: s0, reason: collision with root package name */
    private int f7258s0;

    /* renamed from: t, reason: collision with root package name */
    boolean f7259t;

    /* renamed from: t0, reason: collision with root package name */
    private int f7260t0;

    /* renamed from: u, reason: collision with root package name */
    private h f7261u;

    /* renamed from: u0, reason: collision with root package name */
    private int f7262u0;

    /* renamed from: v, reason: collision with root package name */
    private float f7263v;

    /* renamed from: v0, reason: collision with root package name */
    Rect f7264v0;

    /* renamed from: w, reason: collision with root package name */
    private float f7265w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f7266w0;

    /* renamed from: x, reason: collision with root package name */
    int f7267x;

    /* renamed from: x0, reason: collision with root package name */
    TransitionState f7268x0;

    /* renamed from: y, reason: collision with root package name */
    c f7269y;

    /* renamed from: y0, reason: collision with root package name */
    d f7270y0;

    /* renamed from: z, reason: collision with root package name */
    private boolean f7271z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f7272z0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f7273a;

        static {
            int[] iArr = new int[TransitionState.values().length];
            f7273a = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7273a[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7273a[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7273a[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends n {

        /* renamed from: a, reason: collision with root package name */
        float f7274a = 0.0f;

        /* renamed from: b, reason: collision with root package name */
        float f7275b = 0.0f;

        /* renamed from: c, reason: collision with root package name */
        float f7276c;

        b() {
        }

        @Override // androidx.constraintlayout.motion.widget.n
        public float a() {
            return MotionLayout.this.f7227d;
        }

        public void b(float f11, float f12, float f13) {
            this.f7274a = f11;
            this.f7275b = f12;
            this.f7276c = f13;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f11) {
            float f12;
            float f13;
            float f14 = this.f7274a;
            if (f14 > 0.0f) {
                float f15 = this.f7276c;
                if (f14 / f15 < f11) {
                    f11 = f14 / f15;
                }
                MotionLayout.this.f7227d = f14 - (f15 * f11);
                f12 = (f14 * f11) - (((f15 * f11) * f11) / 2.0f);
                f13 = this.f7275b;
            } else {
                float f16 = this.f7276c;
                if ((-f14) / f16 < f11) {
                    f11 = (-f14) / f16;
                }
                MotionLayout.this.f7227d = (f16 * f11) + f14;
                f12 = (f14 * f11) + (((f16 * f11) * f11) / 2.0f);
                f13 = this.f7275b;
            }
            return f12 + f13;
        }
    }

    /* loaded from: classes.dex */
    private class c {

        /* renamed from: a, reason: collision with root package name */
        float[] f7278a;

        /* renamed from: b, reason: collision with root package name */
        int[] f7279b;

        /* renamed from: c, reason: collision with root package name */
        float[] f7280c;

        /* renamed from: d, reason: collision with root package name */
        Path f7281d;

        /* renamed from: e, reason: collision with root package name */
        Paint f7282e;

        /* renamed from: f, reason: collision with root package name */
        Paint f7283f;

        /* renamed from: g, reason: collision with root package name */
        Paint f7284g;

        /* renamed from: h, reason: collision with root package name */
        Paint f7285h;

        /* renamed from: i, reason: collision with root package name */
        Paint f7286i;

        /* renamed from: j, reason: collision with root package name */
        private float[] f7287j;

        /* renamed from: p, reason: collision with root package name */
        DashPathEffect f7293p;

        /* renamed from: q, reason: collision with root package name */
        int f7294q;

        /* renamed from: t, reason: collision with root package name */
        int f7297t;

        /* renamed from: k, reason: collision with root package name */
        final int f7288k = -21965;

        /* renamed from: l, reason: collision with root package name */
        final int f7289l = -2067046;

        /* renamed from: m, reason: collision with root package name */
        final int f7290m = -13391360;

        /* renamed from: n, reason: collision with root package name */
        final int f7291n = 1996488704;

        /* renamed from: o, reason: collision with root package name */
        final int f7292o = 10;

        /* renamed from: r, reason: collision with root package name */
        Rect f7295r = new Rect();

        /* renamed from: s, reason: collision with root package name */
        boolean f7296s = false;

        public c() {
            this.f7297t = 1;
            Paint paint = new Paint();
            this.f7282e = paint;
            paint.setAntiAlias(true);
            this.f7282e.setColor(-21965);
            this.f7282e.setStrokeWidth(2.0f);
            Paint paint2 = this.f7282e;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            Paint paint3 = new Paint();
            this.f7283f = paint3;
            paint3.setAntiAlias(true);
            this.f7283f.setColor(-2067046);
            this.f7283f.setStrokeWidth(2.0f);
            this.f7283f.setStyle(style);
            Paint paint4 = new Paint();
            this.f7284g = paint4;
            paint4.setAntiAlias(true);
            this.f7284g.setColor(-13391360);
            this.f7284g.setStrokeWidth(2.0f);
            this.f7284g.setStyle(style);
            Paint paint5 = new Paint();
            this.f7285h = paint5;
            paint5.setAntiAlias(true);
            this.f7285h.setColor(-13391360);
            this.f7285h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.f7287j = new float[8];
            Paint paint6 = new Paint();
            this.f7286i = paint6;
            paint6.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.f7293p = dashPathEffect;
            this.f7284g.setPathEffect(dashPathEffect);
            this.f7280c = new float[100];
            this.f7279b = new int[50];
            if (this.f7296s) {
                this.f7282e.setStrokeWidth(8.0f);
                this.f7286i.setStrokeWidth(8.0f);
                this.f7283f.setStrokeWidth(8.0f);
                this.f7297t = 4;
            }
        }

        private void c(Canvas canvas) {
            canvas.drawLines(this.f7278a, this.f7282e);
        }

        private void d(Canvas canvas) {
            boolean z10 = false;
            boolean z11 = false;
            for (int i11 = 0; i11 < this.f7294q; i11++) {
                int i12 = this.f7279b[i11];
                if (i12 == 1) {
                    z10 = true;
                }
                if (i12 == 0) {
                    z11 = true;
                }
            }
            if (z10) {
                g(canvas);
            }
            if (z11) {
                e(canvas);
            }
        }

        private void e(Canvas canvas) {
            float[] fArr = this.f7278a;
            float f11 = fArr[0];
            float f12 = fArr[1];
            float f13 = fArr[fArr.length - 2];
            float f14 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f11, f13), Math.max(f12, f14), Math.max(f11, f13), Math.max(f12, f14), this.f7284g);
            canvas.drawLine(Math.min(f11, f13), Math.min(f12, f14), Math.min(f11, f13), Math.max(f12, f14), this.f7284g);
        }

        private void f(Canvas canvas, float f11, float f12) {
            float[] fArr = this.f7278a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[fArr.length - 2];
            float f16 = fArr[fArr.length - 1];
            float min = Math.min(f13, f15);
            float max = Math.max(f14, f16);
            float min2 = f11 - Math.min(f13, f15);
            float max2 = Math.max(f14, f16) - f12;
            String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f15 - f13)) + 0.5d)) / 100.0f);
            l(str, this.f7285h);
            canvas.drawText(str, ((min2 / 2.0f) - (this.f7295r.width() / 2)) + min, f12 - 20.0f, this.f7285h);
            canvas.drawLine(f11, f12, Math.min(f13, f15), f12, this.f7284g);
            String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f16 - f14)) + 0.5d)) / 100.0f);
            l(str2, this.f7285h);
            canvas.drawText(str2, f11 + 5.0f, max - ((max2 / 2.0f) - (this.f7295r.height() / 2)), this.f7285h);
            canvas.drawLine(f11, f12, f11, Math.max(f14, f16), this.f7284g);
        }

        private void g(Canvas canvas) {
            float[] fArr = this.f7278a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.f7284g);
        }

        private void h(Canvas canvas, float f11, float f12) {
            float[] fArr = this.f7278a;
            float f13 = fArr[0];
            float f14 = fArr[1];
            float f15 = fArr[fArr.length - 2];
            float f16 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f13 - f15, f14 - f16);
            float f17 = f15 - f13;
            float f18 = f16 - f14;
            float f19 = (((f11 - f13) * f17) + ((f12 - f14) * f18)) / (hypot * hypot);
            float f20 = f13 + (f17 * f19);
            float f21 = f14 + (f19 * f18);
            Path path = new Path();
            path.moveTo(f11, f12);
            path.lineTo(f20, f21);
            float hypot2 = (float) Math.hypot(f20 - f11, f21 - f12);
            String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            l(str, this.f7285h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.f7295r.width() / 2), -20.0f, this.f7285h);
            canvas.drawLine(f11, f12, f20, f21, this.f7284g);
        }

        private void i(Canvas canvas, float f11, float f12, int i11, int i12) {
            String str = "" + (((int) ((((f11 - (i11 / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i11)) + 0.5d)) / 100.0f);
            l(str, this.f7285h);
            canvas.drawText(str, ((f11 / 2.0f) - (this.f7295r.width() / 2)) + 0.0f, f12 - 20.0f, this.f7285h);
            canvas.drawLine(f11, f12, Math.min(0.0f, 1.0f), f12, this.f7284g);
            String str2 = "" + (((int) ((((f12 - (i12 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i12)) + 0.5d)) / 100.0f);
            l(str2, this.f7285h);
            canvas.drawText(str2, f11 + 5.0f, 0.0f - ((f12 / 2.0f) - (this.f7295r.height() / 2)), this.f7285h);
            canvas.drawLine(f11, f12, f11, Math.max(0.0f, 1.0f), this.f7284g);
        }

        private void j(Canvas canvas, m mVar) {
            this.f7281d.reset();
            for (int i11 = 0; i11 <= 50; i11++) {
                mVar.e(i11 / 50, this.f7287j, 0);
                Path path = this.f7281d;
                float[] fArr = this.f7287j;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.f7281d;
                float[] fArr2 = this.f7287j;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.f7281d;
                float[] fArr3 = this.f7287j;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.f7281d;
                float[] fArr4 = this.f7287j;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.f7281d.close();
            }
            this.f7282e.setColor(1140850688);
            canvas.translate(2.0f, 2.0f);
            canvas.drawPath(this.f7281d, this.f7282e);
            canvas.translate(-2.0f, -2.0f);
            this.f7282e.setColor(FlowLayout.SPACING_AUTO);
            canvas.drawPath(this.f7281d, this.f7282e);
        }

        private void k(Canvas canvas, int i11, int i12, m mVar) {
            int i13;
            int i14;
            float f11;
            float f12;
            View view = mVar.f7452b;
            if (view != null) {
                i13 = view.getWidth();
                i14 = mVar.f7452b.getHeight();
            } else {
                i13 = 0;
                i14 = 0;
            }
            for (int i15 = 1; i15 < i12 - 1; i15++) {
                if (i11 != 4 || this.f7279b[i15 - 1] != 0) {
                    float[] fArr = this.f7280c;
                    int i16 = i15 * 2;
                    float f13 = fArr[i16];
                    float f14 = fArr[i16 + 1];
                    this.f7281d.reset();
                    this.f7281d.moveTo(f13, f14 + 10.0f);
                    this.f7281d.lineTo(f13 + 10.0f, f14);
                    this.f7281d.lineTo(f13, f14 - 10.0f);
                    this.f7281d.lineTo(f13 - 10.0f, f14);
                    this.f7281d.close();
                    int i17 = i15 - 1;
                    mVar.q(i17);
                    if (i11 == 4) {
                        int i18 = this.f7279b[i17];
                        if (i18 == 1) {
                            h(canvas, f13 - 0.0f, f14 - 0.0f);
                        } else if (i18 == 0) {
                            f(canvas, f13 - 0.0f, f14 - 0.0f);
                        } else if (i18 == 2) {
                            f11 = f14;
                            f12 = f13;
                            i(canvas, f13 - 0.0f, f14 - 0.0f, i13, i14);
                            canvas.drawPath(this.f7281d, this.f7286i);
                        }
                        f11 = f14;
                        f12 = f13;
                        canvas.drawPath(this.f7281d, this.f7286i);
                    } else {
                        f11 = f14;
                        f12 = f13;
                    }
                    if (i11 == 2) {
                        h(canvas, f12 - 0.0f, f11 - 0.0f);
                    }
                    if (i11 == 3) {
                        f(canvas, f12 - 0.0f, f11 - 0.0f);
                    }
                    if (i11 == 6) {
                        i(canvas, f12 - 0.0f, f11 - 0.0f, i13, i14);
                    }
                    canvas.drawPath(this.f7281d, this.f7286i);
                }
            }
            float[] fArr2 = this.f7278a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f7283f);
                float[] fArr3 = this.f7278a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f7283f);
            }
        }

        public void a(Canvas canvas, HashMap hashMap, int i11, int i12) {
            if (hashMap == null || hashMap.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i12 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.f7233g) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.f7285h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.f7282e);
            }
            for (m mVar : hashMap.values()) {
                int m11 = mVar.m();
                if (i12 > 0 && m11 == 0) {
                    m11 = 1;
                }
                if (m11 != 0) {
                    this.f7294q = mVar.c(this.f7280c, this.f7279b);
                    if (m11 >= 1) {
                        int i13 = i11 / 16;
                        float[] fArr = this.f7278a;
                        if (fArr == null || fArr.length != i13 * 2) {
                            this.f7278a = new float[i13 * 2];
                            this.f7281d = new Path();
                        }
                        int i14 = this.f7297t;
                        canvas.translate(i14, i14);
                        this.f7282e.setColor(1996488704);
                        this.f7286i.setColor(1996488704);
                        this.f7283f.setColor(1996488704);
                        this.f7284g.setColor(1996488704);
                        mVar.d(this.f7278a, i13);
                        b(canvas, m11, this.f7294q, mVar);
                        this.f7282e.setColor(-21965);
                        this.f7283f.setColor(-2067046);
                        this.f7286i.setColor(-2067046);
                        this.f7284g.setColor(-13391360);
                        int i15 = this.f7297t;
                        canvas.translate(-i15, -i15);
                        b(canvas, m11, this.f7294q, mVar);
                        if (m11 == 5) {
                            j(canvas, mVar);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void b(Canvas canvas, int i11, int i12, m mVar) {
            if (i11 == 4) {
                d(canvas);
            }
            if (i11 == 2) {
                g(canvas);
            }
            if (i11 == 3) {
                e(canvas);
            }
            c(canvas);
            k(canvas, i11, i12, mVar);
        }

        void l(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.f7295r);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d {

        /* renamed from: a, reason: collision with root package name */
        androidx.constraintlayout.core.widgets.d f7299a = new androidx.constraintlayout.core.widgets.d();

        /* renamed from: b, reason: collision with root package name */
        androidx.constraintlayout.core.widgets.d f7300b = new androidx.constraintlayout.core.widgets.d();

        /* renamed from: c, reason: collision with root package name */
        androidx.constraintlayout.widget.b f7301c = null;

        /* renamed from: d, reason: collision with root package name */
        androidx.constraintlayout.widget.b f7302d = null;

        /* renamed from: e, reason: collision with root package name */
        int f7303e;

        /* renamed from: f, reason: collision with root package name */
        int f7304f;

        d() {
        }

        private void b(int i11, int i12) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            MotionLayout motionLayout = MotionLayout.this;
            if (motionLayout.f7231f == motionLayout.getStartState()) {
                MotionLayout motionLayout2 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar = this.f7300b;
                androidx.constraintlayout.widget.b bVar = this.f7302d;
                motionLayout2.resolveSystem(dVar, optimizationLevel, (bVar == null || bVar.f7834d == 0) ? i11 : i12, (bVar == null || bVar.f7834d == 0) ? i12 : i11);
                androidx.constraintlayout.widget.b bVar2 = this.f7301c;
                if (bVar2 != null) {
                    MotionLayout motionLayout3 = MotionLayout.this;
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f7299a;
                    int i13 = bVar2.f7834d;
                    int i14 = i13 == 0 ? i11 : i12;
                    if (i13 == 0) {
                        i11 = i12;
                    }
                    motionLayout3.resolveSystem(dVar2, optimizationLevel, i14, i11);
                    return;
                }
                return;
            }
            androidx.constraintlayout.widget.b bVar3 = this.f7301c;
            if (bVar3 != null) {
                MotionLayout motionLayout4 = MotionLayout.this;
                androidx.constraintlayout.core.widgets.d dVar3 = this.f7299a;
                int i15 = bVar3.f7834d;
                motionLayout4.resolveSystem(dVar3, optimizationLevel, i15 == 0 ? i11 : i12, i15 == 0 ? i12 : i11);
            }
            MotionLayout motionLayout5 = MotionLayout.this;
            androidx.constraintlayout.core.widgets.d dVar4 = this.f7300b;
            androidx.constraintlayout.widget.b bVar4 = this.f7302d;
            int i16 = (bVar4 == null || bVar4.f7834d == 0) ? i11 : i12;
            if (bVar4 == null || bVar4.f7834d == 0) {
                i11 = i12;
            }
            motionLayout5.resolveSystem(dVar4, optimizationLevel, i16, i11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void j(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.widget.b bVar) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.a aVar = new Constraints.a(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, dVar);
            sparseArray.put(MotionLayout.this.getId(), dVar);
            if (bVar != null && bVar.f7834d != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.f7300b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator it = dVar.v1().iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                constraintWidget.D0(true);
                sparseArray.put(((View) constraintWidget.u()).getId(), constraintWidget);
            }
            Iterator it2 = dVar.v1().iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) it2.next();
                View view = (View) constraintWidget2.u();
                bVar.l(view.getId(), aVar);
                constraintWidget2.o1(bVar.G(view.getId()));
                constraintWidget2.P0(bVar.B(view.getId()));
                if (view instanceof ConstraintHelper) {
                    bVar.j((ConstraintHelper) view, constraintWidget2, aVar, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                aVar.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, constraintWidget2, aVar, sparseArray);
                if (bVar.F(view.getId()) == 1) {
                    constraintWidget2.n1(view.getVisibility());
                } else {
                    constraintWidget2.n1(bVar.E(view.getId()));
                }
            }
            Iterator it3 = dVar.v1().iterator();
            while (it3.hasNext()) {
                ConstraintWidget constraintWidget3 = (ConstraintWidget) it3.next();
                if (constraintWidget3 instanceof androidx.constraintlayout.core.widgets.i) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) constraintWidget3.u();
                    t0.a aVar2 = (t0.a) constraintWidget3;
                    constraintHelper.updatePreLayout(dVar, aVar2, sparseArray);
                    ((androidx.constraintlayout.core.widgets.i) aVar2).y1();
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x00e8  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x013c A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void a() {
            /*
                Method dump skipped, instructions count: 359
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.d.a():void");
        }

        void c(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.core.widgets.d dVar2) {
            ArrayList v12 = dVar.v1();
            HashMap hashMap = new HashMap();
            hashMap.put(dVar, dVar2);
            dVar2.v1().clear();
            dVar2.n(dVar, hashMap);
            Iterator it = v12.iterator();
            while (it.hasNext()) {
                ConstraintWidget constraintWidget = (ConstraintWidget) it.next();
                ConstraintWidget aVar = constraintWidget instanceof androidx.constraintlayout.core.widgets.a ? new androidx.constraintlayout.core.widgets.a() : constraintWidget instanceof androidx.constraintlayout.core.widgets.f ? new androidx.constraintlayout.core.widgets.f() : constraintWidget instanceof androidx.constraintlayout.core.widgets.e ? new androidx.constraintlayout.core.widgets.e() : constraintWidget instanceof androidx.constraintlayout.core.widgets.h ? new androidx.constraintlayout.core.widgets.h() : constraintWidget instanceof t0.a ? new t0.b() : new ConstraintWidget();
                dVar2.a(aVar);
                hashMap.put(constraintWidget, aVar);
            }
            Iterator it2 = v12.iterator();
            while (it2.hasNext()) {
                ConstraintWidget constraintWidget2 = (ConstraintWidget) it2.next();
                ((ConstraintWidget) hashMap.get(constraintWidget2)).n(constraintWidget2, hashMap);
            }
        }

        ConstraintWidget d(androidx.constraintlayout.core.widgets.d dVar, View view) {
            if (dVar.u() == view) {
                return dVar;
            }
            ArrayList v12 = dVar.v1();
            int size = v12.size();
            for (int i11 = 0; i11 < size; i11++) {
                ConstraintWidget constraintWidget = (ConstraintWidget) v12.get(i11);
                if (constraintWidget.u() == view) {
                    return constraintWidget;
                }
            }
            return null;
        }

        void e(androidx.constraintlayout.core.widgets.d dVar, androidx.constraintlayout.widget.b bVar, androidx.constraintlayout.widget.b bVar2) {
            this.f7301c = bVar;
            this.f7302d = bVar2;
            this.f7299a = new androidx.constraintlayout.core.widgets.d();
            this.f7300b = new androidx.constraintlayout.core.widgets.d();
            this.f7299a.a2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.N1());
            this.f7300b.a2(((ConstraintLayout) MotionLayout.this).mLayoutWidget.N1());
            this.f7299a.y1();
            this.f7300b.y1();
            c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f7299a);
            c(((ConstraintLayout) MotionLayout.this).mLayoutWidget, this.f7300b);
            if (MotionLayout.this.f7249o > 0.5d) {
                if (bVar != null) {
                    j(this.f7299a, bVar);
                }
                j(this.f7300b, bVar2);
            } else {
                j(this.f7300b, bVar2);
                if (bVar != null) {
                    j(this.f7299a, bVar);
                }
            }
            this.f7299a.d2(MotionLayout.this.isRtl());
            this.f7299a.f2();
            this.f7300b.d2(MotionLayout.this.isRtl());
            this.f7300b.f2();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    androidx.constraintlayout.core.widgets.d dVar2 = this.f7299a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar2.T0(dimensionBehaviour);
                    this.f7300b.T0(dimensionBehaviour);
                }
                if (layoutParams.height == -2) {
                    androidx.constraintlayout.core.widgets.d dVar3 = this.f7299a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                    dVar3.k1(dimensionBehaviour2);
                    this.f7300b.k1(dimensionBehaviour2);
                }
            }
        }

        public boolean f(int i11, int i12) {
            return (i11 == this.f7303e && i12 == this.f7304f) ? false : true;
        }

        public void g(int i11, int i12) {
            int mode = View.MeasureSpec.getMode(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            MotionLayout motionLayout = MotionLayout.this;
            motionLayout.f7234g0 = mode;
            motionLayout.f7236h0 = mode2;
            motionLayout.getOptimizationLevel();
            b(i11, i12);
            if (!(MotionLayout.this.getParent() instanceof MotionLayout) || mode != 1073741824 || mode2 != 1073741824) {
                b(i11, i12);
                MotionLayout.this.f7226c0 = this.f7299a.Y();
                MotionLayout.this.f7228d0 = this.f7299a.z();
                MotionLayout.this.f7230e0 = this.f7300b.Y();
                MotionLayout.this.f7232f0 = this.f7300b.z();
                MotionLayout motionLayout2 = MotionLayout.this;
                motionLayout2.f7224b0 = (motionLayout2.f7226c0 == motionLayout2.f7230e0 && motionLayout2.f7228d0 == motionLayout2.f7232f0) ? false : true;
            }
            MotionLayout motionLayout3 = MotionLayout.this;
            int i13 = motionLayout3.f7226c0;
            int i14 = motionLayout3.f7228d0;
            int i15 = motionLayout3.f7234g0;
            if (i15 == Integer.MIN_VALUE || i15 == 0) {
                i13 = (int) (i13 + (motionLayout3.f7238i0 * (motionLayout3.f7230e0 - i13)));
            }
            int i16 = i13;
            int i17 = motionLayout3.f7236h0;
            if (i17 == Integer.MIN_VALUE || i17 == 0) {
                i14 = (int) (i14 + (motionLayout3.f7238i0 * (motionLayout3.f7232f0 - i14)));
            }
            MotionLayout.this.resolveMeasuredDimension(i11, i12, i16, i14, this.f7299a.V1() || this.f7300b.V1(), this.f7299a.T1() || this.f7300b.T1());
        }

        public void h() {
            g(MotionLayout.this.f7235h, MotionLayout.this.f7237i);
            MotionLayout.this.X();
        }

        public void i(int i11, int i12) {
            this.f7303e = i11;
            this.f7304f = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public interface e {
        void a(MotionEvent motionEvent);

        float b();

        float c();

        void d(int i11);

        void recycle();
    }

    /* loaded from: classes.dex */
    private static class f implements e {

        /* renamed from: b, reason: collision with root package name */
        private static f f7306b = new f();

        /* renamed from: a, reason: collision with root package name */
        VelocityTracker f7307a;

        private f() {
        }

        public static f e() {
            f7306b.f7307a = VelocityTracker.obtain();
            return f7306b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public void a(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f7307a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public float b() {
            VelocityTracker velocityTracker = this.f7307a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public float c() {
            VelocityTracker velocityTracker = this.f7307a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public void d(int i11) {
            VelocityTracker velocityTracker = this.f7307a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i11);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.e
        public void recycle() {
            VelocityTracker velocityTracker = this.f7307a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f7307a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class g {

        /* renamed from: a, reason: collision with root package name */
        float f7308a = Float.NaN;

        /* renamed from: b, reason: collision with root package name */
        float f7309b = Float.NaN;

        /* renamed from: c, reason: collision with root package name */
        int f7310c = -1;

        /* renamed from: d, reason: collision with root package name */
        int f7311d = -1;

        /* renamed from: e, reason: collision with root package name */
        final String f7312e = "motion.progress";

        /* renamed from: f, reason: collision with root package name */
        final String f7313f = "motion.velocity";

        /* renamed from: g, reason: collision with root package name */
        final String f7314g = "motion.StartState";

        /* renamed from: h, reason: collision with root package name */
        final String f7315h = "motion.EndState";

        g() {
        }

        void a() {
            int i11 = this.f7310c;
            if (i11 != -1 || this.f7311d != -1) {
                if (i11 == -1) {
                    MotionLayout.this.transitionToState(this.f7311d);
                } else {
                    int i12 = this.f7311d;
                    if (i12 == -1) {
                        MotionLayout.this.setState(i11, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i11, i12);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.f7309b)) {
                if (Float.isNaN(this.f7308a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f7308a);
            } else {
                MotionLayout.this.setProgress(this.f7308a, this.f7309b);
                this.f7308a = Float.NaN;
                this.f7309b = Float.NaN;
                this.f7310c = -1;
                this.f7311d = -1;
            }
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f7308a);
            bundle.putFloat("motion.velocity", this.f7309b);
            bundle.putInt("motion.StartState", this.f7310c);
            bundle.putInt("motion.EndState", this.f7311d);
            return bundle;
        }

        public void c() {
            this.f7311d = MotionLayout.this.f7233g;
            this.f7310c = MotionLayout.this.f7229e;
            this.f7309b = MotionLayout.this.getVelocity();
            this.f7308a = MotionLayout.this.getProgress();
        }

        public void d(int i11) {
            this.f7311d = i11;
        }

        public void e(float f11) {
            this.f7308a = f11;
        }

        public void f(int i11) {
            this.f7310c = i11;
        }

        public void g(Bundle bundle) {
            this.f7308a = bundle.getFloat("motion.progress");
            this.f7309b = bundle.getFloat("motion.velocity");
            this.f7310c = bundle.getInt("motion.StartState");
            this.f7311d = bundle.getInt("motion.EndState");
        }

        public void h(float f11) {
            this.f7309b = f11;
        }
    }

    /* loaded from: classes.dex */
    public interface h {
        void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11);

        void onTransitionCompleted(MotionLayout motionLayout, int i11);

        void onTransitionStarted(MotionLayout motionLayout, int i11, int i12);

        void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z10, float f11);
    }

    public MotionLayout(@NonNull Context context) {
        super(context);
        this.f7225c = null;
        this.f7227d = 0.0f;
        this.f7229e = -1;
        this.f7231f = -1;
        this.f7233g = -1;
        this.f7235h = 0;
        this.f7237i = 0;
        this.f7239j = true;
        this.f7241k = new HashMap();
        this.f7243l = 0L;
        this.f7245m = 1.0f;
        this.f7247n = 0.0f;
        this.f7249o = 0.0f;
        this.f7253q = 0.0f;
        this.f7257s = false;
        this.f7259t = false;
        this.f7267x = 0;
        this.f7271z = false;
        this.A = new v0.b();
        this.B = new b();
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1L;
        this.U = 0.0f;
        this.V = 0;
        this.W = 0.0f;
        this.f7222a0 = false;
        this.f7224b0 = false;
        this.f7240j0 = new androidx.constraintlayout.core.motion.utils.d();
        this.f7242k0 = false;
        this.f7246m0 = null;
        this.f7248n0 = null;
        this.f7250o0 = 0;
        this.f7252p0 = false;
        this.f7254q0 = 0;
        this.f7256r0 = new HashMap();
        this.f7264v0 = new Rect();
        this.f7266w0 = false;
        this.f7268x0 = TransitionState.UNDEFINED;
        this.f7270y0 = new d();
        this.f7272z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        T(null);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7225c = null;
        this.f7227d = 0.0f;
        this.f7229e = -1;
        this.f7231f = -1;
        this.f7233g = -1;
        this.f7235h = 0;
        this.f7237i = 0;
        this.f7239j = true;
        this.f7241k = new HashMap();
        this.f7243l = 0L;
        this.f7245m = 1.0f;
        this.f7247n = 0.0f;
        this.f7249o = 0.0f;
        this.f7253q = 0.0f;
        this.f7257s = false;
        this.f7259t = false;
        this.f7267x = 0;
        this.f7271z = false;
        this.A = new v0.b();
        this.B = new b();
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1L;
        this.U = 0.0f;
        this.V = 0;
        this.W = 0.0f;
        this.f7222a0 = false;
        this.f7224b0 = false;
        this.f7240j0 = new androidx.constraintlayout.core.motion.utils.d();
        this.f7242k0 = false;
        this.f7246m0 = null;
        this.f7248n0 = null;
        this.f7250o0 = 0;
        this.f7252p0 = false;
        this.f7254q0 = 0;
        this.f7256r0 = new HashMap();
        this.f7264v0 = new Rect();
        this.f7266w0 = false;
        this.f7268x0 = TransitionState.UNDEFINED;
        this.f7270y0 = new d();
        this.f7272z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        T(attributeSet);
    }

    public MotionLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f7225c = null;
        this.f7227d = 0.0f;
        this.f7229e = -1;
        this.f7231f = -1;
        this.f7233g = -1;
        this.f7235h = 0;
        this.f7237i = 0;
        this.f7239j = true;
        this.f7241k = new HashMap();
        this.f7243l = 0L;
        this.f7245m = 1.0f;
        this.f7247n = 0.0f;
        this.f7249o = 0.0f;
        this.f7253q = 0.0f;
        this.f7257s = false;
        this.f7259t = false;
        this.f7267x = 0;
        this.f7271z = false;
        this.A = new v0.b();
        this.B = new b();
        this.D = true;
        this.I = false;
        this.N = false;
        this.O = null;
        this.P = null;
        this.Q = null;
        this.R = null;
        this.S = 0;
        this.T = -1L;
        this.U = 0.0f;
        this.V = 0;
        this.W = 0.0f;
        this.f7222a0 = false;
        this.f7224b0 = false;
        this.f7240j0 = new androidx.constraintlayout.core.motion.utils.d();
        this.f7242k0 = false;
        this.f7246m0 = null;
        this.f7248n0 = null;
        this.f7250o0 = 0;
        this.f7252p0 = false;
        this.f7254q0 = 0;
        this.f7256r0 = new HashMap();
        this.f7264v0 = new Rect();
        this.f7266w0 = false;
        this.f7268x0 = TransitionState.UNDEFINED;
        this.f7270y0 = new d();
        this.f7272z0 = false;
        this.A0 = new RectF();
        this.B0 = null;
        this.C0 = null;
        this.D0 = new ArrayList();
        T(attributeSet);
    }

    private boolean G(View view, MotionEvent motionEvent, float f11, float f12) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f11, f12);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f11, -f12);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f11, f12);
        if (this.C0 == null) {
            this.C0 = new Matrix();
        }
        matrix.invert(this.C0);
        obtain.transform(this.C0);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    private void H() {
        p pVar = this.f7221a;
        if (pVar == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int G = pVar.G();
        p pVar2 = this.f7221a;
        I(G, pVar2.m(pVar2.G()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator it = this.f7221a.p().iterator();
        while (it.hasNext()) {
            p.b bVar = (p.b) it.next();
            if (bVar == this.f7221a.f7500c) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            J(bVar);
            int A = bVar.A();
            int y10 = bVar.y();
            String c11 = androidx.constraintlayout.motion.widget.a.c(getContext(), A);
            String c12 = androidx.constraintlayout.motion.widget.a.c(getContext(), y10);
            if (sparseIntArray.get(A) == y10) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + c11 + "->" + c12);
            }
            if (sparseIntArray2.get(y10) == A) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + c11 + "->" + c12);
            }
            sparseIntArray.put(A, y10);
            sparseIntArray2.put(y10, A);
            if (this.f7221a.m(A) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + c11);
            }
            if (this.f7221a.m(y10) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + c11);
            }
        }
    }

    private void I(int i11, androidx.constraintlayout.widget.b bVar) {
        String c11 = androidx.constraintlayout.motion.widget.a.c(getContext(), i11);
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            int id2 = childAt.getId();
            if (id2 == -1) {
                Log.w("MotionLayout", "CHECK: " + c11 + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (bVar.A(id2) == null) {
                Log.w("MotionLayout", "CHECK: " + c11 + " NO CONSTRAINTS for " + androidx.constraintlayout.motion.widget.a.d(childAt));
            }
        }
        int[] C = bVar.C();
        for (int i13 = 0; i13 < C.length; i13++) {
            int i14 = C[i13];
            String c12 = androidx.constraintlayout.motion.widget.a.c(getContext(), i14);
            if (findViewById(C[i13]) == null) {
                Log.w("MotionLayout", "CHECK: " + c11 + " NO View matches id " + c12);
            }
            if (bVar.B(i14) == -1) {
                Log.w("MotionLayout", "CHECK: " + c11 + "(" + c12 + ") no LAYOUT_HEIGHT");
            }
            if (bVar.G(i14) == -1) {
                Log.w("MotionLayout", "CHECK: " + c11 + "(" + c12 + ") no LAYOUT_HEIGHT");
            }
        }
    }

    private void J(p.b bVar) {
        if (bVar.A() == bVar.y()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    private void K() {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            m mVar = (m) this.f7241k.get(childAt);
            if (mVar != null) {
                mVar.E(childAt);
            }
        }
    }

    private void N() {
        boolean z10;
        float signum = Math.signum(this.f7253q - this.f7249o);
        long nanoTime = getNanoTime();
        Interpolator interpolator = this.f7223b;
        float f11 = this.f7249o + (!(interpolator instanceof v0.b) ? ((((float) (nanoTime - this.f7251p)) * signum) * 1.0E-9f) / this.f7245m : 0.0f);
        if (this.f7255r) {
            f11 = this.f7253q;
        }
        if ((signum <= 0.0f || f11 < this.f7253q) && (signum > 0.0f || f11 > this.f7253q)) {
            z10 = false;
        } else {
            f11 = this.f7253q;
            z10 = true;
        }
        if (interpolator != null && !z10) {
            f11 = this.f7271z ? interpolator.getInterpolation(((float) (nanoTime - this.f7243l)) * 1.0E-9f) : interpolator.getInterpolation(f11);
        }
        if ((signum > 0.0f && f11 >= this.f7253q) || (signum <= 0.0f && f11 <= this.f7253q)) {
            f11 = this.f7253q;
        }
        this.f7238i0 = f11;
        int childCount = getChildCount();
        long nanoTime2 = getNanoTime();
        Interpolator interpolator2 = this.f7225c;
        if (interpolator2 != null) {
            f11 = interpolator2.getInterpolation(f11);
        }
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            m mVar = (m) this.f7241k.get(childAt);
            if (mVar != null) {
                mVar.x(childAt, f11, nanoTime2, this.f7240j0);
            }
        }
        if (this.f7224b0) {
            requestLayout();
        }
    }

    private void O() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.f7261u == null && ((copyOnWriteArrayList = this.R) == null || copyOnWriteArrayList.isEmpty())) || this.W == this.f7247n) {
            return;
        }
        if (this.V != -1) {
            h hVar = this.f7261u;
            if (hVar != null) {
                hVar.onTransitionStarted(this, this.f7229e, this.f7233g);
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.R;
            if (copyOnWriteArrayList2 != null) {
                Iterator it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    ((h) it.next()).onTransitionStarted(this, this.f7229e, this.f7233g);
                }
            }
            this.f7222a0 = true;
        }
        this.V = -1;
        float f11 = this.f7247n;
        this.W = f11;
        h hVar2 = this.f7261u;
        if (hVar2 != null) {
            hVar2.onTransitionChange(this, this.f7229e, this.f7233g, f11);
        }
        CopyOnWriteArrayList copyOnWriteArrayList3 = this.R;
        if (copyOnWriteArrayList3 != null) {
            Iterator it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                ((h) it2.next()).onTransitionChange(this, this.f7229e, this.f7233g, this.f7247n);
            }
        }
        this.f7222a0 = true;
    }

    private boolean S(float f11, float f12, View view, MotionEvent motionEvent) {
        boolean z10;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                if (S((r3.getLeft() + f11) - view.getScrollX(), (r3.getTop() + f12) - view.getScrollY(), viewGroup.getChildAt(childCount), motionEvent)) {
                    z10 = true;
                    break;
                }
            }
        }
        z10 = false;
        if (!z10) {
            this.A0.set(f11, f12, (view.getRight() + f11) - view.getLeft(), (view.getBottom() + f12) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.A0.contains(motionEvent.getX(), motionEvent.getY())) && G(view, motionEvent, -f11, -f12)) {
                return true;
            }
        }
        return z10;
    }

    private void T(AttributeSet attributeSet) {
        p pVar;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            boolean z10 = true;
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R$styleable.MotionLayout_layoutDescription) {
                    this.f7221a = new p(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                } else if (index == R$styleable.MotionLayout_currentState) {
                    this.f7231f = obtainStyledAttributes.getResourceId(index, -1);
                } else if (index == R$styleable.MotionLayout_motionProgress) {
                    this.f7253q = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.f7257s = true;
                } else if (index == R$styleable.MotionLayout_applyMotionScene) {
                    z10 = obtainStyledAttributes.getBoolean(index, z10);
                } else if (index == R$styleable.MotionLayout_showPaths) {
                    if (this.f7267x == 0) {
                        this.f7267x = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                    }
                } else if (index == R$styleable.MotionLayout_motionDebug) {
                    this.f7267x = obtainStyledAttributes.getInt(index, 0);
                }
            }
            obtainStyledAttributes.recycle();
            if (this.f7221a == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z10) {
                this.f7221a = null;
            }
        }
        if (this.f7267x != 0) {
            H();
        }
        if (this.f7231f != -1 || (pVar = this.f7221a) == null) {
            return;
        }
        this.f7231f = pVar.G();
        this.f7229e = this.f7221a.G();
        this.f7233g = this.f7221a.r();
    }

    private void W() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (this.f7261u == null && ((copyOnWriteArrayList = this.R) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.f7222a0 = false;
        Iterator it = this.D0.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            h hVar = this.f7261u;
            if (hVar != null) {
                hVar.onTransitionCompleted(this, num.intValue());
            }
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.R;
            if (copyOnWriteArrayList2 != null) {
                Iterator it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    ((h) it2.next()).onTransitionCompleted(this, num.intValue());
                }
            }
        }
        this.D0.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        int childCount = getChildCount();
        this.f7270y0.a();
        this.f7257s = true;
        SparseArray sparseArray = new SparseArray();
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            sparseArray.put(childAt.getId(), (m) this.f7241k.get(childAt));
        }
        int width = getWidth();
        int height = getHeight();
        int k11 = this.f7221a.k();
        if (k11 != -1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                m mVar = (m) this.f7241k.get(getChildAt(i13));
                if (mVar != null) {
                    mVar.D(k11);
                }
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.f7241k.size()];
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            m mVar2 = (m) this.f7241k.get(getChildAt(i15));
            if (mVar2.h() != -1) {
                sparseBooleanArray.put(mVar2.h(), true);
                iArr[i14] = mVar2.h();
                i14++;
            }
        }
        if (this.Q != null) {
            for (int i16 = 0; i16 < i14; i16++) {
                m mVar3 = (m) this.f7241k.get(findViewById(iArr[i16]));
                if (mVar3 != null) {
                    this.f7221a.u(mVar3);
                }
            }
            Iterator it = this.Q.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).onPreSetup(this, this.f7241k);
            }
            for (int i17 = 0; i17 < i14; i17++) {
                m mVar4 = (m) this.f7241k.get(findViewById(iArr[i17]));
                if (mVar4 != null) {
                    mVar4.I(width, height, this.f7245m, getNanoTime());
                }
            }
        } else {
            for (int i18 = 0; i18 < i14; i18++) {
                m mVar5 = (m) this.f7241k.get(findViewById(iArr[i18]));
                if (mVar5 != null) {
                    this.f7221a.u(mVar5);
                    mVar5.I(width, height, this.f7245m, getNanoTime());
                }
            }
        }
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt2 = getChildAt(i19);
            m mVar6 = (m) this.f7241k.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && mVar6 != null) {
                this.f7221a.u(mVar6);
                mVar6.I(width, height, this.f7245m, getNanoTime());
            }
        }
        float F = this.f7221a.F();
        if (F != 0.0f) {
            boolean z10 = ((double) F) < 0.0d;
            float abs = Math.abs(F);
            float f11 = -3.4028235E38f;
            float f12 = Float.MAX_VALUE;
            float f13 = -3.4028235E38f;
            float f14 = Float.MAX_VALUE;
            for (int i20 = 0; i20 < childCount; i20++) {
                m mVar7 = (m) this.f7241k.get(getChildAt(i20));
                if (!Float.isNaN(mVar7.f7463m)) {
                    for (int i21 = 0; i21 < childCount; i21++) {
                        m mVar8 = (m) this.f7241k.get(getChildAt(i21));
                        if (!Float.isNaN(mVar8.f7463m)) {
                            f12 = Math.min(f12, mVar8.f7463m);
                            f11 = Math.max(f11, mVar8.f7463m);
                        }
                    }
                    while (i11 < childCount) {
                        m mVar9 = (m) this.f7241k.get(getChildAt(i11));
                        if (!Float.isNaN(mVar9.f7463m)) {
                            mVar9.f7465o = 1.0f / (1.0f - abs);
                            if (z10) {
                                mVar9.f7464n = abs - (((f11 - mVar9.f7463m) / (f11 - f12)) * abs);
                            } else {
                                mVar9.f7464n = abs - (((mVar9.f7463m - f12) * abs) / (f11 - f12));
                            }
                        }
                        i11++;
                    }
                    return;
                }
                float n11 = mVar7.n();
                float o11 = mVar7.o();
                float f15 = z10 ? o11 - n11 : o11 + n11;
                f14 = Math.min(f14, f15);
                f13 = Math.max(f13, f15);
            }
            while (i11 < childCount) {
                m mVar10 = (m) this.f7241k.get(getChildAt(i11));
                float n12 = mVar10.n();
                float o12 = mVar10.o();
                float f16 = z10 ? o12 - n12 : o12 + n12;
                mVar10.f7465o = 1.0f / (1.0f - abs);
                mVar10.f7464n = abs - (((f16 - f14) * abs) / (f13 - f14));
                i11++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect Y(ConstraintWidget constraintWidget) {
        this.f7264v0.top = constraintWidget.a0();
        this.f7264v0.left = constraintWidget.Z();
        Rect rect = this.f7264v0;
        int Y = constraintWidget.Y();
        Rect rect2 = this.f7264v0;
        rect.right = Y + rect2.left;
        int z10 = constraintWidget.z();
        Rect rect3 = this.f7264v0;
        rect2.bottom = z10 + rect3.top;
        return rect3;
    }

    private static boolean Z(float f11, float f12, float f13) {
        if (f11 > 0.0f) {
            float f14 = f11 / f13;
            return f12 + ((f11 * f14) - (((f13 * f14) * f14) / 2.0f)) > 1.0f;
        }
        float f15 = (-f11) / f13;
        return f12 + ((f11 * f15) + (((f13 * f15) * f15) / 2.0f)) < 0.0f;
    }

    void F(float f11) {
        if (this.f7221a == null) {
            return;
        }
        float f12 = this.f7249o;
        float f13 = this.f7247n;
        if (f12 != f13 && this.f7255r) {
            this.f7249o = f13;
        }
        float f14 = this.f7249o;
        if (f14 == f11) {
            return;
        }
        this.f7271z = false;
        this.f7253q = f11;
        this.f7245m = r0.q() / 1000.0f;
        setProgress(this.f7253q);
        this.f7223b = null;
        this.f7225c = this.f7221a.t();
        this.f7255r = false;
        this.f7243l = getNanoTime();
        this.f7257s = true;
        this.f7247n = f14;
        this.f7249o = f14;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(boolean z10) {
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            m mVar = (m) this.f7241k.get(getChildAt(i11));
            if (mVar != null) {
                mVar.f(z10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0170  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M(boolean r23) {
        /*
            Method dump skipped, instructions count: 630
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.M(boolean):void");
    }

    protected void P() {
        int i11;
        CopyOnWriteArrayList copyOnWriteArrayList;
        if ((this.f7261u != null || ((copyOnWriteArrayList = this.R) != null && !copyOnWriteArrayList.isEmpty())) && this.V == -1) {
            this.V = this.f7231f;
            if (this.D0.isEmpty()) {
                i11 = -1;
            } else {
                ArrayList arrayList = this.D0;
                i11 = ((Integer) arrayList.get(arrayList.size() - 1)).intValue();
            }
            int i12 = this.f7231f;
            if (i11 != i12 && i12 != -1) {
                this.D0.add(Integer.valueOf(i12));
            }
        }
        W();
        Runnable runnable = this.f7246m0;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.f7248n0;
        if (iArr == null || this.f7250o0 <= 0) {
            return;
        }
        transitionToState(iArr[0]);
        int[] iArr2 = this.f7248n0;
        System.arraycopy(iArr2, 1, iArr2, 0, iArr2.length - 1);
        this.f7250o0--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q(int i11, float f11, float f12, float f13, float[] fArr) {
        String resourceName;
        HashMap hashMap = this.f7241k;
        View viewById = getViewById(i11);
        m mVar = (m) hashMap.get(viewById);
        if (mVar != null) {
            mVar.l(f11, f12, f13, fArr);
            float y10 = viewById.getY();
            this.f7263v = f11;
            this.f7265w = y10;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i11;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i11);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m R(int i11) {
        return (m) this.f7241k.get(findViewById(i11));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e U() {
        return f.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V() {
        p pVar = this.f7221a;
        if (pVar == null) {
            return;
        }
        if (pVar.h(this, this.f7231f)) {
            requestLayout();
            return;
        }
        int i11 = this.f7231f;
        if (i11 != -1) {
            this.f7221a.f(this, i11);
        }
        if (this.f7221a.d0()) {
            this.f7221a.b0();
        }
    }

    public void addTransitionListener(h hVar) {
        if (this.R == null) {
            this.R = new CopyOnWriteArrayList();
        }
        this.R.add(hVar);
    }

    public boolean applyViewTransition(int i11, m mVar) {
        p pVar = this.f7221a;
        if (pVar != null) {
            return pVar.g(i11, mVar);
        }
        return false;
    }

    public androidx.constraintlayout.widget.b cloneConstraintSet(int i11) {
        p pVar = this.f7221a;
        if (pVar == null) {
            return null;
        }
        androidx.constraintlayout.widget.b m11 = pVar.m(i11);
        androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
        bVar.r(m11);
        return bVar;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        t tVar;
        ArrayList arrayList = this.Q;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).onPreDraw(canvas);
            }
        }
        M(false);
        p pVar = this.f7221a;
        if (pVar != null && (tVar = pVar.f7516s) != null) {
            tVar.c();
        }
        super.dispatchDraw(canvas);
        if (this.f7221a == null) {
            return;
        }
        if ((this.f7267x & 1) == 1 && !isInEditMode()) {
            this.S++;
            long nanoTime = getNanoTime();
            long j11 = this.T;
            if (j11 != -1) {
                if (nanoTime - j11 > 200000000) {
                    this.U = ((int) ((this.S / (((float) r5) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.S = 0;
                    this.T = nanoTime;
                }
            } else {
                this.T = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            String str = this.U + " fps " + androidx.constraintlayout.motion.widget.a.e(this, this.f7229e) + " -> ";
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append(androidx.constraintlayout.motion.widget.a.e(this, this.f7233g));
            sb2.append(" (progress: ");
            sb2.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb2.append(" ) state=");
            int i11 = this.f7231f;
            sb2.append(i11 == -1 ? "undefined" : androidx.constraintlayout.motion.widget.a.e(this, i11));
            String sb3 = sb2.toString();
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            canvas.drawText(sb3, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb3, 10.0f, getHeight() - 30, paint);
        }
        if (this.f7267x > 1) {
            if (this.f7269y == null) {
                this.f7269y = new c();
            }
            this.f7269y.a(canvas, this.f7241k, this.f7221a.q(), this.f7267x);
        }
        ArrayList arrayList2 = this.Q;
        if (arrayList2 != null) {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                ((MotionHelper) it2.next()).onPostDraw(canvas);
            }
        }
    }

    public void enableTransition(int i11, boolean z10) {
        p.b transition = getTransition(i11);
        if (z10) {
            transition.F(true);
            return;
        }
        p pVar = this.f7221a;
        if (transition == pVar.f7500c) {
            Iterator it = pVar.I(this.f7231f).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                p.b bVar = (p.b) it.next();
                if (bVar.C()) {
                    this.f7221a.f7500c = bVar;
                    break;
                }
            }
        }
        transition.F(false);
    }

    public void enableViewTransition(int i11, boolean z10) {
        p pVar = this.f7221a;
        if (pVar != null) {
            pVar.j(i11, z10);
        }
    }

    public void fireTrigger(int i11, boolean z10, float f11) {
        h hVar = this.f7261u;
        if (hVar != null) {
            hVar.onTransitionTrigger(this, i11, z10, f11);
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.R;
        if (copyOnWriteArrayList != null) {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ((h) it.next()).onTransitionTrigger(this, i11, z10, f11);
            }
        }
    }

    public androidx.constraintlayout.widget.b getConstraintSet(int i11) {
        p pVar = this.f7221a;
        if (pVar == null) {
            return null;
        }
        return pVar.m(i11);
    }

    public int[] getConstraintSetIds() {
        p pVar = this.f7221a;
        if (pVar == null) {
            return null;
        }
        return pVar.o();
    }

    public int getCurrentState() {
        return this.f7231f;
    }

    public void getDebugMode(boolean z10) {
        this.f7267x = z10 ? 2 : 1;
        invalidate();
    }

    public ArrayList<p.b> getDefinedTransitions() {
        p pVar = this.f7221a;
        if (pVar == null) {
            return null;
        }
        return pVar.p();
    }

    public androidx.constraintlayout.motion.widget.b getDesignTool() {
        if (this.C == null) {
            this.C = new androidx.constraintlayout.motion.widget.b(this);
        }
        return this.C;
    }

    public int getEndState() {
        return this.f7233g;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.f7249o;
    }

    public p getScene() {
        return this.f7221a;
    }

    public int getStartState() {
        return this.f7229e;
    }

    public float getTargetPosition() {
        return this.f7253q;
    }

    public p.b getTransition(int i11) {
        return this.f7221a.H(i11);
    }

    public Bundle getTransitionState() {
        if (this.f7244l0 == null) {
            this.f7244l0 = new g();
        }
        this.f7244l0.c();
        return this.f7244l0.b();
    }

    public long getTransitionTimeMs() {
        if (this.f7221a != null) {
            this.f7245m = r0.q() / 1000.0f;
        }
        return this.f7245m * 1000.0f;
    }

    public float getVelocity() {
        return this.f7227d;
    }

    public void getViewVelocity(View view, float f11, float f12, float[] fArr, int i11) {
        float f13;
        float f14 = this.f7227d;
        float f15 = this.f7249o;
        if (this.f7223b != null) {
            float signum = Math.signum(this.f7253q - f15);
            float interpolation = this.f7223b.getInterpolation(this.f7249o + 1.0E-5f);
            f13 = this.f7223b.getInterpolation(this.f7249o);
            f14 = (signum * ((interpolation - f13) / 1.0E-5f)) / this.f7245m;
        } else {
            f13 = f15;
        }
        Interpolator interpolator = this.f7223b;
        if (interpolator instanceof n) {
            f14 = ((n) interpolator).a();
        }
        m mVar = (m) this.f7241k.get(view);
        if ((i11 & 1) == 0) {
            mVar.r(f13, view.getWidth(), view.getHeight(), f11, f12, fArr);
        } else {
            mVar.l(f13, f11, f12, fArr);
        }
        if (i11 < 2) {
            fArr[0] = fArr[0] * f14;
            fArr[1] = fArr[1] * f14;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.f7266w0;
    }

    public boolean isInRotation() {
        return this.f7252p0;
    }

    public boolean isInteractionEnabled() {
        return this.f7239j;
    }

    public boolean isViewTransitionEnabled(int i11) {
        p pVar = this.f7221a;
        if (pVar != null) {
            return pVar.L(i11);
        }
        return false;
    }

    public void jumpToState(int i11) {
        if (!isAttachedToWindow()) {
            this.f7231f = i11;
        }
        if (this.f7229e == i11) {
            setProgress(0.0f);
        } else if (this.f7233g == i11) {
            setProgress(1.0f);
        } else {
            setTransition(i11, i11);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i11) {
        p.b bVar;
        if (i11 == 0) {
            this.f7221a = null;
            return;
        }
        try {
            p pVar = new p(getContext(), this, i11);
            this.f7221a = pVar;
            if (this.f7231f == -1) {
                this.f7231f = pVar.G();
                this.f7229e = this.f7221a.G();
                this.f7233g = this.f7221a.r();
            }
            if (!isAttachedToWindow()) {
                this.f7221a = null;
                return;
            }
            try {
                Display display = getDisplay();
                this.f7262u0 = display == null ? 0 : display.getRotation();
                p pVar2 = this.f7221a;
                if (pVar2 != null) {
                    androidx.constraintlayout.widget.b m11 = pVar2.m(this.f7231f);
                    this.f7221a.V(this);
                    ArrayList arrayList = this.Q;
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((MotionHelper) it.next()).onFinishedMotionScene(this);
                        }
                    }
                    if (m11 != null) {
                        m11.i(this);
                    }
                    this.f7229e = this.f7231f;
                }
                V();
                g gVar = this.f7244l0;
                if (gVar != null) {
                    if (this.f7266w0) {
                        post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MotionLayout.this.f7244l0.a();
                            }
                        });
                        return;
                    } else {
                        gVar.a();
                        return;
                    }
                }
                p pVar3 = this.f7221a;
                if (pVar3 == null || (bVar = pVar3.f7500c) == null || bVar.x() != 4) {
                    return;
                }
                transitionToEnd();
                setState(TransitionState.SETUP);
                setState(TransitionState.MOVING);
            } catch (Exception e11) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e11);
            }
        } catch (Exception e12) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e12);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        p.b bVar;
        int i11;
        super.onAttachedToWindow();
        Display display = getDisplay();
        if (display != null) {
            this.f7262u0 = display.getRotation();
        }
        p pVar = this.f7221a;
        if (pVar != null && (i11 = this.f7231f) != -1) {
            androidx.constraintlayout.widget.b m11 = pVar.m(i11);
            this.f7221a.V(this);
            ArrayList arrayList = this.Q;
            if (arrayList != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((MotionHelper) it.next()).onFinishedMotionScene(this);
                }
            }
            if (m11 != null) {
                m11.i(this);
            }
            this.f7229e = this.f7231f;
        }
        V();
        g gVar = this.f7244l0;
        if (gVar != null) {
            if (this.f7266w0) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionLayout.this.f7244l0.a();
                    }
                });
                return;
            } else {
                gVar.a();
                return;
            }
        }
        p pVar2 = this.f7221a;
        if (pVar2 == null || (bVar = pVar2.f7500c) == null || bVar.x() != 4) {
            return;
        }
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        q B;
        int q11;
        RectF p11;
        p pVar = this.f7221a;
        if (pVar != null && this.f7239j) {
            t tVar = pVar.f7516s;
            if (tVar != null) {
                tVar.j(motionEvent);
            }
            p.b bVar = this.f7221a.f7500c;
            if (bVar != null && bVar.C() && (B = bVar.B()) != null && ((motionEvent.getAction() != 0 || (p11 = B.p(this, new RectF())) == null || p11.contains(motionEvent.getX(), motionEvent.getY())) && (q11 = B.q()) != -1)) {
                View view = this.B0;
                if (view == null || view.getId() != q11) {
                    this.B0 = findViewById(q11);
                }
                if (this.B0 != null) {
                    this.A0.set(r0.getLeft(), this.B0.getTop(), this.B0.getRight(), this.B0.getBottom());
                    if (this.A0.contains(motionEvent.getX(), motionEvent.getY()) && !S(this.B0.getLeft(), this.B0.getTop(), this.B0, motionEvent)) {
                        return onTouchEvent(motionEvent);
                    }
                }
            }
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        this.f7242k0 = true;
        try {
            if (this.f7221a == null) {
                super.onLayout(z10, i11, i12, i13, i14);
                return;
            }
            int i15 = i13 - i11;
            int i16 = i14 - i12;
            if (this.G != i15 || this.H != i16) {
                rebuildScene();
                M(true);
            }
            this.G = i15;
            this.H = i16;
            this.E = i15;
            this.F = i16;
        } finally {
            this.f7242k0 = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i11, int i12) {
        if (this.f7221a == null) {
            super.onMeasure(i11, i12);
            return;
        }
        boolean z10 = false;
        boolean z11 = (this.f7235h == i11 && this.f7237i == i12) ? false : true;
        if (this.f7272z0) {
            this.f7272z0 = false;
            V();
            W();
            z11 = true;
        }
        if (this.mDirtyHierarchy) {
            z11 = true;
        }
        this.f7235h = i11;
        this.f7237i = i12;
        int G = this.f7221a.G();
        int r11 = this.f7221a.r();
        if ((z11 || this.f7270y0.f(G, r11)) && this.f7229e != -1) {
            super.onMeasure(i11, i12);
            this.f7270y0.e(this.mLayoutWidget, this.f7221a.m(G), this.f7221a.m(r11));
            this.f7270y0.h();
            this.f7270y0.i(G, r11);
        } else {
            if (z11) {
                super.onMeasure(i11, i12);
            }
            z10 = true;
        }
        if (this.f7224b0 || z10) {
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int Y = this.mLayoutWidget.Y() + getPaddingLeft() + getPaddingRight();
            int z12 = this.mLayoutWidget.z() + paddingTop;
            int i13 = this.f7234g0;
            if (i13 == Integer.MIN_VALUE || i13 == 0) {
                Y = (int) (this.f7226c0 + (this.f7238i0 * (this.f7230e0 - r8)));
                requestLayout();
            }
            int i14 = this.f7236h0;
            if (i14 == Integer.MIN_VALUE || i14 == 0) {
                z12 = (int) (this.f7228d0 + (this.f7238i0 * (this.f7232f0 - r8)));
                requestLayout();
            }
            setMeasuredDimension(Y, z12);
        }
        N();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f11, float f12, boolean z10) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f11, float f12) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NonNull final View view, int i11, int i12, @NonNull int[] iArr, int i13) {
        p.b bVar;
        q B;
        int q11;
        p pVar = this.f7221a;
        if (pVar == null || (bVar = pVar.f7500c) == null || !bVar.C()) {
            return;
        }
        int i14 = -1;
        if (!bVar.C() || (B = bVar.B()) == null || (q11 = B.q()) == -1 || view.getId() == q11) {
            if (pVar.x()) {
                q B2 = bVar.B();
                if (B2 != null && (B2.e() & 4) != 0) {
                    i14 = i12;
                }
                float f11 = this.f7247n;
                if ((f11 == 1.0f || f11 == 0.0f) && view.canScrollVertically(i14)) {
                    return;
                }
            }
            if (bVar.B() != null && (bVar.B().e() & 1) != 0) {
                float y10 = pVar.y(i11, i12);
                float f12 = this.f7249o;
                if ((f12 <= 0.0f && y10 < 0.0f) || (f12 >= 1.0f && y10 > 0.0f)) {
                    view.setNestedScrollingEnabled(false);
                    view.post(new Runnable(this) { // from class: androidx.constraintlayout.motion.widget.MotionLayout.3
                        @Override // java.lang.Runnable
                        public void run() {
                            view.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }
            }
            float f13 = this.f7247n;
            long nanoTime = getNanoTime();
            float f14 = i11;
            this.J = f14;
            float f15 = i12;
            this.K = f15;
            this.M = (float) ((nanoTime - this.L) * 1.0E-9d);
            this.L = nanoTime;
            pVar.R(f14, f15);
            if (f13 != this.f7247n) {
                iArr[0] = i11;
                iArr[1] = i12;
            }
            M(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.I = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NonNull View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        if (this.I || i11 != 0 || i12 != 0) {
            iArr[0] = iArr[0] + i13;
            iArr[1] = iArr[1] + i14;
        }
        this.I = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i11, int i12) {
        this.L = getNanoTime();
        this.M = 0.0f;
        this.J = 0.0f;
        this.K = 0.0f;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i11) {
        p pVar = this.f7221a;
        if (pVar != null) {
            pVar.Y(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i11, int i12) {
        p.b bVar;
        p pVar = this.f7221a;
        return (pVar == null || (bVar = pVar.f7500c) == null || bVar.B() == null || (this.f7221a.f7500c.B().e() & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NonNull View view, int i11) {
        p pVar = this.f7221a;
        if (pVar != null) {
            float f11 = this.M;
            if (f11 == 0.0f) {
                return;
            }
            pVar.S(this.J / f11, this.K / f11);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        p pVar = this.f7221a;
        if (pVar == null || !this.f7239j || !pVar.d0()) {
            return super.onTouchEvent(motionEvent);
        }
        p.b bVar = this.f7221a.f7500c;
        if (bVar != null && !bVar.C()) {
            return super.onTouchEvent(motionEvent);
        }
        this.f7221a.T(motionEvent, getCurrentState(), this);
        if (this.f7221a.f7500c.D(4)) {
            return this.f7221a.f7500c.B().r();
        }
        return true;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.R == null) {
                this.R = new CopyOnWriteArrayList();
            }
            this.R.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.O == null) {
                    this.O = new ArrayList();
                }
                this.O.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.P == null) {
                    this.P = new ArrayList();
                }
                this.P.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.Q == null) {
                    this.Q = new ArrayList();
                }
                this.Q.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList arrayList2 = this.P;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    protected void parseLayoutDescription(int i11) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e("MotionLayout", "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.f7270y0.h();
        invalidate();
    }

    public boolean removeTransitionListener(h hVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.R;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(hVar);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        p pVar;
        p.b bVar;
        if (!this.f7224b0 && this.f7231f == -1 && (pVar = this.f7221a) != null && (bVar = pVar.f7500c) != null) {
            int z10 = bVar.z();
            if (z10 == 0) {
                return;
            }
            if (z10 == 2) {
                int childCount = getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    ((m) this.f7241k.get(getChildAt(i11))).z();
                }
                return;
            }
        }
        super.requestLayout();
    }

    public void rotateTo(int i11, int i12) {
        this.f7252p0 = true;
        this.f7258s0 = getWidth();
        this.f7260t0 = getHeight();
        int rotation = getDisplay().getRotation();
        this.f7254q0 = (rotation + 1) % 4 <= (this.f7262u0 + 1) % 4 ? 2 : 1;
        this.f7262u0 = rotation;
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            v0.e eVar = (v0.e) this.f7256r0.get(childAt);
            if (eVar == null) {
                eVar = new v0.e();
                this.f7256r0.put(childAt, eVar);
            }
            eVar.a(childAt);
        }
        this.f7229e = -1;
        this.f7233g = i11;
        this.f7221a.Z(-1, i11);
        this.f7270y0.e(this.mLayoutWidget, null, this.f7221a.m(this.f7233g));
        this.f7247n = 0.0f;
        this.f7249o = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.2
            @Override // java.lang.Runnable
            public void run() {
                MotionLayout.this.f7252p0 = false;
            }
        });
        if (i12 > 0) {
            this.f7245m = i12 / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i11) {
        if (getCurrentState() == -1) {
            transitionToState(i11);
            return;
        }
        int[] iArr = this.f7248n0;
        if (iArr == null) {
            this.f7248n0 = new int[4];
        } else if (iArr.length <= this.f7250o0) {
            this.f7248n0 = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f7248n0;
        int i12 = this.f7250o0;
        this.f7250o0 = i12 + 1;
        iArr2[i12] = i11;
    }

    public void setDebugMode(int i11) {
        this.f7267x = i11;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z10) {
        this.f7266w0 = z10;
    }

    public void setInteractionEnabled(boolean z10) {
        this.f7239j = z10;
    }

    public void setInterpolatedProgress(float f11) {
        if (this.f7221a != null) {
            setState(TransitionState.MOVING);
            Interpolator t11 = this.f7221a.t();
            if (t11 != null) {
                setProgress(t11.getInterpolation(f11));
                return;
            }
        }
        setProgress(f11);
    }

    public void setOnHide(float f11) {
        ArrayList arrayList = this.P;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((MotionHelper) this.P.get(i11)).setProgress(f11);
            }
        }
    }

    public void setOnShow(float f11) {
        ArrayList arrayList = this.O;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                ((MotionHelper) this.O.get(i11)).setProgress(f11);
            }
        }
    }

    public void setProgress(float f11) {
        if (f11 < 0.0f || f11 > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.f7244l0 == null) {
                this.f7244l0 = new g();
            }
            this.f7244l0.e(f11);
            return;
        }
        if (f11 <= 0.0f) {
            if (this.f7249o == 1.0f && this.f7231f == this.f7233g) {
                setState(TransitionState.MOVING);
            }
            this.f7231f = this.f7229e;
            if (this.f7249o == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f11 >= 1.0f) {
            if (this.f7249o == 0.0f && this.f7231f == this.f7229e) {
                setState(TransitionState.MOVING);
            }
            this.f7231f = this.f7233g;
            if (this.f7249o == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.f7231f = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f7221a == null) {
            return;
        }
        this.f7255r = true;
        this.f7253q = f11;
        this.f7247n = f11;
        this.f7251p = -1L;
        this.f7243l = -1L;
        this.f7223b = null;
        this.f7257s = true;
        invalidate();
    }

    public void setProgress(float f11, float f12) {
        if (!isAttachedToWindow()) {
            if (this.f7244l0 == null) {
                this.f7244l0 = new g();
            }
            this.f7244l0.e(f11);
            this.f7244l0.h(f12);
            return;
        }
        setProgress(f11);
        setState(TransitionState.MOVING);
        this.f7227d = f12;
        if (f12 != 0.0f) {
            F(f12 > 0.0f ? 1.0f : 0.0f);
        } else {
            if (f11 == 0.0f || f11 == 1.0f) {
                return;
            }
            F(f11 > 0.5f ? 1.0f : 0.0f);
        }
    }

    public void setScene(p pVar) {
        this.f7221a = pVar;
        pVar.Y(isRtl());
        rebuildScene();
    }

    void setStartState(int i11) {
        if (isAttachedToWindow()) {
            this.f7231f = i11;
            return;
        }
        if (this.f7244l0 == null) {
            this.f7244l0 = new g();
        }
        this.f7244l0.f(i11);
        this.f7244l0.d(i11);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i11, int i12, int i13) {
        setState(TransitionState.SETUP);
        this.f7231f = i11;
        this.f7229e = -1;
        this.f7233g = -1;
        androidx.constraintlayout.widget.a aVar = this.mConstraintLayoutSpec;
        if (aVar != null) {
            aVar.d(i11, i12, i13);
            return;
        }
        p pVar = this.f7221a;
        if (pVar != null) {
            pVar.m(i11).i(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        TransitionState transitionState2 = TransitionState.FINISHED;
        if (transitionState == transitionState2 && this.f7231f == -1) {
            return;
        }
        TransitionState transitionState3 = this.f7268x0;
        this.f7268x0 = transitionState;
        TransitionState transitionState4 = TransitionState.MOVING;
        if (transitionState3 == transitionState4 && transitionState == transitionState4) {
            O();
        }
        int i11 = a.f7273a[transitionState3.ordinal()];
        if (i11 != 1 && i11 != 2) {
            if (i11 == 3 && transitionState == transitionState2) {
                P();
                return;
            }
            return;
        }
        if (transitionState == transitionState4) {
            O();
        }
        if (transitionState == transitionState2) {
            P();
        }
    }

    public void setTransition(int i11) {
        if (this.f7221a != null) {
            p.b transition = getTransition(i11);
            this.f7229e = transition.A();
            this.f7233g = transition.y();
            if (!isAttachedToWindow()) {
                if (this.f7244l0 == null) {
                    this.f7244l0 = new g();
                }
                this.f7244l0.f(this.f7229e);
                this.f7244l0.d(this.f7233g);
                return;
            }
            int i12 = this.f7231f;
            float f11 = i12 == this.f7229e ? 0.0f : i12 == this.f7233g ? 1.0f : Float.NaN;
            this.f7221a.a0(transition);
            this.f7270y0.e(this.mLayoutWidget, this.f7221a.m(this.f7229e), this.f7221a.m(this.f7233g));
            rebuildScene();
            if (this.f7249o != f11) {
                if (f11 == 0.0f) {
                    L(true);
                    this.f7221a.m(this.f7229e).i(this);
                } else if (f11 == 1.0f) {
                    L(false);
                    this.f7221a.m(this.f7233g).i(this);
                }
            }
            this.f7249o = Float.isNaN(f11) ? 0.0f : f11;
            if (!Float.isNaN(f11)) {
                setProgress(f11);
                return;
            }
            Log.v("MotionLayout", androidx.constraintlayout.motion.widget.a.b() + " transitionToStart ");
            transitionToStart();
        }
    }

    public void setTransition(int i11, int i12) {
        if (!isAttachedToWindow()) {
            if (this.f7244l0 == null) {
                this.f7244l0 = new g();
            }
            this.f7244l0.f(i11);
            this.f7244l0.d(i12);
            return;
        }
        p pVar = this.f7221a;
        if (pVar != null) {
            this.f7229e = i11;
            this.f7233g = i12;
            pVar.Z(i11, i12);
            this.f7270y0.e(this.mLayoutWidget, this.f7221a.m(i11), this.f7221a.m(i12));
            rebuildScene();
            this.f7249o = 0.0f;
            transitionToStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransition(p.b bVar) {
        this.f7221a.a0(bVar);
        setState(TransitionState.SETUP);
        if (this.f7231f == this.f7221a.r()) {
            this.f7249o = 1.0f;
            this.f7247n = 1.0f;
            this.f7253q = 1.0f;
        } else {
            this.f7249o = 0.0f;
            this.f7247n = 0.0f;
            this.f7253q = 0.0f;
        }
        this.f7251p = bVar.D(1) ? -1L : getNanoTime();
        int G = this.f7221a.G();
        int r11 = this.f7221a.r();
        if (G == this.f7229e && r11 == this.f7233g) {
            return;
        }
        this.f7229e = G;
        this.f7233g = r11;
        this.f7221a.Z(G, r11);
        this.f7270y0.e(this.mLayoutWidget, this.f7221a.m(this.f7229e), this.f7221a.m(this.f7233g));
        this.f7270y0.i(this.f7229e, this.f7233g);
        this.f7270y0.h();
        rebuildScene();
    }

    public void setTransitionDuration(int i11) {
        p pVar = this.f7221a;
        if (pVar == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            pVar.X(i11);
        }
    }

    public void setTransitionListener(h hVar) {
        this.f7261u = hVar;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.f7244l0 == null) {
            this.f7244l0 = new g();
        }
        this.f7244l0.g(bundle);
        if (isAttachedToWindow()) {
            this.f7244l0.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return androidx.constraintlayout.motion.widget.a.c(context, this.f7229e) + "->" + androidx.constraintlayout.motion.widget.a.c(context, this.f7233g) + " (pos:" + this.f7249o + " Dpos/Dt:" + this.f7227d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0037, code lost:
    
        if (r10 != 7) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void touchAnimateTo(int r10, float r11, float r12) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void touchSpringTo(float f11, float f12) {
        if (this.f7221a == null || this.f7249o == f11) {
            return;
        }
        this.f7271z = true;
        this.f7243l = getNanoTime();
        this.f7245m = this.f7221a.q() / 1000.0f;
        this.f7253q = f11;
        this.f7257s = true;
        this.A.d(this.f7249o, f11, f12, this.f7221a.C(), this.f7221a.D(), this.f7221a.B(), this.f7221a.E(), this.f7221a.A());
        int i11 = this.f7231f;
        this.f7253q = f11;
        this.f7231f = i11;
        this.f7223b = this.A;
        this.f7255r = false;
        this.f7243l = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        F(1.0f);
        this.f7246m0 = null;
    }

    public void transitionToEnd(Runnable runnable) {
        F(1.0f);
        this.f7246m0 = runnable;
    }

    public void transitionToStart() {
        F(0.0f);
    }

    public void transitionToState(int i11) {
        if (isAttachedToWindow()) {
            transitionToState(i11, -1, -1);
            return;
        }
        if (this.f7244l0 == null) {
            this.f7244l0 = new g();
        }
        this.f7244l0.d(i11);
    }

    public void transitionToState(int i11, int i12) {
        if (isAttachedToWindow()) {
            transitionToState(i11, -1, -1, i12);
            return;
        }
        if (this.f7244l0 == null) {
            this.f7244l0 = new g();
        }
        this.f7244l0.d(i11);
    }

    public void transitionToState(int i11, int i12, int i13) {
        transitionToState(i11, i12, i13, -1);
    }

    public void transitionToState(int i11, int i12, int i13, int i14) {
        androidx.constraintlayout.widget.e eVar;
        int a11;
        p pVar = this.f7221a;
        if (pVar != null && (eVar = pVar.f7499b) != null && (a11 = eVar.a(this.f7231f, i11, i12, i13)) != -1) {
            i11 = a11;
        }
        int i15 = this.f7231f;
        if (i15 == i11) {
            return;
        }
        if (this.f7229e == i11) {
            F(0.0f);
            if (i14 > 0) {
                this.f7245m = i14 / 1000.0f;
                return;
            }
            return;
        }
        if (this.f7233g == i11) {
            F(1.0f);
            if (i14 > 0) {
                this.f7245m = i14 / 1000.0f;
                return;
            }
            return;
        }
        this.f7233g = i11;
        if (i15 != -1) {
            setTransition(i15, i11);
            F(1.0f);
            this.f7249o = 0.0f;
            transitionToEnd();
            if (i14 > 0) {
                this.f7245m = i14 / 1000.0f;
                return;
            }
            return;
        }
        this.f7271z = false;
        this.f7253q = 1.0f;
        this.f7247n = 0.0f;
        this.f7249o = 0.0f;
        this.f7251p = getNanoTime();
        this.f7243l = getNanoTime();
        this.f7255r = false;
        this.f7223b = null;
        if (i14 == -1) {
            this.f7245m = this.f7221a.q() / 1000.0f;
        }
        this.f7229e = -1;
        this.f7221a.Z(-1, this.f7233g);
        SparseArray sparseArray = new SparseArray();
        if (i14 == 0) {
            this.f7245m = this.f7221a.q() / 1000.0f;
        } else if (i14 > 0) {
            this.f7245m = i14 / 1000.0f;
        }
        int childCount = getChildCount();
        this.f7241k.clear();
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            this.f7241k.put(childAt, new m(childAt));
            sparseArray.put(childAt.getId(), (m) this.f7241k.get(childAt));
        }
        this.f7257s = true;
        this.f7270y0.e(this.mLayoutWidget, null, this.f7221a.m(i11));
        rebuildScene();
        this.f7270y0.a();
        K();
        int width = getWidth();
        int height = getHeight();
        if (this.Q != null) {
            for (int i17 = 0; i17 < childCount; i17++) {
                m mVar = (m) this.f7241k.get(getChildAt(i17));
                if (mVar != null) {
                    this.f7221a.u(mVar);
                }
            }
            Iterator it = this.Q.iterator();
            while (it.hasNext()) {
                ((MotionHelper) it.next()).onPreSetup(this, this.f7241k);
            }
            for (int i18 = 0; i18 < childCount; i18++) {
                m mVar2 = (m) this.f7241k.get(getChildAt(i18));
                if (mVar2 != null) {
                    mVar2.I(width, height, this.f7245m, getNanoTime());
                }
            }
        } else {
            for (int i19 = 0; i19 < childCount; i19++) {
                m mVar3 = (m) this.f7241k.get(getChildAt(i19));
                if (mVar3 != null) {
                    this.f7221a.u(mVar3);
                    mVar3.I(width, height, this.f7245m, getNanoTime());
                }
            }
        }
        float F = this.f7221a.F();
        if (F != 0.0f) {
            float f11 = Float.MAX_VALUE;
            float f12 = -3.4028235E38f;
            for (int i20 = 0; i20 < childCount; i20++) {
                m mVar4 = (m) this.f7241k.get(getChildAt(i20));
                float o11 = mVar4.o() + mVar4.n();
                f11 = Math.min(f11, o11);
                f12 = Math.max(f12, o11);
            }
            for (int i21 = 0; i21 < childCount; i21++) {
                m mVar5 = (m) this.f7241k.get(getChildAt(i21));
                float n11 = mVar5.n();
                float o12 = mVar5.o();
                mVar5.f7465o = 1.0f / (1.0f - F);
                mVar5.f7464n = F - ((((n11 + o12) - f11) * F) / (f12 - f11));
            }
        }
        this.f7247n = 0.0f;
        this.f7249o = 0.0f;
        this.f7257s = true;
        invalidate();
    }

    public void updateState() {
        this.f7270y0.e(this.mLayoutWidget, this.f7221a.m(this.f7229e), this.f7221a.m(this.f7233g));
        rebuildScene();
    }

    public void updateState(int i11, androidx.constraintlayout.widget.b bVar) {
        p pVar = this.f7221a;
        if (pVar != null) {
            pVar.W(i11, bVar);
        }
        updateState();
        if (this.f7231f == i11) {
            bVar.i(this);
        }
    }

    public void updateStateAnimate(int i11, androidx.constraintlayout.widget.b bVar, int i12) {
        if (this.f7221a != null && this.f7231f == i11) {
            updateState(R$id.view_transition, getConstraintSet(i11));
            setState(R$id.view_transition, -1, -1);
            updateState(i11, bVar);
            p.b bVar2 = new p.b(-1, this.f7221a, R$id.view_transition, i11);
            bVar2.E(i12);
            setTransition(bVar2);
            transitionToEnd();
        }
    }

    public void viewTransition(int i11, View... viewArr) {
        p pVar = this.f7221a;
        if (pVar != null) {
            pVar.e0(i11, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }
}

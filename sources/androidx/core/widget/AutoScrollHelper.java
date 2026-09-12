package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {

    /* renamed from: r, reason: collision with root package name */
    private static final int f8523r = ViewConfiguration.getTapTimeout();

    /* renamed from: c, reason: collision with root package name */
    final View f8526c;

    /* renamed from: d, reason: collision with root package name */
    private Runnable f8527d;

    /* renamed from: g, reason: collision with root package name */
    private int f8530g;

    /* renamed from: h, reason: collision with root package name */
    private int f8531h;

    /* renamed from: l, reason: collision with root package name */
    private boolean f8535l;

    /* renamed from: m, reason: collision with root package name */
    boolean f8536m;

    /* renamed from: n, reason: collision with root package name */
    boolean f8537n;

    /* renamed from: o, reason: collision with root package name */
    boolean f8538o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f8539p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f8540q;

    /* renamed from: a, reason: collision with root package name */
    final a f8524a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final Interpolator f8525b = new AccelerateInterpolator();

    /* renamed from: e, reason: collision with root package name */
    private float[] f8528e = {0.0f, 0.0f};

    /* renamed from: f, reason: collision with root package name */
    private float[] f8529f = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: i, reason: collision with root package name */
    private float[] f8532i = {0.0f, 0.0f};

    /* renamed from: j, reason: collision with root package name */
    private float[] f8533j = {0.0f, 0.0f};

    /* renamed from: k, reason: collision with root package name */
    private float[] f8534k = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.f8538o) {
                if (autoScrollHelper.f8536m) {
                    autoScrollHelper.f8536m = false;
                    autoScrollHelper.f8524a.m();
                }
                a aVar = AutoScrollHelper.this.f8524a;
                if (aVar.h() || !AutoScrollHelper.this.u()) {
                    AutoScrollHelper.this.f8538o = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.f8537n) {
                    autoScrollHelper2.f8537n = false;
                    autoScrollHelper2.c();
                }
                aVar.a();
                AutoScrollHelper.this.j(aVar.b(), aVar.c());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.f8526c, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private int f8541a;

        /* renamed from: b, reason: collision with root package name */
        private int f8542b;

        /* renamed from: c, reason: collision with root package name */
        private float f8543c;

        /* renamed from: d, reason: collision with root package name */
        private float f8544d;

        /* renamed from: j, reason: collision with root package name */
        private float f8550j;

        /* renamed from: k, reason: collision with root package name */
        private int f8551k;

        /* renamed from: e, reason: collision with root package name */
        private long f8545e = Long.MIN_VALUE;

        /* renamed from: i, reason: collision with root package name */
        private long f8549i = -1;

        /* renamed from: f, reason: collision with root package name */
        private long f8546f = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f8547g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f8548h = 0;

        a() {
        }

        private float e(long j11) {
            long j12 = this.f8545e;
            if (j11 < j12) {
                return 0.0f;
            }
            long j13 = this.f8549i;
            if (j13 < 0 || j11 < j13) {
                return AutoScrollHelper.e(((float) (j11 - j12)) / this.f8541a, 0.0f, 1.0f) * 0.5f;
            }
            float f11 = this.f8550j;
            return (1.0f - f11) + (f11 * AutoScrollHelper.e(((float) (j11 - j13)) / this.f8551k, 0.0f, 1.0f));
        }

        private float g(float f11) {
            return ((-4.0f) * f11 * f11) + (f11 * 4.0f);
        }

        public void a() {
            if (this.f8546f == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float g11 = g(e(currentAnimationTimeMillis));
            long j11 = currentAnimationTimeMillis - this.f8546f;
            this.f8546f = currentAnimationTimeMillis;
            float f11 = ((float) j11) * g11;
            this.f8547g = (int) (this.f8543c * f11);
            this.f8548h = (int) (f11 * this.f8544d);
        }

        public int b() {
            return this.f8547g;
        }

        public int c() {
            return this.f8548h;
        }

        public int d() {
            float f11 = this.f8543c;
            return (int) (f11 / Math.abs(f11));
        }

        public int f() {
            float f11 = this.f8544d;
            return (int) (f11 / Math.abs(f11));
        }

        public boolean h() {
            return this.f8549i > 0 && AnimationUtils.currentAnimationTimeMillis() > this.f8549i + ((long) this.f8551k);
        }

        public void i() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f8551k = AutoScrollHelper.f((int) (currentAnimationTimeMillis - this.f8545e), 0, this.f8542b);
            this.f8550j = e(currentAnimationTimeMillis);
            this.f8549i = currentAnimationTimeMillis;
        }

        public void j(int i11) {
            this.f8542b = i11;
        }

        public void k(int i11) {
            this.f8541a = i11;
        }

        public void l(float f11, float f12) {
            this.f8543c = f11;
            this.f8544d = f12;
        }

        public void m() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f8545e = currentAnimationTimeMillis;
            this.f8549i = -1L;
            this.f8546f = currentAnimationTimeMillis;
            this.f8550j = 0.5f;
            this.f8547g = 0;
            this.f8548h = 0;
        }
    }

    public AutoScrollHelper(View view) {
        this.f8526c = view;
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        float f12 = (int) ((1575.0f * f11) + 0.5f);
        o(f12, f12);
        float f13 = (int) ((f11 * 315.0f) + 0.5f);
        p(f13, f13);
        l(1);
        n(Float.MAX_VALUE, Float.MAX_VALUE);
        s(0.2f, 0.2f);
        t(1.0f, 1.0f);
        k(f8523r);
        r(500);
        q(500);
    }

    private float d(int i11, float f11, float f12, float f13) {
        float h11 = h(this.f8528e[i11], f12, this.f8529f[i11], f11);
        if (h11 == 0.0f) {
            return 0.0f;
        }
        float f14 = this.f8532i[i11];
        float f15 = this.f8533j[i11];
        float f16 = this.f8534k[i11];
        float f17 = f14 * f13;
        return h11 > 0.0f ? e(h11 * f17, f15, f16) : -e((-h11) * f17, f15, f16);
    }

    static float e(float f11, float f12, float f13) {
        return f11 > f13 ? f13 : f11 < f12 ? f12 : f11;
    }

    static int f(int i11, int i12, int i13) {
        return i11 > i13 ? i13 : i11 < i12 ? i12 : i11;
    }

    private float g(float f11, float f12) {
        if (f12 == 0.0f) {
            return 0.0f;
        }
        int i11 = this.f8530g;
        if (i11 == 0 || i11 == 1) {
            if (f11 < f12) {
                if (f11 >= 0.0f) {
                    return 1.0f - (f11 / f12);
                }
                if (this.f8538o && i11 == 1) {
                    return 1.0f;
                }
            }
        } else if (i11 == 2 && f11 < 0.0f) {
            return f11 / (-f12);
        }
        return 0.0f;
    }

    private float h(float f11, float f12, float f13, float f14) {
        float interpolation;
        float e11 = e(f11 * f12, 0.0f, f13);
        float g11 = g(f12 - f14, e11) - g(f14, e11);
        if (g11 < 0.0f) {
            interpolation = -this.f8525b.getInterpolation(-g11);
        } else {
            if (g11 <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.f8525b.getInterpolation(g11);
        }
        return e(interpolation, -1.0f, 1.0f);
    }

    private void i() {
        if (this.f8536m) {
            this.f8538o = false;
        } else {
            this.f8524a.i();
        }
    }

    private void v() {
        int i11;
        if (this.f8527d == null) {
            this.f8527d = new ScrollAnimationRunnable();
        }
        this.f8538o = true;
        this.f8536m = true;
        if (this.f8535l || (i11 = this.f8531h) <= 0) {
            this.f8527d.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.f8526c, this.f8527d, i11);
        }
        this.f8535l = true;
    }

    public abstract boolean a(int i11);

    public abstract boolean b(int i11);

    void c() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.f8526c.onTouchEvent(obtain);
        obtain.recycle();
    }

    public abstract void j(int i11, int i12);

    public AutoScrollHelper k(int i11) {
        this.f8531h = i11;
        return this;
    }

    public AutoScrollHelper l(int i11) {
        this.f8530g = i11;
        return this;
    }

    public AutoScrollHelper m(boolean z10) {
        if (this.f8539p && !z10) {
            i();
        }
        this.f8539p = z10;
        return this;
    }

    public AutoScrollHelper n(float f11, float f12) {
        float[] fArr = this.f8529f;
        fArr[0] = f11;
        fArr[1] = f12;
        return this;
    }

    public AutoScrollHelper o(float f11, float f12) {
        float[] fArr = this.f8534k;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouch(android.view.View r6, android.view.MotionEvent r7) {
        /*
            r5 = this;
            boolean r0 = r5.f8539p
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            int r0 = r7.getActionMasked()
            r2 = 1
            if (r0 == 0) goto L1a
            if (r0 == r2) goto L16
            r3 = 2
            if (r0 == r3) goto L1e
            r6 = 3
            if (r0 == r6) goto L16
            goto L58
        L16:
            r5.i()
            goto L58
        L1a:
            r5.f8537n = r2
            r5.f8535l = r1
        L1e:
            float r0 = r7.getX()
            int r3 = r6.getWidth()
            float r3 = (float) r3
            android.view.View r4 = r5.f8526c
            int r4 = r4.getWidth()
            float r4 = (float) r4
            float r0 = r5.d(r1, r0, r3, r4)
            float r7 = r7.getY()
            int r6 = r6.getHeight()
            float r6 = (float) r6
            android.view.View r3 = r5.f8526c
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r6 = r5.d(r2, r7, r6, r3)
            androidx.core.widget.AutoScrollHelper$a r7 = r5.f8524a
            r7.l(r0, r6)
            boolean r6 = r5.f8538o
            if (r6 != 0) goto L58
            boolean r6 = r5.u()
            if (r6 == 0) goto L58
            r5.v()
        L58:
            boolean r6 = r5.f8540q
            if (r6 == 0) goto L61
            boolean r6 = r5.f8538o
            if (r6 == 0) goto L61
            r1 = r2
        L61:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.widget.AutoScrollHelper.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public AutoScrollHelper p(float f11, float f12) {
        float[] fArr = this.f8533j;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    public AutoScrollHelper q(int i11) {
        this.f8524a.j(i11);
        return this;
    }

    public AutoScrollHelper r(int i11) {
        this.f8524a.k(i11);
        return this;
    }

    public AutoScrollHelper s(float f11, float f12) {
        float[] fArr = this.f8528e;
        fArr[0] = f11;
        fArr[1] = f12;
        return this;
    }

    public AutoScrollHelper t(float f11, float f12) {
        float[] fArr = this.f8532i;
        fArr[0] = f11 / 1000.0f;
        fArr[1] = f12 / 1000.0f;
        return this;
    }

    boolean u() {
        a aVar = this.f8524a;
        int f11 = aVar.f();
        int d11 = aVar.d();
        return (f11 != 0 && b(f11)) || (d11 != 0 && a(d11));
    }
}

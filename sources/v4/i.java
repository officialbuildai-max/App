package v4;

import android.view.Choreographer;

/* loaded from: classes2.dex */
public class i extends c implements Choreographer.FrameCallback {

    /* renamed from: l, reason: collision with root package name */
    private com.airbnb.lottie.h f77163l;

    /* renamed from: d, reason: collision with root package name */
    private float f77155d = 1.0f;

    /* renamed from: e, reason: collision with root package name */
    private boolean f77156e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f77157f = 0;

    /* renamed from: g, reason: collision with root package name */
    private float f77158g = 0.0f;

    /* renamed from: h, reason: collision with root package name */
    private float f77159h = 0.0f;

    /* renamed from: i, reason: collision with root package name */
    private int f77160i = 0;

    /* renamed from: j, reason: collision with root package name */
    private float f77161j = -2.14748365E9f;

    /* renamed from: k, reason: collision with root package name */
    private float f77162k = 2.14748365E9f;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f77164m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f77165n = false;

    private void G() {
        if (this.f77163l == null) {
            return;
        }
        float f11 = this.f77159h;
        if (f11 < this.f77161j || f11 > this.f77162k) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.f77161j), Float.valueOf(this.f77162k), Float.valueOf(this.f77159h)));
        }
    }

    private float n() {
        com.airbnb.lottie.h hVar = this.f77163l;
        if (hVar == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / hVar.i()) / Math.abs(this.f77155d);
    }

    private boolean r() {
        return q() < 0.0f;
    }

    public void A(float f11) {
        if (this.f77158g == f11) {
            return;
        }
        float b11 = k.b(f11, p(), o());
        this.f77158g = b11;
        if (this.f77165n) {
            b11 = (float) Math.floor(b11);
        }
        this.f77159h = b11;
        this.f77157f = 0L;
        i();
    }

    public void B(float f11) {
        C(this.f77161j, f11);
    }

    public void C(float f11, float f12) {
        if (f11 > f12) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f11), Float.valueOf(f12)));
        }
        com.airbnb.lottie.h hVar = this.f77163l;
        float p11 = hVar == null ? -3.4028235E38f : hVar.p();
        com.airbnb.lottie.h hVar2 = this.f77163l;
        float f13 = hVar2 == null ? Float.MAX_VALUE : hVar2.f();
        float b11 = k.b(f11, p11, f13);
        float b12 = k.b(f12, p11, f13);
        if (b11 == this.f77161j && b12 == this.f77162k) {
            return;
        }
        this.f77161j = b11;
        this.f77162k = b12;
        A((int) k.b(this.f77159h, b11, b12));
    }

    public void D(int i11) {
        C(i11, (int) this.f77162k);
    }

    public void E(float f11) {
        this.f77155d = f11;
    }

    public void F(boolean z10) {
        this.f77165n = z10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // v4.c
    public void a() {
        super.a();
        b(r());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        a();
        v();
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j11) {
        u();
        if (this.f77163l == null || !isRunning()) {
            return;
        }
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.b("LottieValueAnimator#doFrame");
        }
        long j12 = this.f77157f;
        float n11 = ((float) (j12 != 0 ? j11 - j12 : 0L)) / n();
        float f11 = this.f77158g;
        if (r()) {
            n11 = -n11;
        }
        float f12 = f11 + n11;
        boolean d11 = k.d(f12, p(), o());
        float f13 = this.f77158g;
        float b11 = k.b(f12, p(), o());
        this.f77158g = b11;
        if (this.f77165n) {
            b11 = (float) Math.floor(b11);
        }
        this.f77159h = b11;
        this.f77157f = j11;
        if (!this.f77165n || this.f77158g != f13) {
            i();
        }
        if (!d11) {
            if (getRepeatCount() == -1 || this.f77160i < getRepeatCount()) {
                e();
                this.f77160i++;
                if (getRepeatMode() == 2) {
                    this.f77156e = !this.f77156e;
                    y();
                } else {
                    float o11 = r() ? o() : p();
                    this.f77158g = o11;
                    this.f77159h = o11;
                }
                this.f77157f = j11;
            } else {
                float p11 = this.f77155d < 0.0f ? p() : o();
                this.f77158g = p11;
                this.f77159h = p11;
                v();
                b(r());
            }
        }
        G();
        if (com.airbnb.lottie.d.g()) {
            com.airbnb.lottie.d.c("LottieValueAnimator#doFrame");
        }
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float p11;
        float o11;
        float p12;
        if (this.f77163l == null) {
            return 0.0f;
        }
        if (r()) {
            p11 = o() - this.f77159h;
            o11 = o();
            p12 = p();
        } else {
            p11 = this.f77159h - p();
            o11 = o();
            p12 = p();
        }
        return p11 / (o11 - p12);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(l());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.f77163l == null) {
            return 0L;
        }
        return r0.d();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.f77164m;
    }

    public void j() {
        this.f77163l = null;
        this.f77161j = -2.14748365E9f;
        this.f77162k = 2.14748365E9f;
    }

    public void k() {
        v();
        b(r());
    }

    public float l() {
        com.airbnb.lottie.h hVar = this.f77163l;
        if (hVar == null) {
            return 0.0f;
        }
        return (this.f77159h - hVar.p()) / (this.f77163l.f() - this.f77163l.p());
    }

    public float m() {
        return this.f77159h;
    }

    public float o() {
        com.airbnb.lottie.h hVar = this.f77163l;
        if (hVar == null) {
            return 0.0f;
        }
        float f11 = this.f77162k;
        return f11 == 2.14748365E9f ? hVar.f() : f11;
    }

    public float p() {
        com.airbnb.lottie.h hVar = this.f77163l;
        if (hVar == null) {
            return 0.0f;
        }
        float f11 = this.f77161j;
        return f11 == -2.14748365E9f ? hVar.p() : f11;
    }

    public float q() {
        return this.f77155d;
    }

    public void s() {
        v();
        c();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i11) {
        super.setRepeatMode(i11);
        if (i11 == 2 || !this.f77156e) {
            return;
        }
        this.f77156e = false;
        y();
    }

    public void t() {
        this.f77164m = true;
        g(r());
        A((int) (r() ? o() : p()));
        this.f77157f = 0L;
        this.f77160i = 0;
        u();
    }

    protected void u() {
        if (isRunning()) {
            w(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    protected void v() {
        w(true);
    }

    protected void w(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.f77164m = false;
        }
    }

    public void x() {
        this.f77164m = true;
        u();
        this.f77157f = 0L;
        if (r() && m() == p()) {
            A(o());
        } else if (!r() && m() == o()) {
            A(p());
        }
        f();
    }

    public void y() {
        E(-q());
    }

    public void z(com.airbnb.lottie.h hVar) {
        boolean z10 = this.f77163l == null;
        this.f77163l = hVar;
        if (z10) {
            C(Math.max(this.f77161j, hVar.p()), Math.min(this.f77162k, hVar.f()));
        } else {
            C((int) hVar.p(), (int) hVar.f());
        }
        float f11 = this.f77159h;
        this.f77159h = 0.0f;
        this.f77158g = 0.0f;
        A((int) f11);
        i();
    }
}

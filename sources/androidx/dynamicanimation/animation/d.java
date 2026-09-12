package androidx.dynamicanimation.animation;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import androidx.dynamicanimation.animation.b;

/* loaded from: classes.dex */
public final class d extends b {
    private e A;
    private float B;
    private boolean C;

    public d(Object obj, c cVar) {
        super(obj, cVar);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
    }

    public d(Object obj, c cVar, float f11) {
        super(obj, cVar);
        this.A = null;
        this.B = Float.MAX_VALUE;
        this.C = false;
        this.A = new e(f11);
    }

    private void p() {
        e eVar = this.A;
        if (eVar == null) {
            throw new UnsupportedOperationException("Incomplete SpringAnimation: Either final position or a spring force needs to be set.");
        }
        double a11 = eVar.a();
        if (a11 > this.f9095g) {
            throw new UnsupportedOperationException("Final position of the spring cannot be greater than the max value.");
        }
        if (a11 < this.f9096h) {
            throw new UnsupportedOperationException("Final position of the spring cannot be less than the min value.");
        }
    }

    @Override // androidx.dynamicanimation.animation.b
    public void i() {
        p();
        this.A.g(d());
        super.i();
    }

    @Override // androidx.dynamicanimation.animation.b
    boolean k(long j11) {
        if (this.C) {
            float f11 = this.B;
            if (f11 != Float.MAX_VALUE) {
                this.A.e(f11);
                this.B = Float.MAX_VALUE;
            }
            this.f9090b = this.A.a();
            this.f9089a = 0.0f;
            this.C = false;
            return true;
        }
        if (this.B != Float.MAX_VALUE) {
            this.A.a();
            long j12 = j11 / 2;
            b.o h11 = this.A.h(this.f9090b, this.f9089a, j12);
            this.A.e(this.B);
            this.B = Float.MAX_VALUE;
            b.o h12 = this.A.h(h11.f9101a, h11.f9102b, j12);
            this.f9090b = h12.f9101a;
            this.f9089a = h12.f9102b;
        } else {
            b.o h13 = this.A.h(this.f9090b, this.f9089a, j11);
            this.f9090b = h13.f9101a;
            this.f9089a = h13.f9102b;
        }
        float max = Math.max(this.f9090b, this.f9096h);
        this.f9090b = max;
        float min = Math.min(max, this.f9095g);
        this.f9090b = min;
        if (!o(min, this.f9089a)) {
            return false;
        }
        this.f9090b = this.A.a();
        this.f9089a = 0.0f;
        return true;
    }

    public void l(float f11) {
        if (e()) {
            this.B = f11;
            return;
        }
        if (this.A == null) {
            this.A = new e(f11);
        }
        this.A.e(f11);
        i();
    }

    public boolean m() {
        return this.A.f9105b > 0.0d;
    }

    public e n() {
        return this.A;
    }

    boolean o(float f11, float f12) {
        return this.A.c(f11, f12);
    }

    public d q(e eVar) {
        this.A = eVar;
        return this;
    }

    public void r() {
        if (!m()) {
            throw new UnsupportedOperationException("Spring animations can only come to an end when there is damping");
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new AndroidRuntimeException("Animations may only be started on the main thread");
        }
        if (this.f9094f) {
            this.C = true;
        }
    }
}

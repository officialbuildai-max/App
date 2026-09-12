package com.bytedance.adsdk.sP.vS;

import android.view.Choreographer;
import com.bytedance.adsdk.sP.Jcg;

/* loaded from: classes2.dex */
public class TKC extends Sj implements Choreographer.FrameCallback {
    private Jcg TEQ;
    private float sP = 1.0f;
    private boolean TKC = false;
    private long EjP = 0;
    private float HiB = 0.0f;
    private float vS = 0.0f;
    private int Jcg = 0;
    private float Dq = -2.14748365E9f;
    private float uA = 2.14748365E9f;
    protected boolean Sj = false;
    private boolean Ym = false;

    private float RiZ() {
        Jcg jcg = this.TEQ;
        if (jcg == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / jcg.aa()) / Math.abs(this.sP);
    }

    private void dx() {
        if (this.TEQ == null) {
            return;
        }
        float f11 = this.vS;
        if (f11 < this.Dq || f11 > this.uA) {
            throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.Dq), Float.valueOf(this.uA), Float.valueOf(this.vS)));
        }
    }

    private boolean sU() {
        return TEQ() < 0.0f;
    }

    public void Dq() {
        this.TEQ = null;
        this.Dq = -2.14748365E9f;
        this.uA = 2.14748365E9f;
    }

    protected void EjP(boolean z10) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z10) {
            this.Sj = false;
        }
    }

    public void Fmk() {
        TzV();
        EjP();
    }

    public float Jcg() {
        return this.vS;
    }

    public void Sj(float f11) {
        if (this.HiB == f11) {
            return;
        }
        float sP = HiB.sP(f11, Zq(), uvD());
        this.HiB = sP;
        if (this.Ym) {
            sP = (float) Math.floor(sP);
        }
        this.vS = sP;
        this.EjP = 0L;
        TKC();
    }

    public void Sj(float f11, float f12) {
        if (f11 > f12) {
            throw new IllegalArgumentException(String.format("minFrame (%s) must be <= maxFrame (%s)", Float.valueOf(f11), Float.valueOf(f12)));
        }
        Jcg jcg = this.TEQ;
        float vS = jcg == null ? -3.4028235E38f : jcg.vS();
        Jcg jcg2 = this.TEQ;
        float Jcg = jcg2 == null ? Float.MAX_VALUE : jcg2.Jcg();
        float sP = HiB.sP(f11, vS, Jcg);
        float sP2 = HiB.sP(f12, vS, Jcg);
        if (sP == this.Dq && sP2 == this.uA) {
            return;
        }
        this.Dq = sP;
        this.uA = sP2;
        Sj((int) HiB.sP(this.vS, sP, sP2));
    }

    public void Sj(int i11) {
        Sj(i11, (int) this.uA);
    }

    public void Sj(Jcg jcg) {
        boolean z10 = this.TEQ == null;
        this.TEQ = jcg;
        if (z10) {
            Sj(Math.max(this.Dq, jcg.vS()), Math.min(this.uA, jcg.Jcg()));
        } else {
            Sj((int) jcg.vS(), (int) jcg.Jcg());
        }
        float f11 = this.vS;
        this.vS = 0.0f;
        this.HiB = 0.0f;
        Sj((int) f11);
        TKC();
    }

    public float TEQ() {
        return this.sP;
    }

    public void TKC(float f11) {
        this.sP = f11;
    }

    public void TKC(boolean z10) {
        this.Ym = z10;
    }

    protected void TzV() {
        EjP(true);
    }

    public void Ym() {
        this.Sj = true;
        Sj(sU());
        Sj((int) (sU() ? uvD() : Zq()));
        this.EjP = 0L;
        this.Jcg = 0;
        dNu();
    }

    public float Zq() {
        Jcg jcg = this.TEQ;
        if (jcg == null) {
            return 0.0f;
        }
        float f11 = this.Dq;
        return f11 == -2.14748365E9f ? jcg.vS() : f11;
    }

    public void aa() {
        TzV();
        sP(sU());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void cancel() {
        sP();
        TzV();
    }

    protected void dNu() {
        if (isRunning()) {
            EjP(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j11) {
        dNu();
        if (this.TEQ == null || !isRunning()) {
            return;
        }
        com.bytedance.adsdk.sP.HiB.Sj("LottieValueAnimator#doFrame");
        long j12 = this.EjP;
        float RiZ = ((float) (j12 != 0 ? j11 - j12 : 0L)) / RiZ();
        float f11 = this.HiB;
        if (sU()) {
            RiZ = -RiZ;
        }
        float f12 = f11 + RiZ;
        boolean TKC = HiB.TKC(f12, Zq(), uvD());
        float f13 = this.HiB;
        float sP = HiB.sP(f12, Zq(), uvD());
        this.HiB = sP;
        if (this.Ym) {
            sP = (float) Math.floor(sP);
        }
        this.vS = sP;
        this.EjP = j11;
        if (!this.Ym || this.HiB != f13) {
            TKC();
        }
        if (!TKC) {
            if (getRepeatCount() == -1 || this.Jcg < getRepeatCount()) {
                Sj();
                this.Jcg++;
                if (getRepeatMode() == 2) {
                    this.TKC = !this.TKC;
                    uA();
                } else {
                    float uvD = sU() ? uvD() : Zq();
                    this.HiB = uvD;
                    this.vS = uvD;
                }
                this.EjP = j11;
            } else {
                float Zq = this.sP < 0.0f ? Zq() : uvD();
                this.HiB = Zq;
                this.vS = Zq;
                TzV();
                sP(sU());
            }
        }
        dx();
        com.bytedance.adsdk.sP.HiB.sP("LottieValueAnimator#doFrame");
    }

    @Override // android.animation.ValueAnimator
    public float getAnimatedFraction() {
        float Zq;
        float uvD;
        float Zq2;
        if (this.TEQ == null) {
            return 0.0f;
        }
        if (sU()) {
            Zq = uvD() - this.vS;
            uvD = uvD();
            Zq2 = Zq();
        } else {
            Zq = this.vS - Zq();
            uvD = uvD();
            Zq2 = Zq();
        }
        return Zq / (uvD - Zq2);
    }

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(vS());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.TEQ == null) {
            return 0L;
        }
        return r0.HiB();
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.Sj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.sP.vS.Sj
    public void sP() {
        super.sP();
        sP(sU());
    }

    public void sP(float f11) {
        Sj(this.Dq, f11);
    }

    public void sef() {
        this.Sj = true;
        dNu();
        this.EjP = 0L;
        if (sU() && Jcg() == Zq()) {
            Sj(uvD());
        } else if (!sU() && Jcg() == uvD()) {
            Sj(Zq());
        }
        HiB();
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i11) {
        super.setRepeatMode(i11);
        if (i11 == 2 || !this.TKC) {
            return;
        }
        this.TKC = false;
        uA();
    }

    public void uA() {
        TKC(-TEQ());
    }

    public float uvD() {
        Jcg jcg = this.TEQ;
        if (jcg == null) {
            return 0.0f;
        }
        float f11 = this.uA;
        return f11 == 2.14748365E9f ? jcg.Jcg() : f11;
    }

    public float vS() {
        Jcg jcg = this.TEQ;
        if (jcg == null) {
            return 0.0f;
        }
        return (this.vS - jcg.vS()) / (this.TEQ.Jcg() - this.TEQ.vS());
    }
}

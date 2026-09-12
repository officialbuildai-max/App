package com.bytedance.adsdk.sP.Sj.sP;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.sP.Sj.sP.Sj;

/* loaded from: classes2.dex */
public class uvD {
    private Sj<com.bytedance.adsdk.sP.Jcg.TKC, com.bytedance.adsdk.sP.Jcg.TKC> Dq;
    private final Matrix EjP;
    private Sj<?, Float> Fmk;
    private final float[] HiB;
    private Sj<?, PointF> Jcg;
    private final Matrix Sj = new Matrix();
    private Sj<Integer, Integer> TEQ;
    private final Matrix TKC;
    private EjP Ym;

    /* renamed from: aa, reason: collision with root package name */
    private EjP f20858aa;
    private final Matrix sP;
    private Sj<?, Float> sef;
    private Sj<Float, Float> uA;
    private Sj<PointF, PointF> vS;

    public uvD(com.bytedance.adsdk.sP.TKC.Sj.aa aaVar) {
        this.vS = aaVar.Sj() == null ? null : aaVar.Sj().Sj();
        this.Jcg = aaVar.sP() == null ? null : aaVar.sP().Sj();
        this.Dq = aaVar.TKC() == null ? null : aaVar.TKC().Sj();
        this.uA = aaVar.EjP() == null ? null : aaVar.EjP().Sj();
        EjP ejP = aaVar.Dq() == null ? null : (EjP) aaVar.Dq().Sj();
        this.Ym = ejP;
        if (ejP != null) {
            this.sP = new Matrix();
            this.TKC = new Matrix();
            this.EjP = new Matrix();
            this.HiB = new float[9];
        } else {
            this.sP = null;
            this.TKC = null;
            this.EjP = null;
            this.HiB = null;
        }
        this.f20858aa = aaVar.uA() == null ? null : (EjP) aaVar.uA().Sj();
        if (aaVar.HiB() != null) {
            this.TEQ = aaVar.HiB().Sj();
        }
        if (aaVar.vS() != null) {
            this.Fmk = aaVar.vS().Sj();
        } else {
            this.Fmk = null;
        }
        if (aaVar.Jcg() != null) {
            this.sef = aaVar.Jcg().Sj();
        } else {
            this.sef = null;
        }
    }

    private void HiB() {
        for (int i11 = 0; i11 < 9; i11++) {
            this.HiB[i11] = 0.0f;
        }
    }

    public Matrix EjP() {
        PointF Jcg;
        PointF Jcg2;
        this.Sj.reset();
        Sj<?, PointF> sj2 = this.Jcg;
        if (sj2 != null && (Jcg2 = sj2.Jcg()) != null) {
            float f11 = Jcg2.x;
            if (f11 != 0.0f || Jcg2.y != 0.0f) {
                this.Sj.preTranslate(f11, Jcg2.y);
            }
        }
        Sj<Float, Float> sj3 = this.uA;
        if (sj3 != null) {
            float floatValue = sj3 instanceof dNu ? sj3.Jcg().floatValue() : ((EjP) sj3).uA();
            if (floatValue != 0.0f) {
                this.Sj.preRotate(floatValue);
            }
        }
        if (this.Ym != null) {
            float cos = this.f20858aa == null ? 0.0f : (float) Math.cos(Math.toRadians((-r3.uA()) + 90.0f));
            float sin = this.f20858aa == null ? 1.0f : (float) Math.sin(Math.toRadians((-r5.uA()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(r0.uA()));
            HiB();
            float[] fArr = this.HiB;
            fArr[0] = cos;
            fArr[1] = sin;
            float f12 = -sin;
            fArr[3] = f12;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.sP.setValues(fArr);
            HiB();
            float[] fArr2 = this.HiB;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.TKC.setValues(fArr2);
            HiB();
            float[] fArr3 = this.HiB;
            fArr3[0] = cos;
            fArr3[1] = f12;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.EjP.setValues(fArr3);
            this.TKC.preConcat(this.sP);
            this.EjP.preConcat(this.TKC);
            this.Sj.preConcat(this.EjP);
        }
        Sj<com.bytedance.adsdk.sP.Jcg.TKC, com.bytedance.adsdk.sP.Jcg.TKC> sj4 = this.Dq;
        if (sj4 != null) {
            com.bytedance.adsdk.sP.Jcg.TKC Jcg3 = sj4.Jcg();
            if (Jcg3.Sj() != 1.0f || Jcg3.sP() != 1.0f) {
                this.Sj.preScale(Jcg3.Sj(), Jcg3.sP());
            }
        }
        Sj<PointF, PointF> sj5 = this.vS;
        if (sj5 != null && (((Jcg = sj5.Jcg()) != null && Jcg.x != 0.0f) || Jcg.y != 0.0f)) {
            this.Sj.preTranslate(-Jcg.x, -Jcg.y);
        }
        return this.Sj;
    }

    public Sj<?, Integer> Sj() {
        return this.TEQ;
    }

    public void Sj(float f11) {
        Sj<Integer, Integer> sj2 = this.TEQ;
        if (sj2 != null) {
            sj2.Sj(f11);
        }
        Sj<?, Float> sj3 = this.Fmk;
        if (sj3 != null) {
            sj3.Sj(f11);
        }
        Sj<?, Float> sj4 = this.sef;
        if (sj4 != null) {
            sj4.Sj(f11);
        }
        Sj<PointF, PointF> sj5 = this.vS;
        if (sj5 != null) {
            sj5.Sj(f11);
        }
        Sj<?, PointF> sj6 = this.Jcg;
        if (sj6 != null) {
            sj6.Sj(f11);
        }
        Sj<com.bytedance.adsdk.sP.Jcg.TKC, com.bytedance.adsdk.sP.Jcg.TKC> sj7 = this.Dq;
        if (sj7 != null) {
            sj7.Sj(f11);
        }
        Sj<Float, Float> sj8 = this.uA;
        if (sj8 != null) {
            sj8.Sj(f11);
        }
        EjP ejP = this.Ym;
        if (ejP != null) {
            ejP.Sj(f11);
        }
        EjP ejP2 = this.f20858aa;
        if (ejP2 != null) {
            ejP2.Sj(f11);
        }
    }

    public void Sj(Sj.InterfaceC0203Sj interfaceC0203Sj) {
        Sj<Integer, Integer> sj2 = this.TEQ;
        if (sj2 != null) {
            sj2.Sj(interfaceC0203Sj);
        }
        Sj<?, Float> sj3 = this.Fmk;
        if (sj3 != null) {
            sj3.Sj(interfaceC0203Sj);
        }
        Sj<?, Float> sj4 = this.sef;
        if (sj4 != null) {
            sj4.Sj(interfaceC0203Sj);
        }
        Sj<PointF, PointF> sj5 = this.vS;
        if (sj5 != null) {
            sj5.Sj(interfaceC0203Sj);
        }
        Sj<?, PointF> sj6 = this.Jcg;
        if (sj6 != null) {
            sj6.Sj(interfaceC0203Sj);
        }
        Sj<com.bytedance.adsdk.sP.Jcg.TKC, com.bytedance.adsdk.sP.Jcg.TKC> sj7 = this.Dq;
        if (sj7 != null) {
            sj7.Sj(interfaceC0203Sj);
        }
        Sj<Float, Float> sj8 = this.uA;
        if (sj8 != null) {
            sj8.Sj(interfaceC0203Sj);
        }
        EjP ejP = this.Ym;
        if (ejP != null) {
            ejP.Sj(interfaceC0203Sj);
        }
        EjP ejP2 = this.f20858aa;
        if (ejP2 != null) {
            ejP2.Sj(interfaceC0203Sj);
        }
    }

    public void Sj(com.bytedance.adsdk.sP.TKC.TKC.Sj sj2) {
        sj2.Sj(this.TEQ);
        sj2.Sj(this.Fmk);
        sj2.Sj(this.sef);
        sj2.Sj(this.vS);
        sj2.Sj(this.Jcg);
        sj2.Sj(this.Dq);
        sj2.Sj(this.uA);
        sj2.Sj(this.Ym);
        sj2.Sj(this.f20858aa);
    }

    public Sj<?, Float> TKC() {
        return this.sef;
    }

    public Matrix sP(float f11) {
        Sj<?, PointF> sj2 = this.Jcg;
        PointF Jcg = sj2 == null ? null : sj2.Jcg();
        Sj<com.bytedance.adsdk.sP.Jcg.TKC, com.bytedance.adsdk.sP.Jcg.TKC> sj3 = this.Dq;
        com.bytedance.adsdk.sP.Jcg.TKC Jcg2 = sj3 == null ? null : sj3.Jcg();
        this.Sj.reset();
        if (Jcg != null) {
            this.Sj.preTranslate(Jcg.x * f11, Jcg.y * f11);
        }
        if (Jcg2 != null) {
            double d11 = f11;
            this.Sj.preScale((float) Math.pow(Jcg2.Sj(), d11), (float) Math.pow(Jcg2.sP(), d11));
        }
        Sj<Float, Float> sj4 = this.uA;
        if (sj4 != null) {
            float floatValue = sj4.Jcg().floatValue();
            Sj<PointF, PointF> sj5 = this.vS;
            PointF Jcg3 = sj5 != null ? sj5.Jcg() : null;
            this.Sj.preRotate(floatValue * f11, Jcg3 == null ? 0.0f : Jcg3.x, Jcg3 != null ? Jcg3.y : 0.0f);
        }
        return this.Sj;
    }

    public Sj<?, Float> sP() {
        return this.Fmk;
    }
}

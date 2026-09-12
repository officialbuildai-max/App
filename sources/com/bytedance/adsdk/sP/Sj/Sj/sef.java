package com.bytedance.adsdk.sP.Sj.Sj;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.sP.Sj.sP.Sj;
import com.bytedance.adsdk.sP.TKC.sP.RiZ;
import com.bytedance.adsdk.sP.TKC.sP.TEQ;
import java.util.List;

/* loaded from: classes2.dex */
public class sef implements Fmk, Ym, Sj.InterfaceC0203Sj {
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, PointF> Dq;
    private final TEQ.Sj EjP;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> Fmk;
    private final boolean HiB;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> Jcg;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> TEQ;
    private final com.bytedance.adsdk.sP.uA TKC;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> Ym;
    private boolean Zq;

    /* renamed from: aa, reason: collision with root package name */
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> f20856aa;
    private final String sP;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> uA;
    private final boolean vS;
    private final Path Sj = new Path();
    private final sP sef = new sP();

    /* renamed from: com.bytedance.adsdk.sP.Sj.Sj.sef$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] Sj;

        static {
            int[] iArr = new int[TEQ.Sj.values().length];
            Sj = iArr;
            try {
                iArr[TEQ.Sj.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                Sj[TEQ.Sj.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public sef(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, com.bytedance.adsdk.sP.TKC.sP.TEQ teq) {
        this.TKC = uAVar;
        this.sP = teq.Sj();
        TEQ.Sj sP = teq.sP();
        this.EjP = sP;
        this.HiB = teq.TEQ();
        this.vS = teq.Ym();
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj = teq.TKC().Sj();
        this.Jcg = Sj;
        com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Sj2 = teq.EjP().Sj();
        this.Dq = Sj2;
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj3 = teq.HiB().Sj();
        this.uA = Sj3;
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj4 = teq.Jcg().Sj();
        this.Ym = Sj4;
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj5 = teq.uA().Sj();
        this.Fmk = Sj5;
        TEQ.Sj sj3 = TEQ.Sj.STAR;
        if (sP == sj3) {
            this.TEQ = teq.vS().Sj();
            this.f20856aa = teq.Dq().Sj();
        } else {
            this.TEQ = null;
            this.f20856aa = null;
        }
        sj2.Sj(Sj);
        sj2.Sj(Sj2);
        sj2.Sj(Sj3);
        sj2.Sj(Sj4);
        sj2.Sj(Sj5);
        if (sP == sj3) {
            sj2.Sj(this.TEQ);
            sj2.Sj(this.f20856aa);
        }
        Sj.Sj(this);
        Sj2.Sj(this);
        Sj3.Sj(this);
        Sj4.Sj(this);
        Sj5.Sj(this);
        if (sP == sj3) {
            this.TEQ.Sj(this);
            this.f20856aa.Sj(this);
        }
    }

    private void HiB() {
        int i11;
        double d11;
        double d12;
        double d13;
        int floor = (int) Math.floor(this.Jcg.Jcg().floatValue());
        double radians = Math.toRadians((this.uA == null ? 0.0d : r2.Jcg().floatValue()) - 90.0d);
        double d14 = floor;
        float floatValue = this.Fmk.Jcg().floatValue() / 100.0f;
        float floatValue2 = this.Ym.Jcg().floatValue();
        double d15 = floatValue2;
        float cos = (float) (Math.cos(radians) * d15);
        float sin = (float) (Math.sin(radians) * d15);
        this.Sj.moveTo(cos, sin);
        double d16 = (float) (6.283185307179586d / d14);
        double d17 = radians + d16;
        double ceil = Math.ceil(d14);
        int i12 = 0;
        while (i12 < ceil) {
            float cos2 = (float) (Math.cos(d17) * d15);
            double d18 = ceil;
            float sin2 = (float) (d15 * Math.sin(d17));
            if (floatValue != 0.0f) {
                d12 = d15;
                i11 = i12;
                d11 = d17;
                double atan2 = (float) (Math.atan2(sin, cos) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                d13 = d16;
                double atan22 = (float) (Math.atan2(sin2, cos2) - 1.5707963267948966d);
                float f11 = floatValue2 * floatValue * 0.25f;
                this.Sj.cubicTo(cos - (cos3 * f11), sin - (sin3 * f11), cos2 + (((float) Math.cos(atan22)) * f11), sin2 + (f11 * ((float) Math.sin(atan22))), cos2, sin2);
            } else {
                i11 = i12;
                d11 = d17;
                d12 = d15;
                d13 = d16;
                this.Sj.lineTo(cos2, sin2);
            }
            d17 = d11 + d13;
            i12 = i11 + 1;
            sin = sin2;
            cos = cos2;
            ceil = d18;
            d15 = d12;
            d16 = d13;
        }
        PointF Jcg = this.Dq.Jcg();
        this.Sj.offset(Jcg.x, Jcg.y);
        this.Sj.close();
    }

    private void TKC() {
        int i11;
        float f11;
        float f12;
        double d11;
        float f13;
        float f14;
        float f15;
        float f16;
        double d12;
        float f17;
        float f18;
        float f19;
        double d13;
        float floatValue = this.Jcg.Jcg().floatValue();
        double radians = Math.toRadians((this.uA == null ? 0.0d : r2.Jcg().floatValue()) - 90.0d);
        double d14 = floatValue;
        float f20 = (float) (6.283185307179586d / d14);
        if (this.vS) {
            f20 *= -1.0f;
        }
        float f21 = f20 / 2.0f;
        float f22 = floatValue - ((int) floatValue);
        int i12 = (f22 > 0.0f ? 1 : (f22 == 0.0f ? 0 : -1));
        if (i12 != 0) {
            radians += (1.0f - f22) * f21;
        }
        float floatValue2 = this.Ym.Jcg().floatValue();
        float floatValue3 = this.TEQ.Jcg().floatValue();
        com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> sj2 = this.f20856aa;
        float floatValue4 = sj2 != null ? sj2.Jcg().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> sj3 = this.Fmk;
        float floatValue5 = sj3 != null ? sj3.Jcg().floatValue() / 100.0f : 0.0f;
        if (i12 != 0) {
            f14 = ((floatValue2 - floatValue3) * f22) + floatValue3;
            i11 = i12;
            double d15 = f14;
            float cos = (float) (d15 * Math.cos(radians));
            f13 = (float) (d15 * Math.sin(radians));
            this.Sj.moveTo(cos, f13);
            d11 = radians + ((f20 * f22) / 2.0f);
            f11 = cos;
            f12 = f21;
        } else {
            i11 = i12;
            double d16 = floatValue2;
            float cos2 = (float) (Math.cos(radians) * d16);
            float sin = (float) (d16 * Math.sin(radians));
            this.Sj.moveTo(cos2, sin);
            f11 = cos2;
            f12 = f21;
            d11 = radians + f12;
            f13 = sin;
            f14 = 0.0f;
        }
        double ceil = Math.ceil(d14) * 2.0d;
        int i13 = 0;
        float f23 = f12;
        float f24 = f11;
        boolean z10 = false;
        while (true) {
            double d17 = i13;
            if (d17 >= ceil) {
                PointF Jcg = this.Dq.Jcg();
                this.Sj.offset(Jcg.x, Jcg.y);
                this.Sj.close();
                return;
            }
            float f25 = z10 ? floatValue2 : floatValue3;
            if (f14 == 0.0f || d17 != ceil - 2.0d) {
                f15 = f20;
                f16 = f23;
            } else {
                f15 = f20;
                f16 = (f20 * f22) / 2.0f;
            }
            if (f14 == 0.0f || d17 != ceil - 1.0d) {
                d12 = d17;
                f17 = f14;
                f14 = f25;
            } else {
                d12 = d17;
                f17 = f14;
            }
            double d18 = f14;
            double d19 = ceil;
            float cos3 = (float) (d18 * Math.cos(d11));
            float sin2 = (float) (d18 * Math.sin(d11));
            if (floatValue4 == 0.0f && floatValue5 == 0.0f) {
                this.Sj.lineTo(cos3, sin2);
                d13 = d11;
                f18 = floatValue4;
                f19 = floatValue5;
            } else {
                f18 = floatValue4;
                double atan2 = (float) (Math.atan2(f13, f24) - 1.5707963267948966d);
                float cos4 = (float) Math.cos(atan2);
                float sin3 = (float) Math.sin(atan2);
                f19 = floatValue5;
                d13 = d11;
                double atan22 = (float) (Math.atan2(sin2, cos3) - 1.5707963267948966d);
                float cos5 = (float) Math.cos(atan22);
                float sin4 = (float) Math.sin(atan22);
                float f26 = z10 ? f18 : f19;
                float f27 = z10 ? f19 : f18;
                float f28 = (z10 ? floatValue3 : floatValue2) * f26 * 0.47829f;
                float f29 = cos4 * f28;
                float f30 = f28 * sin3;
                float f31 = (z10 ? floatValue2 : floatValue3) * f27 * 0.47829f;
                float f32 = cos5 * f31;
                float f33 = f31 * sin4;
                if (i11 != 0) {
                    if (i13 == 0) {
                        f29 *= f22;
                        f30 *= f22;
                    } else if (d12 == d19 - 1.0d) {
                        f32 *= f22;
                        f33 *= f22;
                    }
                }
                this.Sj.cubicTo(f24 - f29, f13 - f30, cos3 + f32, sin2 + f33, cos3, sin2);
            }
            d11 = d13 + f16;
            z10 = !z10;
            i13++;
            f24 = cos3;
            f13 = sin2;
            floatValue5 = f19;
            floatValue4 = f18;
            f14 = f17;
            f20 = f15;
            ceil = d19;
        }
    }

    private void sP() {
        this.Zq = false;
        this.TKC.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.Fmk
    public Path EjP() {
        if (this.Zq) {
            return this.Sj;
        }
        this.Sj.reset();
        if (this.HiB) {
            this.Zq = true;
            return this.Sj;
        }
        int i11 = AnonymousClass1.Sj[this.EjP.ordinal()];
        if (i11 == 1) {
            TKC();
        } else if (i11 == 2) {
            HiB();
        }
        this.Sj.close();
        this.sef.Sj(this.Sj);
        this.Zq = true;
        return this.Sj;
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.InterfaceC0203Sj
    public void Sj() {
        sP();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TKC
    public void Sj(List<TKC> list, List<TKC> list2) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            TKC tkc = list.get(i11);
            if (tkc instanceof dx) {
                dx dxVar = (dx) tkc;
                if (dxVar.sP() == RiZ.Sj.SIMULTANEOUSLY) {
                    this.sef.Sj(dxVar);
                    dxVar.Sj(this);
                }
            }
        }
    }
}

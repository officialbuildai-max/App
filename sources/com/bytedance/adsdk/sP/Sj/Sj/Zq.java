package com.bytedance.adsdk.sP.Sj.Sj;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.sP.Sj.sP.Sj;
import com.bytedance.adsdk.sP.TKC.sP.RiZ;
import java.util.List;

/* loaded from: classes2.dex */
public class Zq implements Fmk, Ym, Sj.InterfaceC0203Sj {
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> Dq;
    private final boolean EjP;
    private final com.bytedance.adsdk.sP.uA HiB;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, PointF> Jcg;
    private final String TKC;
    private boolean Ym;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, PointF> vS;
    private final Path Sj = new Path();
    private final RectF sP = new RectF();
    private final sP uA = new sP();
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> TEQ = null;

    public Zq(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, com.bytedance.adsdk.sP.TKC.sP.Ym ym2) {
        this.TKC = ym2.Sj();
        this.EjP = ym2.HiB();
        this.HiB = uAVar;
        com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Sj = ym2.EjP().Sj();
        this.vS = Sj;
        com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Sj2 = ym2.TKC().Sj();
        this.Jcg = Sj2;
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj3 = ym2.sP().Sj();
        this.Dq = Sj3;
        sj2.Sj(Sj);
        sj2.Sj(Sj2);
        sj2.Sj(Sj3);
        Sj.Sj(this);
        Sj2.Sj(this);
        Sj3.Sj(this);
    }

    private void sP() {
        this.Ym = false;
        this.HiB.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.Fmk
    public Path EjP() {
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> sj2;
        if (this.Ym) {
            return this.Sj;
        }
        this.Sj.reset();
        if (this.EjP) {
            this.Ym = true;
            return this.Sj;
        }
        PointF Jcg = this.Jcg.Jcg();
        float f11 = Jcg.x / 2.0f;
        float f12 = Jcg.y / 2.0f;
        com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> sj3 = this.Dq;
        float uA = sj3 == null ? 0.0f : ((com.bytedance.adsdk.sP.Sj.sP.EjP) sj3).uA();
        if (uA == 0.0f && (sj2 = this.TEQ) != null) {
            uA = Math.min(sj2.Jcg().floatValue(), Math.min(f11, f12));
        }
        float min = Math.min(f11, f12);
        if (uA > min) {
            uA = min;
        }
        PointF Jcg2 = this.vS.Jcg();
        this.Sj.moveTo(Jcg2.x + f11, (Jcg2.y - f12) + uA);
        this.Sj.lineTo(Jcg2.x + f11, (Jcg2.y + f12) - uA);
        if (uA > 0.0f) {
            RectF rectF = this.sP;
            float f13 = Jcg2.x;
            float f14 = uA * 2.0f;
            float f15 = Jcg2.y;
            rectF.set((f13 + f11) - f14, (f15 + f12) - f14, f13 + f11, f15 + f12);
            this.Sj.arcTo(this.sP, 0.0f, 90.0f, false);
        }
        this.Sj.lineTo((Jcg2.x - f11) + uA, Jcg2.y + f12);
        if (uA > 0.0f) {
            RectF rectF2 = this.sP;
            float f16 = Jcg2.x;
            float f17 = Jcg2.y;
            float f18 = uA * 2.0f;
            rectF2.set(f16 - f11, (f17 + f12) - f18, (f16 - f11) + f18, f17 + f12);
            this.Sj.arcTo(this.sP, 90.0f, 90.0f, false);
        }
        this.Sj.lineTo(Jcg2.x - f11, (Jcg2.y - f12) + uA);
        if (uA > 0.0f) {
            RectF rectF3 = this.sP;
            float f19 = Jcg2.x;
            float f20 = Jcg2.y;
            float f21 = uA * 2.0f;
            rectF3.set(f19 - f11, f20 - f12, (f19 - f11) + f21, (f20 - f12) + f21);
            this.Sj.arcTo(this.sP, 180.0f, 90.0f, false);
        }
        this.Sj.lineTo((Jcg2.x + f11) - uA, Jcg2.y - f12);
        if (uA > 0.0f) {
            RectF rectF4 = this.sP;
            float f22 = Jcg2.x;
            float f23 = uA * 2.0f;
            float f24 = Jcg2.y;
            rectF4.set((f22 + f11) - f23, f24 - f12, f22 + f11, (f24 - f12) + f23);
            this.Sj.arcTo(this.sP, 270.0f, 90.0f, false);
        }
        this.Sj.close();
        this.uA.Sj(this.Sj);
        this.Ym = true;
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
                    this.uA.Sj(dxVar);
                    dxVar.Sj(this);
                }
            }
            if (tkc instanceof dNu) {
                this.TEQ = ((dNu) tkc).sP();
            }
        }
    }
}

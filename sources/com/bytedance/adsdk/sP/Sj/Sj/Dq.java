package com.bytedance.adsdk.sP.Sj.Sj;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.bytedance.adsdk.sP.Sj.sP.Sj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class Dq implements HiB, Ym, Sj.InterfaceC0203Sj {
    private final Paint Dq;
    private final com.bytedance.adsdk.sP.TKC.TKC.Sj EjP;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> Fmk;
    private final Path Jcg;
    private final int RiZ;
    float Sj;
    private final List<Fmk> TEQ;
    private final boolean TKC;
    private final com.bytedance.adsdk.sP.uA TzV;
    private final com.bytedance.adsdk.sP.TKC.sP.Jcg Ym;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Zq;

    /* renamed from: aa, reason: collision with root package name */
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<com.bytedance.adsdk.sP.TKC.sP.EjP, com.bytedance.adsdk.sP.TKC.sP.EjP> f20852aa;
    private com.bytedance.adsdk.sP.Sj.sP.dNu dNu;

    /* renamed from: dx, reason: collision with root package name */
    private com.bytedance.adsdk.sP.Sj.sP.TKC f20853dx;
    private final String sP;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> sU;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> sef;
    private final RectF uA;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<ColorFilter, ColorFilter> uvD;
    private final LongSparseArray<LinearGradient> HiB = new LongSparseArray<>();
    private final LongSparseArray<RadialGradient> vS = new LongSparseArray<>();

    public Dq(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.Jcg jcg, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, com.bytedance.adsdk.sP.TKC.sP.HiB hiB) {
        Path path = new Path();
        this.Jcg = path;
        this.Dq = new com.bytedance.adsdk.sP.Sj.Sj(1);
        this.uA = new RectF();
        this.TEQ = new ArrayList();
        this.Sj = 0.0f;
        this.EjP = sj2;
        this.sP = hiB.Sj();
        this.TKC = hiB.Dq();
        this.TzV = uAVar;
        this.Ym = hiB.sP();
        path.setFillType(hiB.TKC());
        this.RiZ = (int) (jcg.HiB() / 32.0f);
        com.bytedance.adsdk.sP.Sj.sP.Sj<com.bytedance.adsdk.sP.TKC.sP.EjP, com.bytedance.adsdk.sP.TKC.sP.EjP> Sj = hiB.EjP().Sj();
        this.f20852aa = Sj;
        Sj.Sj(this);
        sj2.Sj(Sj);
        com.bytedance.adsdk.sP.Sj.sP.Sj<Integer, Integer> Sj2 = hiB.HiB().Sj();
        this.Fmk = Sj2;
        Sj2.Sj(this);
        sj2.Sj(Sj2);
        com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Sj3 = hiB.vS().Sj();
        this.sef = Sj3;
        Sj3.Sj(this);
        sj2.Sj(Sj3);
        com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Sj4 = hiB.Jcg().Sj();
        this.Zq = Sj4;
        Sj4.Sj(this);
        sj2.Sj(Sj4);
        if (sj2.TEQ() != null) {
            com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj5 = sj2.TEQ().Sj().Sj();
            this.sU = Sj5;
            Sj5.Sj(this);
            sj2.Sj(this.sU);
        }
        if (sj2.Ym() != null) {
            this.f20853dx = new com.bytedance.adsdk.sP.Sj.sP.TKC(this, sj2, sj2.Ym());
        }
    }

    private int EjP() {
        int round = Math.round(this.sef.Dq() * this.RiZ);
        int round2 = Math.round(this.Zq.Dq() * this.RiZ);
        int round3 = Math.round(this.f20852aa.Dq() * this.RiZ);
        int i11 = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i11 = i11 * 31 * round2;
        }
        return round3 != 0 ? i11 * 31 * round3 : i11;
    }

    private int[] Sj(int[] iArr) {
        if (this.dNu == null) {
            return iArr;
        }
        throw null;
    }

    private RadialGradient TKC() {
        long EjP = EjP();
        RadialGradient radialGradient = this.vS.get(EjP);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF Jcg = this.sef.Jcg();
        PointF Jcg2 = this.Zq.Jcg();
        com.bytedance.adsdk.sP.TKC.sP.EjP Jcg3 = this.f20852aa.Jcg();
        int[] Sj = Sj(Jcg3.sP());
        float[] Sj2 = Jcg3.Sj();
        float f11 = Jcg.x;
        float f12 = Jcg.y;
        float hypot = (float) Math.hypot(Jcg2.x - f11, Jcg2.y - f12);
        if (hypot <= 0.0f) {
            hypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f11, f12, hypot, Sj, Sj2, Shader.TileMode.CLAMP);
        this.vS.put(EjP, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient sP() {
        long EjP = EjP();
        LinearGradient linearGradient = this.HiB.get(EjP);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF Jcg = this.sef.Jcg();
        PointF Jcg2 = this.Zq.Jcg();
        com.bytedance.adsdk.sP.TKC.sP.EjP Jcg3 = this.f20852aa.Jcg();
        LinearGradient linearGradient2 = new LinearGradient(Jcg.x, Jcg.y, Jcg2.x, Jcg2.y, Sj(Jcg3.sP()), Jcg3.Sj(), Shader.TileMode.CLAMP);
        this.HiB.put(EjP, linearGradient2);
        return linearGradient2;
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.InterfaceC0203Sj
    public void Sj() {
        this.TzV.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(Canvas canvas, Matrix matrix, int i11) {
        if (this.TKC) {
            return;
        }
        com.bytedance.adsdk.sP.HiB.Sj("GradientFillContent#draw");
        this.Jcg.reset();
        for (int i12 = 0; i12 < this.TEQ.size(); i12++) {
            this.Jcg.addPath(this.TEQ.get(i12).EjP(), matrix);
        }
        this.Jcg.computeBounds(this.uA, false);
        Shader sP = this.Ym == com.bytedance.adsdk.sP.TKC.sP.Jcg.LINEAR ? sP() : TKC();
        sP.setLocalMatrix(matrix);
        this.Dq.setShader(sP);
        com.bytedance.adsdk.sP.Sj.sP.Sj<ColorFilter, ColorFilter> sj2 = this.uvD;
        if (sj2 != null) {
            this.Dq.setColorFilter(sj2.Jcg());
        }
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> sj3 = this.sU;
        if (sj3 != null) {
            float floatValue = sj3.Jcg().floatValue();
            if (floatValue == 0.0f) {
                this.Dq.setMaskFilter(null);
            } else if (floatValue != this.Sj) {
                this.Dq.setMaskFilter(new BlurMaskFilter(floatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.Sj = floatValue;
        }
        com.bytedance.adsdk.sP.Sj.sP.TKC tkc = this.f20853dx;
        if (tkc != null) {
            tkc.Sj(this.Dq);
        }
        this.Dq.setAlpha(com.bytedance.adsdk.sP.vS.HiB.Sj((int) ((((i11 / 255.0f) * this.Fmk.Jcg().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.Jcg, this.Dq);
        com.bytedance.adsdk.sP.HiB.sP("GradientFillContent#draw");
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(RectF rectF, Matrix matrix, boolean z10) {
        this.Jcg.reset();
        for (int i11 = 0; i11 < this.TEQ.size(); i11++) {
            this.Jcg.addPath(this.TEQ.get(i11).EjP(), matrix);
        }
        this.Jcg.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TKC
    public void Sj(List<TKC> list, List<TKC> list2) {
        for (int i11 = 0; i11 < list2.size(); i11++) {
            TKC tkc = list2.get(i11);
            if (tkc instanceof Fmk) {
                this.TEQ.add((Fmk) tkc);
            }
        }
    }
}

package com.bytedance.adsdk.sP.Sj.Sj;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;

/* loaded from: classes2.dex */
public class uA extends Sj {
    private final RectF Dq;
    private final String EjP;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Fmk;
    private final boolean HiB;
    private final LongSparseArray<RadialGradient> Jcg;
    private final int TEQ;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<com.bytedance.adsdk.sP.TKC.sP.EjP, com.bytedance.adsdk.sP.TKC.sP.EjP> Ym;

    /* renamed from: aa, reason: collision with root package name */
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> f20857aa;
    private com.bytedance.adsdk.sP.Sj.sP.dNu sef;
    private final com.bytedance.adsdk.sP.TKC.sP.Jcg uA;
    private final LongSparseArray<LinearGradient> vS;

    public uA(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, com.bytedance.adsdk.sP.TKC.sP.vS vSVar) {
        super(uAVar, sj2, vSVar.Dq().Sj(), vSVar.uA().Sj(), vSVar.aa(), vSVar.EjP(), vSVar.Jcg(), vSVar.TEQ(), vSVar.Ym());
        this.vS = new LongSparseArray<>();
        this.Jcg = new LongSparseArray<>();
        this.Dq = new RectF();
        this.EjP = vSVar.Sj();
        this.uA = vSVar.sP();
        this.HiB = vSVar.Fmk();
        this.TEQ = (int) (uAVar.wE().HiB() / 32.0f);
        com.bytedance.adsdk.sP.Sj.sP.Sj<com.bytedance.adsdk.sP.TKC.sP.EjP, com.bytedance.adsdk.sP.TKC.sP.EjP> Sj = vSVar.TKC().Sj();
        this.Ym = Sj;
        Sj.Sj(this);
        sj2.Sj(Sj);
        com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Sj2 = vSVar.HiB().Sj();
        this.f20857aa = Sj2;
        Sj2.Sj(this);
        sj2.Sj(Sj2);
        com.bytedance.adsdk.sP.Sj.sP.Sj<PointF, PointF> Sj3 = vSVar.vS().Sj();
        this.Fmk = Sj3;
        Sj3.Sj(this);
        sj2.Sj(Sj3);
    }

    private int EjP() {
        int round = Math.round(this.f20857aa.Dq() * this.TEQ);
        int round2 = Math.round(this.Fmk.Dq() * this.TEQ);
        int round3 = Math.round(this.Ym.Dq() * this.TEQ);
        int i11 = round != 0 ? round * 527 : 17;
        if (round2 != 0) {
            i11 = i11 * 31 * round2;
        }
        return round3 != 0 ? i11 * 31 * round3 : i11;
    }

    private int[] Sj(int[] iArr) {
        if (this.sef == null) {
            return iArr;
        }
        throw null;
    }

    private RadialGradient TKC() {
        long EjP = EjP();
        RadialGradient radialGradient = this.Jcg.get(EjP);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF Jcg = this.f20857aa.Jcg();
        PointF Jcg2 = this.Fmk.Jcg();
        com.bytedance.adsdk.sP.TKC.sP.EjP Jcg3 = this.Ym.Jcg();
        int[] Sj = Sj(Jcg3.sP());
        float[] Sj2 = Jcg3.Sj();
        RadialGradient radialGradient2 = new RadialGradient(Jcg.x, Jcg.y, (float) Math.hypot(Jcg2.x - r7, Jcg2.y - r8), Sj, Sj2, Shader.TileMode.CLAMP);
        this.Jcg.put(EjP, radialGradient2);
        return radialGradient2;
    }

    private LinearGradient sP() {
        long EjP = EjP();
        LinearGradient linearGradient = this.vS.get(EjP);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF Jcg = this.f20857aa.Jcg();
        PointF Jcg2 = this.Fmk.Jcg();
        com.bytedance.adsdk.sP.TKC.sP.EjP Jcg3 = this.Ym.Jcg();
        LinearGradient linearGradient2 = new LinearGradient(Jcg.x, Jcg.y, Jcg2.x, Jcg2.y, Sj(Jcg3.sP()), Jcg3.Sj(), Shader.TileMode.CLAMP);
        this.vS.put(EjP, linearGradient2);
        return linearGradient2;
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.Sj, com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(Canvas canvas, Matrix matrix, int i11) {
        if (this.HiB) {
            return;
        }
        Sj(this.Dq, matrix, false);
        Shader sP = this.uA == com.bytedance.adsdk.sP.TKC.sP.Jcg.LINEAR ? sP() : TKC();
        sP.setLocalMatrix(matrix);
        this.sP.setShader(sP);
        super.Sj(canvas, matrix, i11);
    }
}

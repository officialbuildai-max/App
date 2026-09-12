package com.bytedance.adsdk.sP.Sj.Sj;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.bytedance.adsdk.sP.Sj.sP.Sj;
import com.bytedance.adsdk.sP.TKC.sP.RiZ;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class Sj implements HiB, Ym, Sj.InterfaceC0203Sj {
    private final com.bytedance.adsdk.sP.uA Dq;
    private final List<com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float>> Fmk;
    protected final com.bytedance.adsdk.sP.TKC.TKC.Sj Sj;
    private final float[] TEQ;
    float TKC;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> Ym;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<ColorFilter, ColorFilter> Zq;

    /* renamed from: aa, reason: collision with root package name */
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Integer> f20855aa;
    private com.bytedance.adsdk.sP.Sj.sP.TKC dNu;
    final Paint sP;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> sef;
    private com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> uvD;
    private final PathMeasure EjP = new PathMeasure();
    private final Path HiB = new Path();
    private final Path vS = new Path();
    private final RectF Jcg = new RectF();
    private final List<C0202Sj> uA = new ArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.adsdk.sP.Sj.Sj.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0202Sj {
        private final List<Fmk> Sj;
        private final dx sP;

        private C0202Sj(dx dxVar) {
            this.Sj = new ArrayList();
            this.sP = dxVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sj(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, Paint.Cap cap, Paint.Join join, float f11, com.bytedance.adsdk.sP.TKC.Sj.EjP ejP, com.bytedance.adsdk.sP.TKC.Sj.sP sPVar, List<com.bytedance.adsdk.sP.TKC.Sj.sP> list, com.bytedance.adsdk.sP.TKC.Sj.sP sPVar2) {
        com.bytedance.adsdk.sP.Sj.Sj sj3 = new com.bytedance.adsdk.sP.Sj.Sj(1);
        this.sP = sj3;
        this.TKC = 0.0f;
        this.Dq = uAVar;
        this.Sj = sj2;
        sj3.setStyle(Paint.Style.STROKE);
        sj3.setStrokeCap(cap);
        sj3.setStrokeJoin(join);
        sj3.setStrokeMiter(f11);
        this.f20855aa = ejP.Sj();
        this.Ym = sPVar.Sj();
        if (sPVar2 == null) {
            this.sef = null;
        } else {
            this.sef = sPVar2.Sj();
        }
        this.Fmk = new ArrayList(list.size());
        this.TEQ = new float[list.size()];
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.Fmk.add(list.get(i11).Sj());
        }
        sj2.Sj(this.f20855aa);
        sj2.Sj(this.Ym);
        for (int i12 = 0; i12 < this.Fmk.size(); i12++) {
            sj2.Sj(this.Fmk.get(i12));
        }
        com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> sj4 = this.sef;
        if (sj4 != null) {
            sj2.Sj(sj4);
        }
        this.f20855aa.Sj(this);
        this.Ym.Sj(this);
        for (int i13 = 0; i13 < list.size(); i13++) {
            this.Fmk.get(i13).Sj(this);
        }
        com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> sj5 = this.sef;
        if (sj5 != null) {
            sj5.Sj(this);
        }
        if (sj2.TEQ() != null) {
            com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj = sj2.TEQ().Sj().Sj();
            this.uvD = Sj;
            Sj.Sj(this);
            sj2.Sj(this.uvD);
        }
        if (sj2.Ym() != null) {
            this.dNu = new com.bytedance.adsdk.sP.Sj.sP.TKC(this, sj2, sj2.Ym());
        }
    }

    private void Sj(Canvas canvas, C0202Sj c0202Sj, Matrix matrix) {
        float f11;
        float f12;
        com.bytedance.adsdk.sP.HiB.Sj("StrokeContent#applyTrimPath");
        if (c0202Sj.sP == null) {
            com.bytedance.adsdk.sP.HiB.sP("StrokeContent#applyTrimPath");
            return;
        }
        this.HiB.reset();
        for (int size = c0202Sj.Sj.size() - 1; size >= 0; size--) {
            this.HiB.addPath(((Fmk) c0202Sj.Sj.get(size)).EjP(), matrix);
        }
        float floatValue = c0202Sj.sP.TKC().Jcg().floatValue() / 100.0f;
        float floatValue2 = c0202Sj.sP.EjP().Jcg().floatValue() / 100.0f;
        float floatValue3 = c0202Sj.sP.HiB().Jcg().floatValue() / 360.0f;
        if (floatValue < 0.01f && floatValue2 > 0.99f) {
            canvas.drawPath(this.HiB, this.sP);
            com.bytedance.adsdk.sP.HiB.sP("StrokeContent#applyTrimPath");
            return;
        }
        this.EjP.setPath(this.HiB, false);
        float length = this.EjP.getLength();
        while (this.EjP.nextContour()) {
            length += this.EjP.getLength();
        }
        float f13 = floatValue3 * length;
        float f14 = (floatValue * length) + f13;
        float min = Math.min((floatValue2 * length) + f13, (f14 + length) - 1.0f);
        float f15 = 0.0f;
        for (int size2 = c0202Sj.Sj.size() - 1; size2 >= 0; size2--) {
            this.vS.set(((Fmk) c0202Sj.Sj.get(size2)).EjP());
            this.vS.transform(matrix);
            this.EjP.setPath(this.vS, false);
            float length2 = this.EjP.getLength();
            if (min > length) {
                float f16 = min - length;
                if (f16 < f15 + length2 && f15 < f16) {
                    f11 = f14 > length ? (f14 - length) / length2 : 0.0f;
                    f12 = Math.min(f16 / length2, 1.0f);
                    com.bytedance.adsdk.sP.vS.vS.Sj(this.vS, f11, f12, 0.0f);
                    canvas.drawPath(this.vS, this.sP);
                    f15 += length2;
                }
            }
            float f17 = f15 + length2;
            if (f17 >= f14 && f15 <= min) {
                if (f17 > min || f14 >= f15) {
                    f11 = f14 < f15 ? 0.0f : (f14 - f15) / length2;
                    f12 = min > f17 ? 1.0f : (min - f15) / length2;
                    com.bytedance.adsdk.sP.vS.vS.Sj(this.vS, f11, f12, 0.0f);
                    canvas.drawPath(this.vS, this.sP);
                } else {
                    canvas.drawPath(this.vS, this.sP);
                }
            }
            f15 += length2;
        }
        com.bytedance.adsdk.sP.HiB.sP("StrokeContent#applyTrimPath");
    }

    private void Sj(Matrix matrix) {
        com.bytedance.adsdk.sP.HiB.Sj("StrokeContent#applyDashPattern");
        if (this.Fmk.isEmpty()) {
            com.bytedance.adsdk.sP.HiB.sP("StrokeContent#applyDashPattern");
            return;
        }
        float Sj = com.bytedance.adsdk.sP.vS.vS.Sj(matrix);
        for (int i11 = 0; i11 < this.Fmk.size(); i11++) {
            this.TEQ[i11] = this.Fmk.get(i11).Jcg().floatValue();
            if (i11 % 2 == 0) {
                float[] fArr = this.TEQ;
                if (fArr[i11] < 1.0f) {
                    fArr[i11] = 1.0f;
                }
            } else {
                float[] fArr2 = this.TEQ;
                if (fArr2[i11] < 0.1f) {
                    fArr2[i11] = 0.1f;
                }
            }
            float[] fArr3 = this.TEQ;
            fArr3[i11] = fArr3[i11] * Sj;
        }
        com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> sj2 = this.sef;
        this.sP.setPathEffect(new DashPathEffect(this.TEQ, sj2 == null ? 0.0f : Sj * sj2.Jcg().floatValue()));
        com.bytedance.adsdk.sP.HiB.sP("StrokeContent#applyDashPattern");
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.InterfaceC0203Sj
    public void Sj() {
        this.Dq.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(Canvas canvas, Matrix matrix, int i11) {
        com.bytedance.adsdk.sP.HiB.Sj("StrokeContent#draw");
        if (com.bytedance.adsdk.sP.vS.vS.sP(matrix)) {
            com.bytedance.adsdk.sP.HiB.sP("StrokeContent#draw");
            return;
        }
        this.sP.setAlpha(com.bytedance.adsdk.sP.vS.HiB.Sj((int) ((((i11 / 255.0f) * ((com.bytedance.adsdk.sP.Sj.sP.vS) this.f20855aa).uA()) / 100.0f) * 255.0f), 0, 255));
        this.sP.setStrokeWidth(((com.bytedance.adsdk.sP.Sj.sP.EjP) this.Ym).uA() * com.bytedance.adsdk.sP.vS.vS.Sj(matrix));
        if (this.sP.getStrokeWidth() <= 0.0f) {
            com.bytedance.adsdk.sP.HiB.sP("StrokeContent#draw");
            return;
        }
        Sj(matrix);
        com.bytedance.adsdk.sP.Sj.sP.Sj<ColorFilter, ColorFilter> sj2 = this.Zq;
        if (sj2 != null) {
            this.sP.setColorFilter(sj2.Jcg());
        }
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> sj3 = this.uvD;
        if (sj3 != null) {
            float floatValue = sj3.Jcg().floatValue();
            if (floatValue == 0.0f) {
                this.sP.setMaskFilter(null);
            } else if (floatValue != this.TKC) {
                this.sP.setMaskFilter(this.Sj.sP(floatValue));
            }
            this.TKC = floatValue;
        }
        com.bytedance.adsdk.sP.Sj.sP.TKC tkc = this.dNu;
        if (tkc != null) {
            tkc.Sj(this.sP);
        }
        for (int i12 = 0; i12 < this.uA.size(); i12++) {
            C0202Sj c0202Sj = this.uA.get(i12);
            if (c0202Sj.sP != null) {
                Sj(canvas, c0202Sj, matrix);
            } else {
                com.bytedance.adsdk.sP.HiB.Sj("StrokeContent#buildPath");
                this.HiB.reset();
                for (int size = c0202Sj.Sj.size() - 1; size >= 0; size--) {
                    this.HiB.addPath(((Fmk) c0202Sj.Sj.get(size)).EjP(), matrix);
                }
                com.bytedance.adsdk.sP.HiB.sP("StrokeContent#buildPath");
                com.bytedance.adsdk.sP.HiB.Sj("StrokeContent#drawPath");
                canvas.drawPath(this.HiB, this.sP);
                com.bytedance.adsdk.sP.HiB.sP("StrokeContent#drawPath");
            }
        }
        com.bytedance.adsdk.sP.HiB.sP("StrokeContent#draw");
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(RectF rectF, Matrix matrix, boolean z10) {
        com.bytedance.adsdk.sP.HiB.Sj("StrokeContent#getBounds");
        this.HiB.reset();
        for (int i11 = 0; i11 < this.uA.size(); i11++) {
            C0202Sj c0202Sj = this.uA.get(i11);
            for (int i12 = 0; i12 < c0202Sj.Sj.size(); i12++) {
                this.HiB.addPath(((Fmk) c0202Sj.Sj.get(i12)).EjP(), matrix);
            }
        }
        this.HiB.computeBounds(this.Jcg, false);
        float uA = ((com.bytedance.adsdk.sP.Sj.sP.EjP) this.Ym).uA();
        RectF rectF2 = this.Jcg;
        float f11 = uA / 2.0f;
        rectF2.set(rectF2.left - f11, rectF2.top - f11, rectF2.right + f11, rectF2.bottom + f11);
        rectF.set(this.Jcg);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.bytedance.adsdk.sP.HiB.sP("StrokeContent#getBounds");
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TKC
    public void Sj(List<TKC> list, List<TKC> list2) {
        dx dxVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            TKC tkc = list.get(size);
            if (tkc instanceof dx) {
                dx dxVar2 = (dx) tkc;
                if (dxVar2.sP() == RiZ.Sj.INDIVIDUALLY) {
                    dxVar = dxVar2;
                }
            }
        }
        if (dxVar != null) {
            dxVar.Sj(this);
        }
        C0202Sj c0202Sj = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            TKC tkc2 = list2.get(size2);
            if (tkc2 instanceof dx) {
                dx dxVar3 = (dx) tkc2;
                if (dxVar3.sP() == RiZ.Sj.INDIVIDUALLY) {
                    if (c0202Sj != null) {
                        this.uA.add(c0202Sj);
                    }
                    c0202Sj = new C0202Sj(dxVar3);
                    dxVar3.Sj(this);
                }
            }
            if (tkc2 instanceof Fmk) {
                if (c0202Sj == null) {
                    c0202Sj = new C0202Sj(dxVar);
                }
                c0202Sj.Sj.add((Fmk) tkc2);
            }
        }
        if (c0202Sj != null) {
            this.uA.add(c0202Sj);
        }
    }
}

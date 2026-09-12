package com.bytedance.adsdk.sP.Sj.Sj;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.sP.Sj.sP.Sj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public class uvD implements Fmk, HiB, TEQ, Ym, Sj.InterfaceC0203Sj {
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Dq;
    private final com.bytedance.adsdk.sP.TKC.TKC.Sj EjP;
    private final String HiB;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Jcg;
    private EjP TEQ;
    private final com.bytedance.adsdk.sP.uA TKC;
    private final com.bytedance.adsdk.sP.Sj.sP.uvD uA;
    private final boolean vS;
    private final Matrix Sj = new Matrix();
    private final Path sP = new Path();

    public uvD(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, com.bytedance.adsdk.sP.TKC.sP.aa aaVar) {
        this.TKC = uAVar;
        this.EjP = sj2;
        this.HiB = aaVar.Sj();
        this.vS = aaVar.HiB();
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj = aaVar.sP().Sj();
        this.Jcg = Sj;
        sj2.Sj(Sj);
        Sj.Sj(this);
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj2 = aaVar.TKC().Sj();
        this.Dq = Sj2;
        sj2.Sj(Sj2);
        Sj2.Sj(this);
        com.bytedance.adsdk.sP.Sj.sP.uvD TEQ = aaVar.EjP().TEQ();
        this.uA = TEQ;
        TEQ.Sj(sj2);
        TEQ.Sj(this);
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.Fmk
    public Path EjP() {
        Path EjP = this.TEQ.EjP();
        this.sP.reset();
        float floatValue = this.Jcg.Jcg().floatValue();
        float floatValue2 = this.Dq.Jcg().floatValue();
        for (int i11 = ((int) floatValue) - 1; i11 >= 0; i11--) {
            this.Sj.set(this.uA.sP(i11 + floatValue2));
            this.sP.addPath(EjP, this.Sj);
        }
        return this.sP;
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.InterfaceC0203Sj
    public void Sj() {
        this.TKC.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(Canvas canvas, Matrix matrix, int i11) {
        float floatValue = this.Jcg.Jcg().floatValue();
        float floatValue2 = this.Dq.Jcg().floatValue();
        float floatValue3 = this.uA.sP().Jcg().floatValue() / 100.0f;
        float floatValue4 = this.uA.TKC().Jcg().floatValue() / 100.0f;
        for (int i12 = ((int) floatValue) - 1; i12 >= 0; i12--) {
            this.Sj.set(matrix);
            float f11 = i12;
            this.Sj.preConcat(this.uA.sP(f11 + floatValue2));
            this.TEQ.Sj(canvas, this.Sj, (int) (i11 * com.bytedance.adsdk.sP.vS.HiB.Sj(floatValue3, floatValue4, f11 / floatValue)));
        }
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.HiB
    public void Sj(RectF rectF, Matrix matrix, boolean z10) {
        this.TEQ.Sj(rectF, matrix, z10);
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TKC
    public void Sj(List<TKC> list, List<TKC> list2) {
        this.TEQ.Sj(list, list2);
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TEQ
    public void Sj(ListIterator<TKC> listIterator) {
        if (this.TEQ != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.TEQ = new EjP(this.TKC, this.EjP, "Repeater", this.vS, arrayList, null);
    }
}

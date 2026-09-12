package com.bytedance.adsdk.sP.TKC.sP;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class sef {
    private final List<com.bytedance.adsdk.sP.TKC.Sj> Sj;
    private boolean TKC;
    private PointF sP;

    public sef() {
        this.Sj = new ArrayList();
    }

    public sef(PointF pointF, boolean z10, List<com.bytedance.adsdk.sP.TKC.Sj> list) {
        this.sP = pointF;
        this.TKC = z10;
        this.Sj = new ArrayList(list);
    }

    public PointF Sj() {
        return this.sP;
    }

    public void Sj(float f11, float f12) {
        if (this.sP == null) {
            this.sP = new PointF();
        }
        this.sP.set(f11, f12);
    }

    public void Sj(sef sefVar, sef sefVar2, float f11) {
        if (this.sP == null) {
            this.sP = new PointF();
        }
        this.TKC = sefVar.sP() || sefVar2.sP();
        if (sefVar.TKC().size() != sefVar2.TKC().size()) {
            sefVar.TKC().size();
            sefVar2.TKC().size();
        }
        int min = Math.min(sefVar.TKC().size(), sefVar2.TKC().size());
        if (this.Sj.size() < min) {
            for (int size = this.Sj.size(); size < min; size++) {
                this.Sj.add(new com.bytedance.adsdk.sP.TKC.Sj());
            }
        } else if (this.Sj.size() > min) {
            for (int size2 = this.Sj.size() - 1; size2 >= min; size2--) {
                List<com.bytedance.adsdk.sP.TKC.Sj> list = this.Sj;
                list.remove(list.size() - 1);
            }
        }
        PointF Sj = sefVar.Sj();
        PointF Sj2 = sefVar2.Sj();
        Sj(com.bytedance.adsdk.sP.vS.HiB.Sj(Sj.x, Sj2.x, f11), com.bytedance.adsdk.sP.vS.HiB.Sj(Sj.y, Sj2.y, f11));
        for (int size3 = this.Sj.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.sP.TKC.Sj sj2 = sefVar.TKC().get(size3);
            com.bytedance.adsdk.sP.TKC.Sj sj3 = sefVar2.TKC().get(size3);
            PointF Sj3 = sj2.Sj();
            PointF sP = sj2.sP();
            PointF TKC = sj2.TKC();
            PointF Sj4 = sj3.Sj();
            PointF sP2 = sj3.sP();
            PointF TKC2 = sj3.TKC();
            this.Sj.get(size3).Sj(com.bytedance.adsdk.sP.vS.HiB.Sj(Sj3.x, Sj4.x, f11), com.bytedance.adsdk.sP.vS.HiB.Sj(Sj3.y, Sj4.y, f11));
            this.Sj.get(size3).sP(com.bytedance.adsdk.sP.vS.HiB.Sj(sP.x, sP2.x, f11), com.bytedance.adsdk.sP.vS.HiB.Sj(sP.y, sP2.y, f11));
            this.Sj.get(size3).TKC(com.bytedance.adsdk.sP.vS.HiB.Sj(TKC.x, TKC2.x, f11), com.bytedance.adsdk.sP.vS.HiB.Sj(TKC.y, TKC2.y, f11));
        }
    }

    public void Sj(boolean z10) {
        this.TKC = z10;
    }

    public List<com.bytedance.adsdk.sP.TKC.Sj> TKC() {
        return this.Sj;
    }

    public boolean sP() {
        return this.TKC;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.Sj.size() + "closed=" + this.TKC + '}';
    }
}

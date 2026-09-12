package com.bytedance.adsdk.sP.Sj.Sj;

import android.graphics.Path;
import com.bytedance.adsdk.sP.Sj.sP.Sj;
import com.bytedance.adsdk.sP.TKC.sP.RiZ;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class TzV implements Fmk, Sj.InterfaceC0203Sj {
    private final com.bytedance.adsdk.sP.uA EjP;
    private final com.bytedance.adsdk.sP.Sj.sP.Fmk HiB;
    private final boolean TKC;
    private final String sP;
    private boolean vS;
    private final Path Sj = new Path();
    private final sP Jcg = new sP();

    public TzV(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, com.bytedance.adsdk.sP.TKC.sP.dNu dnu) {
        this.sP = dnu.Sj();
        this.TKC = dnu.TKC();
        this.EjP = uAVar;
        com.bytedance.adsdk.sP.Sj.sP.Fmk Sj = dnu.sP().Sj();
        this.HiB = Sj;
        sj2.Sj(Sj);
        Sj.Sj(this);
    }

    private void sP() {
        this.vS = false;
        this.EjP.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.Fmk
    public Path EjP() {
        if (this.vS) {
            return this.Sj;
        }
        this.Sj.reset();
        if (this.TKC) {
            this.vS = true;
            return this.Sj;
        }
        Path Jcg = this.HiB.Jcg();
        if (Jcg == null) {
            return this.Sj;
        }
        this.Sj.set(Jcg);
        this.Sj.setFillType(Path.FillType.EVEN_ODD);
        this.Jcg.Sj(this.Sj);
        this.vS = true;
        return this.Sj;
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.InterfaceC0203Sj
    public void Sj() {
        sP();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TKC
    public void Sj(List<TKC> list, List<TKC> list2) {
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < list.size(); i11++) {
            TKC tkc = list.get(i11);
            if (tkc instanceof dx) {
                dx dxVar = (dx) tkc;
                if (dxVar.sP() == RiZ.Sj.SIMULTANEOUSLY) {
                    this.Jcg.Sj(dxVar);
                    dxVar.Sj(this);
                }
            }
            if (tkc instanceof RiZ) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((RiZ) tkc);
            }
        }
        this.HiB.Sj((List<RiZ>) arrayList);
    }
}

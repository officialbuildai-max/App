package com.bytedance.adsdk.sP.Sj.Sj;

import com.bytedance.adsdk.sP.Sj.sP.Sj;
import com.bytedance.adsdk.sP.TKC.sP.RiZ;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class dx implements TKC, Sj.InterfaceC0203Sj {
    private final RiZ.Sj EjP;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> HiB;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> Jcg;
    private final String Sj;
    private final List<Sj.InterfaceC0203Sj> TKC = new ArrayList();
    private final boolean sP;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> vS;

    public dx(com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, com.bytedance.adsdk.sP.TKC.sP.RiZ riZ) {
        this.Sj = riZ.Sj();
        this.sP = riZ.vS();
        this.EjP = riZ.sP();
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj = riZ.EjP().Sj();
        this.HiB = Sj;
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj2 = riZ.TKC().Sj();
        this.vS = Sj2;
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj3 = riZ.HiB().Sj();
        this.Jcg = Sj3;
        sj2.Sj(Sj);
        sj2.Sj(Sj2);
        sj2.Sj(Sj3);
        Sj.Sj(this);
        Sj2.Sj(this);
        Sj3.Sj(this);
    }

    public com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> EjP() {
        return this.vS;
    }

    public com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> HiB() {
        return this.Jcg;
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.InterfaceC0203Sj
    public void Sj() {
        for (int i11 = 0; i11 < this.TKC.size(); i11++) {
            this.TKC.get(i11).Sj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Sj(Sj.InterfaceC0203Sj interfaceC0203Sj) {
        this.TKC.add(interfaceC0203Sj);
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TKC
    public void Sj(List<TKC> list, List<TKC> list2) {
    }

    public com.bytedance.adsdk.sP.Sj.sP.Sj<?, Float> TKC() {
        return this.HiB;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RiZ.Sj sP() {
        return this.EjP;
    }

    public boolean vS() {
        return this.sP;
    }
}

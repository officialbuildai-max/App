package com.bytedance.adsdk.sP.Sj.Sj;

import android.graphics.PointF;
import com.bytedance.adsdk.sP.Sj.sP.Sj;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class dNu implements RiZ, Sj.InterfaceC0203Sj {
    private com.bytedance.adsdk.sP.TKC.sP.sef EjP;
    private final com.bytedance.adsdk.sP.uA Sj;
    private final com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> TKC;
    private final String sP;

    public dNu(com.bytedance.adsdk.sP.uA uAVar, com.bytedance.adsdk.sP.TKC.TKC.Sj sj2, com.bytedance.adsdk.sP.TKC.sP.Fmk fmk) {
        this.Sj = uAVar;
        this.sP = fmk.Sj();
        com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> Sj = fmk.sP().Sj();
        this.TKC = Sj;
        sj2.Sj(Sj);
        Sj.Sj(this);
    }

    private static int Sj(int i11, int i12) {
        return i11 - (sP(i11, i12) * i12);
    }

    private static int sP(int i11, int i12) {
        int i13 = i11 / i12;
        return ((i11 ^ i12) >= 0 || i12 * i13 == i11) ? i13 : i13 - 1;
    }

    private com.bytedance.adsdk.sP.TKC.sP.sef sP(com.bytedance.adsdk.sP.TKC.sP.sef sefVar) {
        List<com.bytedance.adsdk.sP.TKC.Sj> TKC = sefVar.TKC();
        boolean sP = sefVar.sP();
        int size = TKC.size() - 1;
        int i11 = 0;
        while (size >= 0) {
            com.bytedance.adsdk.sP.TKC.Sj sj2 = TKC.get(size);
            com.bytedance.adsdk.sP.TKC.Sj sj3 = TKC.get(Sj(size - 1, TKC.size()));
            PointF TKC2 = (size != 0 || sP) ? sj3.TKC() : sefVar.Sj();
            i11 = (((size != 0 || sP) ? sj3.sP() : TKC2).equals(TKC2) && sj2.Sj().equals(TKC2) && !(!sefVar.sP() && size == 0 && size == TKC.size() - 1)) ? i11 + 2 : i11 + 1;
            size--;
        }
        com.bytedance.adsdk.sP.TKC.sP.sef sefVar2 = this.EjP;
        if (sefVar2 == null || sefVar2.TKC().size() != i11) {
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                arrayList.add(new com.bytedance.adsdk.sP.TKC.Sj());
            }
            this.EjP = new com.bytedance.adsdk.sP.TKC.sP.sef(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.EjP.Sj(sP);
        return this.EjP;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x009c, code lost:
    
        if (r7 == (r0.size() - 1)) goto L27;
     */
    @Override // com.bytedance.adsdk.sP.Sj.Sj.RiZ
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.bytedance.adsdk.sP.TKC.sP.sef Sj(com.bytedance.adsdk.sP.TKC.sP.sef r19) {
        /*
            Method dump skipped, instructions count: 406
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.Sj.Sj.dNu.Sj(com.bytedance.adsdk.sP.TKC.sP.sef):com.bytedance.adsdk.sP.TKC.sP.sef");
    }

    @Override // com.bytedance.adsdk.sP.Sj.sP.Sj.InterfaceC0203Sj
    public void Sj() {
        this.Sj.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.sP.Sj.Sj.TKC
    public void Sj(List<TKC> list, List<TKC> list2) {
    }

    public com.bytedance.adsdk.sP.Sj.sP.Sj<Float, Float> sP() {
        return this.TKC;
    }
}

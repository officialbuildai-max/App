package com.bytedance.sdk.component.HiB.HiB;

import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class vS extends Sj {
    private byte[] Sj(com.bytedance.sdk.component.HiB.TKC.TKC tkc, String str) {
        tkc.TzV().TKC(tkc.RiZ());
        Collection<com.bytedance.sdk.component.HiB.TKC> TKC = tkc.TzV().TKC();
        if (TKC == null) {
            return null;
        }
        Iterator<com.bytedance.sdk.component.HiB.TKC> it = TKC.iterator();
        while (it.hasNext()) {
            byte[] Sj = it.next().Sj((com.bytedance.sdk.component.HiB.TKC) str);
            if (Sj != null) {
                return Sj;
            }
        }
        return null;
    }

    private byte[] sP(com.bytedance.sdk.component.HiB.TKC.TKC tkc, String str) {
        com.bytedance.sdk.component.HiB.TKC TKC = tkc.TzV().TKC(tkc.RiZ());
        if (TKC == null) {
            return null;
        }
        return TKC.Sj((com.bytedance.sdk.component.HiB.TKC) str);
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public String Sj() {
        return "disk_cache";
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public void Sj(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        String uA = tkc.uA();
        byte[] Sj = (tkc.sU() || tkc.RiZ().uA()) ? Sj(tkc, uA) : sP(tkc, uA);
        if (Sj == null) {
            tkc.Sj(new Ym());
        } else {
            tkc.Sj(new sP(Sj, null));
            tkc.TzV().sP(tkc.RiZ()).Sj(uA, Sj);
        }
    }
}

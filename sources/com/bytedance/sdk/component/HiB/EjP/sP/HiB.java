package com.bytedance.sdk.component.HiB.EjP.sP;

import com.bytedance.sdk.component.HiB.RiZ;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes2.dex */
public class HiB implements vS {
    @Override // com.bytedance.sdk.component.HiB.EjP.sP.vS
    public String Sj() {
        return "check_duplicate";
    }

    @Override // com.bytedance.sdk.component.HiB.EjP.sP.vS
    public boolean Sj(com.bytedance.sdk.component.HiB.EjP.TKC.TKC tkc, RiZ riZ, com.bytedance.sdk.component.HiB.EjP.TKC.Sj sj2) {
        List<com.bytedance.sdk.component.HiB.EjP.TKC.TKC> list;
        String sU = tkc.sU();
        Map<String, List<com.bytedance.sdk.component.HiB.EjP.TKC.TKC>> Jcg = tkc.dNu().Jcg();
        tkc.aa();
        tkc.Sj();
        synchronized (Jcg) {
            try {
                list = Jcg.get(sU);
                if (list == null) {
                    list = new CopyOnWriteArrayList<>();
                    Jcg.put(sU, list);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (list) {
            list.add(tkc);
            if (list.size() <= 1) {
                return true;
            }
            tkc.aa();
            tkc.Sj();
            return false;
        }
    }
}

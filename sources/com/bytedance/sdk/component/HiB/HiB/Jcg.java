package com.bytedance.sdk.component.HiB.HiB;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class Jcg extends Sj {
    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public String Sj() {
        return "check_duplicate";
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public void Sj(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        List<com.bytedance.sdk.component.HiB.TKC.TKC> list;
        String zR = tkc.zR();
        Map<String, List<com.bytedance.sdk.component.HiB.TKC.TKC>> Dq = tkc.TzV().Dq();
        synchronized (Dq) {
            try {
                list = Dq.get(zR);
                if (list == null) {
                    list = new LinkedList<>();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        synchronized (list) {
            try {
                list.add(tkc);
                Dq.put(zR, list);
                if (list.size() <= 1) {
                    tkc.Sj(new EjP());
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }
}

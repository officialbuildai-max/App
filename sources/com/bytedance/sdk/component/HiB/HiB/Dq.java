package com.bytedance.sdk.component.HiB.HiB;

import com.bytedance.sdk.component.HiB.uvD;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class Dq extends Sj {
    private Throwable Sj;
    private String TKC;
    private int sP;

    public Dq(int i11, String str, Throwable th2) {
        this.sP = i11;
        this.TKC = str;
        this.Sj = th2;
    }

    private void sP(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        uvD Dq = tkc.Dq();
        if (Dq != null) {
            Dq.Sj(this.sP, this.TKC, this.Sj);
        }
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public String Sj() {
        return "failed";
    }

    @Override // com.bytedance.sdk.component.HiB.HiB.uA
    public void Sj(com.bytedance.sdk.component.HiB.TKC.TKC tkc) {
        tkc.Sj(new com.bytedance.sdk.component.HiB.TKC.Sj(this.sP, this.TKC, this.Sj));
        String zR = tkc.zR();
        Map<String, List<com.bytedance.sdk.component.HiB.TKC.TKC>> Dq = tkc.TzV().Dq();
        List<com.bytedance.sdk.component.HiB.TKC.TKC> list = Dq.get(zR);
        if (list == null) {
            sP(tkc);
            return;
        }
        synchronized (list) {
            try {
                Iterator<com.bytedance.sdk.component.HiB.TKC.TKC> it = list.iterator();
                while (it.hasNext()) {
                    sP(it.next());
                }
                list.clear();
                Dq.remove(zR);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}

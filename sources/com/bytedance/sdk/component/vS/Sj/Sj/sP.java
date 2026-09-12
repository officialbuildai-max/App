package com.bytedance.sdk.component.vS.Sj.Sj;

import com.bytedance.sdk.component.vS.Sj.Dq;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class sP extends Sj {
    private final EjP Sj;
    private final Queue<String> TKC;
    private final TKC sP;

    public sP() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.TKC = concurrentLinkedQueue;
        this.Sj = new vS(concurrentLinkedQueue);
        this.sP = new TKC();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
    
        if (r7 == 2) goto L11;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized java.util.List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj(int r7, int r8, java.util.List<java.lang.String> r9) {
        /*
            Method dump skipped, instructions count: 375
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.vS.Sj.Sj.sP.Sj(int, int, java.util.List):java.util.List");
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public void Sj(int i11, long j11) {
        this.sP.Sj(i11, j11);
        this.Sj.Sj(i11, j11);
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public synchronized void Sj(int i11, List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list) {
        try {
            Iterator<com.bytedance.sdk.component.vS.Sj.EjP.Sj> it = list.iterator();
            while (it.hasNext()) {
                this.TKC.remove(it.next().TKC());
            }
            EjP ejP = this.Sj;
            if (ejP != null) {
                ejP.Sj(i11, list);
            }
            TKC tkc = this.sP;
            if (tkc != null) {
                tkc.Sj(i11, list);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public synchronized void Sj(com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2, int i11) {
        EjP ejP;
        if (i11 != 5) {
            try {
                if (Dq.Jcg().uvD().Sj(Dq.Jcg().vS()) && (ejP = this.Sj) != null && sj2 != null) {
                    ejP.Sj(sj2, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        TKC tkc = this.sP;
        if (tkc != null && sj2 != null) {
            tkc.Sj(sj2, i11);
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public synchronized boolean Sj(int i11, boolean z10) {
        if (this.Sj.Sj(i11, z10)) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.fF(), 1);
            return true;
        }
        if ((i11 != 1 && i11 != 2) || !this.sP.Sj(i11, z10)) {
            return false;
        }
        com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.JcM(), 1);
        return true;
    }
}

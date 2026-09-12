package com.bytedance.sdk.component.vS.Sj.Sj;

import com.bytedance.sdk.component.vS.Sj.Dq;
import com.bytedance.sdk.component.vS.Sj.Sj.sP.Jcg;
import java.util.List;
import java.util.Queue;

/* loaded from: classes2.dex */
public class vS implements EjP {
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Dq;
    private com.bytedance.sdk.component.vS.Sj.Sj.sP.sP EjP;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Fmk;
    private Jcg HiB;
    private com.bytedance.sdk.component.vS.Sj.Sj.sP.vS Jcg;
    HiB Sj = Dq.Jcg().EjP();
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj TEQ;
    private com.bytedance.sdk.component.vS.Sj.Sj.sP.Sj TKC;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Ym;

    /* renamed from: aa, reason: collision with root package name */
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj f21002aa;
    private com.bytedance.sdk.component.vS.Sj.Sj.sP.HiB sP;
    private Queue<String> sef;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj uA;
    private com.bytedance.sdk.component.vS.Sj.Sj.sP.TKC vS;

    public vS(Queue<String> queue) {
        this.sef = queue;
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj aa2 = Dq.Jcg().aa();
            this.Dq = aa2;
            this.sP = new com.bytedance.sdk.component.vS.Sj.Sj.sP.HiB(aa2, queue);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB()) {
            if (Dq.Jcg().TEQ() != null) {
                this.TEQ = Dq.Jcg().TEQ();
            } else {
                this.TEQ = Dq.Jcg().Fmk();
            }
            this.EjP = new com.bytedance.sdk.component.vS.Sj.Sj.sP.sP(this.TEQ, queue);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.sP()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Fmk = Dq.Jcg().Fmk();
            this.uA = Fmk;
            this.TKC = new com.bytedance.sdk.component.vS.Sj.Sj.sP.Sj(Fmk, queue);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Fmk2 = Dq.Jcg().Fmk();
            this.Ym = Fmk2;
            this.HiB = new Jcg(Fmk2, queue);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sef = Dq.Jcg().sef();
            this.f21002aa = sef;
            this.vS = new com.bytedance.sdk.component.vS.Sj.Sj.sP.TKC(sef, queue);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.vS()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Zq = Dq.Jcg().Zq();
            this.Fmk = Zq;
            this.Jcg = new com.bytedance.sdk.component.vS.Sj.Sj.sP.vS(Zq, queue);
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj(int i11, int i12, List<String> list) {
        List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj;
        List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj2;
        List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj3;
        List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj4;
        List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj5;
        List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj6;
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj() && this.sP.sP(i11, i12) && (Sj6 = this.sP.Sj(i11, i12)) != null && Sj6.size() != 0) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.TzV(), 1);
            return Sj6;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB() && this.EjP.sP(i11, i12) && (Sj5 = this.EjP.Sj(i11, i12)) != null && Sj5.size() != 0) {
            return Sj5;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.sP() && this.TKC.sP(i11, i12) && (Sj4 = this.TKC.Sj(i11, i12)) != null && Sj4.size() != 0) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.RiZ(), 1);
            return Sj4;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC() && this.HiB.sP(i11, i12) && (Sj3 = this.HiB.Sj(i11, i12)) != null && Sj3.size() != 0) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.sU(), 1);
            return Sj3;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP() && this.vS.sP(i11, i12) && (Sj2 = this.vS.Sj(i11, i12)) != null && Sj2.size() != 0) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.dx(), 1);
            return Sj2;
        }
        if (!com.bytedance.sdk.component.vS.Sj.sP.Sj.vS() || !this.Jcg.sP(i11, i12) || (Sj = this.Jcg.Sj(i11, i12)) == null || Sj.size() == 0) {
            return null;
        }
        return Sj;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public void Sj(int i11, long j11) {
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public void Sj(int i11, List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2 = list.get(0);
        byte HiB = sj2.HiB();
        byte EjP = sj2.EjP();
        if (EjP == 0 && HiB == 1 && com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj()) {
            this.sP.Sj(i11, list);
            return;
        }
        if (EjP == 3 && HiB == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB()) {
            this.EjP.Sj(i11, list);
            return;
        }
        if (EjP == 0 && HiB == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.sP()) {
            this.TKC.Sj(i11, list);
            return;
        }
        if (EjP == 1 && HiB == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC()) {
            this.HiB.Sj(i11, list);
            return;
        }
        if (EjP == 1 && HiB == 3 && com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP()) {
            this.vS.Sj(i11, list);
        } else if (EjP == 2 && HiB == 3 && com.bytedance.sdk.component.vS.Sj.sP.Sj.vS()) {
            this.Jcg.Sj(i11, list);
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public void Sj(com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2, int i11) {
        try {
            byte EjP = sj2.EjP();
            byte HiB = sj2.HiB();
            if (EjP == 0 && HiB == 1 && com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj()) {
                this.sP.Sj(sj2);
                return;
            }
            if (EjP == 3 && HiB == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB()) {
                this.EjP.Sj(sj2);
                return;
            }
            if (EjP == 0 && HiB == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.sP()) {
                this.TKC.Sj(sj2);
                return;
            }
            if (EjP == 1 && HiB == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC()) {
                this.HiB.Sj(sj2);
                return;
            }
            if (EjP == 1 && HiB == 3 && com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP()) {
                this.vS.Sj(sj2);
            } else if (EjP == 2 && HiB == 3 && com.bytedance.sdk.component.vS.Sj.sP.Sj.vS()) {
                this.Jcg.Sj(sj2);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public boolean Sj(int i11, boolean z10) {
        com.bytedance.sdk.component.vS.Sj.Sj.sP.vS vSVar;
        com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj2;
        com.bytedance.sdk.component.vS.Sj.Sj.sP.TKC tkc;
        com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj3;
        Jcg jcg;
        com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj4;
        com.bytedance.sdk.component.vS.Sj.Sj.sP.Sj sj5;
        com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj6;
        com.bytedance.sdk.component.vS.Sj.Sj.sP.sP sPVar;
        com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj7;
        com.bytedance.sdk.component.vS.Sj.Sj.sP.HiB hiB;
        com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sj8;
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj() && (hiB = this.sP) != null && (sj8 = this.Dq) != null && hiB.sP(i11, sj8.Sj())) {
            return true;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB() && (sPVar = this.EjP) != null && (sj7 = this.TEQ) != null && sPVar.sP(i11, sj7.Sj())) {
            return true;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.sP() && (sj5 = this.TKC) != null && (sj6 = this.uA) != null && sj5.sP(i11, sj6.Sj())) {
            return true;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC() && (jcg = this.HiB) != null && (sj4 = this.Ym) != null && jcg.sP(i11, sj4.Sj())) {
            return true;
        }
        if (!com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP() || (tkc = this.vS) == null || (sj3 = this.f21002aa) == null || !tkc.sP(i11, sj3.Sj())) {
            return com.bytedance.sdk.component.vS.Sj.sP.Sj.vS() && (vSVar = this.Jcg) != null && (sj2 = this.Fmk) != null && vSVar.sP(i11, sj2.Sj());
        }
        return true;
    }
}

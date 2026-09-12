package com.bytedance.sdk.component.vS.Sj.Sj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.vS.Sj.Dq;
import com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.Jcg;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TKC implements EjP {
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Dq;
    private Jcg EjP;
    private com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.vS HiB;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Jcg;
    private com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.EjP Sj;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj TEQ;
    private com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.sP TKC;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Ym;

    /* renamed from: aa, reason: collision with root package name */
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj f21001aa;
    private com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.Sj sP;
    private com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj uA;
    private com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.HiB vS;

    public TKC() {
        Context vS = Dq.Jcg().vS();
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj aa2 = Dq.Jcg().aa();
            this.Jcg = aa2;
            this.Sj = new com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.EjP(vS, aa2);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB()) {
            if (Dq.Jcg().TEQ() != null) {
                this.uA = Dq.Jcg().TEQ();
            } else {
                this.uA = Dq.Jcg().Fmk();
            }
            this.TKC = new com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.sP(vS, this.uA);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.sP()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Fmk = Dq.Jcg().Fmk();
            this.Dq = Fmk;
            this.sP = new com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.Sj(vS, Fmk);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Fmk2 = Dq.Jcg().Fmk();
            this.TEQ = Fmk2;
            this.EjP = new Jcg(vS, Fmk2);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj sef = Dq.Jcg().sef();
            this.Ym = sef;
            this.HiB = new com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.vS(vS, sef);
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.vS()) {
            com.bytedance.sdk.component.vS.Sj.EjP.sP.Sj Zq = Dq.Jcg().Zq();
            this.f21001aa = Zq;
            this.vS = new com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.HiB(vS, Zq);
        }
    }

    private boolean Sj(List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list, List<String> list2) {
        if (list != null && !list.isEmpty() && list2 != null && !list2.isEmpty()) {
            try {
                Iterator<com.bytedance.sdk.component.vS.Sj.EjP.Sj> it = list.iterator();
                while (it.hasNext()) {
                    com.bytedance.sdk.component.vS.Sj.EjP.Sj next = it.next();
                    if (next != null) {
                        String TKC = next.TKC();
                        if (!TextUtils.isEmpty(TKC) && list2.contains(TKC)) {
                            it.remove();
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.getMessage();
            }
        }
        return (list == null || list.isEmpty()) ? false : true;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj(int i11, int i12, List<String> list) {
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj()) {
            List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj = this.Sj.Sj("_id");
            if (Sj(Sj, list)) {
                Sj.size();
                com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.ib(), 1);
                return Sj;
            }
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB()) {
            List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj2 = this.TKC.Sj("_id");
            if (Sj(Sj2, list)) {
                Sj2.size();
                return Sj2;
            }
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.sP()) {
            List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj3 = this.sP.Sj("_id");
            if (Sj(Sj3, list)) {
                Sj3.size();
                com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.kF(), 1);
                return Sj3;
            }
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC()) {
            List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> sP = this.EjP.sP("_id");
            if (Sj(sP, list)) {
                sP.size();
                com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.uP(), 1);
                return sP;
            }
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP()) {
            List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> sP2 = this.HiB.sP("_id");
            if (Sj(sP2, list)) {
                sP2.size();
                com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.wE(), 1);
                return sP2;
            }
        }
        if (!com.bytedance.sdk.component.vS.Sj.sP.Sj.vS()) {
            return null;
        }
        List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> sP3 = this.vS.sP("_id");
        if (!Sj(sP3, list)) {
            return null;
        }
        sP3.size();
        return sP3;
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public void Sj(int i11, long j11) {
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.EjP ejP = this.Sj;
        if (ejP != null) {
            ejP.Sj(i11, j11);
        }
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.sP sPVar = this.TKC;
        if (sPVar != null) {
            sPVar.Sj(i11, j11);
        }
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.Sj sj2 = this.sP;
        if (sj2 != null) {
            sj2.Sj(i11, j11);
        }
        Jcg jcg = this.EjP;
        if (jcg != null) {
            jcg.Sj(i11, j11);
        }
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.vS vSVar = this.HiB;
        if (vSVar != null) {
            vSVar.Sj(i11, j11);
        }
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.HiB hiB = this.vS;
        if (hiB != null) {
            hiB.Sj(i11, j11);
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public void Sj(int i11, List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> list) {
        if (list == null || list.size() == 0 || list.get(0) == null) {
            return;
        }
        com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2 = list.get(0);
        if (i11 == 200 || i11 == -1) {
            com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj sj3 = com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP;
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(sj3.IOh(), list.size());
            if (i11 != 200) {
                com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(sj3.EZ(), list.size());
            }
            if (sj2.EjP() == 0 && sj2.HiB() == 1) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj()) {
                    this.Sj.sP(list);
                    return;
                }
                return;
            }
            if (sj2.EjP() == 3 && sj2.HiB() == 2) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB()) {
                    this.TKC.sP(list);
                    return;
                }
                return;
            }
            if (sj2.EjP() == 0 && sj2.HiB() == 2) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.sP()) {
                    this.sP.sP(list);
                    return;
                }
                return;
            }
            if (sj2.EjP() == 1 && sj2.HiB() == 2) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC()) {
                    this.EjP.sP(list);
                }
            } else if (sj2.EjP() == 1 && sj2.HiB() == 3) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP()) {
                    this.HiB.sP(list);
                }
            } else if (sj2.EjP() == 2 && sj2.HiB() == 3 && com.bytedance.sdk.component.vS.Sj.sP.Sj.vS()) {
                this.vS.sP(list);
            }
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public void Sj(com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2, int i11) {
        if (sj2 == null) {
            return;
        }
        try {
            sj2.sP(System.currentTimeMillis());
            if (sj2.EjP() == 0 && sj2.HiB() == 1) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj()) {
                    this.Sj.Sj(sj2);
                    return;
                }
                return;
            }
            if (sj2.EjP() == 3 && sj2.HiB() == 2) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB()) {
                    this.TKC.Sj(sj2);
                    return;
                }
                return;
            }
            if (sj2.EjP() == 0 && sj2.HiB() == 2) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.sP()) {
                    this.sP.Sj(sj2);
                    return;
                }
                return;
            }
            if (sj2.EjP() == 1 && sj2.HiB() == 2) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC()) {
                    this.EjP.Sj(sj2);
                }
            } else if (sj2.EjP() == 1 && sj2.HiB() == 3) {
                if (com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP()) {
                    this.HiB.Sj(sj2);
                }
            } else if (sj2.EjP() == 2 && sj2.HiB() == 3 && com.bytedance.sdk.component.vS.Sj.sP.Sj.vS()) {
                this.vS.Sj(sj2);
            }
        } catch (Throwable unused) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.WMZ(), 1);
        }
    }

    @Override // com.bytedance.sdk.component.vS.Sj.Sj.EjP
    public boolean Sj(int i11, boolean z10) {
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.HiB hiB;
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.vS vSVar;
        Jcg jcg;
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.Sj sj2;
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.sP sPVar;
        com.bytedance.sdk.component.vS.Sj.Sj.Sj.Sj.EjP ejP;
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj() && (ejP = this.Sj) != null && ejP.Sj(i11)) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.sef(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB() && (sPVar = this.TKC) != null && sPVar.Sj(i11)) {
            return true;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.sP() && (sj2 = this.sP) != null && sj2.Sj(i11)) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.Zq(), 1);
            return true;
        }
        if (com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC() && (jcg = this.EjP) != null && jcg.Sj(i11)) {
            com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.uvD(), 1);
            return true;
        }
        if (!com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP() || (vSVar = this.HiB) == null || !vSVar.Sj(i11)) {
            return com.bytedance.sdk.component.vS.Sj.sP.Sj.vS() && (hiB = this.vS) != null && hiB.Sj(i11);
        }
        com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.dNu(), 1);
        return true;
    }

    public List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> sP(com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2, int i11) {
        if (sj2.EjP() == 0 && sj2.HiB() == 1 && com.bytedance.sdk.component.vS.Sj.sP.Sj.Sj()) {
            if (this.Jcg.sP() <= i11) {
                return null;
            }
            List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj = this.Sj.Sj(this.Jcg.sP() - i11, "_id");
            if (Sj != null && Sj.size() != 0) {
                com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.ley(), 1);
            }
            return Sj;
        }
        if (sj2.EjP() == 3 && sj2.HiB() == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.HiB()) {
            if (this.uA.sP() > i11) {
                return this.TKC.Sj(this.uA.sP() - i11, "_id");
            }
        } else if (sj2.EjP() == 0 && sj2.HiB() == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.sP()) {
            if (this.Dq.sP() > i11) {
                List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj2 = this.sP.Sj(this.Dq.sP() - i11, "_id");
                if (Sj2 != null && Sj2.size() != 0) {
                    com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.LqL(), 1);
                }
                return Sj2;
            }
        } else if (sj2.EjP() == 1 && sj2.HiB() == 2 && com.bytedance.sdk.component.vS.Sj.sP.Sj.TKC()) {
            if (this.TEQ.sP() > i11) {
                List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj3 = this.EjP.Sj(this.TEQ.sP() - i11, "_id");
                if (Sj3 != null && Sj3.size() != 0) {
                    com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.Yf(), 1);
                }
                return Sj3;
            }
        } else if (sj2.EjP() == 1 && sj2.HiB() == 3 && com.bytedance.sdk.component.vS.Sj.sP.Sj.EjP()) {
            if (this.Ym.sP() > i11) {
                List<com.bytedance.sdk.component.vS.Sj.EjP.Sj> Sj4 = this.HiB.Sj(this.Ym.sP() - i11, "_id");
                if (Sj4 != null && Sj4.size() != 0) {
                    com.bytedance.sdk.component.vS.Sj.TKC.sP.Sj(com.bytedance.sdk.component.vS.Sj.sP.EjP.EjP.LD(), 1);
                }
                return Sj4;
            }
        } else if (sj2.EjP() == 2 && sj2.HiB() == 3 && com.bytedance.sdk.component.vS.Sj.sP.Sj.vS() && this.f21001aa.sP() > i11) {
            return this.vS.Sj(this.f21001aa.sP() - i11, "_id");
        }
        return null;
    }
}

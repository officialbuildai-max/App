package com.bytedance.sdk.component.HiB.EjP.TKC;

import com.bytedance.sdk.component.HiB.RiZ;
import com.bytedance.sdk.component.HiB.Ym;
import com.bytedance.sdk.component.HiB.uvD;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class Sj<T> {
    private TKC Sj;
    private RiZ sP;

    public Sj(TKC tkc, RiZ riZ) {
        this.Sj = tkc;
        this.sP = riZ;
    }

    public void Sj(int i11, String str, Throwable th2) {
        try {
            RiZ riZ = this.sP;
            if (riZ != null) {
                riZ.Sj("failed", this.Sj);
            }
            String sU = this.Sj.sU();
            Map<String, List<TKC>> Jcg = this.Sj.dNu().Jcg();
            List<TKC> list = Jcg.get(sU);
            if (list == null) {
                uvD Dq = this.Sj.Dq();
                if (Dq != null) {
                    Dq.Sj(i11, str, th2);
                }
            } else {
                synchronized (list) {
                    try {
                        Iterator<TKC> it = list.iterator();
                        while (it.hasNext()) {
                            uvD Dq2 = it.next().Dq();
                            if (Dq2 != null) {
                                Dq2.toString();
                                Dq2.Sj(i11, str, th2);
                            }
                        }
                        list.clear();
                        Jcg.remove(sU);
                    } finally {
                    }
                }
            }
            RiZ riZ2 = this.sP;
            if (riZ2 != null) {
                riZ2.sP("failed", this.Sj);
            }
        } catch (Throwable unused) {
        }
    }

    public void Sj(Ym<T> ym2) {
        try {
            RiZ riZ = this.sP;
            if (riZ != null) {
                riZ.Sj(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, this.Sj);
            }
            String sU = this.Sj.sU();
            Map<String, List<TKC>> Jcg = this.Sj.dNu().Jcg();
            List<TKC> list = Jcg.get(sU);
            if (list == null) {
                uvD Dq = this.Sj.Dq();
                if (Dq != null) {
                    Dq.toString();
                    this.Sj.TEQ();
                    Dq.Sj(ym2);
                }
            } else {
                synchronized (list) {
                    try {
                        list.size();
                        for (TKC tkc : list) {
                            uvD Dq2 = tkc.Dq();
                            if (Dq2 != null) {
                                Dq2.toString();
                                tkc.TEQ();
                                Dq2.Sj(ym2);
                            }
                        }
                        list.clear();
                        Jcg.remove(sU);
                    } finally {
                    }
                }
            }
            RiZ riZ2 = this.sP;
            if (riZ2 != null) {
                riZ2.sP(NativeComponentConstants.KEY_COMPONENT_RESULT_SUCCESS, this.Sj);
            }
        } catch (Throwable unused) {
        }
    }
}

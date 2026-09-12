package com.bytedance.sdk.component.HiB.EjP.TKC;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.HiB.Fmk;
import com.bytedance.sdk.component.HiB.TzV;
import com.bytedance.sdk.component.HiB.dNu;
import com.bytedance.sdk.component.HiB.dx;
import com.bytedance.sdk.component.HiB.sU;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: classes2.dex */
public class vS {
    private ExecutorService Dq;
    private volatile TzV EjP;
    private ExecutorService Jcg;
    private volatile dNu TKC;
    private final Fmk sP;
    private com.bytedance.sdk.component.HiB.EjP vS;
    private Map<String, List<TKC>> Sj = new ConcurrentHashMap();
    private Map<String, com.bytedance.sdk.component.HiB.TKC> HiB = new ConcurrentHashMap();

    public vS(Context context, Fmk fmk) {
        this.sP = (Fmk) Jcg.Sj(fmk);
        com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.Sj(context, fmk.Dq());
    }

    private com.bytedance.sdk.component.HiB.EjP Dq() {
        com.bytedance.sdk.component.HiB.EjP EjP = this.sP.EjP();
        return EjP == null ? new com.bytedance.sdk.component.HiB.sP.Sj() : EjP;
    }

    private com.bytedance.sdk.component.HiB.TKC EjP(com.bytedance.sdk.component.HiB.sP sPVar) {
        com.bytedance.sdk.component.HiB.TKC Jcg = this.sP.Jcg();
        return Jcg != null ? Jcg : new com.bytedance.sdk.component.HiB.EjP.TKC.Sj.Sj.sP(sPVar.Dq(), sPVar.Sj());
    }

    private ExecutorService uA() {
        ExecutorService sP = this.sP.sP();
        return sP != null ? sP : com.bytedance.sdk.component.HiB.EjP.Sj.sP.Sj();
    }

    public ExecutorService EjP() {
        ExecutorService Sj;
        sU TKC = this.sP.TKC();
        if (TKC != null && (Sj = TKC.Sj()) != null) {
            return Sj;
        }
        if (this.Jcg == null) {
            this.Jcg = uA();
        }
        return this.Jcg;
    }

    public dx HiB() {
        Fmk fmk = this.sP;
        if (fmk != null) {
            return fmk.uA();
        }
        return null;
    }

    public Map<String, List<TKC>> Jcg() {
        return this.Sj;
    }

    public com.bytedance.sdk.component.HiB.EjP.TKC.sP.Sj Sj(TKC tkc) {
        ImageView.ScaleType EjP = tkc.EjP();
        if (EjP == null) {
            EjP = com.bytedance.sdk.component.HiB.EjP.TKC.sP.Sj.Sj;
        }
        ImageView.ScaleType scaleType = EjP;
        Bitmap.Config Ym = tkc.Ym();
        if (Ym == null) {
            Ym = com.bytedance.sdk.component.HiB.EjP.TKC.sP.Sj.sP;
        }
        return new com.bytedance.sdk.component.HiB.EjP.TKC.sP.Sj(tkc.sP(), tkc.TKC(), scaleType, Ym, tkc.vS(), tkc.Jcg());
    }

    public com.bytedance.sdk.component.HiB.TKC Sj(String str) {
        return TKC(com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.Sj(new File(str)));
    }

    public TzV Sj() {
        return this.EjP;
    }

    public dNu Sj(com.bytedance.sdk.component.HiB.sP sPVar) {
        if (sPVar == null) {
            sPVar = com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.TEQ();
        }
        if (this.TKC == null) {
            synchronized (com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.TKC.class) {
                try {
                    if (this.TKC == null) {
                        this.TKC = new com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.TKC(new com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.Sj(sPVar.sP(), sPVar.TKC()));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.TKC;
    }

    public com.bytedance.sdk.component.HiB.EjP TKC() {
        if (this.vS == null) {
            this.vS = Dq();
        }
        return this.vS;
    }

    public com.bytedance.sdk.component.HiB.TKC TKC(com.bytedance.sdk.component.HiB.sP sPVar) {
        if (sPVar == null) {
            sPVar = com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.TEQ();
        }
        String file = sPVar.Dq().toString();
        com.bytedance.sdk.component.HiB.TKC tkc = this.HiB.get(file);
        if (tkc != null) {
            return tkc;
        }
        com.bytedance.sdk.component.HiB.TKC EjP = EjP(sPVar);
        this.HiB.put(file, EjP);
        return EjP;
    }

    public TzV sP(com.bytedance.sdk.component.HiB.sP sPVar) {
        if (sPVar == null) {
            sPVar = com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.TEQ();
        }
        if (this.EjP == null) {
            synchronized (com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.sP.class) {
                try {
                    if (this.EjP == null) {
                        this.EjP = new com.bytedance.sdk.component.HiB.EjP.TKC.Sj.sP.sP(sPVar.sP(), sPVar.EjP());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.EjP;
    }

    public Collection<com.bytedance.sdk.component.HiB.TKC> sP() {
        return this.HiB.values();
    }

    public ExecutorService vS() {
        ExecutorService sP;
        sU TKC = this.sP.TKC();
        if (TKC != null && (sP = TKC.sP()) != null) {
            return sP;
        }
        if (this.Dq == null) {
            this.Dq = com.bytedance.sdk.component.HiB.EjP.Sj.sP.Sj();
        }
        return this.Dq;
    }
}

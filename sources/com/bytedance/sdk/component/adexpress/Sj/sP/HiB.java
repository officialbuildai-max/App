package com.bytedance.sdk.component.adexpress.Sj.sP;

import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.Sj.TKC.Sj;
import com.bytedance.sdk.component.utils.dx;
import java.io.File;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class HiB extends TKC {
    private static File Sj;
    private static volatile HiB sP;
    private AtomicBoolean TKC = new AtomicBoolean(true);
    private AtomicBoolean EjP = new AtomicBoolean(false);
    private boolean HiB = false;
    private AtomicBoolean vS = new AtomicBoolean(false);
    private AtomicInteger Jcg = new AtomicInteger(0);
    private AtomicLong Dq = new AtomicLong();

    private HiB() {
        TEQ();
    }

    public static File Dq() {
        if (Sj == null) {
            try {
                File file = new File(new File(EjP.Sj(), "tt_tmpl_pkg"), "template");
                file.mkdirs();
                Sj = file;
            } catch (Throwable unused) {
            }
        }
        return Sj;
    }

    private void TEQ() {
        com.bytedance.sdk.component.adexpress.EjP.EjP.sP(new com.bytedance.sdk.component.Dq.Dq("init") { // from class: com.bytedance.sdk.component.adexpress.Sj.sP.HiB.1
            @Override // java.lang.Runnable
            public void run() {
                Dq.Sj();
                HiB.this.TKC.set(false);
                HiB.this.EjP();
                HiB.this.Jcg();
                if (com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC() == null || !dx.Sj(com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().sP()) || com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC() == null) {
                    return;
                }
                com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().EjP();
            }
        }, 10);
    }

    private void Ym() {
        if (this.Jcg.getAndSet(0) <= 0 || System.currentTimeMillis() - this.Dq.get() <= 600000) {
            return;
        }
        Jcg();
    }

    public static HiB sP() {
        if (sP == null) {
            synchronized (HiB.class) {
                try {
                    if (sP == null) {
                        sP = new HiB();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return sP;
    }

    public void EjP() {
        com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sP2 = Dq.sP();
        if (sP2 == null || !sP2.Dq()) {
            return;
        }
        boolean Sj2 = Sj(sP2);
        if (!Sj2) {
            Dq.EjP();
        }
        this.HiB = Sj2;
    }

    public boolean HiB() {
        return this.HiB;
    }

    public void Jcg() {
        Sj(false);
    }

    @Override // com.bytedance.sdk.component.adexpress.Sj.sP.TKC
    public File Sj() {
        return Dq();
    }

    public void Sj(boolean z10) {
        List<Sj.C0225Sj> list;
        boolean z11;
        if (this.TKC.get()) {
            return;
        }
        try {
            if (this.EjP.get()) {
                if (z10) {
                    this.Jcg.getAndIncrement();
                    return;
                }
                return;
            }
            boolean z12 = true;
            this.EjP.set(true);
            com.bytedance.sdk.component.adexpress.Sj.TKC.Sj HiB = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().HiB();
            com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sP2 = Dq.sP();
            if (HiB != null && HiB.Dq()) {
                if (!Dq.sP(HiB)) {
                    this.EjP.set(false);
                    this.Dq.set(System.currentTimeMillis());
                    return;
                }
                if (com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC() != null) {
                    com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC().TKC().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.Sj.sP.HiB.2
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.component.adexpress.HiB.HiB.Sj().sP();
                        }
                    });
                }
                Dq.Sj(HiB);
                boolean Sj2 = (HiB.HiB() == null || TextUtils.isEmpty(HiB.HiB().Sj())) ? false : Sj(HiB.HiB().Sj());
                if (HiB.Sj().size() != 0) {
                    list = Sj(HiB, sP2);
                    z11 = list != null;
                } else {
                    list = null;
                    z11 = Sj2;
                }
                if (!Sj2) {
                    List<Sj.C0225Sj> sP3 = sP(HiB, sP2);
                    if (list == null || sP3 == null) {
                        list = sP3;
                    } else {
                        list.addAll(sP3);
                    }
                    if (sP3 == null) {
                        z12 = false;
                    }
                    if (sP3 == null) {
                        this.EjP.set(false);
                    }
                    z11 = z12;
                }
                if (z11 && Sj(HiB)) {
                    Dq.Sj(HiB);
                    Dq.TKC();
                    sP(list);
                }
                EjP();
                this.EjP.set(false);
                this.Dq.set(System.currentTimeMillis());
                Ym();
                return;
            }
            this.EjP.set(false);
            Sj(109);
        } catch (Throwable unused) {
        }
    }

    public boolean Sj(com.bytedance.sdk.component.adexpress.Sj.TKC.Sj sj2) {
        if (sj2 == null) {
            return false;
        }
        return Sj(sj2.Sj()) || Sj(sj2.HiB()) || Sj(sj2.vS());
    }

    public void TKC() {
        TEQ();
    }

    public void sP(boolean z10) {
        this.vS.set(z10);
    }

    public void uA() {
        this.vS.set(true);
        this.HiB = false;
        this.EjP.set(false);
    }

    public com.bytedance.sdk.component.adexpress.Sj.TKC.Sj vS() {
        return Dq.sP();
    }
}

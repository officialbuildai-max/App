package com.bytedance.sdk.component.vS.Sj;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.sdk.component.utils.dx;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class EjP {
    public static final EjP Sj = new EjP();

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(int i11) {
        if (i11 == 0) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.Sj.Sj();
        } else if (i11 == 1) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.sP.Sj();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2, int i11) {
        if (i11 == 0) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.Sj.Sj(sj2);
        } else if (i11 == 1) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.sP.Sj(sj2);
        }
    }

    private void Sj(Sj sj2) {
        Executor HiB;
        if (Looper.myLooper() != Looper.getMainLooper() && com.bytedance.sdk.component.vS.Sj.TKC.Sj.sP()) {
            com.bytedance.sdk.component.vS.Sj.TKC.Sj.Sj();
            return;
        }
        HiB EjP = sj2.EjP();
        if (EjP == null || !com.bytedance.sdk.component.vS.Sj.TKC.Sj.sP() || (HiB = EjP.HiB()) == null) {
            return;
        }
        HiB.execute(new Runnable() { // from class: com.bytedance.sdk.component.vS.Sj.EjP.1
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.component.vS.Sj.TKC.Sj.Sj();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(String str, int i11, boolean z10) {
        if (i11 == 0) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.Sj.Sj(str);
        } else if (i11 == 1) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.sP.Sj(str, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sj(String str, List<String> list, boolean z10, int i11, int i12, String str2) {
        if (i11 == 0) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.Sj.Sj(str, list, z10);
        } else if (i11 == 1) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.sP.Sj(str, list, z10, i12, str2);
        }
    }

    private boolean Sj(Context context, HiB hiB) {
        if (context == null || hiB == null) {
            return false;
        }
        if (hiB.vS() == 2) {
            return true;
        }
        if (hiB.vS() == 1) {
            return hiB.sef();
        }
        try {
            return dx.Sj(context);
        } catch (Throwable th2) {
            th2.getMessage();
            return true;
        }
    }

    private boolean TKC() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sP(int i11) {
        if (i11 == 0) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.Sj.sP();
        } else if (i11 == 1) {
            com.bytedance.sdk.component.vS.Sj.sP.sP.sP.sP();
        }
    }

    private void sP(final com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2) {
        final HiB uvD = Dq.Jcg().uvD();
        if (sj2 == null || uvD == null || Dq.Jcg().vS() == null || uvD.EjP() == null) {
            return;
        }
        if (!Dq.Jcg().sP()) {
            Dq.Jcg().Sj(sj2);
            return;
        }
        if (Sj(Dq.Jcg().vS(), uvD)) {
            Dq.Jcg().Sj(sj2);
            return;
        }
        TKC();
        if (TKC()) {
            uvD.EjP().execute(new com.bytedance.sdk.component.vS.Sj.HiB.HiB("dispatchEvent") { // from class: com.bytedance.sdk.component.vS.Sj.EjP.4
                @Override // java.lang.Runnable
                public void run() {
                    EjP.this.Sj(sj2, uvD.vS());
                }
            });
        } else {
            Sj(sj2, uvD.vS());
        }
    }

    private void sP(Sj sj2, Context context) {
        TKC.Sj(context, "context == null");
        TKC.Sj(sj2, "AdLogConfig == null");
        TKC.Sj(sj2.EjP(), "AdLogDepend ==null");
    }

    public void Sj() {
        final HiB uvD = Dq.Jcg().uvD();
        if (uvD == null || Dq.Jcg().vS() == null || uvD.EjP() == null) {
            return;
        }
        if (!Dq.Jcg().sP()) {
            Dq.Jcg().uA();
            return;
        }
        if (Sj(Dq.Jcg().vS(), uvD)) {
            Dq.Jcg().uA();
        } else if (TKC()) {
            uvD.EjP().execute(new com.bytedance.sdk.component.vS.Sj.HiB.HiB("start") { // from class: com.bytedance.sdk.component.vS.Sj.EjP.2
                @Override // java.lang.Runnable
                public void run() {
                    EjP.this.Sj(uvD.vS());
                }
            });
        } else {
            Sj(uvD.vS());
        }
    }

    public void Sj(com.bytedance.sdk.component.vS.Sj.EjP.Sj sj2) {
        sP(sj2);
    }

    public void Sj(Sj sj2, Context context) {
        sP(sj2, context);
        Dq.Jcg().Sj(context);
        Dq.Jcg().Sj(sj2.TEQ());
        Dq.Jcg().sP(sj2.Jcg());
        Dq.Jcg().TKC(sj2.Dq());
        Dq.Jcg().Sj(sj2.sP());
        Dq.Jcg().EjP(sj2.uA());
        Dq.Jcg().HiB(sj2.vS());
        Dq.Jcg().Sj(sj2.Sj() == null ? com.bytedance.sdk.component.vS.Sj.Sj.Sj.HiB.Sj : sj2.Sj());
        Dq.Jcg().sP(sj2.Ym());
        Dq.Jcg().Sj(sj2.EjP());
        Dq.Jcg().Sj(sj2.TKC());
        Dq.Jcg().Sj(sj2.HiB());
        com.bytedance.sdk.component.vS.Sj.sP.TKC.TKC.Sj(sj2.Fmk());
        com.bytedance.sdk.component.vS.Sj.sP.TKC.TKC.sP(sj2.aa());
        Sj(sj2);
    }

    public void Sj(final String str, final List<String> list, final boolean z10, Map<String, String> map, final int i11, final String str2) {
        final HiB uvD = Dq.Jcg().uvD();
        if (uvD == null || Dq.Jcg().vS() == null || uvD.EjP() == null) {
            return;
        }
        if (uvD.Dq()) {
            if (uvD.vS() == 1) {
                if (list == null || list.isEmpty()) {
                    return;
                }
            } else if (uvD.vS() == 0 && (TextUtils.isEmpty(str) || list == null || list.isEmpty())) {
                return;
            }
            if (Dq.Jcg().sP() && !Sj(Dq.Jcg().vS(), uvD)) {
                if (TKC()) {
                    uvD.EjP().execute(new com.bytedance.sdk.component.vS.Sj.HiB.HiB("trackFailed") { // from class: com.bytedance.sdk.component.vS.Sj.EjP.5
                        @Override // java.lang.Runnable
                        public void run() {
                            EjP.this.Sj(str, (List<String>) list, z10, uvD.vS(), i11, str2);
                        }
                    });
                    return;
                } else {
                    Sj(str, list, z10, uvD.vS(), i11, str2);
                    return;
                }
            }
            Dq.Jcg().Sj(str, list, z10, map, i11, str2);
        }
    }

    public void Sj(final String str, final boolean z10) {
        final HiB uvD = Dq.Jcg().uvD();
        if (uvD == null || Dq.Jcg().vS() == null || uvD.EjP() == null || !uvD.Dq()) {
            return;
        }
        if (uvD.vS() == 0 && TextUtils.isEmpty(str)) {
            return;
        }
        if (!Dq.Jcg().sP() || Sj(Dq.Jcg().vS(), uvD)) {
            Dq.Jcg().Sj(str, z10);
        } else if (TKC()) {
            uvD.EjP().execute(new com.bytedance.sdk.component.vS.Sj.HiB.HiB("trackFailed") { // from class: com.bytedance.sdk.component.vS.Sj.EjP.6
                @Override // java.lang.Runnable
                public void run() {
                    EjP.this.Sj(str, uvD.vS(), z10);
                }
            });
        } else {
            Sj(str, uvD.vS(), z10);
        }
    }

    public void Sj(boolean z10) {
        Dq.Jcg().Sj(z10);
    }

    public void sP() {
        final HiB uvD = Dq.Jcg().uvD();
        if (uvD == null || Dq.Jcg().vS() == null || uvD.EjP() == null) {
            return;
        }
        if (!Dq.Jcg().sP()) {
            Dq.Jcg().Ym();
            return;
        }
        if (Sj(Dq.Jcg().vS(), uvD)) {
            Dq.Jcg().Ym();
        } else if (TKC()) {
            uvD.EjP().execute(new com.bytedance.sdk.component.vS.Sj.HiB.HiB("stop") { // from class: com.bytedance.sdk.component.vS.Sj.EjP.3
                @Override // java.lang.Runnable
                public void run() {
                    EjP.this.sP(uvD.vS());
                }
            });
        } else {
            sP(uvD.vS());
        }
    }
}

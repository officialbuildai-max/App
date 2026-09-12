package com.bytedance.sdk.component.adexpress.EjP;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class EjP {
    public static ScheduledFuture Sj(Runnable runnable, long j11, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.Dq.vS.vS().schedule(runnable, j11, timeUnit);
    }

    public static void Sj(com.bytedance.sdk.component.Dq.Dq dq2, int i11) {
        if (dq2 == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.Sj.Sj.TKC TKC = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
        ExecutorService sef = TKC != null ? TKC.sef() : null;
        if (sef == null) {
            com.bytedance.sdk.component.Dq.vS.Sj(dq2, i11);
        } else {
            dq2.setPriority(i11);
            sef.execute(dq2);
        }
    }

    public static void sP(com.bytedance.sdk.component.Dq.Dq dq2, int i11) {
        if (dq2 == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.Sj.Sj.TKC TKC = com.bytedance.sdk.component.adexpress.Sj.Sj.Sj.Sj().TKC();
        ExecutorService Fmk = TKC != null ? TKC.Fmk() : null;
        if (Fmk == null) {
            com.bytedance.sdk.component.Dq.vS.Sj(dq2);
        } else {
            dq2.setPriority(i11);
            Fmk.execute(dq2);
        }
    }
}

package com.bytedance.sdk.openadsdk.kF.Sj;

import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.Dq;

/* loaded from: classes3.dex */
public class Sj {
    private static Handler Sj;
    private static HandlerThread sP;

    public static Handler Sj() {
        HandlerThread handlerThread;
        try {
            handlerThread = sP;
        } catch (Throwable unused) {
        }
        if (handlerThread != null && handlerThread.isAlive()) {
            if (Sj == null) {
                synchronized (Sj.class) {
                    try {
                        if (Sj == null) {
                            Sj = new Handler(sP.getLooper());
                        }
                    } finally {
                    }
                }
            }
            return Sj;
        }
        synchronized (Sj.class) {
            try {
                HandlerThread handlerThread2 = sP;
                if (handlerThread2 != null) {
                    if (!handlerThread2.isAlive()) {
                    }
                }
                sP = Dq.Sj("csj_ev");
                Sj = new Handler(sP.getLooper());
            } finally {
            }
        }
        return Sj;
    }
}

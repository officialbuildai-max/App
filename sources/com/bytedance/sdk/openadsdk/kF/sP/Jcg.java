package com.bytedance.sdk.openadsdk.kF.sP;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.sdk.component.utils.sU;

/* loaded from: classes3.dex */
public class Jcg {
    private static Sj Sj;
    private static HandlerThread sP;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class Sj extends Handler {
        public Sj(Looper looper) {
            super(looper);
        }

        public void Sj(sP sPVar) {
            if (sPVar == null) {
                return;
            }
            int intValue = sPVar.Ym().intValue();
            if (hasMessages(intValue)) {
                return;
            }
            Message obtain = Message.obtain();
            obtain.what = intValue;
            obtain.obj = sPVar;
            sendMessageDelayed(obtain, sPVar.vS());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            sP sPVar = (sP) message.obj;
            if (sPVar == null) {
                return;
            }
            int sP = sPVar.sP();
            if (sP == 1) {
                sPVar.Jcg();
            } else {
                if (sP != 2) {
                    HiB.sP(sPVar.Ym());
                    return;
                }
                sPVar.Dq();
            }
            if (sPVar.uA()) {
                HiB.sP(sPVar.Ym());
            } else if (sPVar.aa()) {
                Sj(sPVar);
            }
        }
    }

    public static void Sj() {
    }

    public static void Sj(sP sPVar) {
        if (sPVar == null) {
            return;
        }
        sP();
        Sj sj2 = Sj;
        if (sj2 != null) {
            sj2.Sj(sPVar);
        }
    }

    public static void sP() {
        if (Sj != null) {
            return;
        }
        try {
            HandlerThread handlerThread = sP;
            if (handlerThread != null && handlerThread.isAlive()) {
                return;
            }
            synchronized (Jcg.class) {
                try {
                    HandlerThread handlerThread2 = sP;
                    if (handlerThread2 != null) {
                        if (!handlerThread2.isAlive()) {
                        }
                    }
                    sP = com.bytedance.sdk.component.utils.Dq.Sj("csj_MRC");
                    Sj = new Sj(sP.getLooper());
                } finally {
                }
            }
        } catch (Throwable th2) {
            sU.sP("MRC", th2.getMessage());
        }
    }

    public static void sP(sP sPVar) {
        if (sPVar == null || Sj == null) {
            return;
        }
        try {
            int intValue = sPVar.Ym().intValue();
            if (Sj.hasMessages(intValue)) {
                Sj.removeMessages(intValue);
            }
        } catch (Exception unused) {
        }
    }
}

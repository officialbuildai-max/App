package com.cloud.tmc.miniapp.prepare.controller;

import android.os.Handler;
import android.os.Looper;
import com.cloud.tmc.kernel.log.TmcLogger;

/* loaded from: classes3.dex */
public class OooO {
    public final OooO0O0 OooO00o;
    public final OooOO0 OooO0O0;
    public OooO0OO OooO0OO = null;

    /* loaded from: classes3.dex */
    public static class OooO00o implements OooOO0 {
        public Handler OooO00o = new Handler(Looper.getMainLooper());
    }

    /* loaded from: classes3.dex */
    public interface OooO0O0 {
        void onTimeout(long j11);
    }

    /* loaded from: classes3.dex */
    public class OooO0OO implements Runnable {
        public long OooO00o;
        public boolean OooO0O0 = false;

        public OooO0OO(long j11) {
            this.OooO00o = j11;
        }

        @Override // java.lang.Runnable
        public void run() {
            long currentTimeMillis = System.currentTimeMillis() - this.OooO00o;
            TmcLogger.d("Tmcresource:Timer", "timer timeout on elapsed: " + currentTimeMillis);
            if (this.OooO0O0) {
                return;
            }
            OooO0O0 oooO0O0 = OooO.this.OooO00o;
            if (oooO0O0 != null) {
                oooO0O0.onTimeout(currentTimeMillis);
            }
            OooO.this.OooO0OO = null;
        }
    }

    public OooO(OooO0O0 oooO0O0, OooOO0 oooOO0) {
        this.OooO00o = oooO0O0;
        this.OooO0O0 = oooOO0;
    }
}

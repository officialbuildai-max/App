package com.bytedance.sdk.openadsdk.core.Jcg;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.dNu;
import com.bytedance.sdk.openadsdk.core.settings.vS;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes3.dex */
public class Sj {
    private static volatile Sj Sj;
    private static volatile long TKC;
    private static volatile boolean sP;
    private Handler HiB;
    private final Queue<C0264Sj> EjP = new LinkedList();
    private final vS vS = dNu.EjP();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.core.Jcg.Sj$Sj, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0264Sj {
        private final long Sj;
        private final String sP;

        private C0264Sj(long j11, String str) {
            this.Sj = j11;
            this.sP = str;
        }
    }

    private Sj() {
    }

    public static Sj Sj() {
        if (Sj == null) {
            synchronized (Sj.class) {
                try {
                    if (Sj == null) {
                        Sj = new Sj();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return Sj;
    }

    private synchronized void Sj(long j11) {
        try {
            if (this.HiB == null) {
                this.HiB = new Handler(Looper.getMainLooper());
            }
            this.HiB.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.Jcg.Sj.1
                @Override // java.lang.Runnable
                public void run() {
                    Sj.this.Sj(false);
                }
            }, j11);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void Sj(boolean z10) {
        sP = z10;
    }

    private synchronized void sP(long j11) {
        TKC = j11;
    }

    private synchronized boolean sP(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        int zR = this.vS.zR();
        long dx2 = this.vS.dx();
        if (this.EjP.size() <= 0 || this.EjP.size() < zR) {
            this.EjP.offer(new C0264Sj(currentTimeMillis, str));
        } else {
            long abs = Math.abs(currentTimeMillis - this.EjP.peek().Sj);
            if (abs <= dx2) {
                sP(dx2 - abs);
                return true;
            }
            this.EjP.poll();
            this.EjP.offer(new C0264Sj(currentTimeMillis, str));
        }
        return false;
    }

    public synchronized boolean Sj(String str) {
        try {
            if (sP(str)) {
                Sj(true);
                Sj(TKC);
            } else {
                Sj(false);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return sP;
    }

    public synchronized String TKC() {
        String str;
        try {
            HashMap hashMap = new HashMap();
            for (C0264Sj c0264Sj : this.EjP) {
                if (hashMap.containsKey(c0264Sj.sP)) {
                    hashMap.put(c0264Sj.sP, Integer.valueOf(((Integer) hashMap.get(c0264Sj.sP)).intValue() + 1));
                } else {
                    hashMap.put(c0264Sj.sP, 1);
                }
            }
            str = "";
            int i11 = Integer.MIN_VALUE;
            for (String str2 : hashMap.keySet()) {
                int intValue = ((Integer) hashMap.get(str2)).intValue();
                if (i11 < intValue) {
                    str = str2;
                    i11 = intValue;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return str;
    }

    public synchronized boolean sP() {
        return sP;
    }
}

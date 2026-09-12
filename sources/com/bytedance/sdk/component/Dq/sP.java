package com.bytedance.sdk.component.Dq;

import android.os.SystemClock;
import com.bytedance.sdk.component.utils.Zq;
import com.cloud.tmc.ad.utils.CommonLogUtil;

/* loaded from: classes2.dex */
class sP implements Comparable, Runnable {
    private Thread EjP = null;
    private Dq Sj;
    private long TKC;
    private Sj sP;

    public sP(Dq dq2, Sj sj2) {
        this.TKC = 0L;
        this.Sj = dq2;
        this.sP = sj2;
        this.TKC = SystemClock.uptimeMillis();
    }

    private void Sj(String str, String str2, long j11) {
    }

    public Dq Sj() {
        return this.Sj;
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj instanceof sP) {
            return this.Sj.compareTo(((sP) obj).Sj());
        }
        return 0;
    }

    public boolean equals(Object obj) {
        Dq dq2;
        return (obj instanceof sP) && (dq2 = this.Sj) != null && dq2.equals(((sP) obj).Sj());
    }

    public int hashCode() {
        return this.Sj.hashCode();
    }

    @Override // java.lang.Runnable
    public void run() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.EjP = Thread.currentThread();
        Dq dq2 = this.Sj;
        if (dq2 != null) {
            dq2.run();
        }
        long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
        if (this.sP != null) {
            EjP.Sj();
        }
        if (Zq.Sj()) {
            Sj sj2 = this.sP;
            if (sj2 != null) {
                sj2.Sj();
            }
            Dq dq3 = this.Sj;
            if (dq3 != null) {
                dq3.getName();
            }
            String Sj = this.sP.Sj();
            Sj.hashCode();
            char c11 = 65535;
            switch (Sj.hashCode()) {
                case 3107:
                    if (Sj.equals(CommonLogUtil.TAG_AD)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3366:
                    if (Sj.equals("io")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (Sj.equals("log")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3237136:
                    if (Sj.equals("init")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 212371911:
                    if (Sj.equals("computation")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                case 3:
                    if (uptimeMillis2 > 2000) {
                        Sj sj3 = this.sP;
                        String Sj2 = sj3 != null ? sj3.Sj() : "null";
                        Dq dq4 = this.Sj;
                        Sj(Sj2, dq4 != null ? dq4.getName() : "null", uptimeMillis2);
                        return;
                    }
                    return;
                case 1:
                    if (uptimeMillis2 > 5000) {
                        Sj sj4 = this.sP;
                        String Sj3 = sj4 != null ? sj4.Sj() : "null";
                        Dq dq5 = this.Sj;
                        Sj(Sj3, dq5 != null ? dq5.getName() : "null", uptimeMillis2);
                        return;
                    }
                    return;
                case 2:
                    if (uptimeMillis2 > 3000) {
                        Sj sj5 = this.sP;
                        String Sj4 = sj5 != null ? sj5.Sj() : "null";
                        Dq dq6 = this.Sj;
                        Sj(Sj4, dq6 != null ? dq6.getName() : "null", uptimeMillis2);
                        return;
                    }
                    return;
                case 4:
                    if (uptimeMillis2 > 1000) {
                        Sj sj6 = this.sP;
                        String Sj5 = sj6 != null ? sj6.Sj() : "null";
                        Dq dq7 = this.Sj;
                        Sj(Sj5, dq7 != null ? dq7.getName() : "null", uptimeMillis2);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}

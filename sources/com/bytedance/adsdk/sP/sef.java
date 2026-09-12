package com.bytedance.adsdk.sP;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.util.LinkedHashMap;
import java.util.Locale;

/* loaded from: classes2.dex */
public class sef<K, V> {
    private int Dq;
    private int EjP;
    private int HiB;
    private int Jcg;
    private final LinkedHashMap<K, V> Sj;
    private int TKC;
    private int sP;
    private int vS;

    public sef(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.TKC = i11;
        this.Sj = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int TKC(K k11, V v11) {
        int sP = sP(k11, v11);
        if (sP >= 0) {
            return sP;
        }
        throw new IllegalStateException("Negative size: " + k11 + UrlUtils.EQUAL_MARK + v11);
    }

    public final V Sj(K k11) {
        V put;
        if (k11 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                V v11 = this.Sj.get(k11);
                if (v11 != null) {
                    this.Jcg++;
                    return v11;
                }
                this.Dq++;
                V sP = sP(k11);
                if (sP == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.HiB++;
                        put = this.Sj.put(k11, sP);
                        if (put != null) {
                            this.Sj.put(k11, put);
                        } else {
                            this.sP += TKC(k11, sP);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (put != null) {
                    return put;
                }
                Sj(this.TKC);
                return sP;
            } finally {
            }
        }
    }

    public final V Sj(K k11, V v11) {
        V put;
        if (k11 == null || v11 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.EjP++;
                this.sP += TKC(k11, v11);
                put = this.Sj.put(k11, v11);
                if (put != null) {
                    this.sP -= TKC(k11, put);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Sj(this.TKC);
        return put;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x006f, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void Sj(int r4) {
        /*
            r3 = this;
        L0:
            monitor-enter(r3)
            int r0 = r3.sP     // Catch: java.lang.Throwable -> L12
            if (r0 < 0) goto L51
            java.util.LinkedHashMap<K, V> r0 = r3.Sj     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.sP     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L51
            goto L14
        L12:
            r4 = move-exception
            goto L70
        L14:
            int r0 = r3.sP     // Catch: java.lang.Throwable -> L12
            if (r0 <= r4) goto L4f
            java.util.LinkedHashMap<K, V> r0 = r3.Sj     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L21
            goto L4f
        L21:
            java.util.LinkedHashMap<K, V> r0 = r3.Sj     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, V> r2 = r3.Sj     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.sP     // Catch: java.lang.Throwable -> L12
            int r0 = r3.TKC(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r0
            r3.sP = r2     // Catch: java.lang.Throwable -> L12
            int r0 = r3.vS     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.vS = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L4f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L51:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L12
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            r0.<init>()     // Catch: java.lang.Throwable -> L12
            java.lang.Class r1 = r3.getClass()     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L12
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            r0.append(r1)     // Catch: java.lang.Throwable -> L12
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L12
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L12
            throw r4     // Catch: java.lang.Throwable -> L12
        L70:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.sP.sef.Sj(int):void");
    }

    protected int sP(K k11, V v11) {
        return 1;
    }

    protected V sP(K k11) {
        return null;
    }

    public final synchronized String toString() {
        int i11;
        int i12;
        try {
            i11 = this.Jcg;
            i12 = this.Dq + i11;
        } catch (Throwable th2) {
            throw th2;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.TKC), Integer.valueOf(this.Jcg), Integer.valueOf(this.Dq), Integer.valueOf(i12 != 0 ? (i11 * 100) / i12 : 0));
    }
}

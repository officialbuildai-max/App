package com.bytedance.sdk.component.HiB.TKC.Sj;

import com.cloud.tmc.kernel.utils.UrlUtils;
import java.lang.ref.SoftReference;
import java.util.LinkedHashMap;

/* loaded from: classes2.dex */
public class TKC<K, V> {
    private int Dq;
    private int EjP;
    private int HiB;
    private int Jcg;
    private final LinkedHashMap<K, SoftReference<V>> Sj;
    private int TKC;
    private int sP;
    private int vS;

    public TKC(int i11) {
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
        V v11;
        if (k11 == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                SoftReference<V> softReference = this.Sj.get(k11);
                if (softReference != null) {
                    v11 = softReference.get();
                    if (v11 != null) {
                        this.Jcg++;
                        return v11;
                    }
                    this.Sj.remove(k11);
                } else {
                    v11 = null;
                }
                this.Dq++;
                V sP = sP(k11);
                if (sP == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.HiB++;
                        SoftReference<V> put = this.Sj.put(k11, new SoftReference<>(sP));
                        if (put != null) {
                            v11 = put.get();
                        }
                        if (v11 != null) {
                            this.Sj.put(k11, put);
                        } else {
                            this.sP += TKC(k11, sP);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (v11 != null) {
                    return v11;
                }
                Sj(this.TKC);
                return sP;
            } finally {
            }
        }
    }

    public final V Sj(K k11, V v11) {
        V v12;
        if (k11 == null || v11 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.EjP++;
                this.sP += TKC(k11, v11);
                SoftReference<V> put = this.Sj.put(k11, new SoftReference<>(v11));
                if (put != null) {
                    v12 = put.get();
                    if (v12 != null) {
                        this.sP -= TKC(k11, v12);
                    }
                } else {
                    v12 = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Sj(this.TKC);
        return v12;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0054, code lost:
    
        android.util.Log.e("LruCache", "oom maybe occured, clear cache. size= " + r3.sP + ", maxSize: " + r4);
        r3.sP = 0;
        r3.Sj.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x007a, code lost:
    
        return;
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
            if (r0 < 0) goto L54
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.Sj     // Catch: java.lang.Throwable -> L12
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            int r0 = r3.sP     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L14
            goto L54
        L12:
            r4 = move-exception
            goto L7b
        L14:
            int r0 = r3.sP     // Catch: java.lang.Throwable -> L12
            if (r0 > r4) goto L1a
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L1a:
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r0 = r3.Sj     // Catch: java.lang.Throwable -> L12
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> L12
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> L12
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> L12
            if (r0 != 0) goto L2e
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L2e:
            java.lang.Object r1 = r0.getKey()     // Catch: java.lang.Throwable -> L12
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> L12
            java.lang.ref.SoftReference r0 = (java.lang.ref.SoftReference) r0     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r2 = r3.Sj     // Catch: java.lang.Throwable -> L12
            r2.remove(r1)     // Catch: java.lang.Throwable -> L12
            if (r0 == 0) goto L4c
            java.lang.Object r0 = r0.get()     // Catch: java.lang.Throwable -> L12
            int r2 = r3.sP     // Catch: java.lang.Throwable -> L12
            int r0 = r3.TKC(r1, r0)     // Catch: java.lang.Throwable -> L12
            int r2 = r2 - r0
            r3.sP = r2     // Catch: java.lang.Throwable -> L12
        L4c:
            int r0 = r3.vS     // Catch: java.lang.Throwable -> L12
            int r0 = r0 + 1
            r3.vS = r0     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            goto L0
        L54:
            java.lang.String r0 = "LruCache"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = "oom maybe occured, clear cache. size= "
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L12
            int r2 = r3.sP     // Catch: java.lang.Throwable -> L12
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            java.lang.String r2 = ", maxSize: "
            r1.append(r2)     // Catch: java.lang.Throwable -> L12
            r1.append(r4)     // Catch: java.lang.Throwable -> L12
            java.lang.String r4 = r1.toString()     // Catch: java.lang.Throwable -> L12
            android.util.Log.e(r0, r4)     // Catch: java.lang.Throwable -> L12
            r4 = 0
            r3.sP = r4     // Catch: java.lang.Throwable -> L12
            java.util.LinkedHashMap<K, java.lang.ref.SoftReference<V>> r4 = r3.Sj     // Catch: java.lang.Throwable -> L12
            r4.clear()     // Catch: java.lang.Throwable -> L12
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L12
            return
        L7b:
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.HiB.TKC.Sj.TKC.Sj(int):void");
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
        return String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.TKC), Integer.valueOf(this.Jcg), Integer.valueOf(this.Dq), Integer.valueOf(i12 != 0 ? (i11 * 100) / i12 : 0));
    }
}

package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.d;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.uA;
import h6.e;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class Sj implements Ym {
    private static final AtomicLong Fmk = new AtomicLong();
    protected volatile String Dq;
    protected g6.a HiB;
    protected volatile String Jcg;
    protected volatile com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.a Sj;
    protected volatile d TEQ;
    protected final sP.e sP;
    protected volatile uA uA;
    protected volatile List<uA.c> vS;
    protected final AtomicInteger TKC = new AtomicInteger();
    protected final AtomicLong EjP = new AtomicLong();
    protected volatile boolean Ym = false;

    /* renamed from: aa, reason: collision with root package name */
    public final long f20307aa = Fmk.incrementAndGet();
    private final AtomicInteger sef = new AtomicInteger(0);
    private int Zq = -1;

    public Sj(com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.a aVar, sP.e eVar) {
        this.Sj = aVar;
    }

    public boolean EjP() {
        return this.sef.get() == 2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void HiB() throws com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj {
        if (sP()) {
            throw new com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean Jcg() {
        return vS() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h6.c Sj(d.a aVar, int i11, int i12, String str) throws IOException {
        e b11 = h6.d.a().b();
        h6.b bVar = new h6.b();
        HashMap hashMap = new HashMap();
        bVar.f64496b = aVar.f20336a;
        bVar.f64495a = 0;
        if ("HEAD".equalsIgnoreCase(str)) {
            bVar.f64495a = 4;
        }
        List<uA.c> list = this.vS;
        if (list != null && !list.isEmpty()) {
            for (uA.c cVar : list) {
                if (!"Range".equalsIgnoreCase(cVar.f20369a) && !"Connection".equalsIgnoreCase(cVar.f20369a) && !"Proxy-Connection".equalsIgnoreCase(cVar.f20369a) && !HttpHeaders.HOST.equalsIgnoreCase(cVar.f20369a)) {
                    hashMap.put(cVar.f20369a, cVar.f20370b);
                }
            }
        }
        String e11 = f6.a.e(i11, i12);
        if (e11 != null) {
            hashMap.put("Range", e11);
        }
        if (a.f20321e) {
            hashMap.put(HttpHeaders.CACHE_CONTROL, "no-cache");
        }
        EjP j11 = EjP.j();
        vS j12 = vS.j();
        boolean z10 = this.uA == null;
        if (z10) {
            j11.c();
        } else {
            j12.p();
        }
        if (z10) {
            j11.l();
        } else {
            j12.n();
        }
        bVar.f64499e = hashMap;
        if (!this.Ym) {
            return b11.a(bVar);
        }
        this.Ym = false;
        return null;
    }

    public void Sj() {
        this.sef.compareAndSet(0, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Sj(int i11, int i12) {
        if (i11 <= 0 || i12 < 0) {
            return;
        }
        int i13 = a.f20322f;
        int vS = vS();
        if (i13 == 1 || (i13 == 2 && vS == 1)) {
            int i14 = (int) ((i12 / i11) * 100.0f);
            if (i14 > 100) {
                i14 = 100;
            }
            synchronized (this) {
                try {
                    if (i14 <= this.Zq) {
                        return;
                    }
                    this.Zq = i14;
                    f6.a.o(new Runnable() { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Sj.this.getClass();
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void TKC() {
        this.sef.compareAndSet(0, 2);
    }

    public boolean sP() {
        return this.sef.get() == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int vS() {
        if (this.uA != null) {
            return this.uA.f20358c.f20359a;
        }
        return 0;
    }
}

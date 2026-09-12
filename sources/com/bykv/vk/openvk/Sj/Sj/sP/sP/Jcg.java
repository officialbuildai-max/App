package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import android.os.SystemClock;
import android.util.Log;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.Dq;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.TKC;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.d;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.uA;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;

/* loaded from: classes2.dex */
class Jcg extends Sj {
    private final Socket Fmk;
    private final EjP Zq;
    private volatile boolean dNu;
    private final c sef;
    private volatile sP uvD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements sP.b {
        a() {
        }

        @Override // com.bykv.vk.openvk.Sj.Sj.sP.sP.sP.b
        public void a(sP sPVar) {
            Jcg.this.TKC.addAndGet(sPVar.TKC.get());
            Jcg.this.EjP.addAndGet(sPVar.EjP.get());
            synchronized (sPVar.Fmk) {
                sPVar.Fmk.notifyAll();
            }
            if (sPVar.EjP()) {
                Jcg.this.Zq.f(Jcg.this.Jcg(), null);
            }
        }
    }

    /* loaded from: classes2.dex */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.a f20300a;

        /* renamed from: b, reason: collision with root package name */
        sP.e f20301b;

        /* renamed from: c, reason: collision with root package name */
        Socket f20302c;

        /* renamed from: d, reason: collision with root package name */
        c f20303d;

        b() {
        }

        b a(c cVar) {
            this.f20303d = cVar;
            return this;
        }

        b b(sP.e eVar) {
            throw new IllegalArgumentException("db == null");
        }

        b c(Socket socket) {
            if (socket == null) {
                throw new IllegalArgumentException("socket == null");
            }
            this.f20302c = socket;
            return this;
        }

        Jcg d() {
            throw new IllegalArgumentException();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(Jcg jcg);

        void b(Jcg jcg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final OutputStream f20304a;

        /* renamed from: b, reason: collision with root package name */
        private int f20305b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f20306c;

        d(OutputStream outputStream, int i11) {
            this.f20304a = outputStream;
            this.f20305b = i11;
        }

        void a(byte[] bArr, int i11, int i12) {
            if (this.f20306c) {
                return;
            }
            try {
                this.f20304a.write(bArr, i11, i12);
                this.f20306c = true;
            } catch (IOException e11) {
                throw new com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.EjP(e11);
            }
        }

        boolean b() {
            return this.f20306c;
        }

        int c() {
            return this.f20305b;
        }

        void d(byte[] bArr, int i11, int i12) {
            try {
                this.f20304a.write(bArr, i11, i12);
                this.f20305b += i12;
            } catch (IOException e11) {
                throw new com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.EjP(e11);
            }
        }
    }

    Jcg(b bVar) {
        super(bVar.f20300a, bVar.f20301b);
        this.dNu = true;
        this.Fmk = bVar.f20302c;
        this.sef = bVar.f20303d;
        this.Zq = EjP.j();
    }

    private d Dq() {
        try {
            this.uA = uA.a(this.Fmk.getInputStream());
            this.Fmk.getOutputStream();
            if (this.uA.f20358c.f20359a == 1) {
                boolean z10 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
            } else {
                TKC tkc = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20317a;
            }
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_ProxyTask", "cache is null");
            }
            return null;
        } catch (uA.EjP e11) {
            f6.a.q(this.Fmk);
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e11));
            }
            if (this.Sj != null) {
                Jcg();
            }
            return null;
        } catch (IOException e12) {
            f6.a.q(this.Fmk);
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e12));
            }
            if (this.Sj != null) {
                Jcg();
            }
            return null;
        }
    }

    private void EjP(d dVar, d.a aVar) throws com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.EjP, IOException, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP {
        String h11;
        Dq dq2;
        uA();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int c11 = dVar.c();
        h6.c Sj = Sj(aVar, c11, this.uA.f20358c.f20363e, "GET");
        if (Sj == null) {
            return;
        }
        Dq dq3 = null;
        int i11 = 0;
        try {
            h11 = f6.a.h(Sj, false, true);
        } catch (Throwable th2) {
            th = th2;
        }
        if (h11 != null) {
            throw new com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.TKC(h11 + ", rawKey: " + this.Jcg + ", url: " + aVar);
        }
        sP.d c12 = this.sP.c(this.Dq, vS());
        int b11 = f6.a.b(Sj);
        if (c12 != null && c12.f20351c != b11) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_ProxyTask", "Content-Length not match, old: " + c12.f20351c + ", " + b11 + ", key: " + this.Dq);
            }
            throw new com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP("Content-Length not match, old length: " + c12.f20351c + ", new length: " + b11 + ", rawKey: " + this.Jcg + ", currentUrl: " + aVar + ", previousInfo: " + c12.f20353e);
        }
        if (!dVar.b()) {
            String g11 = f6.a.g(Sj, c11);
            HiB();
            byte[] bytes = g11.getBytes(f6.a.f62464b);
            dVar.a(bytes, 0, bytes.length);
        }
        HiB();
        File a11 = this.Sj.a(this.Dq);
        if (!this.dNu || a11 == null || a11.length() < dVar.c()) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.w("TAG_PROXY_ProxyTask", "can't write to cache file in network task, cache file size: " + a11.length() + ", from: " + dVar.c());
            }
            dq2 = null;
        } else {
            f6.a.d(Sj, this.sP, this.Dq, this.uA.f20358c.f20359a);
            try {
                dq2 = new Dq(a11, "rwd");
            } catch (Dq.Sj unused) {
                dq2 = null;
            }
            try {
                dq2.c(dVar.c());
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    StringBuilder sb2 = new StringBuilder("can write to cache file in network task, cache file size: ");
                    sb2.append(a11.length());
                    sb2.append(", from: ");
                    sb2.append(dVar.c());
                }
            } catch (Throwable th3) {
                th = th3;
                dq3 = dq2;
            }
        }
        sP.d c13 = this.sP.c(this.Dq, vS());
        int i12 = c13 == null ? 0 : c13.f20351c;
        byte[] bArr = new byte[8192];
        InputStream a12 = Sj.a();
        int i13 = 0;
        while (true) {
            try {
                int read = a12.read(bArr);
                if (read < 0) {
                    break;
                }
                HiB();
                if (read > 0) {
                    dVar.d(bArr, 0, read);
                    i13 += read;
                    if (dq2 != null) {
                        try {
                            dq2.d(bArr, 0, read);
                        } catch (Throwable th4) {
                            dq2.b();
                            try {
                                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                                    Log.e("TAG_PROXY_ProxyTask", "append to cache file error in network task!!! " + Log.getStackTraceString(th4));
                                }
                                dq2 = null;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        }
                    }
                    Sj(i12, dVar.c());
                }
                HiB();
            } catch (Throwable th6) {
                th = th6;
                dq3 = dq2;
            }
            th = th6;
            dq3 = dq2;
            i11 = i13;
            f6.a.m(Sj.a());
            if (dq3 != null) {
                dq3.b();
            }
            this.TKC.addAndGet(i11);
            this.EjP.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
            throw th;
        }
        boolean z10 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
        TKC();
        f6.a.m(Sj.a());
        if (dq2 != null) {
            dq2.b();
        }
        this.TKC.addAndGet(i13);
        this.EjP.addAndGet(SystemClock.elapsedRealtime() - elapsedRealtime);
    }

    private void Sj(d dVar, d.a aVar) throws com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.EjP, IOException, Dq.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP {
        if ("HEAD".equalsIgnoreCase(this.uA.f20356a.f20366a)) {
            sP(dVar, aVar);
        } else {
            TKC(dVar, aVar);
        }
    }

    private void Sj(sP.d dVar, File file, d dVar2, d.a aVar) throws IOException, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.EjP, Dq.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP {
        final com.bytedance.sdk.component.Dq.Jcg jcg;
        sP sPVar;
        if (!dVar2.b()) {
            byte[] Sj = Sj(dVar, dVar2, aVar);
            HiB();
            if (Sj == null) {
                return;
            } else {
                dVar2.a(Sj, 0, Sj.length);
            }
        }
        Dq dq2 = null;
        if (dVar == null && (dVar = this.sP.c(this.Dq, this.uA.f20358c.f20359a)) == null) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_ProxyTask", "failed to get video header info from db");
            }
            Sj(null, dVar2, aVar);
            dVar = this.sP.c(this.Dq, this.uA.f20358c.f20359a);
            if (dVar == null) {
                throw new com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.TKC("failed to get header, rawKey: " + this.Jcg + ", url: " + aVar);
            }
        }
        if (file.length() >= dVar.f20351c || !((sPVar = this.uvD) == null || sPVar.sP() || sPVar.EjP())) {
            jcg = null;
        } else {
            sP j11 = new sP.a().b(this.Sj).e(this.sP).h(this.Jcg).k(this.Dq).c(new com.bykv.vk.openvk.Sj.Sj.sP.sP.d(aVar.f20336a)).i(this.vS).f(this.uA).d(new a()).j();
            this.uvD = j11;
            jcg = new com.bytedance.sdk.component.Dq.Jcg(j11, null, 10, 1);
            com.bytedance.sdk.component.Dq.vS.sP(new com.bytedance.sdk.component.Dq.Dq("processCacheNetWorkConcurrent") { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.Jcg.2
                @Override // java.lang.Runnable
                public void run() {
                    jcg.run();
                }
            });
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_ProxyTask", "fire download in process cache task");
            }
        }
        byte[] bArr = new byte[8192];
        try {
            Dq dq3 = new Dq(file, CampaignEx.JSON_KEY_AD_R);
            try {
                dq3.c(dVar2.c());
                int min = this.uA.f20358c.f20363e > 0 ? Math.min(dVar.f20351c, this.uA.f20358c.f20363e) : dVar.f20351c;
                while (dVar2.c() < min) {
                    HiB();
                    int a11 = dq3.a(bArr);
                    if (a11 <= 0) {
                        sP sPVar2 = this.uvD;
                        if (sPVar2 != null) {
                            com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP uA = sPVar2.uA();
                            if (uA != null) {
                                throw uA;
                            }
                            Dq.Sj Dq = sPVar2.Dq();
                            if (Dq != null) {
                                throw Dq;
                            }
                        }
                        if (sPVar2 != null && !sPVar2.sP() && !sPVar2.EjP()) {
                            HiB();
                            synchronized (sPVar2.Fmk) {
                                try {
                                    sPVar2.Fmk.wait(1000L);
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                            Log.e("TAG_PROXY_ProxyTask", "download task has finished!!!");
                        }
                        throw new com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.TKC("illegal state download task has finished, rawKey: " + this.Jcg + ", url: " + aVar);
                    }
                    dVar2.d(bArr, 0, a11);
                    HiB();
                }
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    StringBuilder sb2 = new StringBuilder("read cache file complete: ");
                    sb2.append(dVar2.c());
                    sb2.append(", ");
                    sb2.append(min);
                }
                TKC();
                dq3.b();
                if (jcg != null) {
                    try {
                        jcg.get();
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                dq2 = dq3;
                if (dq2 != null) {
                    dq2.b();
                }
                if (jcg != null) {
                    try {
                        jcg.get();
                    } catch (Throwable unused3) {
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private boolean Sj(d dVar) throws com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj {
        while (this.TEQ.b()) {
            HiB();
            d.a d11 = this.TEQ.d();
            try {
                Sj(dVar, d11);
                return true;
            } catch (Dq.Sj e11) {
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e11));
                }
                this.dNu = false;
                Jcg();
            } catch (com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.EjP e12) {
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e12));
                }
                return true;
            } catch (com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.TKC unused) {
                d11.a();
                Jcg();
            } catch (com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP e13) {
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e13));
                }
                return false;
            } catch (IOException e14) {
                if (e14 instanceof SocketTimeoutException) {
                    d11.b();
                }
                if (!sP()) {
                    Jcg();
                } else if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    if ("Canceled".equalsIgnoreCase(e14.getMessage())) {
                        Log.w("TAG_PROXY_ProxyTask", "okhttp call canceled");
                    } else {
                        Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e14));
                    }
                }
            } catch (Exception e15) {
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e15));
                }
            }
        }
        return false;
    }

    private byte[] Sj(sP.d dVar, d dVar2, d.a aVar) throws IOException {
        if (dVar != null) {
            boolean z10 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
            return f6.a.f(dVar, dVar2.c()).getBytes(f6.a.f62464b);
        }
        h6.c Sj = Sj(aVar, 0, -1, "HEAD");
        if (Sj == null) {
            return null;
        }
        try {
            String h11 = f6.a.h(Sj, false, false);
            if (h11 == null) {
                sP.d d11 = f6.a.d(Sj, this.sP, this.Dq, this.uA.f20358c.f20359a);
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    Log.w("TAG_PROXY_ProxyTask", "get header from network");
                }
                byte[] bytes = f6.a.f(d11, dVar2.c()).getBytes(f6.a.f62464b);
                f6.a.m(Sj.a());
                return bytes;
            }
            throw new com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.TKC(h11 + ", rawKey: " + this.Jcg + ", url: " + aVar);
        } catch (Throwable th2) {
            f6.a.m(Sj.a());
            throw th2;
        }
    }

    private void TKC(d dVar, d.a aVar) throws Dq.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.EjP, IOException, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.sP {
        if (this.dNu) {
            File c11 = this.Sj.c(this.Dq);
            long length = c11.length();
            sP.d c12 = this.sP.c(this.Dq, this.uA.f20358c.f20359a);
            int c13 = dVar.c();
            if (length > dVar.c()) {
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    new StringBuilder("cache hit, remainSize: ").append(length - c13);
                }
                Sj(c12, c11, dVar, aVar);
                return;
            }
        } else {
            dVar.c();
        }
        EjP(dVar, aVar);
    }

    private void sP(d dVar, d.a aVar) throws IOException, com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.EjP {
        byte[] Sj = Sj(this.sP.c(this.Dq, this.uA.f20358c.f20359a), dVar, aVar);
        if (Sj == null) {
            return;
        }
        dVar.a(Sj, 0, Sj.length);
    }

    private void uA() {
        sP sPVar = this.uvD;
        this.uvD = null;
        if (sPVar != null) {
            sPVar.Sj();
        }
    }

    @Override // com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj
    public void Sj() {
        super.Sj();
        uA();
    }

    @Override // java.lang.Runnable
    public void run() {
        sP.d c11;
        d Dq = Dq();
        if (Dq == null) {
            return;
        }
        c cVar = this.sef;
        if (cVar != null) {
            cVar.a(this);
        }
        this.Sj.b(this.Dq);
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20323g != 0 && ((c11 = this.sP.c(this.Dq, this.uA.f20358c.f20359a)) == null || this.Sj.c(this.Dq).length() < c11.f20351c)) {
            this.Zq.f(Jcg(), this.Dq);
        }
        try {
            Sj(Dq);
        } catch (com.bykv.vk.openvk.Sj.Sj.sP.sP.TKC.Sj e11) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(e11));
            }
        } catch (Throwable th2) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                Log.e("TAG_PROXY_ProxyTask", Log.getStackTraceString(th2));
            }
        }
        this.Sj.d(this.Dq);
        this.Zq.f(Jcg(), null);
        Sj();
        f6.a.q(this.Fmk);
        c cVar2 = this.sef;
        if (cVar2 != null) {
            cVar2.b(this);
        }
    }
}

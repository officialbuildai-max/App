package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import android.util.Base64;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.Jcg;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public class vS {

    /* renamed from: i, reason: collision with root package name */
    private static volatile vS f20371i;

    /* renamed from: a, reason: collision with root package name */
    private volatile ServerSocket f20372a;

    /* renamed from: b, reason: collision with root package name */
    private volatile int f20373b;

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f20374c = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name */
    private volatile sP.e f20375d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray f20376e;

    /* renamed from: f, reason: collision with root package name */
    private final Jcg.c f20377f;

    /* renamed from: g, reason: collision with root package name */
    private final Runnable f20378g;

    /* renamed from: h, reason: collision with root package name */
    private final AtomicBoolean f20379h;

    /* loaded from: classes2.dex */
    class a implements Jcg.c {
        a() {
        }

        @Override // com.bykv.vk.openvk.Sj.Sj.sP.sP.Jcg.c
        public void a(Jcg jcg) {
            synchronized (vS.this.f20376e) {
                try {
                    Set set = (Set) vS.this.f20376e.get(jcg.vS());
                    if (set != null) {
                        set.add(jcg);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.bykv.vk.openvk.Sj.Sj.sP.sP.Jcg.c
        public void b(Jcg jcg) {
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                "afterExecute, ProxyTask: ".concat(String.valueOf(jcg));
            }
            int vS = jcg.vS();
            synchronized (vS.this.f20376e) {
                try {
                    Set set = (Set) vS.this.f20376e.get(vS);
                    if (set != null) {
                        set.remove(jcg);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements Callable {

        /* renamed from: a, reason: collision with root package name */
        private final String f20388a;

        /* renamed from: b, reason: collision with root package name */
        private final int f20389b;

        b(String str, int i11) {
            this.f20388a = str;
            this.f20389b = i11;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean call() {
            Socket socket;
            Throwable th2;
            try {
                socket = new Socket(this.f20388a, this.f20389b);
                try {
                    socket.setSoTimeout(2000);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write("Ping\n".getBytes(f6.a.f62464b));
                    outputStream.flush();
                    if ("OK".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                        return Boolean.TRUE;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        th2.getMessage();
                        vS.l("ping error", Log.getStackTraceString(th2));
                        return Boolean.FALSE;
                    } finally {
                        f6.a.q(socket);
                    }
                }
            } catch (Throwable th4) {
                socket = null;
                th2 = th4;
            }
            return Boolean.FALSE;
        }
    }

    private vS() {
        SparseArray sparseArray = new SparseArray(2);
        this.f20376e = sparseArray;
        this.f20377f = new a();
        this.f20378g = new Runnable() { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.vS.2

            /* renamed from: com.bykv.vk.openvk.Sj.Sj.sP.sP.vS$2$1, reason: invalid class name */
            /* loaded from: classes2.dex */
            class AnonymousClass1 extends com.bytedance.sdk.component.Dq.Dq {
                final /* synthetic */ Jcg Sj;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(String str, int i11, Jcg jcg) {
                    super(str, i11);
                    this.Sj = jcg;
                }

                @Override // java.lang.Runnable
                public void run() {
                    this.Sj.run();
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    int i11 = 0;
                    vS.this.f20372a = new ServerSocket(0, 50, InetAddress.getByName(vS.this.s()));
                    vS vSVar = vS.this;
                    vSVar.f20373b = vSVar.f20372a.getLocalPort();
                    if (vS.this.f20373b == -1) {
                        vS.l("socket not bound", "");
                        vS.this.e();
                        return;
                    }
                    com.bykv.vk.openvk.Sj.Sj.sP.sP.b.a(vS.this.s(), vS.this.f20373b);
                    if (vS.this.g()) {
                        AtomicInteger unused = vS.this.f20374c;
                        if (vS.this.f20374c.compareAndSet(0, 1)) {
                            AtomicInteger unused2 = vS.this.f20374c;
                            boolean z10 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
                            while (vS.this.f20374c.get() == 1) {
                                try {
                                    try {
                                        Socket accept = vS.this.f20372a.accept();
                                        sP.e unused3 = vS.this.f20375d;
                                        f6.a.q(accept);
                                    } catch (IOException e11) {
                                        vS.l("accept error", Log.getStackTraceString(e11));
                                        i11++;
                                        if (i11 > 3) {
                                            break;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    String stackTraceString = Log.getStackTraceString(th2);
                                    Log.e("ProxyServer", "proxy server crashed!  ".concat(String.valueOf(stackTraceString)));
                                    vS.l("error", stackTraceString);
                                }
                            }
                            boolean z11 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
                            vS.this.e();
                        }
                    }
                } catch (IOException e12) {
                    if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                        Log.e("ProxyServer", "create ServerSocket error!  " + Log.getStackTraceString(e12));
                    }
                    vS.l("create ServerSocket error", Log.getStackTraceString(e12));
                    vS.this.e();
                }
            }
        };
        this.f20379h = new AtomicBoolean();
        sparseArray.put(0, new HashSet());
        sparseArray.put(1, new HashSet());
    }

    private void b() {
        Socket socket = null;
        try {
            socket = this.f20372a.accept();
            socket.setSoTimeout(2000);
            if ("Ping".equals(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine())) {
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("OK\n".getBytes(f6.a.f62464b));
                outputStream.flush();
            }
        } catch (IOException e11) {
            Log.getStackTraceString(e11);
        } finally {
            f6.a.q(socket);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.f20374c.compareAndSet(1, 2) || this.f20374c.compareAndSet(0, 2)) {
            f6.a.p(this.f20372a);
            t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean g() {
        com.bytedance.sdk.component.Dq.Jcg jcg = new com.bytedance.sdk.component.Dq.Jcg(new b(s(), this.f20373b), 5, 1);
        com.bytedance.sdk.component.Dq.vS.TKC().submit(jcg);
        b();
        try {
            if (((Boolean) jcg.get()).booleanValue()) {
                boolean z10 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
                return true;
            }
            Log.e("ProxyServer", "Ping error");
            e();
            return false;
        } catch (Throwable th2) {
            Log.getStackTraceString(th2);
            e();
            return false;
        }
    }

    public static vS j() {
        if (f20371i == null) {
            synchronized (vS.class) {
                try {
                    if (f20371i == null) {
                        f20371i = new vS();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f20371i;
    }

    static /* synthetic */ void l(String str, String str2) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String s() {
        return new String(Base64.decode("MTI3LjAuMC4x".getBytes(), 0));
    }

    private void t() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f20376e) {
            try {
                int size = this.f20376e.size();
                for (int i11 = 0; i11 < size; i11++) {
                    SparseArray sparseArray = this.f20376e;
                    Set set = (Set) sparseArray.get(sparseArray.keyAt(i11));
                    if (set != null) {
                        arrayList.addAll(set);
                        set.clear();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Jcg) it.next()).Sj();
        }
    }

    boolean m(int i11, String str) {
        if (str == null) {
            return false;
        }
        synchronized (this.f20376e) {
            Set<Jcg> set = (Set) this.f20376e.get(i11);
            if (set != null) {
                for (Jcg jcg : set) {
                    if (jcg != null && str.equals(jcg.Dq)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c n() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c p() {
        return null;
    }
}

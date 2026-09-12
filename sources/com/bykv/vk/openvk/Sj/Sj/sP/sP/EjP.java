package com.bykv.vk.openvk.Sj.Sj.sP.sP;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.Sj.TKC;
import com.bykv.vk.openvk.Sj.Sj.sP.sP.sP;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class EjP {

    /* renamed from: k, reason: collision with root package name */
    private static volatile EjP f20280k;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f20281a = 163840;

    /* renamed from: b, reason: collision with root package name */
    private final SparseArray f20282b;

    /* renamed from: c, reason: collision with root package name */
    private final sP f20283c;

    /* renamed from: d, reason: collision with root package name */
    private final ExecutorService f20284d;

    /* renamed from: e, reason: collision with root package name */
    private volatile sP.e f20285e;

    /* renamed from: f, reason: collision with root package name */
    private volatile TKC f20286f;

    /* renamed from: g, reason: collision with root package name */
    private final HashSet f20287g;

    /* renamed from: h, reason: collision with root package name */
    private final sP.b f20288h;

    /* renamed from: i, reason: collision with root package name */
    private volatile String f20289i;

    /* renamed from: j, reason: collision with root package name */
    private volatile boolean f20290j;

    /* loaded from: classes2.dex */
    class a implements sP.b {
        a() {
        }

        @Override // com.bykv.vk.openvk.Sj.Sj.sP.sP.sP.b
        public void a(com.bykv.vk.openvk.Sj.Sj.sP.sP.sP sPVar) {
            int vS = sPVar.vS();
            synchronized (EjP.this.f20282b) {
                try {
                    Map map = (Map) EjP.this.f20282b.get(vS);
                    if (map != null) {
                        map.remove(sPVar.Dq);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                new StringBuilder("afterExecute, key: ").append(sPVar.Dq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b implements RejectedExecutionHandler {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ sP f20292a;

        b(sP sPVar) {
            this.f20292a = sPVar;
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            try {
                this.f20292a.offerFirst(runnable);
                boolean z10 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
            } catch (Throwable unused) {
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class c {

        /* renamed from: a, reason: collision with root package name */
        final boolean f20293a;

        /* renamed from: b, reason: collision with root package name */
        final boolean f20294b;

        /* renamed from: c, reason: collision with root package name */
        final int f20295c;

        /* renamed from: d, reason: collision with root package name */
        final String f20296d;

        /* renamed from: e, reason: collision with root package name */
        final Map f20297e;

        /* renamed from: f, reason: collision with root package name */
        final String[] f20298f;

        c(boolean z10, boolean z11, int i11, String str, Map map, String[] strArr) {
            this.f20293a = z10;
            this.f20294b = z11;
            this.f20295c = i11;
            this.f20296d = str;
            this.f20297e = map;
            this.f20298f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f20293a == cVar.f20293a && this.f20294b == cVar.f20294b && this.f20295c == cVar.f20295c) {
                return this.f20296d.equals(cVar.f20296d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f20293a ? 1 : 0) * 31) + (this.f20294b ? 1 : 0)) * 31) + this.f20295c) * 31) + this.f20296d.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class sP<T> extends LinkedBlockingDeque<T> {
        private ThreadPoolExecutor Sj;

        private sP() {
        }

        /* synthetic */ sP(a aVar) {
            this();
        }

        public void Sj(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                try {
                    if (this.Sj != null) {
                        throw new IllegalStateException("You can only call setExecutor() once!");
                    }
                    if (threadPoolExecutor == null) {
                        throw new NullPointerException("executor argument can't be null!");
                    }
                    this.Sj = threadPoolExecutor;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t11) {
            synchronized (this) {
                int poolSize = this.Sj.getPoolSize();
                int activeCount = this.Sj.getActiveCount();
                int maximumPoolSize = this.Sj.getMaximumPoolSize();
                if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                    return offerFirst(t11);
                }
                boolean z10 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b;
                return false;
            }
        }
    }

    private EjP() {
        SparseArray sparseArray = new SparseArray(2);
        this.f20282b = sparseArray;
        this.f20287g = new HashSet();
        this.f20288h = new a();
        sP sPVar = new sP(null);
        this.f20283c = sPVar;
        ExecutorService d11 = d(sPVar);
        this.f20284d = d11;
        sPVar.Sj((ThreadPoolExecutor) d11);
        sparseArray.put(0, new HashMap());
        sparseArray.put(1, new HashMap());
    }

    private static ExecutorService d(sP sPVar) {
        int i11;
        int a11 = f6.a.a();
        if (a11 <= 0) {
            a11 = 1;
        } else if (a11 > 4) {
            i11 = 4;
            return new ThreadPoolExecutor(0, i11, 60L, TimeUnit.SECONDS, sPVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.EjP.4
                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable) { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.EjP.4.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            try {
                                Process.setThreadPriority(10);
                            } catch (Throwable unused) {
                            }
                            super.run();
                        }
                    };
                    thread.setName("csj_video_preload_" + thread.getId());
                    thread.setDaemon(true);
                    if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                        new StringBuilder("new preload thead: ").append(thread.getName());
                    }
                    return thread;
                }
            }, new b(sPVar));
        }
        i11 = a11;
        return new ThreadPoolExecutor(0, i11, 60L, TimeUnit.SECONDS, sPVar, new ThreadFactory() { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.EjP.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable) { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.EjP.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable unused) {
                        }
                        super.run();
                    }
                };
                thread.setName("csj_video_preload_" + thread.getId());
                thread.setDaemon(true);
                if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                    new StringBuilder("new preload thead: ").append(thread.getName());
                }
                return thread;
            }
        }, new b(sPVar));
    }

    public static EjP j() {
        if (f20280k == null) {
            synchronized (EjP.class) {
                try {
                    if (f20280k == null) {
                        f20280k = new EjP();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f20280k;
    }

    public void a() {
        f6.a.l(new com.bytedance.sdk.component.Dq.Dq("cancelAll") { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.EjP.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bykv.vk.openvk.Sj.Sj.sP.sP.sP> arrayList = new ArrayList();
                synchronized (EjP.this.f20282b) {
                    try {
                        int size = EjP.this.f20282b.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            Map map = (Map) EjP.this.f20282b.get(EjP.this.f20282b.keyAt(i11));
                            if (map != null) {
                                arrayList.addAll(map.values());
                                map.clear();
                            }
                        }
                        EjP.this.f20283c.clear();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                for (com.bykv.vk.openvk.Sj.Sj.sP.sP.sP sPVar : arrayList) {
                    sPVar.Sj();
                    if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + sPVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bykv.vk.openvk.Sj.Sj.sP.sP.c c() {
        return null;
    }

    public void e(String str) {
        i(false, false, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(boolean z10, String str) {
        com.bykv.vk.openvk.Sj.Sj.sP.sP.sP sPVar;
        this.f20289i = str;
        this.f20290j = z10;
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
            "setCurrentPlayKey, ".concat(String.valueOf(str));
        }
        HashSet hashSet = null;
        HashSet hashSet2 = null;
        if (str == null) {
            synchronized (this.f20287g) {
                try {
                    if (!this.f20287g.isEmpty()) {
                        hashSet2 = new HashSet(this.f20287g);
                        this.f20287g.clear();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            if (hashSet2 != null) {
                Iterator it = hashSet2.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    g(cVar.f20293a, cVar.f20294b, cVar.f20295c, cVar.f20296d, cVar.f20297e, cVar.f20298f);
                    if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                        new StringBuilder("setCurrentPlayKey, resume preload: ").append(cVar.f20296d);
                    }
                }
                return;
            }
            return;
        }
        int i11 = com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20323g;
        if (i11 != 3 && i11 != 2) {
            if (i11 == 1) {
                synchronized (this.f20282b) {
                    try {
                        Map map = (Map) this.f20282b.get(sP.f.a(z10));
                        sPVar = map != null ? (com.bykv.vk.openvk.Sj.Sj.sP.sP.sP) map.remove(str) : null;
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                if (sPVar != null) {
                    sPVar.Sj();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.f20282b) {
            try {
                int size = this.f20282b.size();
                for (int i12 = 0; i12 < size; i12++) {
                    SparseArray sparseArray = this.f20282b;
                    Map map2 = (Map) sparseArray.get(sparseArray.keyAt(i12));
                    if (map2 != null) {
                        Collection values = map2.values();
                        if (values != null && !values.isEmpty()) {
                            if (hashSet == null) {
                                hashSet = new HashSet();
                            }
                            hashSet.addAll(values);
                        }
                        map2.clear();
                    }
                }
            } catch (Throwable th4) {
                throw th4;
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            com.bykv.vk.openvk.Sj.Sj.sP.sP.sP sPVar2 = (com.bykv.vk.openvk.Sj.Sj.sP.sP.sP) it2.next();
            sPVar2.Sj();
            if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
                new StringBuilder("setCurrentPlayKey, cancel preload: ").append(sPVar2.Jcg);
            }
        }
        if (i11 == 3) {
            synchronized (this.f20287g) {
                try {
                    Iterator it3 = hashSet.iterator();
                    while (it3.hasNext()) {
                        c cVar2 = (c) ((com.bykv.vk.openvk.Sj.Sj.sP.sP.sP) it3.next()).sef;
                        if (cVar2 != null) {
                            this.f20287g.add(cVar2);
                        }
                    }
                } catch (Throwable th5) {
                    throw th5;
                }
            }
        }
    }

    public void g(boolean z10, boolean z11, int i11, String str, Map map, String... strArr) {
        if (com.bykv.vk.openvk.Sj.Sj.sP.sP.a.f20318b) {
            Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
        }
    }

    public void h(boolean z10, boolean z11, int i11, String str, String... strArr) {
        g(z10, z11, i11, str, null, strArr);
    }

    public void i(final boolean z10, final boolean z11, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f6.a.l(new com.bytedance.sdk.component.Dq.Dq("cancel b b S") { // from class: com.bykv.vk.openvk.Sj.Sj.sP.sP.EjP.2
            @Override // java.lang.Runnable
            public void run() {
                com.bykv.vk.openvk.Sj.Sj.sP.sP.sP sPVar;
                synchronized (EjP.this.f20282b) {
                    try {
                        Map map = (Map) EjP.this.f20282b.get(sP.f.a(z10));
                        if (map != null) {
                            sPVar = (com.bykv.vk.openvk.Sj.Sj.sP.sP.sP) map.remove(z11 ? str : w5.c.a(str));
                        } else {
                            sPVar = null;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (sPVar != null) {
                    sPVar.Sj();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bykv.vk.openvk.Sj.Sj.sP.sP.c l() {
        return null;
    }
}

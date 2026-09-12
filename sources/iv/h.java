package iv;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.http.b0;
import com.transsion.transfer.androidasync.http.server.AsyncHttpServer;
import com.transsion.transfer.impl.PingPongHelper;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.i;
import iv.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class h implements com.transsion.transfer.impl.h {

    /* renamed from: s, reason: collision with root package name */
    public static final a f65759s = new a(null);

    /* renamed from: t, reason: collision with root package name */
    private static final String f65760t = h.class.getName();

    /* renamed from: u, reason: collision with root package name */
    private static volatile com.transsion.transfer.impl.h f65761u;

    /* renamed from: a, reason: collision with root package name */
    private final Context f65762a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f65763b;

    /* renamed from: c, reason: collision with root package name */
    private String f65764c;

    /* renamed from: d, reason: collision with root package name */
    private com.transsion.transfer.impl.g f65765d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f65766e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f65767f;

    /* renamed from: g, reason: collision with root package name */
    private d f65768g;

    /* renamed from: h, reason: collision with root package name */
    private final AsyncHttpServer f65769h;

    /* renamed from: i, reason: collision with root package name */
    private final CopyOnWriteArrayList f65770i;

    /* renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArrayList f65771j;

    /* renamed from: k, reason: collision with root package name */
    private final Lazy f65772k;

    /* renamed from: l, reason: collision with root package name */
    private final PingPongHelper.a f65773l;

    /* renamed from: m, reason: collision with root package name */
    private final Runnable f65774m;

    /* renamed from: n, reason: collision with root package name */
    private final ConcurrentHashMap f65775n;

    /* renamed from: o, reason: collision with root package name */
    private final ConcurrentHashMap f65776o;

    /* renamed from: p, reason: collision with root package name */
    private final ConcurrentHashMap f65777p;

    /* renamed from: q, reason: collision with root package name */
    private final ConcurrentHashMap f65778q;

    /* renamed from: r, reason: collision with root package name */
    private final CopyOnWriteArrayList f65779r;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            com.transsion.transfer.impl.h hVar = h.f65761u;
            if (hVar != null) {
                hVar.d();
            }
            h.f65761u = null;
        }

        public final com.transsion.transfer.impl.h b(Context context) {
            Intrinsics.h(context, "context");
            com.transsion.transfer.impl.h hVar = h.f65761u;
            if (hVar == null) {
                synchronized (this) {
                    hVar = new h(context, null);
                    h.f65761u = hVar;
                }
            }
            return hVar;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements i {
        b() {
        }

        @Override // com.transsion.transfer.impl.i
        public void K(String clientIp, String remoteFilePath, TaskState state, long j11, long j12) {
            Object obj;
            Object obj2;
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            Intrinsics.h(state, "state");
            Iterator it = mv.b.f70138a.d().iterator();
            while (true) {
                obj = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                } else {
                    obj2 = it.next();
                    if (Intrinsics.c(remoteFilePath, ((FileData) obj2).getFileRemotePath())) {
                        break;
                    }
                }
            }
            FileData fileData = (FileData) obj2;
            if (fileData != null) {
                h hVar = h.this;
                if (fileData.getState() != 5 && fileData.getState() != 6 && fileData.getState() != 3 && fileData.getState() != 4) {
                    fileData.setState(FileData.INSTANCE.a(state));
                    fileData.setDownloadSize(j11);
                    fileData.setFileSize(j12);
                }
                Iterator it2 = hVar.f65770i.iterator();
                while (it2.hasNext()) {
                    ((i) it2.next()).K(clientIp, remoteFilePath, state, j11, j12);
                }
            }
            Iterator it3 = mv.b.f70138a.d().iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                Object next = it3.next();
                if (Intrinsics.c(remoteFilePath, ((FileData) next).getCoverUrl())) {
                    obj = next;
                    break;
                }
            }
            if (((FileData) obj) != null) {
                Iterator it4 = h.this.f65770i.iterator();
                while (it4.hasNext()) {
                    ((i) it4.next()).K(clientIp, remoteFilePath, state, j11, j12);
                }
            }
        }

        @Override // com.transsion.transfer.impl.i
        public void d(String clientIp) {
            Intrinsics.h(clientIp, "clientIp");
            Iterator it = h.this.f65770i.iterator();
            while (it.hasNext()) {
                ((i) it.next()).d(clientIp);
            }
        }

        @Override // com.transsion.transfer.impl.i
        public void h(String clientIp, String remoteFilePath, long j11, long j12) {
            Object obj;
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(remoteFilePath, "remoteFilePath");
            Iterator it = mv.b.f70138a.d().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it.next();
                    if (Intrinsics.c(((FileData) obj).getFileRemotePath(), remoteFilePath)) {
                        break;
                    }
                }
            }
            FileData fileData = (FileData) obj;
            if (fileData != null) {
                fileData.setState(2);
                fileData.setDownloadSize(j11);
                fileData.setFileSize(j12);
            }
            Iterator it2 = h.this.f65770i.iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).h(clientIp, remoteFilePath, j11, j12);
            }
        }

        @Override // com.transsion.transfer.impl.i
        public void m(String clientIp) {
            Object obj;
            Intrinsics.h(clientIp, "clientIp");
            Iterator it = h.this.f65770i.iterator();
            while (it.hasNext()) {
                ((i) it.next()).m(clientIp);
            }
            Iterator it2 = mv.b.f70138a.d().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                } else {
                    obj = it2.next();
                    if (((FileData) obj).getState() == 2) {
                        break;
                    }
                }
            }
            FileData fileData = (FileData) obj;
            if (fileData != null) {
                fileData.setState(4);
            }
        }

        @Override // com.transsion.transfer.impl.i
        public void n(String clientIp, List files) {
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(files, "files");
            Iterator it = h.this.f65770i.iterator();
            while (it.hasNext()) {
                ((i) it.next()).n(clientIp, files);
            }
        }

        @Override // com.transsion.transfer.impl.i
        public void p(String clientIp) {
            Intrinsics.h(clientIp, "clientIp");
            for (FileData fileData : mv.b.f70138a.d()) {
                if (fileData.getState() != 4 && fileData.getState() != 3 && fileData.getState() != 7) {
                    fileData.setState(5);
                }
            }
            b0 b0Var = (b0) h.this.f65775n.get(clientIp);
            if (b0Var != null) {
                b0Var.close();
            }
            Iterator it = h.this.f65770i.iterator();
            while (it.hasNext()) {
                ((i) it.next()).p(clientIp);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class c implements PingPongHelper.a {
        c() {
        }

        @Override // com.transsion.transfer.impl.PingPongHelper.a
        public void a(String remoteIp, b0 socket) {
            Intrinsics.h(remoteIp, "remoteIp");
            Intrinsics.h(socket, "socket");
            String unused = h.f65760t;
            int hashCode = h.this.hashCode();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("server detach socket has closed, clientIp: ");
            sb2.append(remoteIp);
            sb2.append(", ");
            sb2.append(hashCode);
            sb2.append(", delay check again");
            if (h.this.f65766e) {
                h.this.f65779r.add(remoteIp);
                h.this.f65767f.postDelayed(h.this.f65774m, 3000L);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static final class d implements com.transsion.transfer.impl.g {
        d() {
        }

        @Override // com.transsion.transfer.impl.g
        public void a(String clientIp, String clientDeviceName) {
            Intrinsics.h(clientIp, "clientIp");
            Intrinsics.h(clientDeviceName, "clientDeviceName");
            String unused = h.f65760t;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("notifyClientInfoUpdate:clientIp:");
            sb2.append(clientIp);
            sb2.append(", clientDeviceName:");
            sb2.append(clientDeviceName);
            com.transsion.transfer.impl.g gVar = h.this.f65765d;
            if (gVar != null) {
                gVar.a(clientIp, clientDeviceName);
            }
        }

        @Override // com.transsion.transfer.impl.g
        public String b() {
            String b11;
            com.transsion.transfer.impl.g gVar = h.this.f65765d;
            if (gVar != null && (b11 = gVar.b()) != null) {
                return b11;
            }
            String MODEL = Build.MODEL;
            Intrinsics.g(MODEL, "MODEL");
            return MODEL;
        }
    }

    private h(Context context) {
        this.f65762a = context;
        this.f65764c = "";
        this.f65767f = new Handler(Looper.getMainLooper());
        this.f65768g = new d();
        AsyncHttpServer asyncHttpServer = new AsyncHttpServer();
        asyncHttpServer.j("/pingpong*", "socket_connect", new AsyncHttpServer.a() { // from class: iv.d
            @Override // com.transsion.transfer.androidasync.http.server.AsyncHttpServer.a
            public final void a(b0 b0Var, com.transsion.transfer.androidasync.http.server.b bVar) {
                h.C(h.this, b0Var, bVar);
            }
        });
        this.f65769h = asyncHttpServer;
        this.f65770i = new CopyOnWriteArrayList();
        this.f65771j = new CopyOnWriteArrayList();
        this.f65772k = LazyKt.b(new Function0() { // from class: iv.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                c z10;
                z10 = h.z(h.this);
                return z10;
            }
        });
        this.f65773l = new c();
        this.f65774m = new Runnable() { // from class: iv.f
            @Override // java.lang.Runnable
            public final void run() {
                h.y(h.this);
            }
        };
        this.f65775n = new ConcurrentHashMap();
        this.f65776o = new ConcurrentHashMap();
        this.f65777p = new ConcurrentHashMap();
        this.f65778q = new ConcurrentHashMap();
        this.f65779r = new CopyOnWriteArrayList();
    }

    public /* synthetic */ h(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final iv.c A() {
        return (iv.c) this.f65772k.getValue();
    }

    private final void B(String str) {
        b0 b0Var = (b0) this.f65775n.get(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notifyClientCMD: clientIp:");
        sb2.append(str);
        sb2.append(" , socket:");
        sb2.append(b0Var);
        if (b0Var != null) {
            b0Var.send("cmd=-2?deviceName=" + jv.a.b(this.f65768g.b()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(final h hVar, final b0 b0Var, com.transsion.transfer.androidasync.http.server.b bVar) {
        b0 b0Var2;
        final String string = bVar.h().getString("clientIp");
        final String string2 = bVar.h().getString("transferId");
        Intrinsics.e(string2);
        hVar.f65764c = string2;
        String string3 = bVar.h().getString("deviceName");
        Intrinsics.g(string3, "getString(...)");
        String a11 = jv.a.a(string3);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("find client connect, clientIp:");
        sb2.append(string);
        sb2.append(", clientDeviceName");
        sb2.append(a11);
        sb2.append(", transferId:");
        sb2.append(string2);
        int size = hVar.f65775n.size();
        ConcurrentHashMap concurrentHashMap = hVar.f65775n;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("find client connect, clientSocketMap: ");
        sb3.append(size);
        sb3.append(", ");
        sb3.append(concurrentHashMap);
        hVar.f65779r.remove(string);
        hVar.f65766e = true;
        hVar.f65767f.removeCallbacks(hVar.f65774m);
        if (hVar.f65775n.contains(string) && (b0Var2 = (b0) hVar.f65775n.remove(string)) != null) {
            PingPongHelper.a aVar = (PingPongHelper.a) hVar.f65777p.remove(b0Var2);
            if (aVar != null) {
                Intrinsics.e(string);
                aVar.a(string, b0Var2);
            }
            b0Var2.close();
        }
        int size2 = hVar.f65771j.size();
        CopyOnWriteArrayList copyOnWriteArrayList = hVar.f65771j;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("find client connect, clientConnectListeners:");
        sb4.append(size2);
        sb4.append(", ");
        sb4.append(copyOnWriteArrayList);
        sb4.append(" , ");
        sb4.append(hVar);
        for (Function4 function4 : hVar.f65771j) {
            Intrinsics.e(string);
            Intrinsics.e(string2);
            function4.invoke(string, string2, Boolean.TRUE, null);
        }
        hVar.f65776o.put(string, a11);
        hVar.f65775n.put(string, b0Var);
        d dVar = hVar.f65768g;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("find client connect, proxyFileHandler:");
        sb5.append(dVar);
        d dVar2 = hVar.f65768g;
        Intrinsics.e(string);
        dVar2.a(string, a11);
        ConcurrentHashMap concurrentHashMap2 = hVar.f65778q;
        Intrinsics.e(b0Var);
        PingPongHelper pingPongHelper = new PingPongHelper(string, true, b0Var, hVar.f65773l);
        pingPongHelper.n();
        concurrentHashMap2.put(b0Var, pingPongHelper);
        b0Var.p(new bv.a() { // from class: iv.g
            @Override // bv.a
            public final void g(Exception exc) {
                h.D(string, hVar, b0Var, string2, exc);
            }
        });
        hVar.B(string);
        hVar.f65763b = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(String str, h hVar, b0 b0Var, String str2, Exception exc) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("server socket close callback ip: ");
        sb2.append(str);
        PingPongHelper.a aVar = hVar.f65773l;
        Intrinsics.e(str);
        Intrinsics.e(b0Var);
        aVar.a(str, b0Var);
        for (Function4 function4 : hVar.f65771j) {
            Intrinsics.e(str2);
            function4.invoke(str, str2, Boolean.FALSE, "normal");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(h hVar) {
        if (hVar.f65779r.isEmpty()) {
            return;
        }
        for (i iVar : hVar.f65770i) {
            String str = (String) CollectionsKt.i0(hVar.f65779r);
            if (str == null) {
                str = "";
            }
            iVar.p(str);
        }
        f65759s.a();
        hVar.f65766e = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final iv.c z(h hVar) {
        return new iv.c(hVar.f65768g, new b());
    }

    @Override // com.transsion.transfer.impl.h
    public void a(i listener) {
        Intrinsics.h(listener, "listener");
        this.f65770i.remove(listener);
        this.f65770i.add(listener);
    }

    @Override // com.transsion.transfer.impl.h
    public void b(Function4 listener) {
        Intrinsics.h(listener, "listener");
        this.f65771j.remove(listener);
        this.f65771j.add(listener);
    }

    @Override // com.transsion.transfer.impl.h
    public List c() {
        Set keySet = this.f65775n.keySet();
        Intrinsics.g(keySet, "<get-keys>(...)");
        return CollectionsKt.U0(CollectionsKt.R0(keySet));
    }

    @Override // com.transsion.transfer.impl.h
    public void d() {
        for (Map.Entry entry : this.f65775n.entrySet()) {
            ((b0) entry.getValue()).send("cmd=-1");
            ((b0) entry.getValue()).close();
        }
        this.f65775n.clear();
        this.f65776o.clear();
        this.f65777p.clear();
        for (Map.Entry entry2 : this.f65778q.entrySet()) {
            ((b0) entry2.getKey()).close();
            ((PingPongHelper) entry2.getValue()).o();
        }
        this.f65778q.clear();
        this.f65771j.clear();
        AsyncServer.r().L();
        this.f65769h.u();
        this.f65763b = false;
    }

    @Override // com.transsion.transfer.impl.h
    public void e(com.transsion.transfer.impl.g gVar) {
        this.f65765d = gVar;
    }

    @Override // com.transsion.transfer.impl.h
    public void f(String clientIp, int i11) {
        Intrinsics.h(clientIp, "clientIp");
        b0 b0Var = (b0) this.f65775n.get(clientIp);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notifyClientCMD: clientIp:");
        sb2.append(clientIp);
        sb2.append(" , socket:");
        sb2.append(b0Var);
        sb2.append(", cmd:");
        sb2.append(i11);
        if (b0Var != null) {
            b0Var.send("cmd=" + i11);
        }
    }

    @Override // com.transsion.transfer.impl.h
    public void g(i listener) {
        Intrinsics.h(listener, "listener");
        this.f65770i.remove(listener);
    }

    @Override // com.transsion.transfer.impl.h
    public void h(Function4 listener) {
        Intrinsics.h(listener, "listener");
        this.f65771j.remove(listener);
    }

    @Override // com.transsion.transfer.impl.h
    public List i() {
        Collection values = this.f65776o.values();
        Intrinsics.g(values, "<get-values>(...)");
        return CollectionsKt.U0(CollectionsKt.R0(values));
    }

    @Override // com.transsion.transfer.impl.h
    public boolean isRunning() {
        return this.f65763b;
    }

    @Override // com.transsion.transfer.impl.h
    public String j() {
        return this.f65764c;
    }

    @Override // com.transsion.transfer.impl.h
    public void open() {
        if (this.f65763b) {
            return;
        }
        for (c.b bVar : A().e()) {
            String a11 = bVar.a();
            String b11 = bVar.b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("open: ");
            sb2.append(a11);
            sb2.append(", ");
            sb2.append(b11);
            if (Intrinsics.c(bVar.a(), "get")) {
                this.f65769h.f(bVar.b(), bVar.c());
            } else if (Intrinsics.c(bVar.a(), "post")) {
                this.f65769h.i(bVar.b(), bVar.c());
            }
        }
        this.f65769h.o(AsyncServer.r(), 9890);
    }
}

package com.google.firebase;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import androidx.compose.animation.core.j0;
import androidx.core.os.t;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.concurrent.UiExecutor;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import mb.o;
import mb.u;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: k, reason: collision with root package name */
    private static final Object f31897k = new Object();

    /* renamed from: l, reason: collision with root package name */
    static final Map f31898l = new androidx.collection.a();

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f31899m = 0;

    /* renamed from: a, reason: collision with root package name */
    private final Context f31900a;

    /* renamed from: b, reason: collision with root package name */
    private final String f31901b;

    /* renamed from: c, reason: collision with root package name */
    private final m f31902c;

    /* renamed from: d, reason: collision with root package name */
    private final mb.o f31903d;

    /* renamed from: g, reason: collision with root package name */
    private final u f31906g;

    /* renamed from: h, reason: collision with root package name */
    private final ic.b f31907h;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f31904e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private final AtomicBoolean f31905f = new AtomicBoolean();

    /* renamed from: i, reason: collision with root package name */
    private final List f31908i = new CopyOnWriteArrayList();

    /* renamed from: j, reason: collision with root package name */
    private final List f31909j = new CopyOnWriteArrayList();

    /* loaded from: classes4.dex */
    public interface a {
        void onBackgroundStateChanged(boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class b implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private static AtomicReference f31910a = new AtomicReference();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (PlatformVersion.isAtLeastIceCreamSandwich() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f31910a.get() == null) {
                    b bVar = new b();
                    if (j0.a(f31910a, null, bVar)) {
                        BackgroundDetector.initialize(application);
                        BackgroundDetector.getInstance().addListener(bVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z10) {
            synchronized (f.f31897k) {
                try {
                    Iterator it = new ArrayList(f.f31898l.values()).iterator();
                    while (it.hasNext()) {
                        f fVar = (f) it.next();
                        if (fVar.f31904e.get()) {
                            fVar.y(z10);
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class c extends BroadcastReceiver {

        /* renamed from: b, reason: collision with root package name */
        private static AtomicReference f31911b = new AtomicReference();

        /* renamed from: a, reason: collision with root package name */
        private final Context f31912a;

        public c(Context context) {
            this.f31912a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f31911b.get() == null) {
                c cVar = new c(context);
                if (j0.a(f31911b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f31912a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (f.f31897k) {
                try {
                    Iterator it = f.f31898l.values().iterator();
                    while (it.hasNext()) {
                        ((f) it.next()).p();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            c();
        }
    }

    protected f(final Context context, String str, m mVar) {
        this.f31900a = (Context) Preconditions.checkNotNull(context);
        this.f31901b = Preconditions.checkNotEmpty(str);
        this.f31902c = (m) Preconditions.checkNotNull(mVar);
        n b11 = FirebaseInitProvider.b();
        cd.c.b("Firebase");
        cd.c.b("ComponentDiscovery");
        List b12 = mb.g.c(context, ComponentDiscoveryService.class).b();
        cd.c.a();
        cd.c.b("Runtime");
        o.b g11 = mb.o.m(UiExecutor.INSTANCE).d(b12).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(mb.c.s(context, Context.class, new Class[0])).b(mb.c.s(this, f.class, new Class[0])).b(mb.c.s(mVar, m.class, new Class[0])).g(new cd.b());
        if (t.a(context) && FirebaseInitProvider.c()) {
            g11.b(mb.c.s(b11, n.class, new Class[0]));
        }
        mb.o e11 = g11.e();
        this.f31903d = e11;
        cd.c.a();
        this.f31906g = new u(new ic.b() { // from class: com.google.firebase.d
            @Override // ic.b
            public final Object get() {
                mc.a v11;
                v11 = f.this.v(context);
                return v11;
            }
        });
        this.f31907h = e11.f(com.google.firebase.heartbeatinfo.a.class);
        g(new a() { // from class: com.google.firebase.e
            @Override // com.google.firebase.f.a
            public final void onBackgroundStateChanged(boolean z10) {
                f.this.w(z10);
            }
        });
        cd.c.a();
    }

    private void i() {
        Preconditions.checkState(!this.f31905f.get(), "FirebaseApp was deleted");
    }

    public static f l() {
        f fVar;
        synchronized (f31897k) {
            try {
                fVar = (f) f31898l.get("[DEFAULT]");
                if (fVar == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + ProcessUtils.getMyProcessName() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((com.google.firebase.heartbeatinfo.a) fVar.f31907h.get()).l();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (!t.a(this.f31900a)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Device in Direct Boot Mode: postponing initialization of Firebase APIs for app ");
            sb2.append(m());
            c.b(this.f31900a);
            return;
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("Device unlocked: initializing all Firebase APIs for app ");
        sb3.append(m());
        this.f31903d.p(u());
        ((com.google.firebase.heartbeatinfo.a) this.f31907h.get()).l();
    }

    public static f q(Context context) {
        synchronized (f31897k) {
            try {
                if (f31898l.containsKey("[DEFAULT]")) {
                    return l();
                }
                m a11 = m.a(context);
                if (a11 == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return r(context, a11);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static f r(Context context, m mVar) {
        return s(context, mVar, "[DEFAULT]");
    }

    public static f s(Context context, m mVar, String str) {
        f fVar;
        b.b(context);
        String x10 = x(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f31897k) {
            Map map = f31898l;
            Preconditions.checkState(!map.containsKey(x10), "FirebaseApp name " + x10 + " already exists!");
            Preconditions.checkNotNull(context, "Application context cannot be null.");
            fVar = new f(context, x10, mVar);
            map.put(x10, fVar);
        }
        fVar.p();
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ mc.a v(Context context) {
        return new mc.a(context, o(), (fc.c) this.f31903d.a(fc.c.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(boolean z10) {
        if (z10) {
            return;
        }
        ((com.google.firebase.heartbeatinfo.a) this.f31907h.get()).l();
    }

    private static String x(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y(boolean z10) {
        Iterator it = this.f31908i.iterator();
        while (it.hasNext()) {
            ((a) it.next()).onBackgroundStateChanged(z10);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f31901b.equals(((f) obj).m());
        }
        return false;
    }

    public void g(a aVar) {
        i();
        if (this.f31904e.get() && BackgroundDetector.getInstance().isInBackground()) {
            aVar.onBackgroundStateChanged(true);
        }
        this.f31908i.add(aVar);
    }

    public void h(g gVar) {
        i();
        Preconditions.checkNotNull(gVar);
        this.f31909j.add(gVar);
    }

    public int hashCode() {
        return this.f31901b.hashCode();
    }

    public Object j(Class cls) {
        i();
        return this.f31903d.a(cls);
    }

    public Context k() {
        i();
        return this.f31900a;
    }

    public String m() {
        i();
        return this.f31901b;
    }

    public m n() {
        i();
        return this.f31902c;
    }

    public String o() {
        return Base64Utils.encodeUrlSafeNoPadding(m().getBytes(Charset.defaultCharset())) + "+" + Base64Utils.encodeUrlSafeNoPadding(n().c().getBytes(Charset.defaultCharset()));
    }

    public boolean t() {
        i();
        return ((mc.a) this.f31906g.get()).b();
    }

    public String toString() {
        return Objects.toStringHelper(this).add("name", this.f31901b).add("options", this.f31902c).toString();
    }

    public boolean u() {
        return "[DEFAULT]".equals(m());
    }
}

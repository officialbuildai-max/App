package com.google.firebase.installations;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.local.PersistedInstallation;
import com.google.firebase.installations.remote.InstallationResponse;
import com.google.firebase.installations.remote.TokenResult;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import mb.u;

/* loaded from: classes4.dex */
public class c implements jc.e {

    /* renamed from: m, reason: collision with root package name */
    private static final Object f31938m = new Object();

    /* renamed from: n, reason: collision with root package name */
    private static final ThreadFactory f31939n = new a();

    /* renamed from: a, reason: collision with root package name */
    private final com.google.firebase.f f31940a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.firebase.installations.remote.c f31941b;

    /* renamed from: c, reason: collision with root package name */
    private final PersistedInstallation f31942c;

    /* renamed from: d, reason: collision with root package name */
    private final h f31943d;

    /* renamed from: e, reason: collision with root package name */
    private final u f31944e;

    /* renamed from: f, reason: collision with root package name */
    private final jc.g f31945f;

    /* renamed from: g, reason: collision with root package name */
    private final Object f31946g;

    /* renamed from: h, reason: collision with root package name */
    private final ExecutorService f31947h;

    /* renamed from: i, reason: collision with root package name */
    private final Executor f31948i;

    /* renamed from: j, reason: collision with root package name */
    private String f31949j;

    /* renamed from: k, reason: collision with root package name */
    private Set f31950k;

    /* renamed from: l, reason: collision with root package name */
    private final List f31951l;

    /* loaded from: classes4.dex */
    class a implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicInteger f31952a = new AtomicInteger(1);

        a() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f31952a.getAndIncrement())));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f31953a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f31954b;

        static {
            int[] iArr = new int[TokenResult.ResponseCode.values().length];
            f31954b = iArr;
            try {
                iArr[TokenResult.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31954b[TokenResult.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31954b[TokenResult.ResponseCode.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[InstallationResponse.ResponseCode.values().length];
            f31953a = iArr2;
            try {
                iArr2[InstallationResponse.ResponseCode.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f31953a[InstallationResponse.ResponseCode.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(final com.google.firebase.f fVar, ic.b bVar, ExecutorService executorService, Executor executor) {
        this(executorService, executor, fVar, new com.google.firebase.installations.remote.c(fVar.k(), bVar), new PersistedInstallation(fVar), h.c(), new u(new ic.b() { // from class: jc.a
            @Override // ic.b
            public final Object get() {
                kc.a y10;
                y10 = com.google.firebase.installations.c.y(com.google.firebase.f.this);
                return y10;
            }
        }), new jc.g());
    }

    c(ExecutorService executorService, Executor executor, com.google.firebase.f fVar, com.google.firebase.installations.remote.c cVar, PersistedInstallation persistedInstallation, h hVar, u uVar, jc.g gVar) {
        this.f31946g = new Object();
        this.f31950k = new HashSet();
        this.f31951l = new ArrayList();
        this.f31940a = fVar;
        this.f31941b = cVar;
        this.f31942c = persistedInstallation;
        this.f31943d = hVar;
        this.f31944e = uVar;
        this.f31945f = gVar;
        this.f31947h = executorService;
        this.f31948i = executor;
    }

    private String A(com.google.firebase.installations.local.b bVar) {
        if ((!this.f31940a.m().equals("CHIME_ANDROID_SDK") && !this.f31940a.u()) || !bVar.m()) {
            return this.f31945f.a();
        }
        String f11 = o().f();
        return TextUtils.isEmpty(f11) ? this.f31945f.a() : f11;
    }

    private com.google.firebase.installations.local.b B(com.google.firebase.installations.local.b bVar) {
        InstallationResponse d11 = this.f31941b.d(l(), bVar.d(), t(), m(), (bVar.d() == null || bVar.d().length() != 11) ? null : o().i());
        int i11 = b.f31953a[d11.e().ordinal()];
        if (i11 == 1) {
            return bVar.s(d11.c(), d11.d(), this.f31943d.b(), d11.b().c(), d11.b().d());
        }
        if (i11 == 2) {
            return bVar.q("BAD CONFIG");
        }
        throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
    }

    private void C(Exception exc) {
        synchronized (this.f31946g) {
            try {
                Iterator it = this.f31951l.iterator();
                while (it.hasNext()) {
                    if (((g) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private void D(com.google.firebase.installations.local.b bVar) {
        synchronized (this.f31946g) {
            try {
                Iterator it = this.f31951l.iterator();
                while (it.hasNext()) {
                    if (((g) it.next()).b(bVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private synchronized void E(String str) {
        this.f31949j = str;
    }

    private synchronized void F(com.google.firebase.installations.local.b bVar, com.google.firebase.installations.local.b bVar2) {
        if (this.f31950k.size() != 0 && !TextUtils.equals(bVar.d(), bVar2.d())) {
            Iterator it = this.f31950k.iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.c.a(it.next());
                bVar2.d();
                throw null;
            }
        }
    }

    private Task f() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new d(this.f31943d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private Task g() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new e(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    private void h(g gVar) {
        synchronized (this.f31946g) {
            this.f31951l.add(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004c  */
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void v(boolean r3) {
        /*
            r2 = this;
            com.google.firebase.installations.local.b r0 = r2.r()
            boolean r1 = r0.i()     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L1d
            if (r1 != 0) goto L24
            boolean r1 = r0.l()     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L1d
            if (r1 == 0) goto L11
            goto L24
        L11:
            if (r3 != 0) goto L1f
            com.google.firebase.installations.h r3 = r2.f31943d     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L1d
            boolean r3 = r3.f(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L1d
            if (r3 == 0) goto L1c
            goto L1f
        L1c:
            return
        L1d:
            r3 = move-exception
            goto L61
        L1f:
            com.google.firebase.installations.local.b r3 = r2.k(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L1d
            goto L28
        L24:
            com.google.firebase.installations.local.b r3 = r2.B(r0)     // Catch: com.google.firebase.installations.FirebaseInstallationsException -> L1d
        L28:
            r2.u(r3)
            r2.F(r0, r3)
            boolean r0 = r3.k()
            if (r0 == 0) goto L3b
            java.lang.String r0 = r3.d()
            r2.E(r0)
        L3b:
            boolean r0 = r3.i()
            if (r0 == 0) goto L4c
            com.google.firebase.installations.FirebaseInstallationsException r3 = new com.google.firebase.installations.FirebaseInstallationsException
            com.google.firebase.installations.FirebaseInstallationsException$Status r0 = com.google.firebase.installations.FirebaseInstallationsException.Status.BAD_CONFIG
            r3.<init>(r0)
            r2.C(r3)
            goto L60
        L4c:
            boolean r0 = r3.j()
            if (r0 == 0) goto L5d
            java.io.IOException r3 = new java.io.IOException
            java.lang.String r0 = "Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request."
            r3.<init>(r0)
            r2.C(r3)
            goto L60
        L5d:
            r2.D(r3)
        L60:
            return
        L61:
            r2.C(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.installations.c.v(boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void x(final boolean z10) {
        com.google.firebase.installations.local.b s11 = s();
        if (z10) {
            s11 = s11.p();
        }
        D(s11);
        this.f31948i.execute(new Runnable() { // from class: jc.d
            @Override // java.lang.Runnable
            public final void run() {
                com.google.firebase.installations.c.this.v(z10);
            }
        });
    }

    private com.google.firebase.installations.local.b k(com.google.firebase.installations.local.b bVar) {
        TokenResult e11 = this.f31941b.e(l(), bVar.d(), t(), bVar.f());
        int i11 = b.f31954b[e11.b().ordinal()];
        if (i11 == 1) {
            return bVar.o(e11.c(), e11.d(), this.f31943d.b());
        }
        if (i11 == 2) {
            return bVar.q("BAD CONFIG");
        }
        if (i11 != 3) {
            throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
        }
        E(null);
        return bVar.r();
    }

    private synchronized String n() {
        return this.f31949j;
    }

    private kc.a o() {
        return (kc.a) this.f31944e.get();
    }

    public static c p() {
        return q(com.google.firebase.f.l());
    }

    public static c q(com.google.firebase.f fVar) {
        Preconditions.checkArgument(fVar != null, "Null is not a valid value of FirebaseApp.");
        return (c) fVar.j(jc.e.class);
    }

    /* JADX WARN: Finally extract failed */
    private com.google.firebase.installations.local.b r() {
        com.google.firebase.installations.local.b d11;
        synchronized (f31938m) {
            try {
                com.google.firebase.installations.b a11 = com.google.firebase.installations.b.a(this.f31940a.k(), "generatefid.lock");
                try {
                    d11 = this.f31942c.d();
                    if (a11 != null) {
                        a11.b();
                    }
                } catch (Throwable th2) {
                    if (a11 != null) {
                        a11.b();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return d11;
    }

    /* JADX WARN: Finally extract failed */
    private com.google.firebase.installations.local.b s() {
        com.google.firebase.installations.local.b d11;
        synchronized (f31938m) {
            try {
                com.google.firebase.installations.b a11 = com.google.firebase.installations.b.a(this.f31940a.k(), "generatefid.lock");
                try {
                    d11 = this.f31942c.d();
                    if (d11.j()) {
                        d11 = this.f31942c.b(d11.t(A(d11)));
                    }
                    if (a11 != null) {
                        a11.b();
                    }
                } catch (Throwable th2) {
                    if (a11 != null) {
                        a11.b();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return d11;
    }

    /* JADX WARN: Finally extract failed */
    private void u(com.google.firebase.installations.local.b bVar) {
        synchronized (f31938m) {
            try {
                com.google.firebase.installations.b a11 = com.google.firebase.installations.b.a(this.f31940a.k(), "generatefid.lock");
                try {
                    this.f31942c.b(bVar);
                    if (a11 != null) {
                        a11.b();
                    }
                } catch (Throwable th2) {
                    if (a11 != null) {
                        a11.b();
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w() {
        x(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ kc.a y(com.google.firebase.f fVar) {
        return new kc.a(fVar);
    }

    private void z() {
        Preconditions.checkNotEmpty(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkNotEmpty(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(h.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        Preconditions.checkArgument(h.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    @Override // jc.e
    public Task a(final boolean z10) {
        z();
        Task f11 = f();
        this.f31947h.execute(new Runnable() { // from class: jc.c
            @Override // java.lang.Runnable
            public final void run() {
                com.google.firebase.installations.c.this.x(z10);
            }
        });
        return f11;
    }

    @Override // jc.e
    public Task getId() {
        z();
        String n11 = n();
        if (n11 != null) {
            return Tasks.forResult(n11);
        }
        Task g11 = g();
        this.f31947h.execute(new Runnable() { // from class: jc.b
            @Override // java.lang.Runnable
            public final void run() {
                com.google.firebase.installations.c.this.w();
            }
        });
        return g11;
    }

    String l() {
        return this.f31940a.n().b();
    }

    String m() {
        return this.f31940a.n().c();
    }

    String t() {
        return this.f31940a.n().e();
    }
}

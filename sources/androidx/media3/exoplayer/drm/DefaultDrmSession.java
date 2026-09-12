package androidx.media3.exoplayer.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.b0;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.upstream.m;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import y1.f4;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class DefaultDrmSession implements DrmSession {

    /* renamed from: a, reason: collision with root package name */
    public final List f11569a;

    /* renamed from: b, reason: collision with root package name */
    private final b0 f11570b;

    /* renamed from: c, reason: collision with root package name */
    private final a f11571c;

    /* renamed from: d, reason: collision with root package name */
    private final b f11572d;

    /* renamed from: e, reason: collision with root package name */
    private final int f11573e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f11574f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f11575g;

    /* renamed from: h, reason: collision with root package name */
    private final HashMap f11576h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.media3.common.util.n f11577i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f11578j;

    /* renamed from: k, reason: collision with root package name */
    private final f4 f11579k;

    /* renamed from: l, reason: collision with root package name */
    private final m0 f11580l;

    /* renamed from: m, reason: collision with root package name */
    private final UUID f11581m;

    /* renamed from: n, reason: collision with root package name */
    private final Looper f11582n;

    /* renamed from: o, reason: collision with root package name */
    private final e f11583o;

    /* renamed from: p, reason: collision with root package name */
    private int f11584p;

    /* renamed from: q, reason: collision with root package name */
    private int f11585q;

    /* renamed from: r, reason: collision with root package name */
    private HandlerThread f11586r;

    /* renamed from: s, reason: collision with root package name */
    private c f11587s;

    /* renamed from: t, reason: collision with root package name */
    private androidx.media3.decoder.b f11588t;

    /* renamed from: u, reason: collision with root package name */
    private DrmSession.DrmSessionException f11589u;

    /* renamed from: v, reason: collision with root package name */
    private byte[] f11590v;

    /* renamed from: w, reason: collision with root package name */
    private byte[] f11591w;

    /* renamed from: x, reason: collision with root package name */
    private b0.a f11592x;

    /* renamed from: y, reason: collision with root package name */
    private b0.d f11593y;

    /* loaded from: classes2.dex */
    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th2) {
            super(th2);
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a(Exception exc, boolean z10);

        void b(DefaultDrmSession defaultDrmSession);

        void onProvisionCompleted();
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(DefaultDrmSession defaultDrmSession, int i11);

        void b(DefaultDrmSession defaultDrmSession, int i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private boolean f11594a;

        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            d dVar = (d) message.obj;
            if (!dVar.f11597b) {
                return false;
            }
            int i11 = dVar.f11600e + 1;
            dVar.f11600e = i11;
            if (i11 > DefaultDrmSession.this.f11578j.a(3)) {
                return false;
            }
            long c11 = DefaultDrmSession.this.f11578j.c(new m.c(new g2.i(dVar.f11596a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f11598c, mediaDrmCallbackException.bytesLoaded), new g2.j(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), dVar.f11600e));
            if (c11 == C.TIME_UNSET) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.f11594a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), c11);
                    return true;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        void b(int i11, Object obj, boolean z10) {
            obtainMessage(i11, new d(g2.i.a(), z10, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f11594a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Throwable th2;
            d dVar = (d) message.obj;
            try {
                int i11 = message.what;
                if (i11 == 1) {
                    th2 = DefaultDrmSession.this.f11580l.b(DefaultDrmSession.this.f11581m, (b0.d) dVar.f11599d);
                } else {
                    if (i11 != 2) {
                        throw new RuntimeException();
                    }
                    th2 = DefaultDrmSession.this.f11580l.a(DefaultDrmSession.this.f11581m, (b0.a) dVar.f11599d);
                }
            } catch (MediaDrmCallbackException e11) {
                boolean a11 = a(message, e11);
                th2 = e11;
                if (a11) {
                    return;
                }
            } catch (Exception e12) {
                androidx.media3.common.util.u.i("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e12);
                th2 = e12;
            }
            DefaultDrmSession.this.f11578j.b(dVar.f11596a);
            synchronized (this) {
                try {
                    if (!this.f11594a) {
                        DefaultDrmSession.this.f11583o.obtainMessage(message.what, Pair.create(dVar.f11599d, th2)).sendToTarget();
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f11596a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f11597b;

        /* renamed from: c, reason: collision with root package name */
        public final long f11598c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f11599d;

        /* renamed from: e, reason: collision with root package name */
        public int f11600e;

        public d(long j11, boolean z10, long j12, Object obj) {
            this.f11596a = j11;
            this.f11597b = z10;
            this.f11598c = j12;
            this.f11599d = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i11 = message.what;
            if (i11 == 1) {
                DefaultDrmSession.this.C(obj, obj2);
            } else {
                if (i11 != 2) {
                    return;
                }
                DefaultDrmSession.this.w(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, b0 b0Var, a aVar, b bVar, List list, int i11, boolean z10, boolean z11, byte[] bArr, HashMap hashMap, m0 m0Var, Looper looper, androidx.media3.exoplayer.upstream.m mVar, f4 f4Var) {
        if (i11 == 1 || i11 == 3) {
            androidx.media3.common.util.a.e(bArr);
        }
        this.f11581m = uuid;
        this.f11571c = aVar;
        this.f11572d = bVar;
        this.f11570b = b0Var;
        this.f11573e = i11;
        this.f11574f = z10;
        this.f11575g = z11;
        if (bArr != null) {
            this.f11591w = bArr;
            this.f11569a = null;
        } else {
            this.f11569a = Collections.unmodifiableList((List) androidx.media3.common.util.a.e(list));
        }
        this.f11576h = hashMap;
        this.f11580l = m0Var;
        this.f11577i = new androidx.media3.common.util.n();
        this.f11578j = mVar;
        this.f11579k = f4Var;
        this.f11584p = 2;
        this.f11582n = looper;
        this.f11583o = new e(looper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Object obj, Object obj2) {
        if (obj == this.f11593y) {
            if (this.f11584p == 2 || s()) {
                this.f11593y = null;
                if (obj2 instanceof Exception) {
                    this.f11571c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.f11570b.provideProvisionResponse((byte[]) obj2);
                    this.f11571c.onProvisionCompleted();
                } catch (Exception e11) {
                    this.f11571c.a(e11, true);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean D() {
        /*
            r4 = this;
            boolean r0 = r4.s()
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            androidx.media3.exoplayer.drm.b0 r0 = r4.f11570b     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            byte[] r0 = r0.openSession()     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r4.f11590v = r0     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.exoplayer.drm.b0 r2 = r4.f11570b     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            y1.f4 r3 = r4.f11579k     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r2.e(r0, r3)     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.exoplayer.drm.b0 r0 = r4.f11570b     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            byte[] r2 = r4.f11590v     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.decoder.b r0 = r0.b(r2)     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r4.f11588t = r0     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r0 = 3
            r4.f11584p = r0     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.exoplayer.drm.b r2 = new androidx.media3.exoplayer.drm.b     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r2.<init>()     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            r4.o(r2)     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            byte[] r0 = r4.f11590v     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            androidx.media3.common.util.a.e(r0)     // Catch: java.lang.NoSuchMethodError -> L32 java.lang.Exception -> L34 android.media.NotProvisionedException -> L45
            return r1
        L32:
            r0 = move-exception
            goto L35
        L34:
            r0 = move-exception
        L35:
            boolean r2 = androidx.media3.exoplayer.drm.x.d(r0)
            if (r2 == 0) goto L41
            androidx.media3.exoplayer.drm.DefaultDrmSession$a r0 = r4.f11571c
            r0.b(r4)
            goto L4a
        L41:
            r4.v(r0, r1)
            goto L4a
        L45:
            androidx.media3.exoplayer.drm.DefaultDrmSession$a r0 = r4.f11571c
            r0.b(r4)
        L4a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.DefaultDrmSession.D():boolean");
    }

    private void E(byte[] bArr, int i11, boolean z10) {
        try {
            this.f11592x = this.f11570b.d(bArr, this.f11569a, i11, this.f11576h);
            ((c) a1.i(this.f11587s)).b(2, androidx.media3.common.util.a.e(this.f11592x), z10);
        } catch (Exception | NoSuchMethodError e11) {
            x(e11, true);
        }
    }

    private boolean G() {
        try {
            this.f11570b.restoreKeys(this.f11590v, this.f11591w);
            return true;
        } catch (Exception | NoSuchMethodError e11) {
            v(e11, 1);
            return false;
        }
    }

    private void H() {
        if (Thread.currentThread() != this.f11582n.getThread()) {
            androidx.media3.common.util.u.i("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f11582n.getThread().getName(), new IllegalStateException());
        }
    }

    private void o(androidx.media3.common.util.m mVar) {
        Iterator it = this.f11577i.elementSet().iterator();
        while (it.hasNext()) {
            mVar.accept((r.a) it.next());
        }
    }

    private void p(boolean z10) {
        if (this.f11575g) {
            return;
        }
        byte[] bArr = (byte[]) a1.i(this.f11590v);
        int i11 = this.f11573e;
        if (i11 != 0 && i11 != 1) {
            if (i11 == 2) {
                if (this.f11591w == null || G()) {
                    E(bArr, 2, z10);
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
            androidx.media3.common.util.a.e(this.f11591w);
            androidx.media3.common.util.a.e(this.f11590v);
            E(this.f11591w, 3, z10);
            return;
        }
        if (this.f11591w == null) {
            E(bArr, 1, z10);
            return;
        }
        if (this.f11584p == 4 || G()) {
            long q11 = q();
            if (this.f11573e != 0 || q11 > 60) {
                if (q11 <= 0) {
                    v(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.f11584p = 4;
                    o(new androidx.media3.common.util.m() { // from class: androidx.media3.exoplayer.drm.f
                        @Override // androidx.media3.common.util.m
                        public final void accept(Object obj) {
                            ((r.a) obj).j();
                        }
                    });
                    return;
                }
            }
            androidx.media3.common.util.u.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + q11);
            E(bArr, 2, z10);
        }
    }

    private long q() {
        if (!androidx.media3.common.h.f10066d.equals(this.f11581m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) androidx.media3.common.util.a.e(n0.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private boolean s() {
        int i11 = this.f11584p;
        return i11 == 3 || i11 == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Throwable th2, r.a aVar) {
        aVar.l((Exception) th2);
    }

    private void v(final Throwable th2, int i11) {
        this.f11589u = new DrmSession.DrmSessionException(th2, x.b(th2, i11));
        androidx.media3.common.util.u.d("DefaultDrmSession", "DRM session error", th2);
        if (th2 instanceof Exception) {
            o(new androidx.media3.common.util.m() { // from class: androidx.media3.exoplayer.drm.e
                @Override // androidx.media3.common.util.m
                public final void accept(Object obj) {
                    DefaultDrmSession.t(th2, (r.a) obj);
                }
            });
        } else {
            if (!(th2 instanceof Error)) {
                throw new IllegalStateException("Unexpected Throwable subclass", th2);
            }
            if (!x.e(th2) && !x.d(th2)) {
                throw ((Error) th2);
            }
        }
        if (this.f11584p != 4) {
            this.f11584p = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Object obj, Object obj2) {
        if (obj == this.f11592x && s()) {
            this.f11592x = null;
            if ((obj2 instanceof Exception) || (obj2 instanceof NoSuchMethodError)) {
                x((Throwable) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f11573e == 3) {
                    this.f11570b.provideKeyResponse((byte[]) a1.i(this.f11591w), bArr);
                    o(new androidx.media3.common.util.m() { // from class: androidx.media3.exoplayer.drm.c
                        @Override // androidx.media3.common.util.m
                        public final void accept(Object obj3) {
                            ((r.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] provideKeyResponse = this.f11570b.provideKeyResponse(this.f11590v, bArr);
                int i11 = this.f11573e;
                if ((i11 == 2 || (i11 == 0 && this.f11591w != null)) && provideKeyResponse != null && provideKeyResponse.length != 0) {
                    this.f11591w = provideKeyResponse;
                }
                this.f11584p = 4;
                o(new androidx.media3.common.util.m() { // from class: androidx.media3.exoplayer.drm.d
                    @Override // androidx.media3.common.util.m
                    public final void accept(Object obj3) {
                        ((r.a) obj3).h();
                    }
                });
            } catch (Exception e11) {
                e = e11;
                x(e, true);
            } catch (NoSuchMethodError e12) {
                e = e12;
                x(e, true);
            }
        }
    }

    private void x(Throwable th2, boolean z10) {
        if ((th2 instanceof NotProvisionedException) || x.d(th2)) {
            this.f11571c.b(this);
        } else {
            v(th2, z10 ? 1 : 2);
        }
    }

    private void y() {
        if (this.f11573e == 0 && this.f11584p == 4) {
            a1.i(this.f11590v);
            p(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        if (D()) {
            p(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(Exception exc, boolean z10) {
        v(exc, z10 ? 1 : 3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        this.f11593y = this.f11570b.getProvisionRequest();
        ((c) a1.i(this.f11587s)).b(1, androidx.media3.common.util.a.e(this.f11593y), true);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final UUID a() {
        H();
        return this.f11581m;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean b() {
        H();
        return this.f11574f;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final androidx.media3.decoder.b c() {
        H();
        return this.f11588t;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public boolean d(String str) {
        H();
        return this.f11570b.c((byte[]) androidx.media3.common.util.a.i(this.f11590v), str);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void e(r.a aVar) {
        H();
        if (this.f11585q < 0) {
            androidx.media3.common.util.u.c("DefaultDrmSession", "Session reference count less than zero: " + this.f11585q);
            this.f11585q = 0;
        }
        if (aVar != null) {
            this.f11577i.a(aVar);
        }
        int i11 = this.f11585q + 1;
        this.f11585q = i11;
        if (i11 == 1) {
            androidx.media3.common.util.a.g(this.f11584p == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f11586r = handlerThread;
            handlerThread.start();
            this.f11587s = new c(this.f11586r.getLooper());
            if (D()) {
                p(true);
            }
        } else if (aVar != null && s() && this.f11577i.count(aVar) == 1) {
            aVar.k(this.f11584p);
        }
        this.f11572d.a(this, this.f11585q);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public void f(r.a aVar) {
        H();
        int i11 = this.f11585q;
        if (i11 <= 0) {
            androidx.media3.common.util.u.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i12 = i11 - 1;
        this.f11585q = i12;
        if (i12 == 0) {
            this.f11584p = 0;
            ((e) a1.i(this.f11583o)).removeCallbacksAndMessages(null);
            ((c) a1.i(this.f11587s)).c();
            this.f11587s = null;
            ((HandlerThread) a1.i(this.f11586r)).quit();
            this.f11586r = null;
            this.f11588t = null;
            this.f11589u = null;
            this.f11592x = null;
            this.f11593y = null;
            byte[] bArr = this.f11590v;
            if (bArr != null) {
                this.f11570b.closeSession(bArr);
                this.f11590v = null;
            }
        }
        if (aVar != null) {
            this.f11577i.b(aVar);
            if (this.f11577i.count(aVar) == 0) {
                aVar.m();
            }
        }
        this.f11572d.b(this, this.f11585q);
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        H();
        if (this.f11584p == 1) {
            return this.f11589u;
        }
        return null;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public final int getState() {
        H();
        return this.f11584p;
    }

    @Override // androidx.media3.exoplayer.drm.DrmSession
    public Map queryKeyStatus() {
        H();
        byte[] bArr = this.f11590v;
        if (bArr == null) {
            return null;
        }
        return this.f11570b.queryKeyStatus(bArr);
    }

    public boolean r(byte[] bArr) {
        H();
        return Arrays.equals(this.f11590v, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(int i11) {
        if (i11 != 2) {
            return;
        }
        y();
    }
}

package com.google.android.exoplayer2.drm;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.c0;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.upstream.z;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e9.u1;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class DefaultDrmSession implements DrmSession {

    /* renamed from: a, reason: collision with root package name */
    public final List f24948a;

    /* renamed from: b, reason: collision with root package name */
    private final c0 f24949b;

    /* renamed from: c, reason: collision with root package name */
    private final a f24950c;

    /* renamed from: d, reason: collision with root package name */
    private final b f24951d;

    /* renamed from: e, reason: collision with root package name */
    private final int f24952e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f24953f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f24954g;

    /* renamed from: h, reason: collision with root package name */
    private final HashMap f24955h;

    /* renamed from: i, reason: collision with root package name */
    private final com.google.android.exoplayer2.util.j f24956i;

    /* renamed from: j, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.z f24957j;

    /* renamed from: k, reason: collision with root package name */
    private final u1 f24958k;

    /* renamed from: l, reason: collision with root package name */
    final j0 f24959l;

    /* renamed from: m, reason: collision with root package name */
    final UUID f24960m;

    /* renamed from: n, reason: collision with root package name */
    final e f24961n;

    /* renamed from: o, reason: collision with root package name */
    private int f24962o;

    /* renamed from: p, reason: collision with root package name */
    private int f24963p;

    /* renamed from: q, reason: collision with root package name */
    private HandlerThread f24964q;

    /* renamed from: r, reason: collision with root package name */
    private c f24965r;

    /* renamed from: s, reason: collision with root package name */
    private com.google.android.exoplayer2.decoder.b f24966s;

    /* renamed from: t, reason: collision with root package name */
    private DrmSession.DrmSessionException f24967t;

    /* renamed from: u, reason: collision with root package name */
    private byte[] f24968u;

    /* renamed from: v, reason: collision with root package name */
    private byte[] f24969v;

    /* renamed from: w, reason: collision with root package name */
    private c0.a f24970w;

    /* renamed from: x, reason: collision with root package name */
    private c0.d f24971x;

    /* loaded from: classes3.dex */
    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th2) {
            super(th2);
        }
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(Exception exc, boolean z10);

        void b(DefaultDrmSession defaultDrmSession);

        void onProvisionCompleted();
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(DefaultDrmSession defaultDrmSession, int i11);

        void b(DefaultDrmSession defaultDrmSession, int i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private boolean f24972a;

        public c(Looper looper) {
            super(looper);
        }

        private boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            d dVar = (d) message.obj;
            if (!dVar.f24975b) {
                return false;
            }
            int i11 = dVar.f24978e + 1;
            dVar.f24978e = i11;
            if (i11 > DefaultDrmSession.this.f24957j.a(3)) {
                return false;
            }
            long c11 = DefaultDrmSession.this.f24957j.c(new z.c(new t9.h(dVar.f24974a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.f24976c, mediaDrmCallbackException.bytesLoaded), new t9.i(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), dVar.f24978e));
            if (c11 == C.TIME_UNSET) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.f24972a) {
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
            obtainMessage(i11, new d(t9.h.a(), z10, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f24972a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Throwable th2;
            d dVar = (d) message.obj;
            try {
                int i11 = message.what;
                if (i11 == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    th2 = defaultDrmSession.f24959l.a(defaultDrmSession.f24960m, (c0.d) dVar.f24977d);
                } else {
                    if (i11 != 1) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    th2 = defaultDrmSession2.f24959l.b(defaultDrmSession2.f24960m, (c0.a) dVar.f24977d);
                }
            } catch (MediaDrmCallbackException e11) {
                boolean a11 = a(message, e11);
                th2 = e11;
                if (a11) {
                    return;
                }
            } catch (Exception e12) {
                com.google.android.exoplayer2.util.s.j("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e12);
                th2 = e12;
            }
            DefaultDrmSession.this.f24957j.b(dVar.f24974a);
            synchronized (this) {
                try {
                    if (!this.f24972a) {
                        DefaultDrmSession.this.f24961n.obtainMessage(message.what, Pair.create(dVar.f24977d, th2)).sendToTarget();
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final long f24974a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f24975b;

        /* renamed from: c, reason: collision with root package name */
        public final long f24976c;

        /* renamed from: d, reason: collision with root package name */
        public final Object f24977d;

        /* renamed from: e, reason: collision with root package name */
        public int f24978e;

        public d(long j11, boolean z10, long j12, Object obj) {
            this.f24974a = j11;
            this.f24975b = z10;
            this.f24976c = j12;
            this.f24977d = obj;
        }
    }

    /* loaded from: classes3.dex */
    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i11 = message.what;
            if (i11 == 0) {
                DefaultDrmSession.this.z(obj, obj2);
            } else {
                if (i11 != 1) {
                    return;
                }
                DefaultDrmSession.this.t(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, c0 c0Var, a aVar, b bVar, List list, int i11, boolean z10, boolean z11, byte[] bArr, HashMap hashMap, j0 j0Var, Looper looper, com.google.android.exoplayer2.upstream.z zVar, u1 u1Var) {
        if (i11 == 1 || i11 == 3) {
            com.google.android.exoplayer2.util.a.e(bArr);
        }
        this.f24960m = uuid;
        this.f24950c = aVar;
        this.f24951d = bVar;
        this.f24949b = c0Var;
        this.f24952e = i11;
        this.f24953f = z10;
        this.f24954g = z11;
        if (bArr != null) {
            this.f24969v = bArr;
            this.f24948a = null;
        } else {
            this.f24948a = Collections.unmodifiableList((List) com.google.android.exoplayer2.util.a.e(list));
        }
        this.f24955h = hashMap;
        this.f24959l = j0Var;
        this.f24956i = new com.google.android.exoplayer2.util.j();
        this.f24957j = zVar;
        this.f24958k = u1Var;
        this.f24962o = 2;
        this.f24961n = new e(looper);
    }

    private boolean A() {
        if (p()) {
            return true;
        }
        try {
            byte[] openSession = this.f24949b.openSession();
            this.f24968u = openSession;
            this.f24949b.f(openSession, this.f24958k);
            this.f24966s = this.f24949b.b(this.f24968u);
            final int i11 = 3;
            this.f24962o = 3;
            l(new com.google.android.exoplayer2.util.i() { // from class: com.google.android.exoplayer2.drm.b
                @Override // com.google.android.exoplayer2.util.i
                public final void accept(Object obj) {
                    ((s.a) obj).k(i11);
                }
            });
            com.google.android.exoplayer2.util.a.e(this.f24968u);
            return true;
        } catch (NotProvisionedException unused) {
            this.f24950c.b(this);
            return false;
        } catch (Exception e11) {
            s(e11, 1);
            return false;
        }
    }

    private void B(byte[] bArr, int i11, boolean z10) {
        try {
            this.f24970w = this.f24949b.d(bArr, this.f24948a, i11, this.f24955h);
            ((c) p0.j(this.f24965r)).b(1, com.google.android.exoplayer2.util.a.e(this.f24970w), z10);
        } catch (Exception e11) {
            u(e11, true);
        }
    }

    private boolean D() {
        try {
            this.f24949b.restoreKeys(this.f24968u, this.f24969v);
            return true;
        } catch (Exception e11) {
            s(e11, 1);
            return false;
        }
    }

    private void l(com.google.android.exoplayer2.util.i iVar) {
        Iterator it = this.f24956i.elementSet().iterator();
        while (it.hasNext()) {
            iVar.accept((s.a) it.next());
        }
    }

    private void m(boolean z10) {
        if (this.f24954g) {
            return;
        }
        byte[] bArr = (byte[]) p0.j(this.f24968u);
        int i11 = this.f24952e;
        if (i11 != 0 && i11 != 1) {
            if (i11 == 2) {
                if (this.f24969v == null || D()) {
                    B(bArr, 2, z10);
                    return;
                }
                return;
            }
            if (i11 != 3) {
                return;
            }
            com.google.android.exoplayer2.util.a.e(this.f24969v);
            com.google.android.exoplayer2.util.a.e(this.f24968u);
            B(this.f24969v, 3, z10);
            return;
        }
        if (this.f24969v == null) {
            B(bArr, 1, z10);
            return;
        }
        if (this.f24962o == 4 || D()) {
            long n11 = n();
            if (this.f24952e != 0 || n11 > 60) {
                if (n11 <= 0) {
                    s(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.f24962o = 4;
                    l(new com.google.android.exoplayer2.util.i() { // from class: com.google.android.exoplayer2.drm.c
                        @Override // com.google.android.exoplayer2.util.i
                        public final void accept(Object obj) {
                            ((s.a) obj).j();
                        }
                    });
                    return;
                }
            }
            com.google.android.exoplayer2.util.s.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + n11);
            B(bArr, 2, z10);
        }
    }

    private long n() {
        if (!com.google.android.exoplayer2.l.f25243d.equals(this.f24960m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) com.google.android.exoplayer2.util.a.e(k0.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private boolean p() {
        int i11 = this.f24962o;
        return i11 == 3 || i11 == 4;
    }

    private void s(final Exception exc, int i11) {
        this.f24967t = new DrmSession.DrmSessionException(exc, y.a(exc, i11));
        com.google.android.exoplayer2.util.s.d("DefaultDrmSession", "DRM session error", exc);
        l(new com.google.android.exoplayer2.util.i() { // from class: com.google.android.exoplayer2.drm.d
            @Override // com.google.android.exoplayer2.util.i
            public final void accept(Object obj) {
                ((s.a) obj).l(exc);
            }
        });
        if (this.f24962o != 4) {
            this.f24962o = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(Object obj, Object obj2) {
        if (obj == this.f24970w && p()) {
            this.f24970w = null;
            if (obj2 instanceof Exception) {
                u((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f24952e == 3) {
                    this.f24949b.provideKeyResponse((byte[]) p0.j(this.f24969v), bArr);
                    l(new com.google.android.exoplayer2.util.i() { // from class: com.google.android.exoplayer2.drm.e
                        @Override // com.google.android.exoplayer2.util.i
                        public final void accept(Object obj3) {
                            ((s.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] provideKeyResponse = this.f24949b.provideKeyResponse(this.f24968u, bArr);
                int i11 = this.f24952e;
                if ((i11 == 2 || (i11 == 0 && this.f24969v != null)) && provideKeyResponse != null && provideKeyResponse.length != 0) {
                    this.f24969v = provideKeyResponse;
                }
                this.f24962o = 4;
                l(new com.google.android.exoplayer2.util.i() { // from class: com.google.android.exoplayer2.drm.f
                    @Override // com.google.android.exoplayer2.util.i
                    public final void accept(Object obj3) {
                        ((s.a) obj3).h();
                    }
                });
            } catch (Exception e11) {
                u(e11, true);
            }
        }
    }

    private void u(Exception exc, boolean z10) {
        if (exc instanceof NotProvisionedException) {
            this.f24950c.b(this);
        } else {
            s(exc, z10 ? 1 : 2);
        }
    }

    private void v() {
        if (this.f24952e == 0 && this.f24962o == 4) {
            p0.j(this.f24968u);
            m(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(Object obj, Object obj2) {
        if (obj == this.f24971x) {
            if (this.f24962o == 2 || p()) {
                this.f24971x = null;
                if (obj2 instanceof Exception) {
                    this.f24950c.a((Exception) obj2, false);
                    return;
                }
                try {
                    this.f24949b.provideProvisionResponse((byte[]) obj2);
                    this.f24950c.onProvisionCompleted();
                } catch (Exception e11) {
                    this.f24950c.a(e11, true);
                }
            }
        }
    }

    public void C() {
        this.f24971x = this.f24949b.getProvisionRequest();
        ((c) p0.j(this.f24965r)).b(0, com.google.android.exoplayer2.util.a.e(this.f24971x), true);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID a() {
        return this.f24960m;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean b() {
        return this.f24953f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final com.google.android.exoplayer2.decoder.b c() {
        return this.f24966s;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d(String str) {
        return this.f24949b.c((byte[]) com.google.android.exoplayer2.util.a.i(this.f24968u), str);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void e(s.a aVar) {
        if (this.f24963p < 0) {
            com.google.android.exoplayer2.util.s.c("DefaultDrmSession", "Session reference count less than zero: " + this.f24963p);
            this.f24963p = 0;
        }
        if (aVar != null) {
            this.f24956i.a(aVar);
        }
        int i11 = this.f24963p + 1;
        this.f24963p = i11;
        if (i11 == 1) {
            com.google.android.exoplayer2.util.a.g(this.f24962o == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f24964q = handlerThread;
            handlerThread.start();
            this.f24965r = new c(this.f24964q.getLooper());
            if (A()) {
                m(true);
            }
        } else if (aVar != null && p() && this.f24956i.count(aVar) == 1) {
            aVar.k(this.f24962o);
        }
        this.f24951d.a(this, this.f24963p);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void f(s.a aVar) {
        int i11 = this.f24963p;
        if (i11 <= 0) {
            com.google.android.exoplayer2.util.s.c("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i12 = i11 - 1;
        this.f24963p = i12;
        if (i12 == 0) {
            this.f24962o = 0;
            ((e) p0.j(this.f24961n)).removeCallbacksAndMessages(null);
            ((c) p0.j(this.f24965r)).c();
            this.f24965r = null;
            ((HandlerThread) p0.j(this.f24964q)).quit();
            this.f24964q = null;
            this.f24966s = null;
            this.f24967t = null;
            this.f24970w = null;
            this.f24971x = null;
            byte[] bArr = this.f24968u;
            if (bArr != null) {
                this.f24949b.closeSession(bArr);
                this.f24968u = null;
            }
        }
        if (aVar != null) {
            this.f24956i.b(aVar);
            if (this.f24956i.count(aVar) == 0) {
                aVar.m();
            }
        }
        this.f24951d.b(this, this.f24963p);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final DrmSession.DrmSessionException getError() {
        if (this.f24962o == 1) {
            return this.f24967t;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.f24962o;
    }

    public boolean o(byte[] bArr) {
        return Arrays.equals(this.f24968u, bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public Map queryKeyStatus() {
        byte[] bArr = this.f24968u;
        if (bArr == null) {
            return null;
        }
        return this.f24949b.queryKeyStatus(bArr);
    }

    public void w(int i11) {
        if (i11 != 2) {
            return;
        }
        v();
    }

    public void x() {
        if (A()) {
            m(true);
        }
    }

    public void y(Exception exc, boolean z10) {
        s(exc, z10 ? 1 : 3);
    }
}

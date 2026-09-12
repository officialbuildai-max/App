package com.google.android.exoplayer2.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.c0;
import com.google.android.exoplayer2.drm.s;
import com.google.android.exoplayer2.drm.u;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.r4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import e9.u1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes3.dex */
public class DefaultDrmSessionManager implements u {

    /* renamed from: c, reason: collision with root package name */
    private final UUID f24980c;

    /* renamed from: d, reason: collision with root package name */
    private final c0.c f24981d;

    /* renamed from: e, reason: collision with root package name */
    private final j0 f24982e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap f24983f;

    /* renamed from: g, reason: collision with root package name */
    private final boolean f24984g;

    /* renamed from: h, reason: collision with root package name */
    private final int[] f24985h;

    /* renamed from: i, reason: collision with root package name */
    private final boolean f24986i;

    /* renamed from: j, reason: collision with root package name */
    private final f f24987j;

    /* renamed from: k, reason: collision with root package name */
    private final com.google.android.exoplayer2.upstream.z f24988k;

    /* renamed from: l, reason: collision with root package name */
    private final g f24989l;

    /* renamed from: m, reason: collision with root package name */
    private final long f24990m;

    /* renamed from: n, reason: collision with root package name */
    private final List f24991n;

    /* renamed from: o, reason: collision with root package name */
    private final Set f24992o;

    /* renamed from: p, reason: collision with root package name */
    private final Set f24993p;

    /* renamed from: q, reason: collision with root package name */
    private int f24994q;

    /* renamed from: r, reason: collision with root package name */
    private c0 f24995r;

    /* renamed from: s, reason: collision with root package name */
    private DefaultDrmSession f24996s;

    /* renamed from: t, reason: collision with root package name */
    private DefaultDrmSession f24997t;

    /* renamed from: u, reason: collision with root package name */
    private Looper f24998u;

    /* renamed from: v, reason: collision with root package name */
    private Handler f24999v;

    /* renamed from: w, reason: collision with root package name */
    private int f25000w;

    /* renamed from: x, reason: collision with root package name */
    private byte[] f25001x;

    /* renamed from: y, reason: collision with root package name */
    private u1 f25002y;

    /* renamed from: z, reason: collision with root package name */
    volatile d f25003z;

    /* loaded from: classes3.dex */
    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        private boolean f25007d;

        /* renamed from: f, reason: collision with root package name */
        private boolean f25009f;

        /* renamed from: a, reason: collision with root package name */
        private final HashMap f25004a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private UUID f25005b = com.google.android.exoplayer2.l.f25243d;

        /* renamed from: c, reason: collision with root package name */
        private c0.c f25006c = h0.f25038d;

        /* renamed from: g, reason: collision with root package name */
        private com.google.android.exoplayer2.upstream.z f25010g = new com.google.android.exoplayer2.upstream.v();

        /* renamed from: e, reason: collision with root package name */
        private int[] f25008e = new int[0];

        /* renamed from: h, reason: collision with root package name */
        private long f25011h = 300000;

        public DefaultDrmSessionManager a(j0 j0Var) {
            return new DefaultDrmSessionManager(this.f25005b, this.f25006c, j0Var, this.f25004a, this.f25007d, this.f25008e, this.f25009f, this.f25010g, this.f25011h);
        }

        public b b(boolean z10) {
            this.f25007d = z10;
            return this;
        }

        public b c(boolean z10) {
            this.f25009f = z10;
            return this;
        }

        public b d(int... iArr) {
            for (int i11 : iArr) {
                boolean z10 = true;
                if (i11 != 2 && i11 != 1) {
                    z10 = false;
                }
                com.google.android.exoplayer2.util.a.a(z10);
            }
            this.f25008e = (int[]) iArr.clone();
            return this;
        }

        public b e(UUID uuid, c0.c cVar) {
            this.f25005b = (UUID) com.google.android.exoplayer2.util.a.e(uuid);
            this.f25006c = (c0.c) com.google.android.exoplayer2.util.a.e(cVar);
            return this;
        }
    }

    /* loaded from: classes3.dex */
    private class c implements c0.b {
        private c() {
        }

        @Override // com.google.android.exoplayer2.drm.c0.b
        public void a(c0 c0Var, byte[] bArr, int i11, int i12, byte[] bArr2) {
            ((d) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f25003z)).obtainMessage(i11, bArr).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f24991n) {
                if (defaultDrmSession.o(bArr)) {
                    defaultDrmSession.w(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class e implements u.b {

        /* renamed from: b, reason: collision with root package name */
        private final s.a f25014b;

        /* renamed from: c, reason: collision with root package name */
        private DrmSession f25015c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f25016d;

        public e(s.a aVar) {
            this.f25014b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(o1 o1Var) {
            if (DefaultDrmSessionManager.this.f24994q == 0 || this.f25016d) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            this.f25015c = defaultDrmSessionManager.s((Looper) com.google.android.exoplayer2.util.a.e(defaultDrmSessionManager.f24998u), this.f25014b, o1Var, false);
            DefaultDrmSessionManager.this.f24992o.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (this.f25016d) {
                return;
            }
            DrmSession drmSession = this.f25015c;
            if (drmSession != null) {
                drmSession.f(this.f25014b);
            }
            DefaultDrmSessionManager.this.f24992o.remove(this);
            this.f25016d = true;
        }

        public void c(final o1 o1Var) {
            ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f24999v)).post(new Runnable() { // from class: com.google.android.exoplayer2.drm.g
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.e.this.d(o1Var);
                }
            });
        }

        @Override // com.google.android.exoplayer2.drm.u.b
        public void release() {
            p0.K0((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f24999v), new Runnable() { // from class: com.google.android.exoplayer2.drm.h
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.e.this.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class f implements DefaultDrmSession.a {

        /* renamed from: a, reason: collision with root package name */
        private final Set f25018a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        private DefaultDrmSession f25019b;

        public f(DefaultDrmSessionManager defaultDrmSessionManager) {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void a(Exception exc, boolean z10) {
            this.f25019b = null;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f25018a);
            this.f25018a.clear();
            r4 it = copyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).y(exc, z10);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void b(DefaultDrmSession defaultDrmSession) {
            this.f25018a.add(defaultDrmSession);
            if (this.f25019b != null) {
                return;
            }
            this.f25019b = defaultDrmSession;
            defaultDrmSession.C();
        }

        public void c(DefaultDrmSession defaultDrmSession) {
            this.f25018a.remove(defaultDrmSession);
            if (this.f25019b == defaultDrmSession) {
                this.f25019b = null;
                if (this.f25018a.isEmpty()) {
                    return;
                }
                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) this.f25018a.iterator().next();
                this.f25019b = defaultDrmSession2;
                defaultDrmSession2.C();
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.a
        public void onProvisionCompleted() {
            this.f25019b = null;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f25018a);
            this.f25018a.clear();
            r4 it = copyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).x();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class g implements DefaultDrmSession.b {
        private g() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void a(DefaultDrmSession defaultDrmSession, int i11) {
            if (DefaultDrmSessionManager.this.f24990m != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.f24993p.remove(defaultDrmSession);
                ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f24999v)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.b
        public void b(final DefaultDrmSession defaultDrmSession, int i11) {
            if (i11 == 1 && DefaultDrmSessionManager.this.f24994q > 0 && DefaultDrmSessionManager.this.f24990m != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.f24993p.add(defaultDrmSession);
                ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f24999v)).postAtTime(new Runnable() { // from class: com.google.android.exoplayer2.drm.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultDrmSession.this.f(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f24990m);
            } else if (i11 == 0) {
                DefaultDrmSessionManager.this.f24991n.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f24996s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f24996s = null;
                }
                if (DefaultDrmSessionManager.this.f24997t == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f24997t = null;
                }
                DefaultDrmSessionManager.this.f24987j.c(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f24990m != C.TIME_UNSET) {
                    ((Handler) com.google.android.exoplayer2.util.a.e(DefaultDrmSessionManager.this.f24999v)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f24993p.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.B();
        }
    }

    private DefaultDrmSessionManager(UUID uuid, c0.c cVar, j0 j0Var, HashMap hashMap, boolean z10, int[] iArr, boolean z11, com.google.android.exoplayer2.upstream.z zVar, long j11) {
        com.google.android.exoplayer2.util.a.e(uuid);
        com.google.android.exoplayer2.util.a.b(!com.google.android.exoplayer2.l.f25241b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f24980c = uuid;
        this.f24981d = cVar;
        this.f24982e = j0Var;
        this.f24983f = hashMap;
        this.f24984g = z10;
        this.f24985h = iArr;
        this.f24986i = z11;
        this.f24988k = zVar;
        this.f24987j = new f(this);
        this.f24989l = new g();
        this.f25000w = 0;
        this.f24991n = new ArrayList();
        this.f24992o = Sets.h();
        this.f24993p = Sets.h();
        this.f24990m = j11;
    }

    private void A(Looper looper) {
        if (this.f25003z == null) {
            this.f25003z = new d(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.f24995r != null && this.f24994q == 0 && this.f24991n.isEmpty() && this.f24992o.isEmpty()) {
            ((c0) com.google.android.exoplayer2.util.a.e(this.f24995r)).release();
            this.f24995r = null;
        }
    }

    private void C() {
        r4 it = ImmutableSet.copyOf((Collection) this.f24993p).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).f(null);
        }
    }

    private void D() {
        r4 it = ImmutableSet.copyOf((Collection) this.f24992o).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    private void F(DrmSession drmSession, s.a aVar) {
        drmSession.f(aVar);
        if (this.f24990m != C.TIME_UNSET) {
            drmSession.f(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public DrmSession s(Looper looper, s.a aVar, o1 o1Var, boolean z10) {
        List list;
        A(looper);
        DrmInitData drmInitData = o1Var.f25553o;
        if (drmInitData == null) {
            return z(com.google.android.exoplayer2.util.w.l(o1Var.f25550l), z10);
        }
        DefaultDrmSession defaultDrmSession = null;
        Object[] objArr = 0;
        if (this.f25001x == null) {
            list = x((DrmInitData) com.google.android.exoplayer2.util.a.e(drmInitData), this.f24980c, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f24980c);
                com.google.android.exoplayer2.util.s.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new a0(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            list = null;
        }
        if (this.f24984g) {
            Iterator it = this.f24991n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) it.next();
                if (p0.c(defaultDrmSession2.f24948a, list)) {
                    defaultDrmSession = defaultDrmSession2;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.f24997t;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = w(list, false, aVar, z10);
            if (!this.f24984g) {
                this.f24997t = defaultDrmSession;
            }
            this.f24991n.add(defaultDrmSession);
        } else {
            defaultDrmSession.e(aVar);
        }
        return defaultDrmSession;
    }

    private static boolean t(DrmSession drmSession) {
        return drmSession.getState() == 1 && (p0.f27680a < 19 || (((DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(drmSession.getError())).getCause() instanceof ResourceBusyException));
    }

    private boolean u(DrmInitData drmInitData) {
        if (this.f25001x != null) {
            return true;
        }
        if (x(drmInitData, this.f24980c, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(com.google.android.exoplayer2.l.f25241b)) {
                return false;
            }
            com.google.android.exoplayer2.util.s.i("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f24980c);
        }
        String str = drmInitData.schemeType;
        if (str == null || C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        return C.CENC_TYPE_cbcs.equals(str) ? p0.f27680a >= 25 : (C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str)) ? false : true;
    }

    private DefaultDrmSession v(List list, boolean z10, s.a aVar) {
        com.google.android.exoplayer2.util.a.e(this.f24995r);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f24980c, this.f24995r, this.f24987j, this.f24989l, list, this.f25000w, this.f24986i | z10, z10, this.f25001x, this.f24983f, this.f24982e, (Looper) com.google.android.exoplayer2.util.a.e(this.f24998u), this.f24988k, (u1) com.google.android.exoplayer2.util.a.e(this.f25002y));
        defaultDrmSession.e(aVar);
        if (this.f24990m != C.TIME_UNSET) {
            defaultDrmSession.e(null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession w(List list, boolean z10, s.a aVar, boolean z11) {
        DefaultDrmSession v11 = v(list, z10, aVar);
        if (t(v11) && !this.f24993p.isEmpty()) {
            C();
            F(v11, aVar);
            v11 = v(list, z10, aVar);
        }
        if (!t(v11) || !z11 || this.f24992o.isEmpty()) {
            return v11;
        }
        D();
        if (!this.f24993p.isEmpty()) {
            C();
        }
        F(v11, aVar);
        return v(list, z10, aVar);
    }

    private static List x(DrmInitData drmInitData, UUID uuid, boolean z10) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i11);
            if ((schemeData.matches(uuid) || (com.google.android.exoplayer2.l.f25242c.equals(uuid) && schemeData.matches(com.google.android.exoplayer2.l.f25241b))) && (schemeData.data != null || z10)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    private synchronized void y(Looper looper) {
        try {
            Looper looper2 = this.f24998u;
            if (looper2 == null) {
                this.f24998u = looper;
                this.f24999v = new Handler(looper);
            } else {
                com.google.android.exoplayer2.util.a.g(looper2 == looper);
                com.google.android.exoplayer2.util.a.e(this.f24999v);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private DrmSession z(int i11, boolean z10) {
        c0 c0Var = (c0) com.google.android.exoplayer2.util.a.e(this.f24995r);
        if ((c0Var.a() == 2 && d0.f25029d) || p0.z0(this.f24985h, i11) == -1 || c0Var.a() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f24996s;
        if (defaultDrmSession == null) {
            DefaultDrmSession w11 = w(ImmutableList.of(), true, null, z10);
            this.f24991n.add(w11);
            this.f24996s = w11;
        } else {
            defaultDrmSession.e(null);
        }
        return this.f24996s;
    }

    public void E(int i11, byte[] bArr) {
        com.google.android.exoplayer2.util.a.g(this.f24991n.isEmpty());
        if (i11 == 1 || i11 == 3) {
            com.google.android.exoplayer2.util.a.e(bArr);
        }
        this.f25000w = i11;
        this.f25001x = bArr;
    }

    @Override // com.google.android.exoplayer2.drm.u
    public int a(o1 o1Var) {
        int a11 = ((c0) com.google.android.exoplayer2.util.a.e(this.f24995r)).a();
        DrmInitData drmInitData = o1Var.f25553o;
        if (drmInitData != null) {
            if (u(drmInitData)) {
                return a11;
            }
            return 1;
        }
        if (p0.z0(this.f24985h, com.google.android.exoplayer2.util.w.l(o1Var.f25550l)) != -1) {
            return a11;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.drm.u
    public void b(Looper looper, u1 u1Var) {
        y(looper);
        this.f25002y = u1Var;
    }

    @Override // com.google.android.exoplayer2.drm.u
    public DrmSession c(s.a aVar, o1 o1Var) {
        com.google.android.exoplayer2.util.a.g(this.f24994q > 0);
        com.google.android.exoplayer2.util.a.i(this.f24998u);
        return s(this.f24998u, aVar, o1Var, true);
    }

    @Override // com.google.android.exoplayer2.drm.u
    public u.b d(s.a aVar, o1 o1Var) {
        com.google.android.exoplayer2.util.a.g(this.f24994q > 0);
        com.google.android.exoplayer2.util.a.i(this.f24998u);
        e eVar = new e(aVar);
        eVar.c(o1Var);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.drm.u
    public final void prepare() {
        int i11 = this.f24994q;
        this.f24994q = i11 + 1;
        if (i11 != 0) {
            return;
        }
        if (this.f24995r == null) {
            c0 a11 = this.f24981d.a(this.f24980c);
            this.f24995r = a11;
            a11.e(new c());
        } else if (this.f24990m != C.TIME_UNSET) {
            for (int i12 = 0; i12 < this.f24991n.size(); i12++) {
                ((DefaultDrmSession) this.f24991n.get(i12)).e(null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.u
    public final void release() {
        int i11 = this.f24994q - 1;
        this.f24994q = i11;
        if (i11 != 0) {
            return;
        }
        if (this.f24990m != C.TIME_UNSET) {
            ArrayList arrayList = new ArrayList(this.f24991n);
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                ((DefaultDrmSession) arrayList.get(i12)).f(null);
            }
        }
        D();
        B();
    }
}

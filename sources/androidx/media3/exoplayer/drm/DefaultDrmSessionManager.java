package androidx.media3.exoplayer.drm;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.drm.DefaultDrmSession;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.b0;
import androidx.media3.exoplayer.drm.r;
import androidx.media3.exoplayer.drm.t;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.r4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import y1.f4;

/* loaded from: classes2.dex */
public class DefaultDrmSessionManager implements t {

    /* renamed from: b, reason: collision with root package name */
    private final UUID f11602b;

    /* renamed from: c, reason: collision with root package name */
    private final b0.c f11603c;

    /* renamed from: d, reason: collision with root package name */
    private final m0 f11604d;

    /* renamed from: e, reason: collision with root package name */
    private final HashMap f11605e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f11606f;

    /* renamed from: g, reason: collision with root package name */
    private final int[] f11607g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f11608h;

    /* renamed from: i, reason: collision with root package name */
    private final f f11609i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.m f11610j;

    /* renamed from: k, reason: collision with root package name */
    private final g f11611k;

    /* renamed from: l, reason: collision with root package name */
    private final long f11612l;

    /* renamed from: m, reason: collision with root package name */
    private final List f11613m;

    /* renamed from: n, reason: collision with root package name */
    private final Set f11614n;

    /* renamed from: o, reason: collision with root package name */
    private final Set f11615o;

    /* renamed from: p, reason: collision with root package name */
    private int f11616p;

    /* renamed from: q, reason: collision with root package name */
    private b0 f11617q;

    /* renamed from: r, reason: collision with root package name */
    private DefaultDrmSession f11618r;

    /* renamed from: s, reason: collision with root package name */
    private DefaultDrmSession f11619s;

    /* renamed from: t, reason: collision with root package name */
    private Looper f11620t;

    /* renamed from: u, reason: collision with root package name */
    private Handler f11621u;

    /* renamed from: v, reason: collision with root package name */
    private int f11622v;

    /* renamed from: w, reason: collision with root package name */
    private byte[] f11623w;

    /* renamed from: x, reason: collision with root package name */
    private f4 f11624x;

    /* renamed from: y, reason: collision with root package name */
    volatile d f11625y;

    /* loaded from: classes2.dex */
    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: d, reason: collision with root package name */
        private boolean f11629d;

        /* renamed from: a, reason: collision with root package name */
        private final HashMap f11626a = new HashMap();

        /* renamed from: b, reason: collision with root package name */
        private UUID f11627b = androidx.media3.common.h.f10066d;

        /* renamed from: c, reason: collision with root package name */
        private b0.c f11628c = k0.f11667d;

        /* renamed from: e, reason: collision with root package name */
        private int[] f11630e = new int[0];

        /* renamed from: f, reason: collision with root package name */
        private boolean f11631f = true;

        /* renamed from: g, reason: collision with root package name */
        private androidx.media3.exoplayer.upstream.m f11632g = new androidx.media3.exoplayer.upstream.k();

        /* renamed from: h, reason: collision with root package name */
        private long f11633h = 300000;

        public DefaultDrmSessionManager a(m0 m0Var) {
            return new DefaultDrmSessionManager(this.f11627b, this.f11628c, m0Var, this.f11626a, this.f11629d, this.f11630e, this.f11631f, this.f11632g, this.f11633h);
        }

        public b b(androidx.media3.exoplayer.upstream.m mVar) {
            this.f11632g = (androidx.media3.exoplayer.upstream.m) androidx.media3.common.util.a.e(mVar);
            return this;
        }

        public b c(boolean z10) {
            this.f11629d = z10;
            return this;
        }

        public b d(boolean z10) {
            this.f11631f = z10;
            return this;
        }

        public b e(int... iArr) {
            for (int i11 : iArr) {
                boolean z10 = true;
                if (i11 != 2 && i11 != 1) {
                    z10 = false;
                }
                androidx.media3.common.util.a.a(z10);
            }
            this.f11630e = (int[]) iArr.clone();
            return this;
        }

        public b f(UUID uuid, b0.c cVar) {
            this.f11627b = (UUID) androidx.media3.common.util.a.e(uuid);
            this.f11628c = (b0.c) androidx.media3.common.util.a.e(cVar);
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private class c implements b0.b {
        private c() {
        }

        @Override // androidx.media3.exoplayer.drm.b0.b
        public void a(b0 b0Var, byte[] bArr, int i11, int i12, byte[] bArr2) {
            ((d) androidx.media3.common.util.a.e(DefaultDrmSessionManager.this.f11625y)).obtainMessage(i11, bArr).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
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
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f11613m) {
                if (defaultDrmSession.r(bArr)) {
                    defaultDrmSession.z(message.what);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class e implements t.b {

        /* renamed from: b, reason: collision with root package name */
        private final r.a f11636b;

        /* renamed from: c, reason: collision with root package name */
        private DrmSession f11637c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f11638d;

        public e(r.a aVar) {
            this.f11636b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(androidx.media3.common.r rVar) {
            if (DefaultDrmSessionManager.this.f11616p == 0 || this.f11638d) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            this.f11637c = defaultDrmSessionManager.s((Looper) androidx.media3.common.util.a.e(defaultDrmSessionManager.f11620t), this.f11636b, rVar, false);
            DefaultDrmSessionManager.this.f11614n.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            if (this.f11638d) {
                return;
            }
            DrmSession drmSession = this.f11637c;
            if (drmSession != null) {
                drmSession.f(this.f11636b);
            }
            DefaultDrmSessionManager.this.f11614n.remove(this);
            this.f11638d = true;
        }

        public void c(final androidx.media3.common.r rVar) {
            ((Handler) androidx.media3.common.util.a.e(DefaultDrmSessionManager.this.f11621u)).post(new Runnable() { // from class: androidx.media3.exoplayer.drm.g
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.e.this.d(rVar);
                }
            });
        }

        @Override // androidx.media3.exoplayer.drm.t.b
        public void release() {
            a1.b1((Handler) androidx.media3.common.util.a.e(DefaultDrmSessionManager.this.f11621u), new Runnable() { // from class: androidx.media3.exoplayer.drm.h
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultDrmSessionManager.e.this.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class f implements DefaultDrmSession.a {

        /* renamed from: a, reason: collision with root package name */
        private final Set f11640a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        private DefaultDrmSession f11641b;

        public f() {
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.a
        public void a(Exception exc, boolean z10) {
            this.f11641b = null;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f11640a);
            this.f11640a.clear();
            r4 it = copyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).B(exc, z10);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.a
        public void b(DefaultDrmSession defaultDrmSession) {
            this.f11640a.add(defaultDrmSession);
            if (this.f11641b != null) {
                return;
            }
            this.f11641b = defaultDrmSession;
            defaultDrmSession.F();
        }

        public void c(DefaultDrmSession defaultDrmSession) {
            this.f11640a.remove(defaultDrmSession);
            if (this.f11641b == defaultDrmSession) {
                this.f11641b = null;
                if (this.f11640a.isEmpty()) {
                    return;
                }
                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) this.f11640a.iterator().next();
                this.f11641b = defaultDrmSession2;
                defaultDrmSession2.F();
            }
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.a
        public void onProvisionCompleted() {
            this.f11641b = null;
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f11640a);
            this.f11640a.clear();
            r4 it = copyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).A();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class g implements DefaultDrmSession.b {
        private g() {
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.b
        public void a(DefaultDrmSession defaultDrmSession, int i11) {
            if (DefaultDrmSessionManager.this.f11612l != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.f11615o.remove(defaultDrmSession);
                ((Handler) androidx.media3.common.util.a.e(DefaultDrmSessionManager.this.f11621u)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // androidx.media3.exoplayer.drm.DefaultDrmSession.b
        public void b(final DefaultDrmSession defaultDrmSession, int i11) {
            if (i11 == 1 && DefaultDrmSessionManager.this.f11616p > 0 && DefaultDrmSessionManager.this.f11612l != C.TIME_UNSET) {
                DefaultDrmSessionManager.this.f11615o.add(defaultDrmSession);
                ((Handler) androidx.media3.common.util.a.e(DefaultDrmSessionManager.this.f11621u)).postAtTime(new Runnable() { // from class: androidx.media3.exoplayer.drm.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultDrmSession.this.f(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f11612l);
            } else if (i11 == 0) {
                DefaultDrmSessionManager.this.f11613m.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f11618r == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f11618r = null;
                }
                if (DefaultDrmSessionManager.this.f11619s == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f11619s = null;
                }
                DefaultDrmSessionManager.this.f11609i.c(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f11612l != C.TIME_UNSET) {
                    ((Handler) androidx.media3.common.util.a.e(DefaultDrmSessionManager.this.f11621u)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f11615o.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.B();
        }
    }

    private DefaultDrmSessionManager(UUID uuid, b0.c cVar, m0 m0Var, HashMap hashMap, boolean z10, int[] iArr, boolean z11, androidx.media3.exoplayer.upstream.m mVar, long j11) {
        androidx.media3.common.util.a.e(uuid);
        androidx.media3.common.util.a.b(!androidx.media3.common.h.f10064b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f11602b = uuid;
        this.f11603c = cVar;
        this.f11604d = m0Var;
        this.f11605e = hashMap;
        this.f11606f = z10;
        this.f11607g = iArr;
        this.f11608h = z11;
        this.f11610j = mVar;
        this.f11609i = new f();
        this.f11611k = new g();
        this.f11622v = 0;
        this.f11613m = new ArrayList();
        this.f11614n = Sets.h();
        this.f11615o = Sets.h();
        this.f11612l = j11;
    }

    private void A(Looper looper) {
        if (this.f11625y == null) {
            this.f11625y = new d(looper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (this.f11617q != null && this.f11616p == 0 && this.f11613m.isEmpty() && this.f11614n.isEmpty()) {
            ((b0) androidx.media3.common.util.a.e(this.f11617q)).release();
            this.f11617q = null;
        }
    }

    private void C() {
        r4 it = ImmutableSet.copyOf((Collection) this.f11615o).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).f(null);
        }
    }

    private void D() {
        r4 it = ImmutableSet.copyOf((Collection) this.f11614n).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    private void F(DrmSession drmSession, r.a aVar) {
        drmSession.f(aVar);
        if (this.f11612l != C.TIME_UNSET) {
            drmSession.f(null);
        }
    }

    private void G(boolean z10) {
        if (z10 && this.f11620t == null) {
            androidx.media3.common.util.u.i("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        if (Thread.currentThread() != ((Looper) androidx.media3.common.util.a.e(this.f11620t)).getThread()) {
            androidx.media3.common.util.u.i("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.f11620t.getThread().getName(), new IllegalStateException());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public DrmSession s(Looper looper, r.a aVar, androidx.media3.common.r rVar, boolean z10) {
        List list;
        A(looper);
        DrmInitData drmInitData = rVar.f10247s;
        if (drmInitData == null) {
            return z(androidx.media3.common.y.k(rVar.f10243o), z10);
        }
        DefaultDrmSession defaultDrmSession = null;
        Object[] objArr = 0;
        if (this.f11623w == null) {
            list = x((DrmInitData) androidx.media3.common.util.a.e(drmInitData), this.f11602b, false);
            if (list.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f11602b);
                androidx.media3.common.util.u.d("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new z(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            list = null;
        }
        if (this.f11606f) {
            Iterator it = this.f11613m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) it.next();
                if (Objects.equals(defaultDrmSession2.f11569a, list)) {
                    defaultDrmSession = defaultDrmSession2;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.f11619s;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = w(list, false, aVar, z10);
            if (!this.f11606f) {
                this.f11619s = defaultDrmSession;
            }
            this.f11613m.add(defaultDrmSession);
        } else {
            defaultDrmSession.e(aVar);
        }
        return defaultDrmSession;
    }

    private static boolean t(DrmSession drmSession) {
        if (drmSession.getState() != 1) {
            return false;
        }
        Throwable cause = ((DrmSession.DrmSessionException) androidx.media3.common.util.a.e(drmSession.getError())).getCause();
        return (cause instanceof ResourceBusyException) || x.e(cause);
    }

    private boolean u(DrmInitData drmInitData) {
        if (this.f11623w != null) {
            return true;
        }
        if (x(drmInitData, this.f11602b, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(androidx.media3.common.h.f10064b)) {
                return false;
            }
            androidx.media3.common.util.u.h("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f11602b);
        }
        String str = drmInitData.schemeType;
        if (str == null || C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        return C.CENC_TYPE_cbcs.equals(str) ? a1.f10432a >= 25 : (C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cens.equals(str)) ? false : true;
    }

    private DefaultDrmSession v(List list, boolean z10, r.a aVar) {
        androidx.media3.common.util.a.e(this.f11617q);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f11602b, this.f11617q, this.f11609i, this.f11611k, list, this.f11622v, this.f11608h | z10, z10, this.f11623w, this.f11605e, this.f11604d, (Looper) androidx.media3.common.util.a.e(this.f11620t), this.f11610j, (f4) androidx.media3.common.util.a.e(this.f11624x));
        defaultDrmSession.e(aVar);
        if (this.f11612l != C.TIME_UNSET) {
            defaultDrmSession.e(null);
        }
        return defaultDrmSession;
    }

    private DefaultDrmSession w(List list, boolean z10, r.a aVar, boolean z11) {
        DefaultDrmSession v11 = v(list, z10, aVar);
        if (t(v11) && !this.f11615o.isEmpty()) {
            C();
            F(v11, aVar);
            v11 = v(list, z10, aVar);
        }
        if (!t(v11) || !z11 || this.f11614n.isEmpty()) {
            return v11;
        }
        D();
        if (!this.f11615o.isEmpty()) {
            C();
        }
        F(v11, aVar);
        return v(list, z10, aVar);
    }

    private static List x(DrmInitData drmInitData, UUID uuid, boolean z10) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i11 = 0; i11 < drmInitData.schemeDataCount; i11++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i11);
            if ((schemeData.matches(uuid) || (androidx.media3.common.h.f10065c.equals(uuid) && schemeData.matches(androidx.media3.common.h.f10064b))) && (schemeData.data != null || z10)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    private synchronized void y(Looper looper) {
        try {
            Looper looper2 = this.f11620t;
            if (looper2 == null) {
                this.f11620t = looper;
                this.f11621u = new Handler(looper);
            } else {
                androidx.media3.common.util.a.g(looper2 == looper);
                androidx.media3.common.util.a.e(this.f11621u);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private DrmSession z(int i11, boolean z10) {
        b0 b0Var = (b0) androidx.media3.common.util.a.e(this.f11617q);
        if ((b0Var.a() == 2 && c0.f11650d) || a1.O0(this.f11607g, i11) == -1 || b0Var.a() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f11618r;
        if (defaultDrmSession == null) {
            DefaultDrmSession w11 = w(ImmutableList.of(), true, null, z10);
            this.f11613m.add(w11);
            this.f11618r = w11;
        } else {
            defaultDrmSession.e(null);
        }
        return this.f11618r;
    }

    public void E(int i11, byte[] bArr) {
        androidx.media3.common.util.a.g(this.f11613m.isEmpty());
        if (i11 == 1 || i11 == 3) {
            androidx.media3.common.util.a.e(bArr);
        }
        this.f11622v = i11;
        this.f11623w = bArr;
    }

    @Override // androidx.media3.exoplayer.drm.t
    public DrmSession a(r.a aVar, androidx.media3.common.r rVar) {
        G(false);
        androidx.media3.common.util.a.g(this.f11616p > 0);
        androidx.media3.common.util.a.i(this.f11620t);
        return s(this.f11620t, aVar, rVar, true);
    }

    @Override // androidx.media3.exoplayer.drm.t
    public int b(androidx.media3.common.r rVar) {
        G(false);
        int a11 = ((b0) androidx.media3.common.util.a.e(this.f11617q)).a();
        DrmInitData drmInitData = rVar.f10247s;
        if (drmInitData != null) {
            if (u(drmInitData)) {
                return a11;
            }
            return 1;
        }
        if (a1.O0(this.f11607g, androidx.media3.common.y.k(rVar.f10243o)) != -1) {
            return a11;
        }
        return 0;
    }

    @Override // androidx.media3.exoplayer.drm.t
    public void c(Looper looper, f4 f4Var) {
        y(looper);
        this.f11624x = f4Var;
    }

    @Override // androidx.media3.exoplayer.drm.t
    public t.b d(r.a aVar, androidx.media3.common.r rVar) {
        androidx.media3.common.util.a.g(this.f11616p > 0);
        androidx.media3.common.util.a.i(this.f11620t);
        e eVar = new e(aVar);
        eVar.c(rVar);
        return eVar;
    }

    @Override // androidx.media3.exoplayer.drm.t
    public final void prepare() {
        G(true);
        int i11 = this.f11616p;
        this.f11616p = i11 + 1;
        if (i11 != 0) {
            return;
        }
        if (this.f11617q == null) {
            b0 a11 = this.f11603c.a(this.f11602b);
            this.f11617q = a11;
            a11.f(new c());
        } else if (this.f11612l != C.TIME_UNSET) {
            for (int i12 = 0; i12 < this.f11613m.size(); i12++) {
                ((DefaultDrmSession) this.f11613m.get(i12)).e(null);
            }
        }
    }

    @Override // androidx.media3.exoplayer.drm.t
    public final void release() {
        G(true);
        int i11 = this.f11616p - 1;
        this.f11616p = i11;
        if (i11 != 0) {
            return;
        }
        if (this.f11612l != C.TIME_UNSET) {
            ArrayList arrayList = new ArrayList(this.f11613m);
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                ((DefaultDrmSession) arrayList.get(i12)).f(null);
            }
        }
        D();
        B();
    }
}

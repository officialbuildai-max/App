package androidx.media3.exoplayer.video;

import android.content.Context;
import android.os.Looper;
import android.util.Pair;
import android.util.SparseArray;
import android.view.Surface;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.c0;
import androidx.media3.common.j0;
import androidx.media3.common.k0;
import androidx.media3.common.l0;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.o0;
import androidx.media3.exoplayer.video.VideoSink;
import androidx.media3.exoplayer.video.q;
import androidx.media3.exoplayer.w3;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class q implements l0 {

    /* renamed from: y, reason: collision with root package name */
    private static final Executor f13255y = new Executor() { // from class: androidx.media3.exoplayer.video.p
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            q.G(runnable);
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final Context f13256a;

    /* renamed from: b, reason: collision with root package name */
    private final o0 f13257b;

    /* renamed from: c, reason: collision with root package name */
    private final c0.a f13258c;

    /* renamed from: d, reason: collision with root package name */
    private final SparseArray f13259d;

    /* renamed from: e, reason: collision with root package name */
    private final List f13260e;

    /* renamed from: f, reason: collision with root package name */
    private final j0 f13261f;

    /* renamed from: g, reason: collision with root package name */
    private final VideoSink f13262g;

    /* renamed from: h, reason: collision with root package name */
    private final VideoSink.b f13263h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.media3.common.util.i f13264i;

    /* renamed from: j, reason: collision with root package name */
    private final CopyOnWriteArraySet f13265j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f13266k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.media3.common.r f13267l;

    /* renamed from: m, reason: collision with root package name */
    private androidx.media3.common.util.p f13268m;

    /* renamed from: n, reason: collision with root package name */
    private long f13269n;

    /* renamed from: o, reason: collision with root package name */
    private Pair f13270o;

    /* renamed from: p, reason: collision with root package name */
    private int f13271p;

    /* renamed from: q, reason: collision with root package name */
    private int f13272q;

    /* renamed from: r, reason: collision with root package name */
    private w3.a f13273r;

    /* renamed from: s, reason: collision with root package name */
    private long f13274s;

    /* renamed from: t, reason: collision with root package name */
    private long f13275t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f13276u;

    /* renamed from: v, reason: collision with root package name */
    private long f13277v;

    /* renamed from: w, reason: collision with root package name */
    private int f13278w;

    /* renamed from: x, reason: collision with root package name */
    private int f13279x;

    /* loaded from: classes2.dex */
    class a implements VideoSink.b {
        a() {
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.b
        public void a(long j11) {
            q.w(q.this);
            android.support.v4.media.session.c.a(androidx.media3.common.util.a.i(null));
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink.b
        public void b() {
            q.w(q.this);
            android.support.v4.media.session.c.a(androidx.media3.common.util.a.i(null));
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f13281a;

        /* renamed from: b, reason: collision with root package name */
        private final u f13282b;

        /* renamed from: c, reason: collision with root package name */
        private k0.a f13283c;

        /* renamed from: d, reason: collision with root package name */
        private c0.a f13284d;

        /* renamed from: e, reason: collision with root package name */
        private List f13285e = ImmutableList.of();

        /* renamed from: f, reason: collision with root package name */
        private j0 f13286f = j0.f10178a;

        /* renamed from: g, reason: collision with root package name */
        private androidx.media3.common.util.i f13287g = androidx.media3.common.util.i.f10469a;

        /* renamed from: h, reason: collision with root package name */
        private boolean f13288h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f13289i;

        public b(Context context, u uVar) {
            this.f13281a = context.getApplicationContext();
            this.f13282b = uVar;
        }

        public q h() {
            androidx.media3.common.util.a.g(!this.f13289i);
            a aVar = null;
            if (this.f13284d == null) {
                if (this.f13283c == null) {
                    this.f13283c = new e(aVar);
                }
                this.f13284d = new f(this.f13283c);
            }
            q qVar = new q(this, aVar);
            this.f13289i = true;
            return qVar;
        }

        public b i(androidx.media3.common.util.i iVar) {
            this.f13287g = iVar;
            return this;
        }
    }

    /* loaded from: classes2.dex */
    private final class c implements VideoSink, d {

        /* renamed from: a, reason: collision with root package name */
        private final int f13290a;

        /* renamed from: b, reason: collision with root package name */
        private final int f13291b;

        /* renamed from: d, reason: collision with root package name */
        private androidx.media3.common.r f13293d;

        /* renamed from: e, reason: collision with root package name */
        private int f13294e;

        /* renamed from: f, reason: collision with root package name */
        private long f13295f;

        /* renamed from: j, reason: collision with root package name */
        private boolean f13299j;

        /* renamed from: c, reason: collision with root package name */
        private ImmutableList f13292c = ImmutableList.of();

        /* renamed from: g, reason: collision with root package name */
        private long f13296g = C.TIME_UNSET;

        /* renamed from: h, reason: collision with root package name */
        private VideoSink.a f13297h = VideoSink.a.f13155a;

        /* renamed from: i, reason: collision with root package name */
        private Executor f13298i = q.f13255y;

        public c(Context context, int i11) {
            this.f13291b = i11;
            this.f13290a = a1.f0(context);
        }

        private void w(androidx.media3.common.r rVar) {
            rVar.b().T(q.A(rVar.C)).N();
            android.support.v4.media.session.c.a(androidx.media3.common.util.a.i(null));
            throw null;
        }

        private void x(List list) {
            if (q.this.f13258c.a()) {
                this.f13292c = ImmutableList.copyOf((Collection) list);
            } else {
                this.f13292c = new ImmutableList.a().l(list).l(q.this.f13260e).e();
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void a(float f11) {
            q.this.N(f11);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean b(long j11, boolean z10, VideoSink.b bVar) {
            androidx.media3.common.util.a.g(isInitialized());
            if (!q.this.Q()) {
                return false;
            }
            android.support.v4.media.session.c.a(androidx.media3.common.util.a.i(null));
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void c() {
            q.this.f13262g.c();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void d(t tVar) {
            q.this.P(tVar);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void e() {
            q.this.f13275t = this.f13296g;
            if (q.this.f13274s >= q.this.f13275t) {
                q.this.f13262g.e();
                q.this.f13276u = true;
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void f(long j11, long j12) {
            o0 o0Var = q.this.f13257b;
            long j13 = this.f13296g;
            o0Var.a(j13 == C.TIME_UNSET ? 0L : j13 + 1, Long.valueOf(j11));
            this.f13295f = j12;
            q.this.L(j12);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void g() {
            q.this.f13262g.g();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void h(w3.a aVar) {
            q.this.f13273r = aVar;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void i(List list) {
            if (this.f13292c.equals(list)) {
                return;
            }
            x(list);
            androidx.media3.common.r rVar = this.f13293d;
            if (rVar != null) {
                w(rVar);
            }
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isEnded() {
            return isInitialized() && q.this.C();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean isInitialized() {
            return false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean j(boolean z10) {
            return q.this.E(z10 && isInitialized());
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public boolean k(androidx.media3.common.r rVar) {
            androidx.media3.common.util.a.g(!isInitialized());
            q.e(q.this, rVar, this.f13291b);
            return false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void l(boolean z10) {
            q.this.f13262g.l(z10);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public Surface m() {
            androidx.media3.common.util.a.g(isInitialized());
            android.support.v4.media.session.c.a(androidx.media3.common.util.a.i(null));
            throw null;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void n() {
            q.this.f13262g.n();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void o(int i11, androidx.media3.common.r rVar, List list) {
            androidx.media3.common.util.a.g(isInitialized());
            if (i11 != 1 && i11 != 2) {
                throw new UnsupportedOperationException("Unsupported input type " + i11);
            }
            x(list);
            this.f13294e = i11;
            this.f13293d = rVar;
            q.this.f13275t = C.TIME_UNSET;
            q.this.f13276u = false;
            w(rVar);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void p(Surface surface, androidx.media3.common.util.l0 l0Var) {
            q.this.M(surface, l0Var);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void q() {
            q.this.f13262g.q();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void r(int i11) {
            q.this.f13262g.r(i11);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void release() {
            q.this.J();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void render(long j11, long j12) {
            q.this.K(j11, j12);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void s() {
            q.this.y();
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void t(boolean z10) {
            if (isInitialized()) {
                throw null;
            }
            this.f13296g = C.TIME_UNSET;
            q.this.z(z10);
            this.f13299j = false;
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void u(boolean z10) {
            q.this.f13262g.u(z10);
        }

        @Override // androidx.media3.exoplayer.video.VideoSink
        public void v(VideoSink.a aVar, Executor executor) {
            this.f13297h = aVar;
            this.f13298i = executor;
        }
    }

    /* loaded from: classes2.dex */
    public interface d {
    }

    /* loaded from: classes2.dex */
    private static final class e implements k0.a {

        /* renamed from: a, reason: collision with root package name */
        private static final com.google.common.base.q f13301a = Suppliers.a(new com.google.common.base.q() { // from class: androidx.media3.exoplayer.video.r
            @Override // com.google.common.base.q
            public final Object get() {
                k0.a b11;
                b11 = q.e.b();
                return b11;
            }
        });

        private e() {
        }

        /* synthetic */ e(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ k0.a b() {
            try {
                Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                return (k0.a) androidx.media3.common.util.a.e(cls.getMethod("build", null).invoke(cls.getConstructor(null).newInstance(null), null));
            } catch (Exception e11) {
                throw new IllegalStateException(e11);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class f implements c0.a {

        /* renamed from: a, reason: collision with root package name */
        private final k0.a f13302a;

        public f(k0.a aVar) {
            this.f13302a = aVar;
        }

        @Override // androidx.media3.common.c0.a
        public boolean a() {
            return false;
        }

        @Override // androidx.media3.common.c0.a
        public androidx.media3.common.c0 b(Context context, androidx.media3.common.i iVar, androidx.media3.common.l lVar, l0 l0Var, Executor executor, j0 j0Var, List list, long j11) {
            try {
            } catch (Exception e11) {
                e = e11;
            }
            try {
                ((c0.a) Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(k0.a.class).newInstance(this.f13302a)).b(context, iVar, lVar, l0Var, executor, j0Var, list, j11);
                return null;
            } catch (Exception e12) {
                e = e12;
                throw VideoFrameProcessingException.from(e);
            }
        }
    }

    private q(b bVar) {
        this.f13256a = bVar.f13281a;
        this.f13257b = new o0();
        this.f13258c = (c0.a) androidx.media3.common.util.a.i(bVar.f13284d);
        this.f13259d = new SparseArray();
        this.f13260e = bVar.f13285e;
        this.f13261f = bVar.f13286f;
        androidx.media3.common.util.i iVar = bVar.f13287g;
        this.f13264i = iVar;
        this.f13262g = new androidx.media3.exoplayer.video.e(bVar.f13282b, iVar);
        this.f13263h = new a();
        this.f13265j = new CopyOnWriteArraySet();
        this.f13266k = bVar.f13288h;
        this.f13267l = new r.b().N();
        this.f13274s = C.TIME_UNSET;
        this.f13275t = C.TIME_UNSET;
        this.f13278w = -1;
        this.f13272q = 0;
    }

    /* synthetic */ q(b bVar, a aVar) {
        this(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static androidx.media3.common.i A(androidx.media3.common.i iVar) {
        return (iVar == null || !iVar.g()) ? androidx.media3.common.i.f10145h : iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        return this.f13271p == 0 && this.f13276u && this.f13262g.isEnded();
    }

    private boolean D() {
        return this.f13272q == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E(boolean z10) {
        return this.f13262g.j(z10 && this.f13271p == 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F() {
        this.f13271p--;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G(Runnable runnable) {
    }

    private void H(Surface surface, int i11, int i12) {
    }

    private k0 I(androidx.media3.common.r rVar, int i11) {
        if (i11 != 0) {
            if (!D()) {
                return null;
            }
            try {
                android.support.v4.media.session.c.a(androidx.media3.common.util.a.e(null));
                throw null;
            } catch (VideoFrameProcessingException e11) {
                throw new VideoSink.VideoSinkException(e11, rVar);
            }
        }
        androidx.media3.common.util.a.g(this.f13272q == 0);
        androidx.media3.common.i A = A(rVar.C);
        if (this.f13266k) {
            A = androidx.media3.common.i.f10145h;
        } else if (A.f10155c == 7 && a1.f10432a < 34) {
            A = A.a().e(6).a();
        }
        androidx.media3.common.i iVar = A;
        final androidx.media3.common.util.p createHandler = this.f13264i.createHandler((Looper) androidx.media3.common.util.a.i(Looper.myLooper()), null);
        this.f13268m = createHandler;
        try {
            c0.a aVar = this.f13258c;
            Context context = this.f13256a;
            androidx.media3.common.l lVar = androidx.media3.common.l.f10179a;
            Objects.requireNonNull(createHandler);
            aVar.b(context, iVar, lVar, this, new Executor() { // from class: androidx.media3.exoplayer.video.n
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    androidx.media3.common.util.p.this.post(runnable);
                }
            }, this.f13261f, this.f13260e, 0L);
            throw null;
        } catch (VideoFrameProcessingException e12) {
            throw new VideoSink.VideoSinkException(e12, rVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(long j11, long j12) {
        this.f13262g.render(j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(long j11) {
        this.f13277v = j11;
        this.f13262g.f(this.f13269n, j11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(float f11) {
        this.f13262g.a(f11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P(t tVar) {
        this.f13262g.d(tVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Q() {
        int i11 = this.f13278w;
        return i11 != -1 && i11 == this.f13279x;
    }

    static /* synthetic */ k0 e(q qVar, androidx.media3.common.r rVar, int i11) {
        qVar.I(rVar, i11);
        return null;
    }

    static /* synthetic */ androidx.media3.common.c0 w(q qVar) {
        qVar.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z10) {
        if (D()) {
            this.f13271p++;
            this.f13262g.t(z10);
            while (this.f13257b.l() > 1) {
                this.f13257b.i();
            }
            if (this.f13257b.l() == 1) {
                this.f13262g.f(((Long) androidx.media3.common.util.a.e((Long) this.f13257b.i())).longValue(), this.f13277v);
            }
            this.f13274s = C.TIME_UNSET;
            this.f13275t = C.TIME_UNSET;
            this.f13276u = false;
            ((androidx.media3.common.util.p) androidx.media3.common.util.a.i(this.f13268m)).post(new Runnable() { // from class: androidx.media3.exoplayer.video.o
                @Override // java.lang.Runnable
                public final void run() {
                    q.this.F();
                }
            });
        }
    }

    public VideoSink B(int i11) {
        androidx.media3.common.util.a.g(!a1.r(this.f13259d, i11));
        c cVar = new c(this.f13256a, i11);
        x(cVar);
        this.f13259d.put(i11, cVar);
        return cVar;
    }

    public void J() {
        if (this.f13272q == 2) {
            return;
        }
        androidx.media3.common.util.p pVar = this.f13268m;
        if (pVar != null) {
            pVar.removeCallbacksAndMessages(null);
        }
        this.f13270o = null;
        this.f13272q = 2;
    }

    public void M(Surface surface, androidx.media3.common.util.l0 l0Var) {
        Pair pair = this.f13270o;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((androidx.media3.common.util.l0) this.f13270o.second).equals(l0Var)) {
            return;
        }
        this.f13270o = Pair.create(surface, l0Var);
        H(surface, l0Var.b(), l0Var.a());
    }

    public void O(int i11) {
        this.f13278w = i11;
    }

    public void x(d dVar) {
        this.f13265j.add(dVar);
    }

    public void y() {
        androidx.media3.common.util.l0 l0Var = androidx.media3.common.util.l0.f10489c;
        H(null, l0Var.b(), l0Var.a());
        this.f13270o = null;
    }
}

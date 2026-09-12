package androidx.media3.exoplayer.dash;

import android.os.Handler;
import android.os.Message;
import androidx.media3.common.ParserException;
import androidx.media3.common.j;
import androidx.media3.common.r;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.j0;
import androidx.media3.common.x;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.source.e0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import l2.r0;
import l2.s0;

/* loaded from: classes2.dex */
public final class f implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.exoplayer.upstream.b f11551a;

    /* renamed from: b, reason: collision with root package name */
    private final b f11552b;

    /* renamed from: f, reason: collision with root package name */
    private a2.c f11556f;

    /* renamed from: g, reason: collision with root package name */
    private long f11557g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f11558h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f11559i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f11560j;

    /* renamed from: e, reason: collision with root package name */
    private final TreeMap f11555e = new TreeMap();

    /* renamed from: d, reason: collision with root package name */
    private final Handler f11554d = a1.B(this);

    /* renamed from: c, reason: collision with root package name */
    private final w2.b f11553c = new w2.b();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public final long f11561a;

        /* renamed from: b, reason: collision with root package name */
        public final long f11562b;

        public a(long j11, long j12) {
            this.f11561a = j11;
            this.f11562b = j12;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(long j11);

        void b();
    }

    /* loaded from: classes2.dex */
    public final class c implements s0 {

        /* renamed from: a, reason: collision with root package name */
        private final e0 f11563a;

        /* renamed from: b, reason: collision with root package name */
        private final s2 f11564b = new s2();

        /* renamed from: c, reason: collision with root package name */
        private final u2.b f11565c = new u2.b();

        /* renamed from: d, reason: collision with root package name */
        private long f11566d = C.TIME_UNSET;

        c(androidx.media3.exoplayer.upstream.b bVar) {
            this.f11563a = e0.m(bVar);
        }

        private u2.b h() {
            this.f11565c.clear();
            if (this.f11563a.V(this.f11564b, this.f11565c, 0, false) != -4) {
                return null;
            }
            this.f11565c.d();
            return this.f11565c;
        }

        private void l(long j11, long j12) {
            f.this.f11554d.sendMessage(f.this.f11554d.obtainMessage(1, new a(j11, j12)));
        }

        private void m() {
            while (this.f11563a.N(false)) {
                u2.b h11 = h();
                if (h11 != null) {
                    long j11 = h11.f11002e;
                    x a11 = f.this.f11553c.a(h11);
                    if (a11 != null) {
                        w2.a aVar = (w2.a) a11.d(0);
                        if (f.h(aVar.f77676a, aVar.f77677b)) {
                            n(j11, aVar);
                        }
                    }
                }
            }
            this.f11563a.t();
        }

        private void n(long j11, w2.a aVar) {
            long f11 = f.f(aVar);
            if (f11 == C.TIME_UNSET) {
                return;
            }
            l(j11, f11);
        }

        @Override // l2.s0
        public void a(j0 j0Var, int i11, int i12) {
            this.f11563a.b(j0Var, i11);
        }

        @Override // l2.s0
        public /* synthetic */ void b(j0 j0Var, int i11) {
            r0.c(this, j0Var, i11);
        }

        @Override // l2.s0
        public void c(r rVar) {
            this.f11563a.c(rVar);
        }

        @Override // l2.s0
        public void d(long j11, int i11, int i12, int i13, s0.a aVar) {
            this.f11563a.d(j11, i11, i12, i13, aVar);
            m();
        }

        @Override // l2.s0
        public /* synthetic */ int e(j jVar, int i11, boolean z10) {
            return r0.b(this, jVar, i11, z10);
        }

        @Override // l2.s0
        public /* synthetic */ void f(long j11) {
            r0.a(this, j11);
        }

        @Override // l2.s0
        public int g(j jVar, int i11, boolean z10, int i12) {
            return this.f11563a.e(jVar, i11, z10);
        }

        public boolean i(long j11) {
            return f.this.j(j11);
        }

        public void j(h2.e eVar) {
            long j11 = this.f11566d;
            if (j11 == C.TIME_UNSET || eVar.f64426h > j11) {
                this.f11566d = eVar.f64426h;
            }
            f.this.m(eVar);
        }

        public boolean k(h2.e eVar) {
            long j11 = this.f11566d;
            return f.this.n(j11 != C.TIME_UNSET && j11 < eVar.f64425g);
        }

        public void o() {
            this.f11563a.W();
        }
    }

    public f(a2.c cVar, b bVar, androidx.media3.exoplayer.upstream.b bVar2) {
        this.f11556f = cVar;
        this.f11552b = bVar;
        this.f11551a = bVar2;
    }

    private Map.Entry e(long j11) {
        return this.f11555e.ceilingEntry(Long.valueOf(j11));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long f(w2.a aVar) {
        try {
            return a1.Z0(a1.H(aVar.f77680e));
        } catch (ParserException unused) {
            return C.TIME_UNSET;
        }
    }

    private void g(long j11, long j12) {
        Long l11 = (Long) this.f11555e.get(Long.valueOf(j12));
        if (l11 == null) {
            this.f11555e.put(Long.valueOf(j12), Long.valueOf(j11));
        } else if (l11.longValue() > j11) {
            this.f11555e.put(Long.valueOf(j12), Long.valueOf(j11));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean h(String str, String str2) {
        return "urn:mpeg:dash:event:2012".equals(str) && ("1".equals(str2) || "2".equals(str2) || "3".equals(str2));
    }

    private void i() {
        if (this.f11558h) {
            this.f11559i = true;
            this.f11558h = false;
            this.f11552b.b();
        }
    }

    private void l() {
        this.f11552b.a(this.f11557g);
    }

    private void p() {
        Iterator it = this.f11555e.entrySet().iterator();
        while (it.hasNext()) {
            if (((Long) ((Map.Entry) it.next()).getKey()).longValue() < this.f11556f.f127h) {
                it.remove();
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (this.f11560j) {
            return true;
        }
        if (message.what != 1) {
            return false;
        }
        a aVar = (a) message.obj;
        g(aVar.f11561a, aVar.f11562b);
        return true;
    }

    boolean j(long j11) {
        a2.c cVar = this.f11556f;
        boolean z10 = false;
        if (!cVar.f123d) {
            return false;
        }
        if (this.f11559i) {
            return true;
        }
        Map.Entry e11 = e(cVar.f127h);
        if (e11 != null && ((Long) e11.getValue()).longValue() < j11) {
            this.f11557g = ((Long) e11.getKey()).longValue();
            l();
            z10 = true;
        }
        if (z10) {
            i();
        }
        return z10;
    }

    public c k() {
        return new c(this.f11551a);
    }

    void m(h2.e eVar) {
        this.f11558h = true;
    }

    boolean n(boolean z10) {
        if (!this.f11556f.f123d) {
            return false;
        }
        if (this.f11559i) {
            return true;
        }
        if (!z10) {
            return false;
        }
        i();
        return true;
    }

    public void o() {
        this.f11560j = true;
        this.f11554d.removeCallbacksAndMessages(null);
    }

    public void q(a2.c cVar) {
        this.f11559i = false;
        this.f11557g = C.TIME_UNSET;
        this.f11556f = cVar;
        p();
    }
}

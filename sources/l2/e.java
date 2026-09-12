package l2;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import l2.m0;

/* loaded from: classes2.dex */
public abstract class e {

    /* renamed from: a, reason: collision with root package name */
    protected final a f68664a;

    /* renamed from: b, reason: collision with root package name */
    protected final f f68665b;

    /* renamed from: c, reason: collision with root package name */
    protected c f68666c;

    /* renamed from: d, reason: collision with root package name */
    private final int f68667d;

    /* loaded from: classes2.dex */
    public static class a implements m0 {

        /* renamed from: a, reason: collision with root package name */
        private final d f68668a;

        /* renamed from: b, reason: collision with root package name */
        private final long f68669b;

        /* renamed from: c, reason: collision with root package name */
        private final long f68670c;

        /* renamed from: d, reason: collision with root package name */
        private final long f68671d;

        /* renamed from: e, reason: collision with root package name */
        private final long f68672e;

        /* renamed from: f, reason: collision with root package name */
        private final long f68673f;

        /* renamed from: g, reason: collision with root package name */
        private final long f68674g;

        public a(d dVar, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.f68668a = dVar;
            this.f68669b = j11;
            this.f68670c = j12;
            this.f68671d = j13;
            this.f68672e = j14;
            this.f68673f = j15;
            this.f68674g = j16;
        }

        @Override // l2.m0
        public long getDurationUs() {
            return this.f68669b;
        }

        @Override // l2.m0
        public m0.a getSeekPoints(long j11) {
            return new m0.a(new n0(j11, c.h(this.f68668a.a(j11), this.f68670c, this.f68671d, this.f68672e, this.f68673f, this.f68674g)));
        }

        public long h(long j11) {
            return this.f68668a.a(j11);
        }

        @Override // l2.m0
        public boolean isSeekable() {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements d {
        @Override // l2.e.d
        public long a(long j11) {
            return j11;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final long f68675a;

        /* renamed from: b, reason: collision with root package name */
        private final long f68676b;

        /* renamed from: c, reason: collision with root package name */
        private final long f68677c;

        /* renamed from: d, reason: collision with root package name */
        private long f68678d;

        /* renamed from: e, reason: collision with root package name */
        private long f68679e;

        /* renamed from: f, reason: collision with root package name */
        private long f68680f;

        /* renamed from: g, reason: collision with root package name */
        private long f68681g;

        /* renamed from: h, reason: collision with root package name */
        private long f68682h;

        protected c(long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
            this.f68675a = j11;
            this.f68676b = j12;
            this.f68678d = j13;
            this.f68679e = j14;
            this.f68680f = j15;
            this.f68681g = j16;
            this.f68677c = j17;
            this.f68682h = h(j12, j13, j14, j15, j16, j17);
        }

        protected static long h(long j11, long j12, long j13, long j14, long j15, long j16) {
            if (j14 + 1 >= j15 || j12 + 1 >= j13) {
                return j14;
            }
            long j17 = ((float) (j11 - j12)) * (((float) (j15 - j14)) / ((float) (j13 - j12)));
            return a1.q(((j17 + j14) - j16) - (j17 / 20), j14, j15 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return this.f68681g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j() {
            return this.f68680f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long k() {
            return this.f68682h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l() {
            return this.f68675a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long m() {
            return this.f68676b;
        }

        private void n() {
            this.f68682h = h(this.f68676b, this.f68678d, this.f68679e, this.f68680f, this.f68681g, this.f68677c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(long j11, long j12) {
            this.f68679e = j11;
            this.f68681g = j12;
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(long j11, long j12) {
            this.f68678d = j11;
            this.f68680f = j12;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface d {
        long a(long j11);
    }

    /* renamed from: l2.e$e, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0853e {

        /* renamed from: d, reason: collision with root package name */
        public static final C0853e f68683d = new C0853e(-3, C.TIME_UNSET, -1);

        /* renamed from: a, reason: collision with root package name */
        private final int f68684a;

        /* renamed from: b, reason: collision with root package name */
        private final long f68685b;

        /* renamed from: c, reason: collision with root package name */
        private final long f68686c;

        private C0853e(int i11, long j11, long j12) {
            this.f68684a = i11;
            this.f68685b = j11;
            this.f68686c = j12;
        }

        public static C0853e d(long j11, long j12) {
            return new C0853e(-1, j11, j12);
        }

        public static C0853e e(long j11) {
            return new C0853e(0, C.TIME_UNSET, j11);
        }

        public static C0853e f(long j11, long j12) {
            return new C0853e(-2, j11, j12);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public interface f {
        void a();

        C0853e b(s sVar, long j11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public e(d dVar, f fVar, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        this.f68665b = fVar;
        this.f68667d = i11;
        this.f68664a = new a(dVar, j11, j12, j13, j14, j15, j16);
    }

    protected c a(long j11) {
        return new c(j11, this.f68664a.h(j11), this.f68664a.f68670c, this.f68664a.f68671d, this.f68664a.f68672e, this.f68664a.f68673f, this.f68664a.f68674g);
    }

    public final m0 b() {
        return this.f68664a;
    }

    public int c(s sVar, l0 l0Var) {
        while (true) {
            c cVar = (c) androidx.media3.common.util.a.i(this.f68666c);
            long j11 = cVar.j();
            long i11 = cVar.i();
            long k11 = cVar.k();
            if (i11 - j11 <= this.f68667d) {
                e(false, j11);
                return g(sVar, j11, l0Var);
            }
            if (!i(sVar, k11)) {
                return g(sVar, k11, l0Var);
            }
            sVar.resetPeekPosition();
            C0853e b11 = this.f68665b.b(sVar, cVar.m());
            int i12 = b11.f68684a;
            if (i12 == -3) {
                e(false, k11);
                return g(sVar, k11, l0Var);
            }
            if (i12 == -2) {
                cVar.p(b11.f68685b, b11.f68686c);
            } else {
                if (i12 != -1) {
                    if (i12 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(sVar, b11.f68686c);
                    e(true, b11.f68686c);
                    return g(sVar, b11.f68686c, l0Var);
                }
                cVar.o(b11.f68685b, b11.f68686c);
            }
        }
    }

    public final boolean d() {
        return this.f68666c != null;
    }

    protected final void e(boolean z10, long j11) {
        this.f68666c = null;
        this.f68665b.a();
        f(z10, j11);
    }

    protected void f(boolean z10, long j11) {
    }

    protected final int g(s sVar, long j11, l0 l0Var) {
        if (j11 == sVar.getPosition()) {
            return 0;
        }
        l0Var.f68743a = j11;
        return 1;
    }

    public final void h(long j11) {
        c cVar = this.f68666c;
        if (cVar == null || cVar.l() != j11) {
            this.f68666c = a(j11);
        }
    }

    protected final boolean i(s sVar, long j11) {
        long position = j11 - sVar.getPosition();
        if (position < 0 || position > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        sVar.skipFully((int) position);
        return true;
    }
}

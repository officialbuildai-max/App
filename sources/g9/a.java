package g9;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import g9.b0;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final C0793a f63469a;

    /* renamed from: b, reason: collision with root package name */
    protected final f f63470b;

    /* renamed from: c, reason: collision with root package name */
    protected c f63471c;

    /* renamed from: d, reason: collision with root package name */
    private final int f63472d;

    /* renamed from: g9.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public static class C0793a implements b0 {

        /* renamed from: a, reason: collision with root package name */
        private final d f63473a;

        /* renamed from: b, reason: collision with root package name */
        private final long f63474b;

        /* renamed from: c, reason: collision with root package name */
        private final long f63475c;

        /* renamed from: d, reason: collision with root package name */
        private final long f63476d;

        /* renamed from: e, reason: collision with root package name */
        private final long f63477e;

        /* renamed from: f, reason: collision with root package name */
        private final long f63478f;

        /* renamed from: g, reason: collision with root package name */
        private final long f63479g;

        public C0793a(d dVar, long j11, long j12, long j13, long j14, long j15, long j16) {
            this.f63473a = dVar;
            this.f63474b = j11;
            this.f63475c = j12;
            this.f63476d = j13;
            this.f63477e = j14;
            this.f63478f = j15;
            this.f63479g = j16;
        }

        public long g(long j11) {
            return this.f63473a.a(j11);
        }

        @Override // g9.b0
        public long getDurationUs() {
            return this.f63474b;
        }

        @Override // g9.b0
        public b0.a getSeekPoints(long j11) {
            return new b0.a(new c0(j11, c.h(this.f63473a.a(j11), this.f63475c, this.f63476d, this.f63477e, this.f63478f, this.f63479g)));
        }

        @Override // g9.b0
        public boolean isSeekable() {
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public static final class b implements d {
        @Override // g9.a.d
        public long a(long j11) {
            return j11;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        private final long f63480a;

        /* renamed from: b, reason: collision with root package name */
        private final long f63481b;

        /* renamed from: c, reason: collision with root package name */
        private final long f63482c;

        /* renamed from: d, reason: collision with root package name */
        private long f63483d;

        /* renamed from: e, reason: collision with root package name */
        private long f63484e;

        /* renamed from: f, reason: collision with root package name */
        private long f63485f;

        /* renamed from: g, reason: collision with root package name */
        private long f63486g;

        /* renamed from: h, reason: collision with root package name */
        private long f63487h;

        protected c(long j11, long j12, long j13, long j14, long j15, long j16, long j17) {
            this.f63480a = j11;
            this.f63481b = j12;
            this.f63483d = j13;
            this.f63484e = j14;
            this.f63485f = j15;
            this.f63486g = j16;
            this.f63482c = j17;
            this.f63487h = h(j12, j13, j14, j15, j16, j17);
        }

        protected static long h(long j11, long j12, long j13, long j14, long j15, long j16) {
            if (j14 + 1 >= j15 || j12 + 1 >= j13) {
                return j14;
            }
            long j17 = ((float) (j11 - j12)) * (((float) (j15 - j14)) / ((float) (j13 - j12)));
            return p0.r(((j17 + j14) - j16) - (j17 / 20), j14, j15 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return this.f63486g;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j() {
            return this.f63485f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long k() {
            return this.f63487h;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long l() {
            return this.f63480a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long m() {
            return this.f63481b;
        }

        private void n() {
            this.f63487h = h(this.f63481b, this.f63483d, this.f63484e, this.f63485f, this.f63486g, this.f63482c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(long j11, long j12) {
            this.f63484e = j11;
            this.f63486g = j12;
            n();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p(long j11, long j12) {
            this.f63483d = j11;
            this.f63485f = j12;
            n();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public interface d {
        long a(long j11);
    }

    /* loaded from: classes4.dex */
    public static final class e {

        /* renamed from: d, reason: collision with root package name */
        public static final e f63488d = new e(-3, C.TIME_UNSET, -1);

        /* renamed from: a, reason: collision with root package name */
        private final int f63489a;

        /* renamed from: b, reason: collision with root package name */
        private final long f63490b;

        /* renamed from: c, reason: collision with root package name */
        private final long f63491c;

        private e(int i11, long j11, long j12) {
            this.f63489a = i11;
            this.f63490b = j11;
            this.f63491c = j12;
        }

        public static e d(long j11, long j12) {
            return new e(-1, j11, j12);
        }

        public static e e(long j11) {
            return new e(0, C.TIME_UNSET, j11);
        }

        public static e f(long j11, long j12) {
            return new e(-2, j11, j12);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes4.dex */
    public interface f {
        void a();

        e b(m mVar, long j11);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(d dVar, f fVar, long j11, long j12, long j13, long j14, long j15, long j16, int i11) {
        this.f63470b = fVar;
        this.f63472d = i11;
        this.f63469a = new C0793a(dVar, j11, j12, j13, j14, j15, j16);
    }

    protected c a(long j11) {
        return new c(j11, this.f63469a.g(j11), this.f63469a.f63475c, this.f63469a.f63476d, this.f63469a.f63477e, this.f63469a.f63478f, this.f63469a.f63479g);
    }

    public final b0 b() {
        return this.f63469a;
    }

    public int c(m mVar, a0 a0Var) {
        while (true) {
            c cVar = (c) com.google.android.exoplayer2.util.a.i(this.f63471c);
            long j11 = cVar.j();
            long i11 = cVar.i();
            long k11 = cVar.k();
            if (i11 - j11 <= this.f63472d) {
                e(false, j11);
                return g(mVar, j11, a0Var);
            }
            if (!i(mVar, k11)) {
                return g(mVar, k11, a0Var);
            }
            mVar.resetPeekPosition();
            e b11 = this.f63470b.b(mVar, cVar.m());
            int i12 = b11.f63489a;
            if (i12 == -3) {
                e(false, k11);
                return g(mVar, k11, a0Var);
            }
            if (i12 == -2) {
                cVar.p(b11.f63490b, b11.f63491c);
            } else {
                if (i12 != -1) {
                    if (i12 != 0) {
                        throw new IllegalStateException("Invalid case");
                    }
                    i(mVar, b11.f63491c);
                    e(true, b11.f63491c);
                    return g(mVar, b11.f63491c, a0Var);
                }
                cVar.o(b11.f63490b, b11.f63491c);
            }
        }
    }

    public final boolean d() {
        return this.f63471c != null;
    }

    protected final void e(boolean z10, long j11) {
        this.f63471c = null;
        this.f63470b.a();
        f(z10, j11);
    }

    protected void f(boolean z10, long j11) {
    }

    protected final int g(m mVar, long j11, a0 a0Var) {
        if (j11 == mVar.getPosition()) {
            return 0;
        }
        a0Var.f63492a = j11;
        return 1;
    }

    public final void h(long j11) {
        c cVar = this.f63471c;
        if (cVar == null || cVar.l() != j11) {
            this.f63471c = a(j11);
        }
    }

    protected final boolean i(m mVar, long j11) {
        long position = j11 - mVar.getPosition();
        if (position < 0 || position > PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return false;
        }
        mVar.skipFully((int) position);
        return true;
    }
}

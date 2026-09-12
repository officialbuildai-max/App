package androidx.media3.exoplayer.video;

import android.content.Context;
import android.view.Surface;
import androidx.media3.common.util.a1;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* loaded from: classes2.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    private final b f13385a;

    /* renamed from: b, reason: collision with root package name */
    private final w f13386b;

    /* renamed from: c, reason: collision with root package name */
    private final long f13387c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13388d;

    /* renamed from: g, reason: collision with root package name */
    private long f13391g;

    /* renamed from: j, reason: collision with root package name */
    private boolean f13394j;

    /* renamed from: m, reason: collision with root package name */
    private boolean f13397m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f13398n;

    /* renamed from: e, reason: collision with root package name */
    private int f13389e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f13390f = C.TIME_UNSET;

    /* renamed from: h, reason: collision with root package name */
    private long f13392h = C.TIME_UNSET;

    /* renamed from: i, reason: collision with root package name */
    private long f13393i = C.TIME_UNSET;

    /* renamed from: k, reason: collision with root package name */
    private float f13395k = 1.0f;

    /* renamed from: l, reason: collision with root package name */
    private androidx.media3.common.util.i f13396l = androidx.media3.common.util.i.f10469a;

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private long f13399a = C.TIME_UNSET;

        /* renamed from: b, reason: collision with root package name */
        private long f13400b = C.TIME_UNSET;

        /* JADX INFO: Access modifiers changed from: private */
        public void h() {
            this.f13399a = C.TIME_UNSET;
            this.f13400b = C.TIME_UNSET;
        }

        public long f() {
            return this.f13399a;
        }

        public long g() {
            return this.f13400b;
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        boolean j(long j11, long j12);

        boolean k(long j11, long j12, long j13, boolean z10, boolean z11);

        boolean o(long j11, long j12, boolean z10);
    }

    public u(Context context, b bVar, long j11) {
        this.f13385a = bVar;
        this.f13387c = j11;
        this.f13386b = new w(context);
    }

    private long b(long j11, long j12, long j13) {
        long j14 = (long) ((j13 - j11) / this.f13395k);
        return this.f13388d ? j14 - (a1.R0(this.f13396l.elapsedRealtime()) - j12) : j14;
    }

    private void f(int i11) {
        this.f13389e = Math.min(this.f13389e, i11);
    }

    private boolean s(long j11, long j12, long j13) {
        if (this.f13393i != C.TIME_UNSET && !this.f13394j) {
            return false;
        }
        int i11 = this.f13389e;
        if (i11 == 0) {
            return this.f13388d;
        }
        if (i11 == 1) {
            return true;
        }
        if (i11 == 2) {
            return j11 >= j13;
        }
        if (i11 == 3) {
            return this.f13388d && this.f13385a.j(j12, a1.R0(this.f13396l.elapsedRealtime()) - this.f13391g);
        }
        throw new IllegalStateException();
    }

    public void a() {
        if (this.f13389e == 0) {
            this.f13389e = 1;
        }
    }

    public int c(long j11, long j12, long j13, long j14, boolean z10, boolean z11, a aVar) {
        aVar.h();
        if (this.f13390f == C.TIME_UNSET) {
            this.f13390f = j12;
        }
        if (this.f13392h != j11) {
            this.f13386b.h(j11);
            this.f13392h = j11;
        }
        aVar.f13399a = b(j12, j13, j11);
        if (z10 && !z11) {
            return 3;
        }
        if (!this.f13397m) {
            this.f13398n = true;
            if (this.f13385a.k(aVar.f13399a, j12, j13, z11, true)) {
                return 4;
            }
            return (!this.f13388d || aVar.f13399a >= 30000) ? 5 : 3;
        }
        boolean z12 = false;
        if (s(j12, aVar.f13399a, j14)) {
            return 0;
        }
        if (!this.f13388d || j12 == this.f13390f) {
            return 5;
        }
        long nanoTime = this.f13396l.nanoTime();
        aVar.f13400b = this.f13386b.b((aVar.f13399a * 1000) + nanoTime);
        aVar.f13399a = (aVar.f13400b - nanoTime) / 1000;
        if (this.f13393i != C.TIME_UNSET && !this.f13394j) {
            z12 = true;
        }
        if (this.f13385a.k(aVar.f13399a, j12, j13, z11, z12)) {
            return 4;
        }
        return this.f13385a.o(aVar.f13399a, j13, z11) ? z12 ? 3 : 2 : aVar.f13399a > 50000 ? 5 : 1;
    }

    public boolean d(boolean z10) {
        if (z10 && (this.f13389e == 3 || (!this.f13397m && this.f13398n))) {
            this.f13393i = C.TIME_UNSET;
            return true;
        }
        if (this.f13393i == C.TIME_UNSET) {
            return false;
        }
        if (this.f13396l.elapsedRealtime() < this.f13393i) {
            return true;
        }
        this.f13393i = C.TIME_UNSET;
        return false;
    }

    public void e(boolean z10) {
        this.f13394j = z10;
        this.f13393i = this.f13387c > 0 ? this.f13396l.elapsedRealtime() + this.f13387c : C.TIME_UNSET;
    }

    public void g() {
        f(0);
    }

    public void h(boolean z10) {
        this.f13389e = z10 ? 1 : 0;
    }

    public boolean i() {
        boolean z10 = this.f13389e != 3;
        this.f13389e = 3;
        this.f13391g = a1.R0(this.f13396l.elapsedRealtime());
        return z10;
    }

    public void j() {
        f(2);
    }

    public void k() {
        this.f13388d = true;
        this.f13391g = a1.R0(this.f13396l.elapsedRealtime());
        this.f13386b.k();
    }

    public void l() {
        this.f13388d = false;
        this.f13393i = C.TIME_UNSET;
        this.f13386b.l();
    }

    public void m() {
        this.f13386b.j();
        this.f13392h = C.TIME_UNSET;
        this.f13390f = C.TIME_UNSET;
        f(1);
        this.f13393i = C.TIME_UNSET;
    }

    public void n(int i11) {
        this.f13386b.o(i11);
    }

    public void o(androidx.media3.common.util.i iVar) {
        this.f13396l = iVar;
    }

    public void p(float f11) {
        this.f13386b.g(f11);
    }

    public void q(Surface surface) {
        this.f13397m = surface != null;
        this.f13398n = false;
        this.f13386b.m(surface);
        f(1);
    }

    public void r(float f11) {
        androidx.media3.common.util.a.a(f11 > 0.0f);
        if (f11 == this.f13395k) {
            return;
        }
        this.f13395k = f11;
        this.f13386b.i(f11);
    }
}

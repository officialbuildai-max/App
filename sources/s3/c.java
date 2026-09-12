package s3;

import androidx.media3.common.r;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Objects;
import l2.b;
import l2.s0;
import s3.l0;

/* loaded from: classes2.dex */
public final class c implements m {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.common.util.i0 f74995a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.common.util.j0 f74996b;

    /* renamed from: c, reason: collision with root package name */
    private final String f74997c;

    /* renamed from: d, reason: collision with root package name */
    private final int f74998d;

    /* renamed from: e, reason: collision with root package name */
    private final String f74999e;

    /* renamed from: f, reason: collision with root package name */
    private String f75000f;

    /* renamed from: g, reason: collision with root package name */
    private s0 f75001g;

    /* renamed from: h, reason: collision with root package name */
    private int f75002h;

    /* renamed from: i, reason: collision with root package name */
    private int f75003i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f75004j;

    /* renamed from: k, reason: collision with root package name */
    private long f75005k;

    /* renamed from: l, reason: collision with root package name */
    private androidx.media3.common.r f75006l;

    /* renamed from: m, reason: collision with root package name */
    private int f75007m;

    /* renamed from: n, reason: collision with root package name */
    private long f75008n;

    public c(String str) {
        this(null, 0, str);
    }

    public c(String str, int i11, String str2) {
        androidx.media3.common.util.i0 i0Var = new androidx.media3.common.util.i0(new byte[128]);
        this.f74995a = i0Var;
        this.f74996b = new androidx.media3.common.util.j0(i0Var.f10470a);
        this.f75002h = 0;
        this.f75008n = C.TIME_UNSET;
        this.f74997c = str;
        this.f74998d = i11;
        this.f74999e = str2;
    }

    private boolean e(androidx.media3.common.util.j0 j0Var, byte[] bArr, int i11) {
        int min = Math.min(j0Var.a(), i11 - this.f75003i);
        j0Var.l(bArr, this.f75003i, min);
        int i12 = this.f75003i + min;
        this.f75003i = i12;
        return i12 == i11;
    }

    private void f() {
        this.f74995a.p(0);
        b.C0851b f11 = l2.b.f(this.f74995a);
        androidx.media3.common.r rVar = this.f75006l;
        if (rVar == null || f11.f68620d != rVar.E || f11.f68619c != rVar.F || !Objects.equals(f11.f68617a, rVar.f10243o)) {
            r.b p02 = new r.b().f0(this.f75000f).U(this.f74999e).u0(f11.f68617a).R(f11.f68620d).v0(f11.f68619c).j0(this.f74997c).s0(this.f74998d).p0(f11.f68623g);
            if (MimeTypes.AUDIO_AC3.equals(f11.f68617a)) {
                p02.Q(f11.f68623g);
            }
            androidx.media3.common.r N = p02.N();
            this.f75006l = N;
            this.f75001g.c(N);
        }
        this.f75007m = f11.f68621e;
        this.f75005k = (f11.f68622f * 1000000) / this.f75006l.F;
    }

    private boolean g(androidx.media3.common.util.j0 j0Var) {
        while (true) {
            if (j0Var.a() <= 0) {
                return false;
            }
            if (this.f75004j) {
                int H = j0Var.H();
                if (H == 119) {
                    this.f75004j = false;
                    return true;
                }
                this.f75004j = H == 11;
            } else {
                this.f75004j = j0Var.H() == 11;
            }
        }
    }

    @Override // s3.m
    public void a(androidx.media3.common.util.j0 j0Var) {
        androidx.media3.common.util.a.i(this.f75001g);
        while (j0Var.a() > 0) {
            int i11 = this.f75002h;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        int min = Math.min(j0Var.a(), this.f75007m - this.f75003i);
                        this.f75001g.b(j0Var, min);
                        int i12 = this.f75003i + min;
                        this.f75003i = i12;
                        if (i12 == this.f75007m) {
                            androidx.media3.common.util.a.g(this.f75008n != C.TIME_UNSET);
                            this.f75001g.d(this.f75008n, 1, this.f75007m, 0, null);
                            this.f75008n += this.f75005k;
                            this.f75002h = 0;
                        }
                    }
                } else if (e(j0Var, this.f74996b.e(), 128)) {
                    f();
                    this.f74996b.W(0);
                    this.f75001g.b(this.f74996b, 128);
                    this.f75002h = 2;
                }
            } else if (g(j0Var)) {
                this.f75002h = 1;
                this.f74996b.e()[0] = 11;
                this.f74996b.e()[1] = 119;
                this.f75003i = 2;
            }
        }
    }

    @Override // s3.m
    public void b(long j11, int i11) {
        this.f75008n = j11;
    }

    @Override // s3.m
    public void c(boolean z10) {
    }

    @Override // s3.m
    public void d(l2.t tVar, l0.d dVar) {
        dVar.a();
        this.f75000f = dVar.b();
        this.f75001g = tVar.track(dVar.c(), 1);
    }

    @Override // s3.m
    public void seek() {
        this.f75002h = 0;
        this.f75003i = 0;
        this.f75004j = false;
        this.f75008n = C.TIME_UNSET;
    }
}

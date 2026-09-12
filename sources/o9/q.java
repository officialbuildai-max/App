package o9;

import com.google.android.exoplayer2.util.d0;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes4.dex */
final class q {

    /* renamed from: a, reason: collision with root package name */
    public c f71015a;

    /* renamed from: b, reason: collision with root package name */
    public long f71016b;

    /* renamed from: c, reason: collision with root package name */
    public long f71017c;

    /* renamed from: d, reason: collision with root package name */
    public long f71018d;

    /* renamed from: e, reason: collision with root package name */
    public int f71019e;

    /* renamed from: f, reason: collision with root package name */
    public int f71020f;

    /* renamed from: l, reason: collision with root package name */
    public boolean f71026l;

    /* renamed from: n, reason: collision with root package name */
    public p f71028n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f71030p;

    /* renamed from: q, reason: collision with root package name */
    public long f71031q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f71032r;

    /* renamed from: g, reason: collision with root package name */
    public long[] f71021g = new long[0];

    /* renamed from: h, reason: collision with root package name */
    public int[] f71022h = new int[0];

    /* renamed from: i, reason: collision with root package name */
    public int[] f71023i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public long[] f71024j = new long[0];

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f71025k = new boolean[0];

    /* renamed from: m, reason: collision with root package name */
    public boolean[] f71027m = new boolean[0];

    /* renamed from: o, reason: collision with root package name */
    public final d0 f71029o = new d0();

    public void a(d0 d0Var) {
        d0Var.j(this.f71029o.d(), 0, this.f71029o.f());
        this.f71029o.P(0);
        this.f71030p = false;
    }

    public void b(g9.m mVar) {
        mVar.readFully(this.f71029o.d(), 0, this.f71029o.f());
        this.f71029o.P(0);
        this.f71030p = false;
    }

    public long c(int i11) {
        return this.f71024j[i11];
    }

    public void d(int i11) {
        this.f71029o.L(i11);
        this.f71026l = true;
        this.f71030p = true;
    }

    public void e(int i11, int i12) {
        this.f71019e = i11;
        this.f71020f = i12;
        if (this.f71022h.length < i11) {
            this.f71021g = new long[i11];
            this.f71022h = new int[i11];
        }
        if (this.f71023i.length < i12) {
            int i13 = (i12 * Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) / 100;
            this.f71023i = new int[i13];
            this.f71024j = new long[i13];
            this.f71025k = new boolean[i13];
            this.f71027m = new boolean[i13];
        }
    }

    public void f() {
        this.f71019e = 0;
        this.f71031q = 0L;
        this.f71032r = false;
        this.f71026l = false;
        this.f71030p = false;
        this.f71028n = null;
    }

    public boolean g(int i11) {
        return this.f71026l && this.f71027m[i11];
    }
}

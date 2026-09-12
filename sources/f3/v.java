package f3;

import androidx.media3.common.util.j0;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes2.dex */
final class v {

    /* renamed from: a, reason: collision with root package name */
    public c f62431a;

    /* renamed from: b, reason: collision with root package name */
    public long f62432b;

    /* renamed from: c, reason: collision with root package name */
    public long f62433c;

    /* renamed from: d, reason: collision with root package name */
    public long f62434d;

    /* renamed from: e, reason: collision with root package name */
    public int f62435e;

    /* renamed from: f, reason: collision with root package name */
    public int f62436f;

    /* renamed from: l, reason: collision with root package name */
    public boolean f62442l;

    /* renamed from: n, reason: collision with root package name */
    public u f62444n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f62446p;

    /* renamed from: q, reason: collision with root package name */
    public long f62447q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f62448r;

    /* renamed from: g, reason: collision with root package name */
    public long[] f62437g = new long[0];

    /* renamed from: h, reason: collision with root package name */
    public int[] f62438h = new int[0];

    /* renamed from: i, reason: collision with root package name */
    public int[] f62439i = new int[0];

    /* renamed from: j, reason: collision with root package name */
    public long[] f62440j = new long[0];

    /* renamed from: k, reason: collision with root package name */
    public boolean[] f62441k = new boolean[0];

    /* renamed from: m, reason: collision with root package name */
    public boolean[] f62443m = new boolean[0];

    /* renamed from: o, reason: collision with root package name */
    public final j0 f62445o = new j0();

    public void a(j0 j0Var) {
        j0Var.l(this.f62445o.e(), 0, this.f62445o.g());
        this.f62445o.W(0);
        this.f62446p = false;
    }

    public void b(l2.s sVar) {
        sVar.readFully(this.f62445o.e(), 0, this.f62445o.g());
        this.f62445o.W(0);
        this.f62446p = false;
    }

    public long c(int i11) {
        return this.f62440j[i11];
    }

    public void d(int i11) {
        this.f62445o.S(i11);
        this.f62442l = true;
        this.f62446p = true;
    }

    public void e(int i11, int i12) {
        this.f62435e = i11;
        this.f62436f = i12;
        if (this.f62438h.length < i11) {
            this.f62437g = new long[i11];
            this.f62438h = new int[i11];
        }
        if (this.f62439i.length < i12) {
            int i13 = (i12 * Sdk$SDKError.Reason.INVALID_METRICS_ENDPOINT_VALUE) / 100;
            this.f62439i = new int[i13];
            this.f62440j = new long[i13];
            this.f62441k = new boolean[i13];
            this.f62443m = new boolean[i13];
        }
    }

    public void f() {
        this.f62435e = 0;
        this.f62447q = 0L;
        this.f62448r = false;
        this.f62442l = false;
        this.f62446p = false;
        this.f62444n = null;
    }

    public boolean g(int i11) {
        return this.f62442l && this.f62443m[i11];
    }
}

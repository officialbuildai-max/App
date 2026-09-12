package nf;

import gf.c;
import gf.d;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes5.dex */
public final class a {
    public static final byte[] A = {68, 88, 68, 73, 70, 70};

    /* renamed from: a, reason: collision with root package name */
    private final ff.a f70548a;

    /* renamed from: b, reason: collision with root package name */
    private short f70549b;

    /* renamed from: c, reason: collision with root package name */
    private int f70550c;

    /* renamed from: d, reason: collision with root package name */
    private int f70551d;

    /* renamed from: e, reason: collision with root package name */
    private int f70552e;

    /* renamed from: f, reason: collision with root package name */
    private int f70553f;

    /* renamed from: g, reason: collision with root package name */
    private int f70554g;

    /* renamed from: h, reason: collision with root package name */
    private int f70555h;

    /* renamed from: i, reason: collision with root package name */
    private int f70556i;

    /* renamed from: j, reason: collision with root package name */
    private int f70557j;

    /* renamed from: k, reason: collision with root package name */
    private int f70558k;

    /* renamed from: l, reason: collision with root package name */
    private int f70559l;

    /* renamed from: m, reason: collision with root package name */
    private int f70560m;

    /* renamed from: n, reason: collision with root package name */
    private int f70561n;

    /* renamed from: o, reason: collision with root package name */
    private int f70562o;

    /* renamed from: p, reason: collision with root package name */
    private int f70563p;

    /* renamed from: q, reason: collision with root package name */
    private int f70564q;

    /* renamed from: r, reason: collision with root package name */
    private int f70565r;

    /* renamed from: s, reason: collision with root package name */
    private int f70566s;

    /* renamed from: t, reason: collision with root package name */
    private int f70567t;

    /* renamed from: u, reason: collision with root package name */
    private int f70568u;

    /* renamed from: v, reason: collision with root package name */
    private int f70569v;

    /* renamed from: w, reason: collision with root package name */
    private int f70570w;

    /* renamed from: x, reason: collision with root package name */
    private int f70571x;

    /* renamed from: y, reason: collision with root package name */
    private int f70572y;

    /* renamed from: z, reason: collision with root package name */
    private byte[] f70573z;

    public a(InputStream inputStream) {
        this.f70548a = new ff.a(ByteBuffer.wrap(d.a(inputStream)));
        z();
    }

    private void z() {
        ff.a aVar = this.f70548a;
        byte[] bArr = A;
        byte[] l11 = aVar.l(bArr.length);
        if (c.d(l11, bArr) != 0) {
            throw new IllegalStateException("bad dex patch file magic: " + Arrays.toString(l11));
        }
        short B = this.f70548a.B();
        this.f70549b = B;
        if (B != 2 && B != 3) {
            throw new IllegalStateException("bad dex patch file version: " + ((int) this.f70549b));
        }
        if (B > 2) {
            this.f70550c = this.f70548a.w();
            this.f70551d = this.f70548a.w();
        }
        this.f70552e = this.f70548a.w();
        this.f70553f = this.f70548a.w();
        this.f70554g = this.f70548a.w();
        this.f70555h = this.f70548a.w();
        this.f70556i = this.f70548a.w();
        this.f70557j = this.f70548a.w();
        this.f70558k = this.f70548a.w();
        if (this.f70549b > 2) {
            this.f70559l = this.f70548a.w();
            this.f70560m = this.f70548a.w();
        }
        this.f70561n = this.f70548a.w();
        this.f70562o = this.f70548a.w();
        this.f70563p = this.f70548a.w();
        this.f70564q = this.f70548a.w();
        this.f70565r = this.f70548a.w();
        this.f70566s = this.f70548a.w();
        this.f70567t = this.f70548a.w();
        this.f70568u = this.f70548a.w();
        this.f70569v = this.f70548a.w();
        this.f70570w = this.f70548a.w();
        this.f70571x = this.f70548a.w();
        this.f70572y = this.f70548a.w();
        this.f70573z = this.f70548a.l(20);
        this.f70548a.g(this.f70553f);
    }

    public ff.a a() {
        return this.f70548a;
    }

    public int b() {
        return this.f70550c;
    }

    public byte[] c() {
        return this.f70573z;
    }

    public int d() {
        return this.f70570w;
    }

    public int e() {
        return this.f70564q;
    }

    public int f() {
        return this.f70565r;
    }

    public int g() {
        return this.f70572y;
    }

    public int h() {
        return this.f70559l;
    }

    public int i() {
        return this.f70566s;
    }

    public int j() {
        return this.f70561n;
    }

    public int k() {
        return this.f70567t;
    }

    public int l() {
        return this.f70569v;
    }

    public int m() {
        return this.f70551d;
    }

    public int n() {
        return this.f70552e;
    }

    public int o() {
        return this.f70571x;
    }

    public int p() {
        return this.f70557j;
    }

    public int q() {
        return this.f70562o;
    }

    public int r() {
        return this.f70560m;
    }

    public int s() {
        return this.f70558k;
    }

    public int t() {
        return this.f70556i;
    }

    public int u() {
        return this.f70568u;
    }

    public int v() {
        return this.f70554g;
    }

    public int w() {
        return this.f70555h;
    }

    public int x() {
        return this.f70563p;
    }

    public short y() {
        return this.f70549b;
    }
}

package com.google.firebase.perf.config;

import android.content.Context;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static final sc.a f32281d = sc.a.e();

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f32282e;

    /* renamed from: a, reason: collision with root package name */
    private final RemoteConfigManager f32283a;

    /* renamed from: b, reason: collision with root package name */
    private com.google.firebase.perf.util.d f32284b;

    /* renamed from: c, reason: collision with root package name */
    private w f32285c;

    public a(RemoteConfigManager remoteConfigManager, com.google.firebase.perf.util.d dVar, w wVar) {
        this.f32283a = remoteConfigManager == null ? RemoteConfigManager.getInstance() : remoteConfigManager;
        this.f32284b = dVar == null ? new com.google.firebase.perf.util.d() : dVar;
        this.f32285c = wVar == null ? w.e() : wVar;
    }

    private boolean H(long j11) {
        return j11 >= 0;
    }

    private boolean I(String str) {
        if (str.trim().isEmpty()) {
            return false;
        }
        for (String str2 : str.split(";")) {
            if (str2.trim().equals(pc.a.f72531b)) {
                return true;
            }
        }
        return false;
    }

    private boolean J(long j11) {
        return j11 >= 0;
    }

    private boolean L(double d11) {
        return 0.0d <= d11 && d11 <= 1.0d;
    }

    private boolean M(long j11) {
        return j11 > 0;
    }

    private boolean N(long j11) {
        return j11 > 0;
    }

    private com.google.firebase.perf.util.e b(u uVar) {
        return this.f32285c.b(uVar.a());
    }

    private com.google.firebase.perf.util.e c(u uVar) {
        return this.f32285c.c(uVar.a());
    }

    private com.google.firebase.perf.util.e d(u uVar) {
        return this.f32285c.f(uVar.a());
    }

    private com.google.firebase.perf.util.e e(u uVar) {
        return this.f32285c.g(uVar.a());
    }

    public static synchronized a g() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f32282e == null) {
                    f32282e = new a(null, null, null);
                }
                aVar = f32282e;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private boolean k() {
        k e11 = k.e();
        com.google.firebase.perf.util.e u11 = u(e11);
        if (!u11.d()) {
            com.google.firebase.perf.util.e b11 = b(e11);
            return b11.d() ? ((Boolean) b11.c()).booleanValue() : e11.d().booleanValue();
        }
        if (this.f32283a.isLastFetchFailed()) {
            return false;
        }
        this.f32285c.m(e11.a(), ((Boolean) u11.c()).booleanValue());
        return ((Boolean) u11.c()).booleanValue();
    }

    private boolean l() {
        j e11 = j.e();
        com.google.firebase.perf.util.e x10 = x(e11);
        if (x10.d()) {
            this.f32285c.l(e11.a(), (String) x10.c());
            return I((String) x10.c());
        }
        com.google.firebase.perf.util.e e12 = e(e11);
        return e12.d() ? I((String) e12.c()) : I(e11.d());
    }

    private com.google.firebase.perf.util.e n(u uVar) {
        return this.f32284b.b(uVar.b());
    }

    private com.google.firebase.perf.util.e o(u uVar) {
        return this.f32284b.c(uVar.b());
    }

    private com.google.firebase.perf.util.e p(u uVar) {
        return this.f32284b.e(uVar.b());
    }

    private com.google.firebase.perf.util.e u(u uVar) {
        return this.f32283a.getBoolean(uVar.c());
    }

    private com.google.firebase.perf.util.e v(u uVar) {
        return this.f32283a.getDouble(uVar.c());
    }

    private com.google.firebase.perf.util.e w(u uVar) {
        return this.f32283a.getLong(uVar.c());
    }

    private com.google.firebase.perf.util.e x(u uVar) {
        return this.f32283a.getString(uVar.c());
    }

    public long A() {
        n e11 = n.e();
        com.google.firebase.perf.util.e p11 = p(e11);
        if (p11.d() && M(((Long) p11.c()).longValue())) {
            return ((Long) p11.c()).longValue();
        }
        com.google.firebase.perf.util.e w11 = w(e11);
        if (w11.d() && M(((Long) w11.c()).longValue())) {
            this.f32285c.k(e11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(e11);
        return (d11.d() && M(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : e11.d().longValue();
    }

    public long B() {
        o e11 = o.e();
        com.google.firebase.perf.util.e p11 = p(e11);
        if (p11.d() && J(((Long) p11.c()).longValue())) {
            return ((Long) p11.c()).longValue();
        }
        com.google.firebase.perf.util.e w11 = w(e11);
        if (w11.d() && J(((Long) w11.c()).longValue())) {
            this.f32285c.k(e11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(e11);
        return (d11.d() && J(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : e11.d().longValue();
    }

    public long C() {
        p f11 = p.f();
        com.google.firebase.perf.util.e p11 = p(f11);
        if (p11.d() && J(((Long) p11.c()).longValue())) {
            return ((Long) p11.c()).longValue();
        }
        com.google.firebase.perf.util.e w11 = w(f11);
        if (w11.d() && J(((Long) w11.c()).longValue())) {
            this.f32285c.k(f11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(f11);
        return (d11.d() && J(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : this.f32283a.isLastFetchFailed() ? f11.e().longValue() : f11.d().longValue();
    }

    public double D() {
        q f11 = q.f();
        com.google.firebase.perf.util.e o11 = o(f11);
        if (o11.d()) {
            double doubleValue = ((Double) o11.c()).doubleValue() / 100.0d;
            if (L(doubleValue)) {
                return doubleValue;
            }
        }
        com.google.firebase.perf.util.e v11 = v(f11);
        if (v11.d() && L(((Double) v11.c()).doubleValue())) {
            this.f32285c.j(f11.a(), ((Double) v11.c()).doubleValue());
            return ((Double) v11.c()).doubleValue();
        }
        com.google.firebase.perf.util.e c11 = c(f11);
        return (c11.d() && L(((Double) c11.c()).doubleValue())) ? ((Double) c11.c()).doubleValue() : this.f32283a.isLastFetchFailed() ? f11.e().doubleValue() : f11.d().doubleValue();
    }

    public long E() {
        r e11 = r.e();
        com.google.firebase.perf.util.e w11 = w(e11);
        if (w11.d() && H(((Long) w11.c()).longValue())) {
            this.f32285c.k(e11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(e11);
        return (d11.d() && H(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : e11.d().longValue();
    }

    public long F() {
        s e11 = s.e();
        com.google.firebase.perf.util.e w11 = w(e11);
        if (w11.d() && H(((Long) w11.c()).longValue())) {
            this.f32285c.k(e11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(e11);
        return (d11.d() && H(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : e11.d().longValue();
    }

    public double G() {
        t f11 = t.f();
        com.google.firebase.perf.util.e v11 = v(f11);
        if (v11.d() && L(((Double) v11.c()).doubleValue())) {
            this.f32285c.j(f11.a(), ((Double) v11.c()).doubleValue());
            return ((Double) v11.c()).doubleValue();
        }
        com.google.firebase.perf.util.e c11 = c(f11);
        return (c11.d() && L(((Double) c11.c()).doubleValue())) ? ((Double) c11.c()).doubleValue() : this.f32283a.isLastFetchFailed() ? f11.e().doubleValue() : f11.d().doubleValue();
    }

    public boolean K() {
        Boolean j11 = j();
        return (j11 == null || j11.booleanValue()) && m();
    }

    public void O(Context context) {
        f32281d.i(com.google.firebase.perf.util.k.b(context));
        this.f32285c.i(context);
    }

    public void P(com.google.firebase.perf.util.d dVar) {
        this.f32284b = dVar;
    }

    public String a() {
        String f11;
        ConfigurationConstants$LogSourceName e11 = ConfigurationConstants$LogSourceName.e();
        if (pc.a.f72530a.booleanValue()) {
            return e11.d();
        }
        String c11 = e11.c();
        long longValue = c11 != null ? ((Long) this.f32283a.getRemoteConfigValueOrDefault(c11, -1L)).longValue() : -1L;
        String a11 = e11.a();
        if (!ConfigurationConstants$LogSourceName.g(longValue) || (f11 = ConfigurationConstants$LogSourceName.f(longValue)) == null) {
            com.google.firebase.perf.util.e e12 = e(e11);
            return e12.d() ? (String) e12.c() : e11.d();
        }
        this.f32285c.l(a11, f11);
        return f11;
    }

    public double f() {
        e e11 = e.e();
        com.google.firebase.perf.util.e o11 = o(e11);
        if (o11.d()) {
            double doubleValue = ((Double) o11.c()).doubleValue() / 100.0d;
            if (L(doubleValue)) {
                return doubleValue;
            }
        }
        com.google.firebase.perf.util.e v11 = v(e11);
        if (v11.d() && L(((Double) v11.c()).doubleValue())) {
            this.f32285c.j(e11.a(), ((Double) v11.c()).doubleValue());
            return ((Double) v11.c()).doubleValue();
        }
        com.google.firebase.perf.util.e c11 = c(e11);
        return (c11.d() && L(((Double) c11.c()).doubleValue())) ? ((Double) c11.c()).doubleValue() : e11.d().doubleValue();
    }

    public boolean h() {
        d e11 = d.e();
        com.google.firebase.perf.util.e n11 = n(e11);
        if (n11.d()) {
            return ((Boolean) n11.c()).booleanValue();
        }
        com.google.firebase.perf.util.e u11 = u(e11);
        if (u11.d()) {
            this.f32285c.m(e11.a(), ((Boolean) u11.c()).booleanValue());
            return ((Boolean) u11.c()).booleanValue();
        }
        com.google.firebase.perf.util.e b11 = b(e11);
        return b11.d() ? ((Boolean) b11.c()).booleanValue() : e11.d().booleanValue();
    }

    public Boolean i() {
        b e11 = b.e();
        com.google.firebase.perf.util.e n11 = n(e11);
        return n11.d() ? (Boolean) n11.c() : e11.d();
    }

    public Boolean j() {
        if (i().booleanValue()) {
            return Boolean.FALSE;
        }
        c d11 = c.d();
        com.google.firebase.perf.util.e b11 = b(d11);
        if (b11.d()) {
            return (Boolean) b11.c();
        }
        com.google.firebase.perf.util.e n11 = n(d11);
        if (n11.d()) {
            return (Boolean) n11.c();
        }
        return null;
    }

    public boolean m() {
        return k() && !l();
    }

    public long q() {
        f e11 = f.e();
        com.google.firebase.perf.util.e w11 = w(e11);
        if (w11.d() && H(((Long) w11.c()).longValue())) {
            this.f32285c.k(e11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(e11);
        return (d11.d() && H(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : e11.d().longValue();
    }

    public long r() {
        g e11 = g.e();
        com.google.firebase.perf.util.e w11 = w(e11);
        if (w11.d() && H(((Long) w11.c()).longValue())) {
            this.f32285c.k(e11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(e11);
        return (d11.d() && H(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : e11.d().longValue();
    }

    public double s() {
        h f11 = h.f();
        com.google.firebase.perf.util.e v11 = v(f11);
        if (v11.d() && L(((Double) v11.c()).doubleValue())) {
            this.f32285c.j(f11.a(), ((Double) v11.c()).doubleValue());
            return ((Double) v11.c()).doubleValue();
        }
        com.google.firebase.perf.util.e c11 = c(f11);
        return (c11.d() && L(((Double) c11.c()).doubleValue())) ? ((Double) c11.c()).doubleValue() : this.f32283a.isLastFetchFailed() ? f11.e().doubleValue() : f11.d().doubleValue();
    }

    public long t() {
        i e11 = i.e();
        com.google.firebase.perf.util.e w11 = w(e11);
        if (w11.d() && N(((Long) w11.c()).longValue())) {
            this.f32285c.k(e11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(e11);
        return (d11.d() && N(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : e11.d().longValue();
    }

    public long y() {
        l e11 = l.e();
        com.google.firebase.perf.util.e p11 = p(e11);
        if (p11.d() && J(((Long) p11.c()).longValue())) {
            return ((Long) p11.c()).longValue();
        }
        com.google.firebase.perf.util.e w11 = w(e11);
        if (w11.d() && J(((Long) w11.c()).longValue())) {
            this.f32285c.k(e11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(e11);
        return (d11.d() && J(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : e11.d().longValue();
    }

    public long z() {
        m f11 = m.f();
        com.google.firebase.perf.util.e p11 = p(f11);
        if (p11.d() && J(((Long) p11.c()).longValue())) {
            return ((Long) p11.c()).longValue();
        }
        com.google.firebase.perf.util.e w11 = w(f11);
        if (w11.d() && J(((Long) w11.c()).longValue())) {
            this.f32285c.k(f11.a(), ((Long) w11.c()).longValue());
            return ((Long) w11.c()).longValue();
        }
        com.google.firebase.perf.util.e d11 = d(f11);
        return (d11.d() && J(((Long) d11.c()).longValue())) ? ((Long) d11.c()).longValue() : this.f32283a.isLastFetchFailed() ? f11.e().longValue() : f11.d().longValue();
    }
}

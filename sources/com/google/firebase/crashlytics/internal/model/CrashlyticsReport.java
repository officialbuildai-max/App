package com.google.firebase.crashlytics.internal.model;

import com.google.firebase.crashlytics.internal.model.a0;
import com.google.firebase.crashlytics.internal.model.b;
import com.google.firebase.crashlytics.internal.model.c;
import com.google.firebase.crashlytics.internal.model.d;
import com.google.firebase.crashlytics.internal.model.e;
import com.google.firebase.crashlytics.internal.model.f;
import com.google.firebase.crashlytics.internal.model.g;
import com.google.firebase.crashlytics.internal.model.h;
import com.google.firebase.crashlytics.internal.model.i;
import com.google.firebase.crashlytics.internal.model.k;
import com.google.firebase.crashlytics.internal.model.l;
import com.google.firebase.crashlytics.internal.model.m;
import com.google.firebase.crashlytics.internal.model.n;
import com.google.firebase.crashlytics.internal.model.o;
import com.google.firebase.crashlytics.internal.model.p;
import com.google.firebase.crashlytics.internal.model.q;
import com.google.firebase.crashlytics.internal.model.r;
import com.google.firebase.crashlytics.internal.model.s;
import com.google.firebase.crashlytics.internal.model.t;
import com.google.firebase.crashlytics.internal.model.u;
import com.google.firebase.crashlytics.internal.model.v;
import com.google.firebase.crashlytics.internal.model.w;
import com.google.firebase.crashlytics.internal.model.x;
import com.google.firebase.crashlytics.internal.model.y;
import com.google.firebase.crashlytics.internal.model.z;
import java.nio.charset.Charset;
import java.util.List;

/* loaded from: classes.dex */
public abstract class CrashlyticsReport {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f31364a = Charset.forName("UTF-8");

    /* loaded from: classes4.dex */
    public enum Type {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    /* loaded from: classes4.dex */
    public static abstract class a {

        /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static abstract class AbstractC0421a {

            /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$a$a$a, reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public static abstract class AbstractC0422a {
                public abstract AbstractC0421a a();

                public abstract AbstractC0422a b(String str);

                public abstract AbstractC0422a c(String str);

                public abstract AbstractC0422a d(String str);
            }

            public static AbstractC0422a a() {
                return new d.b();
            }

            public abstract String b();

            public abstract String c();

            public abstract String d();
        }

        /* loaded from: classes4.dex */
        public static abstract class b {
            public abstract a a();

            public abstract b b(List list);

            public abstract b c(int i11);

            public abstract b d(int i11);

            public abstract b e(String str);

            public abstract b f(long j11);

            public abstract b g(int i11);

            public abstract b h(long j11);

            public abstract b i(long j11);

            public abstract b j(String str);
        }

        public static b a() {
            return new c.b();
        }

        public abstract List b();

        public abstract int c();

        public abstract int d();

        public abstract String e();

        public abstract long f();

        public abstract int g();

        public abstract long h();

        public abstract long i();

        public abstract String j();
    }

    /* loaded from: classes4.dex */
    public static abstract class b {
        public abstract CrashlyticsReport a();

        public abstract b b(a aVar);

        public abstract b c(String str);

        public abstract b d(String str);

        public abstract b e(String str);

        public abstract b f(String str);

        public abstract b g(String str);

        public abstract b h(String str);

        public abstract b i(String str);

        public abstract b j(d dVar);

        public abstract b k(int i11);

        public abstract b l(String str);

        public abstract b m(e eVar);
    }

    /* loaded from: classes4.dex */
    public static abstract class c {

        /* loaded from: classes4.dex */
        public static abstract class a {
            public abstract c a();

            public abstract a b(String str);

            public abstract a c(String str);
        }

        public static a a() {
            return new e.b();
        }

        public abstract String b();

        public abstract String c();
    }

    /* loaded from: classes4.dex */
    public static abstract class d {

        /* loaded from: classes4.dex */
        public static abstract class a {
            public abstract d a();

            public abstract a b(List list);

            public abstract a c(String str);
        }

        /* loaded from: classes4.dex */
        public static abstract class b {

            /* loaded from: classes4.dex */
            public static abstract class a {
                public abstract b a();

                public abstract a b(byte[] bArr);

                public abstract a c(String str);
            }

            public static a a() {
                return new g.b();
            }

            public abstract byte[] b();

            public abstract String c();
        }

        public static a a() {
            return new f.b();
        }

        public abstract List b();

        public abstract String c();
    }

    /* loaded from: classes4.dex */
    public static abstract class e {

        /* loaded from: classes4.dex */
        public static abstract class a {

            /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$a$a, reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public static abstract class AbstractC0423a {
                public abstract a a();

                public abstract AbstractC0423a b(String str);

                public abstract AbstractC0423a c(String str);

                public abstract AbstractC0423a d(String str);

                public abstract AbstractC0423a e(String str);

                public abstract AbstractC0423a f(String str);

                public abstract AbstractC0423a g(String str);
            }

            /* loaded from: classes4.dex */
            public static abstract class b {
                public abstract String a();
            }

            public static AbstractC0423a a() {
                return new i.b();
            }

            public abstract String b();

            public abstract String c();

            public abstract String d();

            public abstract String e();

            public abstract String f();

            public abstract b g();

            public abstract String h();
        }

        /* loaded from: classes4.dex */
        public static abstract class b {
            public abstract e a();

            public abstract b b(a aVar);

            public abstract b c(String str);

            public abstract b d(boolean z10);

            public abstract b e(c cVar);

            public abstract b f(Long l11);

            public abstract b g(List list);

            public abstract b h(String str);

            public abstract b i(int i11);

            public abstract b j(String str);

            public b k(byte[] bArr) {
                return j(new String(bArr, CrashlyticsReport.f31364a));
            }

            public abstract b l(AbstractC0438e abstractC0438e);

            public abstract b m(long j11);

            public abstract b n(f fVar);
        }

        /* loaded from: classes4.dex */
        public static abstract class c {

            /* loaded from: classes4.dex */
            public static abstract class a {
                public abstract c a();

                public abstract a b(int i11);

                public abstract a c(int i11);

                public abstract a d(long j11);

                public abstract a e(String str);

                public abstract a f(String str);

                public abstract a g(String str);

                public abstract a h(long j11);

                public abstract a i(boolean z10);

                public abstract a j(int i11);
            }

            public static a a() {
                return new k.b();
            }

            public abstract int b();

            public abstract int c();

            public abstract long d();

            public abstract String e();

            public abstract String f();

            public abstract String g();

            public abstract long h();

            public abstract int i();

            public abstract boolean j();
        }

        /* loaded from: classes4.dex */
        public static abstract class d {

            /* loaded from: classes4.dex */
            public static abstract class a {

                /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$a, reason: collision with other inner class name */
                /* loaded from: classes4.dex */
                public static abstract class AbstractC0424a {
                    public abstract a a();

                    public abstract AbstractC0424a b(List list);

                    public abstract AbstractC0424a c(Boolean bool);

                    public abstract AbstractC0424a d(c cVar);

                    public abstract AbstractC0424a e(List list);

                    public abstract AbstractC0424a f(b bVar);

                    public abstract AbstractC0424a g(List list);

                    public abstract AbstractC0424a h(int i11);
                }

                /* loaded from: classes4.dex */
                public static abstract class b {

                    /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$a, reason: collision with other inner class name */
                    /* loaded from: classes4.dex */
                    public static abstract class AbstractC0425a {

                        /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$a$a, reason: collision with other inner class name */
                        /* loaded from: classes4.dex */
                        public static abstract class AbstractC0426a {
                            public abstract AbstractC0425a a();

                            public abstract AbstractC0426a b(long j11);

                            public abstract AbstractC0426a c(String str);

                            public abstract AbstractC0426a d(long j11);

                            public abstract AbstractC0426a e(String str);

                            public AbstractC0426a f(byte[] bArr) {
                                return e(new String(bArr, CrashlyticsReport.f31364a));
                            }
                        }

                        public static AbstractC0426a a() {
                            return new o.b();
                        }

                        public abstract long b();

                        public abstract String c();

                        public abstract long d();

                        public abstract String e();

                        public byte[] f() {
                            String e11 = e();
                            if (e11 != null) {
                                return e11.getBytes(CrashlyticsReport.f31364a);
                            }
                            return null;
                        }
                    }

                    /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$b, reason: collision with other inner class name */
                    /* loaded from: classes4.dex */
                    public static abstract class AbstractC0427b {
                        public abstract b a();

                        public abstract AbstractC0427b b(a aVar);

                        public abstract AbstractC0427b c(List list);

                        public abstract AbstractC0427b d(c cVar);

                        public abstract AbstractC0427b e(AbstractC0429d abstractC0429d);

                        public abstract AbstractC0427b f(List list);
                    }

                    /* loaded from: classes4.dex */
                    public static abstract class c {

                        /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$c$a, reason: collision with other inner class name */
                        /* loaded from: classes4.dex */
                        public static abstract class AbstractC0428a {
                            public abstract c a();

                            public abstract AbstractC0428a b(c cVar);

                            public abstract AbstractC0428a c(List list);

                            public abstract AbstractC0428a d(int i11);

                            public abstract AbstractC0428a e(String str);

                            public abstract AbstractC0428a f(String str);
                        }

                        public static AbstractC0428a a() {
                            return new p.b();
                        }

                        public abstract c b();

                        public abstract List c();

                        public abstract int d();

                        public abstract String e();

                        public abstract String f();
                    }

                    /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$d, reason: collision with other inner class name */
                    /* loaded from: classes4.dex */
                    public static abstract class AbstractC0429d {

                        /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$d$a, reason: collision with other inner class name */
                        /* loaded from: classes4.dex */
                        public static abstract class AbstractC0430a {
                            public abstract AbstractC0429d a();

                            public abstract AbstractC0430a b(long j11);

                            public abstract AbstractC0430a c(String str);

                            public abstract AbstractC0430a d(String str);
                        }

                        public static AbstractC0430a a() {
                            return new q.b();
                        }

                        public abstract long b();

                        public abstract String c();

                        public abstract String d();
                    }

                    /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$e, reason: collision with other inner class name */
                    /* loaded from: classes4.dex */
                    public static abstract class AbstractC0431e {

                        /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$e$a, reason: collision with other inner class name */
                        /* loaded from: classes4.dex */
                        public static abstract class AbstractC0432a {
                            public abstract AbstractC0431e a();

                            public abstract AbstractC0432a b(List list);

                            public abstract AbstractC0432a c(int i11);

                            public abstract AbstractC0432a d(String str);
                        }

                        /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$e$b, reason: collision with other inner class name */
                        /* loaded from: classes4.dex */
                        public static abstract class AbstractC0433b {

                            /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$b$e$b$a, reason: collision with other inner class name */
                            /* loaded from: classes4.dex */
                            public static abstract class AbstractC0434a {
                                public abstract AbstractC0433b a();

                                public abstract AbstractC0434a b(String str);

                                public abstract AbstractC0434a c(int i11);

                                public abstract AbstractC0434a d(long j11);

                                public abstract AbstractC0434a e(long j11);

                                public abstract AbstractC0434a f(String str);
                            }

                            public static AbstractC0434a a() {
                                return new s.b();
                            }

                            public abstract String b();

                            public abstract int c();

                            public abstract long d();

                            public abstract long e();

                            public abstract String f();
                        }

                        public static AbstractC0432a a() {
                            return new r.b();
                        }

                        public abstract List b();

                        public abstract int c();

                        public abstract String d();
                    }

                    public static AbstractC0427b a() {
                        return new n.b();
                    }

                    public abstract a b();

                    public abstract List c();

                    public abstract c d();

                    public abstract AbstractC0429d e();

                    public abstract List f();
                }

                /* loaded from: classes4.dex */
                public static abstract class c {

                    /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$a$c$a, reason: collision with other inner class name */
                    /* loaded from: classes4.dex */
                    public static abstract class AbstractC0435a {
                        public abstract c a();

                        public abstract AbstractC0435a b(boolean z10);

                        public abstract AbstractC0435a c(int i11);

                        public abstract AbstractC0435a d(int i11);

                        public abstract AbstractC0435a e(String str);
                    }

                    public static AbstractC0435a a() {
                        return new t.b();
                    }

                    public abstract int b();

                    public abstract int c();

                    public abstract String d();

                    public abstract boolean e();
                }

                public static AbstractC0424a a() {
                    return new m.b();
                }

                public abstract List b();

                public abstract Boolean c();

                public abstract c d();

                public abstract List e();

                public abstract b f();

                public abstract List g();

                public abstract int h();

                public abstract AbstractC0424a i();
            }

            /* loaded from: classes4.dex */
            public static abstract class b {
                public abstract d a();

                public abstract b b(a aVar);

                public abstract b c(c cVar);

                public abstract b d(AbstractC0436d abstractC0436d);

                public abstract b e(f fVar);

                public abstract b f(long j11);

                public abstract b g(String str);
            }

            /* loaded from: classes4.dex */
            public static abstract class c {

                /* loaded from: classes4.dex */
                public static abstract class a {
                    public abstract c a();

                    public abstract a b(Double d11);

                    public abstract a c(int i11);

                    public abstract a d(long j11);

                    public abstract a e(int i11);

                    public abstract a f(boolean z10);

                    public abstract a g(long j11);
                }

                public static a a() {
                    return new u.b();
                }

                public abstract Double b();

                public abstract int c();

                public abstract long d();

                public abstract int e();

                public abstract long f();

                public abstract boolean g();
            }

            /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$d, reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public static abstract class AbstractC0436d {

                /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$d$a */
                /* loaded from: classes4.dex */
                public static abstract class a {
                    public abstract AbstractC0436d a();

                    public abstract a b(String str);
                }

                public static a a() {
                    return new v.b();
                }

                public abstract String b();
            }

            /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$e, reason: collision with other inner class name */
            /* loaded from: classes4.dex */
            public static abstract class AbstractC0437e {

                /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$e$a */
                /* loaded from: classes4.dex */
                public static abstract class a {
                    public abstract AbstractC0437e a();

                    public abstract a b(String str);

                    public abstract a c(String str);

                    public abstract a d(b bVar);

                    public abstract a e(long j11);
                }

                /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$e$b */
                /* loaded from: classes4.dex */
                public static abstract class b {

                    /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$d$e$b$a */
                    /* loaded from: classes4.dex */
                    public static abstract class a {
                        public abstract b a();

                        public abstract a b(String str);

                        public abstract a c(String str);
                    }

                    public static a a() {
                        return new x.b();
                    }

                    public abstract String b();

                    public abstract String c();
                }

                public static a a() {
                    return new w.b();
                }

                public abstract String b();

                public abstract String c();

                public abstract b d();

                public abstract long e();
            }

            /* loaded from: classes4.dex */
            public static abstract class f {

                /* loaded from: classes4.dex */
                public static abstract class a {
                    public abstract f a();

                    public abstract a b(List list);
                }

                public static a a() {
                    return new y.b();
                }

                public abstract List b();
            }

            public static b a() {
                return new l.b();
            }

            public abstract a b();

            public abstract c c();

            public abstract AbstractC0436d d();

            public abstract f e();

            public abstract long f();

            public abstract String g();

            public abstract b h();
        }

        /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$e, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static abstract class AbstractC0438e {

            /* renamed from: com.google.firebase.crashlytics.internal.model.CrashlyticsReport$e$e$a */
            /* loaded from: classes4.dex */
            public static abstract class a {
                public abstract AbstractC0438e a();

                public abstract a b(String str);

                public abstract a c(boolean z10);

                public abstract a d(int i11);

                public abstract a e(String str);
            }

            public static a a() {
                return new z.b();
            }

            public abstract String b();

            public abstract int c();

            public abstract String d();

            public abstract boolean e();
        }

        /* loaded from: classes4.dex */
        public static abstract class f {

            /* loaded from: classes4.dex */
            public static abstract class a {
                public abstract f a();

                public abstract a b(String str);
            }

            public static a a() {
                return new a0.b();
            }

            public abstract String b();
        }

        public static b a() {
            return new h.b().d(false);
        }

        public abstract a b();

        public abstract String c();

        public abstract c d();

        public abstract Long e();

        public abstract List f();

        public abstract String g();

        public abstract int h();

        public abstract String i();

        public byte[] j() {
            return i().getBytes(CrashlyticsReport.f31364a);
        }

        public abstract AbstractC0438e k();

        public abstract long l();

        public abstract f m();

        public abstract boolean n();

        public abstract b o();

        e p(String str) {
            return o().c(str).a();
        }

        e q(List list) {
            return o().g(list).a();
        }

        e r(long j11, boolean z10, String str) {
            b o11 = o();
            o11.f(Long.valueOf(j11));
            o11.d(z10);
            if (str != null) {
                o11.n(f.a().b(str).a());
            }
            return o11.a();
        }
    }

    public static b b() {
        return new b.C0440b();
    }

    public abstract a c();

    public abstract String d();

    public abstract String e();

    public abstract String f();

    public abstract String g();

    public abstract String h();

    public abstract String i();

    public abstract String j();

    public abstract d k();

    public abstract int l();

    public abstract String m();

    public abstract e n();

    protected abstract b o();

    public CrashlyticsReport p(String str) {
        b c11 = o().c(str);
        if (n() != null) {
            c11.m(n().p(str));
        }
        return c11.a();
    }

    public CrashlyticsReport q(a aVar) {
        return aVar == null ? this : o().b(aVar).a();
    }

    public CrashlyticsReport r(List list) {
        if (n() != null) {
            return o().m(n().q(list)).a();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    public CrashlyticsReport s(String str) {
        return o().f(str).a();
    }

    public CrashlyticsReport t(String str) {
        return o().g(str).a();
    }

    public CrashlyticsReport u(d dVar) {
        return o().m(null).j(dVar).a();
    }

    public CrashlyticsReport v(long j11, boolean z10, String str) {
        b o11 = o();
        if (n() != null) {
            o11.m(n().r(j11, z10, str));
        }
        return o11.a();
    }
}

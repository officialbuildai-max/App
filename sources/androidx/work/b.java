package androidx.work;

import android.os.Build;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.m1;
import kotlinx.coroutines.y0;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: v, reason: collision with root package name */
    public static final C0139b f15498v = new C0139b(null);

    /* renamed from: a, reason: collision with root package name */
    private final Executor f15499a;

    /* renamed from: b, reason: collision with root package name */
    private final CoroutineContext f15500b;

    /* renamed from: c, reason: collision with root package name */
    private final Executor f15501c;

    /* renamed from: d, reason: collision with root package name */
    private final androidx.work.a f15502d;

    /* renamed from: e, reason: collision with root package name */
    private final m0 f15503e;

    /* renamed from: f, reason: collision with root package name */
    private final l f15504f;

    /* renamed from: g, reason: collision with root package name */
    private final d0 f15505g;

    /* renamed from: h, reason: collision with root package name */
    private final androidx.core.util.a f15506h;

    /* renamed from: i, reason: collision with root package name */
    private final androidx.core.util.a f15507i;

    /* renamed from: j, reason: collision with root package name */
    private final androidx.core.util.a f15508j;

    /* renamed from: k, reason: collision with root package name */
    private final androidx.core.util.a f15509k;

    /* renamed from: l, reason: collision with root package name */
    private final String f15510l;

    /* renamed from: m, reason: collision with root package name */
    private final long f15511m;

    /* renamed from: n, reason: collision with root package name */
    private final int f15512n;

    /* renamed from: o, reason: collision with root package name */
    private final int f15513o;

    /* renamed from: p, reason: collision with root package name */
    private final int f15514p;

    /* renamed from: q, reason: collision with root package name */
    private final int f15515q;

    /* renamed from: r, reason: collision with root package name */
    private final int f15516r;

    /* renamed from: s, reason: collision with root package name */
    private final boolean f15517s;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f15518t;

    /* renamed from: u, reason: collision with root package name */
    private final f0 f15519u;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private Executor f15520a;

        /* renamed from: b, reason: collision with root package name */
        private CoroutineContext f15521b;

        /* renamed from: c, reason: collision with root package name */
        private m0 f15522c;

        /* renamed from: d, reason: collision with root package name */
        private l f15523d;

        /* renamed from: e, reason: collision with root package name */
        private Executor f15524e;

        /* renamed from: f, reason: collision with root package name */
        private androidx.work.a f15525f;

        /* renamed from: g, reason: collision with root package name */
        private d0 f15526g;

        /* renamed from: h, reason: collision with root package name */
        private androidx.core.util.a f15527h;

        /* renamed from: i, reason: collision with root package name */
        private androidx.core.util.a f15528i;

        /* renamed from: j, reason: collision with root package name */
        private androidx.core.util.a f15529j;

        /* renamed from: k, reason: collision with root package name */
        private androidx.core.util.a f15530k;

        /* renamed from: l, reason: collision with root package name */
        private String f15531l;

        /* renamed from: o, reason: collision with root package name */
        private int f15534o;

        /* renamed from: t, reason: collision with root package name */
        private f0 f15539t;

        /* renamed from: m, reason: collision with root package name */
        private long f15532m = 600000;

        /* renamed from: n, reason: collision with root package name */
        private int f15533n = 4;

        /* renamed from: p, reason: collision with root package name */
        private int f15535p = Integer.MAX_VALUE;

        /* renamed from: q, reason: collision with root package name */
        private int f15536q = 20;

        /* renamed from: r, reason: collision with root package name */
        private int f15537r = 8;

        /* renamed from: s, reason: collision with root package name */
        private boolean f15538s = true;

        public final b a() {
            return new b(this);
        }

        public final androidx.work.a b() {
            return this.f15525f;
        }

        public final int c() {
            return this.f15537r;
        }

        public final String d() {
            return this.f15531l;
        }

        public final Executor e() {
            return this.f15520a;
        }

        public final androidx.core.util.a f() {
            return this.f15527h;
        }

        public final l g() {
            return this.f15523d;
        }

        public final int h() {
            return this.f15533n;
        }

        public final boolean i() {
            return this.f15538s;
        }

        public final int j() {
            return this.f15535p;
        }

        public final int k() {
            return this.f15536q;
        }

        public final int l() {
            return this.f15534o;
        }

        public final long m() {
            return this.f15532m;
        }

        public final d0 n() {
            return this.f15526g;
        }

        public final androidx.core.util.a o() {
            return this.f15528i;
        }

        public final Executor p() {
            return this.f15524e;
        }

        public final f0 q() {
            return this.f15539t;
        }

        public final CoroutineContext r() {
            return this.f15521b;
        }

        public final androidx.core.util.a s() {
            return this.f15530k;
        }

        public final m0 t() {
            return this.f15522c;
        }

        public final androidx.core.util.a u() {
            return this.f15529j;
        }

        public final a v(String processName) {
            Intrinsics.h(processName, "processName");
            this.f15531l = processName;
            return this;
        }

        public final a w(androidx.core.util.a exceptionHandler) {
            Intrinsics.h(exceptionHandler, "exceptionHandler");
            this.f15527h = exceptionHandler;
            return this;
        }

        public final a x(int i11) {
            this.f15533n = i11;
            return this;
        }
    }

    /* renamed from: androidx.work.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0139b {
        private C0139b() {
        }

        public /* synthetic */ C0139b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        b getWorkManagerConfiguration();
    }

    public b(a builder) {
        Intrinsics.h(builder, "builder");
        CoroutineContext r11 = builder.r();
        Executor e11 = builder.e();
        if (e11 == null) {
            e11 = r11 != null ? androidx.work.c.a(r11) : null;
            if (e11 == null) {
                e11 = androidx.work.c.b(false);
            }
        }
        this.f15499a = e11;
        this.f15500b = r11 == null ? builder.e() != null ? m1.b(e11) : y0.a() : r11;
        this.f15517s = builder.p() == null;
        Executor p11 = builder.p();
        this.f15501c = p11 == null ? androidx.work.c.b(true) : p11;
        androidx.work.a b11 = builder.b();
        this.f15502d = b11 == null ? new e0() : b11;
        m0 t11 = builder.t();
        this.f15503e = t11 == null ? h.f15570a : t11;
        l g11 = builder.g();
        this.f15504f = g11 == null ? u.f16138a : g11;
        d0 n11 = builder.n();
        this.f15505g = n11 == null ? new androidx.work.impl.d() : n11;
        this.f15512n = builder.h();
        this.f15513o = builder.l();
        this.f15514p = builder.j();
        this.f15516r = Build.VERSION.SDK_INT == 23 ? builder.k() / 2 : builder.k();
        this.f15506h = builder.f();
        this.f15507i = builder.o();
        this.f15508j = builder.u();
        this.f15509k = builder.s();
        this.f15510l = builder.d();
        this.f15511m = builder.m();
        this.f15515q = builder.c();
        this.f15518t = builder.i();
        f0 q11 = builder.q();
        this.f15519u = q11 == null ? androidx.work.c.c() : q11;
    }

    public final androidx.work.a a() {
        return this.f15502d;
    }

    public final int b() {
        return this.f15515q;
    }

    public final String c() {
        return this.f15510l;
    }

    public final Executor d() {
        return this.f15499a;
    }

    public final androidx.core.util.a e() {
        return this.f15506h;
    }

    public final l f() {
        return this.f15504f;
    }

    public final int g() {
        return this.f15514p;
    }

    public final int h() {
        return this.f15516r;
    }

    public final int i() {
        return this.f15513o;
    }

    public final int j() {
        return this.f15512n;
    }

    public final d0 k() {
        return this.f15505g;
    }

    public final androidx.core.util.a l() {
        return this.f15507i;
    }

    public final Executor m() {
        return this.f15501c;
    }

    public final f0 n() {
        return this.f15519u;
    }

    public final CoroutineContext o() {
        return this.f15500b;
    }

    public final androidx.core.util.a p() {
        return this.f15509k;
    }

    public final m0 q() {
        return this.f15503e;
    }

    public final androidx.core.util.a r() {
        return this.f15508j;
    }

    public final boolean s() {
        return this.f15518t;
    }
}

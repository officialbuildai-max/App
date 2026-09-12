package vc;

import android.content.Context;
import com.google.firebase.perf.util.Constants$TraceNames;
import com.google.firebase.perf.util.Timer;
import com.google.firebase.perf.v1.SessionVerbosity;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.firebase.perf.config.a f77335a;

    /* renamed from: b, reason: collision with root package name */
    private final double f77336b;

    /* renamed from: c, reason: collision with root package name */
    private final double f77337c;

    /* renamed from: d, reason: collision with root package name */
    private a f77338d;

    /* renamed from: e, reason: collision with root package name */
    private a f77339e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f77340f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: k, reason: collision with root package name */
        private static final sc.a f77341k = sc.a.e();

        /* renamed from: l, reason: collision with root package name */
        private static final long f77342l = TimeUnit.SECONDS.toMicros(1);

        /* renamed from: a, reason: collision with root package name */
        private final com.google.firebase.perf.util.a f77343a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f77344b;

        /* renamed from: c, reason: collision with root package name */
        private Timer f77345c;

        /* renamed from: d, reason: collision with root package name */
        private com.google.firebase.perf.util.g f77346d;

        /* renamed from: e, reason: collision with root package name */
        private long f77347e;

        /* renamed from: f, reason: collision with root package name */
        private double f77348f;

        /* renamed from: g, reason: collision with root package name */
        private com.google.firebase.perf.util.g f77349g;

        /* renamed from: h, reason: collision with root package name */
        private com.google.firebase.perf.util.g f77350h;

        /* renamed from: i, reason: collision with root package name */
        private long f77351i;

        /* renamed from: j, reason: collision with root package name */
        private long f77352j;

        a(com.google.firebase.perf.util.g gVar, long j11, com.google.firebase.perf.util.a aVar, com.google.firebase.perf.config.a aVar2, String str, boolean z10) {
            this.f77343a = aVar;
            this.f77347e = j11;
            this.f77346d = gVar;
            this.f77348f = j11;
            this.f77345c = aVar.a();
            g(aVar2, str, z10);
            this.f77344b = z10;
        }

        private static long c(com.google.firebase.perf.config.a aVar, String str) {
            return str == "Trace" ? aVar.E() : aVar.q();
        }

        private static long d(com.google.firebase.perf.config.a aVar, String str) {
            return str == "Trace" ? aVar.t() : aVar.t();
        }

        private static long e(com.google.firebase.perf.config.a aVar, String str) {
            return str == "Trace" ? aVar.F() : aVar.r();
        }

        private static long f(com.google.firebase.perf.config.a aVar, String str) {
            return str == "Trace" ? aVar.t() : aVar.t();
        }

        private void g(com.google.firebase.perf.config.a aVar, String str, boolean z10) {
            long f11 = f(aVar, str);
            long e11 = e(aVar, str);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            com.google.firebase.perf.util.g gVar = new com.google.firebase.perf.util.g(e11, f11, timeUnit);
            this.f77349g = gVar;
            this.f77351i = e11;
            if (z10) {
                f77341k.b("Foreground %s logging rate:%f, burst capacity:%d", str, gVar, Long.valueOf(e11));
            }
            long d11 = d(aVar, str);
            long c11 = c(aVar, str);
            com.google.firebase.perf.util.g gVar2 = new com.google.firebase.perf.util.g(c11, d11, timeUnit);
            this.f77350h = gVar2;
            this.f77352j = c11;
            if (z10) {
                f77341k.b("Background %s logging rate:%f, capacity:%d", str, gVar2, Long.valueOf(c11));
            }
        }

        synchronized void a(boolean z10) {
            try {
                this.f77346d = z10 ? this.f77349g : this.f77350h;
                this.f77347e = z10 ? this.f77351i : this.f77352j;
            } catch (Throwable th2) {
                throw th2;
            }
        }

        synchronized boolean b(com.google.firebase.perf.v1.g gVar) {
            try {
                Timer a11 = this.f77343a.a();
                double durationMicros = (this.f77345c.getDurationMicros(a11) * this.f77346d.a()) / f77342l;
                if (durationMicros > 0.0d) {
                    this.f77348f = Math.min(this.f77348f + durationMicros, this.f77347e);
                    this.f77345c = a11;
                }
                double d11 = this.f77348f;
                if (d11 >= 1.0d) {
                    this.f77348f = d11 - 1.0d;
                    return true;
                }
                if (this.f77344b) {
                    f77341k.j("Exceeded log rate limit, dropping the log.");
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public d(Context context, com.google.firebase.perf.util.g gVar, long j11) {
        this(gVar, j11, new com.google.firebase.perf.util.a(), b(), b(), com.google.firebase.perf.config.a.g());
        this.f77340f = com.google.firebase.perf.util.k.b(context);
    }

    d(com.google.firebase.perf.util.g gVar, long j11, com.google.firebase.perf.util.a aVar, double d11, double d12, com.google.firebase.perf.config.a aVar2) {
        this.f77338d = null;
        this.f77339e = null;
        boolean z10 = false;
        this.f77340f = false;
        com.google.firebase.perf.util.k.a(0.0d <= d11 && d11 < 1.0d, "Sampling bucket ID should be in range [0.0, 1.0).");
        if (0.0d <= d12 && d12 < 1.0d) {
            z10 = true;
        }
        com.google.firebase.perf.util.k.a(z10, "Fragment sampling bucket ID should be in range [0.0, 1.0).");
        this.f77336b = d11;
        this.f77337c = d12;
        this.f77335a = aVar2;
        this.f77338d = new a(gVar, j11, aVar, aVar2, "Trace", this.f77340f);
        this.f77339e = new a(gVar, j11, aVar, aVar2, "Network", this.f77340f);
    }

    static double b() {
        return new Random().nextDouble();
    }

    private boolean c(List list) {
        return list.size() > 0 && ((com.google.firebase.perf.v1.h) list.get(0)).m() > 0 && ((com.google.firebase.perf.v1.h) list.get(0)).l(0) == SessionVerbosity.GAUGES_AND_SYSTEM_EVENTS;
    }

    private boolean d() {
        return this.f77337c < this.f77335a.f();
    }

    private boolean e() {
        return this.f77336b < this.f77335a.s();
    }

    private boolean f() {
        return this.f77336b < this.f77335a.G();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z10) {
        this.f77338d.a(z10);
        this.f77339e.a(z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(com.google.firebase.perf.v1.g gVar) {
        if (!j(gVar)) {
            return false;
        }
        if (gVar.b()) {
            return !this.f77339e.b(gVar);
        }
        if (gVar.e()) {
            return !this.f77338d.b(gVar);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(com.google.firebase.perf.v1.g gVar) {
        if (gVar.e() && !f() && !c(gVar.f().F())) {
            return false;
        }
        if (!i(gVar) || d() || c(gVar.f().F())) {
            return !gVar.b() || e() || c(gVar.c().B());
        }
        return false;
    }

    protected boolean i(com.google.firebase.perf.v1.g gVar) {
        return gVar.e() && gVar.f().E().startsWith("_st_") && gVar.f().u("Hosting_activity");
    }

    boolean j(com.google.firebase.perf.v1.g gVar) {
        return (!gVar.e() || (!(gVar.f().E().equals(Constants$TraceNames.FOREGROUND_TRACE_NAME.toString()) || gVar.f().E().equals(Constants$TraceNames.BACKGROUND_TRACE_NAME.toString())) || gVar.f().x() <= 0)) && !gVar.a();
    }
}
